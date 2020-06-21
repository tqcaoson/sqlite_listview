package com.example.otlistview;

import java.io.Serializable;

public class BHModel implements Serializable {
    public BHModel(int anh, int like, String ten, String casi) {
        this.anh = anh;
        this.like = like;
        this.ten = ten;
        this.casi = casi;
    }
//    public BHModel(int id, int anh, int like, String ten, String casi) {
//        this.id = id;
//        this.anh = anh;
//        this.like = like;
//        this.ten = ten;
//        this.casi = casi;
//    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id, anh, like;
    String ten, casi;
}
