import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
 
 JFrame frame = new JFrame();
 JButton startButton = new JButton("START");
 JButton resetButton = new JButton("RESET");
 JLabel timeLabel = new JLabel();
 int elapsedTime = 0; //Verstrichene Zeit in Millisekunden
 int seconds =0;
 int minutes =0;
 int hours =0;
 boolean started = false;
 String seconds_string = String.format("%02d", seconds); //2 Stellen (z.B. 01:12:33)
 String minutes_string = String.format("%02d", minutes);
 String hours_string = String.format("%02d", hours);
 
 // Alle 1000 ms eine Aktion durchführen
 Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   elapsedTime=elapsedTime+1000; //1000 ms dazu
   hours = (elapsedTime/3600000); //In Stunden umrechnen
   minutes = (elapsedTime/60000) % 60; //Modulo 60, damit nicht 61 Minuten etc.
   seconds = (elapsedTime/1000) % 60;
   seconds_string = String.format("%02d", seconds);
   minutes_string = String.format("%02d", minutes);
   hours_string = String.format("%02d", hours);
   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
   
  }
  
 });
 
 
 Stopwatch(){
  
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
  timeLabel.setBounds(100,100,200,100);
  timeLabel.setFont(new Font("Arial",Font.PLAIN,35));
  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
  timeLabel.setOpaque(true);
  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
  startButton.setBounds(100,200,100,50);
  startButton.setFont(new Font("Arial",Font.PLAIN,20));
  startButton.setFocusable(false);
  startButton.addActionListener(this);
  
  resetButton.setBounds(200,200,100,50);
  resetButton.setFont(new Font("Arial",Font.PLAIN,20));
  resetButton.setFocusable(false);
  resetButton.addActionListener(this);
  
  frame.add(startButton);
  frame.add(resetButton);
  frame.add(timeLabel);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(450,450);
  frame.setLayout(null);
  frame.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==startButton) {
   
   //Uhr starten und Button auf "Stop" umändern
   if(started==false) {
    started=true;
    startButton.setText("STOP");
    start();
   }
   //Uhr stoppen und Button auf "Start" umändern
   else {
    started=false;
    startButton.setText("START");
    stop();
   }
   
  }
  //Reset alles auf 0 und Button wird zu "Start"
  if(e.getSource()==resetButton) {
   started=false;
   startButton.setText("START");
   reset();
  }
  
 }
 
 void start() {
  timer.start();
 }
 
 void stop() {
  timer.stop();
 }
 
 void reset() {
  timer.stop();
  elapsedTime=0; //Alles zurücksetzen auf 0
  seconds =0;
  minutes=0;
  hours=0;
  seconds_string = String.format("%02d", seconds); //Alles neu darstellen
  minutes_string = String.format("%02d", minutes);
  hours_string = String.format("%02d", hours);       
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 }

}