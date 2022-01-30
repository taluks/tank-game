package com.tank.game.desktop;

import java.io.File;
import java.io.UnsupportedEncodingException;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public class DrunkardAutomaticTexturePacker {

	public static void main(String[] args) throws UnsupportedEncodingException {

		Settings settings = new Settings();
		settings.maxWidth = 2048;
		settings.maxHeight = 2048;
		settings.filterMag = TextureFilter.Linear;
		settings.filterMin = TextureFilter.Linear;

		// ${workspace_loc:tpwar-mobile-android/assets}
		final String PROJECT_ROOT_PATH = System.getProperty("user.dir");
		final File file = new File(PROJECT_ROOT_PATH);
		final String sourcePath = file.getParentFile().getPath() + "/resources/";
		final String outputPath = file.getParentFile().getPath() + "/android/assets/";

		
		TexturePacker.processIfModified(settings, sourcePath + "tanks/", outputPath + "tanks/", "tanks");
	}
}
