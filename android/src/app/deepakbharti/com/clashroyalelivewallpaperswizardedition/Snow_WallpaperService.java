package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;

public class Snow_WallpaperService extends AndroidLiveWallpaperService {

    @Override
    public void initialize(ApplicationListener listener) {
        super.initialize(listener);
    }

    @Override
    public void onCreateApplication() {
        super.onCreateApplication();

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGLSurfaceView20API18 = true;
        config.useCompass = false;
        config.useWakelock = false;
        config.useAccelerometer = false;
        config.getTouchEventsForLiveWallpaper = false;
        initialize(new Snow_Starter(),config);
    }

    public void onDeepPauseApplication() {
        super.onDeepPauseApplication();
    }
}
