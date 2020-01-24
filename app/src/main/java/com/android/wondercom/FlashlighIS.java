package com.android.wondercom;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
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
public class FlashlighIS extends IntentService {

    private Camera mCamera;
    private Camera.Parameters parameters;
    private CameraManager camManager;
    private Context context;

//    public FlashlighIS(Context context) {
//        this.context = context;
//    }

    public FlashlighIS() {



        super("FlashlighIS");
    }






       @Override
    protected void onHandleIntent(Intent intent) {
           getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                camManager = (CameraManager) getSystemService(getApplicationContext().CAMERA_SERVICE);
                String cameraId = null;
                try {
                        cameraId = camManager.getCameraIdList()[0]; // Usually front camera is at 0 position.
                }

                catch (CameraAccessException e) {
                    e.printStackTrace();
                    Toast.makeText(this,e.toString()+" its Flashlight off service",Toast.LENGTH_SHORT).show();
                }
                        try {
        camManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e1) {
        e1.printStackTrace();
        Toast.makeText(this,e1.toString(),Toast.LENGTH_SHORT).show();
        }
            } else {
                mCamera = Camera.open();
                parameters = mCamera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
                mCamera.stopPreview();
            }
        }
        Toast.makeText(this,"FLASHLIGHT OFF SERVICE STARTED",Toast.LENGTH_SHORT).show();
    }




    }







//            camera = Camera.open();
//            Camera.Parameters parameters = camera.getParameters();
//            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//            camera.setParameters(parameters);
//            camera.startPreview();

//            NotificationManager mNotificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
//            mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);



//@TargetApi(Build.VERSION_CODES.M)
//@RequiresApi(api = Build.VERSION_CODES.M)
//@Override
//protected void onHandleIntent(Intent intent) {
//
//        getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
//
//
//        CameraManager camManager = (CameraManager) getSystemService(getApplicationContext().CAMERA_SERVICE);
//        String cameraId = null; // Usually front camera is at 0 position.
//        try {
//        cameraId = camManager.getCameraIdList()[0];
//        } catch (CameraAccessException e1) {
//        e1.printStackTrace();
//        Toast.makeText(this,e1.toString(),Toast.LENGTH_SHORT).show();
//        }
//        try {
//        camManager.setTorchMode(cameraId, false);
//        } catch (CameraAccessException e1) {
//        e1.printStackTrace();
//        Toast.makeText(this,e1.toString(),Toast.LENGTH_SHORT).show();
//        }}