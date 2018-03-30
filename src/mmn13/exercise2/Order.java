package mmn13.exercise2;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Order {
	
	private int totalPrice;
	private String orderDetails;
	private final int PRICE = 1;
	
	public Order() {
		totalPrice = 0;
		orderDetails = "";
	}
	
	public String getOrderDetails() {
		return orderDetails;
	}
	
	public String generateOrder(JTabbedPane menuTabs) {
		for(int i = 0; i < menuTabs.getComponentCount(); i++) {
			MenuPage menuPage = (MenuPage) ((JScrollPane) menuTabs.getComponent(i)).getViewport().getView();
			orderDetails += menuTabs.getTitleAt(i) + "\r\n===============\r\n" + extractSelectedFromMenuPage(menuPage) + "\r\n";
		}
		orderDetails += "\r\nTOTAL PRICE: " + totalPrice;
		return orderDetails;
	}
	
	@SuppressWarnings("unchecked")
	private String extractSelectedFromMenuPage(MenuPage menuPage) {
		String extractedItems = "";
		for(int i = 0; i < menuPage.getComponentCount(); i++) {
			JLabel description = (JLabel) ((JPanel) menuPage.getComponent(i)).getComponent(0);
			JCheckBox isChosen = (JCheckBox) ((JPanel) menuPage.getComponent(i)).getComponent(1);
			JComboBox<Integer> amount = (JComboBox<Integer>) ((JPanel) menuPage.getComponent(i)).getComponent(2);
			if(isChosen.isSelected()) {
				int amountTimesPrice = (Integer.parseInt(description.getText().split(": ")[PRICE])) * (Integer)amount.getSelectedItem();
				extractedItems += description.getText() + " * " + amount.getSelectedItem() + " = " + amountTimesPrice + "\r\n";
				totalPrice += amountTimesPrice;
			}
		}
		return extractedItems;
	}
}
