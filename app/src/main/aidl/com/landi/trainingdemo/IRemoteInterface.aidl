// IcalcAidlInterface.aidl
package com.landi.trainingdemo;

// Declare any non-default types here with import statements
import com.landi.trainingdemo.bean.Person;
interface IRemoteInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    double calc(double a,double b);
    String showInfo(in Person person);
}
