package com.tank.game.battle;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tank extends Group {

	private Image body;

	public Tank(AtlasRegion region) {
		body = new Image(region);
		addActor(body);
	}

}
