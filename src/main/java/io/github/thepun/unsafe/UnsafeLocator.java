package io.github.thepun.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Where Unsafe instance is stored.
 */
final class UnsafeLocator {

    private static final Unsafe INSTANCE;
    static {
        try {
            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            INSTANCE = (Unsafe) singleoneInstanceField.get(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find Unsafe instance", e);
        }
    }

    static Unsafe getUnsafe() {
        return INSTANCE;
    }


    private UnsafeLocator() {
    }

}
