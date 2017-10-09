package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	public boolean writeByte(byte singleByte) throws SerialPortException{
		port.writeByte(singleByte);
		String str = Integer.toHexString(singleByte);
		System.out.print(str);
		return debug;
	}
	
	// TODO: Add available() method
	public boolean available(byte singleByte) throws SerialPortException{
		int count = port.getInputBufferBytesCount();
		if (count > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// TODO: Add readByte() method	
	public byte readByte(int singleByte) throws SerialPortException {
	
	}
	// TODO: Add a main() method
	public static void main() {

		while(available()){
			writeByte();
		}
	};
}
