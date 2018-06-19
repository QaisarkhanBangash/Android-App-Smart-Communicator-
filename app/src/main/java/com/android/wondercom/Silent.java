package com.android.wondercom;



        import android.annotation.TargetApi;
        import android.app.IntentService;
        import android.content.Intent;
        import android.content.Context;

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
public class Silent extends IntentService {


    public Silent() {
        super("Silent");
    }






    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onHandleIntent(Intent intent) {

        AudioManager am;
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);




        //am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(this,"SERVICES",Toast.LENGTH_SHORT).show();
        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

//            camera = Camera.open();
//            Camera.Parameters parameters = camera.getParameters();
//            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//            camera.setParameters(parameters);
//            camera.startPreview();

//            NotificationManager mNotificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
//            mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
        Toast.makeText(this,"Intent SERVICES OSS",Toast.LENGTH_SHORT).show();
    }


}





