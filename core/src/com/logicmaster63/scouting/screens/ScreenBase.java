package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenBase implements Screen {

    protected SpriteBatch spriteBatch;
    protected OrthographicCamera orthographicCamera;
    protected Viewport viewport;
    protected Stage stage;
    protected Game game;

    public ScreenBase(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        orthographicCamera = new OrthographicCamera(1600, 2560);
        spriteBatch = new SpriteBatch();
        orthographicCamera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        viewport = new FitViewport(1600, 2560, orthographicCamera);
        viewport.apply();
        stage = new Stage(viewport);
        stage.setDebugAll(true);//For debugging
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        orthographicCamera.update();
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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

    protected void addActor(Actor actor, float xPercent, float yPercent, float widthPercent, float dimensionRatio) {
        actor.setBounds(viewport.getWorldWidth() * xPercent - viewport.getWorldWidth() * widthPercent / 2f, viewport.getWorldHeight() * yPercent - viewport.getWorldWidth() * widthPercent / dimensionRatio / 2f, viewport.getWorldWidth() * widthPercent, viewport.getWorldWidth() * widthPercent / dimensionRatio);
        stage.addActor(actor);
    }
}
