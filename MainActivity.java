package com.unpam.preferencemenu;

import android.app.Activity; 
import android.content.Intent; 
import android.content.SharedPreferences; 
import android.os.Bundle; 
import android.preference.PreferenceManager; 
import android.view.Menu; 
import android.view.MenuItem; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.TextView; 
import android.widget.Toast; 
 
public class MainActivity extends Activity implements 
OnClickListener { 
  static final int SETTING = 1; 
  SharedPreferences preferences; 
  TextView textView; 
  Button button; 
 
  @Override 
  protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_main); 
 
    textView = (TextView) findViewById(R.id.textView1); 
    button = (Button) findViewById(R.id.button1); 
    button.setOnClickListener(this); 
 
    preferences = 
PreferenceManager.getDefaultSharedPreferences(this); 
    textView.setText(preferences.getString("nilaitextview", 
"TextView (default)")); 
    button.setText(preferences.getString("nilaibutton", 
"Button (default)")); 
  } 
 
  @Override 
  public boolean onCreateOptionsMenu(Menu menu) { 
    // Inflate the menu; this adds items to the action bar if it is present. 
    getMenuInflater().inflate(R.menu.activity_main, menu); 
    return true; 
  } 
 
  public void onClick(View v) { 
    // TODO Auto-generated method stub 
    switch (v.getId()) { 
    case R.id.button1: 
        Toast.makeText(this, 
  preferences.getString("nilaibutton", "Button (default)")+" diklik", Toast.LENGTH_SHORT).show(); 
      } 
    } 
   
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) { 
      switch (item.getItemId()) { 
      case R.id.menu_pengaturan: 
        Intent settingIntent = new Intent(this, SettingActivity.class); 
        startActivityForResult(settingIntent, SETTING); 
        return true; 
      case R.id.menu_keluar: 
        System.exit(0); 
        return true; 
      default: 
        return super.onOptionsItemSelected(item); 
      } 
    } 
   
    @Override 
    protected void onActivityResult(int requestCode, int 
  resultCode, Intent data) { 
      switch (requestCode) { 
      case SETTING: 
     
    textView.setText(preferences.getString("nilaitextview", 
  "TextView (default)")); 
     
    button.setText(preferences.getString("nilaibutton", "Button (default)")); 
      } 
    } 
  }