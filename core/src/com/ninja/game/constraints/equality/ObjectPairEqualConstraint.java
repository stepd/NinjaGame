package com.ninja.game.constraints.equality;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public class ObjectPairEqualConstraint extends ObjectsEqualConstraint{
    private Object a, b;

    public ObjectPairEqualConstraint(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected boolean ObjectsAreEqual() {
        return a.equals(b);
    }
}
