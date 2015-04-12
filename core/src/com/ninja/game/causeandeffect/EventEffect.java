package com.ninja.game.causeandeffect;

import com.ninja.game.constraints.Constraint;

/**
 * Created by Stephen Davis on 7/25/2014.
 */
public class EventEffect extends Effect {
    private Constraint constraint;
    private Effect effect;

    @Override
    public void Trigger() {
        if (constraint.Satisfied())
            effect.Trigger();
    }

    @Override
    public void setTarget(Affectable affectable) {
        effect.setTarget(affectable);
    }
}
