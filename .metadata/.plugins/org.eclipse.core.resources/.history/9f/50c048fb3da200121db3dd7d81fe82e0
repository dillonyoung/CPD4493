package ca.dillonyoung.tracare;

/**
 * Filename: SplashActivity.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set the layout for the activity
		setContentView(R.layout.splash);

		// Get a reference to the image view
		ImageView imgSplash = (ImageView) findViewById(R.id.imgLogo);

		// Begin the animation
		imgSplash.startAnimation(AnimationUtils.loadAnimation(this,
				R.anim.alpha));
	}
	
	public void onResume() {
		
		super.onResume();
		
		// Start the main activity
		Handler handler = new Handler(); 
		
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SplashActivity.this, Main.class);
				startActivity(intent);
			} 
			
		}, 5000);
	}
}
