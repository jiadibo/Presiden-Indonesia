package com.example.jiadibo.presidenindonesia;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

class President implements Parcelable {
    private String name;
    private String remarks;
    private String photo;

    public President() {
    }

    protected President(Parcel in) {
        name = in.readString();
        remarks = in.readString();
        photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(remarks);
        dest.writeString(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<President> CREATOR = new Creator<President>() {
        @Override
        public President createFromParcel(Parcel in) {
            return new President(in);
        }

        @Override
        public President[] newArray(int size) {
            return new President[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
