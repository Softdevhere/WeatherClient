package com.example.sony.stormy.UI;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sony.stormy.R;
import com.example.sony.stormy.adapters.HourAdapter;
import com.example.sony.stormy.weather.Hour;

import java.lang.reflect.Array;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HourlyForecastActivity extends AppCompatActivity {

    Hour[] mHours;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);
        Intent intent =getIntent();
        Parcelable[] hourPacelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours= Arrays.copyOf(hourPacelables,hourPacelables.length,Hour[].class);

        HourAdapter hourAdapter = new HourAdapter(this,mHours);
        mRecyclerView.setAdapter(hourAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

    }


}
