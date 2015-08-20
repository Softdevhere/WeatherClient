package com.example.sony.stormy.weather;

/**
 * Created by SONY on 20.08.2015.
 */
public class Forecast {
    private Day[] mDailyForecast;
    private Hour[] mHourlyForecast;
    private Current mCurrent;

    public Day[] getDailyForecast() {
        return mDailyForecast;
    }

    public void setDailyForecast(Day[] dailyForecast) {
        mDailyForecast = dailyForecast;
    }

    public Hour[] getHourlyForecast() {
        return mHourlyForecast;
    }

    public void setHourlyForecast(Hour[] hourlyForecast) {
        mHourlyForecast = hourlyForecast;
    }

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }
}
