package com.tank.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tank.game.battle.Battlefield;
import com.tank.game.utils.Assets;

public class PlayScreen extends ScreenAdapter {

	private Stage stage;
	private ScreenViewport viewport;

	@Override
	public void show() {
		
		Assets assets = Assets.getInstance();
		assets.load();

		viewport = new ScreenViewport();
		stage = new Stage(viewport);
		
		Battlefield battlefield = new Battlefield();
		stage.addActor(battlefield);

		InputMultiplexer multiplexer = new InputMultiplexer(stage);
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.WHITE);

		stage.getViewport().apply();
		stage.act(delta);
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void dispose() {
	}

}
