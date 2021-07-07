package id.imam.cobakkp.model;

public class ModelBerhasil {
    String keterangan_transfer;
    String id_wisata;
    String id_order;
    String alamat_email;
    String kode_transaksi;
    String nama_pemesan;
    String nama_wisata;
    String status_pembatalan;
    String keterangan_pembatalan;
    String id_dia;

    public String getKeterangan_transfer() {
        return keterangan_transfer;
    }

    public void setKeterangan_transfer(String keterangan_transfer) {
        this.keterangan_transfer = keterangan_transfer;
    }

    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getId_order() {
        return id_order;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public String getAlamat_email() {
        return alamat_email;
    }

    public void setAlamat_email(String alamat_email) {
        this.alamat_email = alamat_email;
    }

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public String getNama_pemesan() {
        return nama_pemesan;
    }

    public void setNama_pemesan(String nama_pemesan) {
        this.nama_pemesan = nama_pemesan;
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getStatus_pembatalan() {
        return status_pembatalan;
    }

    public void setStatus_pembatalan(String status_pembatalan) {
        this.status_pembatalan = status_pembatalan;
    }

    public String getKeterangan_pembatalan() {
        return keterangan_pembatalan;
    }

    public void setKeterangan_pembatalan(String keterangan_pembatalan) {
        this.keterangan_pembatalan = keterangan_pembatalan;
    }

    public String getId_dia() {
        return id_dia;
    }

    public void setId_dia(String id_dia) {
        this.id_dia = id_dia;
    }

    public ModelBerhasil(String keterangan_transfer, String id_wisata, String id_order, String alamat_email, String kode_transaksi, String nama_pemesan, String nama_wisata, String status_pembatalan, String keterangan_pembatalan, String id_dia) {
        this.keterangan_transfer = keterangan_transfer;
        this.id_wisata = id_wisata;
        this.id_order = id_order;
        this.alamat_email = alamat_email;
        this.kode_transaksi = kode_transaksi;
        this.nama_pemesan = nama_pemesan;
        this.nama_wisata = nama_wisata;
        this.status_pembatalan = status_pembatalan;
        this.keterangan_pembatalan = keterangan_pembatalan;
        this.id_dia = id_dia;
    }

    public ModelBerhasil() {
    }
}
