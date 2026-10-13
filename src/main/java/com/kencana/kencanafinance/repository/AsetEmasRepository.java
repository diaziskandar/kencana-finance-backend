package com.kencana.kencanafinance.repository;

import com.kencana.kencanafinance.model.AsetEmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsetEmasRepository extends JpaRepository<AsetEmas, Long> {
}