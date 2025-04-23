
package com.example.helloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Example4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_example4_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout rootView = findViewById(R.id.root_view);
        int itemId = item.getItemId();

        if (itemId == R.id.menu_red) {
            rootView.setBackgroundColor(Color.RED);
            return true;
        } else if (itemId == R.id.menu_green) {
            rootView.setBackgroundColor(Color.GREEN);
            return true;
        } else if (itemId == R.id.menu_blue) {
            rootView.setBackgroundColor(Color.BLUE);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}
