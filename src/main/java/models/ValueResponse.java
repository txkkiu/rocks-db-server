package models;

import java.util.Optional;

/**
 * Created by koushikkrishnan on 2/21/17.
 */
public class ValueResponse extends Response {

    private String value = "";

    public ValueResponse(Optional<String> optionalValue) {
        super(optionalValue.isPresent() && optionalValue.get().length() > 0);
        value = optionalValue.orElse("");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
