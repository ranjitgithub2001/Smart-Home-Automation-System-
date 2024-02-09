package com.ranjit.devices;

import com.ranjit.devices.markerIF.BedRoomIF;
import com.ranjit.devices.markerIF.DiningRoomIF;
import com.ranjit.devices.markerIF.EntertainmentIF;
import com.ranjit.devices.markerIF.LivingRoomIF;

public class Television extends Device implements EntertainmentIF,DiningRoomIF,LivingRoomIF,BedRoomIF{

	int volume;
	
	public Television() {
		super("Television");
		this.volume=10;
		System.out.println(this.getdName() + " Added..");
	}

	public int getVolume() {
		return volume;
	}



	public void setVolume(int volume) {
		this.volume = volume;
	}



	@Override
	public void getStatus() {
		if(!this.getController()) {
			System.out.println("Television is Off");
			System.out.println("Television is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}else {
			System.out.println("Television is On");
			System.out.println("Current Volume Level: "+this.getVolume());
			System.out.println("Television is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
	}


	@Override
	public void controlVolume() {
		if(!this.getController()) {
			System.out.println("Television is Off");
			System.out.println("Press 1 to Turn On if NO Press 2");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("Television is turnig on!!");
				this.turnOnOff();
				System.out.println("Television is On!");
				System.out.println("/t1.Increase Volume/n/t2.Decrease Volume");
				n=sc.nextInt();
				if(n==1) {
					this.setVolume(getVolume()+1);
					System.out.println("Current Volume Level: "+this.getVolume());
				}else if(n==2) {
					this.setVolume(getVolume()-1);
					System.out.println("Current Volume Level: "+this.getVolume());
				}else {
					System.out.println("Invalid Choice");
				}
			}else {
				return;
			}
		}else {
			System.out.println("/t1.Increase Volume/n/t2.Decrease Volume");
			int n=sc.nextInt();
			if(n==1) {
				this.setVolume(getVolume()+1);
				System.out.println("Current Volume Level: "+this.getVolume());
			}else if(n==2) {
				this.setVolume(getVolume()-1);
				System.out.println("Current Volume Level: "+this.getVolume());
			}else {
				System.out.println("Invalid Choice");
			}
		}
		
	}


	@Override
	public void change() {
		System.out.println("Channel Changed!!!");
	}

	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Change Channel");
		System.out.println("4.Control Volume");
		System.out.println("5.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Television is Turning On");
					this.turnOnOff();
					System.out.println("Television is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Television is Turning Off");
					this.turnOnOff();
					System.out.println("Television is Off");
				}
				else {
					System.out.println("Already OFF");
				}
				break;
			}
			case 3:{
				this.change();
				break;
			}
			case 4:{
				this.controlVolume();
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
