package com;

public class Product {

    private String pName;
    private String pDetalis;
    private String pPrice;
    private String cName;
    private String cUser_name;
    private String cPhone;
    private int pid;
 
    
    public Product(String pName,String pDetalis,String pPrice,String cName,String cUser_name,String cPhone,int pid)
    {
        this.pName=pName;
        this.pDetalis=pDetalis;
        this.pPrice=pPrice;
        this.cName=cName;
        this.cUser_name=cUser_name;
        this.cPhone=cPhone;
        this.pid=pid;
    }
    
    
    
    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpDetalis(String pDetalis) {
        this.pDetalis = pDetalis;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcUser_name(String cUser_name) {
        this.cUser_name = cUser_name;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getpName() {
        return pName;
    }

    public String getpDetalis() {
        return pDetalis;
    }

    public String getpPrice() {
        return pPrice;
    }

    public String getcName() {
        return cName;
    }

    public String getcUser_name() {
        return cUser_name;
    }

    public String getcPhone() {
        return cPhone;
    }

}
