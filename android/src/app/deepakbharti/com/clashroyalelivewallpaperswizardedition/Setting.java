package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class Setting extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    static PrefClass prefClass;
    private SeekBar snow_speed, snow_intensity;
    private RadioButton snow_spirit, star_shaped;
    private RadioButton fire_spirit, meteor;
    private RadioButton one_line, two_line, three_line;
    private Spinner colour1,colour2;
    private ColourCustomAdapter colourCustomAdapter1, colourCustomAdapter2;
    private String colourname1hex, colourname2hex, colourname1name, colourname2name;

    String[] coloursname = {"WHITE","BLUE","SKY","PURPLE","ROYAL","VIOLET"};

    Button save;
    float snow_value;
    float speed_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        prefClass = new PrefClass(this);
        prefClass.start();

        snow_speed = (SeekBar) findViewById(R.id.snow_speed);
        snow_intensity = (SeekBar) findViewById(R.id.snow_intensity);

        snow_spirit = (RadioButton) findViewById(R.id.snow_spirit);
        star_shaped = (RadioButton) findViewById(R.id.star_shaped);

        fire_spirit = (RadioButton) findViewById(R.id.fire_spirit);
        meteor = (RadioButton) findViewById(R.id.meteor);

        one_line = (RadioButton) findViewById(R.id.one_electric_line);
        two_line = (RadioButton) findViewById(R.id.two_electric_line);
        three_line = (RadioButton) findViewById(R.id.three_electric_line);

        colour1 = (Spinner) findViewById(R.id.colour1);
        colour1.setOnItemSelectedListener(this);
        colour2 = (Spinner) findViewById(R.id.colour2);
        colour2.setOnItemSelectedListener(this);

        colourCustomAdapter1 = new ColourCustomAdapter(this,coloursname);
        colourCustomAdapter2 = new ColourCustomAdapter(this,coloursname);
        colour1.setAdapter(colourCustomAdapter1);
        colour2.setAdapter(colourCustomAdapter2);

        seekbars();

        setAllSettingValues();

        save = (Button) findViewById(R.id.save_setting);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_setting:
                saveSettings();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.colour1:
                colourname1hex = getColorHex(coloursname[i]);
                colourname1name = coloursname[i];
                break;
            case R.id.colour2:
                colourname2hex = getColorHex(coloursname[i]);
                colourname2name = coloursname[i];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private String getColorHex(String cname){
        switch (cname){
            case "WHITE":
                cname = "#ffffff";
                break;
            case "BLUE":
                cname = "#0000ff";
                break;
            case "SKY":
                cname = "#87ceeb";
                break;
            case "PURPLE":
                cname = "#a020f0";
                break;
            case "ROYAL":
                cname = "#4169e1";
                break;
            case "VIOLET":
                cname = "#ee82ee";
                break;
        }
        return cname;
    }

    private void setAllSettingValues(){
        snow_speed.setProgress((int)(prefClass.getSnowSpeed()/0.5f));
        snow_intensity.setProgress((int) (prefClass.getSnowIntensity()/30));

        if (prefClass.getSnowType().equals("snow_spirit.png")) {
            snow_spirit.setChecked(true);
        } else {
            star_shaped.setChecked(true);
        }

        if (prefClass.getFireType().equals("fire_spirit.png")) {
            fire_spirit.setChecked(true);
        } else {
            meteor.setChecked(true);
        }

        if(prefClass.getElectricLine() == 1){
            one_line.setChecked(true);
        }else if(prefClass.getElectricLine() == 2){
            two_line.setChecked(true);
        }else {
            three_line.setChecked(true);
        }
        colour1.setSelection(getColourIndex(colour1,prefClass.getElectricColour1Name()));
        colour2.setSelection(getColourIndex(colour2,prefClass.getElectricColour2Name()));
    }

    private int getColourIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }

    private void saveSettings() {
        Float snow_speed = speed_value;
        Float snow_intensity = snow_value;
        String snow_type = "";
        String fire_type = "";
        int electric_line = 1;

        if (snow_spirit.isChecked()) {
            snow_type = "snow_spirit.png";
        } else if (star_shaped.isChecked()) {
            snow_type = "star_shaped.png";
        }

        if (fire_spirit.isChecked()) {
            fire_type = "fire_spirit.png";
        } else if (meteor.isChecked()) {
            fire_type = "meteor.png";
        }

        if(one_line.isChecked()) {
            electric_line = 1;
        }else if(two_line.isChecked()) {
            electric_line = 2;
        }else if(three_line.isChecked()) {
            electric_line = 3;
        }

        prefClass.setSnowSpeed(snow_speed);
        prefClass.setSnowIntensity(snow_intensity);
        prefClass.setSnowType(snow_type);
        prefClass.setFireType(fire_type);
        prefClass.setElectricLine(electric_line);
        prefClass.setNewSetting(true);
        prefClass.setElectricColour1Hex(colourname1hex);
        prefClass.setElectricColour1Name(colourname1name);
        prefClass.setElectricColour2Hex(colourname2hex);
        prefClass.setElectricColour2Name(colourname2name);
        Intent i = new Intent(Setting.this, AndroidLauncher.class);
        startActivity(i);
        finish();
    }

    private void seekbars() {

        snow_speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                speed_value = 0.5f * i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        snow_intensity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                snow_value = 30 * i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
