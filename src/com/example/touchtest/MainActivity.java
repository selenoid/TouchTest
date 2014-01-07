package com.example.touchtest;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
    private static final String DEBUG_TAG = "myApp";
	private Canvas canvas;
	private Bitmap bg;
	public int count = 0;
	public View v2;
	private int viewCount;

	@Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
	        	//createCircles(event);
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
		
		LayoutInflater vi = (LayoutInflater) getApplicationContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v2 = vi.inflate(R.layout.item, null);
		
		bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bg);
		
        int x = (int)event.getX();
	    int y = (int)event.getY();
	    
		//Change background color
		v2.setBackgroundColor(getRandomColor());
		v2.layout(x, y, x+30, y+30);
		v2.invalidate();

		// insert into main view
		View insertPoint = findViewById(R.id.main);
		
		Log.d(DEBUG_TAG, "Creating view...");
		viewCount++;

		((ViewGroup) insertPoint).addView(v2);
		
		
	    
	    //v2.setX(x);
	    //v2.setY(y);
	    
	    Paint paint = new Paint();
        paint.setColor(Color.parseColor("#CD5C5C"));
        
        int r = (int) Math.round ((Math.random() * 20) + 2);
        
        canvas.drawCircle(Math.round(x-(r*0.5)), Math.round(y-(r*0.5)), r, paint);
        
        //LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        v2.setBackgroundDrawable(new BitmapDrawable(bg));   
         String text = ">> "+x+" , "+ y;

		/*
		 * Timer T = new Timer(); TimerTask task = new TimerTask() {
		 * 
		 * @Override public void run() {
		 * 
		 * removeChild(); count++; Log.d("myApp", "count : " + count); } };
		 * 
		 * T.schedule(task, 1000);
		 */
		
		
		
		/*
		int x = (int)event.getX();
	    int y = (int)event.getY();
	    
	    Paint paint = new Paint();
        paint.setColor(Color.parseColor("#CD5C5C"));
        
        int r = (int) Math.round ((Math.random() * 20) + 2);
        
        canvas.drawCircle(Math.round(x-(r*0.5)), Math.round(y-(r*0.5)), r, paint);
        
        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));   
         String text = ">> "+x+" , "+ y;
        */
	    
	   
	}
	
	public int getRandomColor() {
			
			int rand = (int)(Math.random() * 4);
			int nColor = 0;
			
			switch (rand)
			{
				case 0:
					nColor = Color.BLUE;
				break;
				
				case 1:
					nColor = Color.YELLOW;
				break;
				
				case 2:
					nColor = Color.MAGENTA;
				break;
				
				case 3:
					nColor = Color.GREEN;
				break;
				
				default:
					nColor = Color.CYAN;
			
			}
			
			return nColor;
		}
}