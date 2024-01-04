package com.colatina.app.service.configuration.mapper;

import com.colatina.app.service.core.domain.TransactionDomain;
import com.colatina.app.service.dataprovider.entity.TransactionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-26T15:15:58-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    public TransactionEntity toEntity(TransactionDomain dto) {
        if ( dto == null ) {
            return null;
        }

        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setId( dto.getId() );
        transactionEntity.setAccountOrigin( accountInfoMapper.toEntity( dto.getAccountOrigin() ) );
        transactionEntity.setAccountDestination( accountInfoMapper.toEntity( dto.getAccountDestination() ) );
        transactionEntity.setValue( dto.getValue() );
        transactionEntity.setCreatedAt( dto.getCreatedAt() );
        transactionEntity.setStatus( dto.getStatus() );
        transactionEntity.setType( dto.getType() );

        return transactionEntity;
    }

    @Override
    public TransactionDomain toDto(TransactionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TransactionDomain transactionDomain = new TransactionDomain();

        transactionDomain.setId( entity.getId() );
        transactionDomain.setAccountOrigin( accountInfoMapper.toDto( entity.getAccountOrigin() ) );
        transactionDomain.setAccountDestination( accountInfoMapper.toDto( entity.getAccountDestination() ) );
        transactionDomain.setValue( entity.getValue() );
        transactionDomain.setCreatedAt( entity.getCreatedAt() );
        transactionDomain.setStatus( entity.getStatus() );
        transactionDomain.setType( entity.getType() );

        return transactionDomain;
    }

    @Override
    public List<TransactionEntity> toEntity(List<TransactionDomain> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TransactionEntity> list = new ArrayList<TransactionEntity>( dtoList.size() );
        for ( TransactionDomain transactionDomain : dtoList ) {
            list.add( toEntity( transactionDomain ) );
        }

        return list;
    }

    @Override
    public List<TransactionDomain> toDto(List<TransactionEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TransactionDomain> list = new ArrayList<TransactionDomain>( entityList.size() );
        for ( TransactionEntity transactionEntity : entityList ) {
            list.add( toDto( transactionEntity ) );
        }

        return list;
    }
}
