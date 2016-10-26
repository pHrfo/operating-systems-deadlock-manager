import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	public static void main(String args[]) {
	
		ArrayList<Integer> processList = new ArrayList<>();
		processList.add(0); processList.add(1); processList.add(2);
		
		ArrayList<Integer> available = new ArrayList<>();
		available.add(10); available.add(5); available.add(6);
		
		ArrayList<Integer> alloc0 = new ArrayList<>();
		alloc0.add(3); alloc0.add(1); alloc0.add(0);
		
		ArrayList<Integer> alloc1 = new ArrayList<>();
		alloc1.add(7); alloc1.add(0); alloc1.add(1);
		
		ArrayList<Integer> alloc2 = new ArrayList<>();
		alloc2.add(0); alloc2.add(2); alloc2.add(2);
		
		ArrayList<Integer> max0 = new ArrayList<>();
		max0.add(7); max0.add(5); max0.add(7);
		
		ArrayList<Integer> max1 = new ArrayList<>();
		max1.add(7); max1.add(1); max1.add(1);
		
		ArrayList<Integer> max2 = new ArrayList<>();
		max2.add(10); max2.add(4); max2.add(3);
		
		HashMap<Integer, ArrayList<Integer>> allocation = new HashMap<>();
		allocation.put(0, alloc0); allocation.put(1, alloc1); allocation.put(2, alloc2);
		
		HashMap<Integer, ArrayList<Integer>> max = new HashMap<>();
		max.put(0, max0); max.put(1, max1); max.put(2, max2);
	
		DeadlockManager dmng = new DeadlockManager(processList, allocation, max, available);
		System.out.println(dmng.safety());
	}
	
	
}
