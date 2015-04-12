package com.ninja.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Stephen Davis on 2/7/2015.
 */
public class DebuggerOutput {
    static Skin skin;
    static PostSpace postSpace;
    static BitmapFont font;
    static boolean initialized = false;

    public static void Initialize() {
        if (initialized)
            return;
        initialized = true;

        font = new BitmapFont(Gdx.files.internal("calibri.fnt"),Gdx.files.internal("calibri.png"),false);
        font.scale(1);
        postSpace = new PostSpace(new Vector2(300, Gdx.graphics.getHeight() - 260), 60, font);

        postSpace.lines.add("Hello World!");
    }

    public static void render(SpriteBatch batch) {
        if (!initialized)
            return;

        postSpace.Draw(batch);
    }

    public static void Output(String output) {
        postSpace.lines.add(0, output);
    }
}
