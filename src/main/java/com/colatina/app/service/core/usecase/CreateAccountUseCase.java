package com.colatina.app.service.core.usecase;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.WalletDomain;
import com.colatina.app.service.core.exception.BusinessException;
import com.colatina.app.service.core.gateway.AccountGateway;
import com.colatina.app.service.core.gateway.NegativeCpfGateway;
import com.colatina.app.service.core.gateway.WalletGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateAccountUseCase {

    private final AccountGateway accountGateway;

    public void execute(AccountDomain account) {
        if(account.isUnderage()){
            throw new BusinessException("É necessário ter mais de 18 anos para criar uma conta.");
        }

        WalletDomain walletDomain = new WalletDomain();
        walletDomain.setBalance(BigDecimal.ZERO);
        account.setWallet(walletDomain);

        accountGateway.create(account);
    }
}
