// IMyAIDLInterface.aidl
package com.kkangs_android.ch15_outer;

// Declare any non-default types here with import statements

interface IMyAIDLInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    int getMaxDuration();
    void start();
    void stop();
}