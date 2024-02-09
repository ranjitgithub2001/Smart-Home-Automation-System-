package com.ranjit.devices;

import java.time.Duration;

public interface DeviceBasicFunctions {

	public boolean turnOnOff();
	
	public void getStatus();
	
	public Duration getCurrentTimeStatus();
	
	public void controlDevice();
	
	
	
}