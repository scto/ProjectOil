package com.raysgame.projecoil;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Bullets {
	public final TextureRegion bulletTextureRegion;
	public final Rectangle bound;
	public float stateTime;
	
    public Bullets(float x, float y, float _stateTime) {
    	this.stateTime = _stateTime;
    	bound = new Rectangle(x, y, 30, 8);
    	bulletTextureRegion = Assets.loading_Animation.getKeyFrame(stateTime, true);
    }
    
    public void setStateTime(float _stateTime) {
    	this.stateTime = _stateTime;
    }
}
