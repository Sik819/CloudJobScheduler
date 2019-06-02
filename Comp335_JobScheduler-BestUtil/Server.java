
public class Server{
	String serverType;
	int serverID;
	int state; 	//Inactive = 0, 
				//Booting = 1, 
				//Idle = 2, 
				//Active = 3, 
				//Unavailable = 4
    int avbTime;
    int core;
    int memory;
    int dsk;
    
    public Server()
    {
    	
    }
    
    public Server(String[] arr)
    {
    	if (arr.length != 7)
    	{
    		System.out.println("Server can not be added. Insufficient value received");
    		System.out.println("--------------------------------------------------");
    	}
    	this.serverType = arr[0];
    	this.serverID = Integer.parseInt(arr[1]);
    	this.state = Integer.parseInt(arr[2]);
    	this.avbTime = Integer.parseInt(arr[3]);
    	this.core = Integer.parseInt(arr[4]);
    	this.memory = Integer.parseInt(arr[5]);
    	this.dsk = Integer.parseInt(arr[6]);
    }
    
    public boolean compareJob(Job j)
    {
    	if(j.core <= this.core && j.memory <=this.memory && j.dsk <= this.dsk)
    		return true;
    	return false;
    }
}

