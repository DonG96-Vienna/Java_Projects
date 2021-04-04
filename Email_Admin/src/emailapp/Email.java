package emailapp;

import java.util.Scanner;
import java.util.Random;

public class Email { 			//encapsulation
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCap = 500; //Email Speicherplatz 500 MB
	private int passwordLength = 8; //8 Zeichen langes Password
	private String alternateEmail = "";
	private String companyName = "generic.com";
	private Random random = new Random();
	
	// Constructor für Vor- Nachname
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		
		this.password = randomPassword(passwordLength);
		
		//email erstellen
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "" + companyName;
	}
	
	private String setDepartment() {
		System.out.println("New member: " + this.firstName + ".\nDepartment Codes:\n1 for Sales\n2 for HR\n3 for developer\n0 for none");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "sales.";}
		else if(depChoice == 2) {return "hr.";}
		else if(depChoice == 3) {return "dev.";}
		else {return "";}
	}
	
	//Zufälliges Passwort erstellen mithilfe von Random
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*#@\\";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) random.nextInt(passwordSet.length());
			password[i] = passwordSet.charAt(rand); //In Array abspeichern
		}
		return new String(password); //Als String returnen
	}
	
	// Methoden um manuell einstellen zu können
	public void setMailboxCapacity(int cap) {
		this.mailboxCap = cap;
	}
	
	public void setAlternateEmail(String altemail){
		this.alternateEmail = altemail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	//Getter um direkt auf Info zugreifen zu können
	public int getMailboxCapacity() {return mailboxCap;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	//Direkt anzeigen
	public String showInfo() {
		return "NAME: " + firstName + " " + lastName +
				"\nCompany email: " + email +
				"\nMailbox capacity: " + mailboxCap + "MB" +
				"\nPassword: " + password +
				"\nAlternate Email: " + alternateEmail;
	}
}
