package com.android.wondercom.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.util.Log;

public class SimChangedReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equalsIgnoreCase("android.intent.action.SIM_STATE_CHANGED")) {

            SharedPreferences xsx = context.getSharedPreferences("st", Context.MODE_PRIVATE);

            String nmbr = xsx.getString("nmbr", "");

            SmsManager smss = SmsManager.getDefault();
            smss.sendTextMessage(nmbr, null, "SIM WAS DISCONNECTED", null, null);

        }
    }
}