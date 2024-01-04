package com.colatina.app.service.core.usecase;

import com.colatina.app.service.core.domain.AccountInfoDomain;
import com.colatina.app.service.core.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAccountsBasicInfoUseCase {

    private final AccountGateway accountGateway;

    public List<AccountInfoDomain> execute() {
        return accountGateway.listAccountsBasicInfo();
    }
}
