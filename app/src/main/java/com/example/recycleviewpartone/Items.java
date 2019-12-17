package com.example.recycleviewpartone;

class Items {

    private String Title, Description, Date;
    private int Image;

    Items(String title, String description, String date, int image) {
        Title = title;
        Description = description;
        Date = date;
        this.Image = image;
    }

    String getTitle(){
        return Title;
    }
    String getDescription(){
        return  Description;
    }
    String getDate(){
        return Date;
    }
    int getImage(){
        return Image;
    }
}
