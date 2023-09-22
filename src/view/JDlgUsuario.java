/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Usuario;
import bean.Venda;
import dao.Usuario_DAO;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;

/**
 *
 * @author u07540852100
 */
public class JDlgUsuario extends javax.swing.JDialog {
    
    private boolean incluindo; //variavel boolean para diferenciar o tipo de inclusão
    MaskFormatter mascaraCpf; 
    MaskFormatter mascaraNascimento;

    /**
     * Creates new form JDlgUsuario
     */
    public JDlgUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        setSize(680, 400);
        setTitle("Cadastro de Usuários");
        setLocationRelativeTo(null);
        
        try { //fechar a instrução com o Try Catch
            mascaraCpf = new MaskFormatter("###.###.###-##"); //("###.###.###-##")
            mascaraNascimento = new MaskFormatter("##/##/####"); //("##/##/####")
            
        } catch (ParseException ex) { 
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level. SEVERE, null, ex); 
        }
        
        jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf)); //mascara instanciada e no campo
        jFmtNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraNascimento)); 
    }
    
    public void habilitar(){
    jTxtId_usuario.setEnabled(true);
    jChbAutomatico.setEnabled(true);
    jChbAtivo.setEnabled(true);
    jTxtNome.setEnabled(true);
    jTxtApelido.setEnabled(true);
    jFmtCpf.setEnabled(true);
    jFmtNascimento.setEnabled(true);
    jPwfSenha.setEnabled(true);
    jCboNivel.setEnabled(true);
    jBtnConfirmar.setEnabled(true);
    jBtnCancelar.setEnabled(true);
    
    jBtnIncluir.setEnabled(false);
    jBtnAlterar.setEnabled(false);
    jBtnExcluir.setEnabled(false);
    jBtnPesquisar.setEnabled(false);
    };
    
    public void desabilitar(){
    jTxtId_usuario.setEnabled(false);
    jChbAutomatico.setEnabled(false);
    jChbAtivo.setEnabled(false);
    jTxtNome.setEnabled(false);
    jTxtApelido.setEnabled(false);
    jFmtCpf.setEnabled(false);
    jFmtNascimento.setEnabled(false);
    jPwfSenha.setEnabled(false);
    jCboNivel.setEnabled(false);
    jBtnConfirmar.setEnabled(false);
    jBtnCancelar.setEnabled(false);
    
    jBtnIncluir.setEnabled(true);
    jBtnAlterar.setEnabled(true);
    jBtnExcluir.setEnabled(true);
    jBtnPesquisar.setEnabled(true);
    };
    
    public void automatico() {
    jTxtId_usuario.setEnabled(false);
    };
    
    public void limparCampos() {
        jTxtId_usuario.setText("");
        jTxtNome.setText("");
        jTxtApelido.setText("");
        jFmtCpf.setText("");
        jFmtNascimento.setText("");
        jCboNivel.setSelectedIndex(-1);
        jPwfSenha.setText("");
        jChbAtivo.setSelected(false);
        jChbAutomatico.setSelected(false);
    };
    
    public Usuario viewBean() { //método para pegar da tela e jogar no bean
        Usuario usuario = new Usuario(); //criando o bean
        
        int id = Integer.valueOf(jTxtId_usuario.getText());
        
        usuario.setId_usuario(id);
        usuario.setNome(jTxtNome.getText());
        usuario.setApelido(jTxtApelido.getText());
        usuario.setCpf(jFmtCpf.getText());
        SimpleDateFormat formataNascimento = new SimpleDateFormat("dd/MM/yyyy"); //convertendo string para Date
          try {
             usuario.setNascimento(formataNascimento.parse(jFmtNascimento.getText()));
            } catch (ParseException ex) {
             System.out.println("Erro em -Nascimento-!" + ex.getMessage());
            }
        usuario.setSenha(jPwfSenha.getText());
        usuario.setNivel(jCboNivel.getSelectedIndex());
        usuario.setAtivo(jChbAtivo.isSelected() == true ? "S" : "N");
        
        //if (jChbAtivo.isSelected() == true) {// o Ativo esta selecionado?
            //usuario.setAtivo("S");
        //}else {
            //usuario.setAtivo("N");
        //}
        return usuario;
    };
    
    public void beanView(Usuario usuario) { //do banco para a tela
        
        String valor = String.valueOf(usuario.getId_usuario()); //converte int para string (pelo Text)
        
        jTxtId_usuario.setText(valor);
        jTxtNome.setText(usuario.getNome());
        jTxtApelido.setText(usuario.getApelido());
        jFmtCpf.setText(usuario.getCpf());
        SimpleDateFormat formataNascimento = new SimpleDateFormat("dd/MM/yyyy");// Convertendo date para String
        jFmtNascimento.setText(formataNascimento.format(usuario.getNascimento()));
        jPwfSenha.setText(usuario.getSenha());
        jCboNivel.setSelectedIndex(usuario.getNivel());
        if (usuario.getAtivo().equals("S") == true) { //caso esteja "S" o ativo é true
            jChbAtivo.setSelected(true);
        }else {
            jChbAtivo.setSelected(false);
        }
    };


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtUsuario1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtId_usuario = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApelido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jFmtNascimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jPwfSenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jCboNivel = new javax.swing.JComboBox<>();
        jChbAtivo = new javax.swing.JCheckBox();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jChbAutomatico = new javax.swing.JCheckBox();

        jLabel2.setText("ID Usuario");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID Usuario");

        jLabel3.setText("Nome");

        jLabel4.setText("Apelido");

        jLabel5.setText("CPF");

        jLabel6.setText("Data de Nascimento");

        jLabel7.setText("Senha");

        jLabel8.setText("Nivel");

        jCboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Colaborador", "Visitante" }));

        jChbAtivo.setText("Ativo");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/inserir-removebg-preview.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/editar-removebg-preview.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cancelar-removebg-preview.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/confirmar-removebg-preview.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/busca-removebg-preview.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/recarregar fino (1).png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jChbAutomatico.setText("Automático");
        jChbAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbAutomaticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtApelido)
                    .addComponent(jTxtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPwfSenha)
                            .addComponent(jFmtCpf)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnExcluir)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtNascimento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jCboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jChbAtivo)))
                                        .addGap(0, 94, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCancelar)
                                .addGap(30, 30, 30)
                                .addComponent(jBtnPesquisar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtId_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jChbAutomatico)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtId_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbAutomatico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFmtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbAtivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnAlterar)
                        .addComponent(jBtnPesquisar)
                        .addComponent(jBtnCancelar)
                        .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        habilitar();
        limparCampos();
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        
        Usuario usuario = viewBean();
        Usuario_DAO usuario_DAO = new Usuario_DAO();
        
        if (incluindo == true) {
            usuario_DAO.insert(usuario);
        }else {
            usuario_DAO.update(usuario);
        }
               
        //limparCampos();
        //desabilitar();   CLASSE UTIL
        
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        desabilitar();
        limparCampos();
        JOptionPane.showMessageDialog(null, "Ação cancelada.");
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        habilitar();
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jChbAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbAutomaticoActionPerformed
        // TODO add your handling code here:
        automatico();
    }//GEN-LAST:event_jChbAutomaticoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do produto?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) { //da tela para o bean, depois DAO e lá aciona o delete
            Usuario usuario = viewBean(); //declarou um obj Bean que recebeu viewBean
            Usuario_DAO usuario_DAO = new Usuario_DAO();
            usuario_DAO.delete(usuario);
            
        }else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada!", "Aviso", 2);
        }     
        //limparCampos(); CLASSE UTIL
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        JDlgUsuarioPesquisa jDlgUsuarioPesquisa = new JDlgUsuarioPesquisa(null, true);
        jDlgUsuarioPesquisa.setTelaAnterior(this); //a sua tela anterior sou eu - eu quem? o JDlgUsuario!
        jDlgUsuarioPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgUsuario dialog = new JDlgUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboNivel;
    private javax.swing.JCheckBox jChbAtivo;
    private javax.swing.JCheckBox jChbAutomatico;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPwfSenha;
    private javax.swing.JTextField jTxtApelido;
    private javax.swing.JTextField jTxtId_usuario;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtUsuario1;
    // End of variables declaration//GEN-END:variables

    void beanView(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
