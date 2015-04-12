package com.ninja.game.causeandeffect;

import com.ninja.game.causeandeffect.Effect;

import java.util.List;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class SingleEffect extends Effect {
    private String effectName;
    private List<Object> params;
    private Affectable affectableObject;
    private boolean canChangeTarget;

    @Override
    public void setTarget(Affectable affectable) {
        if (canChangeTarget)
            affectableObject = affectable;
    }

    @Override
    public void Trigger() {
        affectableObject.TriggerEffect(effectName, params);
    }
}
