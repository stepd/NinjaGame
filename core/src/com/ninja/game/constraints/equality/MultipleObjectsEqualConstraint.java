package com.ninja.game.constraints.equality;

import java.util.List;

/**
 * Created by Stephen Davis on 7/26/2014.
 */
public class MultipleObjectsEqualConstraint extends ObjectsEqualConstraint{
    List<Object> objects;

    public MultipleObjectsEqualConstraint(List<Object> objects) {
        this.objects = objects;
    }

    @Override
    protected boolean ObjectsAreEqual() {
        if (objects.isEmpty())
            return  false;

        Object obj = objects.get(0);

        for (int i = 1; i < objects.size(); i++) {
            if (!obj.equals(objects.get(i)))
                return false;
        }

        return true;
    }
}
