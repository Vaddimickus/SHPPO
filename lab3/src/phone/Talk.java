package phone;

import java.util.Scanner;

public class Talk extends PhoneState implements Runnable {
	
	Talk(Phone phone) {
		super(phone);
	}
	
	@Override
	public void doWork() {
		new Thread(() -> {
			System.out.println("Разговариваю");
			System.out.println("Введите 'Сбросить' для завершения разговора");
			
			new Thread(this).start();
			
			Scanner scanner;
			scanner = new Scanner(System.in);
			
			while (phone.balance > 0) {
				String str = scanner.next();
				
				if (str.equals("Сбросить")) {
					endAConversation();
					break;
				}
				
				System.out.println("Баланс = " + phone.balance);
			}
			
			if (!(phone.balance > 0)) {
				phone.changeState(new Blocked(phone));
			}
		}).start();
	}
	
	@Override
	public void toCall(int number) {
		System.out.println("Невозможно вызвать данную команду сейчас");
	}
	
	@Override
	public void pickUp() {
		System.out.println("Невозможно вызвать данную команду сейчас");
	}
	
	@Override
	public void endAConversation() {
		if (phone.balance > 0) {
			System.out.println("Talk to Wait, endAConversation");
			phone.changeState(new Wait(phone));
		} else {
			System.out.println("Talk to Wait, Blocked");
			phone.changeState(new Blocked(phone));
		}
	}
	
	@Override
	public void replenishBalance(float money) {
	}
	
	@Override
	public void run() {
		System.out.println(phone.getState().getClass() + " ; " + Talk.class);
		while (phone.getState().getClass().equals(Talk.class)) {
			phone.balance -= 5;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
