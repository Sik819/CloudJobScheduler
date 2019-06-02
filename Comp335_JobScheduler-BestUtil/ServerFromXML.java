public class ServerFromXML {
	String serverType;
	int limit;
	int bootupTime; 	//Inactive = 0, 
				//Booting = 1, 
				//Idle = 2, 
				//Active = 3, 
				//Unavailable = 4
    float rate;
    int core;
    int memory;
    int disk;
    
    public ServerFromXML(String[] arr)
    {
    	if (arr.length != 7)
    	{
    		System.out.println("Server can not be added. Insufficient value received");
    		System.out.println("--------------------------------------------------");
    	}
    	this.serverType = arr[0];
    	this.limit = Integer.parseInt(arr[1]);
    	this.bootupTime = Integer.parseInt(arr[2]);
    	this.rate = Float.parseFloat(arr[3]);
    	this.core = Integer.parseInt(arr[4]);
    	this.memory = Integer.parseInt(arr[5]);
    	this.disk = Integer.parseInt(arr[6]);
    }
    
    public boolean compareJob(Job j)
    {
    	if(j.core <= this.core && j.memory <=this.memory && j.dsk <= this.disk)
    		return true;
    	return false;
    }
}