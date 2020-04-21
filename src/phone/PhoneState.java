package phone;

public abstract class PhoneState {
    Phone phone;

    PhoneState(Phone phone) {
        this.phone = phone;
    }


    public abstract void toCall(int number);

    public abstract void pickUp();

    public abstract void endAConversation();

    public abstract void replenishBalance(float money);

    public abstract void doWork();
}
