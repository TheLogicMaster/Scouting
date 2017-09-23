package com.logicmaster63.scouting;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.logicmaster63.scouting.screens.MainScreen;
import de.tomgrill.gdxdialogs.core.GDXDialogs;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;
import de.tomgrill.gdxdialogs.core.dialogs.GDXButtonDialog;

public class Scouting extends Game {

	public static GDXDialogs dialogs;

	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);
		dialogs = GDXDialogsSystem.install();

		setScreen(new MainScreen(this));
	}
}
