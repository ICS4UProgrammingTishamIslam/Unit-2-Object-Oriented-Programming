/*
 * Created by: Tisham Islam
 * Created on: 20-Oct-2019
 * Created for: ICS4U
 * Day #20 (Vehicle Class)
 * This is a program that lets you create a random vehicle class
 * Updated 10/29/2019 Day #22 (Inheritance)
 * Can use bike and trucks class
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.util.Random;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;

public class VehicleClass {

	protected Shell shlVehicleClass;
	private Text txtLicensePlate;
	private Text txtColour;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VehicleClass window = new VehicleClass();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlVehicleClass.open();
		shlVehicleClass.layout();
		while (!shlVehicleClass.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlVehicleClass = new Shell();
		shlVehicleClass.setSize(450, 300);
		shlVehicleClass.setText("Vehicle cLass by Tisham Islam");
		
		Label lblEnterInfo = new Label(shlVehicleClass, SWT.NONE);
		lblEnterInfo.setBounds(254, 10, 143, 15);
		lblEnterInfo.setText("Enter Info (If Applicable)");
		
		txtLicensePlate = new Text(shlVehicleClass, SWT.BORDER);
		txtLicensePlate.setText("License Plate");
		txtLicensePlate.setBounds(254, 31, 143, 21);
		
		txtColour = new Text(shlVehicleClass, SWT.BORDER);
		txtColour.setText("Colour");
		txtColour.setBounds(254, 58, 143, 21);
		
		Spinner spnNumDoors = new Spinner(shlVehicleClass, SWT.BORDER);
		spnNumDoors.setMaximum(10);
		spnNumDoors.setIncrement(2);
		spnNumDoors.setBounds(350, 85, 47, 22);
		
		Label lblNumberOfDoors = new Label(shlVehicleClass, SWT.NONE);
		lblNumberOfDoors.setBounds(238, 88, 110, 15);
		lblNumberOfDoors.setText("Number of Doors:");
		
		Label lblNumWheels = new Label(shlVehicleClass, SWT.NONE);
		lblNumWheels.setText("Number of Wheels:");
		lblNumWheels.setBounds(238, 116, 110, 15);
		
		Spinner spnWheels = new Spinner(shlVehicleClass, SWT.BORDER);
		spnWheels.setMaximum(10);
		spnWheels.setIncrement(2);
		spnWheels.setBounds(350, 113, 47, 22);
		
		Label lblSpeed = new Label(shlVehicleClass, SWT.NONE);
		lblSpeed.setText("Speed:");
		lblSpeed.setBounds(238, 142, 110, 15);
		
		Spinner spnSpeed = new Spinner(shlVehicleClass, SWT.BORDER);
		spnSpeed.setBounds(350, 139, 47, 22);
		
		Label lblMaxSpeed = new Label(shlVehicleClass, SWT.NONE);
		lblMaxSpeed.setText("Max Speed:");
		lblMaxSpeed.setBounds(238, 166, 110, 15);
		
		Spinner spnMaxSpeed = new Spinner(shlVehicleClass, SWT.BORDER);
		spnMaxSpeed.setMinimum(10);
		spnMaxSpeed.setIncrement(5);
		spnMaxSpeed.setBounds(350, 163, 47, 22);
		
		Label lblSeats = new Label(shlVehicleClass, SWT.NONE);
		lblSeats.setText("Seats:");
		lblSeats.setBounds(238, 190, 110, 15);
		
		Spinner spnSeats = new Spinner(shlVehicleClass, SWT.BORDER);
		spnSeats.setMaximum(5);
		spnSeats.setMinimum(1);
		spnSeats.setBounds(350, 187, 47, 22);
		
		Label lblLength = new Label(shlVehicleClass, SWT.NONE);
		lblLength.setText("Length:");
		lblLength.setBounds(238, 214, 110, 15);
		
		Spinner spnLength = new Spinner(shlVehicleClass, SWT.BORDER);
		spnLength.setMinimum(50);
		spnLength.setIncrement(2);
		spnLength.setBounds(350, 211, 47, 22);
		
		Button btnCustom = new Button(shlVehicleClass, SWT.CHECK);
		btnCustom.setBounds(20, 33, 110, 16);
		btnCustom.setText("Custom Creation");
		
		Button btnMakeCar = new Button(shlVehicleClass, SWT.NONE);
		btnMakeCar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Sorry but the car is no longer avaliable");
			}
		});
		btnMakeCar.setBounds(20, 72, 110, 25);
		btnMakeCar.setText("Make Car");
		
		Button btnMakeBike = new Button(shlVehicleClass, SWT.NONE);
		btnMakeBike.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//if custom is disabled
				if (!btnCustom.getSelection()) {
				//creates bike and prints info to console
				Bike bike = new Bike();
				bike.PrintInfo();
				}
				//else if custom is enabled
				else {
					//create a bike with the user's entered parameters
					Bike bike = new Bike(
							txtColour.getText(),
							spnSpeed.getSelection(),
							spnMaxSpeed.getSelection(),
							spnWheels.getSelection(),
							spnSeats.getSelection());										
					bike.PrintInfo();
				}
			}
		});
		btnMakeBike.setText("Make Bike");
		btnMakeBike.setBounds(20, 136, 110, 25);
		
		Button btnMakeTruck = new Button(shlVehicleClass, SWT.NONE);
		btnMakeTruck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//if custom is disabled
				if (!btnCustom.getSelection()) {
				//creates car and prints info to console
				Truck truck = new Truck();
				truck.PrintInfo();
				}
				//else if custom is enabled
				else {
					//create a car with the user's entered parameters
					Truck truck = new Truck(
							txtLicensePlate.getText(), 
							txtColour.getText(),
							spnNumDoors.getSelection(),
							spnSpeed.getSelection(),
							spnMaxSpeed.getSelection(),
							spnWheels.getSelection(),
							spnLength.getSelection());										
					truck.PrintInfo();
				}
			}
		});
		btnMakeTruck.setBounds(20, 105, 110, 25);
		btnMakeTruck.setText("Make Truck");

	}

	
	public static abstract class Vroomster{
		
		//vars
		private String licensePlate = "";
		private String colour;
		private int numDoors;
		private int speed;
		private int maxSpeed;
		private int wheels;
		
		//random generator
		private Random numGen = new Random();
		
		Vroomster() {
			//use random num gen to choose char values, and a three digit number for the license plate
			for (int i = 0; i < 4; i++) {
				//0-25 + 65, the char values of A to Z
				this.licensePlate += (char)(numGen.nextInt(26) + 65);
			}
			//add a three digit number 
			this.licensePlate += " " + String.format("%03d", numGen.nextInt(1000));
			
			//default values
			this.wheels = 4;
			this.colour = "Factory Gray";
			this.numDoors = 4;
			this.speed = 0;
			
			//makes max speed a multiple of five
			this.maxSpeed = (numGen.nextInt(50) + 50) / 5 * 5;
			
		}
		
		//custom constructor
		Vroomster(String lic, String col, int door, int nyoom, int nyoomLimit, int wheelies){	
			this.licensePlate = lic;
			this.colour = col;
			this.numDoors = door;
			this.speed = nyoom;
			this.maxSpeed = nyoomLimit;
			this.wheels = wheelies;
		}
		
		//accelerate method, not used in the program but added here just in case
		public void Accelerate(int nyoomFactor){
			this.speed += nyoomFactor;
			if (this.speed > this.maxSpeed) {
				this.speed = this.maxSpeed;
			}
		}

		//brake method, not used in the program but added here just in case
		public void Brake(int nyoomfactor) {
			this.speed -= nyoomfactor;
			if (this.speed < 0) {
				this.speed = 0;
			}
		}
		
		//prints the info of this class
		public void PrintInfo() {
			System.out.println(
					"\r\nCar Number #" + "\r\n" +
					"License Plate: " + licensePlate + "\r\n" +
					"Colour: " + colour + "\r\n" +
					"Doors: " + numDoors + "\r\n" +
					"Speed: " + speed + "\r\n" +					
					"Max Speed: " + maxSpeed + "\r\n" +					
					"Number of Wheels: " + wheels);
			
		}
		
		//prints universal info of this class, for subclasses
		public void UniPrintInfo() {
			System.out.println(
					"Colour: " + colour + "\r\n" +					
					"Number of Wheels: " + wheels + "\r\n" +
					"Speed: " + speed + "\r\n" +
					"Max Speed: " + maxSpeed);
		}
	}
	
	//bike class
	public static class Bike extends Vroomster 
	{
		//vars
		private static int bikeID = 0;
		private int seats;
			
		//bike constructor
		Bike() {
			//use super's constructor
			super();
			//set axSpeed t a lower value
			super.maxSpeed = (super.numGen.nextInt(10) + 10) / 2 * 2;
			//bikes typically only have 1 seat and 2 wheels
			this.seats = 1;			
			super.wheels = 2;
			
			//increment bikeID
			bikeID++;
		}
		
		//custom constructor
		Bike(String col,int nyoom, int nyoomLimit, int wheelies, int seatNum) {			
			super.colour = col;
			super.speed = nyoom;
			super.maxSpeed = nyoomLimit;
			super.wheels = wheelies;
			this.seats = seatNum;
			bikeID++;
		}
		
		//prints info, making use of the universal info printer
		public void PrintInfo(){
			System.out.println("\r\nBike #" + bikeID);
			super.UniPrintInfo();
			System.out.println(
			"Number of seats: " + seats);
		}		
	}
	
	//truck class
	public static class Truck extends Vroomster {
		//vars
		private static int truckID = 0;
		private int length;
		
		//truck constructor
		Truck() {
			//super constructor
			super();
			
			//increase the amount of wheels, decrease max speed by a bit, add length value
			super.wheels = (super.numGen.nextInt(10) + 10) / 2 * 2;
			super.maxSpeed = (super.numGen.nextInt(50) + 40) / 5 * 5;
			this.length = (super.numGen.nextInt(50) + 40 + super.wheels) / 4 * 4;			
			
			//increment truckID
			truckID++;
		}
		
		//custom constructor
		Truck(String lic, String col, int door, int nyoom, int nyoomLimit, int wheelies, int len){
			super.licensePlate = lic;
			super.colour = col;
			super.numDoors = door;
			super.speed = nyoom;
			super.maxSpeed = nyoomLimit;
			super.wheels = wheelies;
			this.length = len;
			truckID++;
		}
		
		//print info, making use of the universal info printer
		public void PrintInfo(){
			System.out.println("\r\n" + "Truck #" + truckID +
					"\r\nLicense Plate: " + super.licensePlate +
					"\r\nNumber of Doors: " + super.numDoors);			
			super.UniPrintInfo();
			System.out.println(
			"Truck Length: " + length);
		}		
	}
}