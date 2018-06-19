package com.android.wondercom.Receivers;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.android.wondercom.DND;
import com.android.wondercom.DNDOFF;
import com.android.wondercom.Flashligh;
import com.android.wondercom.FlashlighIS;
import com.android.wondercom.Flashlight;
import com.android.wondercom.FlashlightIS;
import com.android.wondercom.GeneralIS;
import com.android.wondercom.LocationS;
import com.android.wondercom.MobileMode;
import com.android.wondercom.RABOFF;
import com.android.wondercom.RABON;
import com.android.wondercom.RecentMessages;
import com.android.wondercom.Silent;
import com.android.wondercom.SmartAccess;
import com.android.wondercom.SmsDeliveredReceiver;
import com.android.wondercom.SmsSentReceiver;
import com.android.wondercom.Vibration;
import com.android.wondercom.VibrationIS;
import com.android.wondercom.WIFIOFF;
import com.android.wondercom.WIFION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;


public class MessageReceiver extends BroadcastReceiver {
    // Get the object of SmsManager
    final SmsManager smsx = SmsManager.getDefault();
    String message;
    String mm, fl1, fl2, mm2, mm3,mm4,mm5,wifi,wifi2,rab,rab2, rm, rc, in, lo,co,messagec,cont,messagen,nam,longi,lati, senderNum, totalBody = "", R5 = "";
   // String[] separated;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    senderNum = phoneNumber;
                    message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                    // Show Alert
//                    int duration = Toast.LENGTH_LONG;
//                    Toast toast = Toast.makeText(context,
//                            "senderNum: "+ senderNum + ", message: " + message, duration);
//                    toast.show();

                } // end for loop

                if(message.contains(".")){

                    StringTokenizer tokens = new StringTokenizer(message, ".");
                     messagec = tokens.nextToken();// this will contain "Fruit"
                     cont = tokens.nextToken();

                }

                if(message.contains(":")){

                    StringTokenizer tokens = new StringTokenizer(message, ":");
                    messagen = tokens.nextToken();// this will contain "Fruit"
                    nam = tokens.nextToken();

                }

                SharedPreferences xxx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = xxx.edit();
                editor.putString("rco", senderNum);
                editor.apply();


                SharedPreferences x = context.getSharedPreferences("sco", Context.MODE_PRIVATE);

                mm = x.getString("mobilemode", "");
                mm2 = x.getString("mobilemode2", "");
                mm3 = x.getString("mobilemode3", "");
                mm4 = x.getString("mobilemode4", "");
                mm5 = x.getString("mobilemode5", "");
                wifi = x.getString("wifi", "");
                wifi2 = x.getString("wifi2", "");
                rab = x.getString("rab", "");
                rab2 = x.getString("rab2", "");
                fl1 = x.getString("flashlight1", "");
                fl2 = x.getString("flashlight2", "");


                if (mm.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT MM ", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, GeneralIS.class);
                    context.startService(k);

                }

                if (mm2.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT MM2", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, VibrationIS.class);
                    context.startService(k);

                }

                if (mm3.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT MM3", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, Silent.class);
                    context.startService(k);

                }

                if (mm4.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT MM4", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, DND.class);
                    context.startService(k);

                }

                if (mm5.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT MM5", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, DNDOFF.class);
                    context.startService(k);

                }

                if (wifi.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT WIFI", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, WIFION.class);
                    context.startService(k);

                }

                if (wifi2.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT WIFI2", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, WIFIOFF.class);
                    context.startService(k);

                }

                if (rab.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT RAB", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context, RABON.class);
                    context.startService(k);

                }

                if (rab2.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT RAB", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(context,RABOFF.class);
                    context.startService(k);

                }

                if (fl1.equals(message)) {


                    Toast.makeText(context, "IN IF2 STATEMENT", Toast.LENGTH_SHORT).show();
                    Intent l = new Intent(context, FlashlightIS.class);
                    context.startService(l);

                }

                if (fl2.equals(message)) {


                    Toast.makeText(context, "IN IF3 STATEMENT", Toast.LENGTH_SHORT).show();
                    Intent m = new Intent(context, FlashlighIS.class);
                    context.startService(m);

                }




                SharedPreferences xx = context.getSharedPreferences("sa", Context.MODE_PRIVATE);

                rm = xx.getString("recentmessages", "");
                rc = xx.getString("recentcalls", "");
                in = xx.getString("imeinumber", "");
                lo = xx.getString("location", "");
                co = xx.getString("contacts", "");


                if (rm.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT OF RM", Toast.LENGTH_SHORT).show();

                    List<String> sms = new ArrayList<String>();
                    Uri uriSMSURI = Uri.parse("content://sms/inbox");
                    Cursor cur = context.getContentResolver().query(uriSMSURI, null, null, null, "date DESC LIMIT 10");

                    while (cur != null && cur.moveToNext()) {
                        String address = cur.getString(cur.getColumnIndex("address"));
                        String body = cur.getString(cur.getColumnIndexOrThrow("body"));
                        sms.add("Number: " + address + " .Message: " + body);
                    }

                    if (cur != null) {
                        cur.close();
                    }


                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                    String rcon = xsx.getString("rco", "");


                    Toast.makeText(context, rcon + sms, Toast.LENGTH_LONG).show();
                    try {
                        // SmsManager smss = SmsManager.getDefault();
                        // smss.sendTextMessage(rcon, null, sms.toString(), null, null);


                        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
                        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();
                        PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
                                new Intent(context, SmsSentReceiver.class), 0);

                        PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
                                new Intent(context, SmsDeliveredReceiver.class), 0);
                        try {
                            SmsManager smss = SmsManager.getDefault();
                            ArrayList<String> mSMSMessage = smss.divideMessage(sms.toString());
                            for (int i = 0; i < mSMSMessage.size(); i++) {
                                sentPendingIntents.add(i, sentPI);

                                deliveredPendingIntents.add(i, deliveredPI);
                            }
                            smss.sendMultipartTextMessage(rcon, null, mSMSMessage,
                                    sentPendingIntents, deliveredPendingIntents);

                        } catch (Exception e) {

                            e.printStackTrace();
                            Toast.makeText(context, "SMS sending failed...",
                                    Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception ex) {
                        Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
                    }
                    // Intent k = new Intent(context, RecentMessages.class);
                    //context.startService(k);

                }

                if (rc.equals(message)) {





                    //Intent k = new Intent(context, Vibration.class);
                    //context.startService(k);


                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                    String rcon = xsx.getString("rco", "");
                    try {
                        Toast.makeText(context, "IN IF STATEMENT OF RC", Toast.LENGTH_SHORT).show();
                        // SmsManager smss = SmsManager.getDefault();
                        // smss.sendTextMessage(rcon, null, sms.toString(), null, null);

                        Toast.makeText(context, getCallDetails(context), Toast.LENGTH_SHORT).show();
                        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
                        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();
                        PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
                                new Intent(context, SmsSentReceiver.class), 0);

                        PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
                                new Intent(context, SmsDeliveredReceiver.class), 0);
                        try {


                            SmsManager smss = SmsManager.getDefault();
                            ArrayList<String> mSMSMessage = smss.divideMessage(getCallDetails(context).toString());
                            for (int i = 0; i < mSMSMessage.size(); i++) {
                                sentPendingIntents.add(i, sentPI);

                                deliveredPendingIntents.add(i, deliveredPI);
                            }

                            Toast.makeText(context, rcon + getCallDetails(context).toString(),
                                    Toast.LENGTH_LONG).show();

                            smss.sendMultipartTextMessage(rcon, null, mSMSMessage,
                                    sentPendingIntents, deliveredPendingIntents);

                        } catch (Exception e) {

                            e.printStackTrace();
                            Toast.makeText(context, e.toString(),
                                    Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception ex) {
                        Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
                    }

                }

                if (in.equals(message)) {


                    Toast.makeText(context, "IN IF STATEMENT IN", Toast.LENGTH_SHORT).show();
                    //Intent k = new Intent(context, Silent.class);
                    //context.startService(k);
                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                    String rcon = xsx.getString("rco", "");
                    SmsManager smss = SmsManager.getDefault();
                     smss.sendTextMessage(rcon, null, getUniqueIMEIId(context).toString(), null, null);


                }

                if (lo.equals(message)) {


                    Toast.makeText(context, "IN IF2 STATEMENT LOCATION", Toast.LENGTH_SHORT).show();
//                     Intent l = new Intent(context, LocationS.class);
//                     context.startService(l);

                    SharedPreferences xz = context.getSharedPreferences("lo", Context.MODE_PRIVATE);
                    String loc = xz.getString("loco", "");


                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
                    String rcon = xsx.getString("rco", "");

                    SmsManager smss = SmsManager.getDefault();
                    smss.sendTextMessage(rcon, null, loc, null, null);


                }

                if ((co.equals(messagec))&&(cont!=null)) {


                    Toast.makeText(context, "IN IF STATEMENT OF CONTACTS", Toast.LENGTH_SHORT).show();
                    // Intent l = new Intent(context, Flashlight.class);
                    // context.startService(l);

                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                    String rcon = xsx.getString("rco", "");
                    SmsManager smss = SmsManager.getDefault();
                    smss.sendTextMessage(rcon, null, getPhoneNumber(cont,context).toString(), null, null);


                }

               else if ((co.equals(messagen))&&(nam!=null)) {


                    Toast.makeText(context, "IN IF STATEMENT OF CONTACTS", Toast.LENGTH_SHORT).show();
                    // Intent l = new Intent(context, Flashlight.class);
                    // context.startService(l);

                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                    String rcon = xsx.getString("rco", "");
                    SmsManager smss = SmsManager.getDefault();
                    smss.sendTextMessage(rcon, null, getContactName(nam,context).toString(), null, null);


                }


            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }



    public static String getUniqueIMEIId(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "";
            }
            String imei = telephonyManager.getDeviceId();
            Log.e("imei", "=" + imei);
            if (imei != null && !imei.isEmpty()) {
                return imei;
            } else {
                return android.os.Build.SERIAL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "not_found";
    }





    public static String getCallDetails(Context context) {
        StringBuffer stringBuffer = new StringBuffer();

        //Uri.parse("content://call_log/calls")
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

            if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, android.Manifest.permission.READ_CALL_LOG)){
                ActivityCompat.requestPermissions((Activity) context,new String[]{android.Manifest.permission.READ_CALL_LOG}, 1);
            }
            else {
                ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.READ_CALL_LOG}, 1);
            }


        }
        String sortOrder = String.format("%s limit 10 ", CallLog.Calls.DATE + " DESC");

        Cursor cursor = context.getContentResolver().query(android.provider.CallLog.Calls.CONTENT_URI,
                null, null, null, "date DESC LIMIT 10" );
        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = cursor.getColumnIndex(CallLog.Calls.DATE);

        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        while (cursor.moveToNext()) {
            String phNumber = cursor.getString(number);
            String callType = cursor.getString(type);
            String callDate = cursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = cursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);
            switch (dircode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;

                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;
            }
            stringBuffer.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- "
                    + dir + " \nCall Date:--- " + callDayTime
                    + " \nCall duration in sec :--- " + callDuration);
            stringBuffer.append("\n----------------------------------");
        }
        cursor.close();
        return stringBuffer.toString();
    }



    public String getPhoneNumber(String name, Context context) {
        String ret = null;
        String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" like'%" + name +"%'";
        String[] projection = new String[] { ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor c = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projection, selection, null, null);
        if (c.moveToFirst()) {
            ret = c.getString(0);
        }
        c.close();
        if(ret==null)
            ret = "Unsaved";
        return ret;
    }


    public String getContactName(final String phoneNumber, Context context)
    {
        Uri uri=Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,Uri.encode(phoneNumber));

        String[] projection = new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME};

        String contactName="";
        Cursor cursor=context.getContentResolver().query(uri,projection,null,null,null);

        if (cursor != null) {
            if(cursor.moveToFirst()) {
                contactName=cursor.getString(0);
            }
            cursor.close();
        }
        if(contactName==null)
            contactName = "Unsaved";

        return contactName;
    }




//    @Override
//    public void onRequestPermissionsResult( int requestCode, String[] permissions,
//                                            int[] grantResults){
//
//        switch (requestCode) {
//
//            case  1: {
//
//                if((grantResults.length>0)&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    if(ContextCompat.checkSelfPermission(SmartAccess.this, Manifest.permission.READ_CALL_LOG)==PackageManager.PERMISSION_GRANTED){
//                        Toast.makeText(SmartAccess.this,"PERMISSION GRANTED",Toast.LENGTH_LONG);
//
//
//                    }
//                    else {
//                        Toast.makeText(SmartAccess.this, "PERMISSION NOT GRANTED", Toast.LENGTH_LONG);
//                    }
//                    return;
//
//                }
//
//            }
//        }
//    }



}

