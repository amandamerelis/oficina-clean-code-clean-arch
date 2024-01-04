package com.colatina.app.service.entrypoint.api;

import com.colatina.app.service.core.domain.TransactionDomain;
import com.colatina.app.service.core.domain.dto.CreateTransactionDTO;
import com.colatina.app.service.core.domain.dto.TransactionPageDTO;
import com.colatina.app.service.core.usecase.GetAccountStatementUseCase;
import com.colatina.app.service.core.usecase.MakeTransactionUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final GetAccountStatementUseCase getAccountStatementUseCase;
    private final MakeTransactionUserCase makeTransactionUserCase;

    @GetMapping("/account-statement/{account_id}")
    public TransactionPageDTO getAccountStatement(@PathVariable("account_id") Integer accountId,
                                                                  @RequestHeader("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
                                                                  @RequestHeader("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate,
                                                                  @RequestParam(name = "page", defaultValue = "0") @PositiveOrZero Integer page,
                                                                  @RequestParam(name = "pageSize", defaultValue = "5") @Positive Integer pageSize) {
        return getAccountStatementUseCase.getAccountStatement(accountId, startDate, endDate, page, pageSize);
    }

    @GetMapping("/account-statement/{account_id}/{recipient_id}")
    public ResponseEntity<TransactionPageDTO> getAccountStatementByRecipient(@PathVariable("account_id") Integer accountId,
                                                                             @PathVariable("recipient_id") Integer recipientId,
                                                                             @RequestParam(name = "page", defaultValue = "0") @PositiveOrZero Integer page,
                                                                             @RequestParam(name = "pageSize", defaultValue = "5") @Positive Integer pageSize) {
        final TransactionPageDTO accountStatement = getAccountStatementUseCase.getAccountStatementByRecipient(accountId, recipientId, page, pageSize);
        return new ResponseEntity<>(accountStatement, accountStatement.getTransactions().isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionDomain> create(@RequestBody @Valid CreateTransactionDTO data) throws IllegalArgumentException{
        return new ResponseEntity<>(makeTransactionUserCase.execute(data), HttpStatus.CREATED);
    }

}
