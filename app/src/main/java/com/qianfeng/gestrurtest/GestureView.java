package com.qianfeng.gestrurtest;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2015/3/17.
 */
public class GestureView extends View implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    //手势
    private GestureDetector detector;
    private static final String TAG="GestureView";
    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public GestureView(Context context) {
        super(context);
        detector=new GestureDetector(context,this);
        detector.setOnDoubleTapListener(this);
    }

    public GestureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        detector=new GestureDetector(context,this);
        detector.setOnDoubleTapListener(this);
    }

    public GestureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        detector=new GestureDetector(context,this);
        detector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    //----------------手势监听----------------------

    /**
     * 按下
     * @param motionEvent
     * @return 一般为true
     */
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.d(TAG,"onDown");
        return true;
    }

    /**
     * 短按,没有移动，100毫秒
     * @param motionEvent
     */
    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.d(TAG,"onShowPress");
    }

    /**
     * 单击抬起时，没有移动，不超过600毫秒
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.d(TAG,"onSingleTapUp");
        return false;
    }



    /**
     * 长按，没有移动，时间超过600毫秒时调用
     * @param motionEvent
     */
    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.d(TAG,"onLongPress");
    }
    /**
     * 滚动时
     * @param motionEvent 滚动开始时的点
     * @param motionEvent2 当前的点
     * @param v 滚动的x距离
     * @param v2 滚动的y距离
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        Log.d(TAG,String.format("onScroll dx:%.2f,dy:%.2f",v,v2));
        ViewCompat.setX(view, ViewCompat.getX(view) - v);
        ViewCompat.setY(view, ViewCompat.getY(view) - v2);
        return true;
    }
    /**
     * 抛动,v或者v1的绝对值有一个大于200就会被调用
     * @param motionEvent
     * @param motionEvent2
     * @param v x轴上的速度(像素/每秒)
     * @param v2 y轴上的速度
     * @return
     */
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        Log.d(TAG,String.format("onFling dx:%.2f,dy:%.2f",v,v2));
        if(Math.abs(v)>Math.abs(v2)){
            if(v>0){
                ViewCompat.animate(view).x(getWidth()-view.getWidth()).setDuration(2000).start();
            }else{
                ViewCompat.animate(view).x(ViewCompat.getX(this)).setDuration(2000).start();
            }
        }else{
            if(v2>0){
                ViewCompat.animate(view).y(getHeight()-view.getHeight()).setDuration(2000).start();
            }else{
                ViewCompat.animate(view).y(ViewCompat.getY(this)).setDuration(2000).start();
            }
        }
        return true;
    }
    //------------------双击监听-----------------------

    /**
     *  双击中，单击完成
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    /**
     * 双击，第二次点击时
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    /**
     * 双击剩余的操作
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
