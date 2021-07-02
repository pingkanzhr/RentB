package com.example.exercise2;

public class Buku {
    private String namabuku;
    private String namaauthor;
    private String genre;
    private String ekode,kode;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Buku(){

    }

    public Buku(String nb, String nu, String gr, String kde){
        namabuku = nb;
        namaauthor = nu;
        genre = gr;
        ekode = kde;
    }

    public String getNamabuku() {
        return namabuku;
    }

    public void setNamabuku(String namabuku) {
        this.namabuku = namabuku;
    }

    public String getNamaauthor() {
        return namaauthor;
    }

    public void setNamaauthor(String namaauthor) {
        this.namaauthor = namaauthor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEkode() {
        return ekode;
    }

    public void setEkode(String ekode) {
        this.ekode = ekode;
    }


    @Override
    public String toString() {
        return "Buku{" +
                "namabuku='" + namabuku + '\'' +
                ", namaauthor='" + namaauthor + '\'' +
                ", genre='" + genre + '\'' +
                ", ekode='" + ekode + '\'' +
                ", kode='" + kode + '\'' +
                '}';
    }
}

