package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.logicmaster63.scouting.Scouting;
import de.tomgrill.gdxdialogs.core.dialogs.GDXButtonDialog;
import de.tomgrill.gdxdialogs.core.listener.ButtonClickListener;

public class ScreenBase implements Screen, InputProcessor {

    protected SpriteBatch spriteBatch;
    protected OrthographicCamera orthographicCamera;
    protected Viewport viewport;
    protected Stage stage;
    protected Game game;
    protected GDXButtonDialog exitDialog;

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

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(multiplexer);

        exitDialog = Scouting.dialogs.newDialog(GDXButtonDialog.class);
        exitDialog.setTitle("Hola");
        exitDialog.setMessage("Are you sure you want to exit?");
        exitDialog.addButton("Yes");
        exitDialog.addButton("No");
        exitDialog.setCancelable(false);
        exitDialog.setClickListener(new ButtonClickListener() {
            @Override
            public void click(int button) {
                if(button == 0)
                    Gdx.app.exit();
                else
                    exitDialog.dismiss();
            }
        });
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        orthographicCamera.update();
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.draw();
    }

    protected void back() {
        exitDialog.build().show();
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

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE || keycode == Input.Keys.BACK) {
            back();
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
