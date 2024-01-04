package com.colatina.app.service.dataprovider.repository;

import com.colatina.app.service.dataprovider.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    List<AccountEntity> findAllByOrderByNameAscLastNameAsc();
}
