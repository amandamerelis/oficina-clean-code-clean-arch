package com.colatina.app.service.entrypoint.api;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.enumeration.AccountStatus;
import com.colatina.app.service.core.usecase.ChangeStatusUseCase;
import com.colatina.app.service.core.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final ChangeStatusUseCase changeStatusUseCase;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AccountDomain data) {
        createAccountUseCase.execute(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/account-status/{account_id}")
    public ResponseEntity<AccountDomain> changeAccountStatus(@RequestBody AccountStatus status, @PathVariable Integer account_id) {
        changeStatusUseCase.execute(status, account_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
