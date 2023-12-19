package com.colatina.app.service.dataprovider.adapter;

import com.colatina.app.service.configuration.mapper.TransactionMapper;
import com.colatina.app.service.core.domain.TransactionDomain;
import com.colatina.app.service.core.domain.dto.CreateTransactionDTO;
import com.colatina.app.service.core.domain.dto.TransactionPageDTO;
import com.colatina.app.service.core.domain.enumeration.TransactionStatus;
import com.colatina.app.service.core.gateway.TransactionGateway;
import com.colatina.app.service.dataprovider.entity.AccountEntity;
import com.colatina.app.service.dataprovider.entity.TransactionEntity;
import com.colatina.app.service.dataprovider.repository.AccountRepository;
import com.colatina.app.service.dataprovider.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionAdapter implements TransactionGateway {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;

   /* @Override
    public List<TransactionDomain> getAccountStatement(final Integer accountId, final LocalDateTime startDate, final LocalDateTime endDate) {
        return transactionMapper.toDto(transactionRepository.findAllByAccountOriginIdAndCreatedAtBetween(accountId, startDate, endDate));
    }*/

    @Override
    public TransactionPageDTO getAccountStatement(final Integer accountId, final LocalDateTime startDate, final LocalDateTime endDate, Integer page, Integer pageSize) {
        Page<TransactionEntity> transactionPage = transactionRepository.findAllByAccountOriginIdAndCreatedAtBetween(accountId, startDate, endDate, PageRequest.of(page, pageSize));
        List<TransactionDomain> transactions = transactionPage.get().map(transactionMapper::toDto).collect(Collectors.toList());
        return new TransactionPageDTO(transactions, transactionPage.getTotalPages(), transactionPage.getTotalElements());
    }

    @Override
    public TransactionPageDTO getAccountStatementByRecipient(Integer accountOriginId, Integer accountDestinationId, Integer page, Integer pageSize) {
        Page<TransactionEntity> transactionPage = transactionRepository.findAllByAccountOriginIdAndAccountDestinationId(accountOriginId, accountDestinationId, PageRequest.of(page, pageSize));
        List<TransactionDomain> transactions = transactionPage.get().map(transactionMapper::toDto).collect(Collectors.toList());
        return new TransactionPageDTO(transactions, transactionPage.getTotalPages(), transactionPage.getTotalElements());
    }

    @Override
    @Transactional
    public TransactionDomain makeTransaction(CreateTransactionDTO transactionDTO) throws IllegalArgumentException {
        AccountEntity originAccount = accountRepository.findById(transactionDTO.getOriginId())
                .orElseThrow(() -> new IllegalArgumentException("Origin account not found."));

        originAccount.withdraw(transactionDTO.getAmount());

        AccountEntity destinationAccount = accountRepository.findById(transactionDTO.getDestinationId())
                .orElseThrow(() -> new IllegalArgumentException("Destination account not found."));

        destinationAccount.credit(transactionDTO.getAmount());

        TransactionEntity transactionEntity = new TransactionEntity(
                originAccount, destinationAccount, transactionDTO.getAmount(),
                transactionDTO.getType(), TransactionStatus.PROCESSED);

        return transactionMapper.toDto(transactionRepository.save(transactionEntity));

    }

}
