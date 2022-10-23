package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.TacGia_DAO;
import entity.TacGia;


public class panelTacGia extends JPanel implements MouseListener {
	private JTextField textTenTacGia;
	private JTable table;
	 private static final AtomicInteger count = new AtomicInteger(); 
	 private TacGia_DAO tacGia_DAO;
	private DefaultTableModel tableModel;
	/**
	 * Create the panel.
	 * @param tenTacGia 
	 * @param maTacGia 
	 */
	public panelTacGia() {
		tacGia_DAO=new TacGia_DAO();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 885, 431);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 885, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTacGia = new JLabel("TÁC GIẢ");
		lblTacGia.setBounds(10, 10, 86, 20);
		lblTacGia.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblTacGia);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Ti\u1EBFt T\u00E1c Gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(0, 48, 886, 84);
		panel.add(panel_2);
		
		textTenTacGia = new JTextField();
		textTenTacGia.setColumns(10);
		textTenTacGia.setBounds(175, 30, 216, 23);
		panel_2.add(textTenTacGia);
		
		JLabel lblTenTacGia = new JLabel("Tên Tác Giả");
		lblTenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenTacGia.setBounds(59, 28, 76, 23);
		panel_2.add(lblTenTacGia);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String tenTacGia=textTenTacGia.getText();
			
				
				
				try {
					String maTacGia=tacGia_DAO.getMaxID();
					
						tableModel.addRow(new Object[] {maTacGia,tenTacGia});
						TacGia tacGia = new TacGia(maTacGia,tenTacGia);
						tacGia_DAO.addTacGia(tacGia);
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		btnThem.setIcon(new ImageIcon(panelTacGia.class.getResource("/img/add-1-icon.png")));
		btnThem.setBounds(79, 156, 133, 35);
		panel.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					loadTacGia();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textTenTacGia.setText("");
			}
		});
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setIcon(new ImageIcon(panelTacGia.class.getResource("/img/Gear-icon.png")));
		btnLamMoi.setBounds(281, 156, 133, 35);
		panel.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row>=0)
				{				
					
					String ma = (String)table.getValueAt(row,0);
					int show = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa",ma, JOptionPane.YES_NO_OPTION);
					 if(show==JOptionPane.YES_OPTION)
						try {
							if(tacGia_DAO.deleteTacGia(ma))
							{
								tableModel.removeRow(row);						
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}else {
					JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Dòng Cần Xóa");
				}
				
			}
		});
		btnXoa.setIcon(new ImageIcon(panelTacGia.class.getResource("/img/Button-Delete-icon.png")));
		btnXoa.setBounds(677, 156, 96, 35);
		panel.add(btnXoa);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiemTacGia();
				
			}
		});
		btnTimKiem.setIcon(new ImageIcon(panelTacGia.class.getResource("/img/Zoom-icon.png")));
		btnTimKiem.setBounds(455, 156, 158, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch T\u00E1c Gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setBounds(0, 201, 885, 230);
		panel.add(panel_3);
		panel_3.setLayout(null);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 865, 199);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 tableModel= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã Tác Giả","Tên Tác Giả"
				}
			);
		table.setModel(tableModel);
		scrollPane_1.setViewportView(table);
		table.addMouseListener(this);
		try {
			loadTacGia();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void loadTacGia() throws SQLException {
		while (table.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
	ArrayList<TacGia> dsTacGia = tacGia_DAO.getAllTacGia();
	for (TacGia k : dsTacGia) {
		tableModel.addRow(new Object[] {k.getMaTacGia(),k.getTenTacGia()});
	}
	}
	public void timKiemTacGia()
	{  
	   DefaultTableModel tbModel = (DefaultTableModel) table.getModel();
	   tbModel.setRowCount(0);
	   String name = textTenTacGia.getText();
	   for(TacGia k  : tacGia_DAO.timTacGia(name)) {
		   tableModel.addRow(new Object[] {k.getMaTacGia(),k.getTenTacGia()});

	   }
	   table.setModel(tableModel);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row =table.getSelectedRow();
		textTenTacGia.setText(table.getValueAt(row,1).toString());			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
