package com.ninja.game.animation;

import com.ninja.game.actors.Actor;
import com.ninja.game.animation.ActionAnimation;

import java.util.List;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public class Action {
    private List<ActionAnimation> actionAnimations;

    public ActionAnimation getAnimation(int id) {
        if (id > 0 && id < actionAnimations.size())
            return  actionAnimations.get(id);
        return null;
    }

    public void ApplyAction(Actionable actionable) {
        int state = actionable.getActionState();

        actionable.ApplyAction(getAnimation(state));
    }
}
