package com.android.wondercom;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Date;

public class SmartAccess extends Activity {

    ToggleButton t1,t2,t3,t4,t5;
    String rm,rc,in,lo,co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_access);

try {
    t1 = (ToggleButton) findViewById(R.id.toggleButton);
    t2 = (ToggleButton) findViewById(R.id.toggleButton2);
    t3 = (ToggleButton) findViewById(R.id.toggleButton3);
    t4 = (ToggleButton) findViewById(R.id.toggleButton4);
    t5 = (ToggleButton) findViewById(R.id.toggleButton5);


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

                Toast.makeText(SmartAccess.this, "t1 is Checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("recentmessages", "RECENTMESSAGES");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t1.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "t1 isn't Checked", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(SmartAccess.this, "t2 is Checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("recentcalls", "RECENTCALLS");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();



            } else if (t2.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "t2 isn't Checked", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(SmartAccess.this, "t3 is Checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("imeinumber", "IMEINUMBER");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t3.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "t3 isn't Checked", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(SmartAccess.this, "t4 is Checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("location", "LOCATION");
                editor.apply();

                Intent myIntent = new Intent(v.getContext(), LocationSS.class);
                startService(myIntent);
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t4.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "t4 isn't Checked", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(SmartAccess.this, "t5 is Checked", Toast.LENGTH_SHORT).show();

                SharedPreferences x = getSharedPreferences("sa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = x.edit();
                editor.putString("contacts", "CONTACTS");
                editor.apply();
                //    String mm = x.getString("mobilemode", "");
                //  Toast.makeText(SmartAccess.this, mm + "IN Button", Toast.LENGTH_SHORT).show();

            } else if (t5.isChecked() == (false)) {

                Toast.makeText(SmartAccess.this, "t5 isn't Checked", Toast.LENGTH_SHORT).show();
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




}
