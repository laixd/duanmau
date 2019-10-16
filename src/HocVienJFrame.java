
import dao.HocVienDAO;
import dao.NguoiHocDAO;
import helper.DialogHelper;
import helper.JdbcHelper1;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.HocVien;
import model.NguoiHoc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DMX
 */
public class HocVienJFrame extends javax.swing.JFrame {

    public Integer MaKH;
    HocVienDAO dao = new HocVienDAO();
    NguoiHocDAO nhdao = new NguoiHocDAO();

    /**
     * Creates new form HocVienJFrame
     */
    public HocVienJFrame(Integer MaKH) {
        initComponents();
        setLocationRelativeTo(null);
        img();
        this.MaKH = MaKH;
    }

    public boolean a = false;

    void checkDiem() {
        try {
            Double diem = Double.parseDouble(txtDiem.getText());
            if (diem < -1 || diem > 10) {
                a = false;
                DialogHelper.alert(this, "Điểm phải nằm trong khoảng từ -1 đến 10 " + "\n" + "Vui lòng nhập lại !");
            } else {
                a = true;
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Vui lòng nhập điểm !");
        }

    }

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboTen.getModel();
        model.removeAllElements();
        try {
            List<NguoiHoc> list = nhdao.selectByCourse(MaKH);
            for (NguoiHoc nh : list) {
                model.addElement(nh);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn học viên!");
        }
    }

    void fillGridView() {
        DefaultTableModel model = (DefaultTableModel) tblView.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT hv.*, nh.HoTen FROM HocVien hv "
                    + " JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH WHERE MaKH=?";
            ResultSet rs = JdbcHelper1.executeQuery(sql, MaKH);
            System.out.println(MaKH);
            while (rs.next()) {
                double diem = rs.getDouble("Diem");
                Object[] row = {
                    rs.getInt("MaHV"), rs.getString("MaNH"),
                    rs.getString("HoTen"), diem, false
                };
                if (rdoTatCa.isSelected()) {
                    model.addRow(row);
                } else if (rdoDaNhapDiem.isSelected() && diem >= 0) {
                    model.addRow(row);
                } else if (rdoChuaNhapDiem.isSelected() && diem < 0) {
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            DialogHelper.alert(this, "Lỗi truy vấn học viên!");
        }
    }

    void insert() {
        NguoiHoc nguoiHoc = (NguoiHoc) cboTen.getSelectedItem();
        HocVien model = new HocVien();
        model.setMaKH(MaKH);
        model.setMaNH(nguoiHoc.getMaNH());
        model.setDiem(Double.valueOf(txtDiem.getText()));
        try {
            dao.insert(model);
            this.fillComboBox();
            this.fillGridView();
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi thêm học viên vào khóa học!");
        }
    }

    void update() {
        try {
            for (int i = 0; i < tblView.getRowCount(); i++) {
                Integer mahv = (Integer) tblView.getValueAt(i, 0);
                String manh = (String) tblView.getValueAt(i, 1);
                String diemm = String.valueOf(tblView.getValueAt(i, 3));
                double diem = Double.parseDouble(diemm);
                Boolean isDelete = (Boolean) tblView.getValueAt(i, 4);
                if (isDelete) {
                    dao.delete(mahv);
                } else {
                    HocVien model = new HocVien();
                    model.setMaHV(mahv);
                    model.setMaKH(MaKH);
                    model.setMaNH(manh);
                    model.setDiem(diem);
                    dao.update(model);
                }
            }
            this.fillComboBox();
            this.fillGridView();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtDiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        cboTen = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaNhapDiem = new javax.swing.JRadioButton();
        rdoChuaNhapDiem = new javax.swing.JRadioButton();
        btnCapNhat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ HỌC VIÊN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("HỌC VIÊN KHÁC");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cboTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboTen, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(cboTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ HV", "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM ", "XÓA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblView);

        buttonGroup2.add(rdoTatCa);
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDaNhapDiem);
        rdoDaNhapDiem.setText("Đã nhập điểm");
        rdoDaNhapDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaNhapDiemActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoChuaNhapDiem);
        rdoChuaNhapDiem.setText("Chưa nhập điểm");
        rdoChuaNhapDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaNhapDiemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(rdoTatCa)
                .addGap(10, 10, 10)
                .addComponent(rdoDaNhapDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoChuaNhapDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoDaNhapDiem)
                    .addComponent(rdoChuaNhapDiem)
                    .addComponent(btnCapNhat))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("HỌC VIÊN TRONG CỦA KHÓA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 457, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // 
        this.fillComboBox();
        this.fillGridView();
    }//GEN-LAST:event_formWindowOpened

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // 
        this.checkDiem();
        if (a == true) {
            this.insert();
        } else {
            DialogHelper.alert(this, "Thêm mới thất bại !");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        //
        this.fillGridView();
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDaNhapDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaNhapDiemActionPerformed
        // 
        this.fillGridView();
    }//GEN-LAST:event_rdoDaNhapDiemActionPerformed

    private void rdoChuaNhapDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaNhapDiemActionPerformed
        // 
        this.fillGridView();
    }//GEN-LAST:event_rdoChuaNhapDiemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // 
//        this.checkDiem();

        this.update();

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void cboTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenActionPerformed

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
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HocVienJFrame(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoChuaNhapDiem;
    private javax.swing.JRadioButton rdoDaNhapDiem;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblView;
    private javax.swing.JTextField txtDiem;
    // End of variables declaration//GEN-END:variables
private void img() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
}