package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by koushikkrishnan on 2/27/17.
 */
public class ModelUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    private static String writeHelper(Response object) throws IOException {
        StringWriter stringWriter = new StringWriter();
        try {
            mapper.writeValue(stringWriter, object);
        } catch (IOException e) {
            mapper.writeValue(stringWriter, Response.FAILURE);
        }
        return stringWriter.toString();
    }

    public static String write(Response object) {
        try {
            return writeHelper(object);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"success\": false}";
        }
    }

}
