package view;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.Sach_DAO;
import entity.Sach;

import java.awt.GridLayout;

public class PanelXemSach extends JPanel {
      private Sach_DAO sach_DAO;
     
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public PanelXemSach() throws SQLException {
		sach_DAO =new Sach_DAO();
		JScrollPane scrollPane = new JScrollPane();
		JPanel PanelProduct=new JPanel();
		PanelProduct.setLayout(new GridBagLayout());
		scrollPane.setViewportView(PanelProduct);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		//     initComponents();
		
			ArrayList<Sach> dsSach=sach_DAO.getAllSach();
		
		ArrayList <PanelBookItem> list=new ArrayList<>();
		
			for(Sach sach :dsSach) {
				list.add(new PanelBookItem(sach));
			}
				
     
    
     GridBagConstraints gbc=new GridBagConstraints();
     gbc.insets=new Insets(20, 20, 20, 20);
     
     
     int x=0;
     int y=0;
     for (PanelBookItem item :list) {
    	 gbc.gridx=x;
    	 gbc.gridy=y;
    	 PanelProduct.add(item,gbc);
    	 x++;
    	 if(x==4) {
    		 x=0;
    		 y++;
    	 }
    	 
     }
	}
}
