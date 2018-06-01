package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;
import java.util.Random;

public class Fire implements Screen {

    float snowSpeed, snowIntesity;
    String fireType;
    private int f1853H;
    private int f1854W;
    Game game;
    private SpriteBatch batch;
    private boolean ln;
    private int nr_snow_6;
    private Sprite snow1_6;
    private float[][] snow1_coord_6;
    private Sprite snow2_6;
    private float[][] snow2_coord_6;
    private Sprite snow3_6;
    private float[][] snow3_coord_6;
    private Sprite snow4_6;
    private Sprite back_6;
    private float[][] snow4_coord_6;
    private Random f1856r = new Random();
    private float[] dim_6 = new float[4];
    private float[] down_limit = new float[this.dim_6.length];
    private float[] down_limit_add = new float[this.dim_6.length];
    private float[] right_limit = new float[this.dim_6.length];
    private float[] left_limit = new float[this.dim_6.length];
    private float[][] twingle;
    private float[][] snow_vel_6 = ((float[][]) Array.newInstance(Float.TYPE, new int[]{this.dim_6.length, 2}));
    private ParticleEffect particleEffect;

    public Fire(Game game) {
        this.game = game;
        setquantities();
    }

    private void setquantities() {
        this.batch = new SpriteBatch();

        Preferences mpreferences;
        mpreferences = Gdx.app.getPreferences(null);
        snowSpeed = mpreferences.getFloat(""+100000000);
        snowIntesity = mpreferences.getFloat(""+100000001);
        fireType = mpreferences.getString(""+100000003);

        this.f1853H = Gdx.graphics.getHeight();
        this.f1854W = Gdx.graphics.getWidth();
        this.ln = this.f1854W >= this.f1853H;

        this.particleEffect = new ParticleEffect();
        this.particleEffect.load(Gdx.files.internal("fire_wiz_flame.p"),Gdx.files.internal(""));
        this.particleEffect.start();
        if(this.ln){
            this.particleEffect.scaleEffect(2f,2f,2);
            this.particleEffect.setPosition(((float) this.f1854W)/2.05f,((float) this.f1853H)/3.3f);
        }else{
            this.particleEffect.scaleEffect(2f,2f,2);
            this.particleEffect.setPosition(((float) this.f1854W)/1.8f,((float) this.f1853H)/3.6f);
        }

        this.back_6 = get_sprite(this.ln ? "fire_wiz_land.png" : "fire_wiz_port.png",
                0.5f * ((float) this.f1854W), 0.5f * ((float) this.f1853H),
                (float) this.f1854W, (float) this.f1853H);

        this.nr_snow_6 = (int) (snowIntesity * 1.5f);
        //this.windspeed = (0.5f *0.0016f) / 0.0016f;
        this.snow1_coord_6 = (float[][]) Array.newInstance(Float.TYPE, new int[]{2, this.nr_snow_6 * 2});
        this.snow2_coord_6 = (float[][]) Array.newInstance(Float.TYPE, new int[]{2, this.nr_snow_6});
        this.snow3_coord_6 = (float[][]) Array.newInstance(Float.TYPE, new int[]{2, (int) (((float) this.nr_snow_6) * 0.3f)});
        this.snow4_coord_6 = (float[][]) Array.newInstance(Float.TYPE, new int[]{2, (int) (((float) this.nr_snow_6) * 0.03f)});

        if (this.ln) {
            this.dim_6[0] = ((float) this.f1853H) * 0.0045f;
            this.dim_6[1] = ((float) this.f1853H) * 0.0095f;
            this.dim_6[2] = ((float) this.f1853H) * 0.018f;
            this.dim_6[3] = ((float) this.f1853H) * 0.028f;
        } else {
            this.dim_6[0] = ((float) this.f1853H) * 0.0028f;
            this.dim_6[1] = ((float) this.f1853H) * 0.006f;
            this.dim_6[2] = ((float) this.f1853H) * 0.011f;
            this.dim_6[3] = ((float) this.f1853H) * 0.016f;
        }

        this.snow1_6 = get_sprite(fireType, 0.0f, 0.0f, this.dim_6[0], this.dim_6[0]);
        this.snow2_6 = get_sprite(fireType, 0.0f, 0.0f, this.dim_6[1], this.dim_6[1]);
        this.snow3_6 = get_sprite(fireType, 0.0f, 0.0f, this.dim_6[2], this.dim_6[2]);
        this.snow4_6 = get_sprite(fireType, 0.0f, 0.0f, this.dim_6[3], this.dim_6[3]);

        int i;
        for (i = 0; i < this.dim_6.length; i++) {
            this.right_limit[i] = ((float) this.f1854W) + (2.0f * this.dim_6[i]);
            this.left_limit[i] = -2.0f * this.dim_6[i];
            this.down_limit[i] = -this.dim_6[i];
            this.down_limit_add[i] = ((float) this.f1853H) + this.dim_6[i];
        }
        for (i = 0; i < this.nr_snow_6; i++) {
            this.snow1_coord_6[0][i] = (float) this.f1856r.nextInt(this.f1854W);
            this.snow1_coord_6[1][i] = (float) this.f1856r.nextInt(this.f1853H);
            this.snow2_coord_6[0][i] = (float) this.f1856r.nextInt(this.f1854W);
            this.snow2_coord_6[1][i] = (float) this.f1856r.nextInt(this.f1853H);
        }
        for (i = 0; i < ((int) (((float) this.nr_snow_6) * 0.3f)); i++) {
            this.snow3_coord_6[0][i] = (float) this.f1856r.nextInt(this.f1854W);
            this.snow3_coord_6[1][i] = (float) this.f1856r.nextInt(this.f1853H);
        }
        for (i = 0; i < ((int) (((float) this.nr_snow_6) * 0.03f)); i++) {
            this.snow4_coord_6[0][i] = (float) this.f1856r.nextInt(this.f1854W);
            this.snow4_coord_6[1][i] = (float) this.f1856r.nextInt(this.f1853H);
        }
        this.twingle = (float[][]) Array.newInstance(Float.TYPE, new int[]{4, this.nr_snow_6});

        this.snow_vel_6[0][0] = ((float) this.f1853H) * (snowSpeed *0.0016f);
        this.snow_vel_6[0][1] = this.snow_vel_6[0][0] * 1.416f;
        this.snow_vel_6[1][0] = this.snow_vel_6[0][0] * 0.8333f;
        this.snow_vel_6[1][1] = this.snow_vel_6[0][0] * 1.833f;
        this.snow_vel_6[2][0] = this.snow_vel_6[0][0] * 0.416f;
        this.snow_vel_6[2][1] = this.snow_vel_6[0][0] * 2.5f;
        this.snow_vel_6[3][0] = this.snow_vel_6[0][0] * 0.23f;
        this.snow_vel_6[3][1] = this.snow_vel_6[0][0] * 3.7f;

        System.gc();
    }

    private Sprite get_sprite(String tex_name, float cx, float cy, float w, float h) {
        Texture actorTexture = new Texture(Gdx.files.internal(tex_name));
        actorTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(actorTexture);
        sprite.setBounds(cx - (w * 0.5f), cy - (h * 0.5f), w, h);
        return sprite;
    }

    private void disposeAll() {
        if (this.batch != null) {
            this.batch.dispose();
        }
        if (this.back_6 != null) {
            this.back_6.getTexture().dispose();
        }
        if (this.snow1_6 != null) {
            this.snow1_6.getTexture().dispose();
        }
        if (this.snow2_6 != null) {
            this.snow2_6.getTexture().dispose();
        }
        if (this.snow3_6 != null) {
            this.snow3_6.getTexture().dispose();
        }
        if (this.snow4_6 != null) {
            this.snow4_6.getTexture().dispose();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        run();
    }

    private void run() {
        Preferences npref = Gdx.app.getPreferences(null);
        if (npref.getBoolean(""+100000004)) {
            disposeAll();
            setquantities();
            npref.putBoolean(""+100000004,false);
            npref.flush();
        }

        if (!(this.f1853H == Gdx.graphics.getHeight() && this.f1854W == Gdx.graphics.getWidth())) {
            disposeAll();
            setquantities();
        }

        Gdx.gl.glViewport(0, 0, this.f1854W, this.f1853H);
        Gdx.gl.glClear(16640);
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.batch.begin();
        this.batch.disableBlending();
        this.back_6.draw(this.batch);
        this.batch.enableBlending();
        snow_6(this.batch, this.snow1_6, this.nr_snow_6, this.snow1_coord_6, 0);
        snow_6(this.batch, this.snow2_6, this.nr_snow_6, this.snow2_coord_6, 1);
        snow_6(this.batch, this.snow3_6, (int) (((float) this.nr_snow_6) * 0.3f), this.snow3_coord_6, 2);
        snow_6(this.batch, this.snow4_6, (int) (((float) this.nr_snow_6) * 0.03f), this.snow4_coord_6, 3);
        this.particleEffect.draw(this.batch, Gdx.graphics.getDeltaTime());
        this.batch.end();
    }

    private void snow_6(SpriteBatch batch, Sprite snow, int nr_particle, float[][] coords, int snowindex) {
        for (int i = 0; i < nr_particle; i++) {
            float[] fArr = coords[0];
            fArr[i] = fArr[i] + (this.snow_vel_6[snowindex][0] + this.twingle[snowindex][i]);
            fArr = coords[1];
            fArr[i] = fArr[i] - this.snow_vel_6[snowindex][1];
            if (coords[0][i] > this.right_limit[snowindex]) {
                coords[0][i] = -this.dim_6[snowindex];
                coords[1][i] = (float) this.f1856r.nextInt(this.f1853H);
                //this.twingle[snowindex][i] = (((float) (this.f1856r.nextInt((int) this.c6) - ((int) this.c7))) * this.windspeed) / 200.0f;
            }
            if (coords[0][i] < this.left_limit[snowindex]) {
                fArr = coords[0];
                fArr[i] = fArr[i] + this.right_limit[snowindex];
                coords[1][i] = (float) this.f1856r.nextInt(this.f1853H);
                //this.twingle[snowindex][i] = (((float) (this.f1856r.nextInt((int) this.c6) - ((int) this.c7))) * this.windspeed) / 200.0f;
            }
            if (coords[1][i] < this.down_limit[snowindex]) {
                fArr = coords[1];
                fArr[i] = fArr[i] + this.down_limit_add[snowindex];
                coords[0][i] = (float) this.f1856r.nextInt(this.f1854W);
                //this.twingle[snowindex][i] = (((float) (this.f1856r.nextInt((int) this.c6) - ((int) this.c7))) * this.windspeed) / 200.0f;
            }
            snow.setPosition(coords[0][i], coords[1][i]);
            snow.draw(batch);
        }
    }

    @Override
    public void resize(int width, int height) {
        if (width != this.f1854W || this.f1853H != height) {
            disposeAll();
            setquantities();
            System.gc();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        disposeAll();
    }
}
