package com.colatina.app.service.dataprovider.entity;

import com.colatina.app.service.core.domain.enumeration.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class TransactionEntity {

    public TransactionEntity(AccountEntity accountOrigin, AccountEntity accountDestination, BigDecimal value, String type, TransactionStatus status) {
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
        this.value = value;
        this.type = type;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transaction")
    @SequenceGenerator(name = "seq_transaction", allocationSize = 1, sequenceName = "seq_transaction")
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_origin_id")
    private AccountEntity accountOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_destination_id")
    private AccountEntity accountDestination;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "type")
    private String type;

}
