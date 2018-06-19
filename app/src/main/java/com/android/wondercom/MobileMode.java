package com.android.wondercom;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MobileMode extends Service {
    String message;
    String first,second,third;
    int h;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {

    }


    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        AudioManager am;
        am= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);




        //am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(this,"SERVICES",Toast.LENGTH_SHORT).show();
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);


       h = am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION);


        am.setStreamVolume(AudioManager.STREAM_RING, h,
                AudioManager.FLAG_SHOW_UI|AudioManager.FLAG_PLAY_SOUND);



        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
