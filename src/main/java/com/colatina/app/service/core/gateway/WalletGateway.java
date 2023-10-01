package com.colatina.app.service.core.gateway;

import com.colatina.app.service.core.domain.WalletDomain;

import java.math.BigDecimal;

public interface WalletGateway {

    String getAccountBalance(Integer accountId);
}
