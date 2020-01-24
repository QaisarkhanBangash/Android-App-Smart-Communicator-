package com.android.wondercom;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Date;

public class SmartAccess extends Activity {

    ToggleButton t1,t2,t3,t4,t5;
    String rm,rc,in,lo,co;
    ImageView i1,i2,i3,i4,i5;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_access);

try {

    getActionBar().setTitle("   Set Access Features");
    getActionBar().setHomeAsUpIndicator(R.drawable.back);
    getActionBar().setHomeButtonEnabled(true);
    getActionBar().setDisplayHomeAsUpEnabled(true);

    t1 = (ToggleButton) findViewById(R.id.toggleButton);
    t2 = (ToggleButton) findViewById(R.id.toggleButton2);
    t3 = (ToggleButton) findViewById(R.id.toggleButton3);
    t4 = (ToggleButton) findViewById(R.id.toggleButton4);
    t5 = (ToggleButton) findViewById(R.id.toggleButton5);

    i1=(ImageView)findViewById(R.id.imageView2);
    i2=(ImageView)findViewById(R.id.imageView3);
    i3=(ImageView)findViewById(R.id.imageView1);
    i4=(ImageView)findViewById(R.id.imageView4);
    i5=(ImageView)findViewById(R.id.imageView5);

    i1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccess.this,InfooSA1.class);
            startActivity(i);
        }
    });

    i2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccess.this,InfooSA2.class);
            startActivity(i);
        }
    });


    i3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccess.this,InfooSA3.class);
            startActivity(i);
        }
    });


    i4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccess.this,InfooSA4.class);
            startActivity(i);
        }
    });


    i5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccess.this,InfooSA5.class);
            startActivity(i);
        }
    });




    SharedPreferences prefs = getSharedPreferences("sa", MODE_PRIVATE);

    rm = prefs.getString("recentmessages", "");

    rc = prefs.getString("recentcalls", "");

    in = prefs.getString("imeinumber", "");

    lo = prefs.getString("location", "");

    co = prefs.getString("contacts", "");


    if (rm.equals("RECENTMESSAGES")) {
        t1.setChecked(true);
        Toast.makeText(SmartAccess.this, "I M IN RCENT MSGS TRUE", Toast.LENGTH_SHORT).show();
    }


    if (rc.equals("RECENTCALLS")) {
        t2.setChecked(true);
        Toast.makeText(SmartAccess.this, "I M IN RCENT CALLS TRUE", Toast.LENGTH_SHORT).show();
    }

    if (in.equals("IMEINUMBER")) {
        t3.setChecked(true);
        Toast.makeText(SmartAccess.this, "I M IN RCENT CALLS TRUE", Toast.LENGTH_SHORT).show();
    }


    if (lo.equals("LOCATION")) {
        t4.setChecked(true);
        Toast.makeText(SmartAccess.this, "I M IN RCENT CALLS TRUE", Toast.LENGTH_SHORT).show();
    }

    if (co.equals("CONTACTS")) {
        t5.setChecked(true);
        Toast.makeText(SmartAccess.this, "I M IN RCENT CALLS TRUE", Toast.LENGTH_SHORT).show();
    }

    t1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t1.isChecked() == (true)) {

                Toast.makeText(SmartAccess.this, "RECENT MESSAGES toggle button is checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("recentmessages", "RECENTMESSAGES");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t1.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "RECENT MESSAGES toggle button is unchecked", Toast.LENGTH_SHORT).show();
                //  editor.putString("first", "###");

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("recentmessages", "elso");

                editor.apply();

            }


        }
    });


    t2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t2.isChecked() == (true)) {

                Toast.makeText(SmartAccess.this, "RECENT CALLS toggle button is checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("recentcalls", "RECENTCALLS");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();



            } else if (t2.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "RECENT CALLS toggle button is unchecked", Toast.LENGTH_SHORT).show();
                //  editor.putString("first", "###");

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("recentcalls", "elso");

                editor.apply();

            }


        }
    });


    t3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t3.isChecked() == (true)) {

                Toast.makeText(SmartAccess.this, "IMEI NUMBER toggle button is checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("imeinumber", "IMEINUMBER");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t3.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "IMEI NUMBER toggle button is unchecked", Toast.LENGTH_SHORT).show();
                //  editor.putString("first", "###");

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("imeinumber", "elso");

                editor.apply();

            }


        }
    });


    t4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t4.isChecked() == (true)) {

                Toast.makeText(SmartAccess.this, "LOCATION toggle button is checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("location", "LOCATION");
                editor.apply();


                statusCheck();

                
                Intent myIntent = new Intent(v.getContext(), LocationSS.class);
                startService(myIntent);
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t4.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "LOCATION toggle button is unchecked", Toast.LENGTH_SHORT).show();
                //  editor.putString("first", "###");

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("location", "elso");

                editor.apply();
                Intent myIntent = new Intent(v.getContext(), LocationSS.class);
                stopService(myIntent);

            }


        }
    });


    t5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t5.isChecked() == (true)) {

                Toast.makeText(SmartAccess.this, "CONTACTS toggle button is checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("contacts", "CONTACTS");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t5.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "CONTACTS toggle button is unchecked", Toast.LENGTH_SHORT).show();
                //  editor.putString("first", "###");

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("contacts", "elso");

                editor.apply();

            }


        }
    });

}
catch (Exception e){

    Toast.makeText(SmartAccess.this,e.toString(),Toast.LENGTH_SHORT);
}

    }


    public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

}
