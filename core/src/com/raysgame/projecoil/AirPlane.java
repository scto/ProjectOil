package com.raysgame.projecoil;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class AirPlane {
	
	public final Sprite image;
	public final Rectangle bound;
	
    public AirPlane(float x, float y) {
    	 image = Assets.spriteAirPlane;
    	 bound = new Rectangle(x, y, 120, 60);
    }
}
