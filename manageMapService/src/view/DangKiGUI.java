package view;

import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import control.KhachHangHelper;
import control.TaiKhoanHelper;
import model.KhachHang;

/**
 *
 * @author vanth
 */
public class DangKiGUI extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form DangKiGUI
     */
    public DangKiGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Phần mềm quản lý quán cà phê");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTieuDe = new javax.swing.JLabel();
        lblTenDangNhap = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblNhapLaiMatKhau = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblHo = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnDangKi = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();
        txtNhapLaiMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTieuDe.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblTieuDe.setText("Đăng Kí Tài Khoản");

        lblTenDangNhap.setText("Tên đăng nhập   : ");

        lblMatKhau.setText("Mật Khẩu              :");

        lblNhapLaiMatKhau.setText("Nhập lại               :");

        lblEmail.setText("Email                    :");

        lblHo.setText("Họ tên:                  :");

        lblTen.setText("Số điện thoại       :");

        lblDiaChi.setText("Địa chỉ                  :");

        btnDangKi.setText("Đăng kí");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatKhau)
                            .addComponent(lblTenDangNhap)
                            .addComponent(lblNhapLaiMatKhau)
                            .addComponent(lblEmail)
                            .addComponent(lblHo)
                            .addComponent(lblTen)
                            .addComponent(lblDiaChi)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDangKi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHuyBo))
                            .addComponent(lblTieuDe)
                            .addComponent(txtTenDangNhap)
                            .addComponent(txtEmail)
                            .addComponent(txtHoTen)
                            .addComponent(txtSoDienThoai)
                            .addComponent(txtDiaChi)
                            .addComponent(txtMatKhau)
                            .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTieuDe)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenDangNhap)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMatKhau)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNhapLaiMatKhau)
                    .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHo)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTen)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKi)
                    .addComponent(btnHuyBo))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

	private String createRandomRegistryId(String handleId)
	{     
	    String val = "KH";      
	    Random r = new Random();
	    int numbers = 100000 + (int)(r.nextFloat() * 899900);
	    val += String.valueOf(numbers);
	    return val;
	}
    
	protected boolean kiemTraRong(String chuoi) {
		if(chuoi.equals("")) 
			return false;
		return true;
	}
	
    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String tenDangNhap = txtTenDangNhap.getText().toString();
        String matKhau = new String(txtMatKhau.getPassword());
        String nhapLaiMatKhau = new String(txtNhapLaiMatKhau.getPassword());
        String email = txtEmail.getText().toString();
        String hoTen = txtHoTen.getText().toString();
        String soDienThoai = txtSoDienThoai.getText().toString();
        String diaChi = txtDiaChi.getText().toString();
        //System.out.println(kiemTraRong(tenDangNhap));
        
        //Kiểm tra tài text field có bị rỗng hay không
        if(kiemTraRong(tenDangNhap) && kiemTraRong(matKhau) 
        		&& kiemTraRong(nhapLaiMatKhau) && kiemTraRong(email)
        		&& kiemTraRong(hoTen) && kiemTraRong(soDienThoai)
        		&& kiemTraRong(diaChi)) {
        	//Trường hợp không rỗng
        	TaiKhoanHelper tk = new TaiKhoanHelper();
            try {
            	if(matKhau.equals(nhapLaiMatKhau))
            		if(!tk.dangKiTaiKhoan(tenDangNhap, matKhau, "Khach Hang"))
            		{
            			JOptionPane.showMessageDialog(this,
                                "Tài khoản hoặc mật khẩu đã tồn tại.");
            			System.exit(0);
            		}
            		else {
                    	KhachHangHelper kHangHelper = new KhachHangHelper();
                    	KhachHang kh = new KhachHang(createRandomRegistryId("KH"), hoTen, 
                    			soDienThoai,diaChi, email, tenDangNhap);
                    	kHangHelper.themKhachHang(kh);
                    	JOptionPane.showMessageDialog(this,"Đăng kí thành công.");
                        this.setVisible(false);
                        DangNhapGUI dangNhap = new DangNhapGUI();
                        dangNhap.setVisible(true);
            		}
            	else {
            		JOptionPane.showMessageDialog(this,
                            "Mật khẩu nhập lại không khớp.");
            		return;
            	}
    		} catch (SQLException e) {
    			
    		}
        } else {
        	JOptionPane.showMessageDialog(this,"Không được để kí tự rỗng.");
        }
    }                                         

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	System.exit(0);
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
            java.util.logging.Logger.getLogger(DangKiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNhapLaiMatKhau;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtNhapLaiMatKhau;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration                   
}
