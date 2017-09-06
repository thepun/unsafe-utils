package org.thepun.unsafe;

public final class ObjectMemoryLayout {

    public static <T> long getFieldOffset(Class<T> type, String fieldName) {
        if (type.isArray() || type.isPrimitive() || type.isInterface()) {
            throw new IllegalArgumentException("Should be class");
        }

        try {
            return UnsafeLocator.getUnsafe().objectFieldOffset(type.getDeclaredField(fieldName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private ObjectMemoryLayout() {
    }
}