package id.imam.cobakkp.model;

public class ModelGagal {
    private String id_wisata;
    private String id_order;
    private String kode_transaksi;
    private String nama_wisata;
    private String  id_transaksi;
    private String harga_wisata;
    private String keterangan;
    private String keterangan_wisata;
    private String waktu_gagal;
    private String harga;



    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public ModelGagal(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getId_order() {
        return id_order;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getHarga_wisata() {
        return harga_wisata;
    }

    public void setHarga_wisata(String harga_wisata) {
        this.harga_wisata = harga_wisata;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeterangan_wisata() {
        return keterangan_wisata;
    }

    public void setKeterangan_wisata(String keterangan_wisata) {
        this.keterangan_wisata = keterangan_wisata;
    }

    public String getWaktu_gagal() {
        return waktu_gagal;
    }

    public void setWaktu_gagal(String waktu_gagal) {
        this.waktu_gagal = waktu_gagal;
    }

    public ModelGagal(String id_order, String kode_transaksi, String nama_wisata, String id_transaksi, String harga_wisata, String keterangan, String keterangan_wisata, String waktu_gagal) {
        this.id_order = id_order;
        this.kode_transaksi = kode_transaksi;
        this.nama_wisata = nama_wisata;
        this.id_transaksi = id_transaksi;
        this.harga_wisata = harga_wisata;
        this.keterangan = keterangan;
        this.keterangan_wisata = keterangan_wisata;
        this.waktu_gagal = waktu_gagal;
    }

    public ModelGagal() {
    }
}
