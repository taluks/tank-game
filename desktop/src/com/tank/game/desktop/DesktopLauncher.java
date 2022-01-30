package com.tank.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tank.game.TankGame;
import com.tank.game.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.SCREEN_WIDTH;
		config.height = Constants.SCREEN_HEIGHT;
		config.resizable = true;
		config.samples = 3;
		config.vSyncEnabled = true;
		config.r = 8;
		config.g = 8;
		config.b = 8;
		config.a = 8;
		new LwjglApplication(new TankGame(), config);
	}
}
