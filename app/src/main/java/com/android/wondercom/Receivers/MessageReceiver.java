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
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.wondercom.DND;
import com.android.wondercom.DNDOFF;
import com.android.wondercom.Flashligh;
import com.android.wondercom.FlashlighIS;
import com.android.wondercom.Flashlight;
import com.android.wondercom.FlashlightIS;
import com.android.wondercom.GeneralIS;
import com.android.wondercom.LocationS;
import com.android.wondercom.Main2Activity;
import com.android.wondercom.MainActivity;
import com.android.wondercom.MobileMode;
import com.android.wondercom.R;
import com.android.wondercom.RABOFF;
import com.android.wondercom.RABON;
import com.android.wondercom.RecentMessages;
import com.android.wondercom.Settings;
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
    String pc1,pc2,pc11,pc22,pcn,pcnn,pcs,mm, fl1, fl2, mm2, mm3,mm4,mm5,wifi,wifi2,rab,rab2, rm, rc, in, lo,co,messagec,cont,messagen,nam,longi,lati, senderNum, totalBody = "", R5 = "";
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

                if(message.contains("@")){

                    StringTokenizer tokens = new StringTokenizer(message, "@");
                    pc1 = tokens.nextToken();
                    pc2 = tokens.nextToken();
                    pcn = senderNum;

//                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = zxy.edit();


                    if(pc1.equals("LOGIN")) {
                        SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = zxy.edit();

                        editor.putString("pc11", pc1);
                        editor.putString("pc22", pc2);
                        editor.putString("pcn", pcn);
                        editor.apply();
                        Toast.makeText(context,"LOGIN msg RECEIVED",Toast.LENGTH_LONG).show();
                    }

                    if(pc1.equals("LOGOUT")) {

                        SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = zxy.edit();
                        editor.putString("pc11", pc1);
                        editor.putString("pc22", pc2);
                        editor.putString("pcn", pcn);
                        editor.apply();
                        Toast.makeText(context,"LOGOUT msg RECEIVED",Toast.LENGTH_LONG).show();
                    }

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
//                        smss.sendTextMessage(rcon, null, "LOGGEDOUT ( KINDLY CHANGE YOUR PASSCODE FOR SECURITY REASONS)",null , null);
//
//                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = zxy.edit();

//
//                        editor.putString("pc11", "0");
//                        editor.putString("pc22", "0");
//                        editor.putString("pcn", "0");
//
//                        editor.apply();
//                    }

                }

                if(message.contains(".")){

                    StringTokenizer tokens = new StringTokenizer(message, ".");
                     messagec = tokens.nextToken();
                     cont = tokens.nextToken();

                }

                if(message.contains(":")){

                    StringTokenizer tokens = new StringTokenizer(message, ":");
                    messagen = tokens.nextToken();
                    nam = tokens.nextToken();

                }

                if(message.equals("WRONG PASSCODE")){
                    Toast.makeText(context,"YOU ENTERED WRONG PASSCODE",Toast.LENGTH_LONG).show();
                }

                if(message.equals("LOGGEDIN")){

                    //for smart_accessom and for smart_controlom
                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editora = zxy.edit();
                    editora.putString("nombr", senderNum);
                    editora.apply();

                    SharedPreferences xxx = context.getSharedPreferences("loginlogout", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = xxx.edit();
                    editor.putString("ll", "LOGGEDIN");
                    editor.apply();

//                    SharedPreferences xxx1 = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor1 = xxx1.edit();
//                    editor1.putString("ll1", "LOGOUT");
//                    editor1.apply();




                    SharedPreferences xxx1 = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = xxx1.edit();
                    editor1.putString("ll1", "LOGOUT");
                    editor1.apply();

                    Toast.makeText(context,"YOU ARE LOGGED IN",Toast.LENGTH_LONG).show();

                    SharedPreferences xn = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editorn = xn.edit();
                    editorn.putString("nmr", senderNum);
                    editorn.apply();
//
//                    Intent k2 = new Intent(context, MainActivity.class);
//                    context.startActivity(k2);






                    Intent k = new Intent(context, Main2Activity.class);
                    context.startActivity(k);





                }


                if(message.equals("LOGGEDOUT ( KINDLY CHANGE YOUR PASSCODE FOR SECURITY REASONS)")){

                    //for smart_accessom and for smart_controlom
                    SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editora = zxy.edit();
                    editora.putString("nombr", "03469008332");
                    editora.apply();


                    //FOR ACO and SCO buttons
                    SharedPreferences xxx = context.getSharedPreferences("loginlogout", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = xxx.edit();
                    editor.putString("ll", "LOGGEDOUT");
                    editor.apply();

                    SharedPreferences xxx1 = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = xxx1.edit();
                    editor1.putString("ll1", "LOGIN");
                    editor1.apply();

                    Toast.makeText(context,"YOU ARE LOGGED OUT",Toast.LENGTH_LONG).show();

                    SharedPreferences xn = context.getSharedPreferences("ll", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editorn = xn.edit();
                    editorn.putString("nmr", "");
                    editorn.apply();



                //    Toast.makeText(context,"YOU ARE LOGGED OUT",Toast.LENGTH_LONG).show();
//
//                    Intent k2 = new Intent(context, MainActivity.class);
//                    context.startActivity(k2);

                    Intent k = new Intent(context, Main2Activity.class);
                    context.startActivity(k);



                   // LOGIN
//                    SharedPreferences xl = context.getSharedPreferences("st", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editorx = xl.edit();
//                    editorx.putString(senderNum, "ENTER NUMBER FROM WHERE YOU WANT TO LOGGOUT");
//                    editorx.apply();

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



                //AURHORIZATION SHIT

                SharedPreferences xz = context.getSharedPreferences("st", Context.MODE_PRIVATE);

                pcs = xz.getString("pc", "");

                SharedPreferences xs = context.getSharedPreferences("pco", Context.MODE_PRIVATE);

                pc11 = xs.getString("pc11", "");

                pc22 = xs.getString("pc22", "");

                pcnn = xs.getString("pcn", "");

                SharedPreferences ab = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);

                String iv = ab.getString("i", "");


                //if(iv!="1")

                if(!iv.equals("1")){
                SharedPreferences ifam = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
                SharedPreferences.Editor edo = ifam.edit();
                edo.putString("i", "0");
                edo.apply();
                }


                //AUTHORIZATION





                if((pc11.equals("LOGIN"))&&(pc22.equals(pcs))&&(pcnn.equals(senderNum))) {

                    SharedPreferences abcz = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);

                    String iii = abcz.getString("i", "");
//
                    if (iii.equals("0")&&(message.contains("@"))){



                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                        String rcon = xsx.getString("rco", "");
                        SmsManager smss = SmsManager.getDefault();
                        smss.sendTextMessage(rcon, null, "LOGGEDIN", null, null);




                        SharedPreferences ifamm = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edoo = ifamm.edit();
                        edoo.putString("i", "1");
                        edoo.apply();

                    }

                    if (message.equals("Unsaved")){
                        Toast.makeText(context, "Contact is unsaved.", Toast.LENGTH_SHORT).show();
                    }

                    if (message.equals("HELP007")){
                        Toast.makeText(context, "HELP", Toast.LENGTH_SHORT).show();


                        try {


                            String sms=       "CODE : DOING ," +
                                    " LOGIN@PASSCODE : For logging in , LOGOUT@PASSCODE : For logging out , HELP007 : FOR ALL CODES , " +
                                    "GENERAL : For General mode , SILENT : For Silent mode , VIBRATION : For Vibration mode , DND : For activating do not disturb , " +
                                    "DNDOFF : For deactivating do not disturb , FLASHLIGHTON : For turning on flashlight , FLASHLIGHTOFF : For turning off flashlight , " +
                                    "WIFION : For turning on WiFi , WIFIOFF : For turing off WiFi , RAPON : Ring a phone , RAPOFF : Ring a phone , " +
                                    "RECENTMESSAGES : For acquiring recent messages , RECENTCALLS : For acquiring recent calls , IMEINUMBER : For acquiring IMEI Number ," +
                                    "LOCATION : For acquiring location coordinates , CONTACTS.NUMBER : For acquiring name of this NUMBER from phonebook , " +
                                    "CONTACTS:NAME : For acquiring number of this NAME from phonebook. ";



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
                                smss.sendMultipartTextMessage(senderNum, null, mSMSMessage,
                                        sentPendingIntents, deliveredPendingIntents);

                                Toast.makeText(context, mSMSMessage.toString(), Toast.LENGTH_SHORT).show();

                            } catch (Exception e) {

                                e.printStackTrace();
                                Toast.makeText(context, "SMS sending failed...",
                                        Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception ex) {
                            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
                        }





                    }


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
                        Intent k = new Intent(context, RABOFF.class);
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

                        SharedPreferences abc = context.getSharedPreferences("st", Context.MODE_PRIVATE);

                        String rm = abc.getString("rm", "");

                        List<String> sms = new ArrayList<String>();
                        Uri uriSMSURI = Uri.parse("content://sms/inbox");
                        Cursor cur = context.getContentResolver().query(uriSMSURI, null, null, null, "date DESC LIMIT " + rm);

                        // int nm= ((cur.getColumnIndex(CallLog.Calls.CACHED_NAME)));

                        while (cur != null && cur.moveToNext()) {
                            String address = cur.getString(cur.getColumnIndex("address"));
                            //String nm2=cur.getString((nm));
                            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
                            sms.add(" ( Name: " + getContactName(address, context) +
                                    " ,Number: " + address + " ,Message: " + body + " ) ");
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

                        SharedPreferences xzz = context.getSharedPreferences("lo", Context.MODE_PRIVATE);
                        String loc = xzz.getString("loco", "");


                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
                        String rcon = xsx.getString("rco", "");

                        SmsManager smss = SmsManager.getDefault();
                        smss.sendTextMessage(rcon, null, loc, null, null);


                    }

                    if ((co.equals(messagec)) && (cont != null)) {


                        Toast.makeText(context, "IN IF STATEMENT OF CONTACTS", Toast.LENGTH_SHORT).show();
                        // Intent l = new Intent(context, Flashlight.class);
                        // context.startService(l);

                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                        String rcon = xsx.getString("rco", "");
                        SmsManager smss = SmsManager.getDefault();
                        smss.sendTextMessage(rcon, null, getPhoneNumber(cont, context).toString(), null, null);


                    } else if ((co.equals(messagen)) && (nam != null)) {


                        Toast.makeText(context, "IN IF STATEMENT OF CONTACTS", Toast.LENGTH_SHORT).show();
                        // Intent l = new Intent(context, Flashlight.class);
                        // context.startService(l);

                        SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                        String rcon = xsx.getString("rco", "");
                        SmsManager smss = SmsManager.getDefault();
                        smss.sendTextMessage(rcon, null, getContactName(nam, context).toString(), null, null);


                    }
                }

                else if((pc11.equals("LOGIN"))&&(pc22!=pcs)&&(message.contains("@"))&&(pcnn.equals(senderNum))){


                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);

                    Toast.makeText(context,"WRONGPC msg SENT",Toast.LENGTH_LONG).show();

                    String rcon = xsx.getString("rco", "");
                    SmsManager smss = SmsManager.getDefault();
                    smss.sendTextMessage(rcon, null, "WRONG PASSCODE", null, null);

                    SharedPreferences ifam = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edo = ifam.edit();
                    edo.putString("i", "0");
                    edo.apply();
                }

                //&&(pcnn.equals(senderNum))

                  else  if((pc11.equals("LOGOUT"))&&(pc22.equals(pcs))&&(message.contains("@")))
                  {

                      SharedPreferences zxy = context.getSharedPreferences("pco", Context.MODE_PRIVATE);
                      SharedPreferences.Editor editors = zxy.edit();

                      editors.putString("pc11", "0");
                      editors.putString("pc22", "0");
                      editors.putString("pcn", "0");

                      editors.apply();


                      SharedPreferences ifamm = context.getSharedPreferences("ifm", Context.MODE_PRIVATE);
                      SharedPreferences.Editor edoo = ifamm.edit();
                      edoo.putString("i", "0");
                      edoo.apply();

                      //
                        Toast.makeText(context,"LOGGEDOUT msg SENT",Toast.LENGTH_LONG).show();

                        SharedPreferences xsxsb = context.getSharedPreferences("pco", Context.MODE_PRIVATE);

                        String rcon = xsxsb.getString("pcn", "");

                        SmsManager smss = SmsManager.getDefault();
                        smss.sendTextMessage(senderNum, null, "LOGGEDOUT ( KINDLY CHANGE YOUR PASSCODE FOR SECURITY REASONS)",null , null);




                }

//                else {
//
//
//                    SharedPreferences xsx = context.getSharedPreferences("rcon", Context.MODE_PRIVATE);
//
//                    String rcon = xsx.getString("rco", "");
//                    SmsManager smss = SmsManager.getDefault();
//                    smss.sendTextMessage(rcon, null, "Akhwa sha System dey ghalat dey", null, null);
//
//                }

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

        SharedPreferences x = context.getSharedPreferences("st", Context.MODE_PRIVATE);

        String rc = x.getString("rc", "");

        Cursor cursor = context.getContentResolver().query(android.provider.CallLog.Calls.CONTENT_URI,
                null, null, null, "date DESC LIMIT " +rc );
        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
        int nm= ((cursor.getColumnIndex(CallLog.Calls.CACHED_NAME)));

        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        while (cursor.moveToNext()) {
            String phNumber = cursor.getString(number);
            String callType = cursor.getString(type);
            String nm2=cursor.getString((nm));
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
            stringBuffer.append("\nName:-- " + nm2 + "\nPhone Number:-- " + phNumber + " \nCall Type:-- "
                    + dir + " \nCall Date:-- " + callDayTime
                    + " \nCall duration in sec :-- " + callDuration);
            stringBuffer.append("\n-----------------------------");
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

        String contactName=null;
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

