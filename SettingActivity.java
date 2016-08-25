package com.unpam.preferencemenu;

import android.os.Bundle; 
import android.preference.PreferenceManager; 
import android.app.Activity; 
import android.content.SharedPreferences; 
import android.content.SharedPreferences.Editor; 
import android.view.Menu; 
import android.widget.EditText; 
 
public class SettingActivity extends Activity { 
  SharedPreferences preferences; 
  EditText nilaiTextView;
  EditText nilaiButton; 
  
  @Override 
  protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_setting); 
     
    nilaiTextView = (EditText) 
    		findViewById(R.id.nilaiTextViewEditText);
    nilaiButton = (EditText) 
    		findViewById(R.id.nilaiButtonEditText); 
     
    preferences = 
    		PreferenceManager.getDefaultSharedPreferences(this); 
 
  nilaiTextView.setText(preferences.getString("nilaitextview", 
"TextView (default)")); 
 
  nilaiButton.setText(preferences.getString("nilaibutton", 
"Button (default)")); 
  } 
 
  @Override 
  public boolean onCreateOptionsMenu(Menu menu) { 
    // Inflate the menu; this adds items to the action bar if it is present. 
    getMenuInflater().inflate(R.menu.activity_setting, 
menu); 
    return true; 
  } 
 
  @Override 
  protected void onPause() { 
    Editor edit = preferences.edit(); 
    edit.putString("nilaitextview", 
nilaiTextView.getText().toString()); 
    edit.putString("nilaibutton", 
nilaiButton.getText().toString()); 
 
    edit.commit(); 
    super.onPause(); 
  } 
}