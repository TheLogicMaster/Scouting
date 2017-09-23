package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainScreen extends ScreenBase {

    public MainScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        Texture background = new Texture("Background.png");

        Image backgroundImage = new Image(background);
        backgroundImage.setBounds(0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        stage.addActor(backgroundImage);

        addActor(new Image(new Texture("Banner.png")), 0.5f, 0.8f, 0.95f,19f / 3);
        addActor(new Image(new Texture("Tyros_Logo.png")), 0.5f, 0.6f, 0.3f,182f / 225);

        ImageButton viewButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("Tyros_Logo.png"))));
        viewButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new ViewScreen(game));
            }
        });
        viewButton.getImageCell().expand().fill();
        addActor(viewButton, 0.5f, 0.3f, 0.3f, 182f / 225);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render(delta);
    }
}
