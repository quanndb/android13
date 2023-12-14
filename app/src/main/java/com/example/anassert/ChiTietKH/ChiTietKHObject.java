package com.example.anassert.ChiTietKH;

public class ChiTietKHObject {

    private int IDKH, IDHP;
    private String addDate;

    public ChiTietKHObject(String addDate, int IDKH, int IDHP){
        this.addDate = addDate;
        this.IDHP = IDHP;
        this.IDKH = IDKH;
    }

    public int getIDKH() {
        return IDKH;
    }

    public void setIDKH(int IDKH) {
        this.IDKH = IDKH;
    }

    public int getIDHP() {
        return IDHP;
    }

    public void setIDHP(int IDHP) {
        this.IDHP = IDHP;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
}
