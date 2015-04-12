package com.ninja.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ninja.game.animation.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Davis on 7/30/2014.
 */
public class SpriteReader {
    public static final String FOLDER = "Animations//",
                               EXTENSION = ".txt";

    public static List<Sprite> ReadSprite(String name) {
        List<Sprite> sprites = new ArrayList<Sprite>();

        FileHandle handle = Gdx.files.internal(FOLDER + name + EXTENSION);
        String lines = handle.readString()
                             .trim()
                             .replace("\n","")
                             .replace("\r", " ");

        String[] tokens = lines.split(" ");

        /*for (String str : tokens) {
            Gdx.app.log("READ SPRITE: ", str);
        }*/

        Texture texture;

        try {
            texture = new Texture(tokens[0]);
        }
        catch (Exception e) {
            Gdx.app.log("ERROR: Texure Load\n\t", e.getMessage());
            texture = new Texture("badlogic.jpg");
        }

        for (int i = 1; i < tokens.length; i += 4) {
            sprites.add(new Sprite(CreateTextureRegion(texture, tokens[i], tokens[i+1], tokens[i+2], tokens[i+3])));
        }

        return sprites;
    }

    public static TextureRegion CreateTextureRegion(Texture texture, String sx, String sy, String sw, String sh) {
        int x, y, w, h;
        x = y = w = h = 0;

        try {
            x = Integer.parseInt(sx);
            y = Integer.parseInt(sy);
            w = Integer.parseInt(sw);
            h = Integer.parseInt(sh);
        }
        catch (Exception e) {
            Gdx.app.log("ERROR: Dimension Parse in Sprite Load\n\t", e.getMessage());
            x = y = 0;
            w = texture.getWidth();
            h = texture.getHeight();
        }

        return new TextureRegion(texture, x, y, w, h);
    }
}
