package io.github.Vortigerns.Tower;

import com.badlogic.gdx.Screen;
//Change \/
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;



/** First screen of the application. Displayed after the application is created. */
public class MainMenu implements Screen {
    // Change\/
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private ImageButton startButton;
    private ImageButton exitButton;
    private Texture startTexture;
    private Texture exitTexture;
    private Game game;

    public MainMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        // Prepare your screen here.
        // Change \/
        //Background
        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("Main Menu Background 1728 x 1080.png"));
        //Buttons
        stage = new Stage();
        startTexture = new Texture(Gdx.files.internal("Start Game Button 200 x 50.png"));
        exitTexture = new Texture(Gdx.files.internal("Exit Game Button 200 x 50.png"));
        startButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(startTexture)));
        exitButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(exitTexture)));
        startButton.setPosition(764,500);
        startButton.setSize(200,50);
        exitButton.setPosition(764,400);
        exitButton.setSize(200,50);
        //Clicks button
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        stage.addActor(startButton);
        stage.addActor(exitButton);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        // Change \/
        //Background
        batch.begin();
        batch.draw(background,0,0);
        batch.end();
        //Buttons
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        // Change \/
        batch.dispose();
        background.dispose();
        stage.dispose();
        startTexture.dispose();
        exitTexture.dispose();
    }
}
