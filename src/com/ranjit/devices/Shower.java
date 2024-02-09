package com.ranjit.devices;

import com.ranjit.devices.markerIF.PressureIF;
import com.ranjit.devices.markerIF.WashRoomIF;

public class Shower extends Device implements WashRoomIF,PressureIF{

	int pressure;
	public Shower() {
		super("Shower");
		this.pressure=1;
		System.out.println(this.getdName() + " Added..");
	}

	@Override
	public void getStatus() {
		if(this.controller) {
			System.out.println("Shower is On");
			System.out.println("Current Pressure: "+this.pressure);
			System.out.println("Shower is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		else {
			System.out.println("Shower is Off");
			System.out.println("Shower is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
	}

	@Override
	public void regulatePressure() {
		if(this.getController()) {
			System.out.println("Current Pressure is: " + this.pressure +" Max:10 Min:1");
			System.out.println("1.Increase Pressure\n2.Decrease Pressure");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("Pressure increased to "+ ++this.pressure);				
			}
			else if(ch==2) {
				System.out.println("Pressure Decreased to "+ --this.pressure);
			}
			else {
				System.out.println("Invalid Entry!!");
			}
		}
		else {
			System.out.println("Shower is Off");
		}
	}

	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Regulate Pressure");
		System.out.println("4.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Shower is Turning On");
					this.turnOnOff();
					System.out.println("Shower is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Shower is Turning Off");
					this.turnOnOff();
					System.out.println("Shower is Off");
				}
				else {
					System.out.println("Already OFF");
				}
				break;
			}
			case 3:{
				this.regulatePressure();
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
