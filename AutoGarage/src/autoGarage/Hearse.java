//TaylorJenkins
//11-04-16
//Programming Portfolio Project


package autoGarage;

import javax.swing.JOptionPane;

public class Hearse implements Vehicle{

	int doorNum= 4;
	int wheelNum= 4;
	String color= "Silver";
	double speed= 50.6;
	
	@Override
	public void honk() {
		JOptionPane.showMessageDialog(null, "Dun, Dun, Dunnnnn!");;
		
	}

	@Override
	public void move() {
		JOptionPane.showMessageDialog(null, "Congratulations! The Hearse has moved.");
		
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
