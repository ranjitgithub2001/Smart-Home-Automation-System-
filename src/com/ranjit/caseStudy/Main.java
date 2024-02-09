package com.ranjit.caseStudy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		House myHouse=new House();
		Scanner sc=new Scanner(System.in);
		boolean a=true;
		do {
			System.out.println("****Mister Controller*******");
			System.out.println("1. Add Room to your House");
			System.out.println("2. Add Device to Room");
			System.out.println("3. Control Device from Room");
			System.out.println("4. Get Status(Room Wise)");
			System.out.println("5. Get Total Devices Room wise");
			System.out.println("6. Exit");
			System.out.println("Enter Choice: ");
			int ch=sc.nextInt();
			switch(ch) {
				case 1:{
					myHouse.addRoom();
					break;
				}
				case 2:{
					myHouse.addDevice();
					break;
				}
				case 3:{
					myHouse.controlDevice();
					break;
				}
				case 4:{
					myHouse.roomDeviceWiseStatus();
					break;
				}
				case 5:{
					myHouse.roomWiseDeviceList();
					break;
				}
				case 6:{
					a=false;
					break;
				}
				default:{
					System.out.println("Invalid Choise!");
					break;
				}
			}	
		}while(a);
		System.out.println("You have Exited the Application/nThank You!!!");
		
	}
}
