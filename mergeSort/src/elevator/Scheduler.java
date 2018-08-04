package elevator;

import java.util.List;

public interface Scheduler {

	public void schedule(List<Elevator> elecators, List<List<Requests>> requests);
}
