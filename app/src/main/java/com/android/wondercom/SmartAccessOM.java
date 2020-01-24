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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SmartAccessOM extends Activity {

    Spinner s;
    Button b1,b2,b3,b4;
    EditText editText;
    ImageView i1,i2,i3,i4,i5;
    String rcon;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_accessom);

try {


    getActionBar().setTitle("   Access Your Smartphone");
    getActionBar().setHomeAsUpIndicator(R.drawable.back);
    getActionBar().setHomeButtonEnabled(true);
    getActionBar().setDisplayHomeAsUpEnabled(true);


    s=(Spinner)findViewById(R.id.spinner5);
    editText=(EditText)findViewById(R.id.editText2);

    b1=(Button)findViewById(R.id.button1);
    b2=(Button)findViewById(R.id.button2);
    b3=(Button)findViewById(R.id.button3);
    b4=(Button)findViewById(R.id.button4);

    i1=(ImageView)findViewById(R.id.imageView5);
    i2=(ImageView)findViewById(R.id.imageView3);
    i3=(ImageView)findViewById(R.id.imageView1);
    i4=(ImageView)findViewById(R.id.imageView4);
    i5=(ImageView)findViewById(R.id.imageView2);

    i1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccessOM.this,InfooSA6.class);
            startActivity(i);
        }
    });

    i2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccessOM.this,InfooSA7.class);
            startActivity(i);
        }
    });


    i3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccessOM.this,InfooSA8.class);
            startActivity(i);
        }
    });


    i4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccessOM.this,InfooSA9.class);
            startActivity(i);
        }
    });


    i5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            i=new Intent(SmartAccessOM.this,InfooSA10.class);
            startActivity(i);
        }
    });




    String arr[]={"SET","Number","Name"};

    ArrayAdapter<String> aa=new ArrayAdapter<String>(SmartAccessOM.this,android.R.layout.simple_spinner_item,arr);

    s.setAdapter(aa);

    s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            switch (position){

                case 0:

                    break;
                case 1:
                    //FOR CONTACT NUMBER
                    SharedPreferences xsxsb = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb.getString("nombr", "");

                    Toast.makeText(SmartAccessOM.this, "SENDING 'CONTACTS.' COMMAND TO GET CONTACT NUMBER ..." , Toast.LENGTH_SHORT).show();


                    SmsManager smss3 = SmsManager.getDefault();
                    smss3.sendTextMessage(rcon, null,"CONTACTS."+ editText.getText().toString(), null, null);
                    break;

                case 2:

                    //FOR CONTACT NAME
                    SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

                     rcon = xsxsb1.getString("nombr", "");

                    Toast.makeText(SmartAccessOM.this, "SENDING 'CONTACTS:' COMMAND TO GET CONTACT NAME ..." , Toast.LENGTH_SHORT).show();


                    SmsManager smss4 = SmsManager.getDefault();
                    smss4.sendTextMessage(rcon, null, "CONTACTS:"+editText.getText().toString(), null, null);


                    break;

            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });



    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //FOR RECENT CALLS
            SharedPreferences xsxsb = getSharedPreferences("pco", Context.MODE_PRIVATE);

            rcon = xsxsb.getString("nombr", "");

            Toast.makeText(SmartAccessOM.this, "SENDING 'RECENTCALLS' COMMAND TO GET RECENT CALLS ..." , Toast.LENGTH_SHORT).show();


            SmsManager smss3 = SmsManager.getDefault();
            smss3.sendTextMessage(rcon, null, "RECENTCALLS", null, null);

        }
    });

    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //FOR IMEI NUMBER
            SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

            rcon = xsxsb1.getString("nombr", "");

            Toast.makeText(SmartAccessOM.this, "SENDING 'IMEINUMBER' COMMAND TO GET IMEI NUMBER ..." , Toast.LENGTH_SHORT).show();


            SmsManager smss3 = SmsManager.getDefault();
            smss3.sendTextMessage(rcon, null, "IMEINUMBER", null, null);

        }
    });

    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //FOR LOCATION
            SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

            rcon = xsxsb1.getString("nombr", "");

            Toast.makeText(SmartAccessOM.this, "SENDING 'LOCATION' COMMAND TO GET LOCATION COORDINATES ..." , Toast.LENGTH_SHORT).show();


            SmsManager smss3 = SmsManager.getDefault();
            smss3.sendTextMessage(rcon, null, "LOCATION", null, null);


        }
    });

    b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            //FOR RECENT MESSAGES
            SharedPreferences xsxsb1 = getSharedPreferences("pco", Context.MODE_PRIVATE);

            rcon = xsxsb1.getString("nombr", "");

            Toast.makeText(SmartAccessOM.this, "SENDING 'RECENTMESSAGES' COMMAND TO GET RECENTMESSAGES ..." , Toast.LENGTH_SHORT).show();


            SmsManager smss3 = SmsManager.getDefault();
            smss3.sendTextMessage(rcon, null, "RECENTMESSAGES", null, null);

        }
    });
}
catch (Exception e){

    Toast.makeText(SmartAccessOM.this,e.toString(),Toast.LENGTH_SHORT);
}

    }




}
