package com.ninja.game.constraints.intersections;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public class RectangleOverlapConstraint extends ShapesOverlapConstraint {
    Rectangle a, b;

    public RectangleOverlapConstraint(Rectangle a, Rectangle b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected boolean Overlap() {
        return a.overlaps(b);
    }
}
