import javax.swing.JFrame;

public class GameFrame extends JFrame{

	GameFrame(){
			
		this.add(new GamePanel()); //Panel einfügen 
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Schließen, wenn man auf das x drückt
		this.setResizable(false); //Größe nicht veränderbar
		this.pack(); //Größe an Inhalt anpassen
		this.setVisible(true); //Sichtbar
		this.setLocationRelativeTo(null); //Zentrieren am Bildschirm
		
	}
}