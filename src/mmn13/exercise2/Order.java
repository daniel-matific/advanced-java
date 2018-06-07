package mmn13.exercise2;

import javax.swing.*;

public class Order {
	
	private double totalPrice;
	private String orderDetails;
	private final int PRICE = 1;
	
	public Order() {
		totalPrice = 0;
		orderDetails = "";
	}

	// Returns the order details
	public String getOrderDetails() {
		return orderDetails;
	}

	// Generates the order details
	public String generateOrder(JTabbedPane menuTabs) {
		for(int i = 0; i < menuTabs.getComponentCount(); i++) {
			MenuPage menuPage = (MenuPage) ((JScrollPane) menuTabs.getComponent(i)).getViewport().getView();
			orderDetails += menuTabs.getTitleAt(i) + "\r\n===============\r\n" + extractSelectedFromMenuPage(menuPage) + "\r\n";
		}
		orderDetails += "\r\nTOTAL PRICE: " + totalPrice;
		return orderDetails;
	}

	// Extracts the selected items from the menu page
	@SuppressWarnings("unchecked")
	private String extractSelectedFromMenuPage(MenuPage menuPage) {
		String extractedItems = "";
		for(int i = 0; i < menuPage.getComponentCount(); i++) {
			JLabel description = (JLabel) ((JPanel) menuPage.getComponent(i)).getComponent(0);
			JCheckBox isChosen = (JCheckBox) ((JPanel) menuPage.getComponent(i)).getComponent(1);
			JComboBox<Integer> amount = (JComboBox<Integer>) ((JPanel) menuPage.getComponent(i)).getComponent(2);
			if(isChosen.isSelected()) {
				double amountTimesPrice = Math.round((Double.parseDouble(description.getText().split(": ")[PRICE])) * (Integer)amount.getSelectedItem() * 100.0) / 100.0;
				extractedItems += description.getText() + " * " + amount.getSelectedItem() + " = " + amountTimesPrice + "\r\n";
				totalPrice += amountTimesPrice;
			}
		}
		return extractedItems;
	}
}
