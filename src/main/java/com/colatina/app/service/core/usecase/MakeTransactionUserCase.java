package com.colatina.app.service.core.usecase;

import com.colatina.app.service.core.domain.TransactionDomain;
import com.colatina.app.service.core.domain.dto.CreateTransactionDTO;
import com.colatina.app.service.core.gateway.TransactionGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class MakeTransactionUserCase {

    private final TransactionGateway transactionGateway;

    public TransactionDomain execute(CreateTransactionDTO transactionDTO) {
        return transactionGateway.makeTransaction(transactionDTO);
    }
}
