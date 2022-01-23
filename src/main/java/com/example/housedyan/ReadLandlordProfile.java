package com.example.housedyan;

public class ReadLandlordProfile implements java.io.Serializable
{
    public String landordid;
    public String landlordusername;
    public String landlordpassword;
    public String landlordname;
    public String landlordemail;
    public String landlordage;
    public String landlordphoneno;
    public String landlordgender;

    public ReadLandlordProfile()
    {

    }

    public ReadLandlordProfile(String landordid,String landlordusername,String landlordpassword,String landlordname,String landlordemail,String landlordage,String landlordphoneno,String landlordgender)
    {
        this.landordid=landordid;
        this.landlordusername=landlordusername;
        this.landlordpassword=landlordpassword;
        this.landlordname=landlordname;
        this.landlordemail=landlordemail;
        this.landlordage=landlordage;
        this.landlordphoneno=landlordphoneno;
        this.landlordgender=landlordgender;
    }

    public String getLandordid() {
        return landordid;
    }

    public String getLandlordusername() {
        return landlordusername;
    }

    public String getLandlordpassword() {
        return landlordpassword;
    }

    public String getLandlordname() {
        return landlordname;
    }

    public String getLandlordemail() {
        return landlordemail;
    }

    public String getLandlordage() {
        return landlordage;
    }

    public String getLandlordphoneno() {
        return landlordphoneno;
    }

    public String getLandlordgender() {
        return landlordgender;
    }

    public void setLandordid(String landordid) {
        this.landordid = landordid;
    }

    public void setLandlordusername(String landlordusername) {
        this.landlordusername = landlordusername;
    }

    public void setLandlordpassword(String landlordpassword) {
        this.landlordpassword = landlordpassword;
    }

    public void setLandlordname(String landlordname) {
        this.landlordname = landlordname;
    }

    public void setLandlordemail(String landlordemail) {
        this.landlordemail = landlordemail;
    }

    public void setLandlordage(String landlordage) {
        this.landlordage = landlordage;
    }

    public void setLandlordphoneno(String landlordphoneno) {
        this.landlordphoneno = landlordphoneno;
    }

    public void setLandlordgender(String landlordgender) {
        this.landlordgender = landlordgender;
    }
}

