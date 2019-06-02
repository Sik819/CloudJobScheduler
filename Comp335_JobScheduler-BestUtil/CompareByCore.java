import java.util.Comparator;

public class CompareByCore implements Comparator<Server>{
	

	//ascending order
	@Override
	public int compare(Server s1, Server s2) {
		
		return s1.core-s2.core;
	} 
	
}
