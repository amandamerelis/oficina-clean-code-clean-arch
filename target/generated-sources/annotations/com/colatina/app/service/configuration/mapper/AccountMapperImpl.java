package com.colatina.app.service.configuration.mapper;

import com.colatina.app.service.core.domain.AccountDomain;
import com.colatina.app.service.dataprovider.entity.AccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-26T15:15:57-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountEntity toEntity(AccountDomain dto) {
        if ( dto == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId( dto.getId() );
        accountEntity.setName( dto.getName() );
        accountEntity.setLastName( dto.getLastName() );
        accountEntity.setDocument( dto.getDocument() );
        accountEntity.setStatus( dto.getStatus() );
        accountEntity.setBirthDate( dto.getBirthDate() );

        return accountEntity;
    }

    @Override
    public AccountDomain toDto(AccountEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AccountDomain accountDomain = new AccountDomain();

        accountDomain.setId( entity.getId() );
        accountDomain.setName( entity.getName() );
        accountDomain.setLastName( entity.getLastName() );
        accountDomain.setDocument( entity.getDocument() );
        accountDomain.setStatus( entity.getStatus() );
        accountDomain.setBirthDate( entity.getBirthDate() );

        return accountDomain;
    }

    @Override
    public List<AccountEntity> toEntity(List<AccountDomain> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AccountEntity> list = new ArrayList<AccountEntity>( dtoList.size() );
        for ( AccountDomain accountDomain : dtoList ) {
            list.add( toEntity( accountDomain ) );
        }

        return list;
    }

    @Override
    public List<AccountDomain> toDto(List<AccountEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AccountDomain> list = new ArrayList<AccountDomain>( entityList.size() );
        for ( AccountEntity accountEntity : entityList ) {
            list.add( toDto( accountEntity ) );
        }

        return list;
    }
}
