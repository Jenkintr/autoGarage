//TaylorJenkins
//11-04-16
//Programming Portfolio Project


package autoGarage;

import javax.swing.JOptionPane;

public class Truck implements Vehicle{

	int doorNum = 4;
	int wheelNum = 4;
	String color = "Blue";
	double speed = 60.5;
	
	@Override
	public void honk() {
		JOptionPane.showMessageDialog(null, "Honk, Honk!");
		
	}

	@Override
	public void move() {
		JOptionPane.showMessageDialog(null, "Congratulations! The Truck has moved.");
		
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
