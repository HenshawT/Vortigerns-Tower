package io.github.Vortigerns.Tower;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseMenu implements Screen {
    private Game game;
    private SpriteBatch batch;

    public PauseMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch(); // Needed if you want to draw anything later
    }

    @Override
    public void render(float delta) {
        // Blank screen — nothing drawn
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

        batch.dispose();
    }
}

