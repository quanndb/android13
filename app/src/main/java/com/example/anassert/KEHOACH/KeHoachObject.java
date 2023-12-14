package com.example.anassert.KEHOACH;

public class KeHoachObject {

    private String updateDate;
    private int IDSV;

    public KeHoachObject(String updateDate,int IDSV){
        this.updateDate = updateDate;
        this.IDSV = IDSV;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getIDSV() {
        return IDSV;
    }

    public void setIDSV(int IDSV) {
        this.IDSV = IDSV;
    }
}
