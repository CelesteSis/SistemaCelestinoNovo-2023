/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RccCliente;
import dao.Cliente_DAO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author u07540852100
 */
public class JDlgCliente extends javax.swing.JDialog {
    
    private boolean incluindo;
    MaskFormatter mascaraCpf; //
    MaskFormatter mascaraRg;
    MaskFormatter mascaraNascimento;
    MaskFormatter mascaraCelular;
    MaskFormatter mascaraCep;
    
    public RccCliente rccCliente; //atributo global da classe
    public Cliente_DAO cliente_DAO;

    /**
     * Creates new form JDlgCliente
     */
    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Util.habilitar(false, jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        setSize(900, 750);
        setTitle("Cadastro de Cliente");
        setLocationRelativeTo(null);
        
        cliente_DAO = new Cliente_DAO(); 
        
        try { //fechar a instrução com o Try Catch
            mascaraCpf = new MaskFormatter("###.###.###-##"); //("###.###.###-##")
            mascaraRg = new MaskFormatter("#.###.###"); //("#.###.###")
            mascaraNascimento = new MaskFormatter("##/##/####"); //("##/##/####")
            mascaraCelular = new MaskFormatter("(##)#####-####"); //("(##)#####-####")
            mascaraCep = new MaskFormatter("#####-###"); //("#####-###")
            
        } catch (ParseException ex) { 
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level. SEVERE, null, ex); 
        }
        
        jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf)); //mascara instanciada e no campo
        jFmtRg.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
        jFmtNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraNascimento));
        jFmtCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraCelular));
        jFmtCep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
    }
    
    public void automatico() { 
    jTxtId_cliente.setEnabled(false);
    };
    
    public RccCliente viewBean() { //método para pegar da tela e jogar no bean
        rccCliente = new RccCliente(); //criando o bean
        
        int id = Util.strInt(jTxtId_cliente.getText());
        rccCliente.setRccIdCliente(id);
        
        rccCliente.setRccNome(jTxtNome.getText());
        rccCliente.setRccApelido(jTxtApelido.getText());
        rccCliente.setRccSexo(jTxtSexo.getText());
        rccCliente.setRccCpf(jFmtCpf.getText());
        rccCliente.setRccRg(jFmtRg.getText());
        rccCliente.setRccNascimento(Util.strDate(jFmtNascimento.getText()));
        rccCliente.setRccEmail(jTxtEmail.getText());
        rccCliente.setRccTelefone(jTxtTelefone.getText());
        rccCliente.setRccCelular(jFmtCelular.getText());
        rccCliente.setRccUf(jFmtUf.getText());
        rccCliente.setRccCep(jFmtCep.getText());
        rccCliente.setRccCidade(jTxtCidade.getText());
        rccCliente.setRccBairro(jTxtBairro.getText());
        rccCliente.setRccEndereco(jTxtEndereco.getText());
        rccCliente.setRccSenha(jPwfSenha.getText());
        rccCliente.setRccConfirmeSenha(jPwfConfirme_senha.getText());
        
        return rccCliente;
    };
    
    public void beanView(RccCliente rccCliente) { //do banco/bean para a tela
        
        String valor = Util.intStr(rccCliente.getRccIdCliente()); //converte int para string (pelo Text)
        jTxtId_cliente.setText(valor);
        
        jTxtNome.setText(rccCliente.getRccNome());
        jTxtApelido.setText(rccCliente.getRccApelido());
        jTxtSexo.setText(rccCliente.getRccSexo());
        jFmtCpf.setText(rccCliente.getRccCpf());
        jFmtRg.setText(rccCliente.getRccRg());
        jFmtNascimento.setText(Util.dateStr(rccCliente.getRccNascimento()));
        jTxtEmail.setText(rccCliente.getRccEmail());
        jTxtTelefone.setText(rccCliente.getRccTelefone());
        jFmtCelular.setText(rccCliente.getRccCelular());
        jFmtUf.setText(rccCliente.getRccUf());
        jFmtCep.setText(rccCliente.getRccCep());
        jTxtCidade.setText(rccCliente.getRccCidade());
        jTxtBairro.setText(rccCliente.getRccBairro());
        jTxtEndereco.setText(rccCliente.getRccEndereco());
        jPwfSenha.setText(rccCliente.getRccSenha());
        jPwfConfirme_senha.setText(rccCliente.getRccConfirmeSenha());       
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jFmtNascimento = new javax.swing.JFormattedTextField();
        jFmtUf = new javax.swing.JFormattedTextField();
        jFmtCep = new javax.swing.JFormattedTextField();
        jTxtId_cliente = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jTxtSexo = new javax.swing.JTextField();
        jTxtEmail = new javax.swing.JTextField();
        jTxtApelido = new javax.swing.JTextField();
        jTxtTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jChbAutomatico = new javax.swing.JCheckBox();
        jTxtEndereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPwfConfirme_senha = new javax.swing.JPasswordField();
        jPwfSenha = new javax.swing.JPasswordField();
        jFmtCelular = new javax.swing.JFormattedTextField();
        jFmtRg = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID Cliente");

        jLabel2.setText("Nome");

        jLabel3.setText("Apelido");

        jLabel4.setText("CPF");

        jLabel5.setText("RG");

        jLabel6.setText("Sexo");

        jLabel7.setText("Nascimento");

        jLabel8.setText("Email");

        jLabel9.setText("Telefone");

        jLabel10.setText("Celular");

        jLabel11.setText("UF");

        jLabel12.setText("Cidade");

        jLabel13.setText("CEP");

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

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/recarregar fino (1).png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_certo/busca-removebg-preview.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jChbAutomatico.setText("Automático");
        jChbAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbAutomaticoActionPerformed(evt);
            }
        });

        jLabel14.setText("Bairro");

        jLabel15.setText("Endereço");

        jLabel16.setText("Senha");

        jLabel17.setText("Confirme a senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(93, 93, 93))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTxtCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 560, Short.MAX_VALUE))
                                    .addComponent(jTxtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtBairro, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jFmtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFmtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTxtId_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jChbAutomatico))
                                .addComponent(jTxtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(221, 221, 221)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jFmtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jFmtRg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTxtEndereco)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jBtnPesquisar)
                                .addGap(23, 23, 23))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPwfConfirme_senha)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtId_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbAutomatico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFmtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPwfConfirme_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        
        incluindo = true;
        
        Util.limparCampos(jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha);
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        
        rccCliente = viewBean();
        cliente_DAO = new Cliente_DAO();
        
        if (incluindo == true) {
            cliente_DAO.insert(rccCliente);
        }else {
            cliente_DAO.update(rccCliente);
        }
        
        Util.limparCampos(jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha);
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        
        Util.mensagem("Ação cancelada.");
        
        Util.limparCampos(jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jChbAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbAutomaticoActionPerformed
        // TODO add your handling code here:
        automatico();
    }//GEN-LAST:event_jChbAutomaticoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        if (Util.perguntar("Deseja excluir o registro?") == true) {
            rccCliente = viewBean(); //declarou um obj Bean que recebeu viewBean
            cliente_DAO.delete(rccCliente);
        }else {
            Util.mensagem("Operação de exclusão cancelada!");
        };
        
        Util.limparCampos(jTxtId_cliente, jChbAutomatico, jTxtNome, jTxtApelido, jFmtCpf, jFmtRg, jTxtSexo, jFmtNascimento, jTxtEmail, jTxtCidade, jFmtUf, jTxtBairro, jTxtEndereco,jPwfSenha, jPwfConfirme_senha);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        JDlgClientePesquisa jDlgClientePesquisa = new JDlgClientePesquisa(null, true);
        jDlgClientePesquisa.setTelaAnterior(this); //a sua tela anterior sou eu - eu quem? o JDlgCliente!
        jDlgClientePesquisa.setVisible(true);
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
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox jChbAutomatico;
    private javax.swing.JFormattedTextField jFmtCelular;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtNascimento;
    private javax.swing.JFormattedTextField jFmtRg;
    private javax.swing.JFormattedTextField jFmtUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPwfConfirme_senha;
    private javax.swing.JPasswordField jPwfSenha;
    private javax.swing.JTextField jTxtApelido;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtId_cliente;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtSexo;
    private javax.swing.JTextField jTxtTelefone;
    // End of variables declaration//GEN-END:variables
}
