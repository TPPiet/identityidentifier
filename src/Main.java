
public class Main {

	public static void main(String[] args) {
		String uri = "visma-identity://confirm?source=netvisor&paymentnumber=102226";
		Identifier identifier = new Identifier();
		identifiedRequest result = identifier.identify(uri);

		System.out.println(result.getPath());
		for(String i:result.getParameters().keySet()){
			System.out.println("key: "+ i+" value: " +result.getParameters().get(i));
		}
	}

}
