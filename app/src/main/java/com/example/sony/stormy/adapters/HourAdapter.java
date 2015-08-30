package com.example.sony.stormy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sony.stormy.R;
import com.example.sony.stormy.weather.Hour;

import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SONY on 27.08.2015.
 */
public class HourAdapter extends RecyclerView.Adapter <HourAdapter.HourViewHolder> {
    Hour[] mHours;

    public HourAdapter(Hour[] hours){
        mHours=hours;

    }





    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourly_list_item,viewGroup,false);
        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder hourViewHolder, int i) {
        hourViewHolder.bindHour(mHours[i]);


    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder{
        /*private TextView mTimeLabel;
        private TextView mSummaryLabel;
        private ImageView mIconImageView;
        private TextView mTemperatureLabel;
        */
        @Bind(R.id.timeLabel) TextView mTimeLabel;
        @Bind(R.id.temperatureLabel) TextView mTemperatureLabel;
        @Bind(R.id.summaryLabel) TextView mSummaryLabel;
        @Bind(R.id.iconImageView)ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            /*mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            */
           ButterKnife.bind(this,itemView);
        }

        public void bindHour(Hour hour){

            mTimeLabel.setText(hour.getTimeOfDay());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature()+"");
            mIconImageView.setImageResource(hour.getIconId());



        }
    }

}
