import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("Max","123456");
		logininfo.put("Peter","passwort");
		logininfo.put("Julia","00000");
	}
	
	//Login Info in Main weitergeben an LoginPage
	public HashMap getLoginInfo(){
		return logininfo;
	}
}