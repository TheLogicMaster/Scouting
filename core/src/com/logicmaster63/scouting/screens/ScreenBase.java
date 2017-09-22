package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenBase implements com.badlogic.gdx.Screen {

    protected SpriteBatch spriteBatch;
    protected OrthographicCamera orthographicCamera;
    protected Viewport viewport;
    protected Stage stage;

    @Override
    public void show() {
        orthographicCamera = new OrthographicCamera(2560, 1600);
        spriteBatch = new SpriteBatch();
        orthographicCamera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        viewport = new FitViewport(1600, 2560, orthographicCamera);
        viewport.apply();
        stage = new Stage(viewport);
    }

    @Override
    public void render(float delta) {
        stage.act(Gdx.graphics.getDeltaTime());
        orthographicCamera.update();
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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

    }
}
