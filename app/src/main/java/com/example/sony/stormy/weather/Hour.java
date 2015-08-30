package com.example.sony.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SONY on 20.08.2015.
 */
public class Hour implements Parcelable {
    private long mTime;
    private String mSummary;
    private double mTemperature;
    private String mIcon;
    private String mTimezone;

    public Hour(){

    }

    public long getTime() {

        return mTime;
    }

    public void setTime(long time) {
        mTime=time;
    }

    public String getTimeOfDay(){
        DateFormat formatter = new SimpleDateFormat("h a");
        Date date = new Date(mTime*1000);

        return formatter.format(date);
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperature() {
        return (int)Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {


        mTemperature = temperature;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSummary);
        dest.writeLong(mTime);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);
        dest.writeDouble(mTemperature);

    }

    private Hour(Parcel in){
        mSummary=in.readString();
        mTime=in.readLong();
        mIcon=in.readString();
        mTimezone=in.readString();
        mTemperature=in.readDouble();
    }

    public static final Parcelable.Creator<Hour> CREATOR = new Creator<Hour>(){
        @Override
        public Hour createFromParcel(Parcel in){
            return new Hour(in);
        }

        @Override
        public Hour[] newArray(int size){
            return new Hour[size];
        }
    };


}
