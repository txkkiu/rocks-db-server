package models;

/**
 * Created by koushikkrishnan on 2/27/17.
 */
public class Response {

    protected boolean success;
    public static Response FAILURE = new Response(false);

    public Response(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
