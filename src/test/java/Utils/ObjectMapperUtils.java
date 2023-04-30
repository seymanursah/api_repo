package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.BookingResponsePojo;

import java.io.IOException;

public class ObjectMapperUtils {


    //This method will accept json data as string and convert it to any data type
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls){  //This is a Generic method. It means it will accept and return any data type.
        //<T> T - Class<T> cls mean any class/ any data type. We could put Object class as data type but when we use Object, we have to do type casting to convert it. But if we use this T, it will accept any data and we dont need to convert it.

        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
