package com.orange.myapplication;

public class RecyclerData {
    private String title;
    private String prix;
    private int imgid;

    public String getTitle() {
        return title;
    }
    public String getPrix() {
        return prix;
    }
    public void setPrix(String prix) {
        this.prix = prix;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public RecyclerData(String title, String prix, int imgid) {
        this.prix = prix;
        this.title = title;
        this.imgid = imgid;
    }
}
