/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TokoBaju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import static TokoBaju.Menu.ID;


public class MenuUser extends javax.swing.JFrame {
 
    private Connection con;
    private Statement stat;
    private ResultSet res;

    public static String ID;

    public MenuUser() {
        initComponents();
        koneksi();
        tabel();
    }

    public void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tokobaju", "root", "");
            stat = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void tabel() {
        koneksi();
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setRowCount(0);

        try {
            String sql = "select * from bajudewasa";
            res = stat.executeQuery(sql);
            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getString("idBaju"),
                    res.getString("namaBaju"),
                    res.getInt("harga"),
                    res.getInt("stock"),
                    res.getString("merekBaju"),
                    res.getString("jenisKelamin")
                });
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    private void tabel(String search) {
        koneksi();
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setRowCount(0);

        try {
            String sql = "select * from bajudewasa WHERE namaBaju LIKE '%" + search + "%' OR merekBaju LIKE '%" + search + "%'";
            res = stat.executeQuery(sql);
            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getString("idBaju"),
                    res.getString("namaBaju"),
                    res.getInt("harga"),
                    res.getInt("stock"),
                    res.getString("merekBaju"),
                    res.getString("jenisKelamin")
                });
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        btnpesan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        MenuBarAdmin = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setBackground(new java.awt.Color(244, 236, 223));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Baju", "Nama Baju", "Harga", "Stok", "Merek", "Jenis Kelamin"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        txtsearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        btnpesan.setBackground(new java.awt.Color(182, 142, 107));
        btnpesan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnpesan.setText("Pesan");
        btnpesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("CARI BARANG");

        MenuBarAdmin.setBackground(new java.awt.Color(204, 255, 255));

        jMenu6.setBackground(new java.awt.Color(204, 255, 255));
        jMenu6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu6.setText("History Order");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        MenuBarAdmin.add(jMenu6);

        jMenu2.setBackground(new java.awt.Color(204, 255, 255));
        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("Logout");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        MenuBarAdmin.add(jMenu2);

        setJMenuBar(MenuBarAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnpesan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnpesan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        String cari = txtsearch.getText();
        tabel(cari);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int baris = table.getSelectedRow();
        ID = (String) table.getValueAt(baris, 0);
        System.out.println(ID);
    }//GEN-LAST:event_tableMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnpesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesanActionPerformed
        // TODO add your handling code here:
    if (ID == null || ID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap Pilih Baju Terlebih Dahulu", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String username, id_alat;
    username = Login.IDU;
    id_alat = ID;
    String tanggal = LocalDate.now().toString();

    int response = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin Ingin Membeli Baju Dengan ID " + id_alat + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
        try {
            Connection conn = koneksi.getConnection();
            String sql = "INSERT INTO orders VALUES (NULL,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, id_alat);
            stmt.setString(3, tanggal);

            int rowAffected = stmt.executeUpdate();
            if (rowAffected > 0) {
                ID = null;
                JOptionPane.showMessageDialog(this, "Berhasil Membeli Baju!", "SQL Information", JOptionPane.INFORMATION_MESSAGE);
                stmt.close();
                tabel();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnpesanActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        Historyorder HO = new Historyorder();
        HO.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBarAdmin;
    private javax.swing.JButton btnpesan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
