package models;

import java.util.Optional;

/**
 * Created by koushikkrishnan on 2/21/17.
 */
public class ValueResponse {

    private String value = "";
    private boolean success;

    public ValueResponse(Optional<String> optionalValue) {
        optionalValue.ifPresent(x -> {
            value = x;
        });
        value = optionalValue.orElse("");
        success = this.value.length() > 0;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getSuccess(){
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
