package com.example.sony.stormy.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.example.sony.stormy.R;

/**
 * Created by SONY on 02.08.2015.
 */
public class AlertDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context=getActivity();
        AlertDialog.Builder builder=new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.error_title))
                .setMessage(context.getString(R.string.error_message))
                .setPositiveButton(context.getString(R.string.error_button), null);
        AlertDialog dialog=builder.create();


        return dialog;
    }
}
