package com.ranjit.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ranjit.devices.Device;
import com.ranjit.devices.DeviceBasicFunctions;
import com.ranjit.devices.Fan;
import com.ranjit.devices.Light;
import com.ranjit.devices.MusicPlayer;
import com.ranjit.devices.markerIF.CorridorIF;

public class Corridor implements Room{
	
	String name;
	List<CorridorIF> crDL;
	Scanner sc=new Scanner(System.in);
	public Corridor() {
		name = "Corridor";
		crDL = new ArrayList<CorridorIF>();
	}

	public String getName() {
		return name;
	}
	
	@Override
	public DeviceBasicFunctions addDevice(int ch) {
		switch(ch) {
			case 1:{
				Fan obj = new Fan();
				this.crDL.add(obj);
				return obj;
			}
			case 2:{
				Light obj = new Light();
				this.crDL.add(obj);
				return obj;
			}
			case 3:{
				MusicPlayer obj = new MusicPlayer();
				this.crDL.add(obj);
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
		if(crDL.size()==0) {
			System.out.println("You have no devices in this room!");
		}
		else {
			for(int i=0;i<crDL.size();i++) {
				Device obj = (Device) crDL.get(i);
				System.out.println((i+1)+"."+obj.getdName());
			}
			System.out.println("Select Device:");
			int n=sc.nextInt();
			crDL.get(n-1).controlDevice();
			
		}
		
	}

	@Override
	public void getList(int flag) {
		if(flag==1) {
			for(int i=0;i<crDL.size();i++) {
				crDL.get(i).getStatus();	
			}			
		}
		else {
			for(int i=0;i<crDL.size();i++) {
				Device obj = (Device)crDL.get(i);
				System.out.println("\t"+(i+1)+"."+obj.getdName());
			}
		}
	}
}
