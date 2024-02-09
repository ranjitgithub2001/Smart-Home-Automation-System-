package com.ranjit.devices;

import com.ranjit.devices.markerIF.BedRoomIF;
import com.ranjit.devices.markerIF.DiningRoomIF;
import com.ranjit.devices.markerIF.KitchenRoomIF;
import com.ranjit.devices.markerIF.LivingRoomIF;
import com.ranjit.devices.markerIF.TemperatureIF;

public class AirConditioner extends Device implements TemperatureIF,LivingRoomIF,BedRoomIF,DiningRoomIF,KitchenRoomIF{

	int temperature;
	String mode;

	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public AirConditioner() {
		super("AC");
		this.temperature = 18;
		this.mode="Cool";
		System.out.println(this.getdName() + " Added..");
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public void regulateTemperature() {
		if(!this.getController()) {
			System.out.println("AC is Off!");
			System.out.println("Press 1 to turn ON");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("AC is turnig ON!");
				if(this.turnOnOff()) {
					System.out.println("AC is On!");
					System.out.println("/t/t1.Increase Temperature/n/t/t2.Decrease Temperature");
					int s=sc.nextInt();
					if(s==1) {
						this.setTemperature(getTemperature()+1);
						System.out.println("Current Temperature is: "+this.getTemperature()+" *C");
					}else if(s==2){
						this.setTemperature(getTemperature()-1);
						System.out.println("Current Temperature is: "+this.getTemperature()+" *C");
					}else {
						System.out.println("Invalid Choice!!");
					}
				}
			}else {
				System.out.println("Invlid entry!!!");
				return;
			}
		}
		else {
			System.out.println("/t/t1.Increase Temperature/n/t/t2.Decrease Temperature");
			int s=sc.nextInt();
			if(s==1) {
				this.setTemperature(getTemperature()+1);
				System.out.println("Current Temperature is: "+this.getTemperature()+" *C");
			}else if(s==2){
				this.setTemperature(getTemperature()-1);
				System.out.println("Current Temperature is: "+this.getTemperature()+" *C");
			}else {
				System.out.println("Invalid Choice!!");
			}
		}
	}

	@Override
	public void changeMode() {
		if(this.controller) {
			System.out.println("Select Mode/n1.Cool/n2.Dry/n3.Fan/n4.Turbo Mode/n5.Sleep Mode/n6.Eco Mode");
			int n=sc.nextInt();
			switch(n) {
			case 1:{
				this.setMode("Cool");
				break;
			}
			case 2:{
				this.setMode("Dry");
				break;
			}
			case 3:{
				this.setMode("Fan");
				break;
			}
			case 4:{
				this.setMode("Turbo Mode");
				break;
			}
			case 5:{
				this.setMode("Sleep Mode");
				break;
			}
			case 6:{
				this.setMode("Eco Mode");
				break;
			}
			default: {
				System.out.println("Invalid Choice!!");
			}
			}
			System.out.println("Current Mode: "+this.getMode());
		}
		else {
			System.out.println("AC is off!!");
			
		}
	}

	@Override
	public void getStatus() {
		if(!this.getController()) {
			System.out.println("AC is Off");
			System.out.println("AC is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes"); 
		}else {
			System.out.println("AC is On");
			System.out.println("Current Mode : "+this.getMode());
			System.out.println("Current Temperature of your AC : "+this.getTemperature());
			System.out.println("AC is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		
	}

	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Regulate Temperature");
		System.out.println("4.Change Mode");
		System.out.println("5.Check Status");
		int n=sc.nextInt();
		switch(n) {
			case 1:{
				if(!this.getController()) {
					System.out.println("AC is Turning On");
					this.turnOnOff();
					System.out.println("AC is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("AC is Turning Off");
					this.turnOnOff();
					System.out.println("AC is Off");					
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
				this.changeMode();
				break;
			}
			case 5:{
				this.getStatus();
				break;
			}
			default:{
				System.out.println("Invalid Choice!!!");
			}
		}
		
	}
	
	
}
