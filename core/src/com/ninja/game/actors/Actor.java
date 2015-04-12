package com.ninja.game.actors;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.ninja.game.Renderable;
import com.ninja.game.Updatable;
import com.ninja.game.animation.Action;
import com.ninja.game.animation.ActionAnimation;
import com.ninja.game.world.MovingObject;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class Actor extends MovingObject implements Updatable, Renderable {
    private ActionAnimation animation;
    private Rectangle drawRect;
    private int state = 0;

    public int State() {
        return  state;
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        UpdateDrawRect();
    }

    public void UpdateDrawRect() {
        drawRect.x = getOriginX() - drawRect.getWidth() / 2;
        drawRect.y = getY();
    }

    public Actor(Rectangle body, Rectangle drawRect, ActionAnimation animation) {
        this(body, drawRect, animation, 0);
    }

    public Actor(Rectangle body, Rectangle drawRect, ActionAnimation animation, int state) {
        super(body);

        this.drawRect = drawRect;
        this.animation = animation;
        this.state = state;
    }

    @Override
    public void Render(SpriteBatch spriteBatch) {
        animation.Render(spriteBatch, drawRect);
    }
}
