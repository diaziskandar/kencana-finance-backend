package com.kencana.kencanafinance.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pemasukan")
public class Pemasukan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "sumber_dana")
    private String sumberDana;
    
    @Column(name = "kategori_kas")
    private String kategoriKas;
    
    private BigDecimal nominal;
    
    @Column(name = "tanggal_penerimaan")
    private LocalDate tanggalPenerimaan;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSumberDana() { return sumberDana; }
    public void setSumberDana(String sumberDana) { this.sumberDana = sumberDana; }
    public String getKategoriKas() { return kategoriKas; }
    public void setKategoriKas(String kategoriKas) { this.kategoriKas = kategoriKas; }
    public BigDecimal getNominal() { return nominal; }
    public void setNominal(BigDecimal nominal) { this.nominal = nominal; }
    public LocalDate getTanggalPenerimaan() { return tanggalPenerimaan; }
    public void setTanggalPenerimaan(LocalDate tanggalPenerimaan) { this.tanggalPenerimaan = tanggalPenerimaan; }
}