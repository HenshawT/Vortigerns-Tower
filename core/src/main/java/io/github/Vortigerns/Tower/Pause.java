package io.github.Vortigerns.Tower;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Pause implements Screen {
    private Game game;
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private ImageButton exitButton;
    private Texture exitTexture;

    public Pause(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        this.batch = new SpriteBatch(); // Needed if you want to draw anything later
        this.background = new Texture("PauseMenuBackground.png");
        this.stage = new Stage();
        exitTexture = new Texture(Gdx.files.internal("Pause Button.png"));
        exitButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(exitTexture)));
        exitButton.setPosition(50,900);
        exitButton.setSize(100,100);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        stage.addActor(exitButton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        this.batch.begin();
        this.batch.draw(background, 200, 150);
        this.batch.end();
        this.stage.act(delta);
        this.stage.draw();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.background.dispose();
        this.stage.dispose();
        this.exitTexture.dispose();
    }

}
