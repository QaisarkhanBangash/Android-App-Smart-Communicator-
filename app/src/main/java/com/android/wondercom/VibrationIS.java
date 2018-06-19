package com.android.wondercom;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class VibrationIS extends IntentService {


    public VibrationIS() {
        super("VibrationIS");
    }







    protected void onHandleIntent(Intent intent) {

        AudioManager am;
        am= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);




        //am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(this,"SERVICES",Toast.LENGTH_SHORT).show();
        am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);




    }


    }




