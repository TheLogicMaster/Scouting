package com.logicmaster63.scouting.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.logicmaster63.scouting.AndroidStuff;
import com.logicmaster63.scouting.Scouting;
import com.logicmaster63.scouting.User;

public class DesktopLauncher implements AndroidStuff {

	public DesktopLauncher() {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 400;
		config.height = 640;
		new LwjglApplication(new Scouting(this), config);
	}

	public static void main (String[] arg) {
		new DesktopLauncher();
	}

	@Override
	public void signIn() {

	}

	@Override
	public void signOut() {

	}

	@Override
	public boolean isSignedIn() {
		return false;
	}

	@Override
	public User getUser() {
		return null;
	}
}
