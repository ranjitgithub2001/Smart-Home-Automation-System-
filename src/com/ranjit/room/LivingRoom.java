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
import com.ranjit.devices.markerIF.LivingRoomIF;

public class LivingRoom implements Room{
	
	String name;
	List<LivingRoomIF> lrDL;
	Scanner sc=new Scanner(System.in);
	public LivingRoom() {
		name = "Living Room";
		lrDL = new ArrayList<LivingRoomIF>();
	}
	public String getName() {
		return name;
	}
	
	public DeviceBasicFunctions addDevice(int ch) {
		switch(ch) {
			case 1:{
				Fan obj = new Fan();
				this.lrDL.add(obj);
				return obj;
			}
			case 2:{
				Light obj = new Light();
				this.lrDL.add(obj);
				return obj;
			}
			case 3:{
				Television obj = new Television();
				this.lrDL.add(obj);
				return obj;
			}
			case 4:{
				AirConditioner obj = new AirConditioner();
				this.lrDL.add(obj);
				return obj;
			}
			case 5:{
				MusicPlayer obj = new MusicPlayer();
				this.lrDL.add(obj);
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
		if(lrDL.size()==0) {
			System.out.println("You have no devices in this room!");
		}
		else {
			for(int i=0;i<lrDL.size();i++) {
				Device obj = (Device) lrDL.get(i);
				System.out.println((i+1)+"."+obj.getdName());
			}
			System.out.println("Select Device:");
			int n=sc.nextInt();
			lrDL.get(n-1).controlDevice();
			
		}
		
	}
	@Override
	public void getList(int flag) {
		if(flag==1) {
			for(int i=0;i<lrDL.size();i++) {
				lrDL.get(i).getStatus();	
			}			
		}
		else {
			for(int i=0;i<lrDL.size();i++) {
				Device obj = (Device)lrDL.get(i);
				System.out.println("\t"+(i+1)+"."+obj.getdName());
			}
		}
		
	}
}
