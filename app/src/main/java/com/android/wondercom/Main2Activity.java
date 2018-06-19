package com.android.wondercom;

import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    CardView cvc2,cvsc,cvsay,cva;
    ImageView k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences.Editor editor = getSharedPreferences("f1", MODE_PRIVATE).edit();
        editor.putString("f", "second");
        editor.commit();

        cvc2 =(CardView)findViewById(R.id.cvc2);
        cvsc =(CardView)findViewById(R.id.scc);
        cvsay =(CardView)findViewById(R.id.cvsa);

        cva =(CardView)findViewById(R.id.cva);
      //  k=(ImageView)findViewById(R.id.imageView7);

        		try {



        		    cvc2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(i);


                        }
                    });


                    cvsc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i2=new Intent(Main2Activity.this,SmartControl.class);
                            startActivity(i2);


                        }
                    });

                    cvsay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i3=new Intent(Main2Activity.this,SmartAccess.class);
                            startActivity(i3);


                        }
                    });

                    cva.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i4=new Intent(Main2Activity.this,About.class);
                            startActivity(i4);


                        }
                    });

		}
		catch ( Exception e) {
			Toast.makeText(Main2Activity.this,e.toString(),Toast.LENGTH_SHORT).show();
	}

    }
}
