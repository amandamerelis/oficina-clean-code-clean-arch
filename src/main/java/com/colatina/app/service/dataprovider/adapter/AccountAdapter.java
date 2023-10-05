package com.colatina.app.service.dataprovider.adapter;

import com.colatina.app.service.configuration.mapper.AccountMapper;
import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.enumeration.AccountStatus;
import com.colatina.app.service.core.gateway.AccountGateway;
import com.colatina.app.service.dataprovider.entity.AccountEntity;
import com.colatina.app.service.dataprovider.entity.WalletEntity;
import com.colatina.app.service.dataprovider.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountGateway {

    private final AccountMapper mapper;
    private final AccountRepository repository;

    @Override
    @Transactional
    public AccountDomain create(AccountDomain account) {

        AccountEntity entity = mapper.toEntity(account);
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setBalance(BigDecimal.ZERO);
        walletEntity.setAccount(entity);
        entity.setWallet(walletEntity);
        repository.save(entity);

        return mapper.toDto(entity);
    }

    @Override
    public AccountDomain changeAccountStatus(AccountStatus status, Integer id) {
        AccountEntity accountEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found."));
        accountEntity.setStatus(status);
        repository.save(accountEntity);

        return mapper.toDto(accountEntity);
    }


}
