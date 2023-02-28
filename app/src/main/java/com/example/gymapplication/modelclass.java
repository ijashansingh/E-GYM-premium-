package com.example.gymapplication;

public class modelclass {


    public int image;

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int thumbnail;
    public String textview1,textview2;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    boolean selected;

    modelclass(int image, String textview1, String textview2,int thumbnail){
        this.image = image;
        this.textview1=textview1;
        this.textview2=textview2;
        this.thumbnail=thumbnail;
    }

    public int getImage() {
        return image;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }


}
