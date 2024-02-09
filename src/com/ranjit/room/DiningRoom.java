package com.ranjit.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ranjit.devices.AirConditioner;
import com.ranjit.devices.Device;
import com.ranjit.devices.DeviceBasicFunctions;
import com.ranjit.devices.Fan;
import com.ranjit.devices.Light;
import com.ranjit.devices.MusicPlayer;
import com.ranjit.devices.Television;
import com.ranjit.devices.markerIF.DiningRoomIF;

public class DiningRoom implements Room{

	String name;
	List<DiningRoomIF> drDL;
	Scanner sc=new Scanner(System.in);
	public DiningRoom() {
		name = "Dining Room";
		drDL = new ArrayList<DiningRoomIF>();
	}
	
	public String getName() {
		return name;
	}
	public DeviceBasicFunctions addDevice(int ch) {
		switch(ch) {
		case 1:{
			Fan obj = new Fan();
			this.drDL.add(obj);
			return obj;
		}
		case 2:{
			Light obj = new Light();
			this.drDL.add(obj);
			return obj;
		}
		case 3:{
			Television obj = new Television();
			this.drDL.add(obj);
			return obj;
		}
		case 4:{
			AirConditioner obj = new AirConditioner();
			this.drDL.add(obj);
			return obj;
		}
		case 5:{
			MusicPlayer obj = new MusicPlayer();
			this.drDL.add(obj);
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
		if(drDL.size()==0) {
			System.out.println("You have no devices in this room!");
		}
		else {
			for(int i=0;i<drDL.size();i++) {
				Device obj = (Device) drDL.get(i);
				System.out.println((i+1)+"."+obj.getdName());
			}
			System.out.println("Select Device:");
			int n=sc.nextInt();
			drDL.get(n-1).controlDevice();
			
		}
		
	}

	@Override
	public void getList(int flag) {
		if(flag==1) {
			for(int i=0;i<drDL.size();i++) {
				drDL.get(i).getStatus();	
			}			
		}
		else {
			for(int i=0;i<drDL.size();i++) {
				Device obj = (Device)drDL.get(i);
				System.out.println("\t"+(i+1)+"."+obj.getdName());
			}
		}
		
	}
}
