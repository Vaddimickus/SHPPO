package phone;

public class Blocked extends PhoneState {
    Blocked(Phone phone) {
        super(phone);
    }

    @Override
    public void doWork() {
        System.out.println("Телефон заблокирован");
    }

    @Override
    public void toCall(int number) {
        System.out.println("Невозможно вызвать данную команду сейчас");
    }

    @Override
    public void pickUp() {
        System.out.println("Blocked to Talk, pickUp");
        phone.changeState(new Talk(phone));
    }

    @Override
    public void endAConversation() {
        System.out.println("Невозможно вызвать данную команду сейчас");
    }

    @Override
    public void replenishBalance(float money) {
        if (money < 0)
            System.out.println("Вы ввели неверную сумму");
        else
            phone.balance += money;
        System.out.println("Баланс = " + phone.balance);
    }
}
