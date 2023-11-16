/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RccCliente;
import bean.RccVenda;
import bean.RccVendaProduto;
import bean.VendaProdutoControle;
import bean.RccVendedor;
import dao.Cliente_DAO; //usado para lista da Fk_cliente
import dao.Venda_DAO;
import dao.Venda_produto_DAO;
import dao.Vendedor_DAO;  //usado para lista da Fk_vendedor
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author art16
 */
public class JDlgVenda extends javax.swing.JDialog {
    
    public boolean incluindo; //variavel boolean para diferenciar o tipo de inclusão
    MaskFormatter mascaraDataVenda;
    
    private RccVenda rccVenda;
    private RccVendaProduto rccVendaProduto;
    private JDlgVendaProduto jDlgVendaProduto;
    private JDlgVendaPesquisa jDlgVendaPesquisa;
    private VendaProdutoControle vendaProdutoControle;
    private Cliente_DAO cliente_DAO;
    private Vendedor_DAO vendedor_DAO;
    private Venda_produto_DAO venda_produto_DAO;
    private Venda_DAO venda_DAO;

    /**
     * Creates new form JDlgVenda
     */
    public JDlgVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Util.habilitar(false, jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(true, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        setSize(700, 600);
        setTitle("Vendas");
        setLocationRelativeTo(null);
        
        cliente_DAO = new Cliente_DAO();
        vendedor_DAO = new Vendedor_DAO();
        vendaProdutoControle = new VendaProdutoControle();
        venda_produto_DAO = new Venda_produto_DAO();
        
        
        List listCliente = cliente_DAO.listALL();
        for (int i = 0; i < listCliente.size(); i++ ) {
            jCboFk_cliente.addItem((RccCliente) listCliente.get(i));
        }
        
        List listVendedor = vendedor_DAO.listALL();
        for (int i = 0; i < listVendedor.size(); i++ ) {
            jCboFk_vendedor.addItem((RccVendedor) listVendedor.get(i));
        }
        
        
        try { //fechar a instrução com o Try Catch
            mascaraDataVenda = new MaskFormatter("##/##/####"); //("##/##/####")
            
        } catch (ParseException ex) { 
            Logger.getLogger(JDlgVenda.class.getName()).log(Level. SEVERE, null, ex); 
        }
        
        jFmtData_venda.setFormatterFactory(new DefaultFormatterFactory(mascaraDataVenda)); //mascara instanciada e no campo
        
        //pegar a lista do DAO para colocar na Table
        List lista = venda_produto_DAO.listALL(); //peguei o list do DAO
        vendaProdutoControle.setList(lista);
        jTable1.setModel(vendaProdutoControle); 
    }
    
    public void setTelaAnterior(JDlgVendaProduto jDlgVendaProduto){//método para se conectar com a tela de cadastro de Usuario 
        this.jDlgVendaProduto = jDlgVendaProduto; //agora ela sabe que ela é ela msm e a outra é a outra
    }
    
    public void automatico() {
    jTxtId_venda.setEnabled(false);
    };
    
    public RccVenda viewBean() { //método para pegar da tela e jogar no bean
        rccVenda = new RccVenda(); //criando o bean
        
        int id = Util.strInt(jTxtId_venda.getText());
        rccVenda.setRccIdVenda(id);
        
        rccVenda.setRccDataVenda(Util.strDate(jFmtData_venda.getText()));
        rccVenda.setRccFrete(Util.strDouble(jTxtFrete.getText()));
        rccVenda.setRccValorTotal(Util.strDouble(jTxtValor_total.getText()));
        rccVenda.setRccDescricaoItens(jTxtDescricao_itens.getText());
        
        //Para gravar apenas o numero do ID e não o bean da Cbo inteiro
        RccCliente rccCliente1 = (RccCliente) jCboFk_cliente.getSelectedItem(); //pega o item selecionado
        rccVenda.setRccFkCliente(rccCliente1.getRccIdCliente()); //e grava só a chave no BD
        
        RccVendedor rccVendedor1 = (RccVendedor) jCboFk_vendedor.getSelectedItem(); //pega o item selecionado
        rccVenda.setRccFkVendedor(rccVendedor1.getRccIdVendedor()); //e grava só a chave no BD   
        
        return rccVenda;
    };
    
    public void beanView(RccVenda rccVenda) { //do banco para a tela
        
        String valor = Util.intStr(rccVenda.getRccIdVenda()); //converte int para string (pelo Text)
        jTxtId_venda.setText(valor);
        
        jFmtData_venda.setText(Util.dateStr(rccVenda.getRccDataVenda()));
        jTxtFrete.setText(String.valueOf(rccVenda.getRccFrete()));
        jTxtValor_total.setText(Util.doubleStr(rccVenda.getRccValorTotal()));
        jTxtDescricao_itens.setText(rccVenda.getRccDescricaoItens());
        
        int id_cliente = rccVenda.getRccFkCliente();//trazer do BD o ID da PK
        cliente_DAO = new Cliente_DAO(); //usamos o DAO para acessar o list e então selecionar o ID
        jCboFk_cliente.setSelectedItem(cliente_DAO.list(id_cliente)); //passei o ID para o list e ele retorna um bean para a Cbo
        
        int id_vendedor = rccVenda.getRccFkVendedor(); //trazer do BD o ID da PK
        vendedor_DAO = new Vendedor_DAO(); //usamos o DAO para acessar o list e então selecionar o ID
        jCboFk_vendedor.setSelectedItem(vendedor_DAO.list(id_vendedor)); //passei o ID para o list e ele retorna um bean para a Cbo
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtnAlterarVd = new javax.swing.JButton();
        jBtnConfirmarVd = new javax.swing.JButton();
        jBtnExcluirVd = new javax.swing.JButton();
        jBtnCancelarVd = new javax.swing.JButton();
        jBtnPesquisarVd = new javax.swing.JButton();
        jBtnIncluirVd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTxtId_venda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jFmtData_venda = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtFrete = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtValor_total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtDescricao_itens = new javax.swing.JTextField();
        jCboFk_cliente = new javax.swing.JComboBox<RccCliente>();
        jCboFk_vendedor = new javax.swing.JComboBox<RccVendedor>();
        jChbAutomatico = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jBtnIncluirVp = new javax.swing.JButton();
        jBtnAlterarVp = new javax.swing.JButton();
        jBtnExcluirVp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnAlterarVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/editar-removebg-preview.png"))); // NOI18N
        jBtnAlterarVd.setText("Alterar");
        jBtnAlterarVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarVdActionPerformed(evt);
            }
        });

        jBtnConfirmarVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/confirmar-removebg-preview.png"))); // NOI18N
        jBtnConfirmarVd.setText("Confirmar");
        jBtnConfirmarVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarVdActionPerformed(evt);
            }
        });

        jBtnExcluirVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cancelar-removebg-preview.png"))); // NOI18N
        jBtnExcluirVd.setText("Excluir");
        jBtnExcluirVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirVdActionPerformed(evt);
            }
        });

        jBtnCancelarVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/recarregar fino (1).png"))); // NOI18N
        jBtnCancelarVd.setText("Cancelar");
        jBtnCancelarVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarVdActionPerformed(evt);
            }
        });

        jBtnPesquisarVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/busca-removebg-preview.png"))); // NOI18N
        jBtnPesquisarVd.setText("Pesquisar");
        jBtnPesquisarVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarVdActionPerformed(evt);
            }
        });

        jBtnIncluirVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/inserir-removebg-preview.png"))); // NOI18N
        jBtnIncluirVd.setText("Incluir");
        jBtnIncluirVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirVdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIncluirVd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterarVd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluirVd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jBtnConfirmarVd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancelarVd)
                .addGap(18, 18, 18)
                .addComponent(jBtnPesquisarVd)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAlterarVd)
                    .addComponent(jBtnPesquisarVd)
                    .addComponent(jBtnCancelarVd)
                    .addComponent(jBtnConfirmarVd)
                    .addComponent(jBtnExcluirVd)
                    .addComponent(jBtnIncluirVd))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 480, 680, 59);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor Uni."
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 148, 600, 315);
        getContentPane().add(jTxtId_venda);
        jTxtId_venda.setBounds(10, 28, 116, 20);

        jLabel1.setText("ID Venda");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 44, 14);
        getContentPane().add(jFmtData_venda);
        jFmtData_venda.setBounds(10, 76, 172, 20);

        jLabel2.setText("Data da Venda");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 56, 71, 14);

        jLabel4.setText("Cliente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(485, 56, 33, 14);

        jLabel5.setText("Vendedor");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(484, 102, 46, 14);
        getContentPane().add(jTxtFrete);
        jTxtFrete.setBounds(200, 76, 190, 20);

        jLabel6.setText("Frete");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 56, 26, 14);

        jLabel7.setText("Valor Total");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 102, 51, 14);
        getContentPane().add(jTxtValor_total);
        jTxtValor_total.setBounds(10, 122, 117, 20);

        jLabel8.setText("Descrição de Itens");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(133, 102, 89, 14);
        getContentPane().add(jTxtDescricao_itens);
        jTxtDescricao_itens.setBounds(133, 122, 257, 20);

        getContentPane().add(jCboFk_cliente);
        jCboFk_cliente.setBounds(485, 76, 207, 20);

        getContentPane().add(jCboFk_vendedor);
        jCboFk_vendedor.setBounds(485, 122, 207, 20);

        jChbAutomatico.setText("Automatico");
        jChbAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbAutomaticoActionPerformed(evt);
            }
        });
        getContentPane().add(jChbAutomatico);
        jChbAutomatico.setBounds(132, 27, 79, 23);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnIncluirVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/inserir-removebg-preview.png"))); // NOI18N
        jBtnIncluirVp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnIncluirVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirVpActionPerformed(evt);
            }
        });

        jBtnAlterarVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/editar-removebg-preview.png"))); // NOI18N
        jBtnAlterarVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarVpActionPerformed(evt);
            }
        });

        jBtnExcluirVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cancelar-removebg-preview.png"))); // NOI18N
        jBtnExcluirVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirVpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterarVp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnIncluirVp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnExcluirVp)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIncluirVp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterarVp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluirVp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(611, 148, 81, 315);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChbAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbAutomaticoActionPerformed
        // TODO add your handling code here:
        automatico();
    }//GEN-LAST:event_jChbAutomaticoActionPerformed

    private void jBtnIncluirVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirVdActionPerformed
        // TODO add your handling code here:
        incluindo = true;
        
        Util.habilitar(true, jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(false, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
        Util.limparCampos(jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        
    }//GEN-LAST:event_jBtnIncluirVdActionPerformed

    private void jBtnCancelarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarVdActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(true, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
        Util.limparCampos(jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        
        Util.mensagem("Ação cancelada.");
    }//GEN-LAST:event_jBtnCancelarVdActionPerformed

    private void jBtnAlterarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarVdActionPerformed
        // TODO add your handling code here:
        incluindo = false;
        
        Util.habilitar(true, jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(false, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
    }//GEN-LAST:event_jBtnAlterarVdActionPerformed

    private void jBtnConfirmarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarVdActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(true, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
        
        rccVenda = viewBean();
        venda_DAO = new Venda_DAO();
        
        if (incluindo == true) {
            venda_DAO.insert(rccVenda);
        }else {
            venda_DAO.update(rccVenda);
        }
        
        Util.limparCampos(jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
    }//GEN-LAST:event_jBtnConfirmarVdActionPerformed

    private void jBtnExcluirVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirVdActionPerformed
        // TODO add your handling code here:
        if (Util.perguntar("Deseja excluir o registro?") == true) {
            rccVenda = viewBean(); //declarou um obj Bean que recebeu viewBean
            venda_DAO.delete(rccVenda);
        }else {
            Util.mensagem("Operação de exclusão cancelada!");
        };
        
        Util.limparCampos(jTxtId_venda, jChbAutomatico, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
    }//GEN-LAST:event_jBtnExcluirVdActionPerformed

    private void jBtnPesquisarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarVdActionPerformed
        // TODO add your handling code here:
        jDlgVendaPesquisa = new JDlgVendaPesquisa(null, true);
        jDlgVendaPesquisa.setTelaAnterior(this); //a sua tela anterior sou eu - eu quem? o JDlgVenda!
        jDlgVendaPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarVdActionPerformed

    private void jBtnIncluirVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirVpActionPerformed
        // TODO add your handling code here:
        incluindo = true;
        
        jDlgVendaProduto = new JDlgVendaProduto(null, true);
        jDlgVendaProduto.setTelaAnterior(this); //a sua tela anterior sou eu - eu quem? o JDlgVenda!
        jDlgVendaProduto.setVisible(true);

    }//GEN-LAST:event_jBtnIncluirVpActionPerformed

    private void jBtnExcluirVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirVpActionPerformed
        // TODO add your handling code here:
        int rowSel = jTable1.getSelectedRow(); //pegar a linha selecionada
        
        if (Util.perguntar("Deseja excluir o registro?") == true) {
            rccVendaProduto = vendaProdutoControle.getBean(rowSel);
            vendedor_DAO.delete(rccVendaProduto);

        }else {
            Util.mensagem("Operação de exclusão cancelada!");
        };

    }//GEN-LAST:event_jBtnExcluirVpActionPerformed

    private void jBtnAlterarVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarVpActionPerformed
        // TODO add your handling code here:   
        incluindo = false;
        
        jDlgVendaProduto = new JDlgVendaProduto(null, true);
        jDlgVendaProduto.setTelaAnterior(this); //a sua tela anterior sou eu - eu quem? o JDlgVendaProduto!
        jDlgVendaProduto.setVisible(true);

    }//GEN-LAST:event_jBtnAlterarVpActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVenda dialog = new JDlgVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterarVd;
    private javax.swing.JButton jBtnAlterarVp;
    private javax.swing.JButton jBtnCancelarVd;
    private javax.swing.JButton jBtnConfirmarVd;
    private javax.swing.JButton jBtnExcluirVd;
    private javax.swing.JButton jBtnExcluirVp;
    private javax.swing.JButton jBtnIncluirVd;
    private javax.swing.JButton jBtnIncluirVp;
    private javax.swing.JButton jBtnPesquisarVd;
    private javax.swing.JComboBox<RccCliente> jCboFk_cliente;
    private javax.swing.JComboBox<RccVendedor> jCboFk_vendedor;
    private javax.swing.JCheckBox jChbAutomatico;
    private javax.swing.JFormattedTextField jFmtData_venda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtDescricao_itens;
    private javax.swing.JTextField jTxtFrete;
    private javax.swing.JTextField jTxtId_venda;
    private javax.swing.JTextField jTxtValor_total;
    // End of variables declaration//GEN-END:variables
}
