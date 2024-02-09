package com.ranjit.devices;

import com.ranjit.devices.markerIF.TemperatureIF;
import com.ranjit.devices.markerIF.WashRoomIF;

public class WashingMachine extends Device implements TemperatureIF, WashRoomIF{

	String mode;
	
	public WashingMachine() {
		super("Washing Machine");
		this.mode="Normal Mode";
		System.out.println(this.getdName() + " Added..");
	}
	

	public String getMode() {
		return mode;
	}

	@Override
	public void getStatus() {
		if(!this.getController()) {
			System.out.println("Washing Machine is Off");
			System.out.println("Washing Machine is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}else {
			System.out.println("Washing Machine is On");
			System.out.println("Current Mode: "+this.getMode());
			System.out.println("Washing Machine is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		
	}

	@Override
	public void changeMode() {
		if(this.getController()) {
			System.out.println("Select Mode: /n/t1.Normal Mode/n/t2.Green Mode/n/t3.Allergy Mode/n/t4.Permannant Press/n/t5.Quick Wash");
			int n=sc.nextInt();
			switch(n) {
				case 1:{
					this.mode = "Normal Mode";
					break;
				}
				case 2:{
					this.mode = "Green Mode";
					break;
				}
				case 3:{
					this.mode = "Allergy Mode";
					break;
				}
				case 4:{
					this.mode = "Permanant Press";
					break;
				}
				case 5:{
					this.mode = "Quick Wash";
					break;
				}
				default:{
					System.out.println("Invalid Choice");
				}
			}
			System.out.println("Current Mode: "+this.getMode());
		}else {
			System.out.println("Washing Machine is Off");
		}	
	}


	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Change Mode");
		System.out.println("5.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Washing Room is Turning On");
					this.turnOnOff();
					System.out.println("Washing Room is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Washing Room is Turning Off");
					this.turnOnOff();
					System.out.println("Washing Room is Off");
				}
				else {
					System.out.println("Already OFF");
				}
				break;
			}
			case 3:{
				this.changeMode();
				break;
			}
			case 4:{
				this.getStatus();
			}
			default:{
				System.out.println("Invalid Entry!!!");
				break;
			}
		}		
	}

}
