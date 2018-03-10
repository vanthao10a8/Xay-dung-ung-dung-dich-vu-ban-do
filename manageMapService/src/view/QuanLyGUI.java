package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.NhanVienHelper;
import control.TaiKhoanHelper;
import model.NhanVien;

/**
 *
 * @author vanth
 */
public class QuanLyGUI extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form QuanLyGUI
     */
    public QuanLyGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
                         
    private void initComponents() {

        pnQuanLy = new javax.swing.JPanel();
        lblTiltle = new javax.swing.JLabel();
        lblChucNangQuanLy = new javax.swing.JLabel();
        btnTaoTaiKhoanNV = new javax.swing.JButton();
        btnXoaTaiKhoanNV = new javax.swing.JButton();
        btnSuaThongTinNV = new javax.swing.JButton();
        btnThemDoUong = new javax.swing.JButton();
        btnXoaDoUong = new javax.swing.JButton();
        btnSuaThongTinDU = new javax.swing.JButton();
        btnXuatLuongNV = new javax.swing.JButton();
        btnXuatDoanhThu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTiltle.setBackground(new java.awt.Color(102, 255, 0));
        lblTiltle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        lblTiltle.setText("Coffee FISH & GO");

        lblChucNangQuanLy.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lblChucNangQuanLy.setText("Chức năng quản lý");

        btnTaoTaiKhoanNV.setText("Tạo tài khoản nhân viên");
        btnTaoTaiKhoanNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTaiKhoanNVActionPerformed(evt);
            }
        });

        btnXoaTaiKhoanNV.setText("Xóa tài khoản nhân viên");
        btnXoaTaiKhoanNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTaiKhoanNVActionPerformed(evt);
            }
        });

        btnSuaThongTinNV.setText("Sửa thông tin nhân viên");
        btnSuaThongTinNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinNVActionPerformed(evt);
            }
        });

        btnThemDoUong.setText("Thêm đồ uống");
        btnThemDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDoUongActionPerformed(evt);
            }
        });

        btnXoaDoUong.setText("Xóa đồ uống");
        btnXoaDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDoUongActionPerformed(evt);
            }
        });

        btnSuaThongTinDU.setText("Sửa thông tin đồ uống");
        btnSuaThongTinDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinDUActionPerformed(evt);
            }
        });

        btnXuatLuongNV.setText("Xuất lương nhân viên");
        btnXuatLuongNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatLuongNVActionPerformed(evt);
            }
        });

        btnXuatDoanhThu.setText("Xuất doanh thu");
        btnXuatDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDoanhThuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Nhân viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Thực đơn");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Cửa hàng");

        javax.swing.GroupLayout pnQuanLyLayout = new javax.swing.GroupLayout(pnQuanLy);
        pnQuanLy.setLayout(pnQuanLyLayout);
        pnQuanLyLayout.setHorizontalGroup(
            pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnQuanLyLayout.createSequentialGroup()
                        .addComponent(btnTaoTaiKhoanNV)
                        .addGap(26, 26, 26)
                        .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSuaThongTinDU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXuatDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuatLuongNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQuanLyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnQuanLyLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblChucNangQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123))))
            .addGroup(pnQuanLyLayout.createSequentialGroup()
                .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnQuanLyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSuaThongTinNV))
                    .addGroup(pnQuanLyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXoaTaiKhoanNV))
                    .addGroup(pnQuanLyLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnQuanLyLayout.setVerticalGroup(
            pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyLayout.createSequentialGroup()
                .addComponent(lblTiltle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChucNangQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoTaiKhoanNV)
                    .addComponent(btnThemDoUong)
                    .addComponent(btnXuatLuongNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThongTinNV)
                    .addComponent(btnXoaDoUong)
                    .addComponent(btnXuatDoanhThu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaTaiKhoanNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThongTinDU))
                .addGap(0, 168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnTaoTaiKhoanNVActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        TaoTaiKhoanNVGUI tkt = new TaoTaiKhoanNVGUI();
        this.setVisible(false);
        tkt.setVisible(true);
    }                                                

    private void btnXoaTaiKhoanNVActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	String maNV = JOptionPane.showInputDialog("Nhập mã số nhân viên cần xóa tài khoản");
    	NhanVienHelper nvh = new NhanVienHelper();
    	ArrayList<NhanVien> lsNV = nvh.layTatCaNhanVien();
    	TaiKhoanHelper tkh = new TaiKhoanHelper();
    	for (NhanVien nhanVien : lsNV) {
    		System.out.println(maNV + " : " + nhanVien.getMaSoNV());
			if(nhanVien.getMaSoNV().equals(maNV))
			{
				try {
					nvh.xoaNhanVien(maNV);
					tkh.xoaTaiKhoan(maNV);
					JOptionPane.showMessageDialog(this, "Xóa thành công");
					return;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    	JOptionPane.showMessageDialog(this, "Không có nhân viên này");
    }                                                

    private void btnSuaThongTinNVActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	String maNV = JOptionPane.showInputDialog("Nhập mã số nhân viên cần sửa thông tin");
    	NhanVienHelper nvh = new NhanVienHelper();
    	ArrayList<NhanVien> lsNV = nvh.layTatCaNhanVien();
    	for (NhanVien nhanVien : lsNV) {
			if(nhanVien.getMaSoNV().equals(maNV))
			{
				TaoTaiKhoanNVGUI tkt = new TaoTaiKhoanNVGUI(maNV);
		    	this.setVisible(false);
		    	tkt.setVisible(true);
		    	return;
			}
		}
    	JOptionPane.showMessageDialog(this, "Không có nhân viên này");
    }                                                

    private void btnThemDoUongActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnXoaDoUongActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void btnSuaThongTinDUActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void btnXuatLuongNVActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void btnXuatDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

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
            java.util.logging.Logger.getLogger(QuanLyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSuaThongTinDU;
    private javax.swing.JButton btnSuaThongTinNV;
    private javax.swing.JButton btnTaoTaiKhoanNV;
    private javax.swing.JButton btnThemDoUong;
    private javax.swing.JButton btnXoaDoUong;
    private javax.swing.JButton btnXoaTaiKhoanNV;
    private javax.swing.JButton btnXuatDoanhThu;
    private javax.swing.JButton btnXuatLuongNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblChucNangQuanLy;
    private javax.swing.JLabel lblTiltle;
    private javax.swing.JPanel pnQuanLy;
    // End of variables declaration                   
}