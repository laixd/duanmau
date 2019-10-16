
import dao.NhanVienDAO;
import helper.DialogHelper;
import helper.ShareHelper;
import java.awt.Toolkit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DMX
 */
public class NhanVienJFrame extends javax.swing.JFrame {

    int index = 0;
    NhanVienDAO dao = new NhanVienDAO();

    /**
     * s
     * Creates new form NhanVienJFrame
     */
    public NhanVienJFrame() {
        initComponents();
        img();
        setLocationRelativeTo(null);
    }
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    NhanVien model = new NhanVien();
    ButtonGroup button = new ButtonGroup();

    public void button() {
    }

    public void checkrong() {
        String maNV = txtMaNV.getText();
        String tenNV = txtHoTen.getText();
        String matkhau = txtMatKhau.getText();
        String xacNhan = txtXacNhanMK.getText();

        if (maNV.length() == 0) {
            a = false;
            DialogHelper.alert(this, "Không để trống mã nhân viên !");
        } else {
            a = true;
        }

        if (matkhau.length() == 0) {
            c = false;
            DialogHelper.alert(this, "Không được để trống mật khẩu !");

        } else {
            c = true;
        }
        if (xacNhan.length() == 0) {
            d = false;
            DialogHelper.alert(this, "Không được để trống xác nhận mật khẩu !");
        } else {
            d = true;
        }
        if (tenNV.length() == 0) {
            b = false;
            DialogHelper.alert(this, "Không được để trống tên nhân viên !");
        } else {
            b = true;
        }
    }

    public void checkMK() {
        String matkhau = txtMatKhau.getText();
        if (matkhau.length() >= 6) {
            e = true;
        } else {
            e = false;
            DialogHelper.alert(this, "mật khẩu phải từ 6 số trở lên !!");
        }
    }

    public void checkTrungMa() {
        String maNV = txtMaNV.getText();
        model = dao.findById(maNV);
        if (model != null) {
            DialogHelper.alert(this, "Mã nhân viên đã tồn tại!");
            f = false;
        } else {
            f = true;
        }
    }

    public void checkTrungMK() {
        String matkhau = txtMatKhau.getText();
        String xacNhan = txtXacNhanMK.getText();

        if (matkhau.valueOf(c) != xacNhan.valueOf(d)) {
            c = false;
            d = false;
            DialogHelper.alert(this, "Mã xác nhận không đúng với mật khẩu !");
        } else {
            c = true;
            d = true;
        }
    }

    public void checkAlphabet() {
        String fullname = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ"
                + "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ"
                + "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";
        Pattern pattern = Pattern.compile(fullname);
        Matcher rengexMatcher = pattern.matcher(txtHoTen.getText());
        if (rengexMatcher.matches()) {
            g = true;
        } else {
            g = false;
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại họ và tên");
        }
    }

//    public void check() {
//        String maNV = txtMaNV.getText();
//        String tenNV = txtHoTen.getText();
//        String matkhau = txtMatKhau.getText();
//        String xacNhan = txtXacNhanMK.getText();
//        //check rõng
//        if (maNV.length() == 0) {
//            a = false;
//            DialogHelper.alert(this, "Không để trống mã nhân viên !");
//        } else {
//            a = true;
//        }
//        if (tenNV.length() == 0) {
//            b = false;
//            DialogHelper.alert(this, "Không được để trống tên nhân viên !");
//        } else {
//            b = true;
//        }
//        if (matkhau.length() == 0) {
//            c = false;
//            DialogHelper.alert(this, "Không được để trống mật khẩu !");
//
//        } else {
//            c = true;
//        }
//        if (xacNhan.length() == 0) {
//            d = false;
//            DialogHelper.alert(this, "Không được để trống xác nhận mật khẩu !");
//        } else {
//            d = true;
//        }
//        //checkMK
//        if (matkhau.length() >= 3) {
//            c = true;
//        } else {
//            c = false;
//            DialogHelper.alert(this, "Mật khẩu vui lòng điền lớn hơn 3 kí tự !");
//        }
//
//        //check trùng mã
//        NhanVien model = new NhanVien();
//        model = dao.findById(maNV);
//        if (model != null) {
//            a = false;
//            DialogHelper.alert(this, "Mã nhân viên đã tồn tại !");
//        } else {
//            a = true;
//        }
//
//        // check trùng mk
//        if (matkhau.valueOf(c) != xacNhan.valueOf(d)) {
//            c = false;
//            d = false;
//            DialogHelper.alert(this, "Mã xác nhận không đúng với mật khẩu !");
//        } else {
//            c = true;
//            d = true;
//        }
//        // check alphabet và ký tự trắng
//        String name = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ"
//                + "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ"
//                + "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";
//        Pattern pt = Pattern.compile(name);
//        Matcher mc = pt.matcher(txtHoTen.getText());
//        if (mc.matches()) {
//            b = true;
//        } else {
//            b = false;
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại họ tên !");
//        }
//        //vai trò
//
//    }
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblView.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = dao.select();
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getMatKhau(),
                    nv.getHoTen(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        NhanVien model = new NhanVien();
        model = getModel();

        String confirm = new String(txtXacNhanMK.getPassword());
        if (confirm.equals(model.getMatKhau())) {
            try {
                dao.insert(model);
                this.load();

                this.clear();
                DialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại!");
            }
        } else {
            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
        }
    }

    void update() {
        NhanVien model = getModel();
        String confirm = new String(txtXacNhanMK.getPassword());
        if (!confirm.equals(model.getMatKhau())) {
            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
        } else {
            try {
                dao.update(model);
                this.load();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    void delete() {
        try {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
                String manv = txtMaNV.getText();
                if (ShareHelper.USER.getMaNV().equals(manv)) {
                    DialogHelper.alert(this, "Bạn không thể xóa nhân viên này !");
                } else {
                    try {
                        dao.delete(manv);
                        this.load();
                        this.clear();
                        DialogHelper.alert(this, "Xóa thành công!");
                    } catch (Exception e) {
                        DialogHelper.alert(this, "Xóa thất bại!");
                    }
                }

            }
        } catch (Exception e) {
        }

    }

    void edit() {
        try {
            String manv = (String) tblView.getValueAt(this.index, 0);
            NhanVien model = dao.findById(manv);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void clear() {
        this.setModel(new NhanVien());
        this.setStatus(true);
    }

    void clearr() {
        txtHoTen.setText("");
        txtMaNV.setText("");
        txtMatKhau.setText("");
        txtXacNhanMK.setText("");
    }

    void setModel(NhanVien model) {
        txtMaNV.setText(model.getMaNV());
        txtHoTen.setText(model.getHoTen());
        txtMatKhau.setText(model.getMatKhau());
        txtXacNhanMK.setText(model.getMatKhau());
        rdoTruongPhong.setSelected(model.isVaiTro());
        rdoNhanVien.setSelected(!model.isVaiTro());
    }

    NhanVien getModel() {
        NhanVien model = new NhanVien();
        model.setHoTen((txtHoTen.getText()));
        model.setMaNV(txtMaNV.getText());

        model.setMatKhau(new String(txtMatKhau.getPassword()));

        model.setVaiTro(rdoTruongPhong.isSelected());
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaNV.setEditable(insertable);
        btnThem.setEnabled(insertable);
        btnSua.setEnabled(!insertable);
        btnXoa.setEnabled(!insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblView.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);
        btnPrev.setEnabled(!insertable && first);
        btnNext.setEnabled(!insertable && last);
        btnLast.setEnabled(!insertable && last);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlCapNhat = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdoTruongPhong = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();
        txtXacNhanMK = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        pnlDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setText("Vai trò");

        buttonGroup1.add(rdoTruongPhong);
        rdoTruongPhong.setText("Trưởng phòng");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân viên");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel6.setText("Họ và tên:");

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlCapNhatLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCapNhatLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                            .addComponent(btnThem)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSua)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnXoa)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnMoi)
                                            .addGap(48, 48, 48)
                                            .addComponent(btnFirst))
                                        .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(rdoTruongPhong)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rdoNhanVien)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPrev)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnNext)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLast))
                                .addComponent(jLabel6)))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTruongPhong)
                    .addComponent(rdoNhanVien))
                .addGap(18, 18, 18)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", pnlCapNhat);

        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NV", "MẬT KHẨU", "HỌ VÀ TÊN", "VAI TRÒ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblView);

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", pnlDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // 
        this.checkMK();
        this.checkTrungMK();
        this.checkAlphabet();
        if (e == true && c == true && d == true && g == true) {
            this.update();
        } else {
            DialogHelper.alert(this, "Cập nhật thất bại !");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // 
        this.load();
        this.setStatus(true);
    }//GEN-LAST:event_formWindowOpened

    private void tblViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewMouseClicked
        //
        if (evt.getClickCount() == 2) {
            this.index = tblView.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblViewMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // 
//        this.check();
        this.checkrong();
        this.checkMK();
        this.checkAlphabet();
        this.checkTrungMa();
        this.checkTrungMK();
        if (a == true && b == true && c == true && d == true && e == true && f == true && g == true) {
            this.insert();
        } else {
            DialogHelper.alert(this, "Thêm mới thất bại !");
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // 
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // 
        this.clear();
//        this.clearr();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // 
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // 
        this.index--;
        this.edit();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // 
        this.index++;
        this.edit();

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // 
        this.index = tblView.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblView;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables
private void img() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
}
