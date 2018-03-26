package mmn13.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPage extends JPanel {
	
	private ArrayList<Item> items;
	
	public MenuPage(File menu, Category category) {
		switch(category) {
		case FIRST_COURSE:break;
		case MAIN_COURSE:break;
		case DESSERT:break;
		case DRINK:break;
		}
	}
	
	private void convertFileToItemList(File menu) {
		try {
			Scanner input = new Scanner(menu);
		}
		catch (FileNotFoundException e) {
			
		}
	}
	
}
