package com.techelevator;

import com.techelevator.view.Menu;

import java.util.List;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE ,MAIN_MENU_OPTION_EXIT};
	private VendingMachine vendingMachine;

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				displayPurchaseItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
			else if(choice.equals(MAIN_MENU_OPTION_EXIT))
				//TODO Add logger later
				System.exit(0);
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


	public void displayPurchaseItems(){
		VendingMachineItem[] items = vendingMachine.getInventory().toArray(new VendingMachineItem[0]);
		for(int i = 0;i<items.length;i++ ){
			System.out.println(items[i].getId() +" "+items[i].getName() +" QTY: "+(items[i].isSoldOut()?"SOLD OUT":items[i].getStock()));
		}
	}
}
