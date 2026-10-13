package com.kencana.kencanafinance.repository;

import com.kencana.kencanafinance.model.PengeluaranHarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PengeluaranHarianRepository extends JpaRepository<PengeluaranHarian, Long> {
}