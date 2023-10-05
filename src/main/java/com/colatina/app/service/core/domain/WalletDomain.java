package com.colatina.app.service.core.domain;

import com.colatina.app.service.dataprovider.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletDomain {

    private Integer id;

    @NotNull
    private BigDecimal balance;

}
