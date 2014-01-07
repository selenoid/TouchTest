package com.example.touchtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
     private static final String DEBUG_TAG = "myApp";
	private Canvas canvas;
	private Bitmap bg;

	@Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bg);
        setContentView(R.layout.activity_main);
     }
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onTouchEvent(MotionEvent event){ 
	        
	    int action = MotionEventCompat.getActionMasked(event);
	        
	    switch(action) {
	        case (MotionEvent.ACTION_DOWN) :
	            Log.d(DEBUG_TAG,"Action was DOWN");
	        	createCircles(event);
	            return true;
	        case (MotionEvent.ACTION_MOVE) :
	            //Log.d(DEBUG_TAG,"Action was MOVE");
	        createCircles(event);
	            return true;
	        case (MotionEvent.ACTION_UP) :
	            Log.d(DEBUG_TAG,"Action was UP");
	            return true;
	        case (MotionEvent.ACTION_CANCEL) :
	            //Log.d(DEBUG_TAG,"Action was CANCEL");
	            return true;
	        case (MotionEvent.ACTION_OUTSIDE) :
	            Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
	                    "of current screen element");
	            return true;      
	        default : 
	            return super.onTouchEvent(event);
	    }      
	}

	private void createCircles(MotionEvent event) {
		Log.d(DEBUG_TAG, "Drawing circles...");
		
		int x = (int)event.getX();
	    int y = (int)event.getY();
	    
	    Paint paint = new Paint();
        paint.setColor(Color.parseColor("#CD5C5C"));
        
        int r = (int) Math.round ((Math.random() * 20) + 2);
        
        canvas.drawCircle(Math.round(x-(r*0.5)), Math.round(y-(r*0.5)), r, paint);
        
        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));   
        
	    
	    String text = ">> "+x+" , "+ y;
	}
}