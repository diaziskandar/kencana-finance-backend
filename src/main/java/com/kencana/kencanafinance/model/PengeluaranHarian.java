package com.kencana.kencanafinance.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pengeluaran_harian")
public class PengeluaranHarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tanggal;
    private String hari;
    
    @Column(name = "minggu_ke")
    private String mingguKe;
    
    private String kategori;
    private String klasifikasi;
    private String keterangan;
    private BigDecimal nominal;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructor Kosong
    public PengeluaranHarian() {}

    // Getter dan Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getHari() { return hari; }
    public void setHari(String hari) { this.hari = hari; }

    public String getMingguKe() { return mingguKe; }
    public void setMingguKe(String mingguKe) { this.mingguKe = mingguKe; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getKlasifikasi() { return klasifikasi; }
    public void setKlasifikasi(String klasifikasi) { this.klasifikasi = klasifikasi; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }

    public BigDecimal getNominal() { return nominal; }
    public void setNominal(BigDecimal nominal) { this.nominal = nominal; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}