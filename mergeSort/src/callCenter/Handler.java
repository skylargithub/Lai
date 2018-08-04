package callCenter;

public abstract class Handler {
	
	protected boolean isFree = true;

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	

}
