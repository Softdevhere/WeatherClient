package com.example.sony.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sony.stormy.R;
import com.example.sony.stormy.UI.HourlyForecastActivity;
import com.example.sony.stormy.weather.Hour;

import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SONY on 27.08.2015.
 */
public class HourAdapter extends RecyclerView.Adapter <HourAdapter.HourViewHolder> {
    Hour[] mHours;
    Context mContext;

    public HourAdapter(Context context,Hour[] hours){
        mContext = context;
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

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour){

            mTimeLabel.setText(hour.getTimeOfDay());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature()+"");
            mIconImageView.setImageResource(hour.getIconId());



        }

        @Override
        public void onClick(View v) {
            String time = mTimeLabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String summary=mSummaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temperature, summary);
            Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
            toast.show();

        }
    }

}
