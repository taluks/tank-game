package com.tank.game.battle;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.tank.game.utils.Assets;
import com.tank.game.utils.Constants;

public class Battlefield extends Group {


	
	public Battlefield() {
		Assets assets = Assets.getInstance();
		TextureAtlas atlas = assets.get(Constants.TANK_ATLAS);
		
		for (int i = 0; i < 5; i++) {
			Tank tank = new Tank(atlas.findRegion("tank_huge"));
			tank.setPosition((float)(Math.random() * Constants.SCREEN_WIDTH), (float)(Math.random() * Constants.SCREEN_HEIGHT));
			addActor(tank);
		}
		
	}

	
}
