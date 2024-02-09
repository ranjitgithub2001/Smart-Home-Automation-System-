package com.ranjit.devices;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class Device implements DeviceBasicFunctions {
	
	LocalTime onTime;
	LocalTime offTime;
	boolean controller;
	String dName;
	
//	public Device() {
//		// TODO Auto-generated constructor stub
//	}

	Device(String dName) {
		super();
		this.dName=dName;
		this.onTime = null;
		this.offTime = LocalTime.now();
		this.controller = false;
	}

	Scanner sc=new Scanner(System.in);
	public LocalTime getOnTime() {
		return onTime;
	}

	public void setOnTime(LocalTime onTime) {
		this.onTime = onTime;
	}

	public LocalTime getOffTime() {
		return offTime;
	}

	public void setOffTime(LocalTime offTime) {
		this.offTime = offTime;
	}

	

	public boolean getController() {
		return controller;
	}

	public void setController(boolean controller) {
		this.controller = controller;
	}

	public String getdName() {
		return dName;
	}

	@Override
	public boolean turnOnOff() {
		if(this.controller==false) {
			System.out.println();
			this.onTime=LocalTime.now();
			this.controller=true;
			return true;
		}else {
			this.offTime=LocalTime.now();
			this.controller=false;
			return false;
		}
	}

	@Override
	public Duration getCurrentTimeStatus() {
		if(this.controller==true) {
			return Duration.between(this.onTime,LocalTime.now());
		}else {
			return Duration.between(this.offTime,LocalTime.now());
		}
	}
}
