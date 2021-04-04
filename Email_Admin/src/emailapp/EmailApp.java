package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		Email email1 = new Email("Peter", "Pan");
		
		//email1.setAlternateEmail("myemail@company.com");
		
		System.out.println(email1.showInfo());
	
	}

}
