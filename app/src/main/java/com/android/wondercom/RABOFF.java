package com.android.wondercom;

import android.app.IntentService;

import android.content.Intent;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;



/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RABOFF extends IntentService {

    Uri notification;
    public RABOFF() {
        super("RABOFF");
    }







    protected void onHandleIntent(Intent intent) {

        notification = RingtoneManager.getDefaultUri(Integer.parseInt(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT));
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
        if(notification == null) {

            notification = RingtoneManager.getDefaultUri(Integer.parseInt(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT));
        }


    }



}

