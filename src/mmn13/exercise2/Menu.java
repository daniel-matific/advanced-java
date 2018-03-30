package mmn13.exercise2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener {

	private ArrayList<Item> items;
	private JTabbedPane menuTabs;
	private JButton orderButton;
	private MenuPage firstCourse, mainCourse, dessert, drinks;
	private JScrollPane firstCourse_scrollable, mainCourse_scrollable, dessert_scrollable, drinks_scrollable;
	private Order order;

	public Menu(File menu) {
		super(new BorderLayout());

		items = new ArrayList<Item>();
		convertFileToItemList(menu);

		firstCourse = new MenuPage(Category.FIRST_COURSE, items);
		mainCourse = new MenuPage(Category.MAIN_COURSE, items);
		dessert = new MenuPage(Category.DESSERT, items);
		drinks = new MenuPage(Category.DRINK, items);
		firstCourse_scrollable = new JScrollPane(firstCourse);
		mainCourse_scrollable = new JScrollPane(mainCourse);
		dessert_scrollable = new JScrollPane(dessert);
		drinks_scrollable = new JScrollPane(drinks);

		menuTabs = new JTabbedPane();
		menuTabs.addTab("First Course", firstCourse_scrollable);
		menuTabs.addTab("Main Course", mainCourse_scrollable);
		menuTabs.addTab("Dessert", dessert_scrollable);
		menuTabs.addTab("Drinks", drinks_scrollable);

		orderButton = new JButton("Order");
		orderButton.addActionListener(this);

		add(menuTabs, BorderLayout.CENTER);
		add(orderButton, BorderLayout.SOUTH);

		order = new Order();
	}

	private void convertFileToItemList(File menu) {
		try {
			Scanner input = new Scanner(menu);
			int i = 0;
			while(input.hasNext()) {
				if(i % 3 == 0) {
					Item item = new Item();
					items.add(item);
				}
				switch(i % 3) {
				case 0: items.get(items.size()-1).setDescription(input.nextLine());
				break;
				case 1: items.get(items.size()-1).setCategory(Category.valueOf(input.nextLine()));
				break;
				case 2: items.get(items.size()-1).setPrice(Integer.parseInt(input.nextLine()));
				break;
				}	
				i++;
			}
			input.close();
		}
		catch (FileNotFoundException e) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderButton) {
			String[] options = {"Confirm", "Change", "Cancel"};
			int choice = JOptionPane.showOptionDialog(this, order.generateOrder(menuTabs), "Order Details", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			switch(choice) {
			case 0: 
				String outputFileName = JOptionPane.showInputDialog("Please enter your first name and ID(e.g. Name123456789):");
				File outputFile = new File("D:\\workspace\\advanced-java\\bin\\mmn13\\exercise2\\" + outputFileName + ".txt");
				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new FileWriter(outputFile));
					writer.write(order.getOrderDetails());
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						writer.close();
					} catch (Exception e2) {
					}
				}
				resetOrder();
				break;
			case 1:
				order = new Order();
				break;
			case 2:
			case -1:
				resetOrder();
				break;
			}
		}
	}

	private void resetOrder() {
		removeAll();

		firstCourse = new MenuPage(Category.FIRST_COURSE, items);
		mainCourse = new MenuPage(Category.MAIN_COURSE, items);
		dessert = new MenuPage(Category.DESSERT, items);
		drinks = new MenuPage(Category.DRINK, items);
		firstCourse_scrollable = new JScrollPane(firstCourse);
		mainCourse_scrollable = new JScrollPane(mainCourse);
		dessert_scrollable = new JScrollPane(dessert);
		drinks_scrollable = new JScrollPane(drinks);

		menuTabs = new JTabbedPane();
		menuTabs.addTab("First Course", firstCourse_scrollable);
		menuTabs.addTab("Main Course", mainCourse_scrollable);
		menuTabs.addTab("Dessert", dessert_scrollable);
		menuTabs.addTab("Drinks", drinks_scrollable);

		add(menuTabs, BorderLayout.CENTER);
		add(orderButton, BorderLayout.SOUTH);

		order = new Order();
		revalidate();
		repaint();
	}
}































