package com.kencana.kencanafinance.controller;

import com.kencana.kencanafinance.model.*;
import com.kencana.kencanafinance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kencana")
@CrossOrigin(origins = "http://localhost:3000") // Mengizinkan akses dari Frontend Next.js
public class KencanaController {

    private final PengeluaranHarianRepository pengeluaranRepo;
    private final PosAnggaranRepository posAnggaranRepo;
    private final AsetEmasRepository asetEmasRepo;
    private final PemasukanRepository pemasukanRepo; // Ditambahkan untuk tabel pemasukan

    @Autowired
    public KencanaController(PengeluaranHarianRepository pengeluaranRepo, 
                             PosAnggaranRepository posAnggaranRepo, 
                             AsetEmasRepository asetEmasRepo,
                             PemasukanRepository pemasukanRepo) {
        this.pengeluaranRepo = pengeluaranRepo;
        this.posAnggaranRepo = posAnggaranRepo;
        this.asetEmasRepo = asetEmasRepo;
        this.pemasukanRepo = pemasukanRepo;
    }

    // 1. Endpoint Pengeluaran Harian (GET & POST)
    @GetMapping("/pengeluaran")
    public List<PengeluaranHarian> getAllPengeluaran() {
        return pengeluaranRepo.findAll();
    }

    @PostMapping("/pengeluaran")
    public PengeluaranHarian addPengeluaran(@RequestBody PengeluaranHarian pengeluaran) {
        return pengeluaranRepo.save(pengeluaran);
    }

    // 2. Endpoint Pos Anggaran & Realisasi
    @GetMapping("/anggaran")
    public List<PosAnggaran> getAllAnggaran() {
        return posAnggaranRepo.findAll();
    }

    // 3. Endpoint Portofolio Aset Emas
    @GetMapping("/aset-emas")
    public List<AsetEmas> getAllAsetEmas() {
        return asetEmasRepo.findAll();
    }

    // 4. Endpoint Pemasukan / Saldo Awal & Kas Ibu (GET & POST)
    @GetMapping("/pemasukan")
    public List<Pemasukan> getAllPemasukan() {
        return pemasukanRepo.findAll();
    }

    @PostMapping("/pemasukan")
    public Pemasukan addPemasukan(@RequestBody Pemasukan pemasukan) {
        return pemasukanRepo.save(pemasukan);
    }
}