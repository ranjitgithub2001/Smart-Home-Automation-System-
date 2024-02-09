package com.ranjit.caseStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ranjit.devices.DeviceBasicFunctions;
import com.ranjit.room.BedRoom;
import com.ranjit.room.Corridor;
import com.ranjit.room.DiningRoom;
import com.ranjit.room.Kitchen;
import com.ranjit.room.LivingRoom;
import com.ranjit.room.Room;
import com.ranjit.room.WashRoom;

public class House {
	List<DeviceBasicFunctions> dList;
	List<Room> rList;
	
	public House() {
		dList = new ArrayList<DeviceBasicFunctions>();
		rList = new ArrayList<Room>();
	}
	
	Scanner sc = new Scanner(System.in);
	public void addRoom() {
		System.out.println("Select type of Room");
		System.out.println("1.BedRoom");
		System.out.println("2.Living Room");
		System.out.println("3.Kitchen");
		System.out.println("4.Dining Room");
		System.out.println("5.WashRoom");
		System.out.println("6.Corridor");
		
		int ch = sc.nextInt();
		switch(ch) {
			case 1:{
				rList.add(new BedRoom());
				System.out.println("BedRoom added...");
				break;
			}
			case 2:{
				rList.add(new LivingRoom());
				System.out.println("Living Room added...");
				break;
			}
			case 3:{
				rList.add(new Kitchen());
				System.out.println("Kitchen added...");
				break;
			}
			case 4:{
				rList.add(new DiningRoom());
				System.out.println("Dining Room added...");
				break;
			}
			case 5:{
				rList.add(new WashRoom());
				System.out.println("WashRoom added...");
				break;
			}
			case 6:{
				rList.add(new Corridor());
				System.out.println("Corridor added...");
				break;
			}
			default:{
				System.out.println("Invalid entry!!!");
				break;
			}
		}
	}
	
	//device add
	public void addDevice() {
		if(rList.size()==0){
			System.out.println("You have no room added yet!\n");
		}
		else {
			for(int i=0;i<rList.size();i++) {
				System.out.println((i+1)+"."+rList.get(i).getName());
			}
			
			System.out.println("Select Room: ");
			int n=sc.nextInt();
			
			if(rList.get(n-1) instanceof BedRoom) {
				System.out.println("1.Fan");
				System.out.println("2.Light");
				System.out.println("3.TV");
				System.out.println("4.AC");
				System.out.println("5.Music Player");
			}
			else if(rList.get(n-1) instanceof Corridor) {
				System.out.println("1.Fan");
				System.out.println("2.Light");
				System.out.println("3.Music Player");
			}
			else if(rList.get(n-1) instanceof Kitchen) {
				System.out.println("1.Fan");
				System.out.println("2.Light");
				System.out.println("3.Microwave Oven");
				System.out.println("4.Refrigerator");
				System.out.println("5.AC");
				System.out.println("6.Music Player");
			}
			else if(rList.get(n-1) instanceof LivingRoom) {
				System.out.println("1.Fan");
				System.out.println("2.Light");
				System.out.println("3.TV");
				System.out.println("4.AC");
				System.out.println("5.Music Player");
			}
			else if(rList.get(n-1) instanceof WashRoom) {
				System.out.println("1.Light");
				System.out.println("2.Shower");
				System.out.println("3.Washing Machine");
				System.out.println("4.Music Player");
				System.out.println("5.Geyser");
			}
			else if(rList.get(n-1) instanceof DiningRoom) {
				System.out.println("1.Fan");
				System.out.println("2.Light");
				System.out.println("3.TV");
				System.out.println("4.AC");
				System.out.println("5.Music Player");
			}
			
			int ch = sc.nextInt();
			dList.add(rList.get(n-1).addDevice(ch));
		}
	}
	public void controlDevice() {
		if(rList.size()==0) {
			System.out.println("You have no room added yet!\n");
		}
		else {
			for(int i=0;i<rList.size();i++) {
				System.out.println((i+1)+"."+rList.get(i).getName());
			}
			System.out.println("Select Room: ");
			int n=sc.nextInt();
			rList.get(n-1).controlDeviceR();			
		}
	}
	
	public void roomDeviceWiseStatus() {
		if(rList.size()==0) {
			System.out.println("You have no room added yet!\n");
		}
		else {
			for(int i=0;i<rList.size();i++) {
				System.out.println(rList.get(i).getName());
				rList.get(i).getList(1);
			}
		}
	}
	public void roomWiseDeviceList() {
		if(rList.size()==0) {
			System.out.println("You have no room added yet!\n");
		}
		else {
			for(int i=0;i<rList.size();i++) {
				System.out.println(rList.get(i).getName());
				rList.get(i).getList(2);
			}
		}
	}
	
	
	
	
	
}
