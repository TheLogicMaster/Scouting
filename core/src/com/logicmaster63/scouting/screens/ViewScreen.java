package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ViewScreen extends ScreenBase {

    Texture banner = new Texture("Banner.png");

    @Override
    public void show() {
        super.show();
        stage.addActor(new Image(banner));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render(delta);
    }
}
