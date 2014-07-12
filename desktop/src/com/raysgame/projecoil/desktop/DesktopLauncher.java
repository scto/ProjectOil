package com.raysgame.projecoil.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.raysgame.projecoil.ProjectOil;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Project Oil";    //標題
		config.useGL30 = true;
		config.width = 960;
		config.height = 544;
		config.resizable = false;
		new LwjglApplication(new ProjectOil(), config);
	}
}
