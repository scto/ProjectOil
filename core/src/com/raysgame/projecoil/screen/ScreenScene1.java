package com.raysgame.projecoil.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ETC1;
import com.raysgame.projecoil.Assets;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.SoundManager;
import com.raysgame.projecoil.entity.EntityManager;

public class ScreenScene1 extends Screen{
	OrthographicCamera camera;
	SpriteBatch batch;
	private BitmapFont font, scoreFont;
    private EntityManager entitymanager;
    private int loopTimes;
    private int[] enemyNumber;
    private int temp = 0;
    
    
	@Override
	public void create() {
		//設定鏡頭
		camera = new OrthographicCamera();
		camera.setToOrtho(true, ProjectOil.CAMERA_WIDTH, ProjectOil.CAMERA_HEIGHT);    //設定一個1920x1080的鏡頭，並且縮小會自動拉申，不會失真
		//true 是為了翻轉座標系統 libGDX 用的跟一般數學是一樣的，所以要翻轉
		
		batch = new SpriteBatch();    //For Image Rendering
		
		//System.out.println("graphics Width: " +screenBounds.width);
		//System.out.println("graphics height: " +screenBounds.height);
        enemyNumber = new int[]{5,12,16,4};
		entitymanager = new EntityManager();
		loopTimes = 4;    //階段
		entitymanager.loopTimes = loopTimes;
		font = new BitmapFont();
		scoreFont = new BitmapFont();
		SoundManager.bgm1.loop(0.4f);    //播放BGM
	}

	@Override
	public void render(SpriteBatch sb) {
		camera.update();    //60fps 速率更新鏡頭
		batch.setProjectionMatrix(camera.combined);    //遊戲視窗內圖片大小縮放
		generalUpdate();    //控制移動
		batch.begin();
		//Rendering Code Here
		font.setColor(Color.RED);
		font.setScale(3, -3);    //-1,將字翻轉
		String str = "There are "+(loopTimes+1)+" times to clear this stage";
		scoreFont.setColor(Color.BLACK);
		scoreFont.setScale(3, -3);
		
		batch.draw(Assets.spriteBackgound, 0, 0);
		entitymanager.render(batch);
		font.draw(batch, str, ProjectOil.CAMERA_WIDTH/2-350, 30);
		scoreFont.draw(batch, String.valueOf(ProjectOil.score), 50, 30);
		batch.end();
	}
	
	public void generalUpdate() {
		//牆壁
		if (entitymanager.playerIsDead()) {
			return;
		}
		if (entitymanager.getPlayer().getPosition().x < 0) {
			//System.out.println("Left!!");
			entitymanager.getPlayer().setDirection2(0, entitymanager.getPlayer().getPosition().y);
		}
		if (entitymanager.getPlayer().getPosition().y < 0) {
			//System.out.println("Top!!");
			entitymanager.getPlayer().setDirection2(entitymanager.getPlayer().getPosition().x, 0);
		}
		
		if ((entitymanager.getPlayer().getPosition().x + entitymanager.getPlayer().getBound().getWidth()) > ProjectOil.CAMERA_WIDTH) {
			//System.out.println("Right!!");
			entitymanager.getPlayer().setDirection2(ProjectOil.CAMERA_WIDTH - entitymanager.getPlayer().getBound().getWidth(), entitymanager.getPlayer().getPosition().y);
		}
		if ((entitymanager.getPlayer().getPosition().y + entitymanager.getPlayer().getBound().getHeight()) > ProjectOil.CAMERA_HEIGHT) {
			//System.out.println("Bottom!!");
			entitymanager.getPlayer().setDirection2(entitymanager.getPlayer().getPosition().x , ProjectOil.CAMERA_HEIGHT - entitymanager.getPlayer().getBound().getHeight());
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
		entitymanager.update();
		if (entitymanager.clearScene() && loopTimes > 0) {
			entitymanager.AddEnemies(enemyNumber[temp++]);    //括弧數量 => 敵人數
			entitymanager.loopTimes--;
			loopTimes--;
		}
	}

}
