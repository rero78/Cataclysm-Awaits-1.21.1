package net.foxtrot.cataclysmawaits.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum MushletVariant {
    BROWN(0),
    RED(1),
    RED2(2),
    WARPED(3),
    CRIMSON(4);

    private static final MushletVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(MushletVariant::getID)).toArray(MushletVariant[]::new);
    private final int id;
    MushletVariant(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public static MushletVariant byID(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
