package com.logicmaster63.scouting;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.logicmaster63.scouting.screens.MainScreen;
import de.tomgrill.gdxdialogs.core.GDXDialogs;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;

import java.io.IOException;
import java.util.Arrays;

public class Scouting extends Game {

	public static GDXDialogs dialogs;
	public static AndroidStuff ANDROID_STUFF;

	private BitmapFont font;

	public Scouting(AndroidStuff androidStuff) {
		ANDROID_STUFF = androidStuff;
	}

	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);
		dialogs = GDXDialogsSystem.install();

		Texture texture = new Texture(Gdx.files.internal("moonhouse64.png"), true); // true enables mipmaps
		texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		font =  new BitmapFont(Gdx.files.internal("moonhouse64.fnt"), new TextureRegion(texture), false);

		System.err.println("Path: " + Gdx.files.getExternalStoragePath().concat("parsed.txt"));
		try {
			Parser.write(Gdx.files.getExternalStoragePath().concat("parsed.txt"), Arrays.asList(new LayoutObject(LayoutObject.INPUT_METHOD.CHECK_BOX, "Can Climb"), new LayoutObject(LayoutObject.INPUT_METHOD.TEXT_FIELD, "Balls Scored")));
			System.err.println("Parser: " + Parser.read(Gdx.files.getExternalStoragePath().concat("parsed.txt")));
		} catch (IOException e) {
			System.err.println("Parser: " + e);
		}

		setScreen(new MainScreen(this));
	}

	public BitmapFont getFont() {
		return font;
	}
}
