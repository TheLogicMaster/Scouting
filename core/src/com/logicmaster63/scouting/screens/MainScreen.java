package com.logicmaster63.scouting.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.logicmaster63.scouting.Scouting;

public class MainScreen extends ScreenBase {

    private Button signInButton, signOutButton;

    public MainScreen(Scouting game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        Image backgroundImage = new Image(new Texture("Background.png"));
        backgroundImage.setBounds(0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        stage.addActor(backgroundImage);

        addActor(new Image(new Texture("Banner.png")), 0.5f, 0.8f, 0.95f,19f / 3f);
        addActor(new Image(new Texture("WarriorsLogo.png")), 0.3f, 0.6f, 0.3f,160f / 149f);
        addActor(new Image(new Texture("Tyros_Logo.png")), 0.7f, 0.6f, 0.3f,182f / 225f);

        ImageButton viewButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("Graph.png"))));
        viewButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new ViewScreen(game));
            }
        });
        viewButton.getImageCell().expand().fill();
        addActor(viewButton, 0.5f, 0.3f, 0.1f, 1f);

        //Sign in button
        signInButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("SignIn.png"))));
        signInButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(Scouting.ANDROID_STUFF != null)
                    Scouting.ANDROID_STUFF.signIn();
            }
        });
        signOutButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("SignOut.png"))));
        signOutButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(Scouting.ANDROID_STUFF != null)
                    Scouting.ANDROID_STUFF.signOut();
                //TDGalaxy.preferences.changePref("autoSignIn", false);
            }
        });
        signOutButton.setVisible(false);
        Stack signInStack = new Stack(signInButton, signOutButton);
        signInStack.setBounds(100, viewport.getWorldHeight() - 250, 600, 150);
        stage.addActor(signInStack);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        signOutButton.setVisible(Scouting.ANDROID_STUFF.getUser() != null);
        signInButton.setVisible(Scouting.ANDROID_STUFF.getUser() == null);

        super.render(delta);

        spriteBatch.begin();
        if(Scouting.ANDROID_STUFF.getUser() != null)
            game.getFont().draw(spriteBatch, Scouting.ANDROID_STUFF.getUser().getUsername(), viewport.getWorldWidth() / 2, viewport.getWorldHeight() - 100);
        spriteBatch.end();
    }
}
