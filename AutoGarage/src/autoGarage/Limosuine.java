//TaylorJenkins
//11-04-16
//Programming Portfolio Project


package autoGarage;

import javax.swing.JOptionPane;

public class Limosuine implements Vehicle{

	int doorNum= 4;
	int wheelNum= 4;
	String color= "White";
	double speed= 80.5;
	
	@Override
	public void honk() {
		JOptionPane.showMessageDialog(null, "Meep, Meep!");
		
	}

	@Override
	public void move() {
		JOptionPane.showMessageDialog(null, "Congratulations! The Limosuine has moved.");
		
	}
	
	@Override
	public int getDoorNum(){
		return doorNum;
	}
	
	@Override
	public int getWheelNum(){
		return wheelNum;
	}
	
	@Override
	public String getColor(){
		return color;
	}
	
	@Override
	public double getSpeed(){
		return speed;
	}

}
