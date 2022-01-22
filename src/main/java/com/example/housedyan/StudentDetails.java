package com.example.housedyan;

public class StudentDetails implements java.io.Serializable
{

    public String studid;
    public String stuname;
    public String email;
    public String phonenum;

    public StudentDetails(){

    }

    public StudentDetails(String studid, String stuname, String email, String phonenum) {
        this.studid = studid;
        this.stuname = stuname;
        this.email = email;
        this.phonenum = phonenum;
    }



    public String getStudid() {
        return studid;
    }

    public String getStuname() {
        return stuname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setStudid(String studid) {
        this.studid = studid;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}