package com.android.wondercom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class ACO extends Activity {

    CardView c1,c2;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aco);

        getActionBar().setTitle("   Smart Access");


        getActionBar().setHomeAsUpIndicator(R.drawable.back);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        c1=(CardView)findViewById(R.id.sf);
        c2=(CardView)findViewById(R.id.sf2);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(getApplicationContext(),SmartAccess.class);
                startActivity(i);

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences x = getApplicationContext().getSharedPreferences("loginlogout", Context.MODE_PRIVATE);

                String mm = x.getString("ll", "");

                if(mm.equals("LOGGEDIN")){
                    Intent i;
                    i = new Intent(getApplicationContext(),SmartAccessOM.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"KINDLY FIRST LOGIN FROM SETTINGS",Toast.LENGTH_LONG).show();



            }
        });
    }


}
