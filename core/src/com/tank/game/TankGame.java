package com.tank.game;

import com.badlogic.gdx.Game;
import com.tank.game.screen.PlayScreen;

public class TankGame extends Game {

	@Override
	public void create() {
		setScreen(new PlayScreen());
		
	}

	
}
