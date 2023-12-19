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
    private final NegativeCpfGateway negativeCpfGateway;

    public void execute(AccountDomain account) {

        if(account.isUnderage()){
            throw new BusinessException("The user must be of legal age to create an account.");
        }

        if(negativeCpfGateway.isNegativeCpf(account.getDocument())){
            throw new BusinessException("The CPF must not be negative to create an account.");
        }

        WalletDomain wallet = new WalletDomain();
        wallet.setBalance(BigDecimal.ZERO);
        account.setWalletDomain(wallet);
        accountGateway.create(account);
    }
}
