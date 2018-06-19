package com.android.wondercom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.wondercom.InitThreads.ClientInit;
import com.android.wondercom.InitThreads.ServerInit;
import com.android.wondercom.Main2Activity;
import com.android.wondercom.Receivers.WifiDirectBroadcastReceiver;
import com.android.wondercom.util.ActivityUtilities;

/*
 * This activity is the launcher activity. 
 * Once the connection established, the ChatActivity is launched.
 */
public class MainActivity extends Activity{
	public static final String TAG = "MainActivity";	
	public static final String DEFAULT_CHAT_NAME = "";
	private WifiP2pManager mManager;
	private Channel mChannel;
	private WifiDirectBroadcastReceiver mReceiver;
	private IntentFilter mIntentFilter;
	private Button goToChat;
	private ImageView goToSettings;
	private TextView goToSettingsText;
	private TextView setChatNameLabel;
	private EditText setChatName;
	private ImageView disconnect;
	public static String chatName;
	public static ServerInit server;

	//Getters and Setters
    public WifiP2pManager getmManager() { return mManager; }
	public Channel getmChannel() { return mChannel; }
	public WifiDirectBroadcastReceiver getmReceiver() { return mReceiver; }
	public IntentFilter getmIntentFilter() { return mIntentFilter; }
	public Button getGoToChat(){ return goToChat; }
	public TextView getSetChatNameLabel() { return setChatNameLabel; }
	public ImageView getGoToSettings() { return goToSettings; }
	public EditText getSetChatName() { return setChatName; }
	public TextView getGoToSettingsText() { return goToSettingsText; }
	public ImageView getDisconnect() { return disconnect; }
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




		SharedPreferences.Editor editor = getSharedPreferences("f1", MODE_PRIVATE).edit();
		SharedPreferences prefs = getSharedPreferences("f1", MODE_PRIVATE);
		String fc = prefs.getString("f","");
		editor.putString("f", "");
		editor.commit();
		String f = prefs.getString("f","");

		if ((f!="second" )&& (fc!="second")){
		editor.putString("f", "first");
		editor.commit();

		}
		try {String ff = prefs.getString("f", "");

//			SharedPreferences prefs = getSharedPreferences("fisy", MODE_PRIVATE);
//			String f = prefs.getString("f", null);
			if (ff.equals("first")) {

				Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
				startActivity(intent);

				//String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
				//int idName = prefs.getInt("idName", 0); //0 is the default value.
			}


		}
		catch ( Exception e) {

			Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
		}

		editor.putString("f", "second");
		editor.commit();

        //Init the Channel, Intent filter and Broadcast receiver
        init();

		//Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
		//startActivity(intent);

        //Button Go to Settings
        goToSettings = (ImageView) findViewById(R.id.goToSettings);
        goToSettings();
        
        //Go to Settings text
        goToSettingsText = (TextView) findViewById(R.id.textGoToSettings);        
        
        //Button Go to Chat
        goToChat = (Button) findViewById(R.id.goToChat);
        goToChat();
        
        //Set the chat name
        setChatName = (EditText) findViewById(R.id.setChatName);
        setChatNameLabel = (TextView) findViewById(R.id.setChatNameLabel);
        setChatName.setText(loadChatName(this));
        
        //Button Disconnect
        disconnect = (ImageView) findViewById(R.id.disconnect);
        disconnect();
		getActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		ActivityUtilities.customiseActionBar(this);
	}
    
	@Override
    public void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
        
		mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
					
			@Override
			public void onSuccess() {
				Log.v(TAG, "Discovery process succeeded");
			}
			
			@Override
			public void onFailure(int reason) {
				Log.v(TAG, "Discovery process failed");
			}
		});
    }

	@Override
	protected void onDestroy() {


		super.onDestroy();
	}

	@Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//			case android.R.id.home:
//				NavUtils.navigateUpFromSameTask(this);
//				return true;
//			default:
//				return super.onOptionsItemSelected(item);
//		}
//	}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int idItem = item.getItemId();
       // / return super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}

    }
    
    public void init(){
    	mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReceiver = WifiDirectBroadcastReceiver.createInstance();
        mReceiver.setmManager(mManager);
        mReceiver.setmChannel(mChannel);
        mReceiver.setmActivity(this);
        
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }
    
    public void goToChat(){
    	goToChat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(!setChatName.getText().toString().equals("")){
					//Set the chat name
					saveChatName(MainActivity.this, setChatName.getText().toString());
					chatName = loadChatName(MainActivity.this);
					
					//Start the init process
					if(mReceiver.isGroupeOwner() ==  WifiDirectBroadcastReceiver.IS_OWNER){
						Toast.makeText(MainActivity.this, "I'm the group owner  " + mReceiver.getOwnerAddr().getHostAddress(), Toast.LENGTH_SHORT).show();
						server = new ServerInit();
						server.start();
					}
					else if(mReceiver.isGroupeOwner() ==  WifiDirectBroadcastReceiver.IS_CLIENT){
						Toast.makeText(MainActivity.this, "I'm the client", Toast.LENGTH_SHORT).show();
						ClientInit client = new ClientInit(mReceiver.getOwnerAddr());
						client.start();
					}
					
					//Open the ChatActivity
					Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
					startActivity(intent);
				}
				else{
					Toast.makeText(MainActivity.this, "Please enter a chat name", Toast.LENGTH_SHORT).show();
				}					
			}
		});    	
    }
    
    public void disconnect(){
    	disconnect.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mManager.removeGroup(mChannel, null);
		    	finish();
			}
		});    	
    }
    
    public void goToSettings(){    	
    	goToSettings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Open Wifi settings

				//Toast.makeText(MainActivity.this,"HELLO HI",Toast.LENGTH_SHORT).show();
				 startActivityForResult(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS), 0);


			}
		});    	
    }
    
    //Save the chat name to SharedPreferences
  	public void saveChatName(Context context, String chatName) {
  		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
  		Editor edit = prefs.edit();
  		edit.putString("chatName", chatName);
  		edit.commit();
  	}

  	//Retrieve the chat name from SharedPreferences
  	public String loadChatName(Context context) {
  		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
  		return prefs.getString("chatName", DEFAULT_CHAT_NAME);
  	}
}