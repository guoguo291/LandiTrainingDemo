// IcalcAidlInterface.aidl
package com.landi.trainingdemo;

// Declare any non-default types here with import statements
import com.landi.trainingdemo.bean.Person;
interface IRemoteInterface {

    double calc(double a,double b);
    String showInfo(in Person person);
}
