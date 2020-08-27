package com.e_commerce.projectinjection;

public class DemoClass implements DemoParent
{

	VideoType videotype;
	Platform platform;
	Device device;
	
	
	
	
	public VideoType getVideotype() {
		return videotype;
	}




	public void setVideotype(VideoType videotype) {
		this.videotype = videotype;
	}




	public Platform getPlatform() {
		return platform;
	}




	public void setPlatform(Platform platform) {
		this.platform = platform;
	}




	public Device getDevice() {
		return device;
	}




	public void setDevice(Device device) {
		this.device = device;
	}




	public void watch() 
	{
		System.out.println("Let's watch "+videotype.getVideotype()+" from "+platform.getPlatform()+" on "+device.getDevice());
	}

}
