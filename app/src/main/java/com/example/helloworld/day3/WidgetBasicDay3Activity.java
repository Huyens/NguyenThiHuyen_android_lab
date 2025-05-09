package com.example.helloworld.day3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.R;

public class WidgetBasicDay3Activity extends AppCompatActivity {

    EditText inputName;
    Button confirmName;
    String namePlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.widget_basic_day_3);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        confirmName = this.findViewById(R.id.confirmName);
        inputName = this.findViewById(R.id.inputName);

        confirmName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namePlayer = inputName.getText().toString();
                Toast.makeText(WidgetBasicDay3Activity.this,"Xin chào bạn " + namePlayer,Toast.LENGTH_SHORT).show();
            }
        });

    }
}