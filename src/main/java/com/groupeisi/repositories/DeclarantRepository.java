package com.groupeisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupeisi.models.Declarant;

@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long> {

}
