// IHelloBinder.aidl
package com.china.superbox.aidlclient;

// Declare any non-default types here with import statements

interface IHelloBinder {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    String hello(String msg);
}
