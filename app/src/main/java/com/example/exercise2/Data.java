package com.example.exercise2;

import java.io.Serializable;

//activity untuk setter and getter data untuk kelas java
public class Data implements Serializable {
    private String nama;
    private String alamat;
    private String nohp;
    private String judulbuku;
    private String kdsewa;

    public String getKdsewa() {
        return kdsewa;
    }

    public void setKdsewa(String kdsewa) {
        this.kdsewa = kdsewa;
    }

    public Data(){

    }
    public Data(String nm, String al, String no, String jd,String kds){
        nama = nm;
        alamat = al;
        nohp = no;
        judulbuku = jd;
        kdsewa = kds;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getJudulbuku() {
        return judulbuku;
    }

    public void setJudulbuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    @Override
    public String toString() {
        return "Data{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", nohp='" + nohp + '\'' +
                ", judulbuku='" + judulbuku + '\'' +
                ", kdsewa='" + kdsewa + '\'' +
                '}';
    }
}
