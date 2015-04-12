package com.ninja.game.constraints.intersections;

import com.ninja.game.constraints.Constraint;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public abstract class ShapesOverlapConstraint implements Constraint {
    @Override
    public boolean Satisfied() {
        return Overlap();
    }

    protected abstract boolean Overlap();
}