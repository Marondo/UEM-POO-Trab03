/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Pacote1.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marondo
 * Retorna o painel que contem a tabela de contas cadastradas
 */
public class pTabela extends javax.swing.JPanel {

    /**
     * Creates new form tABELA
     */
    public pTabela() {
        initComponents();
    }

    public pTabela(ArrayList lista) {
        preenche_a_tbl(lista);
    }
/**Preenche a tabela com os dados de cada conta na lista
 * 
 * @param lista 
 */
    public void preenche_a_tbl(ArrayList<ContaBancaria> lista) {
        if (lista != null) {
             ((DefaultTableModel) tblTabela.getModel()).setNumRows(0);
            if (lista.size() > 0) {
//            tblTabela.removeAll();
                int id = 1;
                for (ContaBancaria ob : lista) {
                    add_Linha_na_tbl(id, ob);
                    id++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista vazia!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista nula!");
        }
    }
    Conta_Corrente cc = new Conta_Corrente();
    Conta_Poupaca cp = new Conta_Poupaca();
    String contaTipo = "";
/**Adiciona uma linha na tabela
 * 
 * @param id
 * @param ob 
 */
    private void add_Linha_na_tbl(int id, ContaBancaria ob) {
        if (ob instanceof Conta_Corrente) {
            cc = (Conta_Corrente) ob;
            contaTipo = "Corrente";
        } else {
            cp = (Conta_Poupaca) ob;
            contaTipo = "Poupaca";
        }
        Object[] registo = {id, ob.getNrConta(), ob.getSaldo(), ob.getHistorico(), contaTipo};
        DefaultTableModel modelo = (DefaultTableModel) tblTabela.getModel();
        modelo.addRow(registo);
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
        tblTabela = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 51, 51));

        tblTabela.setBackground(new java.awt.Color(204, 204, 255));
        tblTabela.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NUMERO DE CONTA", "SALDO DISPONUVEL", "HISTORICO", "TIPO DE CONTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTabela);
        if (tblTabela.getColumnModel().getColumnCount() > 0) {
            tblTabela.getColumnModel().getColumn(0).setHeaderValue("ID");
            tblTabela.getColumnModel().getColumn(1).setHeaderValue("NUMERO DE CONTA");
            tblTabela.getColumnModel().getColumn(2).setHeaderValue("SALDO DISPONUVEL");
            tblTabela.getColumnModel().getColumn(3).setHeaderValue("HISTORICO");
            tblTabela.getColumnModel().getColumn(4).setHeaderValue("TIPO DE CONTA");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabela;
    // End of variables declaration//GEN-END:variables
}