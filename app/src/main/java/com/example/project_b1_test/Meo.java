package com.example.project_b1_test;

import android.widget.ImageView;

public class Meo    {
    public String Tenmeo,Noidung;


    public Meo(String tenmeo, String noidung) {
        this.Tenmeo = tenmeo;
        this.Noidung = noidung;

    }


    public String getTenmeo() {
        return Tenmeo;
    }
    public void setTenmeo(String tenmeo) {
        this.Tenmeo = tenmeo;
    }

    public String getNoidung() {
        return Noidung;
    }
    public void setNoidung(String noidung) {
        this.Noidung = noidung;
    }

}
