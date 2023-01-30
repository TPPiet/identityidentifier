import java.util.HashMap;

public class identifiedRequest {
    private String path;
    private HashMap<String, String> parameters;

    public identifiedRequest(String path, HashMap<String,String> map){
        this.path = path;
        this.parameters = map;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}
