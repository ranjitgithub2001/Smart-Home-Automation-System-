package com.ranjit.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ranjit.devices.AirConditioner;
import com.ranjit.devices.Device;
import com.ranjit.devices.DeviceBasicFunctions;
import com.ranjit.devices.Fan;
import com.ranjit.devices.Light;
import com.ranjit.devices.MicrowaveOven;
import com.ranjit.devices.MusicPlayer;
import com.ranjit.devices.Refrigerator;
import com.ranjit.devices.markerIF.KitchenRoomIF;

public class Kitchen implements Room{

	String name;
	List<KitchenRoomIF> krDL;
	Scanner sc=new Scanner(System.in);
	public Kitchen() {
		name = "Kitchen";
		krDL = new ArrayList<KitchenRoomIF>();
	}
	
	public String getName() {
		return name;
	}
	public DeviceBasicFunctions addDevice(int ch) {
		switch(ch) {
			case 1:{
				Fan obj = new Fan();
				this.krDL.add(obj);
				return obj;
			}
			case 2:{
				Light obj = new Light();
				this.krDL.add(obj);
				return obj;
			}
			case 3:{
				MicrowaveOven obj = new MicrowaveOven();
				this.krDL.add(obj);
				return obj;
			}
			case 4:{
				Refrigerator obj = new Refrigerator();
				this.krDL.add(obj);
				return obj;
			}
			case 5:{
				AirConditioner obj = new AirConditioner();
				this.krDL.add(obj);
				return obj;
			}
			case 6:{
				MusicPlayer obj = new MusicPlayer();
				this.krDL.add(obj);
				return obj;
			}
			default:{
				System.out.println("Invalid entry!!!");
				return null;
			}
		}
	}

	@Override
	public void controlDeviceR() {
		if(krDL.size()==0) {
			System.out.println("You have no devices in this room!");
		}
		else {
			for(int i=0;i<krDL.size();i++) {
				Device obj = (Device) krDL.get(i);
				System.out.println((i+1)+"."+obj.getdName());
			}
			System.out.println("Select Device:");
			int n=sc.nextInt();
			krDL.get(n-1).controlDevice();
			
		}
		
	}

	@Override
	public void getList(int flag) {
		if(flag==1) {
			for(int i=0;i<krDL.size();i++) {
				krDL.get(i).getStatus();	
			}			
		}
		else {
			for(int i=0;i<krDL.size();i++) {
				Device obj = (Device)krDL.get(i);
				System.out.println("\t"+(i+1)+"."+obj.getdName());
			}
		}
	}
}
