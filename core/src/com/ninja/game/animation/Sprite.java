package com.ninja.game.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class Sprite {
    private TextureRegion textureRegion;

    public TextureRegion getTextureRegion() {
        return  textureRegion;
    }

    public Sprite(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }
}
