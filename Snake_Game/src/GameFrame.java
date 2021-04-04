import javax.swing.JFrame;

public class GameFrame extends JFrame{

	GameFrame(){
			
		this.add(new GamePanel()); //Panel einf�gen 
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Schlie�en, wenn man auf das x dr�ckt
		this.setResizable(false); //Gr��e nicht ver�nderbar
		this.pack(); //Gr��e an Inhalt anpassen
		this.setVisible(true); //Sichtbar
		this.setLocationRelativeTo(null); //Zentrieren am Bildschirm
		
	}
}