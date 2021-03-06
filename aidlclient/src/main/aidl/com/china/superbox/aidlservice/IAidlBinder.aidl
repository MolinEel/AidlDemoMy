// IAidlBinder.aidl
package com.china.superbox.aidlservice;

// Declare any non-default types here with import statements

interface IAidlBinder {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    int calcul(int num1, int num2);
}
