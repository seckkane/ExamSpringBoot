package com.groupeisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupeisi.models.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
