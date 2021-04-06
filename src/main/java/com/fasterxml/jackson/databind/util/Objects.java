package com.fasterxml.jackson.databind.util;

/**
 * Partial backport of JDK+ java.lang.Objects.
 */
public final class Objects {

    private Objects() {

    }

    public static boolean equals(final Object a, final Object b) {
        if (a == b) {
            return true;
        }

        if (a != null) {
            return a.equals(b);
        }

        return false;
    }

    public static <T> T requireNonNull(final T o) {
        if (o == null) {
            throw new  NullPointerException();
        }

        return o;
    }

    public static <T> T requireNonNull(final T o, final String message) {
        if (o == null) {
            throw new  NullPointerException(message);
        }

        return o;
    }

    public static int hash(final Object ...objects) {
        if (objects == null) {
            return 0;
        }

        int hash = 7;
        for (final Object o : objects) {
            final int h = (o == null)? 0 : o.hashCode();
            hash = 31 * hash + h;
        }
        return hash;
    }

    public static int hashCode(final Object o) {
        return o.hashCode();
    }
}
