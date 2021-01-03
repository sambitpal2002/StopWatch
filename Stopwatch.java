import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {
	
	JFrame frame= new JFrame();
	JButton startButton=new JButton("START");   //start Button
	JButton resetButton=new JButton("RESET");   //RESET BUTTON
	JLabel timeLabel= new JLabel();            //For Time
	int elaspedTime=0;
	int second=0;
	int minutes=0;
	int hours=0;
	boolean started=false;
	//STRING
	String seconds_string=String.format("%02d", second);
	String minutes_string=String.format("%02d", minutes);
	String hours_string=String.format("%02d", hours);
	

	Timer timer=new Timer(1000,new ActionListener() {
		//-------------------------------------------------------//
		public void actionPerformed(ActionEvent e) {
			elaspedTime+=1000;
			hours=(elaspedTime/3600000);
			minutes=(elaspedTime/60000) % 60;
			second=(elaspedTime/1000) %60;
			
			seconds_string=String.format("%02d", second);
			minutes_string=String.format("%02d", minutes);
			hours_string=String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			
		}
	});
	
	Stopwatch(){
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);   ///(intx,int y , width , height)
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
/* */	timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		//START BUTTON
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("INK FREE",Font.BOLD,10));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		//RESTART BUTTON
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("INK FREE",Font.BOLD,10));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		

		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		//frame.setResizable(false);
		frame.setVisible(true);

	}
         @Override
         public void actionPerformed(ActionEvent e) {
	      
        	 if(e.getSource()==startButton){
        		 if(started==false) {
        			 started=true;
        			 startButton.setText("STOP");
        			 start();
        		 }
        		 else {
        			 started=false;
        			 startButton.setText("START");
        			 stop();
        		 }
        	 }
        	if(e.getSource()==resetButton);
        	 {
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
        	 elaspedTime=0;
        	 second=0;
        	 minutes=0;
        	 hours=0;
        	seconds_string=String.format("%02d", second);
 			minutes_string=String.format("%02d", minutes);
 			hours_string=String.format("%02d", hours);
 			
 			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 			
        	 
         } 
         
}

