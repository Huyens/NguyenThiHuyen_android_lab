package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Example2Activity extends AppCompatActivity {

    TextView textEvt1;
    TextView textEvt2;
    final String TAG = "TestGesture";

    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example2);

        textEvt1 = this.findViewById(R.id.my_text_evt1);
        textEvt2 = this.findViewById(R.id.my_text_evt2);

        GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(@NonNull MotionEvent e) {
                textEvt1.setText("onDown");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onDown");
                return false;
            }

            @Override
            public void onShowPress(@NonNull MotionEvent e) {
                textEvt1.setText("onShowPress");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onShowPress");
            }

            @Override
            public boolean onSingleTapUp(@NonNull MotionEvent e) {
                textEvt1.setText("onSingleTapUp");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onSingleTapUp");
                return false;
            }

            @Override
            public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
                textEvt1.setText("onScroll");
                textEvt2.setText(e1.getX() + ":" + e1.getY() + " " + e2.getX() + ":" + e2.getY());
                Log.e(TAG, "onScroll");
                return false;
            }

            @Override
            public void onLongPress(@NonNull MotionEvent e) {
                textEvt1.setText("onLongPress");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onLongPress");
            }

            @Override
            public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
                textEvt1.setText("onFling");
                textEvt2.setText(e1.getX() + ":" + e1.getY() + " " + e2.getX() + ":" + e2.getY());
                Log.e(TAG, "onFling");
                return false;
            }
        };
        GestureDetector.OnDoubleTapListener doubleTapListener = new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
                textEvt1.setText("onSingleTapConfirmed");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onSingleTapConfirmed");
                return false;
            }

            @Override
            public boolean onDoubleTap(@NonNull MotionEvent e) {
                textEvt1.setText("onDoubleTap");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onDoubleTap");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
                textEvt1.setText("onDoubleTapEvent");
                textEvt2.setText(e.getX() + ":" + e.getY());
                Log.e(TAG, "onDoubleTapEvent");
                return false;
            }
        };
        this.gestureDetector = new GestureDetector(this, gestureListener);
        this.gestureDetector.setOnDoubleTapListener(doubleTapListener);

        View rootView = getWindow().getDecorView();
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
        Log.e(TAG, "Running...");
    }
}