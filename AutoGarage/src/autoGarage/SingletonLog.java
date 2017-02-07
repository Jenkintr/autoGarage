//TaylorJenkins
//11-04-16
//Programming Portfolio Project


package autoGarage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SingletonLog {
	
	//Implements a Singleton logger instance
	private static final SingletonLog instance = new SingletonLog();
	
	//Retrieve the execution directory. 
	public String logname = "singletonlog";
	protected String env = System.getProperty("user.dir");
	private static File logFile;
	
	public static SingletonLog getInstance(){
		return instance;
	}
	
	public static SingletonLog getInstance(String withName){
		instance.logname = withName;
		instance.createLogFile();
		return instance;
	}

	public void createLogFile(){
		//Determine if a log directory exists or not.
		File logsFolder = new File(env + '/' + "logs");
		if(!logsFolder.exists()){
			System.err.println("Creating new logs directory" + env);
			logsFolder.mkdir();
		}
		
		//Get date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		//Create the name of file from the path and current time.
		logname = logname + '-' + dateFormat.format(cal.getTime()) + ".log";
		SingletonLog.logFile = new File(logsFolder.getName(), logname);
		try{
			if(logFile.createNewFile()){
				System.err.println("Creating new log file");
			}
		}
		catch(IOException e){
			System.err.println("ERROR. Log file cannot be created.");
			System.exit(1);
		}
	}
	
	private SingletonLog(){
		if (instance != null){
			throw new IllegalStateException("Cannot instantiate a new singleton instance.");
		}
		this.createLogFile();
	}
	
	public static void log(String message){
		try{
			FileWriter out = new FileWriter(SingletonLog.logFile, true);
			out.write(message.toCharArray());
			out.close();
		}
		catch(IOException e){
			System.err.println("ERROR. Log couldnt be written to this file.");
		}
	}
}
