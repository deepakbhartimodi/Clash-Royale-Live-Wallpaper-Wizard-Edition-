package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import android.view.SurfaceHolder;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;

public class Fire_WallpaperService extends AndroidLiveWallpaperService {

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
        initialize(new Fire_Starter(),config);
    }

    @Override
    public SurfaceHolder getSurfaceHolder() {
        return super.getSurfaceHolder();
    }

    public void onDeepPauseApplication() {
        super.onDeepPauseApplication();
    }
}
