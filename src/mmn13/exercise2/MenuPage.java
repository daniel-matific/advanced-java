package mmn13.exercise2;

import javax.swing.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MenuPage extends JPanel {
	
	public MenuPage(Category category, ArrayList<Item> items) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Integer[] values = {1,2,3,4,5};
		JPanel row;
		for(Item item : items) {
			row = new JPanel();
			if(item.getCategory() == category) {
				row.add(new JLabel(item.getDescription() + ": " + item.getPrice()));
				row.add(new JCheckBox());
				row.add(new JComboBox<Integer>(values));
				add(row);
				row.setMaximumSize(row.getPreferredSize());
			}
		}
	}
}
