package com.android.wondercom;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.android.wondercom.MainActivity.TAG;

public class Main2Activity extends Activity {

    CardView cvc2,cvsc,cvsay,cva;
    ImageView k;

    private static final int SMS_PERMISSION_CODE = 0;
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
                    if (!hasReadSmsPermission()) {
                        requestReadAndSendSmsPermission();
                    }

                    getActionBar().setTitle("   SmartComm");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                        getActionBar().setHomeAsUpIndicator(R.drawable.hom);
                    }
                    getActionBar().setHomeButtonEnabled(true);
                    getActionBar().setDisplayHomeAsUpEnabled(true);


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
                            Intent i2=new Intent(Main2Activity.this,SCO.class);
                            startActivity(i2);


                        }
                    });

                    cvsay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i3=new Intent(Main2Activity.this,ACO.class);
                            startActivity(i3);


                        }
                    });

                    cva.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i4=new Intent(Main2Activity.this,Settings.class);
                            startActivity(i4);


                        }
                    });

		}
		catch ( Exception e) {
			Toast.makeText(Main2Activity.this,e.toString(),Toast.LENGTH_SHORT).show();
	}

    }
    @Override
    public void onBackPressed() {
        AlertDialog diaBox = AskOption();
        diaBox.show();
    }

    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setIcon(R.drawable.d)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

//                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("Exit me", true);
//                        startActivity(intent);
//                        finish();
//

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

//                        System.exit(0);
//                        System.runFinalizersOnExit(true);
//                        Process.killProcess(Process.myPid());
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            finishAndRemoveTask();
//                        }
//                        finishAffinity();
//                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;

    }

    /**
     * Validates if the app has readSmsPermissions and the mobile phone is valid
     *
     * @return boolean validation value
     */


    /**
     * Optional informative alert dialog to explain the user why the app needs the Read/Send SMS permission
     */
//    private void showRequestPermissionsInfoAlertDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("PERMISSION");
//        builder.setMessage("GIVE PERMISSION FOR READ/SEND SMS");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//
//            }
//        });
//        builder.show();
//    }


    /**
     * Runtime permission shenanigans
     */
    private boolean hasReadSmsPermission() {
        return ContextCompat.checkSelfPermission(Main2Activity.this, android.Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(Main2Activity.this, android.Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED&&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CHANGE_WIFI_STATE) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WRITE_CALL_LOG) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WAKE_LOCK) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.ACCESS_NOTIFICATION_POLICY) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.LOCATION_HARDWARE) == PackageManager.PERMISSION_GRANTED

                ;
    }

    private void requestReadAndSendSmsPermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(Main2Activity.this, android.Manifest.permission.READ_SMS)) {
//            Log.d(TAG, "shouldShowRequestPermissionRationale(), no permission requested");
//          //  Toast.makeText(Main2Activity.this,"shouldShowRequestPermissionRationale(), no permission requested",Toast.LENGTH_SHORT);
//            return;
//        }
        ActivityCompat.requestPermissions(Main2Activity.this, new String[]{android.Manifest.permission.READ_SMS, android.Manifest.permission.RECEIVE_SMS,
                        Manifest.permission.READ_CONTACTS, Manifest.permission.READ_CALL_LOG,
                         Manifest.permission.RECORD_AUDIO, Manifest.permission.RECORD_AUDIO,
                         Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.CAMERA,
                         Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_CALL_LOG,
                        Manifest.permission.WRITE_CONTACTS,Manifest.permission.WAKE_LOCK,Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                        Manifest.permission.INTERNET,Manifest.permission.LOCATION_HARDWARE, Manifest.permission.SEND_SMS},
                SMS_PERMISSION_CODE);
    }
}
