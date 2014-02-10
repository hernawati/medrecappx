/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmIntSpesialis.java
 *
 * Created on Dec 19, 2013, 11:26:45 AM
 */
package medrecappx.Gui.Internal;

import com.mysql.jdbc.Connection;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import medrecappx.Dao.SpesialisDao;
import medrecappx.Entity.Spesialis;
import medrecappx.Services.SpesialisService;
import medrecappx.TabelModel.TabelModelSpesialis;

/**
 *
 * @author Fachrul Pralienka BM
 */
public class FrmIntSpesialis extends javax.swing.JInternalFrame {

    SpesialisService ss = new SpesialisService();
    TabelModelSpesialis tabelModelSpesialis = new TabelModelSpesialis();
    Connection connection;

    /** Creates new form FrmIntSpesialis */
    public FrmIntSpesialis() {
        initComponents();
        tabelSpesialis.setModel(tabelModelSpesialis);
        tabelModelSpesialis.setData(ss.serviceGetAllSpesialis());

        // cek hasil hasilGetAll
        if (!SpesialisDao.hasilGetAll.equals("ok")) {
            JOptionPane.showMessageDialog(null, SpesialisDao.hasilGetAll, "Get All Spesialis Gagal!", JOptionPane.ERROR_MESSAGE);
        }
        sesuaikan();

        tabelSpesialis.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelSpesialis.getSelectedRow();
                if (row != -1) {

                    String ID = tabelSpesialis.getValueAt(row, 0).toString();
                    String nama = tabelSpesialis.getValueAt(row, 1).toString();
                    String tarif = tabelSpesialis.getValueAt(row, 2).toString();
                    txtIdSpesialis.setText(ID);
                    txtNmSpesialis.setText(nama);
                    txtTarifSpesialis.setText(tarif);

                    btnInsert.setEnabled(false);
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    txtIdSpesialis.setEnabled(false);
                }
            }
        });

        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtIdSpesialis.setText("");
        txtNmSpesialis.setText("");
        txtTarifSpesialis.setText("");
        txtIdSpesialis.requestFocus();
    }

    public final void sesuaikan() {
        TableColumnModel tcm = tabelSpesialis.getColumnModel();
        for (int kolom = 0; kolom < tcm.getColumnCount(); kolom++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < tabelSpesialis.getRowCount(); baris++) {
                TableCellRenderer tcr = tabelSpesialis.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelSpesialis.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelSpesialis, nilaiTable,
                        false, false, baris, kolom);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn tc = tcm.getColumn(kolom);
            tc.setPreferredWidth(lebarKolomMax);
        }
    }

    public void clear() {
        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtIdSpesialis.setEnabled(true);
        txtIdSpesialis.setText("");
        txtNmSpesialis.setText("");
        txtTarifSpesialis.setText("");
        txtCari.setText("");
        tabelModelSpesialis.setData(ss.serviceGetAllSpesialis());
        txtIdSpesialis.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNmSpesialis = new javax.swing.JTextField();
        txtTarifSpesialis = new javax.swing.JTextField();
        txtIdSpesialis = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSpesialis = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Spesialis"));

        jLabel6.setText(":");

        jLabel5.setText(":");

        jLabel2.setText("Nama Spesialis");

        jLabel1.setText("ID Spesialis");

        jLabel4.setText(":");

        jLabel3.setText("Tarif Konsul");

        txtNmSpesialis.setName("txtNamaSpesialis"); // NOI18N

        txtTarifSpesialis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarifSpesialis.setName("txtTarifKonsul"); // NOI18N

        txtIdSpesialis.setName("txtIDSpesialis"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNmSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTarifSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtIdSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtNmSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtTarifSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsert.setText("Insert");
        btnInsert.setName("btnInsert"); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btRefresh.setText("Refresh");
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });

        tabelSpesialis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelSpesialis.setName("tabelSpesialis"); // NOI18N
        jScrollPane1.setViewportView(tabelSpesialis);

        jLabel7.setText("Masukkan ID / Nama Spesialis:");

        txtCari.setName("txtCari"); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                        .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(85, 85, 85))
                    .addComponent(txtCari, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String idSpesialis = txtIdSpesialis.getText();
        String nmSpesialis = txtNmSpesialis.getText();
        String tarifKonsul = txtTarifSpesialis.getText();

        if ((idSpesialis.equals("")) || (nmSpesialis.equals("")) || (tarifKonsul.equals("")) ){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Insert Spesialis Gagal!", JOptionPane.ERROR_MESSAGE);
        } else {
            Spesialis s = new Spesialis();
            s.setIdSpesialis(idSpesialis);
            s.setNmSpesialis(nmSpesialis);
            s.setTarifKonsul(Integer.parseInt(tarifKonsul));
            ss.serviceInsertSpesialis(s);

            if (SpesialisDao.hasilInsert.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data spesialis berhasil ditambah!", "Insert Spesialis", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, SpesialisDao.hasilInsert, "Insert Spesialis Gagal!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nmSpesialis = txtNmSpesialis.getText();
        String tarifKonsul = txtTarifSpesialis.getText();

        if ((nmSpesialis.equals("")) || (tarifKonsul.equals("")) ){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Update Spesialis Gagal!", JOptionPane.ERROR_MESSAGE);
        } else {
            Spesialis s = new Spesialis();
            s.setNmSpesialis(nmSpesialis);
            s.setTarifKonsul(Integer.parseInt(tarifKonsul));

            int row = tabelSpesialis.getSelectedRow();
            if (row != -1) {
                ss.serviceUpdateSpesialis(s, tabelSpesialis.getValueAt(row, 0).toString());

                if (SpesialisDao.hasilUpdate.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Data spesialis berhasil diubah!", "Update Spesialis", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, SpesialisDao.hasilUpdate, "Update Spesialis Gagal!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tabelSpesialis.getSelectedRow();
        if (row == -1) {
            return;
        }

        int pilih = JOptionPane.showConfirmDialog(rootPane,
                "Yakin ingin mengahapus data yang dipilih?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pilih == JOptionPane.OK_OPTION) {

            ss.serviceDeleteSpesialis(tabelSpesialis.getValueAt(row, 0).toString());

            if (SpesialisDao.hasilDelete.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data spesialis berhasil dihapus!", "Delete Spesialis", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, SpesialisDao.hasilDelete, "Delete Spesialis Gagal!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btRefreshActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        tabelModelSpesialis.setData(ss.serviceGetAllSpesialisById(txtCari.getText()));
        if (tabelModelSpesialis.getRowCount() == 0) {
            tabelModelSpesialis.setData(ss.serviceGetAllSpesialisByNm(txtCari.getText()));
        }
        txtIdSpesialis.setText("");
        txtNmSpesialis.setText("");
        txtTarifSpesialis.setText("");

        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        txtIdSpesialis.setEnabled(true);
    }//GEN-LAST:event_txtCariKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelSpesialis;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdSpesialis;
    private javax.swing.JTextField txtNmSpesialis;
    private javax.swing.JTextField txtTarifSpesialis;
    // End of variables declaration//GEN-END:variables
}
