package com.ranjit.devices;

import com.ranjit.devices.markerIF.KitchenRoomIF;
import com.ranjit.devices.markerIF.TemperatureIF;

public class MicrowaveOven extends Device implements TemperatureIF,KitchenRoomIF{
	
	int temp;
	String mode;

	public MicrowaveOven() {
		super("MicrowaveOven");
		this.temp =40;
		this.mode = "Standard";
	}

	
	public int getTemp() {
		return temp;
	}


	public void setTemp(int temp) {
		this.temp = temp;
	}


	public String getMode() {
		return mode;
	}

	@Override
	public void regulateTemperature() {
		if(!this.getController()) {
			System.out.println("MicrowaveOven is off!");
			System.out.println("Press 1 to turn ON");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("Microwave Oven is turnig on!!");
				this.turnOnOff();
				System.out.println("Microwave Oven is On!");
				if(this.getTemp()>=200) {
					System.out.println("Temperature at Max");
				}else {
					System.out.println("1.Increase Temperature/n2.Decrease Temperature");
					int ch=sc.nextInt();
					if(ch==1) {
						this.setTemp(getTemp()+1);
						System.out.println("Current Temperature is: "+ this.getTemp());
					}else if(ch==2) {
						this.setTemp(getTemp()-1);
						System.out.println("Current Temperature is: "+ this.getTemp());
					}else {
						System.out.println("Invalid Choice!");
					}
					
				}
			}else {
				return;
			}
		}else {
			if(this.getTemp()>=200) {
				System.out.println("Temperature at Max");
			}else {
				System.out.println("1.Increase Temperature/n2.Decrease Temperature");
				int n=sc.nextInt();
				if(n==1) {
					this.setTemp(getTemp()+1);
					System.out.println("Current Temperature is: "+ this.getTemp());
				}else if(n==2) {
					this.setTemp(getTemp()-1);
					System.out.println("Current Temperature is: "+ this.getTemp());
				}else {
					System.out.println("Invalid Choice!");
				}
				
			}
		}
		
	}

	@Override
	public void changeMode() {
		if(!this.controller) {
			System.out.println("Oven is off!");
			System.out.println("Press 1 to turn on: ");
			int n = sc.nextInt();
			if(n==1) {
				this.turnOnOff();
				System.out.println("Currently device is on "+ this.mode+ " mode");
				if(this.mode=="Standard") {
					System.out.println("To Change mode to Convention press 1 else 0");
					int ch = sc.nextInt();
					if(ch==1) {
						this.mode= "Convention";
						System.out.println("mode changed...");
					}
				}
				else {
					System.out.println("To Change mode to Standard press 1 else 0");
					int ch = sc.nextInt();
					if(ch==1) {
						this.mode = "Standard";
						System.out.println("mode changed...");
					}
				}
			}
		}
		else {
			System.out.println("Currently device is on "+ this.mode+ " mode");
			if(this.mode=="Standard") {
				System.out.println("To Change mode to Convention press 1 else 0");
				int ch = sc.nextInt();
				if(ch==1) {
					this.mode= "Convention";
					System.out.println("mode changed...");
				}
			}
			else {
				System.out.println("To Change mode to Standard press 1 else 0");
				int ch = sc.nextInt();
				if(ch==1) {
					this.mode = "Standard";
					System.out.println("mode changed...");
				}
			}
		}
		
	}


	@Override
	public void getStatus() {
		if(!this.getController()) {
			System.out.println("MicroWave Oven is Off");
			System.out.println("MicroWave Oven is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}else {
			System.out.println("Microwave Oven is On");
			System.out.println("Current Mode: "+this.getMode());
			System.out.println("Current Temperature: "+this.getTemp());
			System.out.println("Microwave Oven is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		
	}


	@Override
	public void controlDevice() {
		
		System.out.println("1.Turn ON Oven");
		System.out.println("2.Turn OFF Oven");
		System.out.println("3.Change Mode");
		System.out.println("4.Regulate Temperature");
		System.out.println("5.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Microwave Oven is Turning On");
					this.turnOnOff();
					System.out.println("Microwave Oven is Turning On");
				}
				else {
					System.out.println("Oven is already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Microwave Oven is Turning Off");
					this.turnOnOff();
					System.out.println("Microwave Oven is Turning Off");
				}
				else {
					System.out.println("Oven is already OFF");
				}
				break;
			}
			case 3:{
				this.changeMode();
				break;
			}
			case 4:{
				this.regulateTemperature();
				break;
			}
			case 5:{
				this.getStatus();
			}
			default:{
				System.out.println("Invalid Entry!!!");
				break;
			}
		}
	}

}
