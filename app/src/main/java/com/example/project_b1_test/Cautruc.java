package com.example.project_b1_test;


public class Cautruc {
    public String Tenct, Noidungct ;

    public Cautruc(String tenct, String noidungct) {
        this.Tenct = tenct;
        this.Noidungct = noidungct;

    }
    public String getTenct() {
        return Tenct;
    }
    public void setTenct(String tenct) {this.Tenct = tenct; }

    public String getNoidungct() {return Noidungct; }
    public void setNoidungct(String noidungct) {
        this.Noidungct = noidungct;
    }
}
