package phone;

import java.util.Scanner;

public class Call extends PhoneState {
    Call(Phone phone) {
        super(phone);
    }

    @Override
    public void doWork() {
        System.out.println("Гудки.....");
        System.out.println("Введите 'Ответить' или 'Сбросить'");
        Scanner scaner = new Scanner(System.in);
        switch (scaner.next()){
            case "Ответить" : {
                System.out.println("Call to Talk, doWork");
                phone.changeState(new Talk(phone));
                break;
            } case "Сбросить" : {
                if(phone.balance > 0){
                    System.out.println("Call to Wait, doWork");
                    phone.changeState(new Wait(phone));
                } else {
                    System.out.println("Call to Blocked, doWork");
                    phone.changeState(new Blocked(phone));
                }
            }
        }

    }

    @Override
    public void toCall(int number) {
        System.out.println("Невозможно вызвать данную команду сейчас");
    }

    @Override
    public void pickUp() {
        phone.changeState(new Talk(phone));
    }

    @Override
    public void endAConversation() {
        if (phone.balance > 0) {
            System.out.println("Call to Wait, endAConversation");
            phone.changeState(new Wait(phone));
        } else {
           System.out.println("Call to Blocked, endAConversation");
            phone.changeState(new Blocked(phone));
       }
    }

    @Override
    public void replenishBalance(float money) {

    }
}
