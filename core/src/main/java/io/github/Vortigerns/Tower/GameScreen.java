package io.github.Vortigerns.Tower;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
    private Game game;
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;

    public GameScreen(Game game) {

        this.game = game;
    }

    @Override
    public void show() {

        this.batch = new SpriteBatch(); // Needed if you want to draw anything later
        this.stage = new Stage();
        this.background = new Texture("GameScreenBackground.png");
    }

    @Override
    public void render(float delta) {
        this.batch.begin();
        this.batch.draw(background, 0, 0);
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
    }

}
