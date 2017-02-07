//TaylorJenkins
//11-04-16
//Programming Portfolio Project


package autoGarage;

import javax.swing.JOptionPane;

public class Motorcycle implements Vehicle{

	int doorNum= 2;
	int wheelNum= 2;
	String color= "Grey";
	double speed= 160.5;
	
	@Override
	public void honk() {
		JOptionPane.showMessageDialog(null, "Toot, Toot!");
		
	}

	@Override
	public void move() {
		JOptionPane.showMessageDialog(null, "Congratulations! The Motorcycle has moved.");
		
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
