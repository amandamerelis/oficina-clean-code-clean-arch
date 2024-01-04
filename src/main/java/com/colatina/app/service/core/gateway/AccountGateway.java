package com.colatina.app.service.core.gateway;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.core.domain.AccountInfoDomain;
import com.colatina.app.service.core.domain.enumeration.AccountStatus;

import java.util.List;

public interface AccountGateway {

    AccountDomain create(AccountDomain account);
    AccountDomain changeAccountStatus(AccountStatus status, Integer id);
    List<AccountInfoDomain> listAccountsBasicInfo();

}
