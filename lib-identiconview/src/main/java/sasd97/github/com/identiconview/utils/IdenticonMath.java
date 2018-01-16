// Copyright © 2017 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package sasd97.github.com.identiconview.utils;

/**
 * A set of auxiliary mathematical utilities.
 */
public final class IdenticonMath {

    private IdenticonMath() {
    }

    /**
     * Restricts an integer to a segment.
     * @param value need to be clamped
     * @param min integer
     * @param max integer
     * @return clamped integer value
     */
    public static int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }
}
