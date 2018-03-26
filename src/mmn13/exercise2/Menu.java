package mmn13.exercise2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener {
	
	private JTabbedPane menuTabs;
	private JButton orderButton;
	private MenuPage firstCourse, mainCourse, dessert, drinks;
	
	public Menu(File menu) {
		super(new BorderLayout());
		
		firstCourse = new MenuPage(menu, Category.FIRST_COURSE);
		mainCourse = new MenuPage(menu, Category.MAIN_COURSE);
		dessert = new MenuPage(menu, Category.DESSERT);
		drinks = new MenuPage(menu, Category.DRINK);
		
		menuTabs = new JTabbedPane();
		menuTabs.addTab("First Course", firstCourse);
		menuTabs.addTab("Main Course", mainCourse);
		menuTabs.addTab("Dessert", dessert);
		menuTabs.addTab("Drinks", drinks);
		
		orderButton = new JButton("Order");
		
		add(menuTabs, BorderLayout.CENTER);
		add(orderButton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderButton) {
			
		}
	}

}
