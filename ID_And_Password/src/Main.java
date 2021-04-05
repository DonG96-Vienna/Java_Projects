public class Main {

	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords(); //Gespeicherte Login-Daten
				
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo()); //Vorhandene Logindaten weitergeben

	}
}