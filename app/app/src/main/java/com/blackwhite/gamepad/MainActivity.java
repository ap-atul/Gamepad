package com.blackwhite.gamepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.blackwhite.gamepad.controller.GamePadController;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private ImageView up, down, right, left, triangle, square, circle, cross;
    private GamePadController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        return false;
    }

    private void keyPress(View v) {
        Log.d("EVENT", "Key pressed");
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

    private void keyRelease(View v) {
        Log.d("EVENT", "Key released");
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
