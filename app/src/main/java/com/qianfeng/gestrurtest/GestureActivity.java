package com.qianfeng.gestrurtest;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class GestureActivity extends ActionBarActivity implements View.OnTouchListener {

    private ImageView imageView;
    private double dx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        imageView = ((ImageView) findViewById(R.id.image));
        findViewById(R.id.relayout).setOnTouchListener(this);
    }

    /**
     *
     * @param view
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()&MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_DOWN:
                if(event.getPointerCount()==2){
                    //记录当前两点的距离
                    dx = Math.sqrt(Math.pow(event.getX(0)-event.getX(1),2)+Math.pow(event.getY(0)-event.getY(1),2));
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(event.getPointerCount()==2){
                    double temp= Math.sqrt(Math.pow(event.getX(0)-event.getX(1),2)+Math.pow(event.getY(0)-event.getY(1),2));
                    //3.o以后用
//                    imageView.setScaleX(((float) (temp / dx)));
//                    imageView.setScaleY(((float) (temp / dx)));
                    //3.0以前用
                    ViewCompat.setScaleX(imageView, ((float) (temp / dx)));
                    ViewCompat.setScaleY(imageView, ((float) (temp / dx)));
                }
                break;
        }
        return true;
    }
}
