package com.ranjit.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ranjit.devices.Device;
import com.ranjit.devices.DeviceBasicFunctions;
import com.ranjit.devices.Geyser;
import com.ranjit.devices.Light;
import com.ranjit.devices.MusicPlayer;
import com.ranjit.devices.Shower;
import com.ranjit.devices.WashingMachine;
import com.ranjit.devices.markerIF.WashRoomIF;

public class WashRoom implements Room{
	
	String name;
	List<WashRoomIF> wrDL;
	Scanner sc=new Scanner(System.in);
	public WashRoom() {
		name = "WashRoom";
		wrDL = new ArrayList<WashRoomIF>();
	}
	public String getName() {
		return name;
	}
	
	public DeviceBasicFunctions addDevice(int ch) {
		switch(ch) {
			case 1:{
				Light obj = new Light();
				this.wrDL.add(obj);
				return obj;
			}
			case 2:{
				Shower obj = new Shower();
				this.wrDL.add(obj);
				return obj;
			}
			case 3:{
				WashingMachine obj = new WashingMachine();
				this.wrDL.add(obj);
				return obj;
			}
			case 4:{
				MusicPlayer obj = new MusicPlayer();
				this.wrDL.add(obj);
				return obj;
			}
			case 5:{
				Geyser obj = new Geyser();
				this.wrDL.add(obj);
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
		if(wrDL.size()==0) {
			System.out.println("You have no devices in this room!");
		}
		else {
			for(int i=0;i<wrDL.size();i++) {
				Device obj = (Device) wrDL.get(i);
				System.out.println((i+1)+"."+obj.getdName());
			}
			System.out.println("Select Device:");
			int n=sc.nextInt();
			wrDL.get(n-1).controlDevice();			
		}
		
	}
	@Override
	public void getList(int flag) {
		if(flag==1) {
			for(int i=0;i<wrDL.size();i++) {
				wrDL.get(i).getStatus();	
			}
		}
		else {
			for(int i=0;i<wrDL.size();i++) {
				Device obj = (Device)wrDL.get(i);
				System.out.println("\t"+(i+1)+"."+obj.getdName());
			}
		}
		
	}
}
