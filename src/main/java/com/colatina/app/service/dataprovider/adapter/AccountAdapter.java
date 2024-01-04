package com.colatina.app.service.dataprovider.adapter;

import com.colatina.app.service.configuration.mapper.AccountInfoMapper;
import com.colatina.app.service.configuration.mapper.AccountMapper;
import com.colatina.app.service.configuration.mapper.WalletMapper;
import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.AccountInfoDomain;
import com.colatina.app.service.core.domain.enumeration.AccountStatus;
import com.colatina.app.service.core.gateway.AccountGateway;
import com.colatina.app.service.dataprovider.entity.AccountEntity;
import com.colatina.app.service.dataprovider.entity.WalletEntity;
import com.colatina.app.service.dataprovider.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountGateway {

    private final AccountMapper accountMapper;
    private final AccountInfoMapper accountInfoMapper;
    private final WalletMapper walletMapper;
    private final AccountRepository repository;

    @Override
    @Transactional
    public AccountDomain create(AccountDomain account) {

        AccountEntity entity = accountMapper.toEntity(account);
        WalletEntity walletEntity = walletMapper.toEntity(account.getWalletDomain());
        entity.setWallet(walletEntity);
        repository.save(entity);

        return this.accountMapper.toDto(entity);
    }

    @Override
    public AccountDomain changeAccountStatus(AccountStatus status, Integer id) {
        AccountEntity accountEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found."));
        accountEntity.setStatus(status);
        repository.save(accountEntity);

        return accountMapper.toDto(accountEntity);
    }

    @Override
    public List<AccountInfoDomain> listAccountsBasicInfo() {
        return repository.findAllByOrderByNameAscLastNameAsc().stream().map(accountInfoMapper::toDto).collect(Collectors.toList());
    }


}
