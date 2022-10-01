package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import javax.swing.JList;

public class JPanelTest extends JPanel {

	/**
	 * Create the panel.
	 */  
	public ArrayList<MenuItem> getSubMenu() {
		return null;
	       
	    }
	public JPanelTest() {
		
		JScrollPane scrollPane = new JScrollPane(null,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(4, 5));
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_12 = new JButton("New button");
		panel.add(btnNewButton_12);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_16 = new JButton("New button");
		panel.add(btnNewButton_16);
		
		JButton btnNewButton_13 = new JButton("New button");
		panel.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		panel.add(btnNewButton_15);
		setLayout(groupLayout);
        
	}
}
