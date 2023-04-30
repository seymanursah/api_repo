package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    //This method will create a Map for payload.(payload is the data we will send to API)
    public Map<String, Object> expectedDataMapMethod(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData = new HashMap<>();

        if (userId != null) {
            expectedData.put("userId", userId);
        }
        if (title != null) {
            expectedData.put("title", title);
        }
        if (completed != null) {
            expectedData.put("completed", completed);
        }

        return expectedData;
    }

}
