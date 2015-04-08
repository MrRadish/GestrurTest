package com.qianfeng.gestrurtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private GestureView gestureView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureView = ((GestureView) findViewById(R.id.gest));
        textView = ((TextView) findViewById(R.id.txt_view));
        gestureView.setView(textView);
    }


}
