package com.logicmaster63.scouting;

import com.badlogic.gdx.Game;
import com.logicmaster63.scouting.screens.MainScreen;

public class Scouting extends Game {
	
	@Override
	public void create () {
		setScreen(new MainScreen());
	}
	
	@Override
	public void dispose () {

	}
}
