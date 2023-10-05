package com.colatina.app.service.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionDTO {
    @NotNull
    private Integer originId;
    @NotNull
    private Integer destinationId;
    @NotNull @Positive
    private BigDecimal amount;
    @NotBlank
    private String type;
}
