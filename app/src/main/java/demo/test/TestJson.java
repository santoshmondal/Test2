package demo.test;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by santosh on 5/9/16.
 */
public class TestJson {
    public static void main(String[] args) {
        String json = "{\"id\":1}";

        try {

            JSONObject obj = new JSONObject(json);

            System.out.println(obj);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
