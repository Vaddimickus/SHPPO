package phone;

public class Wait extends PhoneState {
    Wait(Phone phone) {
        super(phone);
    }

    @Override
    public void doWork() {
        System.out.println("Ожидаю");
        new Thread(() -> {
            if(Math.random() < this.phone.probability){
                System.out.println("Вам входящий звонок");
                System.out.println("Wait to Call, doWork");
                phone.changeState(new Call(phone));
            }
        }).start();
    }

    @Override
    public void toCall(int number) {
        if (phone.balance > 0){
            System.out.println("Wait to Talk, toCall");
            phone.changeState(new Talk(phone));
        } else {
            System.out.println("Wait to Blocked, toCall");
            phone.changeState(new Blocked(phone));
        }
    }

    @Override
    public void pickUp() {
        System.out.println("Принимаем входящий звонок");
        System.out.println("Wait to Talk, pickUp");
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
