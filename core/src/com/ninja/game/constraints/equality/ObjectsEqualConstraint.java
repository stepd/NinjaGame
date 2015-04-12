package com.ninja.game.constraints.equality;

import com.ninja.game.constraints.Constraint;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public abstract class ObjectsEqualConstraint implements Constraint {
    @Override
    public boolean Satisfied() {
        return ObjectsAreEqual();
    }

    protected abstract boolean ObjectsAreEqual();
}
