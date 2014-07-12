package com.raysgame.projecoil;

import com.badlogic.gdx.Game;

public class ProjectOil extends Game{
	
	public GameScreen gameScreen;

	@Override
	public void create() {
		Assets.load();    //讀取assets檔案
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);    //設定目前畫面
	}

}
