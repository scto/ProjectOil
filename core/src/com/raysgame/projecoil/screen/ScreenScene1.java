package com.raysgame.projecoil.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.raysgame.projecoil.Assets;
import com.raysgame.projecoil.entity.Player;

public class ScreenScene1 extends Screen{
	OrthographicCamera camera;
	SpriteBatch batch;
	Rectangle screenBounds;
    int characterX, characterY;
    final float speed = 6;
    float stateTime;    //動畫重要
    //AirPlane airPlane; 
    private Player player;
    
	@Override
	public void create() {
		//設定鏡頭
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);    //設定一個1920x1080的鏡頭，並且縮小會自動拉申，不會失真
		//true 是為了翻轉座標系統 libGDX 用的跟一般數學是一樣的，所以要翻轉
		
		batch = new SpriteBatch();    //For Image Rendering
		
		//取得螢幕邊界
		screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//System.out.println("graphics Width: " +screenBounds.width);
		//System.out.println("graphics height: " +screenBounds.height);
		
		//airPlane = new AirPlane(960 - 64, 540);
		player = new Player(new Vector2(960 - 64, 540), new Vector2(0, 0));    //新增主角飛機
		stateTime = 0f;    //還是不知為何要設這個
	}

	@Override
	public void render(SpriteBatch sb) {
		stateTime += Gdx.graphics.getDeltaTime();    //應該取得螢幕刷新時間?
		camera.update();    //60fps 速率更新鏡頭
		batch.setProjectionMatrix(camera.combined);    //遊戲視窗內圖片大小縮放
		generalUpdate();    //控制移動
		batch.begin();
		//Rendering Code Here
		batch.draw(Assets.spriteBackgound, 0, 0);
		player.render(batch);
		batch.end();
	}
	
	public void generalUpdate() {
		//牆壁
		if (player.getPosition().x < 0) {
			//System.out.println("Left!!");
			player.setDirection2(0, player.getPosition().y);
		}
		if (player.getPosition().y < 0) {
			//System.out.println("Top!!");
			player.setDirection2(player.getPosition().x, 0);
		}
		
		if ((player.getPosition().x + player.getBound().getWidth()) > 1920) {
			//System.out.println("Right!!");
			player.setDirection2(1919 - player.getBound().getWidth(), player.getPosition().y);
		}
		if ((player.getPosition().y + player.getBound().getHeight()) > 1080) {
			//System.out.println("Bottom!!");
			player.setDirection2(player.getPosition().x , 1079 - player.getBound().getHeight());
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void update() {
		camera.update();
		player.update();
	}

}
