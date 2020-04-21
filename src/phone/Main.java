package phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Доступные комманды:\n" +
                "\t1.Позвонить\n" +
                "\t2.Поднять трубку\n" +
                "\t3.Сбросить\n" +
                "\t4.Пополнить баланс" +
                "\tВведите номер команды");
        Phone phone = new Phone(880055522, 100, 0.9);
        Scanner scanner = new Scanner(System.in);
        while(true){
            switch (scanner.nextLine()){
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
                }
                case "Поднять трубку": {
                    System.out.println("Поднял");
                    phone.pickUpThePhone();
                    break;
                }
                case "Сбросить" : {
                    phone.endConversation();
                    break;
                }
                case "Пополнить баланс" : {
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
