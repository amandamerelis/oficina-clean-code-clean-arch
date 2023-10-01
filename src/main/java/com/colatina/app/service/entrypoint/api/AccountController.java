package com.colatina.app.service.entrypoint.api;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.usecase.ChangeStatusUseCase;
import com.colatina.app.service.core.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeAccountStatus(@RequestBody @Valid AccountDomain data, @PathVariable Long id) {

        //Implementar a alteração
        //Considerar uso do PatchMapping

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
