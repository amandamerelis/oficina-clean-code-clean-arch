package com.colatina.app.service.core.usecase;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.enumeration.AccountStatus;
import com.colatina.app.service.core.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeStatusUseCase {

    private final AccountGateway accountGateway;
    public AccountDomain execute(AccountStatus status, Integer account_id){
        return accountGateway.changeAccountStatus(status, account_id);
    }

}
