package com.ranjit.devices;

import com.ranjit.devices.markerIF.KitchenRoomIF;
import com.ranjit.devices.markerIF.TemperatureIF;

public class Refrigerator extends Device implements TemperatureIF, KitchenRoomIF{

	int temp;
	String mode;

	public Refrigerator() {
		super("Refrigerator");
		this.temp =15;
		this.mode = "Normal";
		System.out.println(this.getdName() + " Added..");
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

	public void regulateTemperature() {
		if(!this.getController()) {
			System.out.println("Refrigerator is off!");
			System.out.println("Press 1 to turn ON");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("Refrigerator is turnig on!!");
				this.turnOnOff();
				System.out.println("Refrigerator is On!");
				if(this.getTemp()>=15) {
					System.out.println("Temperature at Max");
				}else {
					System.out.println("1.Increase Temperature/n2.Decrease Temperature");
					int ch=sc.nextInt();
					if(ch==1) {
						this.setTemp(getTemp()+1);
						System.out.println("Current Temperature is: "+ this.getTemp());
					}else if(ch==2) {
						if(this.getTemp()<=3) {
							System.out.println("Reached the lowest temperature 3 celsius");
						}
						else {
							this.setTemp(getTemp()-1);
							System.out.println("Current Temperature is: "+ this.getTemp());
						}
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
		
		if(this.getController()) {
			System.out.println("Select Mode:/n/t/t1.Freezer Mode/n/t/t2.Vacation Mode/n/t/t3.Turbo Mode/n/t/t4.Normal Mode/n/t/t5.Seasonal Mode");
			int n=sc.nextInt();
			switch(n) {
				case 1:{
					this.mode = "Freezer Mode";
					break;
				}
				case 2:{
					this.mode = "Vacation Mode";
					break;
				}
				case 3:{
					this.mode = "Turbo Mode";
					break;
				}
				case 4:{
					this.mode = "Normal Mode";
					break;
				}
				case 5:{
					this.mode = "Seasonal Mode";
					break;
				}
				default:{
					System.out.println("Inavalid Choice!!");
				}
			}
		}else {
			System.out.println("Refrigerator is Off");
		}
		
		
	}


	@Override
	public void getStatus() {
		
		if(!this.getController()) {
			System.out.println("Refrigerator is Off");
			System.out.println("Refrigerator is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}else {
			System.out.println("Refrigerator is On");
			System.out.println("Current Mode: "+ this.getMode());
			System.out.println("Current Temperature: "+this.getTemp());
			System.out.println("Refrigerator is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		
	}

	@Override
	public void controlDevice() {
		System.out.println("1.Turn On");
		System.out.println("2.Turn Off");
		System.out.println("3.Change Mode");
		System.out.println("4.Regulate Temperature");
		System.out.println("5.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Refrigerator is Turning On");
					this.turnOnOff();
					System.out.println("Refrigerator is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Refrigerator is Turning On");
					this.turnOnOff();
					System.out.println("Refrigerator is On");
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
