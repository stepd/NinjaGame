package com.ninja.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ninja.game.Forces.Charge;
import com.ninja.game.UI.DebuggerOutput;
import com.ninja.game.animation.ActionAnimation;
import com.ninja.game.animation.ActionFrame;
import com.ninja.game.animation.Sprite;
import com.ninja.game.animation.SpriteSet;
import com.ninja.game.collision.ImmovableCollider;
import com.ninja.game.collision.NonreflectiveRectCollider;
import com.ninja.game.collision.ReflectiveRectCollider;
import com.ninja.game.gameobjects.NinjaObject;
import com.ninja.game.world.CollidableMovingObject;
import com.ninja.game.world.WorldObject;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    ActionAnimation ani1, ani2;
    float x = 0, y = 0;

    CollidableMovingObject obj;
    ImmovableCollider wallObj;
    ImmovableCollider floorObj, lWall, rWall;
    ImmovableCollider testWall;
    boolean movingPlayer = false;
	
	@Override
	public void create () {
        DebuggerOutput.Initialize();

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

        obj = new NinjaObject(new Rectangle(10,10,173,200), 1f);
        wallObj = new NonreflectiveRectCollider(new WorldObject(new Rectangle(700, 300, 173, 200)));
        floorObj = new ReflectiveRectCollider(new WorldObject(new Rectangle(0, -Gdx.graphics.getWidth(), Gdx.graphics.getWidth(), Gdx.graphics.getWidth())), 0.2f);
        lWall = new ReflectiveRectCollider(new WorldObject(new Rectangle(-Gdx.graphics.getHeight(), 0, Gdx.graphics.getHeight(), Gdx.graphics.getHeight())), 0.1f);
        rWall = new ReflectiveRectCollider(new WorldObject(new Rectangle(Gdx.graphics.getWidth(), 0, Gdx.graphics.getHeight(), Gdx.graphics.getHeight())), 0.1f);

        List<ActionFrame> frames = new ArrayList<ActionFrame>();
        List<Sprite> sprites = SpriteSet.get("ninja_run");
        for (Sprite sprite : sprites) {
            frames.add(new ActionFrame(2/24f, sprite));
        }
        ani1 = new ActionAnimation(frames);

        frames = new ArrayList<ActionFrame>();
        sprites = SpriteSet.get("ninja_crawl");
        for (Sprite sprite : sprites) {
            frames.add(new ActionFrame(4/24f, sprite));
        }
        ani2 = new ActionAnimation(frames);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

        obj.Update(Gdx.graphics.getDeltaTime());
        wallObj.TryCollide(obj);
        floorObj.TryCollide(obj);
        lWall.TryCollide(obj);
        rWall.TryCollide(obj);

        ani1.Update(Gdx.graphics.getDeltaTime());
        ani2.Update(Gdx.graphics.getDeltaTime());
        ani1.Render(batch, obj.getRectangle(new Rectangle()));
        ani2.Render(batch, new Rectangle(700, 300, 173, 200));

		batch.end();


        batch.begin();
        DebuggerOutput.render(batch);
        batch.end();
	}
}
