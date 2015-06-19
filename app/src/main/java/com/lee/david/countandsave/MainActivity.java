package com.lee.david.countandsave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textNum = (TextView) findViewById(R.id.showNum);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String num = preferences.getString("Number", "");

        // Check if information is saved
       if(num != null)
        {
            count = Integer.parseInt(num);
            textNum.setText(num);
        }
        else
        {
            textNum.setText(0+"");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void advance(View view) {
        count++;
        TextView textNum = (TextView) findViewById(R.id.showNum);
        textNum.setText("" + count);
    }

    public void save(View view) {
        // store
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Number", String.valueOf(count));
        editor.apply();
    }
}
