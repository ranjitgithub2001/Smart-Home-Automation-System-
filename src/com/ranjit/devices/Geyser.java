package com.ranjit.devices;

import com.ranjit.devices.markerIF.TemperatureIF;
import com.ranjit.devices.markerIF.WashRoomIF;

public class Geyser extends Device implements TemperatureIF, WashRoomIF{

	int temp;
	
	public Geyser() {
		super("Geyser");
		temp=50;
		System.out.println(this.getdName() + " Added..");
	}
	
	public int getTemp() {
		return temp;
	}

	@Override
	public void getStatus() {
		if(this.getController()) {
			System.out.println("Geyser is On");
			System.out.println("Current Temperature: "+this.temp);
			System.out.println("Geyser is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		else {
			System.out.println("Geyser is Off");
			System.out.println("Geyser is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
	}
	
	public void regulateTemperature() {
		if(this.getController()) {
			System.out.println("Current Temperature is: " + this.temp +" Max:60 Min:50");
			System.out.println("1.Increase Temperature\n2.Decrease Temperature");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("Temperature increased to "+ ++this.temp);				
			}
			else if(ch==2) {
				System.out.println("Temperature Decreased to "+ --this.temp);
			}
			else {
				System.out.println("Invalid Entry!!");
			}
		}
		else {
			System.out.println("Geyser is Off");
		}
	}

	@Override
	public void changeMode() {
		System.out.println("This feature is not available!!");
	}

	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Regulate volume");
		System.out.println("4.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Geyser is Turning On");
					this.turnOnOff();
					System.out.println("Geyser is On");
					
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Geyser is Turning Off");
					this.turnOnOff();
					System.out.println("Geyser is Off");
				}
				else {
					System.out.println("Already OFF");
				}
				break;
			}
			case 3:{
				this.regulateTemperature();
				break;
			}
			case 4:{
				this.getStatus();
				break;
			}
			default:{
				System.out.println("Invalid Entry!!!");
				break;
			}
		}		
	}

}
