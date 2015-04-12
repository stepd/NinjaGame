package com.ninja.game.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.ninja.game.Updatable;
import com.ninja.game.Renderable;

import java.util.List;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class ActionAnimation implements Updatable, Renderable{
    public static final Rectangle DEBUG_RECT;

    static {
        DEBUG_RECT = new Rectangle(128f, 128f, 512f, 512f);
    }

    private int currentFrame = 0;
    private float currentFrameLifetime = 0;
    private List<ActionFrame> frames;

    public ActionAnimation(List<ActionFrame> frames) {
        this.frames = frames;
    }

    @Override
    public void Update(float deltaTime) {
        currentFrameLifetime += deltaTime;

        if (currentFrameLifetime < frames.get(currentFrame).getDuration())
            return;

        currentFrameLifetime = 0;
        if (currentFrame < frames.size() - 1)
            currentFrame++;
        else
            currentFrame = 0;

        frames.get(currentFrame).Trigger();
    }

    @Override
    public void Render(SpriteBatch spriteBatch) {
        Render(spriteBatch, DEBUG_RECT);
    }

    public void Render(SpriteBatch spriteBatch, Rectangle drawRect) {
        TextureRegion textureRegion = frames.get(currentFrame).getSprite().getTextureRegion();

        spriteBatch.draw(textureRegion, drawRect.x, drawRect.y, drawRect.width, drawRect.height);
    }
}
