package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.NhaXuatBan_DAO;
import dao.Sach_DAO;
import dao.TacGia_DAO;
import entity.NhaXuatBan;
import entity.Sach;
import entity.TacGia;


import javax.swing.ListSelectionModel;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class CapNhatSach extends JPanel implements MouseListener {
	private JTextField txtTenSach;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private JTable table;
	private JTextField txtLoaiSach;
    private TacGia_DAO tacGia_DAO;
    private NhaXuatBan_DAO nxb_DAO;
    private Sach_DAO sach_DAO;
    private String maSachHientai;
	/**
	 * Create the panel.
	 */
	private DefaultTableModel tableModel;
	private JTextField txtSoLuongDaBan;
	protected static String donGia;
	protected static String tenLoaiSach;
	protected static String tenSach;
	protected static String soLuong;
	protected static String soLuongDaBan;
	protected static String maTacGia;
	protected static String maNXB;
	protected File file;
	public CapNhatSach() {
		tacGia_DAO=new TacGia_DAO();
		nxb_DAO=new NhaXuatBan_DAO();
		sach_DAO=new Sach_DAO();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1282, 776);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 0, 1282, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CẬP NHẬT ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 0, 97, 35);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 45, 1272, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Sách");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(59, 26, 65, 23);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Đơn Giá\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(59, 60, 65, 23);
		panel_2.add(lblNewLabel_1_1_1);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(193, 28, 216, 23);
		panel_2.add(txtTenSach);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(193, 62, 216, 23);
		panel_2.add(txtDonGia);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại Sách");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(603, 26, 65, 23);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số Lượng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(603, 60, 65, 23);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("NXB");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(603, 94, 65, 23);
		panel_2.add(lblNewLabel_1_2_2);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(783, 62, 213, 23);
		panel_2.add(txtSoLuong);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tác Giả");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(59, 94, 76, 23);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		txtLoaiSach = new JTextField();
		txtLoaiSach.setColumns(10);
		txtLoaiSach.setBounds(783, 28, 213, 23);
		panel_2.add(txtLoaiSach);
		
		JComboBox comboBoxTacGia = new JComboBox();
		ArrayList<TacGia> dsTacGia = null;
		try {
			dsTacGia = tacGia_DAO.getAllTacGia();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (TacGia k : dsTacGia) {
			comboBoxTacGia.addItem(k.getMaTacGia());
		}
		comboBoxTacGia.setBounds(193, 96, 216, 22);
		
		
		JComboBox comboBoxNXB = new JComboBox();
		ArrayList<NhaXuatBan> dsNXB = null;
		try {
			dsNXB = nxb_DAO.getAllNXB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (NhaXuatBan k : dsNXB) {
			comboBoxNXB.addItem(k.getMaNhaXuatBan());
		}
		panel_2.add(comboBoxTacGia);
		comboBoxNXB.setBounds(783, 96, 213, 22);
		panel_2.add(comboBoxNXB);
		
		txtSoLuongDaBan = new JTextField();
		txtSoLuongDaBan.setBounds(193, 129, 216, 20);
		panel_2.add(txtSoLuongDaBan);
		txtSoLuongDaBan.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Số Lượng Đã Bán");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(58, 132, 125, 17);
		panel_2.add(lblNewLabel_1);
		
		JButton btnThemSach = new JButton("Thêm");
		btnThemSach.addActionListener(new ActionListener() {
		

		

			public void actionPerformed(ActionEvent e) {
				
             tenSach=txtTenSach.getText();
             donGia=txtDonGia.getText();
             tenLoaiSach=txtLoaiSach.getText();
             soLuong=txtSoLuong.getText();
             soLuongDaBan=txtSoLuongDaBan.getText();
			 maTacGia=comboBoxTacGia.getSelectedItem()+"";
				 maNXB=comboBoxNXB.getSelectedItem()+"";
				
				try {
					String maSach=sach_DAO.getMaxID();
					if(ktraTTSach(tenSach,donGia,tenLoaiSach,soLuong,soLuongDaBan)) {
						
						tableModel.addRow(new Object[] {maSach,maNXB,maTacGia,tenSach,donGia,tenLoaiSach,soLuong,soLuongDaBan});
						Sach sach = new Sach(maSach,maNXB,maTacGia,tenSach,Double.parseDouble(donGia),tenLoaiSach,Integer.parseInt(soLuong),Integer.parseInt(soLuongDaBan));
						sach_DAO.addSach(sach);
					}
			
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
			}
		);
		
		btnThemSach.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/add-1-icon.png")));
		btnThemSach.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemSach.setBounds(205, 267, 133, 35);
		panel.add(btnThemSach);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadSach();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnLamMoi.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/disk-icon.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(449, 267, 144, 35);
		panel.add(btnLamMoi);
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(row>=0)
				{
				
					 tenSach=txtTenSach.getText();
		             donGia=txtDonGia.getText();
		             tenLoaiSach=txtLoaiSach.getText();
		             soLuong=txtSoLuong.getText();
		             soLuongDaBan=txtSoLuongDaBan.getText();
					 maTacGia=comboBoxTacGia.getSelectedItem()+"";
						 maNXB=comboBoxNXB.getSelectedItem()+"";
						 Sach sach = new Sach(maSachHientai,maNXB,maTacGia,tenSach,Double.parseDouble(donGia),tenLoaiSach,Integer.parseInt(soLuong),Integer.parseInt(soLuongDaBan));
					int show = JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Chắn Muốn Sửa","Chắc Chắn",JOptionPane.YES_NO_OPTION);
					 if(show==JOptionPane.YES_OPTION)
						try {
							if(sach_DAO.updateSach(sach))
							{						
								table.setValueAt(maSachHientai, row, 0);
								table.setValueAt(maNXB, row, 1);
								table.setValueAt(maTacGia, row, 2);
								table.setValueAt(tenSach, row, 3);
								table.setValueAt(donGia, row, 4);
								table.setValueAt(tenLoaiSach, row, 5);
								table.setValueAt(soLuong, row, 6);
								table.setValueAt(soLuongDaBan, row, 7);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sách cần sửa");
					
				}
			}
		});
		btnCapNhat.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/Gear-icon.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCapNhat.setBounds(665, 267, 158, 35);
		panel.add(btnCapNhat);
		
		JButton btnXoaSach = new JButton("Xóa");
		btnXoaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(row>=0)
				{				
					
					String ma = (String)table.getValueAt(row,0);
					int show = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa",ma, JOptionPane.YES_NO_OPTION);
					 if(show==JOptionPane.YES_OPTION)
						try {
							if(sach_DAO.deleteSach(ma))
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
		btnXoaSach.setIcon(new ImageIcon(CapNhatSach.class.getResource("/img/Button-Delete-icon.png")));
		btnXoaSach.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoaSach.setBounds(917, 267, 96, 35);
		panel.add(btnXoaSach);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setBorder(new TitledBorder(null, "Danh S\u00E1ch C\u00E1c Lo\u1EA1i S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(36, 350, 1208, 415);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 1188, 389);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableModel =new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã Sách", "Mã NXB", "Mã Tác Giả", "Tên Sách", "Đơn Giá", "Tên Loại Sách", "Số Lượng", "Số lượng đã bán"
					
				}
			);
		table.setModel(tableModel);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		JButton btnNhapFile = new JButton("Nhập Từ File");
		btnNhapFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser= new JFileChooser();
				fileChooser.setCurrentDirectory(new File("."));
				int response=fileChooser.showSaveDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					
					 file =new File(fileChooser.getSelectedFile().getAbsolutePath());
					System.out.println(file);
					try {
						readExcel(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNhapFile.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNhapFile.setBounds(1099, 267, 158, 35);
		panel.add(btnNhapFile);
    try {
		loadSach();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

	
private boolean ktraTTSach(String tenSach,String donGia ,String tenLoaiSach,String soLuong,String soLuongDaBan) {
		
		if(!(tenSach.length()>0 && tenSach.matches("[a-zA-Z' ]+"))) {
			thongBao("Error: Tên sách theo định dạng [a-zA-Z' ]+", txtTenSach);
			return false;
		}
		if(!(tenLoaiSach.length()>0 && tenLoaiSach.matches("[a-zA-Z' ]+"))) {
			thongBao("Error: Loại sách theo định dạng [a-zA-Z' ]+", txtLoaiSach);
			return false;
		}
		if(!(soLuong.length()>0 && soLuong.matches("[0-9]+"))) {
			thongBao("Error: Số lượng phải là số", txtSoLuong);
			return false;
		}
		if(!(donGia.length()>0 && donGia.matches("[0-9]+"))) {
			thongBao("Error: Đơn giá phải là số", txtDonGia);
			return false;
		}
		if(!(soLuongDaBan.length()>0&&Integer.parseInt(soLuongDaBan)< Integer.parseInt(soLuong) && (soLuongDaBan.matches("[0-9]+") ))) {
			thongBao("Error: Số lượng đã bán phải là số và phải nhỏ hơn số lượng", txtSoLuongDaBan);
			return false;
		}
		return true;
	}
public void thongBao(String er , JTextField txt) {
	JOptionPane.showMessageDialog(null, er);
//	txt.selectAll();
//	txt.requestFocus();
}
public void loadSach() throws SQLException {
	
		while (table.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
	ArrayList<Sach> dsSach = sach_DAO.getAllSach();
	for (Sach k : dsSach) {
		tableModel.addRow(new Object[] {k.getMaSach(),k.getNhaXB(),k.getTacGia(),k.getTenSach().trim(),k.getDonGia(),k.getTenLoaiSach().trim(),k.getSoLuong(),k.getSoLuongDaBan()});
		
	
	}
	
}
public void mouseClicked(MouseEvent e) {
	int row =table.getSelectedRow();	
	maSachHientai= table.getValueAt(row, 0).toString().trim();
	txtTenSach.setText( table.getValueAt(row, 3).toString().trim());
	txtDonGia.setText( table.getValueAt(row, 4).toString().trim());
	txtLoaiSach.setText( table.getValueAt(row, 5).toString().trim());
	txtSoLuong.setText( table.getValueAt(row, 6).toString().trim());
	txtSoLuongDaBan.setText( table.getValueAt(row, 7).toString().trim());
}
public static void readExcel(File fileInput) throws IOException {
	
	FileInputStream file = new FileInputStream(fileInput);
	XSSFWorkbook wb = new XSSFWorkbook(file); //chuyen file sang dinh dang excel
	XSSFSheet sheet = wb.getSheetAt(0); //Đọc từ sheet 1
	FormulaEvaluator fml = wb.getCreationHelper().createFormulaEvaluator();
	int i = 0;
	

//	   tenSach=txtTenSach.getText();
//       donGia=txtDonGia.getText();
//       tenLoaiSach=txtLoaiSach.getText();
//       soLuong=txtSoLuong.getText();
//       soLuongDaBan=txtSoLuongDaBan.getText();
//		 maTacGia=comboBoxTacGia.getSelectedItem()+"";
//			 maNXB=comboBoxNXB.getSelectedItem()+"";
	for(Row row : sheet) {
		for(Cell cell : row ) {
			if(i==0) {
				if(cell.getCellType()==CellType.STRING) {
//					System.out.println(cell.getCellType()+"1");
					maNXB =  cell.getStringCellValue();
				}
//				System.out.println(i);
				i++;
			}
			
			else if(i==1) {
				if(cell.getCellType()==CellType.STRING) {
//					System.out.println(cell.getCellType()+"2");
					maTacGia =  cell.getStringCellValue();
				}
//				System.out.println(i);
				i ++;
			}
			else if(i==2) {
				if(cell.getCellType()==CellType.STRING) {
//					System.out.println(cell.getCellType()+"3");
					tenSach =  cell.getStringCellValue();
				}
//				System.out.println(i);
				i++;
			}
			else if(i==3) {
				if(cell.getCellType()==CellType.NUMERIC) {
//					System.out.println(cell.getCellType()+"4");
					donGia =  cell.getNumericCellValue()+"";
				}
//				System.out.println(i);
				i++;
			}
			else if(i==4) {
				if(cell.getCellType()==CellType.STRING) {
//					System.out.println(cell.getCellType()+"5");
					tenLoaiSach =  cell.getStringCellValue();
				}
//				System.out.println(i);
				i++;
			}
			else if(i==5) {
				if(cell.getCellType()==CellType.NUMERIC) {
//					System.out.println(cell.getCellType()+"6");
					soLuong = cell.getNumericCellValue()+"" ;
				}
//				System.out.println(i);
				i++;
			}
			else if(i==6) {
				if(cell.getCellType()==CellType.NUMERIC) {
//					System.out.println(cell.getCellType()+"7");
					soLuongDaBan =  cell.getNumericCellValue()+"";
				}
//				System.out.println(i);
				i=0;
			}
			
		}
		System.out.println(maNXB+"-"+maTacGia+"-"+tenSach+"-"+donGia+"-"+tenLoaiSach+"-"+soLuong+"-"+soLuongDaBan);
		
		
	}
	
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

