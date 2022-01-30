package com.tank.game.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ShaderProgramLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class Assets extends AssetManager {
	
	private static final Assets instance = new Assets();

	private static final String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗ�?ЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
			+ "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
			+ "0123456789"
			+ "ії₽©®™✓\\°¢$€£~`|•√π÷×№";
	

	public Assets() {
	}

	public Assets(FileHandleResolver resolver) {
		super(resolver);
	}

	public Assets(FileHandleResolver resolver, boolean defaultLoaders) {
		super(resolver, defaultLoaders);
	}

	public void load() {

		FileHandleResolver resolver = new InternalFileHandleResolver();
		this.setLoader(ShaderProgram.class, new ShaderProgramLoader(resolver));
		this.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		this.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

		load(Constants.TANK_ATLAS, TextureAtlas.class);
		finishLoading();
	}

	//======================================
	public Array<TextureRegion> extractRegions(TextureAtlas atlas, String name){
		Array<TextureRegion> result = new Array<>();
		for (TextureAtlas.AtlasRegion region: atlas.getRegions()) {
			if(region.name.contains(name))
				result.add(region);
		}
        return result;
    }
	
	public NinePatchDrawable getNinePatchDrawable(TextureAtlas atlas, String name, int left, int right, int top, int bottom) {
		return new NinePatchDrawable(getNinePatch(atlas, name, left, right, top, bottom));
	}
	
	public NinePatch getNinePatch(TextureAtlas atlas, String name, int left, int right, int top, int bottom) {
		return new NinePatch(atlas.findRegion(name), left, right, top, bottom);
	}
	
	public Drawable getDrawable(TextureAtlas atlas, String name, int index) {
		return new TextureRegionDrawable(atlas.findRegion(name, index));
	}
	
	public Drawable getDrawable(TextureAtlas atlas, String name) {
		return new TextureRegionDrawable(atlas.findRegion(name));
	}

	public static Assets getInstance() {
		return instance;
	}
	
}
