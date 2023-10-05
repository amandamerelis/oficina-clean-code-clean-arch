package com.colatina.app.service.core.usecase;


import com.colatina.app.service.core.domain.TransactionDomain;
import com.colatina.app.service.core.domain.dto.TransactionPageDTO;
import com.colatina.app.service.core.gateway.TransactionGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAccountStatementUseCase {

    private final TransactionGateway transactionGateway;

    public TransactionPageDTO getAccountStatement(Integer accountId, LocalDateTime startDate, LocalDateTime endDate, Integer page, Integer pageSize) {
        return transactionGateway.getAccountStatement(accountId, startDate, endDate, page, pageSize);
    }

    public TransactionPageDTO getAccountStatementByRecipient(Integer accountId, Integer recipientId, Integer page, Integer pageSize){
        return transactionGateway.getAccountStatementByRecipient(accountId, recipientId, page, pageSize);
    }

}
