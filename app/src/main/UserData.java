package com.example.ashishkumarpatel.tops;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by ashishkumarpatel on 26/02/18.
 */
@Entity(tableName = "UserData")

public class UserData {
    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo (name = "name")
    private  String name;
    @ColumnInfo(name = "mobileNo")

    private String mobileNo;
    @ColumnInfo(name = "Address")

    private String Address;
    @ColumnInfo(name = "latitude")

    private double latitude;
    @ColumnInfo(name = "longitude")

    private  double longitude;
    public  UserData(){}

    public UserData(String name, String mobileNo, String address, double latitude, double longitude) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.Address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
