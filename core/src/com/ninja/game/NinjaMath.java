package com.ninja.game;

import com.ninja.game.world.WorldObject;

/**
 * Created by Stephen Davis on 7/28/2014.
 */
public class NinjaMath {
    public static double Distance(float x1, float y1, float x2, float y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static float CalculateNewEnergy(float energy, float retentivity, float absorbtion) {
        return energy - energy * absorbtion * retentivity;
    }

    public static Edge NearestEdge(WorldObject obj1, WorldObject obj2) {
        double minDistance, distance;
        Edge minEdge;

        minDistance = Distance(obj1.getOriginX(), obj1.getOriginY(), obj2.getOriginX(), obj2.getY() + obj2.getHeight());
        minEdge = Edge.TOP;

        distance = Distance(obj1.getOriginX(), obj1.getOriginY(), obj2.getX(), obj2.getOriginY());
        if (distance < minDistance) {
            minDistance = distance;
            minEdge = Edge.LEFT;
        }

        distance = Distance(obj1.getOriginX(), obj1.getOriginY(), obj2.getX() + obj2.getWidth(), obj2.getOriginY());
        if (distance < minDistance) {
            minDistance = distance;
            minEdge = Edge.RIGHT;
        }

        distance = Distance(obj1.getOriginX(), obj1.getOriginY(), obj2.getOriginX(), obj2.getY());
        if (distance < minDistance) {
            minDistance = distance;
            minEdge = Edge.BOTTOM;
        }

        return minEdge;
    }

    public static double min(double A, double B) {
        return (A < B)?A:B;
    }
}
