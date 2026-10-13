package com.kencana.kencanafinance.repository;

import com.kencana.kencanafinance.model.Pemasukan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PemasukanRepository extends JpaRepository<Pemasukan, Long> {
}