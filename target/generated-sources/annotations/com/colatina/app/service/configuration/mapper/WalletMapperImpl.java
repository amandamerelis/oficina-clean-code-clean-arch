package com.colatina.app.service.configuration.mapper;

import com.colatina.app.service.core.domain.WalletDomain;
import com.colatina.app.service.dataprovider.entity.WalletEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-04T20:39:29-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public WalletEntity toEntity(WalletDomain dto) {
        if ( dto == null ) {
            return null;
        }

        WalletEntity walletEntity = new WalletEntity();

        walletEntity.setId( dto.getId() );
        walletEntity.setBalance( dto.getBalance() );

        return walletEntity;
    }

    @Override
    public WalletDomain toDto(WalletEntity entity) {
        if ( entity == null ) {
            return null;
        }

        WalletDomain walletDomain = new WalletDomain();

        walletDomain.setId( entity.getId() );
        walletDomain.setBalance( entity.getBalance() );

        return walletDomain;
    }

    @Override
    public List<WalletEntity> toEntity(List<WalletDomain> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<WalletEntity> list = new ArrayList<WalletEntity>( dtoList.size() );
        for ( WalletDomain walletDomain : dtoList ) {
            list.add( toEntity( walletDomain ) );
        }

        return list;
    }

    @Override
    public List<WalletDomain> toDto(List<WalletEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<WalletDomain> list = new ArrayList<WalletDomain>( entityList.size() );
        for ( WalletEntity walletEntity : entityList ) {
            list.add( toDto( walletEntity ) );
        }

        return list;
    }
}
