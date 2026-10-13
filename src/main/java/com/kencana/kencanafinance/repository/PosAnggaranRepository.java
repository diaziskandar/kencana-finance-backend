package com.kencana.kencanafinance.repository;

import com.kencana.kencanafinance.model.PosAnggaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosAnggaranRepository extends JpaRepository<PosAnggaran, Long> {
}