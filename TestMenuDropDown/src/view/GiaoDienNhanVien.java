

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author RavenPC
 */
public class GiaoDienNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
	
    public GiaoDienNhanVien() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        execute();
    }
    public void switchPanel(JPanel panel) {
    	panelBody.removeAll();
    	panelBody.add(panel);
    	panelBody.repaint();
    	panelBody.revalidate();
		
	}
    private void execute() {
    	panelBody.add(new PanelTrangChuKH());
        ImageIcon iconBook = new ImageIcon(getClass().getResource("/img/book-search.png"));
        ImageIcon iconCustomer = new ImageIcon(getClass().getResource("/img/customer-icon.png"));
        ImageIcon iconDatabase = new ImageIcon(getClass().getResource("/img/bill-icon.png"));
        ImageIcon iconThongKe= new ImageIcon(getClass().getResource("/img/main-books-icon.png"));
        ImageIcon iconMainPage = new ImageIcon(getClass().getResource("/img/Help-icon.png"));
        ImageIcon iconMessage = new ImageIcon(getClass().getResource("/img/message.png"));
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/img/subMenu.png"));
        ImageIcon iconNext = new ImageIcon(getClass().getResource("/img/next.png"));
        //  create submenu staff
        
        MenuItem menuTimKiemSach = new MenuItem(iconSubMenu, "Tìm kiếm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            switchPanel(new PanelTimKiem());
            }
        });
        
        MenuItem menuCapNhatSach = new MenuItem(iconSubMenu, "Cập nhật",       new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent ae) {
            	switchPanel(new CapNhatSach() );
              }
          });

        MenuItem menuThemSach = new MenuItem(iconSubMenu, "Thêm ",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          	  panelBody.removeAll();
//                panelBody.add( new Panel1());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        //  create submenu setting message

        MenuItem message1 = new MenuItem(iconNext, "Message 001", null);
        MenuItem message2 = new MenuItem(iconNext, "Message 002", null);
        MenuItem message3 = new MenuItem(iconNext, "Message 003", null);

        //  create submenu setting 
        MenuItem menuTimKiemKH = new MenuItem(iconSubMenu, "Tìm kiếm ",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          	switchPanel(new TimKiemKhachHang());
            }
        });
        
        MenuItem menuCapNhatKH = new MenuItem(iconSubMenu, "Cập nhật",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          	switchPanel(new CapNhatKhachHang());
            }
        });
//        MenuItem menuKhachHang4 = new MenuItem(iconSubMenu, "", null);
        MenuItem tkDoanhThu = new MenuItem(iconNext, "Thống Kê Doanh Thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          	switchPanel(new ThongKeDoanhThu());
            }
        });
 
        MenuItem tkDoanhSo = new MenuItem(iconNext, "Thống Kê Doanh số", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	
            }
        });
        MenuItem hd1 = new MenuItem(iconNext, "Nhập Hóa Đơn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	switchPanel(new NhapHoaDon());
            }
        });
        MenuItem hd2 = new MenuItem(iconNext, "Xuất Hóa Đơn",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	switchPanel(new XuatHoaDon());
            }
        });
        MenuItem trangChu = new MenuItem(iconMainPage, "Trang Chủ",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	switchPanel(new PanelTrangChuKH());
            }
        });
        MenuItem menuSach = new MenuItem(iconBook, "Sách", null, menuTimKiemSach, menuCapNhatSach);
        MenuItem menuKhachHang = new MenuItem(iconCustomer, "Khách Hàng", null, menuTimKiemKH, menuCapNhatKH);
        MenuItem menuHoaDon = new MenuItem(iconDatabase, "Hóa Đơn", null,hd1,hd2);
        MenuItem menuThongKe = new MenuItem(iconThongKe, "Thống Kê", null,tkDoanhThu,tkDoanhSo);
        addMenu(trangChu,menuSach, menuKhachHang, menuHoaDon,menuThongKe);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        panelHeader.setBounds(0, 0, 1919, 86);
        panelMenu = new javax.swing.JPanel();
        panelMenu.setBounds(0, 88, 250, 920);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(0, 0, 250, 920);
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        panelBody.setBounds(250, 88, 1669, 920);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHeader.setBackground(new Color(176, 172, 213));
        panelHeader.setPreferredSize(new java.awt.Dimension(561, 50));
        
        JLabel lblNewLabel = new JLabel("Chào Mừng Đến Với Hiệu Sách NKT");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        JLabel lblIconHeader = new JLabel("");
        ImageIcon iconHeader = new ImageIcon(getClass().getResource("/img/Books-2-icon.png"));
        getContentPane().setLayout(null);
        lblIconHeader.setIcon(iconHeader);

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeaderLayout.setHorizontalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addGap(274)
        			.addComponent(lblIconHeader, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        			.addGap(320)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(751, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addGroup(panelHeaderLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelHeaderLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblIconHeader, GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE))
        				.addGroup(panelHeaderLayout.createSequentialGroup()
        					.addGap(28)
        				
        					.addComponent(lblNewLabel)))
        			.addContainerGap())
        );
        panelHeader.setLayout(panelHeaderLayout);

        getContentPane().add(panelHeader);

        panelMenu.setBackground(new java.awt.Color(115, 120, 230));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(255, 255, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        getContentPane().add(panelMenu);
        panelMenu.setLayout(null);
        panelMenu.add(jScrollPane1);

        panelBody.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(panelBody);
        panelBody.setLayout(new BoxLayout(panelBody, BoxLayout.X_AXIS));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
}
