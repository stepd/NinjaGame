package com.ninja.game.animation;

import com.ninja.game.io.SpriteReader;

import java.util.*;

/**
 * Created by Stephen Davis on 7/30/2014.
 */
public final class SpriteSet {
    private SpriteSet(){}

    private static Map<String, List<Sprite>> spriteSets = new HashMap<String, List<Sprite>>();

    public static List<Sprite> get(String name) {
        List<Sprite> set = spriteSets.get(name);

        if (set == null) {
            set = SpriteReader.ReadSprite(name);
            SpriteSet.spriteSets.put(name, set);
        }

        return set;
    }

    public static void remove(String name) {
        spriteSets.remove(name);
    }
}
