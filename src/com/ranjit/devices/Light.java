package com.ranjit.devices;

import com.ranjit.devices.markerIF.BedRoomIF;
import com.ranjit.devices.markerIF.CorridorIF;
import com.ranjit.devices.markerIF.DiningRoomIF;
import com.ranjit.devices.markerIF.KitchenRoomIF;
import com.ranjit.devices.markerIF.LivingRoomIF;
import com.ranjit.devices.markerIF.WashRoomIF;

public class Light extends Device implements BedRoomIF,KitchenRoomIF,DiningRoomIF,LivingRoomIF,WashRoomIF,CorridorIF{
	
	public Light(){
		super("Light");
		System.out.println(this.getdName() + " Added..");
	}

	@Override
	public void getStatus() {
		if(this.getController()) {
			System.out.println("Light is ON");
			System.out.println("Light is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}else {
			System.out.println("Light is OFF");
			System.out.println("Light is Off since "+this.getCurrentTimeStatus().toMinutes()+" minutes");
		}
		
	}

	@Override
	public void controlDevice() {
		System.out.println("Press 1 to turn On Light");
		System.out.println("Press 2 to Turn Off Light");
		int ch = sc.nextInt();
		if(ch==1) {
			if(!this.getController()) {
				System.out.println("Light is Turning On");
				this.turnOnOff();
				System.out.println("Light is On");
			}
			else {
				System.out.println("Light is already ON");
			}
		}
		else if(ch==2) {
			if(this.getController()) {
				System.out.println("Light is Turning Off");
				this.turnOnOff();
				System.out.println("Light is Off");
			}
			else {
				System.out.println("Light is already OFF");
			}
		}
		else {
			System.out.println("Invalid Entry!");
		}
	}
}
