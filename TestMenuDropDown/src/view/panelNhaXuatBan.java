package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.NhaXuatBan_DAO;
import entity.NhaXuatBan;
import entity.TacGia;

public class panelNhaXuatBan extends JPanel {
	private JTextField textTenNXB;
	private JTextField textDiaChi;
	private JTable table;
	private DefaultTableModel tableModel;
    private NhaXuatBan_DAO nxb_DAO;
	/**
	 * Create the panel.
	 */
	public panelNhaXuatBan() {
		nxb_DAO=new NhaXuatBan_DAO();
setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 885, 450);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 885, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNhaXuatBan = new JLabel("NHÀ XUẤT BẢN");
		lblNhaXuatBan.setBounds(10, 10, 132, 20);
		lblNhaXuatBan.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNhaXuatBan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Ti\u1EBFt NXB", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(0, 48, 886, 109);
		panel.add(panel_2);
		
		JLabel lblTenNXB = new JLabel("Tên NXB");
		lblTenNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenNXB.setBounds(59, 28, 76, 23);
		panel_2.add(lblTenNXB);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaChi.setBounds(508, 30, 76, 23);
		panel_2.add(lblDiaChi);
		
		textTenNXB = new JTextField();
		textTenNXB.setColumns(10);
		textTenNXB.setBounds(152, 28, 216, 23);
		panel_2.add(textTenNXB);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(579, 32, 216, 23);
		panel_2.add(textDiaChi);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
             String tenNXB=textTenNXB.getText().trim();
			 String diaChi=textDiaChi.getText().trim();
				
				try {
					String maNXB=nxb_DAO.getMaxID().trim();
				
					if(ktraTTNXB(tenNXB,diaChi)) {
						
						NhaXuatBan nxb = new NhaXuatBan(maNXB,tenNXB,diaChi);
						nxb_DAO.addNXB(nxb);

						tableModel.addRow(new Object[] {maNXB,tenNXB,diaChi});
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
				
			});
		
		
		btnThem.setIcon(new ImageIcon(panelTacGia.class.getResource("/img/add-1-icon.png")));
		btnThem.setBounds(78, 179, 133, 35);
		panel.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadNXB();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textDiaChi.setText("");
				textTenNXB.setText("");
			}
		});
		btnLamMoi.setIcon(new ImageIcon(panelNhaXuatBan.class.getResource("/img/Gear-icon.png")));
		btnLamMoi.setBounds(283, 179, 133, 35);
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
							if(nxb_DAO.deleteNXB(ma))
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
		btnXoa.setBounds(691, 179, 96, 35);
		panel.add(btnXoa);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(panelTacGia.class.getResource("/img/Zoom-icon.png")));
		btnTimKiem.setBounds(459, 179, 158, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Nh\u00E0 Xu\u1EA5t B\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setBounds(0, 224, 885, 230);
		panel.add(panel_3);
		panel_3.setLayout(null);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 20, 865, 200);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 tableModel= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã Nhà Xuất Bản","Tên Nhà Xuất Bản","Địa Chỉ"
				}
			);
		table.setModel(tableModel);
		
		
	
		
	
		scrollPane_1.setViewportView(table);
		
		try {
			loadNXB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public void loadNXB() throws SQLException {
		while (table.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
		
	ArrayList<NhaXuatBan> dsNXB = nxb_DAO.getAllNXB();
	for (NhaXuatBan k : dsNXB) {
		tableModel.addRow(new Object[] {k.getMaNhaXuatBan(),k.getTenNXB(),k.getDiaChi()});
	}
	}
private boolean ktraTTNXB(String tenNXB,String DiaChi) {
		
		if(!(tenNXB.length()>0 && tenNXB.matches("[a-zA-Z' ]+"))) {
			thongBao("Error: Tên NXB theo định dạng [a-zA-Z' ]+", textTenNXB);
			return false;
		}
		if(!(DiaChi.length()>0 && DiaChi.matches("[a-zA-Z' ]+"))) {
			thongBao("Error: Địa Chỉ theo định dạng [a-zA-Z' ]+", textDiaChi);
			return false;
		}
		return true;
	}
public void thongBao(String er , JTextField txt) {
	JOptionPane.showMessageDialog(null, er);
//	txt.selectAll();
//	txt.requestFocus();
}
}

