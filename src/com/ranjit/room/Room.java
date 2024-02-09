package com.ranjit.room;

import com.ranjit.devices.DeviceBasicFunctions;

public interface Room {
	public DeviceBasicFunctions addDevice(int ch);
	public void controlDeviceR();
	public String getName();
	public void getList(int i);
}
