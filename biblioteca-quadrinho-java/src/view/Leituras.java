/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import model.Leitura;
import model.Usuario;

/**
 *
 * @author joaoe
 */
public class Leituras extends javax.swing.JFrame {

    List<Leitura> leituras;
    /**
     * Creates new form Leituras
     */
    public Leituras() {
        initComponents();
        atualizarTabela();
    }
    
    public void atualizarTabela(){
        this.leituras = TelaLogin.funcao.listarLeitura();
        DefaultTableModel tTabela = (DefaultTableModel) jTable1.getModel();
        tTabela.setNumRows(0);                
        
        for(Leitura l: this.leituras){                       
            Object[] obj = {l.getUsuario().getNome(), l.getQuadrinho().getTitulo(),
                l.getDataLeitura(), l.getAvaliacao()};
            tTabela.addRow(obj); 
        } 
        jTable1.setModel(tTabela);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Leituras");

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Encerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Quadrinho", "Data de Inicio", "Avaliação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int linha = jTable1.getSelectedRow();        
        if(linha >= 0){
            int cont = 0;
            for(Leitura l: this.leituras){
                if(cont == linha){
                    if(avaliacaoOk(l.getAvaliacao())){
                        int resposta = JOptionPane.showConfirmDialog(this, "Deseja cancelar a leitura?");
                        if(resposta == JOptionPane.YES_OPTION){
                            if(l.getUsuario().getCpf().equals(TelaLogin.funcao.getUsuario().getCpf())){
                                TelaLogin.funcao.cancelarLeitura(l.getDataLeitura(), l.getQuadrinho().getId());
                                JOptionPane.showMessageDialog(this, "Leitura cancelada");
                                atualizarTabela();
                            }else{
                                JOptionPane.showMessageDialog(this, "Leitura iniciadar por outro usuário, impossivel cancelar");
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, "Leitura não cancelada");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Não pode cancelar uma leitura que já foi encerrada");
                    }
                }
                cont++;
            }
        }else
            JOptionPane.showMessageDialog(this, "Selecione uma leitura");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new MenuUsuario().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public boolean avaliacaoOk(String str){
        if(str == null)
            return true;
        if(str.equals("boa") || str.equals("media") || str.equals("ruim"))
            return false;
        return true;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int linha = jTable1.getSelectedRow();
        if(linha >= 0){
            int cont = 0;
            for(Leitura l: this.leituras){
                if(cont == linha){
                    if(avaliacaoOk(l.getAvaliacao())){
                        if(l.getUsuario().getCpf().equals(TelaLogin.funcao.getUsuario().getCpf())){
                            String avaliacao = pegarAvaliacao();
                            TelaLogin.funcao.encerrarLeitura(avaliacao, l.getDataLeitura(), l.getQuadrinho().getId());
                            JOptionPane.showMessageDialog(this, "Leitura encerrada com sucesso");
                            atualizarTabela();
                        }else{
                            JOptionPane.showMessageDialog(this, "Leitura iniciada por outro usuario, impossível encerrar");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Leitura já encerrada");
                    }
                    break;
                }
                cont++;
            }
        }else
            JOptionPane.showMessageDialog(this, "Selecione a leitura que deseja encerrar");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new IniciarLeitura().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public String pegarAvaliacao(){
        int pos = JOptionPane.showOptionDialog(this, "O que achou do quadrinho", "Avaliação",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[] {"BOA", "MEDIA", "RUIM"}, this);
        if(pos == 0)
            return "boa";
        if(pos == 1)
            return "media";
        return "ruim";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}