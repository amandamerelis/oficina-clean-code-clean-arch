package com.colatina.app.service.dataprovider.repository;

import com.colatina.app.service.dataprovider.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    //List<TransactionEntity> findAllByAccountOriginIdAndCreatedAtBetween(Integer accountId, LocalDateTime startDate, LocalDateTime endDate);
    Page<TransactionEntity> findAllByAccountOriginIdAndCreatedAtBetween(Integer accountId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<TransactionEntity> findAllByAccountOriginIdAndAccountDestinationId(Integer accountOriginId, Integer accountDestinationId, Pageable page);
}
