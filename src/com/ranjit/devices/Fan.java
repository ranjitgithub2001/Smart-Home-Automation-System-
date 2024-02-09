package com.ranjit.devices;

import com.ranjit.devices.markerIF.BedRoomIF;
import com.ranjit.devices.markerIF.CorridorIF;
import com.ranjit.devices.markerIF.DiningRoomIF;
import com.ranjit.devices.markerIF.KitchenRoomIF;
import com.ranjit.devices.markerIF.LivingRoomIF;

public class Fan extends Device implements LivingRoomIF,BedRoomIF,DiningRoomIF,KitchenRoomIF,CorridorIF{

	int speed;
	
	public Fan() {
		super("Fan");
		this.speed = 1;
		System.out.println(this.getdName() + " Added..");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

	public void regulateSpeed() {
		
		if(!this.getController()) {
			System.out.println("Fan is off!");
			System.out.println("Press 1 to Turn ON");
			int ch=sc.nextInt();
			if(ch==1) {
				System.out.println("Fan is turnig on!!");
				this.turnOnOff();
				System.out.println("Fan is On!");
				if(this.getSpeed()>=5) {
					System.out.println("Fan at Max Speed!");
				}else {
					System.out.println("/t/t1.Increase Speed/n/t/t2.Decrease Speed");
					int s=sc.nextInt();
					if(s==1) {
						this.setSpeed(getSpeed()+1);
						System.out.println("Current Speed is: "+this.getSpeed());
					}else if(s==2){
						this.setSpeed(getSpeed()-1);
						System.out.println("Current Speed is: "+this.getSpeed());
					}
				}
			}else {
				return;
			}
		}else {
			if(this.getSpeed()>=5) {
				System.out.println("Fan at Max Speed!");
			}else {
				System.out.println("/t/t1.Increase Speed/n/t/t2.Decrease Speed");
				int s=sc.nextInt();
				if(s==1) {
					this.setSpeed(getSpeed()+1);
					System.out.println("Current Speed is: "+this.getSpeed());
				}else if(s==2){
					this.setSpeed(getSpeed()-1);
					System.out.println("Current Speed is: "+this.getSpeed());
				}
			}
		}	
	}

	@Override
	public void getStatus() {
		if(!this.getController()) {
			System.out.println("Fan is Off!!");
			System.out.println("Fan is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}else {
			System.out.println("Fan is On");
			System.out.println("Current Speed is: "+this.getSpeed());
			System.out.println("Fan is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
	}

	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Regulate Speed");
		System.out.println("4.Check Status");
		int n=sc.nextInt();
		switch(n) {
			case 1:{
				if(!this.getController()) {
					System.out.println("Fan is Turning On");
					this.turnOnOff();
					System.out.println("Fan is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Fan is Turning Off");
					this.turnOnOff();
					System.out.println("Fan is Off");					
				}
				else {
					System.out.println("Already OFF");
				}
				break;
			}
			case 3:{
				this.regulateSpeed();
				break;
			}
			case 4:{
				this.getStatus();
				break;
			}
			default:{
				System.out.println("Invalid Entry!!");
				break;
			}
		}
	}
	
}
