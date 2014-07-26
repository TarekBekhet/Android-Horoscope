package com.example.horoscope;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.AlertDialog;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MyActivity extends Activity implements View.OnClickListener {

    ImageButton a,b,c,d,e,f,g,h,i,j,k,l;
    boolean connected,online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        check c=new check();
        try {
			c.execute().get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(connected){
        	init();
        }
        else{
        	new AlertDialog.Builder(this)
        	.setTitle("No Connection")
        	.setMessage("Please check connection")
        	.show();
        }
        
    }
    
    public class check extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			if(isOnline())
	        	connected=true;
			else
				connected=false;
			return null;	
		}
    	
    }

    private boolean isOnline() {
    	if (isConnected()) {
            try {
            	HttpURLConnection urlc = (HttpURLConnection)(new URL("http://www.google.com").openConnection());  // or any valid link.
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500); 
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    	}
        return false;
	}

	public boolean isConnected() {
		// TODO Auto-generated method stub
    	ConnectivityManager cm =
    	        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
    	        return true;
    	    }
    	    return false;
		
	}
	private void init() {
        a=(ImageButton)findViewById(R.id.aries);
        b=(ImageButton)findViewById(R.id.taurus);
        c=(ImageButton)findViewById(R.id.gemini);
        d=(ImageButton)findViewById(R.id.cancer);
        e=(ImageButton)findViewById(R.id.leo);
        f=(ImageButton)findViewById(R.id.virgo);
        g=(ImageButton)findViewById(R.id.libra);
        h=(ImageButton)findViewById(R.id.scorpio);
        i=(ImageButton)findViewById(R.id.sagittarius);
        j=(ImageButton)findViewById(R.id.capricorn);
        k=(ImageButton)findViewById(R.id.aquarius);
        l=(ImageButton)findViewById(R.id.pisces);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch(view.getId()){
            case R.id.aries:
                i=new Intent(MyActivity.this,Aries.class);
                startActivity(i);
                break;
            case R.id.taurus:
                i=new Intent(MyActivity.this,Taurus.class);
                startActivity(i);
                break;
            case R.id.gemini:
                i=new Intent(MyActivity.this,Gemini.class);
                startActivity(i);
                break;
            case R.id.cancer:
                i=new Intent(MyActivity.this,Cancer.class);
                startActivity(i);
                break;
            case R.id.leo:
                i=new Intent(MyActivity.this,Leo.class);
                startActivity(i);
                break;
            case R.id.virgo:
                i=new Intent(MyActivity.this,Virgo.class);
                startActivity(i);
                break;
            case R.id.libra:
                i=new Intent(MyActivity.this,Libra.class);
                startActivity(i);
                break;
            case R.id.scorpio:
                i=new Intent(MyActivity.this,Scorpio.class);
                startActivity(i);
                break;
            case R.id.sagittarius:
                i=new Intent(MyActivity.this,Sagittarius.class);
                startActivity(i);
                break;
            case R.id.capricorn:
                i=new Intent(MyActivity.this,Capricorn.class);
                startActivity(i);
                break;
            case R.id.aquarius:
                i=new Intent(MyActivity.this,Aquarius.class);
                startActivity(i);
                break;
            case R.id.pisces:
                i=new Intent(MyActivity.this,Pisces.class);
                startActivity(i);
                break;
        }
    }
}
