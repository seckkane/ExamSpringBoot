package com.groupeisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupeisi.models.Declaration;


@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {

}
