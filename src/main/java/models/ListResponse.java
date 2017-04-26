package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

/**
 * Created by koushikkrishnan on 4/26/17.
 */
public class ListResponse extends Response {

    private String value = "";

    public ListResponse(List<String> list) {
        super(list != null);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            value = mapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
