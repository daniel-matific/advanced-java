package mmn13.exercise2;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
