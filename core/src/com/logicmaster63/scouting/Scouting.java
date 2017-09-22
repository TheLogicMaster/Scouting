package com.logicmaster63.scouting;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.logicmaster63.scouting.screens.MainScreen;

public class Scouting extends Game {
	
	@Override
	public void create () {
		setScreen(new MainScreen(this));
	}
	
	@Override
	public void dispose () {

	}
}
