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
public class RABON extends IntentService {

    Uri notification;
    public RABON() {
        super("RABON");
    }







    protected void onHandleIntent(Intent intent) {

         notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
        if(notification == null) {

           notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
    }


}



}

