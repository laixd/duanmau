
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DMX
 */
public class AboutJDialog extends javax.swing.JDialog {

    /**
     * Creates new form AboutJDialog
     */
    public AboutJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        img();
        
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtgioithieu = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Giới thiệu");
        setBackground(new java.awt.Color(51, 255, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/fpt.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LỜI GIỚI THIỆU");

        txtgioithieu.setColumns(20);
        txtgioithieu.setLineWrap(true);
        txtgioithieu.setRows(5);
        txtgioithieu.setText(" Dự án mẫu là một môn học trong chương trình đào tạo CNTT của hệ cao đẳng thực hành FPT Polytechnic. \n\n Mục tiêu của môn học này là cung cấp cho sinh viên một cái nhìn tổng quan về việc làm dự án phần mềm theo qui trình công nghiệp sát với thực tế hiện nay.\nQua môn học này sinh viên cần biết sử dụng tài liệu dự án được xây dựng sẵn để xây dựng ra một phần mềm – đó là phần mềm Quản lý đào tạo cho trung tâm đào tạo tin học ngắn hạn theo chuyên đề LapTrinhCity.\n\n Trong chương trình đào tạo theo tiêu chuẩn CDIO thì sinh viên cần được huấn luyện các kỹ năng C, D, I, O (Conceiving — Designing — Implementing — Operating). Dự án này rèn luyện cho sinh viên các kỹ năng I và O đồng thời làm nền tảng cho sinh viên rèn luyện các kỹ năng còn lại C và D qua các môn học tiếp sau trong đó đặc biệt là dự án 1 và dự án 2 và cả thực tập tốt nghiệp.\n\n Với phương pháp đào tạo đảo ngược như vậy chúng tôi mong muốn sinh viên nghề không những có đủ kỹ năng thực hiện mà còn được rèn luyện thêm kỹ phân tích và thiết kế nhằm giúp sinh viên phát triển sự nghiệp lâu dài học học tiếp lên các cấp độ cao hơn.\n");
        jScrollPane2.setViewportView(txtgioithieu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        pack();
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
            java.util.logging.Logger.getLogger(AboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AboutJDialog dialog = new AboutJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtgioithieu;
    // End of variables declaration//GEN-END:variables
private void img(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));}
}