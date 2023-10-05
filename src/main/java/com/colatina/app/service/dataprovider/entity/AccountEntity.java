package com.colatina.app.service.dataprovider.entity;

import com.colatina.app.service.core.domain.enumeration.AccountStatus;
import com.colatina.app.service.core.exception.BusinessException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    @SequenceGenerator(name = "seq_account", allocationSize = 1, sequenceName = "seq_account")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "document")
    private String document;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private WalletEntity wallet;

    public void withdraw(BigDecimal amount){
        if (!status.isActive()){
            throw new BusinessException("The account must be active to change its balance.");
        }
        wallet.subtractFromBalance(amount);
    }

    public void credit(BigDecimal amount){
        if (!status.isActive()){
            throw new BusinessException("The account must be active to change its balance.");
        }
        wallet.addToBalance(amount);
    }

}
