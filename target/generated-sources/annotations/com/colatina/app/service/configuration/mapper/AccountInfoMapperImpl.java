package com.colatina.app.service.configuration.mapper;

import com.colatina.app.service.core.domain.AccountInfoDomain;
import com.colatina.app.service.dataprovider.entity.AccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-19T15:34:01-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class AccountInfoMapperImpl implements AccountInfoMapper {

    @Override
    public AccountEntity toEntity(AccountInfoDomain dto) {
        if ( dto == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId( dto.getId() );
        accountEntity.setName( dto.getName() );
        accountEntity.setLastName( dto.getLastName() );

        return accountEntity;
    }

    @Override
    public AccountInfoDomain toDto(AccountEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AccountInfoDomain accountInfoDomain = new AccountInfoDomain();

        accountInfoDomain.setId( entity.getId() );
        accountInfoDomain.setName( entity.getName() );
        accountInfoDomain.setLastName( entity.getLastName() );

        return accountInfoDomain;
    }

    @Override
    public List<AccountEntity> toEntity(List<AccountInfoDomain> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AccountEntity> list = new ArrayList<AccountEntity>( dtoList.size() );
        for ( AccountInfoDomain accountInfoDomain : dtoList ) {
            list.add( toEntity( accountInfoDomain ) );
        }

        return list;
    }

    @Override
    public List<AccountInfoDomain> toDto(List<AccountEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AccountInfoDomain> list = new ArrayList<AccountInfoDomain>( entityList.size() );
        for ( AccountEntity accountEntity : entityList ) {
            list.add( toDto( accountEntity ) );
        }

        return list;
    }
}
