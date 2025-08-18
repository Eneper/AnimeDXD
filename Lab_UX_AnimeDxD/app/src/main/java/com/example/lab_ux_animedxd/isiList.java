package com.example.lab_ux_animedxd;

public class isiList {

    private String nama;

    private String genre;

    private String description;
    private int image;

    private int ImageResourceId;

    public isiList(String nama ,String genre ,String description,int image){
        this.nama = nama;
        this.genre = genre;
        this.description = description;
        this.image = image;
    }

    public String getName(){
        return nama;
    }

    public String getDescription(){
        return description;
    }

    public String getGenre(){ return genre;}

    public int getImage(){
        return image;
    }

    public int getImageResourceId(){
        return this.image;
    }
}
