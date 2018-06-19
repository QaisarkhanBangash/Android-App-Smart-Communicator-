package com.android.wondercom;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SmartControl extends Activity {

    ToggleButton t1,t2,t3,t4;

    String mm,fl1,wfi,rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_control);

        t1=(ToggleButton)findViewById(R.id.toggleButton);

        t2=(ToggleButton)findViewById(R.id.toggleButton2);

        t3=(ToggleButton)findViewById(R.id.toggleButton3);

        t4=(ToggleButton)findViewById(R.id.toggleButton4);


 try {

//     SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
//     SharedPreferences.Editor editor = x.edit();
//     editor.putString("mobilemode", "elso");
//     editor.putString("flashlight1", "elso");
//     editor.apply();
// boolean chk1 = prefs.contains("mobilemode");
     //boolean chk2 = prefs.contains("flashlight1");


    //if()
     SharedPreferences prefs = getSharedPreferences("sco", MODE_PRIVATE);
    // if (contains(mm)==true) "" DOuble quotes helped
      mm = prefs.getString("mobilemode","");
     //if (contains(mm)==true)
      fl1 = prefs.getString("flashlight1", "");

     wfi = prefs.getString("wifi", "");

     rb = prefs.getString("rab", "");



  //   Toast.makeText(SmartControl.this, mm.toString(), Toast.LENGTH_SHORT).show();
     if (mm.equals("GENERAL")) {
         t1.setChecked(true);
         Toast.makeText(SmartControl.this, "I M IN MM", Toast.LENGTH_SHORT).show();
     }

   //  Toast.makeText(SmartControl.this, fl1.toString(), Toast.LENGTH_SHORT).show();
     if (fl1.equals("FLASHLIGHTON")) {
         t2.setChecked(true);
         Toast.makeText(SmartControl.this, "I M IN FLSHLIGHT", Toast.LENGTH_SHORT).show();
     }

     if (wfi.equals("WIFION")) {
         t3.setChecked(true);
         Toast.makeText(SmartControl.this, "I M IN WIFION" , Toast.LENGTH_SHORT).show();
     }

     if (rb.equals("RABON")) {
         t4.setChecked(true);
         Toast.makeText(SmartControl.this, "I M IN RABOn", Toast.LENGTH_SHORT).show();
     }




     t1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (t1.isChecked() == (true)) {

                 NotificationManager notificationManager =
                         (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                         && !notificationManager.isNotificationPolicyAccessGranted()) {

                     Intent intent = new Intent(
                             android.provider.Settings
                                     .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

                     startActivity(intent);
                 }

                 Toast.makeText(SmartControl.this, "t1 is Checked", Toast.LENGTH_SHORT).show();

                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();
                 editor.putString("mobilemode", "GENERAL");
                 editor.putString("mobilemode2", "VIBRATION");
                 editor.putString("mobilemode3", "SILENT");
                 editor.putString("mobilemode4", "DND");
                 editor.putString("mobilemode5", "DNDOFF");
                 editor.apply();
                 String mm = x.getString("mobilemode", "");
                 Toast.makeText(SmartControl.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

             } else if (t1.isChecked() == (false)) {

                 Toast.makeText(SmartControl.this, "t1 isn't Checked", Toast.LENGTH_SHORT).show();
                 //  editor.putString("first", "###");

                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();
                 editor.putString("mobilemode", "elso");
                 editor.putString("mobilemode2", "elso");
                 editor.putString("mobilemode3", "elso");
                 editor.putString("mobilemode4", "elso");
                 editor.putString("mobilemode5", "elso");
                 editor.apply();

             }



         }
     });


     t2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (t2.isChecked() == (true)) {
                 Toast.makeText(SmartControl.this, "t2 is Checked", Toast.LENGTH_SHORT).show();
                 //For Normal mode
                 //  am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);


                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();
                 editor.putString("flashlight1", "FLASHLIGHTON");
                 editor.putString("flashlight2", "FLASHLIGHTOFF");
                 editor.apply();


             } else if (t2.isChecked() == (false)) {

                 Toast.makeText(SmartControl.this, "t2 isn't Checked", Toast.LENGTH_SHORT).show();
                 //  editor.putString("first", "###");

                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();

                 editor.putString("flashlight1", "elso");
                 editor.putString("flashlight2", "elso");
                 editor.apply();

             }
         }
     });

     t3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (t3.isChecked() == (true)) {
                 Toast.makeText(SmartControl.this, "t3 is Checked", Toast.LENGTH_SHORT).show();
                 //For Normal mode
                 //  am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);


                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();
                 editor.putString("wifi", "WIFION");
                 editor.putString("wifi2", "WIFIOFF");
                 editor.apply();


             } else if (t3.isChecked() == (false)) {

                 Toast.makeText(SmartControl.this, "t3 isn't Checked", Toast.LENGTH_SHORT).show();
                 //  editor.putString("first", "###");

                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();

                 editor.putString("wifi", "elso");
                 editor.putString("wifi2", "elso");
                 editor.apply();

             }
         }
     });

     t4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (t4.isChecked() == (true)) {
                 Toast.makeText(SmartControl.this, "t4 is Checked", Toast.LENGTH_SHORT).show();
                 //For Normal mode
                 //  am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);


                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();
                 editor.putString("rab", "RABON");
                 editor.putString("rab2", "RABOFF");
                 editor.apply();


             } else if (t4.isChecked() == (false)) {

                 Toast.makeText(SmartControl.this, "t4 isn't Checked", Toast.LENGTH_SHORT).show();
                 //  editor.putString("first", "###");

                 SharedPreferences x = getSharedPreferences("sco", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = x.edit();

                 editor.putString("rab", "elso");
                 editor.putString("rab2", "elso");
                 editor.apply();

             }
         }
     });

 }
 catch ( Exception e){

     Toast.makeText(SmartControl.this,e.toString(), Toast.LENGTH_SHORT).show();
 }

    }


}
