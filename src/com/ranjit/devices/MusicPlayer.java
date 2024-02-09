package com.ranjit.devices;

import com.ranjit.devices.markerIF.BedRoomIF;
import com.ranjit.devices.markerIF.CorridorIF;
import com.ranjit.devices.markerIF.DiningRoomIF;
import com.ranjit.devices.markerIF.EntertainmentIF;
import com.ranjit.devices.markerIF.KitchenRoomIF;
import com.ranjit.devices.markerIF.LivingRoomIF;
import com.ranjit.devices.markerIF.WashRoomIF;

public class MusicPlayer extends Device implements EntertainmentIF,DiningRoomIF,KitchenRoomIF,BedRoomIF,LivingRoomIF,CorridorIF,WashRoomIF{

	int vol;
	String mode;
	
	public MusicPlayer() {
		super("Music Player");
		this.vol=12;
		this.mode="Music";
		System.out.println(this.getdName() + " Added..");
	}

	
	public int getVol() {
		return vol;
	}


	public void setVol(int vol) {
		this.vol = vol;
	}


	public String getMode() {
		return mode;
	}


	@Override
	public void getStatus() {
		if(!this.getController()) {
			System.out.println("Music Player is Off");
			System.out.println("Music Player is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");		
		}else {
			System.out.println("Music Player is On");
			System.out.println("Curret Mode: "+this.getMode());
			System.out.println("Current Volume Level : "+this.getVol());
			System.out.println("Music Player is On since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		
	}

	@Override
	public void controlVolume() {
		if(!this.getController()) {
			System.out.println("Music Player is Off");
			System.out.println("Press 1 to Turn On if NO Press 2");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("Music Player is turnig on!!");
				this.turnOnOff();
				System.out.println("Music Player is On!");
				System.out.println("/t1.Increase Volume/n/t2.Decrease Volume");
				n=sc.nextInt();
				if(n==1) {
					this.setVol(getVol()+1);
					System.out.println("Current Volume Level: "+this.getVol());
				}else if(n==2) {
					this.setVol(getVol()-1);
					System.out.println("Current Volume Level: "+this.getVol());
				}else {
					System.out.println("Invalid Choice!!");
				}
			}
			else {
				return;
			}
		}else {
			System.out.println("/t1.Increase Volume/n/t2.Decrease Volume");
			int n=sc.nextInt();
			if(n==1) {
				this.setVol(getVol()+1);
				System.out.println("Current Volume Level: "+this.getVol());
			}else if(n==2) {
				this.setVol(getVol()-1);
				System.out.println("Current Volume Level: "+this.getVol());
			}else {
				System.out.println("Invalid Choice!!");
			}
		}
	}

	@Override
	public void change() {
		System.out.println("Select Mode: /n/t1.Music Mode/n/t2.Gaming Mode/n/t3.Sports Mode/n/t4.Movie Mode");
		int n=sc.nextInt();
		switch(n) {
			case 1:{
				this.mode = "Music Mode";
				break;
			}
			case 2:{
				this.mode = "Gaming Mode";
				break;
			}
			case 3:{
				this.mode = "Sports Mode";
				break;
			}
			case 4:{
				this.mode = "Movie Mode";
				break;
			}
			default:{
				System.out.println("Invalid Choice!!");
				break;
			}
		}
		System.out.println("Current Mode: "+this.getMode());
	}


	@Override
	public void controlDevice() {
		System.out.println("1.Turn ON");
		System.out.println("2.Turn OFF");
		System.out.println("3.Change Mode");
		System.out.println("4.Regulate Volume");
		System.out.println("5.Check Status");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:{
				if(!this.getController()) {
					System.out.println("Music Player is Turning On");
					this.turnOnOff();
					System.out.println("Music Player is On");
				}
				else {
					System.out.println("Already ON");
				}
				break;
			}
			case 2:{
				if(this.getController()) {
					System.out.println("Music Player is Turning Off");
					this.turnOnOff();
					System.out.println("Music Player is Off");
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
