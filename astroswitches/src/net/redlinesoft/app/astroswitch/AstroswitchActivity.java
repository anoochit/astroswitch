package net.redlinesoft.app.astroswitch;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

@SuppressLint("ShowToast")
public class AstroswitchActivity extends Activity {
	/** Called when the activity is first created. */
	private AdView adView;
	private MediaPlayer mMediaPlayer = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
		// Create the adView
				adView = new AdView(this, AdSize.SMART_BANNER, "a14fe714e4169f1");
				// Lookup your LinearLayout assuming it’s been given
				// the attribute android:id="@+id/mainLayout"
				LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
				// Add the adView to it
				layout.addView(adView);
				// Initiate a generic request to load it with an ad
				adView.loadAd(new AdRequest());
				//adView.loadAd(new AdRequest().addTestDevice("EEEC201218AC425593883C4F37DAA5C9"));

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {

			// references to our images
 		public Integer[] mSounds = { R.raw.switch01,
 				R.raw.switch02, R.raw.switch03, R.raw.switch04,
 				R.raw.switch05, R.raw.switch06, R.raw.switch07,
 				R.raw.switch08, R.raw.switch09, R.raw.switch10,
 				R.raw.switch11, R.raw.switch12, R.raw.switch13,
 				R.raw.switch14, R.raw.switch15, R.raw.switch16,
 				R.raw.switch17, R.raw.switch18, R.raw.switch19,
 				R.raw.switch20, R.raw.switch21, R.raw.switch22, 
 				R.raw.switch23, R.raw.switch24, R.raw.switch25, 
 				R.raw.switch26, R.raw.switch27, R.raw.switch28, 
 				R.raw.switch29, R.raw.switch30, R.raw.switch31, 
 				R.raw.switch32, R.raw.switch33, R.raw.switch34, 
 				R.raw.switch35, R.raw.switch36, R.raw.switch37, 
 				R.raw.switch38, R.raw.switch39, R.raw.switch40, 
 				R.raw.switch_s1, R.raw.switch_s3, R.raw.switch_meteor,
 				R.raw.switch_fusion, R.raw.switch_basestage, R.raw.switch_elec_state, 
 				R.raw.switch_fire_state, R.raw.switch_magnet_state, R.raw.switch_costmic_state, 
 				R.raw.switch_fusion_state, R.raw.switch_limit_state, R.raw.switch_dd1_state, R.raw.switch_dd3_state };
 		
 		public Integer[] mSoundsFinal = { R.raw.switch01_final,
 				R.raw.switch02_final, R.raw.switch03_final, R.raw.switch04_final,
 				R.raw.switch05_final, R.raw.switch06_final, R.raw.switch07_final,
 				R.raw.switch08_final, R.raw.switch09_final, R.raw.switch10_final,
 				R.raw.switch11_final, R.raw.switch12_final, R.raw.switch13_final,
 				R.raw.switch14_final, R.raw.switch15_final, R.raw.switch16_final,
 				R.raw.switch17_final, R.raw.switch18_final, R.raw.switch19_final,
 				R.raw.switch20_final, R.raw.switch21_final, R.raw.switch22_final, 
 				R.raw.switch23_final, R.raw.switch24_final, R.raw.switch25_final, 
 				R.raw.switch26_final, R.raw.switch27_final, R.raw.switch28_final, 
 				R.raw.switch29_final, R.raw.switch30_final, R.raw.switch31_final, 
 				R.raw.switch32_final, R.raw.switch33_final, R.raw.switch34_final, 
 				R.raw.switch35_final, R.raw.switch36_final, R.raw.switch37_final, 
 				R.raw.switch38_final, R.raw.switch39_final, R.raw.switch40_final, 
 				R.raw.switch01, R.raw.switch03, R.raw.switch_meteor_final,
 				R.raw.switch_fusion_final  };

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				if (position<44) {
					playSound(mSounds[position]);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					playSound(mSoundsFinal[position]);
				} else {
					playSound(mSounds[position]);
				}
				Log.d("POS",String.valueOf(position));
			}
		});

	}

	/*
	 * Playsound
	 */
	public void playSound(int resources) {

		mMediaPlayer = MediaPlayer.create(this, resources);
		try {
			mMediaPlayer.prepareAsync();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mMediaPlayer.start();
		
	}

	public class ImageAdapter extends BaseAdapter {
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return mThumbIds.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) { // if it's not recycled, initialize some
				// attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(162, 130));
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(mThumbIds[position]);
			return imageView;
		}

		// references to our images
		private Integer[] mThumbIds = { R.drawable.switch01,
				R.drawable.switch02, R.drawable.switch03, R.drawable.switch04,
				R.drawable.switch05, R.drawable.switch06, R.drawable.switch07,
				R.drawable.switch08, R.drawable.switch09, R.drawable.switch10,
				R.drawable.switch11, R.drawable.switch12, R.drawable.switch13,
				R.drawable.switch14, R.drawable.switch15, R.drawable.switch16,
				R.drawable.switch17, R.drawable.switch18, R.drawable.switch19,
				R.drawable.switch20, R.drawable.switch21, R.drawable.switch22, 
				R.drawable.switch23, R.drawable.switch24, R.drawable.switch25, 
				R.drawable.switch26, R.drawable.switch27, R.drawable.switch28, 
				R.drawable.switch29, R.drawable.switch30, R.drawable.switch31, 
				R.drawable.switch32, R.drawable.switch33, R.drawable.switch34, 
				R.drawable.switch35, R.drawable.switch36, R.drawable.switch37, 
				R.drawable.switch38, R.drawable.switch39, R.drawable.switch40, 
				R.drawable.switch_s1, R.drawable.switch_s3, R.drawable.switch_meteor,
				R.drawable.switch_fusion, R.drawable.switch_basestate, R.drawable.switch_elecstate, 
				R.drawable.switch_firestate, R.drawable.switch_magnetstate, R.drawable.switch_cosmictstate,
				R.drawable.switch_fusionstate, R.drawable.switch_basestate, R.drawable.switch_dds1, R.drawable.switch_dds3 };

	}

}