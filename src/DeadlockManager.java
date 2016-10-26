import java.util.ArrayList;
import java.util.HashMap;

public class DeadlockManager {
	
	ArrayList<Integer> processList;
	HashMap<Integer, ArrayList<Integer>> allocation;
	HashMap<Integer, ArrayList<Integer>> max;
	ArrayList<Integer> available;
	
	public DeadlockManager(ArrayList<Integer> processList, HashMap<Integer, ArrayList<Integer>> allocation,
			HashMap<Integer, ArrayList<Integer>> max, ArrayList<Integer> available) {

		this.processList = processList;
		this.allocation = allocation;
		this.max = max;
		this.available = available;
		
	}
	
	public void getNewInstance(Integer p, int resource, int qtt) {
		if (allocation.get(p).get(resource) + qtt <= max.get(p).get(resource)){
			if (available.get(resource) >= qtt) {
				available.set(resource, available.get(resource) - qtt);
				allocation.get(p).set(resource, allocation.get(p).get(resource) + qtt);
			}
		}
	}
	
	public boolean safety() {
		ArrayList<Integer> work = new ArrayList<>(available);
		ArrayList<Boolean> finish = new ArrayList<>();
		boolean output = true;
		boolean flag = true;
		
		for (@SuppressWarnings("unused") int p : processList)
			finish.add(false);
		
		while(flag) {
			flag = false;
			for (int i=0; i < processList.size(); i++)
				if (finish.get(i) == false && needWorkTest(i, work)) {
					flag = true;
					finish.set(i, true);
					System.out.println("Process " + (i) + " finished");
					increaseWork(i, work);					
				}
		}
		
		for(boolean b : finish)
			if (b == false)
				output = false;		
		
		return output;
	}
	
	public boolean needWorkTest(int p, ArrayList<Integer> work) {
		
		for (int i = 0; i < work.size(); i++)
			if (work.get(i) < max.get(p).get(i) - allocation.get(p).get(i))
				return false;
		return true;
		
	}
	
	public void increaseWork(int p, ArrayList<Integer> work) {
		
		for (int i = 0; i < work.size(); i++)
			work.set(i, work.get(i) + allocation.get(p).get(i));
		
	}
	
}
