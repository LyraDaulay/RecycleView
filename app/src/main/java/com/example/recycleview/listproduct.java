package com.example.recycleview;

public class listproduct {
    private String namaItem;
    private int logoitem;
    private String deskripsiItem;
    private String hargaItem;

    public listproduct(String namaItem, int logoitem, String deskripsiItem, String hargaItem) {
        this.namaItem = namaItem;
        this.logoitem = logoitem;
        this.deskripsiItem = deskripsiItem;
        this.hargaItem = hargaItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public int getLogoitem() {
        return logoitem;
    }

    public String getDeskripsiItem() {
        return deskripsiItem;
    }

    public String getHargaItem() {
        return hargaItem;
    }
}
