package com.colatina.app.service.core.domain.dto;

import com.colatina.app.service.core.domain.TransactionDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPageDTO {
    private List<TransactionDomain> transactions;
    private Integer totalPages;
    private Long totalElements;
}
