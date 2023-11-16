package view;

import java.awt.Color;
import query.JDlgConsultaCliente;
import query.JDlgConsultaProduto;
import query.JDlgConsultaUsuario;
import query.JDlgConsultaVenda;
import query.JDlgConsultaVendedor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u07540852100
 */
public class JFrmTelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFrmTelaPrincipal
     */
    public JFrmTelaPrincipal(java.awt.Frame parent, boolean modal) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.getHSBColor(180, 204, 0x78));
        setTitle("Sistema de Venda de Roupas e Acessórios Vintage");
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBtnCliente_toolbar = new javax.swing.JButton();
        jBtnProduto_toolbar = new javax.swing.JButton();
        jBtnVenda_toolbar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMnuUsuario = new javax.swing.JMenuItem();
        jMnuCliente = new javax.swing.JMenuItem();
        jMnuProduto = new javax.swing.JMenuItem();
        jMnuVendedor = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMnuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMnuVendas = new javax.swing.JMenuItem();
        jMnuConsultas = new javax.swing.JMenu();
        jMnuConsultaUsuario = new javax.swing.JMenuItem();
        jMnuConsultaCliente = new javax.swing.JMenuItem();
        jMnuConsultaVendedor = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMnuConsultaProduto = new javax.swing.JMenuItem();
        jMnuConsultaVenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jBtnCliente_toolbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cliente.png"))); // NOI18N
        jBtnCliente_toolbar.setFocusable(false);
        jBtnCliente_toolbar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnCliente_toolbar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnCliente_toolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCliente_toolbarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnCliente_toolbar);

        jBtnProduto_toolbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/produto-removebg-preview.png"))); // NOI18N
        jBtnProduto_toolbar.setFocusable(false);
        jBtnProduto_toolbar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnProduto_toolbar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnProduto_toolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProduto_toolbarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnProduto_toolbar);

        jBtnVenda_toolbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/vendas-removebg-preview.png"))); // NOI18N
        jBtnVenda_toolbar.setFocusable(false);
        jBtnVenda_toolbar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnVenda_toolbar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnVenda_toolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVenda_toolbarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnVenda_toolbar);

        jMenu.setBackground(new java.awt.Color(204, 204, 255));
        jMenu.setForeground(new java.awt.Color(0, 0, 255));
        jMenu.setText("Cadastro");

        jMnuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMnuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/usuario-removebg-preview.png"))); // NOI18N
        jMnuUsuario.setText("Usuario");
        jMnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuUsuarioActionPerformed(evt);
            }
        });
        jMenu.add(jMnuUsuario);

        jMnuCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMnuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cliente.png"))); // NOI18N
        jMnuCliente.setText("Cliente");
        jMnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuClienteActionPerformed(evt);
            }
        });
        jMenu.add(jMnuCliente);

        jMnuProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMnuProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/produto-removebg-preview.png"))); // NOI18N
        jMnuProduto.setText("Produto");
        jMnuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuProdutoActionPerformed(evt);
            }
        });
        jMenu.add(jMnuProduto);

        jMnuVendedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMnuVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/vendedor.png"))); // NOI18N
        jMnuVendedor.setText("Vendedor");
        jMnuVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuVendedorActionPerformed(evt);
            }
        });
        jMenu.add(jMnuVendedor);
        jMenu.add(jSeparator1);

        jMnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cancelar-removebg-preview.png"))); // NOI18N
        jMnuSair.setText("SAIR");
        jMnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuSairActionPerformed(evt);
            }
        });
        jMenu.add(jMnuSair);

        jMenuBar1.add(jMenu);

        jMenu2.setForeground(new java.awt.Color(51, 51, 255));
        jMenu2.setText("Movimento");

        jMnuVendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMnuVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/vendas-removebg-preview.png"))); // NOI18N
        jMnuVendas.setText("Vendas");
        jMnuVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuVendasActionPerformed(evt);
            }
        });
        jMenu2.add(jMnuVendas);

        jMenuBar1.add(jMenu2);

        jMnuConsultas.setForeground(new java.awt.Color(50, 51, 255));
        jMnuConsultas.setText("Consultas");

        jMnuConsultaUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuConsultaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/usuario-removebg-preview.png"))); // NOI18N
        jMnuConsultaUsuario.setText("Usuario");
        jMnuConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuConsultaUsuarioActionPerformed(evt);
            }
        });
        jMnuConsultas.add(jMnuConsultaUsuario);

        jMnuConsultaCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cliente.png"))); // NOI18N
        jMnuConsultaCliente.setText("Cliente");
        jMnuConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuConsultaClienteActionPerformed(evt);
            }
        });
        jMnuConsultas.add(jMnuConsultaCliente);

        jMnuConsultaVendedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuConsultaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/vendedor.png"))); // NOI18N
        jMnuConsultaVendedor.setText("Vendedor");
        jMnuConsultaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuConsultaVendedorActionPerformed(evt);
            }
        });
        jMnuConsultas.add(jMnuConsultaVendedor);
        jMnuConsultas.add(jSeparator2);

        jMnuConsultaProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuConsultaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/produto-removebg-preview.png"))); // NOI18N
        jMnuConsultaProduto.setText("Produto");
        jMnuConsultaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuConsultaProdutoActionPerformed(evt);
            }
        });
        jMnuConsultas.add(jMnuConsultaProduto);

        jMnuConsultaVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuConsultaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/vendas-removebg-preview.png"))); // NOI18N
        jMnuConsultaVenda.setText("Venda");
        jMnuConsultaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuConsultaVendaActionPerformed(evt);
            }
        });
        jMnuConsultas.add(jMnuConsultaVenda);

        jMenuBar1.add(jMnuConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(767, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuClienteActionPerformed
        // TODO add your handling code here:
        JDlgCliente jDlgCliente = new JDlgCliente(null, true);
        jDlgCliente.setVisible(true);
    }//GEN-LAST:event_jMnuClienteActionPerformed

    private void jMnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuUsuarioActionPerformed
        // TODO add your handling code here:
        JDlgUsuario jDlgUsuario = new JDlgUsuario(null, true);
        jDlgUsuario.setVisible(true);
    }//GEN-LAST:event_jMnuUsuarioActionPerformed

    private void jMnuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuProdutoActionPerformed
        // TODO add your handling code here:
        JDlgProdutoNovo jDlgProdutoNovo = new JDlgProdutoNovo(null, true);
        jDlgProdutoNovo.setVisible(true);
    }//GEN-LAST:event_jMnuProdutoActionPerformed

    private void jMnuVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuVendedorActionPerformed
        // TODO add your handling code here:
        JDlgVendedorNovo jDlgVendedorNovo = new JDlgVendedorNovo(null, true);
        jDlgVendedorNovo.setVisible(true);
    }//GEN-LAST:event_jMnuVendedorActionPerformed

    private void jMnuVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuVendasActionPerformed
        // TODO add your handling code here:
        JDlgVenda jDlgVenda = new JDlgVenda(null, true);
        jDlgVenda.setVisible(true);
    }//GEN-LAST:event_jMnuVendasActionPerformed

    private void jMnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMnuSairActionPerformed

    private void jBtnCliente_toolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCliente_toolbarActionPerformed
        // TODO add your handling code here:
        JDlgCliente jDlgCliente = new JDlgCliente(null, true);
        jDlgCliente.setVisible(true);
    }//GEN-LAST:event_jBtnCliente_toolbarActionPerformed

    private void jBtnProduto_toolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnProduto_toolbarActionPerformed
        // TODO add your handling code here:
        JDlgProdutoNovo jDlgProdutoNovo = new JDlgProdutoNovo(null, true);
        jDlgProdutoNovo.setVisible(true);
    }//GEN-LAST:event_jBtnProduto_toolbarActionPerformed

    private void jBtnVenda_toolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVenda_toolbarActionPerformed
        // TODO add your handling code here:
        JDlgVenda jDlgVenda = new JDlgVenda(null, true);
        jDlgVenda.setVisible(true);
    }//GEN-LAST:event_jBtnVenda_toolbarActionPerformed

    private void jMnuConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuConsultaUsuarioActionPerformed
        // TODO add your handling code here:
        JDlgConsultaUsuario jDlgConsultaUsuario = new JDlgConsultaUsuario(null, true);
        jDlgConsultaUsuario.setVisible(true);
    }//GEN-LAST:event_jMnuConsultaUsuarioActionPerformed

    private void jMnuConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuConsultaClienteActionPerformed
        // TODO add your handling code here:
        JDlgConsultaCliente jDlgConsultaCliente = new JDlgConsultaCliente(null, true);
        jDlgConsultaCliente.setVisible(true);
    }//GEN-LAST:event_jMnuConsultaClienteActionPerformed

    private void jMnuConsultaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuConsultaVendedorActionPerformed
        // TODO add your handling code here:
        JDlgConsultaVendedor jDlgConsultaVendedor = new JDlgConsultaVendedor(null, true);
        jDlgConsultaVendedor.setVisible(true);
    }//GEN-LAST:event_jMnuConsultaVendedorActionPerformed

    private void jMnuConsultaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuConsultaProdutoActionPerformed
        // TODO add your handling code here:
        JDlgConsultaProduto jDlgConsultaProduto = new JDlgConsultaProduto(null, true);
        jDlgConsultaProduto.setVisible(true);
    }//GEN-LAST:event_jMnuConsultaProdutoActionPerformed

    private void jMnuConsultaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuConsultaVendaActionPerformed
        // TODO add your handling code here:
        JDlgConsultaVenda jDlgConsultaVenda = new JDlgConsultaVenda(null, true);
        jDlgConsultaVenda.setVisible(true);
    }//GEN-LAST:event_jMnuConsultaVendaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmTelaPrincipal(null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCliente_toolbar;
    private javax.swing.JButton jBtnProduto_toolbar;
    private javax.swing.JButton jBtnVenda_toolbar;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnuCliente;
    private javax.swing.JMenuItem jMnuConsultaCliente;
    private javax.swing.JMenuItem jMnuConsultaProduto;
    private javax.swing.JMenuItem jMnuConsultaUsuario;
    private javax.swing.JMenuItem jMnuConsultaVenda;
    private javax.swing.JMenuItem jMnuConsultaVendedor;
    private javax.swing.JMenu jMnuConsultas;
    private javax.swing.JMenuItem jMnuProduto;
    private javax.swing.JMenuItem jMnuSair;
    private javax.swing.JMenuItem jMnuUsuario;
    private javax.swing.JMenuItem jMnuVendas;
    private javax.swing.JMenuItem jMnuVendedor;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
