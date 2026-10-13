package com.kencana.kencanafinance.controller;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.kencana.kencanafinance.model.Pemasukan;
import com.kencana.kencanafinance.model.PengeluaranHarian;
import com.kencana.kencanafinance.repository.PemasukanRepository;
import com.kencana.kencanafinance.repository.PengeluaranHarianRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.Color;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/kencana")
@CrossOrigin(origins = "http://localhost:3000")
public class PdfController {

    private final PengeluaranHarianRepository pengeluaranRepo;
    private final PemasukanRepository pemasukanRepo;

    @Autowired
    public PdfController(PengeluaranHarianRepository pengeluaranRepo, PemasukanRepository pemasukanRepo) {
        this.pengeluaranRepo = pengeluaranRepo;
        this.pemasukanRepo = pemasukanRepo;
    }

    @GetMapping("/export-pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Laporan_Keuangan_Kencana.pdf");

        // Ambil data dari database
        List<PengeluaranHarian> pengeluaranList = pengeluaranRepo.findAll();
        List<Pemasukan> pemasukanList = pemasukanRepo.findAll();

        // Hitung total pemasukan & pengeluaran
        BigDecimal totalPemasukan = pemasukanList.stream()
            .map(Pemasukan::getNominal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPengeluaran = pengeluaranList.stream()
            .map(PengeluaranHarian::getNominal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal sisaSaldo = totalPemasukan.subtract(totalPengeluaran);

        // Buat dokumen PDF (Ukuran A4 dengan margin 36pt)
        Document doc = new Document(PageSize.A4, 36, 36, 36, 36);
        PdfWriter.getInstance(doc, response.getOutputStream());

        doc.open();

        // Judul Laporan
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, new Color(110, 35, 140));
        Paragraph title = new Paragraph("LAPORAN KEUANGAN KELUARGA KENCANA", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);
        doc.add(new Paragraph(" ")); // Spasi

        // Ringkasan Finansial
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.DARK_GRAY);
        doc.add(new Paragraph("Total Pemasukan / Saldo Awal: Rp " + totalPemasukan, normalFont));
        doc.add(new Paragraph("Total Pengeluaran Realisasi: Rp " + totalPengeluaran, normalFont));
        doc.add(new Paragraph("Total Sisa Saldo Akhir: Rp " + sisaSaldo, normalFont));
        doc.add(new Paragraph(" "));

        // Tabel Rincian Pengeluaran
        Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.WHITE);
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3f, 2f, 2f, 3f, 4f, 3f});

        String[] headers = {"Tanggal", "Hari", "Minggu", "Kategori", "Keterangan", "Nominal"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, tableHeaderFont));
            cell.setBackgroundColor(new Color(110, 35, 140)); // Warna ungu Kencana
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(6);
            table.addCell(cell);
        }

        for (PengeluaranHarian p : pengeluaranList) {
            table.addCell(new PdfPCell(new Phrase(p.getTanggal() != null ? p.getTanggal().toString() : "-", normalFont)));
            table.addCell(new PdfPCell(new Phrase(p.getHari() != null ? p.getHari() : "-", normalFont)));
            table.addCell(new PdfPCell(new Phrase(p.getMingguKe() != null ? p.getMingguKe() : "-", normalFont)));
            table.addCell(new PdfPCell(new Phrase(p.getKategori() != null ? p.getKategori() : "-", normalFont)));
            table.addCell(new PdfPCell(new Phrase(p.getKeterangan() != null ? p.getKeterangan() : "-", normalFont)));
            
            PdfPCell nominalCell = new PdfPCell(new Phrase("Rp " + p.getNominal(), normalFont));
            nominalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(nominalCell);
        }

        doc.add(table);
        doc.close();
    }
}