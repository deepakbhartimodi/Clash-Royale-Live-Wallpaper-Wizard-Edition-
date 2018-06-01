package app.deepakbharti.com.clashroyalelivewallpaperswizardedition;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Electro implements Screen {

    private int numberofLines;
    private Color color1, color2;
    private Vector2[] vec1,vec2;
    private Vector2 lefthand, righthand, lefttesla, righttesla;
    private Vector2 leftteslaright1, leftteslaright2, leftteslatop1, leftteslatop2, leftteslaleft1, leftteslaleft2;
    private Vector2 rightteslaleft1, rightteslaleft2, rightteslatop1, rightteslatop2, rightteslaright1, rightteslaright2;
    private int f1853H;
    private int f1854W;
    Game game;
    private SpriteBatch batch;
    private boolean ln;
    private Sprite back_6;
    Random random = new Random();

    public Electro(Game game) {
        this.game = game;
        setquantities();
    }

    private void setquantities() {
        this.batch = new SpriteBatch();
        GFX.setTexture(new Texture("snow_spirit.png"));
        Preferences mpreferences;
        mpreferences = Gdx.app.getPreferences(null);
        numberofLines = mpreferences.getInteger(""+100000006);
        color1 = Color.valueOf(mpreferences.getString(""+100000007));
        color2 = Color.valueOf(mpreferences.getString(""+100000009));
        GFX.setNumberOfBolts(numberofLines);
        GFX.setColour(color1,color2);
        lefthand = new Vector2();
        righthand = new Vector2();
        lefttesla = new Vector2();
        righttesla = new Vector2();

        leftteslaright1 = new Vector2();
        leftteslaright2 = new Vector2();
        leftteslaleft1 = new Vector2();
        leftteslaleft2 = new Vector2();
        leftteslatop1 = new Vector2();
        leftteslatop2 = new Vector2();

        rightteslaright1 = new Vector2();
        rightteslaright2 = new Vector2();
        rightteslaleft1 = new Vector2();
        rightteslaleft2 = new Vector2();
        rightteslatop1 = new Vector2();
        rightteslatop2 = new Vector2();

        vec1 = new Vector2[2];
        vec2 = new Vector2[2];

        this.f1853H = Gdx.graphics.getHeight();
        this.f1854W = Gdx.graphics.getWidth();
        this.ln = this.f1854W >= this.f1853H;

        if(this.ln){
            lefthand.set(((float) this.f1854W)/2.4f,((float) this.f1853H)/3.5f);
            righthand.set(((float) this.f1854W)/1.86f,((float) this.f1853H)/3.2f);
            lefttesla.set(((float) this.f1854W)/3.13f,((float) this.f1853H)/2f);
            righttesla.set(((float) this.f1854W)/1.52f,((float) this.f1853H)/2f);

            leftteslaright1.set(((float) this.f1854W)/3.26f,((float) this.f1853H)/1.58f);
            leftteslaright2.set(((float) this.f1854W)/3.25f,((float) this.f1853H)/1.56f);
            leftteslaleft1.set(((float) this.f1854W)/3.95f,((float) this.f1853H)/1.58f);
            leftteslaleft2.set(((float) this.f1854W)/3.9f,((float) this.f1853H)/1.56f);
            leftteslatop1.set(((float) this.f1854W)/3.6f,((float) this.f1853H)/1.35f);
            leftteslatop2.set(((float) this.f1854W)/3.65f,((float) this.f1853H)/1.37f);

            rightteslaleft1.set(((float) this.f1854W)/1.49f,((float) this.f1853H)/1.58f);
            rightteslaleft2.set(((float) this.f1854W)/1.48f,((float) this.f1853H)/1.56f);
            rightteslaright1.set(((float) this.f1854W)/1.38f,((float) this.f1853H)/1.58f);
            rightteslaright2.set(((float) this.f1854W)/1.37f,((float) this.f1853H)/1.56f);
            rightteslatop1.set(((float) this.f1854W)/1.42f,((float) this.f1853H)/1.35f);
            rightteslatop2.set(((float) this.f1854W)/1.42f,((float) this.f1853H)/1.37f);

            vec1[0] = new Vector2(((float) this.f1854W)/2.37f,((float) this.f1853H)/3.3f);
            vec1[1] = new Vector2(((float) this.f1854W)/3.15f,((float) this.f1853H)/2f);

            vec2[0] = new Vector2(((float) this.f1854W)/1.88f,((float) this.f1853H)/3.1f);
            vec2[1] = new Vector2(((float) this.f1854W)/1.53f,((float) this.f1853H)/2f);

        }else{
            lefthand.set(((float) this.f1854W)/2.4f,((float) this.f1853H)/3.5f);
            righthand.set(((float) this.f1854W)/1.6f,((float) this.f1853H)/3.3f);
            lefttesla.set(((float) this.f1854W)/4.1f,((float) this.f1853H)/2.6f);
            righttesla.set(((float) this.f1854W)/1.26f,((float) this.f1853H)/2.6f);

            leftteslaright1.set(((float) this.f1854W)/4.8f,((float) this.f1853H)/1.9f);
            leftteslaright2.set(((float) this.f1854W)/4.7f,((float) this.f1853H)/2f);
            leftteslaleft1.set(((float) this.f1854W)/11.3f,((float) this.f1853H)/1.87f);
            leftteslaleft2.set(((float) this.f1854W)/11.2f,((float) this.f1853H)/1.9f);
            leftteslatop1.set(((float) this.f1854W)/6.7f,((float) this.f1853H)/1.65f);
            leftteslatop2.set(((float) this.f1854W)/6.65f,((float) this.f1853H)/1.6f);

            rightteslaleft1.set(((float) this.f1854W)/1.2f,((float) this.f1853H)/1.9f);
            rightteslaleft2.set(((float) this.f1854W)/1.25f,((float) this.f1853H)/2f);
            rightteslaright1.set(((float) this.f1854W)/1.09f,((float) this.f1853H)/1.87f);
            rightteslaright2.set(((float) this.f1854W)/1.08f,((float) this.f1853H)/1.9f);
            rightteslatop1.set(((float) this.f1854W)/1.14f,((float) this.f1853H)/1.65f);
            rightteslatop2.set(((float) this.f1854W)/1.13f,((float) this.f1853H)/1.6f);

            vec1[0] = new Vector2(((float) this.f1854W)/2.4f,((float) this.f1853H)/3.5f);
            vec1[1] = new Vector2(((float) this.f1854W)/4.1f,((float) this.f1853H)/2.6f);

            vec2[0] = new Vector2(((float) this.f1854W)/1.6f,((float) this.f1853H)/3.3f);
            vec2[1] = new Vector2(((float) this.f1854W)/1.26f,((float) this.f1853H)/2.6f);
        }

        this.back_6 = get_sprite(this.ln ? "electro_wiz_land.png" : "electro_wiz_port.png",
                0.5f * ((float) this.f1854W), 0.5f * ((float) this.f1853H),
                (float) this.f1854W, (float) this.f1853H);

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
    }

    @Override
    public void show() {

    }

    private float timer = 0;
    private long endPauseTime = 0;

    @Override
    public void render(float delta) {
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
        int radius = random.nextInt(10);

        drawSphere(radius);
        GFX.drawChainLightningRandomBetweenPoints(this.batch,lefttesla, leftteslaright1, leftteslaright2);
        GFX.drawChainLightningRandomBetweenPoints(this.batch,leftteslaright1, leftteslatop1, leftteslatop2);
        GFX.drawChainLightningRandomBetweenPoints(this.batch,leftteslatop1, leftteslaleft1, leftteslaleft2);

        GFX.drawChainLightningRandomBetweenPoints(this.batch,righttesla, rightteslaleft1, rightteslaleft2);
        GFX.drawChainLightningRandomBetweenPoints(this.batch,rightteslaleft1, rightteslatop1, rightteslatop2);
        GFX.drawChainLightningRandomBetweenPoints(this.batch,rightteslatop1, rightteslaright1, rightteslaright2);

        GFX.drawSphereLightning(this.batch,lefthand,3,2,0,2);
        GFX.drawSphereLightning(this.batch,righthand,3,2,0,2);
        timer += delta;
        if(timer <= 1f) {
            GFX.drawChainLightning(this.batch,vec1);
            GFX.drawChainLightning(this.batch,vec2);
        }else if(timer >= 4f) {
            timer = 0f;
        }
        this.batch.enableBlending();
        this.batch.end();
    }

    public void drawSphere(int radius){
        GFX.drawSphereLightning(this.batch,lefttesla,3,radius,radius,3);
        GFX.drawSphereLightning(this.batch,righttesla,3,radius,radius,3);
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
