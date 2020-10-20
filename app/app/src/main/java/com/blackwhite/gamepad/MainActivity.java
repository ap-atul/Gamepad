package com.blackwhite.gamepad;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blackwhite.gamepad.controller.GamePadController;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private ImageView up, down, right, left, triangle, square, circle, cross;
    private GamePadController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        right = findViewById(R.id.right);
        left = findViewById(R.id.left);
        triangle = findViewById(R.id.triangle);
        square = findViewById(R.id.square);
        circle = findViewById(R.id.circle);
        cross = findViewById(R.id.cross);

        controller = new GamePadController();

        up.setOnTouchListener(this);
        down.setOnTouchListener(this);
        right.setOnTouchListener(this);
        left.setOnTouchListener(this);
        triangle.setOnTouchListener(this);
        square.setOnTouchListener(this);
        circle.setOnTouchListener(this);
        cross.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            keyPress(v);
            return true;
        }
        else if(event.getAction() == MotionEvent.ACTION_UP) {
            keyRelease(v);
            return true;
        }
        v.performClick();
        return false;
    }

    private void keyPress(View v) {
        Log.d("EVENT", "Key pressed");
        setAnimation(v);
        switch (v.getId()){
            case R.id.up:
                controller.keyPressed("up");
                break;
            case R.id.down:
                controller.keyPressed("down");
                break;
            case R.id.left:
                controller.keyPressed("left");
                break;
            case R.id.right:
                controller.keyPressed("right");
                break;
            case R.id.triangle:
                controller.keyPressed("triangle");
                break;
            case R.id.square:
                controller.keyPressed("square");
                break;
            case R.id.circle:
                controller.keyPressed("circle");
                break;
            case R.id.cross:
                controller.keyPressed("cross");
                break;
        }
    }

    private void setAnimation(View v) {
        v.setAlpha(0.5f);
        v.setScaleX(0.9f);
        v.setScaleY(0.9f);
    }

    private void resetAnimation(View v){
        v.setAlpha(1);
        v.setScaleX(1f);
        v.setScaleY(1f);
    }

    private void keyRelease(View v) {
        Log.d("EVENT", "Key released");
        resetAnimation(v);
        switch (v.getId()){
            case R.id.up:
                controller.keyReleased("up");
                break;
            case R.id.down:
                controller.keyReleased("down");
                break;
            case R.id.left:
                controller.keyReleased("left");
                break;
            case R.id.right:
                controller.keyReleased("right");
                break;
            case R.id.triangle:
                controller.keyReleased("triangle");
                break;
            case R.id.square:
                controller.keyReleased("square");
                break;
            case R.id.circle:
                controller.keyReleased("circle");
                break;
            case R.id.cross:
                controller.keyReleased("cross");
                break;
        }
    }
}
