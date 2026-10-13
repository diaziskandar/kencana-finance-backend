package com.kencana.kencanafinance.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "aset_emas")
public class AsetEmas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "kategori_aset")
    private String kategoriAset;
    
    @Column(name = "nama_item")
    private String namaItem;
    
    @Column(name = "berat_atau_unit")
    private String beratAtauUnit;
    
    @Column(name = "nilai_estimasi")
    private BigDecimal nilaiEstimasi;

    public AsetEmas() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKategoriAset() { return kategoriAset; }
    public void setKategoriAset(String kategoriAset) { this.kategoriAset = kategoriAset; }

    public String getNamaItem() { return namaItem; }
    public void setNamaItem(String namaItem) { this.namaItem = namaItem; }

    public String getBeratAtauUnit() { return beratAtauUnit; }
    public void setBeratAtauUnit(String beratAtauUnit) { this.beratAtauUnit = beratAtauUnit; }

    public BigDecimal getNilaiEstimasi() { return nilaiEstimasi; }
    public void setNilaiEstimasi(BigDecimal nilaiEstimasi) { this.nilaiEstimasi = nilaiEstimasi; }
}