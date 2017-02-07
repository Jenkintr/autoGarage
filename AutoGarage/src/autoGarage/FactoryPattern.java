//TaylorJenkins
//11-04-16
//Programming Portfolio Project

package autoGarage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FactoryPattern {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	//Factory Pattern Constructor:
	public FactoryPattern(){
		prepareGUI();
	}
	
	public static void main(String[] args){
		FactoryPattern factoryPattern = new FactoryPattern();
		factoryPattern.showCombobox();
		
		SingletonLog.log("\nProgram launched.");

	}

	private void prepareGUI(){
		mainFrame = new JFrame("Auto Garage");
		mainFrame.setSize(800,300);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
				SingletonLog.log("Program Closed.");
			}
		});
		headerLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);

		statusLabel.setSize(800,100);
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
	
	//Create drop down menu and add button objects
	private void showCombobox(){
		headerLabel.setText("Select a Vehicle Type and press Show Info Button to View Information about it.");
		
		final DefaultComboBoxModel<String> vehicleName = new DefaultComboBoxModel<String>();
		
		vehicleName.addElement("CAR");
		vehicleName.addElement("TRUCK");
		vehicleName.addElement("MOTORCYCLE");
		vehicleName.addElement("LIMOSUINE");
		vehicleName.addElement("HEARSE");
		
		final JComboBox<String> vehicleCombo = new JComboBox<>(vehicleName);
		vehicleCombo.setSelectedIndex(0);
		
		JScrollPane vehicleListScrollPane = new JScrollPane(vehicleCombo);
		
		JButton showButton = new JButton("Show Info");
		JButton honkButton = new JButton("Honk");
		JButton moveButton = new JButton ("Move");
		
		//Create new vehicle object to access methods.
		VehicleFactory vehicleFactory = new VehicleFactory();
				
		/**
		 * The showButton will allow a user to view more information about a vehicle
		 * by clicking on the button. The user will be able to view how many doors the 
		 * vehicle has, the number of wheels, the speed, as well as the default color
		 * of the vehicle.
		 */
		//Method for show information button
		showButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Variables for String Information
				String data = "";
				String type = "";
				String wheels = "";
				String doors = "";
				String color = "";
				String speed = "";
				
				if (vehicleCombo.getSelectedIndex() != -1){
					if(vehicleCombo.getSelectedIndex() == 0){
						Vehicle vehicle1 = vehicleFactory.getVehicleType("CAR");
						SingletonLog.log("\nCAR SELECTED.");
						type = "Vehicle Selected: " +
								vehicleCombo.getItemAt(vehicleCombo.getSelectedIndex());
						wheels = "\n Number of Wheels: " + vehicle1.getWheelNum();
						doors =	"\n Number of Doors: " + vehicle1.getDoorNum();
						color = "\n Default Color: " + vehicle1.getColor();
						speed =	"\n Top Speed: " + vehicle1.getSpeed(); 
						data =  type + "  \n" + wheels + "  \n" + doors + "  \n" + color + "  \n" + speed;
					}
					if(vehicleCombo.getSelectedIndex() == 1){
					Vehicle vehicle2 = vehicleFactory.getVehicleType("TRUCK");
					SingletonLog.log("\nTRUCK SELECTED.");
					type = "Vehicle Selected: " +
							vehicleCombo.getItemAt(vehicleCombo.getSelectedIndex());
							wheels = "\n Number of Wheels: " + vehicle2.getWheelNum();
							doors =	"\n Number of Doors: " + vehicle2.getDoorNum();
							color = "\n Default Color: " + vehicle2.getColor();
							speed =	"\n Top Speed: " + vehicle2.getSpeed(); 
							data =  type + "  \n" + wheels + "  \n" + doors + "  \n" + color + "  \n" + speed;
					}
					if(vehicleCombo.getSelectedIndex() == 2){
						Vehicle vehicle3 = vehicleFactory.getVehicleType("MOTORCYCLE");
						SingletonLog.log("\nMOTORCYCLE SELECTED.");
						type = "Vehicle Selected: " +
								vehicleCombo.getItemAt(vehicleCombo.getSelectedIndex());
						wheels = "\n Number of Wheels: " + vehicle3.getWheelNum();
						doors =	"\n Number of Doors: " + vehicle3.getDoorNum();
						color = "\n Default Color: " + vehicle3.getColor();
						speed =	"\n Top Speed: " + vehicle3.getSpeed(); 
						data =  type + "  \n" + wheels + "  \n" + doors + "  \n" + color + "  \n" + speed;
					}
					if(vehicleCombo.getSelectedIndex() == 3){
						Vehicle vehicle4 = vehicleFactory.getVehicleType("LIMOSUINE");
						SingletonLog.log("\nLIMOSUINE SELECTED.");
						type = "Vehicle Selected: " +
								vehicleCombo.getItemAt(vehicleCombo.getSelectedIndex());
						wheels = "\n Number of Wheels: " + vehicle4.getWheelNum();
						doors =	"\n Number of Doors: " + vehicle4.getDoorNum();
						color = "\n Default Color: " + vehicle4.getColor();
						speed =	"\n Top Speed: " + vehicle4.getSpeed(); 
						data =  type + "  \n" + wheels + "  \n" + doors + "  \n" + color + "  \n" + speed;
					}
					if(vehicleCombo.getSelectedIndex() == 4){
						Vehicle vehicle5 = vehicleFactory.getVehicleType("HEARSE");
						SingletonLog.log("\nHEARSE SELECTED.");
						type = "Vehicle Selected: " +
								vehicleCombo.getItemAt(vehicleCombo.getSelectedIndex());
						wheels = "\n Number of Wheels: " + vehicle5.getWheelNum();
						doors =	"\n Number of Doors: " + vehicle5.getDoorNum();
						color = "\n Default Color: " + vehicle5.getColor();
						speed =	"\n Top Speed: " + vehicle5.getSpeed(); 
						data =  type + "  \n" + wheels + "  \n" + doors + "  \n" + color + "  \n" + speed;
					}
				}
				statusLabel.setText(data);
				SingletonLog.log("\nShow information button pressed.");
			}
		});
		
		/**
		 * The honkButton will allow a user to simulate the honking of each vehicle.
		 * Each vehicle has a unique honk specific to them.
		 */
		//Method for honk button
		honkButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (vehicleCombo.getSelectedIndex() != -1){
					if(vehicleCombo.getSelectedIndex() == 0){
						SingletonLog.log("\nCAR SELECTED.");
						//get an object of Car and call its honk method
						Vehicle vehicle1 = vehicleFactory.getVehicleType("CAR");
						//call honk method of car
						vehicle1.honk();
					}
					if(vehicleCombo.getSelectedIndex() == 1){
						SingletonLog.log("\nTRUCK SELECTED.");
						//get an object of Truck and call its honk method
						Vehicle vehicle2 = vehicleFactory.getVehicleType("TRUCK");
						vehicle2.honk();
					}
					if(vehicleCombo.getSelectedIndex() == 2){
						SingletonLog.log("\nMOTORCYCLE SELECTED.");
						//get an object of Truck and call its honk method
						Vehicle vehicle3 = vehicleFactory.getVehicleType("MOTORCYCLE");
						vehicle3.honk();
					}
					if(vehicleCombo.getSelectedIndex() == 3){
						SingletonLog.log("\nLIMOSUINE SELECTED.");
						//get an object of Truck and call its honk method
						Vehicle vehicle4 = vehicleFactory.getVehicleType("LIMOSUINE");
						vehicle4.honk();
					}
					if(vehicleCombo.getSelectedIndex() == 4){
						SingletonLog.log("\nHEARSE SELECTED.");
						//get an object of Truck and call its honk method
						Vehicle vehicle5 = vehicleFactory.getVehicleType("HEARSE");
						vehicle5.honk();
					}
			   }
			   SingletonLog.log("\nHonk button pressed.");
			}
		});
		
		/**
		 * The moveButton will allow a user to view a MessageBox that informs the user that
		 * the vehicle has moved. Each vehicle has a unique message specific to them. 
		 */
		//Method for move information button
		moveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (vehicleCombo.getSelectedIndex() != -1){
					if(vehicleCombo.getSelectedIndex() == 0){
						SingletonLog.log("\nCAR SELECTED.");
						//get an object of Car and call its move method
						Vehicle vehicle1 = vehicleFactory.getVehicleType("CAR");
						//call move method of car
						vehicle1.move();
					}
					if(vehicleCombo.getSelectedIndex() == 1){
						SingletonLog.log("\nTRUCK SELECTED.");
						//get an object of Truck and call its move method
						Vehicle vehicle2 = vehicleFactory.getVehicleType("TRUCK");
						vehicle2.move();
					}
					if(vehicleCombo.getSelectedIndex() == 2){
						SingletonLog.log("\nMOTORCYCLE SELECTED.");
						//get an object of Truck and call its move method
						Vehicle vehicle3 = vehicleFactory.getVehicleType("MOTORCYCLE");
						vehicle3.move();
					}
					if(vehicleCombo.getSelectedIndex() == 3){
						SingletonLog.log("\nLIMOSUINE SELECTED.");
						//get an object of Truck and call its move method
						Vehicle vehicle4 = vehicleFactory.getVehicleType("LIMOSUINE");
						vehicle4.move();
					}
					if(vehicleCombo.getSelectedIndex() == 4){
						SingletonLog.log("\nHEARSE SELECTED.");
						//get an object of Truck and call its move method
						Vehicle vehicle5 = vehicleFactory.getVehicleType("HEARSE");
						vehicle5.move();
					}
			   }
			   SingletonLog.log("\nMove button pressed.");
			}
		});
		
		controlPanel.add(vehicleListScrollPane);
		controlPanel.add(showButton);
		controlPanel.add(honkButton);
		controlPanel.add(moveButton);
		mainFrame.setVisible(true);
	}
}
