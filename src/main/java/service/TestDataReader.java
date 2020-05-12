package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ResourceBundle;

public class TestDataReader {

    public static String getJsonTestData(String fileName,String data){
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("testdata/" + fileName + ".json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        return jsonObject.get(data).getAsString();
    }

//    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
//
//    public static String getTestData(String key){
//        return resourceBundle.getString(key);
//    }


}
