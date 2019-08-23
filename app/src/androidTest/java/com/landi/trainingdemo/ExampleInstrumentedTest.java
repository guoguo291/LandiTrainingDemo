package com.landi.trainingdemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.landi.trainingdemo", appContext.getPackageName());
//        System.out.print("hahahhaha");
    }
@Test
public void parse(){
    System.out.print("hahahhaha");
    String jsonStr="{\"request\":\"success\",\"age\":18,\"school\":\"清华大学\"}";
    JSONObject jsonObj = null;
    try {
        jsonObj = new JSONObject(jsonStr);
//            int age = jsonObj.getInt("age");
        String request = (String) jsonObj.get("request");
        System.out.print(request);
    } catch (JSONException e) {
        e.printStackTrace();
    }

}
}
