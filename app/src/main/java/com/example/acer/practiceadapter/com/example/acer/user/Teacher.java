package com.example.acer.practiceadapter.com.example.acer.user;

import android.os.Parcelable;
import android.os.Parcel;
/**
 * Created by ACER on 13/10/2016.
 */

public class Teacher implements Parcelable {
    private int id;
    private String nip;
    private String name;
    private String phone;
    private String mail;

public Teacher(int id, String nip, String name, String mail, String phone) {
        this.id = id;
        this.nip = nip;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

        public Teacher(Parcel in){
            id = in.readInt();
            nip = in.readString();
            name = in.readString();
            mail = in.readString();
            phone = in.readString();
        }

        public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
            @Override
            public Teacher createFromParcel(Parcel in){
                return new Teacher(in);
            }
            @Override
            public Teacher[] newArray(int size) {
                return new Teacher[size];
            }
        };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getNip());
        dest.writeString(getName());
        dest.writeString(getMail());
        dest.writeString(getPhone());
    }
}
