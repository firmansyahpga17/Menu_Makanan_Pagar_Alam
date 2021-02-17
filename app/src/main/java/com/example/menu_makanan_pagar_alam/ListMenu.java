package com.example.menu_makanan_pagar_alam;

public class ListMenu {
    private String nama, harga, deskripsi, no_hp, latitude, longitude;
    private int foto;

    public ListMenu(String nama, String harga, String deskripsi, int foto, String no_hp, String latitude, String longitude){
        this.nama       = nama;
        this.harga      = harga;
        this.deskripsi  = deskripsi;
        this.foto       = foto;
        this.no_hp      = no_hp;
        this.latitude   = latitude;
        this.longitude  = longitude;
    }

    public String getNama(){
        return this.nama;
    }

    public  String getHarga(){
        return this.harga;
    }

    public String getDeskripsi(){
        return this.deskripsi;
    }

    public int getFoto(){
        return  this.foto;
    }

    public String getNo_hp() {
        return this.no_hp;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude(){
        return this.longitude;
    }
}
