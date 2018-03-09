package view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import control.DoUongHelper;
import model.DoUong;

/**
 *
 * @author vanth
 */
public class NhanVienGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form NhanVienGUI
	 * @throws Exception 
	 */
	public NhanVienGUI() throws Exception {
		initComponents();
		this.setLocationRelativeTo(null);
	}                
	private void initComponents() throws Exception {

		lblTieuDe = new javax.swing.JLabel();
		tabNhanVien = new javax.swing.JTabbedPane();
		pnBanHang = new javax.swing.JPanel();
		btnXuatHoaDon = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableDanhMuc = new javax.swing.JTable();
		jLabel5 = new javax.swing.JLabel();
		btnThem = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();
		btnSua = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		tableDaChon = new javax.swing.JTable();
		pnDatBan = new javax.swing.JPanel();
		canvas1 = new java.awt.Canvas();
		btnDatBan = new javax.swing.JButton();
		btnHuyDatBan = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		pnCaNhan = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		txtHoTenNV = new javax.swing.JTextField();
		txtGioiTinhNV = new javax.swing.JTextField();
		txtNgaySinhNV = new javax.swing.JTextField();
		txtDiaChiNV = new javax.swing.JTextField();
		lblSoNgayLamNV = new javax.swing.JLabel();
		lblMucLuongNV = new javax.swing.JLabel();
		lblChucVuNV = new javax.swing.JLabel();
		lblMaSoNV = new javax.swing.JLabel();
		btnChinhSuaNV = new javax.swing.JButton();
		btnTinhLuongNV = new javax.swing.JButton();
		lblThongBao = new javax.swing.JLabel();
		btnThoatRa = new javax.swing.JButton();
		//canvas1.setForeground(new java.awt.Color(0, 0, 255));
		canvas1.setBackground(Color.GRAY);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblTieuDe.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
		lblTieuDe.setText("Coffee FUCK && GO");

		btnXuatHoaDon.setText("Xuất hóa đơn");
		btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXuatHoaDonActionPerformed(evt);
			}
		});

		tableDanhMuc.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		String[] col = new String [] {
				"Mã đồ uống", "Tên đồ uống", "Loại đồ uống", "Giá đồ uống"
		};
		tableDataDanhMuc = new DefaultTableModel(col,0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tableDanhMuc.setModel(tableDataDanhMuc);
		DoUongHelper doUongHelper = new DoUongHelper();
		ArrayList<DoUong> lsDoUong = (ArrayList<DoUong>) doUongHelper.layDanhSachDoUong();
		for (DoUong doUong : lsDoUong) {
			String maDoUong = doUong.getMaDoUong();
			String tenDoUong = doUong.getTenDoUong();
			String loaiDoUong = doUong.getLoaiDoUong();
			double giaDoUong = doUong.getGiaDoUong();
			Object[] rowData = {maDoUong,tenDoUong,loaiDoUong,giaDoUong};
			tableDataDanhMuc.addRow(rowData);
		}
		tableDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(evt.getClickCount() == 2) {
					int row = tableDanhMuc.rowAtPoint(evt.getPoint());
					//int col = tableDanhMuc.columnAtPoint(evt.getPoint());
					double donGia = (double)tableDataDanhMuc.getValueAt(row, 4);
					String tenDoUong = (String)tableDataDanhMuc.getValueAt(row, 2);
					int soLuong = 0;
					double thanhTien = 0;
					
					if (row >= 0) {
						Object[] data = {tenDoUong,
								donGia,
								soLuong,
								thanhTien};
						tableDataBill.addRow(data);
					}
				}
			}
		});

		/*tableDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã đồ uống", "Tên đồ uống", "Loại đồ uống", "Giá đồ uống"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });*/
		jScrollPane1.setViewportView(tableDanhMuc);
		if (tableDanhMuc.getColumnModel().getColumnCount() > 0) {
			tableDanhMuc.getColumnModel().getColumn(0).setResizable(false);
			tableDanhMuc.getColumnModel().getColumn(1).setResizable(false);
			tableDanhMuc.getColumnModel().getColumn(2).setResizable(false);
			tableDanhMuc.getColumnModel().getColumn(3).setResizable(false);
		}

		jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel5.setText("Các món đã chọn");

		btnThem.setText("Thêm ");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});

		btnSua.setText("Sửa");
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});

		/* tableDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên đồ uống", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });*/

		String[] col2 = new String [] {
				"Tên đồ uống", "Đơn giá", "Số lượng", "Thành tiền"
		};
		tableDataBill = new DefaultTableModel(col2, 0);
		tableDaChon.setModel(tableDataBill);



		jScrollPane2.setViewportView(tableDaChon);
		if (tableDaChon.getColumnModel().getColumnCount() > 0) {
			tableDaChon.getColumnModel().getColumn(0).setResizable(false);
			tableDaChon.getColumnModel().getColumn(1).setResizable(false);
			tableDaChon.getColumnModel().getColumn(2).setResizable(false);
			tableDaChon.getColumnModel().getColumn(3).setResizable(false);
		}

		javax.swing.GroupLayout pnBanHangLayout = new javax.swing.GroupLayout(pnBanHang);
		pnBanHang.setLayout(pnBanHangLayout);
		pnBanHangLayout.setHorizontalGroup(
				pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBanHangLayout.createSequentialGroup()
						.addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnBanHangLayout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(pnBanHangLayout.createSequentialGroup()
														.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnXuatHoaDon))
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(pnBanHangLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(54, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBanHangLayout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(jLabel5)
						.addGap(199, 199, 199))
				);
		pnBanHangLayout.setVerticalGroup(
				pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBanHangLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThem)
								.addComponent(btnXoa)
								.addComponent(btnSua)
								.addComponent(btnXuatHoaDon))
						.addContainerGap(40, Short.MAX_VALUE))
				);

		tabNhanVien.addTab("Bán hàng", pnBanHang);

		btnDatBan.setText("Đặt Bàn");

		btnHuyDatBan.setText("Hủy Đặt Bàn");

		jButton3.setText("Xen Thông Tin Đặt Bàn");

		javax.swing.GroupLayout pnDatBanLayout = new javax.swing.GroupLayout(pnDatBan);
		pnDatBan.setLayout(pnDatBanLayout);
		pnDatBanLayout.setHorizontalGroup(
				pnDatBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnDatBanLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnDatBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pnDatBanLayout.createSequentialGroup()
										.addComponent(btnDatBan)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnHuyDatBan)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton3)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				);
		pnDatBanLayout.setVerticalGroup(
				pnDatBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnDatBanLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnDatBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnDatBan)
								.addComponent(btnHuyDatBan)
								.addComponent(jButton3))
						.addGap(42, 42, 42))
				);

		tabNhanVien.addTab("Đặt bàn", pnDatBan);

		jLabel6.setText("Mã số nhân viên : ");

		jLabel7.setText("Họ và tên           :");

		jLabel8.setText("Giới tính              :");

		jLabel9.setText("Ngày sinh           :");

		jLabel10.setText("Địa chỉ                :");

		jLabel11.setText("Chức vụ             :");

		jLabel12.setText(" Mức lương         :");

		jLabel13.setText("Số ngày làm       :");

		txtHoTenNV.setEditable(false);
		txtHoTenNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtHoTenNVActionPerformed(evt);
			}
		});

		txtGioiTinhNV.setEditable(false);

		txtNgaySinhNV.setEditable(false);

		txtDiaChiNV.setEditable(false);

		lblSoNgayLamNV.setText("Số ngày làm");

		lblMucLuongNV.setText("Mức lương");

		lblChucVuNV.setText("Chức vụ");

		lblMaSoNV.setText("Mã số nhân viên");

		btnChinhSuaNV.setText("Chỉnh sửa");
		btnChinhSuaNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChinhSuaNVActionPerformed(evt);
			}
		});

		btnTinhLuongNV.setText("Tính lương");
		btnTinhLuongNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTinhLuongNVActionPerformed(evt);
			}
		});

		lblThongBao.setForeground(new java.awt.Color(255, 0, 0));
		lblThongBao.setText("Tin nhắn từ hệ thống: ");

		btnThoatRa.setText("Thoát ra");
		btnThoatRa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThoatRaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnCaNhanLayout = new javax.swing.GroupLayout(pnCaNhan);
		pnCaNhan.setLayout(pnCaNhanLayout);
		pnCaNhanLayout.setHorizontalGroup(
				pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCaNhanLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pnCaNhanLayout.createSequentialGroup()
										.addComponent(btnChinhSuaNV)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtHoTenNV)
								.addComponent(txtGioiTinhNV)
								.addComponent(txtNgaySinhNV)
								.addComponent(txtDiaChiNV)
								.addComponent(lblMucLuongNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblChucVuNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMaSoNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pnCaNhanLayout.createSequentialGroup()
										.addComponent(lblSoNgayLamNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(108, 108, 108))
								.addGroup(pnCaNhanLayout.createSequentialGroup()
										.addComponent(btnTinhLuongNV)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnThoatRa)))
						.addGap(161, 161, 161))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCaNhanLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblThongBao)
						.addGap(191, 191, 191))
				);
		pnCaNhanLayout.setVerticalGroup(
				pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnCaNhanLayout.createSequentialGroup()
						.addGap(22, 22, 22)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(lblMaSoNV))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7)
								.addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel8)
								.addComponent(txtGioiTinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9)
								.addComponent(txtNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10)
								.addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblChucVuNV)
								.addComponent(jLabel11))
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnCaNhanLayout.createSequentialGroup()
										.addGap(7, 7, 7)
										.addComponent(lblMucLuongNV))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCaNhanLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel12)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblSoNgayLamNV)
								.addComponent(jLabel13))
						.addGap(16, 16, 16)
						.addComponent(lblThongBao)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnChinhSuaNV)
								.addComponent(btnTinhLuongNV)
								.addComponent(btnThoatRa))
						.addContainerGap(97, Short.MAX_VALUE))
				);

		tabNhanVien.addTab("Cá nhân", pnCaNhan);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(tabNhanVien)
				.addGroup(layout.createSequentialGroup()
						.addGap(120, 120, 120)
						.addComponent(lblTieuDe)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(lblTieuDe)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tabNhanVien))
				);

		pack();
	}                      

	private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {                                              
		// TODO add your handling code here:
	}                                             

	private void txtHoTenNVActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
	}                                          

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                        
		// TODO add your handling code here:
	}                                       

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {                                       
		// TODO add your handling code here:
	}                                      

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {                                       
		// TODO add your handling code here:
	}                                      

	private void btnChinhSuaNVActionPerformed(java.awt.event.ActionEvent evt) {                                              
		// TODO add your handling code here:
	}                                             

	private void btnTinhLuongNVActionPerformed(java.awt.event.ActionEvent evt) {                                               
		// TODO add your handling code here:
	}                                              

	private void btnThoatRaActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
			java.util.logging.Logger.getLogger(NhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(NhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(NhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(NhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new NhanVienGUI().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton btnChinhSuaNV;
	private javax.swing.JButton btnDatBan;
	private javax.swing.JButton btnHuyDatBan;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnThoatRa;
	private javax.swing.JButton btnTinhLuongNV;
	private javax.swing.JButton btnXoa;
	private javax.swing.JButton btnXuatHoaDon;
	private java.awt.Canvas canvas1;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblChucVuNV;
	private javax.swing.JLabel lblMaSoNV;
	private javax.swing.JLabel lblMucLuongNV;
	private javax.swing.JLabel lblSoNgayLamNV;
	private javax.swing.JLabel lblThongBao;
	private javax.swing.JLabel lblTieuDe;
	private javax.swing.JPanel pnBanHang;
	private javax.swing.JPanel pnCaNhan;
	private javax.swing.JPanel pnDatBan;
	private javax.swing.JTabbedPane tabNhanVien;
	private javax.swing.JTable tableDaChon;
	private javax.swing.JTable tableDanhMuc;
	private javax.swing.JTextField txtDiaChiNV;
	private javax.swing.JTextField txtGioiTinhNV;
	private javax.swing.JTextField txtHoTenNV;
	private javax.swing.JTextField txtNgaySinhNV;
	private DefaultTableModel tableDataDanhMuc;
	private DefaultTableModel tableDataBill;
	// End of variables declaration                   
}