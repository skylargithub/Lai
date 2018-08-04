package callCenter;

import java.util.Deque;

public class Respondent extends Handler {
	
	private Respondent nextChain;
	
	public Respondent() {
		super();
	}
	
	public void add(Respondent res) {
		if(nextChain == null) {
			this.nextChain = res;
		} else {
			this.nextChain.add(res);
		}
	}
	
	public void execute(Deque<Request> resQ) {
		if(this.isFree) {
			resQ.pollFirst();
		} else {
			nextChain.execute(resQ);
		}
	}

}
