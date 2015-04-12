package com.ninja.game.causeandeffect;

import java.util.List;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public interface Affectable {
    public void TriggerEffect(String effectName, List<Object> params);
}
