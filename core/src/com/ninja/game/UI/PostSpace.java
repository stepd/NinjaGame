package com.ninja.game.UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Stephen Davis on 2/7/2015.
 */
public class PostSpace {
    public static PostSpace singleton;
    public Vector2 position;
    public float fontSize;
    public ArrayList<CharSequence> lines;
    public BitmapFont font;

    public PostSpace(Vector2 position, float fontSize, BitmapFont font) {
        this.position = position;
        this.fontSize = fontSize;
        this.font = font;

        lines = new ArrayList<CharSequence>();

        PostSpace.singleton = this;
    }

    public void Draw(SpriteBatch batch) {
        for (int i = lines.size() - 1; i >= 0; i--) {
            font.setColor(1, 1, 1, 1 - 0.075f * i);
            font.draw(batch, lines.get(i), position.x, position.y - fontSize * i);
        }
    }
}
