package Models;

public class Request {
    private String Type;
    private String Context;

    public Request(String type, String context) {
        this.Type = type;
        this.Context = context;
    }

    public Request() {

    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setContext(String context) {
        this.Context = context;
    }

    public String getContext() {
        return Context;
    }

}
