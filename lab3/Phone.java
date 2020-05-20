package phone;


public class Phone {
	
	public volatile int number;
	public volatile int balance;
	public volatile double probability;
	
	private volatile PhoneState state;
	
	public void changeState(PhoneState state) {
		this.state = state;
		state.doWork();
	}
	
	public PhoneState getState() {
		return state;
	}
	
	public Phone(int number, int balance, double probability) {
		this.number = number;
		this.balance = balance;
		this.probability = probability;
		if (this.balance > 0)
			this.changeState(new Wait(this));
		else
			this.changeState(new Blocked(this));
	}
	
	public void call(int number) {
		this.state.toCall(number);
	}
	
	public void pickUpThePhone() {
		this.state.pickUp();
	}
	
	public void endConversation() {
		this.state.endAConversation();
	}
	
	public void replenishBalance(float money) {
		this.state.replenishBalance(money);
	}
}
