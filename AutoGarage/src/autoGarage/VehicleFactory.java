//TaylorJenkins
//11-04-16
//Programming Portfolio Project


package autoGarage;

public class VehicleFactory {
	//use getVehicleType method to get object of the type of vehicle.
	
	public Vehicle getVehicleType(String vehicleType){
		if (vehicleType == null){
			return null;
		}
		if (vehicleType.equalsIgnoreCase("CAR")){
			return new Car();
		}
		if (vehicleType.equalsIgnoreCase("TRUCK")){
			return new Truck();
		}
		if (vehicleType.equalsIgnoreCase("MOTORCYCLE")){
			return new Motorcycle();
		}
		if (vehicleType.equalsIgnoreCase("LIMOSUINE")){
			return new Limosuine();
		}
		if (vehicleType.equalsIgnoreCase("HEARSE")){
			return new Hearse();
		}
		return null;
	}
}
