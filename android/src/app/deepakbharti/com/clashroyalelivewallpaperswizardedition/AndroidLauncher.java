package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

public class AndroidLauncher extends Activity implements View.OnClickListener {

	PrefClass prefClass;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		prefClass = new PrefClass(this);
		prefClass.start();

		if(prefClass.getDefaultSetting()){
			prefClass.setSnowSpeed(0.5f);
			prefClass.setSnowIntensity(30f);
			prefClass.setSnowType("snow_spirit.png");
			prefClass.setFireType("fire_spirit.png");
			prefClass.setElectricLine(2);
			prefClass.setElectricColour1Hex("#ffffff");
			prefClass.setElectricColour1Name("WHITE");
			prefClass.setElectricColour2Hex("#ffffff");
			prefClass.setElectricColour2Name("WHITE");
			prefClass.setDefaultSetting(false);
		}

		findViewById(R.id.set_fire_wiz_wallpaper).setOnClickListener(this);
		findViewById(R.id.set_snow_wiz_wallpaper).setOnClickListener(this);
		findViewById(R.id.set_electro_wiz_wallpaper).setOnClickListener(this);
		findViewById(R.id.settings).setOnClickListener(this);
		findViewById(R.id.shareapp).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.set_fire_wiz_wallpaper:
				startWallpaperIntent("fire");
				break;
			case R.id.set_snow_wiz_wallpaper:
				startWallpaperIntent("snow");
				break;
			case R.id.set_electro_wiz_wallpaper:
				startWallpaperIntent("electro");
				break;
			case R.id.settings:
				Intent intent = new Intent(this,Setting.class);
				startActivity(intent);
				break;
			case R.id.shareapp:
				shareApplication();
				break;
		}
	}

	private void shareApplication(){
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT,
				"Check the live wallpaper of Clash Royale Wizards in this application: https://play.google.com/store/apps/details?id=app.deepakbharti.com.clashroyalelivewallpaperswizardedition");
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
	}

	private void startWallpaperIntent(String str){
		Intent intent;
		if (Build.VERSION.SDK_INT >= 16) {
			try {
				intent = new Intent();
				Parcelable componentName;
				if(str.equals("snow")){
					componentName = new ComponentName(this, Snow_WallpaperService.class);
				}else if(str.equals("fire")){
					componentName = new ComponentName(this, Fire_WallpaperService.class);
				}else {
					componentName = new ComponentName(this,Electro_WallpaperService.class);
				}
				intent.setAction("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
				intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", componentName);
				startActivity(intent);
				return;
			} catch (ActivityNotFoundException e) {
				return;
			}
		}
		try {
			intent = new Intent();
			intent.setAction("android.service.wallpaper.LIVE_WALLPAPER_CHOOSER");
			startActivity(intent);
			return;
		} catch (ActivityNotFoundException e2) {
			return;
		}
	}
}