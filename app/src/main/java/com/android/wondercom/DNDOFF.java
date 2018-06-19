
package com.android.wondercom;




        import android.annotation.TargetApi;
        import android.app.IntentService;
        import android.app.NotificationManager;
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
public class DNDOFF extends IntentService {


    public DNDOFF() {
        super("DNDOFF");
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onHandleIntent(Intent intent) {

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);

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






