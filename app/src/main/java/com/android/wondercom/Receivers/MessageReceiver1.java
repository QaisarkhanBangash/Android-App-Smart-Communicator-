//package com.android.wondercom.Receivers;
//
//import android.Manifest;
//import android.app.Activity;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.CallLog;
//import android.provider.ContactsContract;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.telephony.SmsManager;
//import android.telephony.SmsMessage;
//import android.util.Log;
//import android.widget.Toast;
//
//
//import com.android.wondercom.SmsDeliveredReceiver;
//import com.android.wondercom.SmsSentReceiver;
//
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.StringTokenizer;
//
//
//public class MessageReceiver1 extends BroadcastReceiver {
//    // Get the object of SmsManager
//    final SmsManager smsx = SmsManager.getDefault();
//    String message;
//    String pc1,pc2,pc11,pc22,pcn,pcnn,pcs,mm, fl1, fl2, mm2, mm3,mm4,mm5,wifi,wifi2,rab,rab2, rm, rc, in, lo,co,messagec,cont,messagen,nam,longi,lati, senderNum, totalBody = "", R5 = "";
//   // String[] separated;
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        // Retrieves a map of extended data from the intent.
//        final Bundle bundle = intent.getExtras();
//
//        try {
//
//            if (bundle != null) {
//
//                final Object[] pdusObj = (Object[]) bundle.get("pdus");
//
//                for (int i = 0; i < pdusObj.length; i++) {
//
//                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
//                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
//
//                    senderNum = phoneNumber;
//                    message = currentMessage.getDisplayMessageBody();
//
//                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);
//
//                    // Show Alert
////                    int duration = Toast.LENGTH_LONG;
////                    Toast toast = Toast.makeText(context,
////                            "senderNum: "+ senderNum + ", message: " + message, duration);
////                    toast.show();
//
//                } // end for loop
//
//                if(message.contains("@")){
//
//                    StringTokenizer tokens = new StringTokenizer(message, "@");
//                    pc1 = tokens.nextToken();
//                    pc2 = tokens.nextToken();
//                    pcn = senderNum;
//
//                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = zxy.edit();
//
//
//                    if(pc1.equals("LOGIN")) {
//
//
//                        editor.putString("pc11", pc1);
//                        editor.putString("pc22", pc2);
//                        editor.putString("pcn", pcn);
//                        editor.apply();
//                        Toast.makeText(context,"LOGGEDIN msg RECEIVED",Toast.LENGTH_LONG).show();
//                    }
//
//                    SharedPreferences xsxs = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
//
//
//                    if ((pc1.equals("LOGOUT"))&&(senderNum.equals(xsxs.getString("pcn", "")))){
//
//
//                        Toast.makeText(context,"LOGGEDOUT msg RECEIVED",Toast.LENGTH_LONG).show();
//
//                        SharedPreferences xsxsb = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
//
//                        String rcon = xsxsb.getString("pcn", "");
//
//                        SmsManager smss = SmsManager.getDefault();
//                        smss.sendTextMessage(rcon, null, "LOGGEDOUT ( KINDLY CHANGE YOUR PASSCODE FOR SECURITY REASONS)", null, null);
//
//
//                        editor.putString("pc11", "0");
//                        editor.putString("pc22", "0");
//                        editor.putString("pcn", "0");
//
//                        editor.apply();
//                    }
//
//                }
//
//
//
////                if(message.equals("WRONG PASSCODE")){
////                    Toast.makeText(context,"YOU ENTERED WRONG PASSCODE",Toast.LENGTH_LONG).show();
////                }
////
////                if(message.equals("LOGGEDIN")){
////
////                    //for smart_accessom and for smart_controlom
////                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editora = zxy.edit();
////                    editora.putString("nombr", senderNum);
////                    editora.apply();
////
////                    SharedPreferences xxx = context.getSharedPreferences("loginlogout", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editor = xxx.edit();
////                    editor.putString("ll", "LOGGEDIN");
////                    editor.apply();
////
//////                    SharedPreferences xxx1 = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
//////                    SharedPreferences.Editor editor1 = xxx1.edit();
//////                    editor1.putString("ll1", "LOGOUT");
//////                    editor1.apply();
////
////                    Toast.makeText(context,"YOU ARE LOGGED IN",Toast.LENGTH_LONG).show();
////
////                    SharedPreferences xxx1 = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editor1 = xxx1.edit();
////                    editor1.putString("ll1", "LOGOUT");
////                    editor1.apply();
////
////                    Intent k = new Intent(context, Settings.class);
////                    context.startActivity(k);
////
////
////
////                }
////
////
////                if(message.equals("LOGGEDOUT ( KINDLY CHANGE YOUR PASSCODE FOR SECURITY REASONS)")){
////
////                    //for smart_accessom and for smart_controlom
////                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editora = zxy.edit();
////                    editora.putString("nombr", "03469008332");
////                    editora.apply();
////
////
////                    //FOR ACO and SCO buttons
////                    SharedPreferences xxx = context.getSharedPreferences("loginlogout", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editor = xxx.edit();
////                    editor.putString("ll", "LOGGEDOUT");
////                    editor.apply();
////
////                    SharedPreferences xxx1 = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editor1 = xxx1.edit();
////                    editor1.putString("ll1", "LOGIN");
////                    editor1.apply();
////
////                    Toast.makeText(context,"YOU ARE LOGGED OUT",Toast.LENGTH_LONG).show();
////
////                    Intent k = new Intent(context, Settings.class);
////                    context.startActivity(k);
////
////
////                }
//
//                SharedPreferences xxx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = xxx.edit();
//                editor.putString("rco", senderNum);
//                editor.apply();
//
//
//
//
//
//
//                //AURHORIZATION SHIT
//
//                SharedPreferences xz = context.getSharedPreferences("st", Context.MODE_PRIVATE);
//
//                pcs = xz.getString("pc", "");
//
//                SharedPreferences xs = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
//
//                pc11 = xs.getString("pc11", "");
//
//                pc22 = xs.getString("pc22", "");
//
//                pcnn = xs.getString("pcn", "");
//
//                SharedPreferences ab = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
//
//                String iv = ab.getString("i", "");
//
//                if(iv!="1"){
//                SharedPreferences ifam = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
//                SharedPreferences.Editor edo = ifam.edit();
//                edo.putString("i", "0");
//                edo.apply();
//                }
//
//
//                //AUTHORIZATION
//
//
//
//
//
//                if((pc11.equals("LOGIN"))&&(pc22.equals(pcs))&&(pcnn.equals(senderNum))) {
//
//                    SharedPreferences abcz = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
//
//                    String iii = abcz.getString("i", "");
//
//                    if (iii.equals("0")&&(message.contains("@"))){
//
//                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
//
//                        String rcon = xsx.getString("rco", "");
//                        SmsManager smss = SmsManager.getDefault();
//                        smss.sendTextMessage(rcon, null, "LOGGEDIN", null, null);
//
//
//
//
//                        SharedPreferences ifamm = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor edoo = ifamm.edit();
//                        edoo.putString("i", "1");
//                        edoo.apply();
//
//                    }
//
//
//
//
//
//                    SharedPreferences xx = context.getSharedPreferences("sa", Context.MODE_PRIVATE);
//
//                    rm = xx.getString("recentmessages", "");
//                    rc = xx.getString("recentcalls", "");
//
//
//                    if (rm.equals(message)) {
//
//
//                        Toast.makeText(context, "IN RECENT MESSAGES", Toast.LENGTH_SHORT).show();
//
//                        SharedPreferences abc = context.getSharedPreferences("st", Context.MODE_PRIVATE);
//
//                        String rm = abc.getString("rm", "");
//
//                        List<String> sms = new ArrayList<String>();
//                        Uri uriSMSURI = Uri.parse("content://sms/inbox");
//                        Cursor cur = context.getContentResolver().query(uriSMSURI, null, null, null, "date DESC LIMIT " + rm);
//
//                        // int nm= ((cur.getColumnIndex(CallLog.Calls.CACHED_NAME)));
//
//                        while (cur != null && cur.moveToNext()) {
//                            String address = cur.getString(cur.getColumnIndex("address"));
//                            //String nm2=cur.getString((nm));
//                            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
//                            sms.add(" ( Name: " + getContactName(address, context) +
//                                    " ,Number: " + address + " ,Message: " + body + " ) ");
//                        }
//
//                        if (cur != null) {
//                            cur.close();
//                        }
//
//
//                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
//
//                        String rcon = xsx.getString("rco", "");
//
//
//                        Toast.makeText(context, rcon + sms, Toast.LENGTH_LONG).show();
//                        try {
//                            // SmsManager smss = SmsManager.getDefault();
//                            // smss.sendTextMessage(rcon, null, sms.toString(), null, null);
//
//
//                            ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
//                            ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();
//                            PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
//                                    new Intent(context, SmsSentReceiver.class), 0);
//
//                            PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
//                                    new Intent(context, SmsDeliveredReceiver.class), 0);
//                            try {
//                                SmsManager smss = SmsManager.getDefault();
//                                ArrayList<String> mSMSMessage = smss.divideMessage(sms.toString());
//                                for (int i = 0; i < mSMSMessage.size(); i++) {
//                                    sentPendingIntents.add(i, sentPI);
//
//                                    deliveredPendingIntents.add(i, deliveredPI);
//                                }
//                                smss.sendMultipartTextMessage(rcon, null, mSMSMessage,
//                                        sentPendingIntents, deliveredPendingIntents);
//
//                            } catch (Exception e) {
//
//                                e.printStackTrace();
//                                Toast.makeText(context, "SMS sending failed...",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//
//                        } catch (Exception ex) {
//                            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
//                        }
//                        // Intent k = new Intent(context, RecentMessages.class);
//                        //context.startService(k);
//
//                    }
//
//                    if (rc.equals(message)) {
//
//                        Toast.makeText(context, "IN RECENT CALLS", Toast.LENGTH_SHORT).show();
//                        //Intent k = new Intent(context, Vibration.class);
//                        //context.startService(k);
//
//
//                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
//
//                        String rcon = xsx.getString("rco", "");
//                        try {
//
//                            // SmsManager smss = SmsManager.getDefault();
//                            // smss.sendTextMessage(rcon, null, sms.toString(), null, null);
//
//                            Toast.makeText(context, getCallDetails(context), Toast.LENGTH_SHORT).show();
//                            ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
//                            ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();
//                            PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
//                                    new Intent(context, SmsSentReceiver.class), 0);
//
//                            PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
//                                    new Intent(context, SmsDeliveredReceiver.class), 0);
//                            try {
//
//
//                                SmsManager smss = SmsManager.getDefault();
//                                ArrayList<String> mSMSMessage = smss.divideMessage(getCallDetails(context).toString());
//                                for (int i = 0; i < mSMSMessage.size(); i++) {
//                                    sentPendingIntents.add(i, sentPI);
//
//                                    deliveredPendingIntents.add(i, deliveredPI);
//                                }
//
//                                Toast.makeText(context, rcon + getCallDetails(context).toString(),
//                                        Toast.LENGTH_LONG).show();
//
//                                smss.sendMultipartTextMessage(rcon, null, mSMSMessage,
//                                        sentPendingIntents, deliveredPendingIntents);
//
//                            } catch (Exception e) {
//
//                                e.printStackTrace();
//                                Toast.makeText(context, e.toString(),
//                                        Toast.LENGTH_SHORT).show();
//                            }
//
//                        } catch (Exception ex) {
//                            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//
//                   }
//
//                else if((pc11.equals("LOGIN"))&&(pc22!=pcs)&&(message.contains("@"))&&(pcnn.equals(senderNum))){
//
//
//                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
//
//                    String rcon = xsx.getString("rco", "");
//                    SmsManager smss = SmsManager.getDefault();
//                    smss.sendTextMessage(rcon, null, "WRONG PASSCODE", null, null);
//
//                    SharedPreferences ifam = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor edo = ifam.edit();
//                    edo.putString("i", "0");
//                    edo.apply();
//                }
//
////                else {
////
////
////                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
////
////                    String rcon = xsx.getString("rco", "");
////                    SmsManager smss = SmsManager.getDefault();
////                    smss.sendTextMessage(rcon, null, "Akhwa sha System dey ghalat dey", null, null);
////
////                }
//
//            } // bundle is null
//
//        } catch (Exception e) {
//            Log.e("SmsReceiver", "Exception smsReceiver" + e);
//
//        }
//    }
//
//
//
//
//
//
//
//
//
//    public static String getCallDetails(Context context) {
//        StringBuffer stringBuffer = new StringBuffer();
//
//        //Uri.parse("content://call_log/calls")
//        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
//
//            if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_CALL_LOG)){
//                ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.READ_CALL_LOG}, 1);
//            }
//            else {
//                ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.READ_CALL_LOG}, 1);
//            }
//
//
//        }
//
//        String sortOrder = String.format("%s limit 10 ", CallLog.Calls.DATE + " DESC");
//
//        SharedPreferences x = context.getSharedPreferences("st", Context.MODE_PRIVATE);
//
//        String rc = x.getString("rc", "");
//
//        Cursor cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI,
//                null, null, null, "date DESC LIMIT " +rc );
//        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
//        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
//        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
//        int nm= ((cursor.getColumnIndex(CallLog.Calls.CACHED_NAME)));
//
//        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
//        while (cursor.moveToNext()) {
//            String phNumber = cursor.getString(number);
//            String callType = cursor.getString(type);
//            String nm2=cursor.getString((nm));
//            String callDate = cursor.getString(date);
//            Date callDayTime = new Date(Long.valueOf(callDate));
//            String callDuration = cursor.getString(duration);
//            String dir = null;
//            int dircode = Integer.parseInt(callType);
//            switch (dircode) {
//                case CallLog.Calls.OUTGOING_TYPE:
//                    dir = "OUTGOING";
//                    break;
//                case CallLog.Calls.INCOMING_TYPE:
//                    dir = "INCOMING";
//                    break;
//
//                case CallLog.Calls.MISSED_TYPE:
//                    dir = "MISSED";
//                    break;
//            }
//            stringBuffer.append("\nName:-- " + nm2 + "\nPhone Number:-- " + phNumber + " \nCall Type:-- "
//                    + dir + " \nCall Date:-- " + callDayTime
//                    + " \nCall duration in sec :-- " + callDuration);
//            stringBuffer.append("\n-----------------------------");
//        }
//        cursor.close();
//        return stringBuffer.toString();
//    }
//
//
//
//
//
//
//    public String getContactName(final String phoneNumber, Context context)
//    {
//        Uri uri=Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,Uri.encode(phoneNumber));
//
//        String[] projection = new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME};
//
//        String contactName=null;
//        Cursor cursor=context.getContentResolver().query(uri,projection,null,null,null);
//
//        if (cursor != null) {
//            if(cursor.moveToFirst()) {
//                contactName=cursor.getString(0);
//            }
//            cursor.close();
//        }
//        if(contactName==null)
//            contactName = "Unsaved";
//
//        return contactName;
//    }}
//
//
