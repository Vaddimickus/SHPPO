package phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone(880055522, 100, 0.1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные комманды:\n" +
                "\tПозвонить\n" +
                "\tПоднять трубку\n" +
                "\tСбросить\n" +
                "\tПополнить баланс");
        while(true){
            switch (scanner.next()){
                case "Позвонить" : {
                    System.out.println("Введите номер (начиная с 8, максимум 9 цифр)");
                    while(true) {
                        try {
                            phone.call(scanner.nextInt());
                            break;
                        } catch (Exception e) {
                            System.out.println("Вы ввели номер не верно");
                        }
                    }
                    break;
                } case "Поднять трубку": {
                    phone.pickUpThePhone();
                    break;
                } case "Сбросить" : {
                    phone.endConversation();
                    break;
                } case "Пополнить баланс" : {
                    System.out.println("Введите сумму (в копейках)");
                    while(true) {
                        try {
                            phone.replenishBalance(scanner.nextInt());
                            break;
                        } catch (Exception e) {
                            System.out.println("Вы ввели не приемлимую сумму");
                        }
                    }
                    break;
                }
            }
        }
    }
}
