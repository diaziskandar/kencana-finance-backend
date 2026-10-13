package com.kencana.kencanafinance.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pos_anggaran")
public class PosAnggaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "jenis_anggaran")
    private String jenisAnggaran;
    
    @Column(name = "nama_pos")
    private String namaPos;
    
    @Column(name = "pos_nominal")
    private BigDecimal posNominal;
    
    @Column(name = "realisasi_nominal")
    private BigDecimal realisasiNominal;
    
    @Column(name = "periode_bulan")
    private String periodeBulan;

    public PosAnggaran() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJenisAnggaran() { return jenisAnggaran; }
    public void setJenisAnggaran(String jenisAnggaran) { this.jenisAnggaran = jenisAnggaran; }

    public String getNamaPos() { return namaPos; }
    public void setNamaPos(String namaPos) { this.namaPos = namaPos; }

    public BigDecimal getPosNominal() { return posNominal; }
    public void setPosNominal(BigDecimal posNominal) { this.posNominal = posNominal; }

    public BigDecimal getRealisasiNominal() { return realisasiNominal; }
    public void setRealisasiNominal(BigDecimal realisasiNominal) { this.realisasiNominal = realisasiNominal; }

    public String getPeriodeBulan() { return periodeBulan; }
    public void setPeriodeBulan(String periodeBulan) { this.periodeBulan = periodeBulan; }
}