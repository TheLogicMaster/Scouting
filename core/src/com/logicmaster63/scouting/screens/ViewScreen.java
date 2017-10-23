package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.logicmaster63.scouting.Scouting;

public class ViewScreen extends ScreenBase {


    public ViewScreen(Scouting game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle(new TextureRegionDrawable(new TextureRegion(new Texture("checked_box.png"))), new TextureRegionDrawable(new TextureRegion(new Texture("unchecked_box.png"))), game.getFont(), Color.BLACK);
        checkBoxStyle.font = game.getFont();

        Image backgroundImage = new Image(new Texture("Background.png"));
        backgroundImage.setBounds(0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        stage.addActor(backgroundImage);

        ImageButton backButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("BackButton.png"))));
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                back();
            }
        });
        addActor(backButton, 0.1f,0.9f, 0.09f, 1f);

        VerticalGroup verticalGroup = new VerticalGroup();
        verticalGroup.setBounds(viewport.getWorldWidth() / 10, viewport.getWorldHeight() / 10, viewport.getWorldWidth() / 10f * 8, viewport.getWorldHeight() / 10f * 8);
        CheckBox climbCheckBox = new CheckBox("Can Climb", checkBoxStyle);

        verticalGroup.addActor(climbCheckBox);
        stage.addActor(verticalGroup);
    }

    @Override
    protected void back() {
        game.setScreen(new MainScreen(game));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render(delta);
    }
}
