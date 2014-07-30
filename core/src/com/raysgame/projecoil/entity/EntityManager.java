package com.raysgame.projecoil.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.raysgame.projecoil.ProjectOil;
import com.raysgame.projecoil.SoundManager;
import com.raysgame.projecoil.TextureManager;
import com.raysgame.projecoil.screen.ScreenGameOver;
import com.raysgame.projecoil.screen.ScreenManager;

public class EntityManager {
    //控制畫面上的實體
	private final Array<Entity> entities = new Array<Entity>();
	private Player player;
	public int loopTimes;
	
	public EntityManager() {
		player = new Player(new Vector2(960 - 64, 540), new Vector2(0, 0), this);
	}
	
	public void AddEnemies(int amount) {
		for (int i=0; i<amount; i++) {
			//為了讓怪物符合上下螢幕出現
			float y = MathUtils.random(0, ProjectOil.CAMERA_HEIGHT - TextureManager.enemy1.getHeight());
			//為了讓怪物出現在螢幕後面
			float x = MathUtils.random(ProjectOil.CAMERA_WIDTH+(ProjectOil.CAMERA_WIDTH/2) , ProjectOil.CAMERA_HEIGHT * 3);
			float speed = MathUtils.random(2, 6);
			addEntity(new Enemy1(new Vector2(x, y), new Vector2(-speed, 0)));    //向左移動
		}
	}
	
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
		//子彈到盡頭檢查
		for (Bullet b : getBullet()) {
			if (b.checkEnd()) {
				//System.out.println("Bullet End");
				entities.removeValue(b, false);
			}
		}
		player.update();
		checkCollisions();    //檢查碰撞
	}
	
	public void render(SpriteBatch batch) {
		for (Entity e : entities) {
			if (e instanceof Bullet) {
			    e.renderAnimation(batch);	
			}
			else {
				e.render(batch);	
			}
		}
		player.render(batch);
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private void checkCollisions() {
		for (Enemy1 e : getEnemies()) {
			//System.out.println("Enemy posx:" +e.getBound().x +", Enemy posy:" +e.getBound().y+", Enemy width:" +e.getBound().getWidth()+", Enemy height:" +e.getBound().getHeight());
			for (Bullet b : getBullet()) {
				//System.out.println("Bullet posx:" +b.getBound().x +", Bullet posy:" +b.getBound().y+", Bullet width:" +b.getBound().getWidth()+", Bullet height:" +b.getBound().getHeight());
				if (e.getBoundPerFrame().overlaps(b.getBoundPerFrame())) {
					//System.out.println("Check Collisions.");
					entities.removeValue(e, false);
					entities.removeValue(b, false);
					SoundManager.boom.play();    //爆炸聲
					ProjectOil.score += Enemy1.score;
					if (gameOver()) {
						//贏了，消滅了畫面上所有的敵人
						ScreenManager.setScreen(new ScreenGameOver(true));
					}
				}
			}
			if (e.getBoundPerFrame().overlaps(player.getBoundPerFrame())) {
				//輸了，因為碰到敵人
				ScreenManager.setScreen(new ScreenGameOver(false));
			}
		}
	}
	
	private Array<Enemy1> getEnemies() {
		Array<Enemy1> ret = new Array<Enemy1>();
		for (Entity e : entities) {
			if (e instanceof Enemy1) {
				ret.add((Enemy1)e);
			}
		}
		return ret;
	}
	
	private Array<Bullet> getBullet() {
		Array<Bullet> ret = new Array<Bullet>();
		for (Entity e : entities) {
			if (e instanceof Bullet) {
				ret.add((Bullet)e);
			}
		}
		return ret;
	}
	
	public boolean clearScene() {
		return getEnemies().size <= 0;
	}
	
	public boolean gameOver() {
		if ((getEnemies().size <= 0) && (loopTimes <= 0))
		    return true;
		else
			return false;
	}
}
