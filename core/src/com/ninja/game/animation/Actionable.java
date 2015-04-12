package com.ninja.game.animation;

/**
 * Created by Stephen Davis on 7/22/2014.
 */
public interface Actionable {
    public void ApplyAction(ActionAnimation actionAnimation);
    public int getActionState();
}
