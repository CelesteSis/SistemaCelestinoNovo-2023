/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RccCliente;
import bean.RccVenda;
import bean.RccVendaProduto;
import bean.RccVendedor;
import bean.VendaProdutoController;
import dao.Cliente_DAO; //usado para lista da Fk_cliente
import dao.Venda_DAO;
import dao.Venda_produto_DAO;
import dao.Vendedor_DAO;  //usado para lista da Fk_vendedor
import dao.Produto_DAO; 
import java.text.ParseException;
import java.util.ArrayList;
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
    private RccCliente rccCliente;
    private RccVendaProduto rccVendaProduto;
    private JDlgVendaProduto jDlgVendaProduto;
    private JDlgVendaPesquisa jDlgVendaPesquisa;
    private Cliente_DAO cliente_DAO;
    private Vendedor_DAO vendedor_DAO;
    private Produto_DAO produto_DAO;
    private Venda_produto_DAO venda_produto_DAO;
    private Venda_DAO venda_DAO;
    
    public VendaProdutoController vendaProdutoController;

    /**
     * Creates new form JDlgVenda
     */
    public JDlgVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Util.habilitar(false, jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(true, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        Util.limparCampos(jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        setSize(720, 600);
        setTitle("Vendas");
        setLocationRelativeTo(null);
        
        cliente_DAO = new Cliente_DAO();
        vendedor_DAO = new Vendedor_DAO();
        venda_produto_DAO = new Venda_produto_DAO();
        produto_DAO = new Produto_DAO();
        vendaProdutoController = new VendaProdutoController();
        venda_DAO = new Venda_DAO();
        rccVenda = new RccVenda();
        rccCliente = new RccCliente();
        
        
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
        vendaProdutoController.setList(new ArrayList());
        jTable1.setModel(vendaProdutoController); 
    }
    
    public void setTelaAnterior(JDlgVendaProduto jDlgVendaProduto){//método para se conectar com a tela de cadastro de Usuario 
        this.jDlgVendaProduto = jDlgVendaProduto; //agora ela sabe que ela é ela msm e a outra é a outra
    }
    
    public RccVenda viewBean() { //método para pegar da tela e jogar no bean
        rccVenda = new RccVenda(); //criando o bean
        
        int id = Util.strInt(jTxtId_venda.getText());
        rccVenda.setRccIdVenda(id);
        
        rccVenda.setRccDataVenda(Util.strDate(jFmtData_venda.getText()));
        rccVenda.setRccFrete(Util.strDouble(jTxtFrete.getText()));
        rccVenda.setRccValorTotal(Util.strDouble(jTxtValor_total.getText()));
        rccVenda.setRccDescricaoItens(jTxtDescricao_itens.getText());
        
        rccVenda.setRccCliente((RccCliente) jCboFk_cliente.getSelectedItem());
        rccVenda.setRccVendedor((RccVendedor) jCboFk_vendedor.getSelectedItem());
        
        return rccVenda;
    };
    
    public void beanView(RccVenda rccVenda) { //do banco para a tela
        
        String valor = Util.intStr(rccVenda.getRccIdVenda()); //converte int para string (pelo Text)
        jTxtId_venda.setText(valor);
        
        jFmtData_venda.setText(Util.dateStr(rccVenda.getRccDataVenda()));
        jTxtFrete.setText(String.valueOf(rccVenda.getRccFrete()));
        jTxtValor_total.setText(Util.doubleStr(rccVenda.getRccValorTotal()));
        jTxtDescricao_itens.setText(rccVenda.getRccDescricaoItens());
        
        jCboFk_cliente.setSelectedItem(rccVenda.getRccCliente());
        jCboFk_vendedor.setSelectedItem(rccVenda.getRccVendedor());

    };
    
    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    }
    
//    public void beanViewVP(RccVendaProduto rccVendaProduto) { //do banco para a tela
//        
//        String valor = Util.intStr(rccVendaProduto.getRccIdVendaProduto()); //converte int para string (pelo Text)
//        jTxtId_venda.setText(valor);
//        
//        int id_produto = rccVendaProduto.getRccFkProduto();//trazer do BD o ID da PK
//        produto_DAO = new Produto_DAO(); //usamos o DAO para acessar o list e então selecionar o ID
//        jCboFk_cliente.setSelectedItem(produto_DAO.list(id_produto)); //passei o ID para o list e ele retorna um bean para a Cbo
//        
//        int id_venda = rccVendaProduto.getRccFkVenda(); //trazer do BD o ID da PK
//        venda_produto_DAO = new Venda_produto_DAO();//usamos o DAO para acessar o list e então selecionar o ID
//            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
//                rccVendaProduto = vendaProdutoController.getBean(linha);
//                rccVendaProduto.
//                venda_produto_DAO.listaProduto();
//        jTable1.setValueAt(venda_DAO.list(id_venda)); //passei o ID para o list e ele retorna um bean para a Table
//        
//        
//                List lista = venda_produto_DAO.listaProduto(rccVenda); 
//                usuarioController.setList(lista);
//    };

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
                "", "", ""
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
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

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnIncluirVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/inserir-removebg-preview.png"))); // NOI18N
        jBtnIncluirVp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnIncluirVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirVpActionPerformed(evt);
            }
        });

        jBtnAlterarVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/editar-removebg-preview.png"))); // NOI18N
        jBtnAlterarVp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAlterarVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarVpActionPerformed(evt);
            }
        });

        jBtnExcluirVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/cancelar-removebg-preview.png"))); // NOI18N
        jBtnExcluirVp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                    .addComponent(jBtnIncluirVp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jBtnExcluirVp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jBtnIncluirVp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterarVp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluirVp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(611, 148, 81, 315);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirVdActionPerformed
        // TODO add your handling code here:
        incluindo = true;
        Util.limparCampos(jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        Util.habilitar(true, jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(false, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
        vendaProdutoController.setList(new ArrayList());
        jTxtId_venda.grabFocus();
        rccVenda = new RccVenda();
        
    }//GEN-LAST:event_jBtnIncluirVdActionPerformed

    private void jBtnCancelarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarVdActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(true, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
        Util.limparCampos(jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        
        Util.mensagem("Ação cancelada.");
    }//GEN-LAST:event_jBtnCancelarVdActionPerformed

    private void jBtnAlterarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarVdActionPerformed
        // TODO add your handling code here:
        if (rccVenda != null) {
            
            Util.habilitar(true, jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
            Util.habilitar(false, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
            incluindo = false;
            
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
        
    }//GEN-LAST:event_jBtnAlterarVdActionPerformed

    private void jBtnConfirmarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarVdActionPerformed
        // TODO add your handling code here:
        rccVenda = viewBean();
        if (incluindo == true) {
            venda_DAO.insert(rccVenda);
            Venda_produto_DAO venda_produto_DAO1 = new Venda_produto_DAO();
            RccVendaProduto rccVendaProduto1;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                rccVendaProduto1 = vendaProdutoController.getBean(linha);
                rccVendaProduto1.setRccVenda(rccVenda);
                venda_produto_DAO1.insert(rccVendaProduto1);
            }
        } else {
            venda_DAO.update(rccVenda);
            //remover todos os pedidos produtos deste pedido
            Venda_produto_DAO venda_produto_DAO1 = new Venda_produto_DAO(); 
            RccVendaProduto rccVendaProduto1;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                rccVendaProduto1 = vendaProdutoController.getBean(linha);
                venda_produto_DAO1.delete(rccVendaProduto1);
            }

            //incluir todos os pedidosProduto que estao no jtable
            Venda_produto_DAO venda_produto_DAO2 = new Venda_produto_DAO();
            RccVendaProduto rccVendaProduto2;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                rccVendaProduto2 = vendaProdutoController.getBean(linha);
                rccVendaProduto2.setRccVenda(rccVenda);
                venda_produto_DAO2.insert(rccVendaProduto2);
            }
        }
        Util.habilitar(false, jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1, jBtnIncluirVp, jBtnAlterarVp, jBtnExcluirVp);
        Util.habilitar(true, jBtnIncluirVd, jBtnAlterarVd, jBtnExcluirVd, jBtnPesquisarVd);
        
        Util.limparCampos(jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        vendaProdutoController.setList(new ArrayList());

        rccVenda = null;
        
    }//GEN-LAST:event_jBtnConfirmarVdActionPerformed

    private void jBtnExcluirVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirVdActionPerformed
        // TODO add your handling code here:
        if (rccVenda != null) {
            if (Util.perguntar("Deseja excluir o pedido ?") == true) {
                Venda_produto_DAO venda_produto_DAO1 = new Venda_produto_DAO();
                
                RccVendaProduto rccVendaProduto1;
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    rccVendaProduto1 = vendaProdutoController.getBean(linha);
                    venda_produto_DAO1.delete(rccVendaProduto1);
                }
                
                venda_DAO.delete(rccVenda);
            }
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
        
        Util.limparCampos(jTxtId_venda, jFmtData_venda, jTxtFrete, jTxtValor_total, jTxtDescricao_itens, jCboFk_cliente, jCboFk_vendedor, jBtnConfirmarVd, jBtnCancelarVd, jTable1);
        rccVenda = null;
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
        jDlgVendaProduto.setTitle("Inclusão de Produtos");
        jDlgVendaProduto.setTelaAnterior(this); //a sua tela anterior sou eu - eu quem? o JDlgVenda!
        jDlgVendaProduto.setVisible(true);

    }//GEN-LAST:event_jBtnIncluirVpActionPerformed

    private void jBtnExcluirVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirVpActionPerformed
        // TODO add your handling code here:
        int rowSel = jTable1.getSelectedRow(); //pegar a linha selecionada
        
        if (rowSel == -1) {
            Util.mensagem("Nenhuma linha foi selecionada.");
        }else {
            if(Util.perguntar("Deseja excluir o registro?") == true) {
                vendaProdutoController.removeBean(rowSel);
            };
        };

    }//GEN-LAST:event_jBtnExcluirVpActionPerformed

    private void jBtnAlterarVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarVpActionPerformed
        // TODO add your handling code here:   
        incluindo = false;
        
        int rowSel = jTable1.getSelectedRow(); //pegar a linha selecionada
        if (rowSel == -1) {
            Util.mensagem("Nenhuma linha foi selecionada.");
        }else {
            jDlgVendaProduto = new JDlgVendaProduto(null, true);
            jDlgVendaProduto.setTitle("Alteração de Produtos");
            jDlgVendaProduto.setTelaAnterior(this); 
            
            RccVendaProduto VendaProduto = (RccVendaProduto) vendaProdutoController.getBean(rowSel);
            jDlgVendaProduto.beanView(VendaProduto);
            
//            //cbo com o bean a ser modificado
//            int id_produto = rccVendaProduto.getRccFkProduto();//trazer do BD o ID da PK
//            produto_DAO = new Produto_DAO(); //usamos o DAO para acessar o list e então selecionar o ID
//            jDlgVendaProduto.setCbo(produto_DAO.list(id_produto)); //passei o ID para o list e ele retorna um bean para a Cbo
//            
            jDlgVendaProduto.setVisible(true);
        };
        
        
    }//GEN-LAST:event_jBtnAlterarVpActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
//        if (jTable1.getAutoCreateRowSorter() == false) {
//            double valor_uni = Util.strDouble(jTxtValor_uni.getText());
//            double quant = Util.strDouble(jTxtQuantidade.getText());
//            jTxtValor_total.setText(String.valueOf(quant * valor_uni));
//        } else {
//            jTxtValor_total.setText("0");
//        }
//        
//        List listVP = venda_produto_DAO.listALL();
//        for (int i = 0; i < listVP.size(); i++ ) {
//            jCboFk_vendedor.Item((RccVendedor) listVendedor.get(i));
//        }
    }//GEN-LAST:event_jTable1KeyPressed

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
