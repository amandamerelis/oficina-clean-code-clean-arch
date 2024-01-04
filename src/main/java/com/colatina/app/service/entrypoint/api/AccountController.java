package com.colatina.app.service.entrypoint.api;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.AccountInfoDomain;
import com.colatina.app.service.core.domain.enumeration.AccountStatus;
import com.colatina.app.service.core.usecase.ChangeStatusUseCase;
import com.colatina.app.service.core.usecase.CreateAccountUseCase;
import com.colatina.app.service.core.usecase.ListAccountsBasicInfoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final ChangeStatusUseCase changeStatusUseCase;
    private final ListAccountsBasicInfoUseCase listAccountsBasicInfoUseCase;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AccountDomain data) {
        createAccountUseCase.execute(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(value = "/account-status/{accountId}")
    public void changeAccountStatus(@RequestBody AccountStatus status, @PathVariable Integer accountId) {
        System.out.println(status);
        changeStatusUseCase.execute(status, accountId);
    }

    @GetMapping
    public ResponseEntity<List<AccountInfoDomain>> list() {
        final List<AccountInfoDomain> accounts = listAccountsBasicInfoUseCase.execute();
        return new ResponseEntity<>(accounts, accounts.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

}
