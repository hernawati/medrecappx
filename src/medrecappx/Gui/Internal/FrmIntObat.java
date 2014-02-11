/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import medrecappx.Dao.ObatDao;
import medrecappx.Entity.Obat;
import medrecappx.Services.ObatService;
import medrecappx.TabelModel.TabelModelObat;

/**
 *
 * @author Hady
 */
public class FrmIntObat extends javax.swing.JInternalFrame {

    ObatService os = new ObatService();
    TabelModelObat tabelModelObat = new TabelModelObat();
    Connection connection;

    /**
     * Creates new form FrmIntObat
     */
    public FrmIntObat() {
        initComponents();
        tabelObat.setModel(tabelModelObat);
        tabelModelObat.setData(os.serviceGetAllObat());
        if (!ObatDao.hasilGetAll.equals("ok")) {
            JOptionPane.showMessageDialog(null, ObatDao.hasilGetAll, "Get All Dokter Gagal!", JOptionPane.ERROR_MESSAGE);
        }
        sesuaikan();

        tabelObat.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelObat.getSelectedRow();
                if (row != -1) {

                    String idObat = tabelObat.getValueAt(row, 0).toString();
                    String keterangan = tabelObat.getValueAt(row, 1).toString();
                    txtIdObat.setText(idObat);
                    txtKeterangan.setText(keterangan);
                    btnInsert.setEnabled(false);
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    txtIdObat.setEnabled(false);
                }
            }
        });
    }

    public final void sesuaikan() {
        TableColumnModel tcm = tabelObat.getColumnModel();
        for (int kolom = 0; kolom < tcm.getColumnCount(); kolom++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < tabelObat.getRowCount(); baris++) {
                TableCellRenderer tcr = tabelObat.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelObat.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelObat, nilaiTable,
                        false, false, baris, kolom);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn tc = tcm.getColumn(kolom);
            tc.setPreferredWidth(lebarKolomMax);
        }

        txtIdObat.setText("");
        txtKeterangan.setText("");
        txtCari.setText("");
        txtIdObat.requestFocus();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void clear() {
        txtIdObat.setText("");
        txtKeterangan.setText("");
        txtCari.setText("");
        txtIdObat.requestFocus();
        tabelModelObat.setData(os.serviceGetAllObat());
        sesuaikan();
        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        txtIdObat.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdObat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelObat = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Obat"));

        jLabel1.setText("ID Obat");

        jLabel2.setText("Keterangan");

        jLabel3.setText(":");

        jLabel4.setText(":");

        txtIdObat.setName("txtIdObat"); // NOI18N

        txtKeterangan.setColumns(20);
        txtKeterangan.setFont(new java.awt.Font("Tahoma", 0, 11));
        txtKeterangan.setLineWrap(true);
        txtKeterangan.setRows(5);
        txtKeterangan.setName("txtKeterangan"); // NOI18N
        jScrollPane1.setViewportView(txtKeterangan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdObat, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtIdObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelObat.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelObat.setName("tabelObat"); // NOI18N
        jScrollPane3.setViewportView(tabelObat);

        btnRefresh.setText("Refresh");
        btnRefresh.setName("btnRefresh"); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

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

        jLabel7.setText("Masukkan ID / Nama Obat :");

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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(157, 157, 157))
                    .addComponent(txtCari, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String idObat = txtIdObat.getText();
        String ketObat = txtKeterangan.getText();

        if ((idObat.equals("")) || (ketObat.equals(""))) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Insert Obat Gagal!", JOptionPane.ERROR_MESSAGE);
        } else {
            Obat o = new Obat();
            o.setIdObat(idObat);
            o.setKetObat(ketObat);
            os.serviceInsertObat(o);

            if (ObatDao.hasilInsert.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data obat berhasil ditambah!", "Insert Obat", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, ObatDao.hasilInsert, "Insert Obat Gagal!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String idObat = txtIdObat.getText();
        String ketObat = txtKeterangan.getText();

        if ((idObat.equals("")) || (ketObat.equals(""))) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Update Obat Gagal!", JOptionPane.ERROR_MESSAGE);
        } else {
            Obat o = new Obat();
            o.setKetObat(txtKeterangan.getText());
                        
            int row = tabelObat.getSelectedRow();
            if (row != -1) {
                os.serviceUpdateObat(o, tabelObat.getValueAt(row, 0).toString());
                //os.serviceUpdateObat(o, txtIdObat.getText());
                if (ObatDao.hasilUpdate.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Data Obat berhasil diubah!", "Update Obat", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, ObatDao.hasilUpdate, "Update Obat Gagal!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tabelObat.getSelectedRow();
        if (row == -1) {
            return;
        }
        
        int pilih = JOptionPane.showConfirmDialog(rootPane,
                "Yakin ingin mengahapus data yang dipilih?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pilih == JOptionPane.OK_OPTION) {
            os.serviceDeleteObat(tabelObat.getValueAt(row, 0).toString());
            if (ObatDao.hasilDelete.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data obat berhasil dihapus!", "Delete Obat", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, ObatDao.hasilDelete, "Delete Obat Gagal!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        tabelModelObat.setData(os.serviceGetAllObatById(txtCari.getText()));

        txtIdObat.setText("");
        txtKeterangan.setText("");

        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_txtCariKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelObat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdObat;
    private javax.swing.JTextArea txtKeterangan;
    // End of variables declaration//GEN-END:variables
}
