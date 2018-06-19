
package com.android.wondercom;


        import android.app.IntentService;
        import android.content.Context;
        import android.content.Intent;

        import android.net.wifi.WifiManager;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class WIFIOFF extends IntentService {


    public WIFIOFF() {
        super("WIFIOFF");
    }







    protected void onHandleIntent(Intent intent) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);

    }


}




