package net.redlinesoft.app.astroswitch;


import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.google.ads.*;

public class AstroswitchActivity extends Activity {
	/** Called when the activity is first created. */
	private AdView adView;
	private MediaPlayer mMediaPlayer = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Create the adView
				adView = new AdView(this, AdSize.BANNER, "a14fe714e4169f1");
				// Lookup your LinearLayout assuming it’s been given
				// the attribute android:id="@+id/mainLayout"
				LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
				// Add the adView to it
				layout.addView(adView);
				// Initiate a generic request to load it with an ad
				adView.loadAd(new AdRequest());

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {

			// references to our images
			public Integer[] mSounds = { R.raw.rocket_switch,
					R.raw.launcher_switch, R.raw.drill_switch,
					R.raw.radar_switch, R.raw.magic_hand_switch,
					R.raw.camera_switch, R.raw.parachute_switch,
					R.raw.chainsaw_switch, R.raw.hopping_switch,
					R.raw.elek_states, R.raw.scissors_switch,
					R.raw.beat_switch, R.raw.chainarray_switch,
					R.raw.smoke_switch, R.raw.spike_switch, R.raw.winch_switch,
					R.raw.flash_switch, R.raw.shield_switch, R.raw.gatling_switch,
					R.raw.fire_states  };

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				playSound(mSounds[position]);
			}
		});

	}

	/*
	 * Playsound
	 */
	public void playSound(int resources) {
		if (mMediaPlayer != null) {
			mMediaPlayer.stop();
			mMediaPlayer.release();
		}
		mMediaPlayer = MediaPlayer.create(this, resources);
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
				imageView.setLayoutParams(new GridView.LayoutParams(161, 102));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
				R.drawable.switch20};

	}

}