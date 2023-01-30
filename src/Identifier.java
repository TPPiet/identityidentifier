import java.util.HashMap;

public class Identifier {
	private String uri;
	private String scheme;
	private String path;
	private String allowedPath[] = new String[] {"login", "confirm", "sign"};
	private HashMap<String, String> parameters;
	
	public Identifier() {}

	public identifiedRequest identify(String uri){
		this.uri = uri;
		parseAndValidate();
		identifiedRequest result = new identifiedRequest(this.path, this.parameters);
		return result;
	}
	
	private boolean parseAndValidate() {
		String[] parsed = this.uri.split("[:?]");
		this.scheme = parsed[0];
		this.path = parsed[1].replaceFirst("//", "");
		this.parameters = dealWithParameters(parsed[2]);
		
		if(scheme.equals("visma-identity") && checkPath(path)) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean checkPath(String path) {
		for(String i:allowedPath) {
			if(path.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	private HashMap<String, String> dealWithParameters(String parameters){
		HashMap<String, String> parametersMap = new HashMap<String, String>();
		String[] splittedP = parameters.split("[&=]");
		if(splittedP.length>2){
			parametersMap.put(splittedP[2],splittedP[3]);
		}
		return parametersMap;
	}

}
