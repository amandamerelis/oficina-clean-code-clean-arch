package com.colatina.app.service.dataprovider.entity;

import com.colatina.app.service.core.exception.BusinessException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "wallet")
@NoArgsConstructor
public class WalletEntity {

    public WalletEntity(BigDecimal balance, AccountEntity account) {
        this.balance = balance;
        this.account = account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wallet")
    @SequenceGenerator(name = "seq_wallet", allocationSize = 1, sequenceName = "seq_wallet")
    @Column(name = "id")
    private Integer id;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToOne(mappedBy = "wallet", cascade = CascadeType.ALL)
    private AccountEntity account;

    @Version
    private Long version;

    public void subtractFromBalance(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new BusinessException("There is not enough balance to proceed with this transaction.");
        }
        balance = balance.subtract(amount);
    }

    public void addToBalance(BigDecimal amount){
        balance = balance.add(amount);
    }

}
