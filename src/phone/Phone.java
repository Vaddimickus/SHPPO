package phone;


public class Phone {
    public int number;
    public int balance;
    public double probability;

    private PhoneState state;

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
