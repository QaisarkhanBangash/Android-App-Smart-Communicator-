package com.android.wondercom;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Set;

public class Settings extends Activity {

    TextView t12,t17;
    SeekBar s3,s4;
    Button b,b1,b2,b3;
    EditText pc,ed1,ed2,ed3;
    TextView ll;
    String ll1,ll2,nmbr1;
    String rcm,nmr;
    String item1="1";
    ImageView i1,i2,i3,i4,i5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        try {
            s3  =  (SeekBar) findViewById(R.id.seekBar3);
            s4  =  (SeekBar) findViewById(R.id.seekBar4);
            t12 = (TextView) findViewById(R.id.textView12);
            t17 = (TextView) findViewById(R.id.textView17);

            pc  =  (EditText) findViewById(R.id.editText);
            ed1 = (EditText) findViewById(R.id.editText1);
            ed2 = (EditText) findViewById(R.id.editText2);
            ed3 = (EditText) findViewById(R.id.editText3);

            b = (Button) findViewById(R.id.button);
            b1 = (Button) findViewById(R.id.button1);
            b2 = (Button) findViewById(R.id.button2);
            b3 = (Button) findViewById(R.id.button3);

            i1=(ImageView)findViewById(R.id.imageView2);
            i2=(ImageView)findViewById(R.id.imageView3);
            i3=(ImageView)findViewById(R.id.imageView4);
            i4=(ImageView)findViewById(R.id.imageView5);
            i5=(ImageView)findViewById(R.id.imageView6);



            s3.setMax(25);
            s3.setProgress(5);

            s4.setMax(25);
            s4.setProgress(5);






            i1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(Settings.this,InfooS1.class);
                    startActivity(i);
                }
            });

            i2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(Settings.this,InfooS2.class);
                    startActivity(i);
                }
            });

            i3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(Settings.this,InfooS3.class);
                    startActivity(i);
                }
            });

            i4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(Settings.this,InfooS4.class);
                    startActivity(i);
                }
            });

            i5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i=new Intent(Settings.this,InfooS5.class);
                    startActivity(i);
                }
            });






            getActionBar().setTitle("   Settings");
            getActionBar().setHomeAsUpIndicator(R.drawable.back);
            getActionBar().setHomeButtonEnabled(true);
            getActionBar().setDisplayHomeAsUpEnabled(true);


       //   ll=(TextView)findViewById(R.id.ll);

            //onebutton
            SharedPreferences xsx = getApplicationContext().getSharedPreferences("ll", Context.MODE_PRIVATE);

             ll1 = xsx.getString("ll1", "");



            if(ll1.equals("LOGOUT")){
                b2.setVisibility(View.GONE);
            b3.setVisibility(View.VISIBLE);
            }

            if(ll1.equals("LOGIN")){
                b3.setVisibility(View.GONE);
                b2.setVisibility(View.VISIBLE);
            }

//            if((ll1!="LOGIN")&&(ll1!="LOGOUT")){
//                b3.setVisibility(View.GONE);
//                b2.setVisibility(View.VISIBLE);}

            SharedPreferences xt = getSharedPreferences("st", Context.MODE_PRIVATE);
            SharedPreferences.Editor editorc = xt.edit();
            editorc.putString("nmbr1", String.valueOf(ed2.getText()));
            editorc.apply();

            SharedPreferences xsxx = getSharedPreferences("st", Context.MODE_PRIVATE);

            nmbr1 = xsxx.getString("nmbr1", "");
            ed2.setText(nmbr1);


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences xt = getSharedPreferences("st", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editorc = xt.edit();
                        editorc.putString("nmbr1", String.valueOf(ed2.getText()));
                        editorc.apply();

                        SharedPreferences xsxx = getSharedPreferences("st", Context.MODE_PRIVATE);

                        nmbr1 = xsxx.getString("nmbr1", "");


                       SmsManager smss = SmsManager.getDefault();
                        smss.sendTextMessage(nmbr1, null, "LOGIN@" + String.valueOf(ed3.getText()),null , null);

                        ed2.setText(nmbr1);

                        SharedPreferences xtt = getSharedPreferences("st", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editorct = xtt.edit();
                        editorct.putString("nmbr9", String.valueOf(ed3.getText()));
                        editorct.apply();

                        Toast.makeText(Settings.this,"Wait for authentication message",Toast.LENGTH_LONG).show();

                    }
                });


            SharedPreferences xsx1 = getApplicationContext().getSharedPreferences("ll", Context.MODE_PRIVATE);

            nmr = xsx1.getString("nmr", "");

            ed2.setText(nmr);


                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences xsx = getApplicationContext().getSharedPreferences("ll", Context.MODE_PRIVATE);

                        nmr = xsx.getString("nmr", "");

                        SharedPreferences xsxx = getApplicationContext().getSharedPreferences("st", Context.MODE_PRIVATE);

                        String nmbr9 = xsxx.getString("nmbr9", "");

                        //                    //LOGOUT
                        SmsManager smss1 = SmsManager.getDefault();
                        smss1.sendTextMessage(nmr, null, "LOGOUT@" + nmbr9, null, null);


                        AlertDialog diaBox = AskOption();
                        diaBox.show();

//                        SharedPreferences xtt = getSharedPreferences("st", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editorct = xtt.edit();
//                        editorct.putString("nmbr9", "");
//                        editorct.apply();

                        Toast.makeText(Settings.this,"Wait for authentication message",Toast.LENGTH_LONG).show();

                    }
                });

//
//                ll.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        if(nmbr1!=null){
//                            ed2.setText(nmbr1);
//                        }
//
//                        //LOGIN
//                        SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = x.edit();
//                        editor.putString("nmbr1", String.valueOf(ed2.getText()));
//                        editor.apply();
//
//                        SharedPreferences xsx = getSharedPreferences("st", Context.MODE_PRIVATE);
//
//                        nmbr1 = xsx.getString("nmbr1", "");
//                        ed2.setText(nmbr1);
//                        if (ll1.equals("LOGIN")){
//
//
//
//
//
//
//                    SmsManager smss = SmsManager.getDefault();
//                    smss.sendTextMessage(nmbr1, null, "LOGIN@" + String.valueOf(ed3.getText()),null , null);
//
//                        ed2.setText(nmbr1);
//
//                        }
//
//                        else if(ll1.equals("LOGOUT")){
//
//
//
//                            //                    //LOGOUT
//                    SmsManager smss1 = SmsManager.getDefault();
//                    smss1.sendTextMessage(nmbr1, null, "LOGOUT@abc", null, null);
//
//
//                            ed2.setText(nmbr1);
//
//
//
//                            }
//                            else if((ll1!=("LOGIN"))&&(ll1!=("LOGOUT"))) {
//
//
//
//
//                            SmsManager smss = SmsManager.getDefault();
//                            smss.sendTextMessage(nmbr1, null, "LOGIN@" + String.valueOf(ed3.getText()), null, null);
//                            ed2.setText(nmbr1);
//                        }
//
//                        Toast.makeText(Settings.this,"WAIT FOR AUTHENTICATION MESSAGE",Toast.LENGTH_LONG).show();
//                       // Toast.makeText(Settings.this,nmbr1+ed2.getText().toString()+ed3.getText().toString(),Toast.LENGTH_LONG).show();
//                        }
//
//
//
//                });




            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pc.getText().length() < 4) {
                        Toast.makeText(getApplicationContext(), "PASSCODE SHOULD HAVE AT LEAST 4 CHARACTERS", Toast.LENGTH_LONG).show();
                    }

                    if (pc.getText().length() > 3) {
                        SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = x.edit();
                        editor.putString("pc", String.valueOf(pc.getText()));
                        editor.apply();

                        Toast.makeText(getApplicationContext(), "PASSCODE IS SET", Toast.LENGTH_LONG).show();
                    }
                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = x.edit();
                    editor.putString("nmbr", String.valueOf(ed1.getText()));
                    editor.apply();

                    SharedPreferences xsx = getApplicationContext().getSharedPreferences("st", Context.MODE_PRIVATE);

                    String nmbr = xsx.getString("nmbr", "");

                    ed1.setText(nmbr);

                    Toast.makeText(getApplicationContext(),"NUMBER IS SET",Toast.LENGTH_LONG).show();
                }
            });

            SharedPreferences xsx3 = getApplicationContext().getSharedPreferences("st", Context.MODE_PRIVATE);

            String nmbr = xsx3.getString("nmbr", "");

            ed1.setText(nmbr);

//            b2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//
//                    //LOGIN
//                    SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = x.edit();
//                    editor.putString("nmbr1", String.valueOf(ed2.getText()));
//                    editor.apply();
//
//                    SharedPreferences xsx = getApplicationContext().getSharedPreferences("st", Context.MODE_PRIVATE);
//
//                    String nmbr1 = xsx.getString("nmbr1", "");
//
//                    ed2.setText(nmbr1);
//
//
//                    SmsManager smss = SmsManager.getDefault();
//                    smss.sendTextMessage(String.valueOf(ed2.getText()), null, "LOGIN@" + String.valueOf(ed3.getText()), null, null);
//
//
//
//
//                    //LOGOUT
//                    SmsManager smss1 = SmsManager.getDefault();
//                    smss1.sendTextMessage(String.valueOf(ed2.getText()), null, "LOGOUT@abc", null, null);
//
//
//                    ed2.setText(null);
//                    ed3.setText(null);
//                }
//            });

//            b3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                    //LOGOUT
//                    SmsManager smss = SmsManager.getDefault();
//                    smss.sendTextMessage(String.valueOf(ed2.getText()), null, "LOGOUT@abc", null, null);
//
//
//                    ed2.setText(null);
//                    ed3.setText(null);
//
//                }
//            });


            SharedPreferences prefs = getSharedPreferences("st", MODE_PRIVATE);

            String rm = prefs.getString("rm", "");
            String rc = prefs.getString("rc", "");

            t12.setText(rm);
            t17.setText(rc);


            SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = x.edit();
            editor.putString("i","0");
            editor.apply();
            SharedPreferences xx = getSharedPreferences("st", Context.MODE_PRIVATE);
            String i=xx.getString("i","");

//            if( i.equals("0")){
//            rcm= String.valueOf(5);
//            SharedPreferences xxx = getSharedPreferences("st", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editorx = xxx.edit();
//            editorx.putString("rm", rcm);
//            editorx.putString("rc", rcm);
//                editor.putString("i","1");
//            editorx.apply();
//            ;}

            s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    t12.setText("" + progress);
                    SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = x.edit();
                    rcm=String.valueOf(progress);
                    editor.putString("rm", rcm);
                    editor.apply();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


            s4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    t17.setText("" + progress);

                    SharedPreferences x = getSharedPreferences("st", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = x.edit();
                    rcm=String.valueOf(progress);
                    editor.putString("rc",rcm );
                    editor.apply();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
        catch (Exception ex){

            Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();
        }




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.help:
                Intent ii;
                ii=new Intent(this,Info_Help.class);
                startActivity(ii);
                break;
            case R.id.about:
                Intent i;
                i=new Intent(this,Info_About.class);
                startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this).create();
                myQuittingDialogBox.setTitle("Security Alert");
                myQuittingDialogBox.setMessage("Kindly delete the SMS conversation for security and privacy reasons.");
                myQuittingDialogBox.setIcon(R.drawable.d);
                myQuittingDialogBox.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        return myQuittingDialogBox;

    }

//    private void removeMessage() {
//
//
//        String numberFilter = "address='"+ "+923169008079" + "'";
////        String messageid = null;
////        Cursor cursor = getApplicationContext().getContentResolver().query(Uri.parse("content://sms/"),
////                null, numberFilter, null, null);
////
////        if (cursor.moveToFirst()) {
////            messageid = cursor.getString(0);
////        }
//
//        for (;;) {
//            // restart cursor before each delete
//            String messageid = null;
//            Cursor cursor = getApplicationContext().getContentResolver().query(Uri.parse("content://sms/"),
//                    null, numberFilter, null, null);
//
//            if (!cursor.moveToFirst()) {
//                break; // nothing more to delete
//            }
//
//            // delete single record
//            messageid = cursor.getString(0);
//            getContentResolver().delete(Uri.parse("content://sms/" + messageid), null, null);
//        }


//        Uri uriSMSURI = Uri.parse("content://sms");
//        Cursor cur = getApplicationContext().getContentResolver().query(uriSMSURI, null, null, null,null);
//        String phoneNo, msg;
//        if (cur.moveToFirst()) {
//            String pid = cur.getString(1);
//            // do some process
//            Toast.makeText(getApplicationContext(), pid, Toast.LENGTH_LONG).show();
//            Cursor cur2 = getApplicationContext().getContentResolver().query(Uri.parse("content://sms/conversations/" + pid), null, null, null, null);
//            if (cur2.moveToFirst()) {
//                ////Tried with this with no luck, its Delete the whole Conversation :
//                String pid2 = cur2.getString(1);
//                String uri = "content://sms/conversations/" + pid2;
//                getApplicationContext().getContentResolver().delete(Uri.parse(uri), null, null);
//            }
//        }
//


//    private void removeMessage(Context context, String fromAddress) {
//
//        Uri uriSMS = Uri.parse("content://sms/inbox");
//        Cursor cursor = context.getContentResolver().query(uriSMS, null,
//                null, null, null);
//        cursor.moveToFirst();
//        if(cursor.getCount() > 0){
//            int ThreadId = cursor.getInt(1);
//            Log.d("Thread Id", ThreadId+" id - "+cursor.getInt(0));
//            Log.d("contact number", cursor.getString(2));
//            Log.d("column name", cursor.getColumnName(2));
//
//            context.getContentResolver().delete(Uri.
//                            parse("content://sms/inbox/"+ThreadId), "address=?",
//                    new String[]{fromAddress});
//            Log.d("Message Thread Deleted", fromAddress);
//            Toast.makeText(Settings.this,nmr+" "+ThreadId+" "+fromAddress+"  01",Toast.LENGTH_LONG).show();
//        }
//
//        cursor.close();
//    }

//    public void delete_thread(String thread)
//    {
//        Cursor c = getApplicationContext().getContentResolver().query(
//                Uri.parse("content://sms/"),new String[] {
//                        "_id", "thread_id", "address", "person", "date","body" }, null, null, null);
//
//        try {
//            while (c.moveToNext())
//            {
//                int id = c.getInt(0);
//                String address = c.getString(2);
//                if (address.equals(thread))
//                {
//                    getApplicationContext().getContentResolver().delete(
//                            Uri.parse("content://sms/inbox/" + id), null, null);
//                }
//              //  Toast.makeText(Settings.this,nmr+id+"  02",Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//
//            Toast.makeText(Settings.this,e.toString(),Toast.LENGTH_LONG).show();
//        }
//    }

}
