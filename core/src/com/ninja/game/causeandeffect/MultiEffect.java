package com.ninja.game.causeandeffect;

import java.util.List;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class MultiEffect extends Effect {
    private List<SingleEffect> effects;

    @Override
    public void setTarget(Affectable affectable) {

    }

    @Override
    public void Trigger() {
        for(SingleEffect effect : effects) {
            effect.Trigger();
        }
    }
}
