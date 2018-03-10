package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import control.NhanVienHelper;
import control.TaiKhoanHelper;
import model.NhanVien;

/**
 *
 * @author vanth
 */
public class TaoTaiKhoanNVGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maNV;
    /**
     * Creates new form TaoTaiKhoanNVGUI
     */
    public TaoTaiKhoanNVGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    public TaoTaiKhoanNVGUI(String maNV) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.maNV = maNV;
    }
                       
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        lblMucLuong = new javax.swing.JLabel();
        lblSoNgaySinh = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtMucLuong = new javax.swing.JTextField();
        txtNgayLam = new javax.swing.JTextField();
        btnTaoTK = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        cbxChucVu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setText("TẠO TÀI KHOẢN NHÂN VIÊN");

        lblHoTen.setText("Họ và tên");

        lblNgaySinh.setText("Ngày Sinh");

        lblDiaChi.setText("Địa chỉ ");

        lblGioiTinh.setText("Giới tính ");

        lblChucVu.setText("Chức vụ");

        lblMucLuong.setText("Mức lương ");

        lblSoNgaySinh.setText("Ngày bắt đầu làm");

        rdNam.setText("Nam");
    /*    rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });*/

        rdNu.setText("Nữ");
       /* rdNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNuActionPerformed(evt);
            }
        });*/

        btnTaoTK.setText("Tạo Tài Khoản");
        btnTaoTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTKActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        cbxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhan Vien", "Quan Ly", "Khach Hang" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMucLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnTaoTK)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                            .addComponent(btnQuayLai))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rdNam)
                            .addGap(34, 34, 34)
                            .addComponent(rdNu))
                        .addComponent(txtNgaySinh)
                        .addComponent(txtNgayLam)
                        .addComponent(txtMucLuong)
                        .addComponent(txtDiaChi)
                        .addComponent(txtHoTen))
                    .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHoTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgaySinh)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiTinh)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChucVu)
                    .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMucLuong)
                    .addComponent(txtMucLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoNgaySinh)
                    .addComponent(txtNgayLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoTK)
                    .addComponent(btnQuayLai))
                .addGap(0, 128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnTaoTKActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	if(txtHoTen.getText().isEmpty() 
    			|| txtDiaChi.getText().isEmpty() || txtMucLuong.getText().isEmpty() ||
    			txtNgaySinh.getText().isEmpty()
    			)
    		JOptionPane.showMessageDialog(this, "Không được để rỗng!");
    	else {
    	if(this.maNV != null) {
    		NhanVienHelper nvh = new NhanVienHelper();
        	TaiKhoanHelper tkh = new TaiKhoanHelper();
            String hoTen = txtHoTen.getText().toString();
            String ngaySinh = txtNgaySinh.getText().toString();
            String diaChi = txtDiaChi.getText().toString();
            String gioiTinh = "Nam";
            if(!rdNam.isSelected() && rdNu.isSelected()) gioiTinh = "Nữ";
            String chucVu = cbxChucVu.getSelectedItem().toString();
            double mucLuong = Double.parseDouble(txtMucLuong.getText().toString());
            int soNgayLam = Integer.parseInt(txtNgayLam.getText().toString());
            int num = nvh.layTatCaNhanVien().size();
            //System.out.println(num);
            String user = "nhanvien" + num++;
            String password = "123456";
            try {
    			tkh.dangKiTaiKhoan(user, password, chucVu);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
           // NhanVien nv = new NhanVien(user, hoTen, gioiTinh, ngaySinh, diaChi, chucVu, mucLuong, soNgayLam);
            nvh.capNhatNhanVien(this.maNV,hoTen , ngaySinh, gioiTinh, diaChi, chucVu, mucLuong, soNgayLam);
            JOptionPane.showMessageDialog(this, "Thay đổi thành công!");
    	}else {
    		NhanVienHelper nvh = new NhanVienHelper();
        	TaiKhoanHelper tkh = new TaiKhoanHelper();
            String hoTen = txtHoTen.getText().toString();
            String ngaySinh = txtNgaySinh.getText().toString();
            String diaChi = txtDiaChi.getText().toString();
            String gioiTinh = "Nam";
            if(!rdNam.isSelected() && rdNu.isSelected()) gioiTinh = "Nữ";
            String chucVu = cbxChucVu.getSelectedItem().toString();
            double mucLuong = Double.parseDouble(txtMucLuong.getText().toString());
            int soNgayLam = Integer.parseInt(txtNgayLam.getText().toString());
            int num = nvh.layTatCaNhanVien().size();
            System.out.println(num);
            String user = "nhanvien" + num++;
            String password = "123456";
            try {
    			tkh.dangKiTaiKhoan(user, password, chucVu);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
            NhanVien nv = new NhanVien(user, hoTen, gioiTinh, ngaySinh, diaChi, chucVu, mucLuong, soNgayLam);
            try {
				nvh.themNhanVien(nv);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            JOptionPane.showMessageDialog(this, "Thêm thành công!\nUserName: "
            		+user + "\nPassword: " + password);
            this.setVisible(false);
            QuanLyGUI ql = new QuanLyGUI();
            ql.setVisible(true);
    	}
    	}
    }                                        

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	this.setVisible(false);
        QuanLyGUI ql = new QuanLyGUI();
        ql.setVisible(true);
    }                                          

/*    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void rdNuActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    
*/
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
            java.util.logging.Logger.getLogger(TaoTaiKhoanNVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanNVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanNVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanNVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoTaiKhoanNVGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnTaoTK;
    private javax.swing.JComboBox<String> cbxChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMucLuong;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoNgaySinh;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMucLuong;
    private javax.swing.JTextField txtNgayLam;
    private javax.swing.JTextField txtNgaySinh;
    // End of variables declaration                   
}