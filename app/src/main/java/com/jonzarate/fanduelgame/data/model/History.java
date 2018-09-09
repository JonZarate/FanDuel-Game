package com.jonzarate.fanduelgame.data.model;

import android.arch.persistence.room.PrimaryKey;

public class History {

    @PrimaryKey(autoGenerate = true)
    int id;

    String name0, name1, name2, name3;
    float fppg0, fppg1, fppg2, fppg3;
    String img0, img1, img2, img3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName0() {
        return name0;
    }

    public void setName0(String name0) {
        this.name0 = name0;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public float getFppg0() {
        return fppg0;
    }

    public void setFppg0(float fppg0) {
        this.fppg0 = fppg0;
    }

    public float getFppg1() {
        return fppg1;
    }

    public void setFppg1(float fppg1) {
        this.fppg1 = fppg1;
    }

    public float getFppg2() {
        return fppg2;
    }

    public void setFppg2(float fppg2) {
        this.fppg2 = fppg2;
    }

    public float getFppg3() {
        return fppg3;
    }

    public void setFppg3(float fppg3) {
        this.fppg3 = fppg3;
    }

    public String getImg0() {
        return img0;
    }

    public void setImg0(String img0) {
        this.img0 = img0;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
}
