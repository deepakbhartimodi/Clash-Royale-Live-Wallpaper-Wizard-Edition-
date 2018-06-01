package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

public class PrefClass extends ContextWrapper {

    public SharedPreferences mPrefs;

    public PrefClass(Context base) {
        super(base);
    }

    public void start() {
        this.mPrefs = getSharedPreferences(null,0);
    }

    public float getSnowSpeed() {
        return this.mPrefs.getFloat(""+C1390R.snowspeed, 0.5f);
    }

    public void setSnowSpeed(float val) {
        this.mPrefs.edit().putFloat(""+ C1390R.snowspeed, val).apply();
    }

    public float getSnowIntensity() {
        return this.mPrefs.getFloat(""+C1390R.snowintensity, 30.0f);
    }

    public void setSnowIntensity(float val) {
        this.mPrefs.edit().putFloat(""+C1390R.snowintensity, val).apply();
    }

    public String getSnowType() {
        return this.mPrefs.getString(""+C1390R.snowtype, "snow_spirit.png");
    }

    public void setSnowType(String val) {
        this.mPrefs.edit().putString(""+C1390R.snowtype, val).apply();
    }

    public String getFireType() {
        return this.mPrefs.getString(""+C1390R.firetype, "fire_spirit.png");
    }

    public void setFireType(String val) {
        this.mPrefs.edit().putString(""+C1390R.firetype, val).apply();
    }

    public boolean getNewSetting() {
        return this.mPrefs.getBoolean(""+C1390R.newsetting, true);
    }

    public void setNewSetting(boolean val) {
        this.mPrefs.edit().putBoolean(""+C1390R.newsetting, val).apply();
    }

    public boolean getDefaultSetting() {
        return this.mPrefs.getBoolean(""+C1390R.defaultsetting, true);
    }

    public void setDefaultSetting(boolean val) {
        this.mPrefs.edit().putBoolean(""+C1390R.defaultsetting, val).apply();
    }

    public int getElectricLine() {
        return this.mPrefs.getInt(""+C1390R.electricline,2);
    }

    public void setElectricLine(int val) {
        this.mPrefs.edit().putInt(""+C1390R.electricline, val).apply();
    }

    public String getElectricColour1Hex() {
        return this.mPrefs.getString(""+C1390R.electriccolour1hex,"#ffffff");
    }

    public void setElectricColour1Hex(String val){
        this.mPrefs.edit().putString(""+C1390R.electriccolour1hex,val).apply();
    }

    public String getElectricColour2Hex() {
        return this.mPrefs.getString(""+C1390R.electriccolour2hex,"#ffffff");
    }

    public void setElectricColour2Hex(String val){
        this.mPrefs.edit().putString(""+C1390R.electriccolour2hex,val).apply();
    }

    public String getElectricColour1Name() {
        return this.mPrefs.getString(""+C1390R.electriccolour1name,"WHITE");
    }

    public void setElectricColour1Name(String val){
        this.mPrefs.edit().putString(""+C1390R.electriccolour1name,val).apply();
    }

    public String getElectricColour2Name() {
        return this.mPrefs.getString(""+C1390R.electriccolour2name,"WHITE");
    }

    public void setElectricColour2Name(String val){
        this.mPrefs.edit().putString(""+C1390R.electriccolour2name,val).apply();
    }
}
