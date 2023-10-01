package com.colatina.app.service.core.usecase;

import com.colatina.app.service.core.gateway.WalletGateway;
import com.colatina.app.service.dataprovider.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class GetAccountBalanceUseCase {

    private final WalletGateway walletGateway;
    public String getAccountBalance(Integer accountId){
        return walletGateway.getAccountBalance(accountId);
    };

}
