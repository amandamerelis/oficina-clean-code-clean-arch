package com.colatina.app.service.core.gateway;

import com.colatina.app.service.core.domain.TransactionDomain;
import com.colatina.app.service.core.domain.dto.CreateTransactionDTO;
import com.colatina.app.service.core.domain.dto.TransactionPageDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionGateway {

    TransactionPageDTO getAccountStatement(Integer accountId, LocalDateTime startDate, LocalDateTime endDate, Integer page, Integer pageSize);

    TransactionPageDTO getAccountStatementByRecipient(Integer accountId, Integer recipientId, Integer page, Integer pageSize);

    TransactionDomain makeTransaction(CreateTransactionDTO transactionDTO);
}
