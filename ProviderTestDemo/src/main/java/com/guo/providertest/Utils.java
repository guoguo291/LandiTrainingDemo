package com.guo.providertest;

import android.content.Context;

import com.guo.providertest.annotation.BindView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by guoj on 2019/6/1.
 */

public class Utils {
    public static void injectView(Context context){
        Class cls=context.getClass();
        Field[] fields= cls.getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            BindView bindView=field.getAnnotation(BindView.class);
            if (bindView!=null){
                try {
                   int viewId=bindView.value();
                   Method method=cls.getMethod("findViewById",int.class);
                   Object obj=method.invoke(context,viewId);
                   field.set(context,obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
