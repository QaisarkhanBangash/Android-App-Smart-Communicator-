package com.android.wondercom;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class SmartControlOM extends Activity {

String rcon;
    Spinner s,s1,s2,s3,s4,s5;
    ImageView i1,i2,i3,i4,i5;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_controlom);

        try {

            getActionBar().setTitle("   Control Your Smartphone");


            getActionBar().setHomeAsUpIndicator(R.drawable.back);
            getActionBar().setHomeButtonEnabled(true);
            getActionBar().setDisplayHomeAsUpEnabled(true);


        s=(Spinner)findViewById(R.id.spinner);
        s1=(Spinner)findViewById(R.id.spinner2);
        s2=(Spinner)findViewById(R.id.spinner3);
        s3=(Spinner)findViewById(R.id.spinner4);

            i1=(ImageView)findViewById(R.id.imageView2);
            i2=(ImageView)findViewById(R.id.imageView3);
            i3=(ImageView)findViewById(R.id.imageView4);
            i4=(ImageView)findViewById(R.id.imageView5);


            i1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(SmartControlOM.this,InfooSC5.class);
                    startActivity(i);
                }
            });

            i2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(SmartControlOM.this,InfooSC6.class);
                    startActivity(i);
                }
            });


            i3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(SmartControlOM.this,InfooSC7.class);
                    startActivity(i);
                }
            });


            i4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(SmartControlOM.this,InfooSC8.class);
                    startActivity(i);
                }
            });



            String arr[]={"SET","GENERAL","VIBRATION","SILENT","DO NOT DISTURB"};

        String arr1[]={"SET","ON","OFF"};

        String arr2[]={"SET","ON","OFF"};

        String arr3[]={"SET","ON","OFF"};

        String arr4[]={"","1","2","3","4"};

        String arr5[]={"","1","2","3","4"};


        ArrayAdapter<String> aa=new ArrayAdapter<String>(SmartControlOM.this,android.R.layout.simple_spinner_item,arr);

        s.setAdapter(aa);

        ArrayAdapter<String> aa1=new ArrayAdapter<String>(SmartControlOM.this,android.R.layout.simple_spinner_item,arr1);

        s1.setAdapter(aa1);

        ArrayAdapter<String> aa2=new ArrayAdapter<String>(SmartControlOM.this,android.R.layout.simple_spinner_item,arr2);

        s2.setAdapter(aa2);

        ArrayAdapter<String> aa3=new ArrayAdapter<String>(SmartControlOM.this,android.R.layout.simple_spinner_item,arr3);

        s3.setAdapter(aa3);








     s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


             switch (position){

                 case 0:

                     break;
                 case 1:

                     //FOR GENERAL
                     SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'GENERAL' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss = SmsManager.getDefault();
                     smss.sendTextMessage(rcon, null, "GENERAL", null, null);

                 break;

                 case 2:

                     //FOR VIBRATION
                     SharedPreferences xsxsb = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'VIBRATION' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss2 = SmsManager.getDefault();
                     smss2.sendTextMessage(rcon, null, "VIBRATION", null, null);

                     break;

                 case 3:

                     //FOR SILENT
                     SharedPreferences xsxsb11 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb11.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'SILENT' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss3 = SmsManager.getDefault();
                     smss3.sendTextMessage(rcon, null, "SILENT", null, null);


                 break;

                 case 4:

                     //FOR DND
                     SharedPreferences xsx = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsx.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'DO NOT DISTURB' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss4 = SmsManager.getDefault();
                     smss4.sendTextMessage(rcon, null, "DND", null, null);

                     break;




             }

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });


     s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


             switch (position){

                 case 0:

                     break;
                 case 1:

                     //FOR TURNING ON FLASHLIGHT
                     SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'FLASHLIGHTON' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss3 = SmsManager.getDefault();
                     smss3.sendTextMessage(rcon, null, "FLASHLIGHTON", null, null);
                     break;

                 case 2:

                     //FOR TURNING OFF FLASHLIGHT
                     SharedPreferences x1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = x1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'FLASHLIGHTOFF' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss4 = SmsManager.getDefault();
                     smss4.sendTextMessage(rcon, null, "FLASHLIGHTOFF", null, null);

                     break;






             }

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });


     s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


             switch (position){

                 case 0:

                     break;
                 case 1:
                     //FOR TURNING ON WIFI
                     SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'WIFION' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss3 = SmsManager.getDefault();
                     smss3.sendTextMessage(rcon, null, "WIFION", null, null);
                     break;



                 case 2:

                     //FOR TURNING OFF WIFI
                     SharedPreferences sb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = sb1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'WIFIOFF' COMMAND..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss4 = SmsManager.getDefault();
                     smss4.sendTextMessage(rcon, null, "WIFIOFF", null, null);

                     break;





             }

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });


     s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


             switch (position){

                 case 0:

                     break;
                 case 1:

                     //FOR RINGING PHONE
                     SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'RAPON' COMMAND TO TURN ON RINGING ..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss3 = SmsManager.getDefault();
                     smss3.sendTextMessage(rcon, null, "RAPON", null, null);
                     break;

                 case 2:

                     //FOR RINGING OFF PHONE
                     SharedPreferences b1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = b1.getString("nombr", "");

                     Toast.makeText(SmartControlOM.this, "SENDING 'RAPOFF' COMMAND TO TURN OFF RINGING ..." , Toast.LENGTH_SHORT).show();

                     SmsManager smss4 = SmsManager.getDefault();
                     smss4.sendTextMessage(rcon, null, "RAPOFF", null, null);

                     break;






             }

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });





 }
 catch ( Exception e){

     Toast.makeText(SmartControlOM.this,e.toString(), Toast.LENGTH_LONG).show();
 }

    }


}
