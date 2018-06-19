package com.android.wondercom;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

public class Flashlight extends Service {

    Camera camera;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Toast.makeText(this,"SERVICES 2 startedddd",Toast.LENGTH_SHORT).show();

        try {


            getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);


            CameraManager camManager = (CameraManager) getSystemService(getApplicationContext().CAMERA_SERVICE);
            String cameraId = camManager.getCameraIdList()[0]; // Usually front camera is at 0 position.
            camManager.setTorchMode(cameraId, true);





//            camera = Camera.open();
//            Camera.Parameters parameters = camera.getParameters();
//            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//            camera.setParameters(parameters);
//            camera.startPreview();

//            NotificationManager mNotificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
//            mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
            Toast.makeText(this,"SERVICES 2 started",Toast.LENGTH_SHORT).show();
        }

        catch (Exception e){

            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }
}
