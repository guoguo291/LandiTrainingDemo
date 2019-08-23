package com.landi.trainingdemo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public ExampleUnitTest() throws JSONException {
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void parse(){
        System.out.print("hahahhaha");
        String jsonStr="{\"request\":\"success\",\"age\":18,\"school\":\"清华大学\"}";
        JSONObject  jsonObj = null;
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