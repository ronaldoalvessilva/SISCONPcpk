/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.visao;

import br.com.sisconpcpk.dao.ConectaBanco;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.descricaoUnidade;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.idUserAcesso;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.nameUser;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class FormPrincipal extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco();

    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); // HORAIO DE 24 HORAS, PARA O DE 12 HORAS UTILIZAR hh:mm:ss
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");

    public static TelaTrocaSenha telaTrocaSenhaCPK;

    private TelaConfereInternos objConfere = null;
    private TelaPagamentoKitInternoCPK objPagto = null;
    private TelaConsultaLocalInternoSegurancaCPK objLocal = null;
    private TelaCadastroDatiloscopia cadBio = null;
    //
    // VARIAVEIS PARA PERMISSÃO DE USUÁRIOS NOS MÓDULOS
    String loginUsusario = "ADMINISTRADOR DO SISTEMA";
    String nomeUsuario = "";
    String nomeGrupo = "";
    //GRUPO DE ADMINISTRADORES E DIRETORORES
    public static String grupoAdministrador = "ADMINISTRADORES";
    public static String grupoDiretores = "DIRETORES"; // AINDA NÃO FOI CRIADO A FUNCIONALIDADE (16/07/2016)
    String nomeModulo = "";
    String permissaoModulo = "";
    int idGrupo;
    int idModulo;
    int idGrupoModulo;
    // TRIAGEM
    public static String telaEntregaMaterialUsoTRI = "Movimentação:Entrega de Material Uso Pessoal:Manutenção";
    public static String telaEntregaMaterialUsoInternosTRI = "Movimentação:Entrega de Material Uso Pessoal:Internos";
    public static String telaEntregaMaterialUsoInternosBioTRI = "Movimentação:Entrega de Material Uso Pessoal:Biometria";
    public static String telaInicializarLeitorTRI = "Movimentação:Entrega de Material Uso Pessoal:Inicializar leitor";
    //BASE I
    public static String telaEntregaMaterialUsoB1 = "Movimentação:Entrega de Material Uso Pessoal:Manutenção-B1";
    public static String telaEntregaMaterialUsoInternosB1 = "Movimentação:Entrega de Material Uso Pessoal:Internos-B1";
    public static String telaEntregaMaterialUsoInternosBioB1 = "Movimentação:Entrega de Material Uso Pessoal:Biometria-B1";
    public static String telaInicializarLeitorB1 = "Movimentação:Entrega de Material Uso Pessoal:Inicializar leitor-B1";
    //BASE II
    public static String telaEntregaMaterialUsoB2 = "Movimentação:Entrega de Material Uso Pessoal:Manutenção-B2";
    public static String telaEntregaMaterialUsoInternosB2 = "Movimentação:Entrega de Material Uso Pessoal:Internos-B2";
    public static String telaEntregaMaterialUsoInternosBioB2 = "Movimentação:Entrega de Material Uso Pessoal:Biometria-B2";
    //    
    public static int codigoUserTRI = 0;
    public static int codUserAcessoTRI = 0;
    public static int codigoUserGroupTRI = 0;
    public static int codAbrirTRI = 0;
    public static int codIncluirTRI = 0;
    public static int codAlterarTRI = 0;
    public static int codExcluirTRI = 0;
    public static int codGravarTRI = 0;
    public static int codConcultarTRI = 0;
    public static int codigoGrupoTRI = 0;
    public static String nomeGrupoTRI = "";
    public static String nomeTelaTRI = "";
    // TELAS DE ACESSOS AO MÓDULO CRC
    public static String nomeModuloTRIAGEM = "TRIAGEM";
    //BASE I
    public static int codigoUserB1 = 0;
    public static int codUserAcessoB1 = 0;
    public static int codigoUserGroupB1 = 0;
    public static int codAbrirB1 = 0;
    public static int codIncluirB1 = 0;
    public static int codAlterarB1 = 0;
    public static int codExcluirB1 = 0;
    public static int codGravarB1 = 0;
    public static int codConsultarB1 = 0;
    public static int codigoGrupoB1 = 0;
    public static String nomeGrupoB1 = "";
    public static String nomeTelaB1 = "";
    // TELAS DE ACESSOS AO MÓDULO ENFERMARIA
    int pCodModulo = 0; // VARIÁVEL PARA PESQUISAR CÓDIGO DO MÓDULO
    public static String nomeModuloB1 = "BASE PAVILHAO UM";
    //BASE II
    public static int codigoUserB2 = 0;
    public static int codUserAcessoB2 = 0;
    public static int codigoUserGroupB2 = 0;
    public static int codAbrirB2 = 0;
    public static int codIncluirB2 = 0;
    public static int codAlterarB2 = 0;
    public static int codExcluirB2 = 0;
    public static int codGravarB2 = 0;
    public static int codConsultarB2 = 0;
    public static int codigoGrupoB2 = 0;
    public static String nomeGrupoB2 = "";
    public static String nomeTelaB2 = "";
    // TELAS DE ACESSOS AO MÓDULO ENFERMARIA    
    public static String nomeModuloB2 = "BASE PAVILHAO DOIS";
    //
    public static String tipoServidor = "";
    public static String tipoBancoDados = "";

    /**
     * Creates new form FormPrincipal
     *
     */
    public FormPrincipal() {

        initComponents();
        // NOME DA UNIDADE ONDE O SISTEMA ESTA ATUANDO, IRÁ PARA OS RELATÓRIOS TAMBÉM.
        jNomeUnidade.setText(descricaoUnidade);
        jLoginConectado.setText(nameUser);
        setExtendedState(MAXIMIZED_BOTH); // Maximnizar a tela prinicpal
        Thread threadRelogio = new Thread() {

            @Override
            public void run() {
                rodaRelogio();
            }
        };
        threadRelogio.start();
        Date data = new Date();
        String hora = formatter.format(data); // Data da conexão
        String date = formatter2.format(data); // Hora da conexão
        jHoraSistema.setText(String.valueOf(hora));    // no lugar do label, por seu JTextField    
        jDataSistema.setText(String.valueOf(date));
        // VERIFICAR PARAMETRO PARA SABER SE O OS É LINUX(UBUNTU) OU WINDOWS.     
        verificarParametrosSRV();
        //     
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X    
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do Sistema?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    public void mostrarTelaTrocaSenha() {
        telaTrocaSenhaCPK = new TelaTrocaSenha(this, true);
        telaTrocaSenhaCPK.setVisible(true);
    }

    public void rodaRelogio() {
        try {
            while (true) {
                Date data = new Date();
                String hora = formatter.format(data);
                String date = formatter2.format(data);
                jHoraSistema.setText(String.valueOf(hora));    // no lugar do label, por seu JTextField    
                jDataSistema.setText(String.valueOf(date));
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
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

        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jHoraSistema = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeUnidade = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jLoginConectado = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        jDataSistema = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBtTrocarSenha = new javax.swing.JButton();
        jBtLogoff = new javax.swing.JButton();
        jBtSairSistema = new javax.swing.JButton();
        jPainelPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtConfere = new javax.swing.JButton();
        jBtPagamentoKit = new javax.swing.JButton();
        jBtLocalizacaoInterno = new javax.swing.JButton();
        jBtCadastroBiometria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("SISCONP - Sistema de Controle Prisional ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Hora:");

        jHoraSistema.setEditable(false);
        jHoraSistema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Versão: 5.9");

        jNomeUnidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jNomeUnidade.setForeground(new java.awt.Color(0, 153, 0));
        jNomeUnidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Divisão de Segurança - Controle de Pagamento de Kit e Confere de Internos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jHoraSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jHoraSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25))
        );

        jToolBar1.setRollover(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usuário:");
        jToolBar1.add(jLabel3);

        jToolBar2.setRollover(true);

        jLoginConectado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLoginConectado.setText("jLabel6");
        jToolBar2.add(jLoginConectado);

        jToolBar4.setRollover(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data:  ");
        jToolBar4.add(jLabel5);

        jToolBar3.setRollover(true);

        jDataSistema.setEditable(false);
        jDataSistema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToolBar3.add(jDataSistema);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtTrocarSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTrocarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Button_Refresh_Icon_32.png"))); // NOI18N
        jBtTrocarSenha.setText("Trocar Senha");
        jBtTrocarSenha.setToolTipText("Trocar Senha");
        jBtTrocarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTrocarSenhaActionPerformed(evt);
            }
        });

        jBtLogoff.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/refresh-reload-icone-6258-32.png"))); // NOI18N
        jBtLogoff.setText("Logoff");
        jBtLogoff.setToolTipText("Fazer logoff");
        jBtLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLogoffActionPerformed(evt);
            }
        });

        jBtSairSistema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSairSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSairSistema.setText("Sair");
        jBtSairSistema.setToolTipText("Sair do Sistema");
        jBtSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtTrocarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtSairSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtTrocarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLogoff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSistema)
                .addContainerGap())
        );

        jPainelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/SISCONP 2.gif"))); // NOI18N

        jPainelPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPrincipalLayout = new javax.swing.GroupLayout(jPainelPrincipal);
        jPainelPrincipal.setLayout(jPainelPrincipalLayout);
        jPainelPrincipalLayout.setHorizontalGroup(
            jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPainelPrincipalLayout.setVerticalGroup(
            jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtConfere.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/gthumb-icone-9196-48.png"))); // NOI18N
        jBtConfere.setText("Confere Internos");
        jBtConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfereActionPerformed(evt);
            }
        });

        jBtPagamentoKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPagamentoKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Full_shopping_cart_Icon_48.png"))); // NOI18N
        jBtPagamentoKit.setText("Pagamento Kit");
        jBtPagamentoKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPagamentoKitActionPerformed(evt);
            }
        });

        jBtLocalizacaoInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtLocalizacaoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/11985_32x32.png"))); // NOI18N
        jBtLocalizacaoInterno.setText("Local Internos");
        jBtLocalizacaoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLocalizacaoInternoActionPerformed(evt);
            }
        });

        jBtCadastroBiometria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtCadastroBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Biometria42Vermelho.png"))); // NOI18N
        jBtCadastroBiometria.setText("Cadastrar Biometria");
        jBtCadastroBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastroBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtPagamentoKit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtConfere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtLocalizacaoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jBtCadastroBiometria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCadastroBiometria, jBtConfere, jBtLocalizacaoInterno, jBtPagamentoKit});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtCadastroBiometria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtConfere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPagamentoKit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLocalizacaoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCadastroBiometria, jBtConfere, jBtLocalizacaoInterno, jBtPagamentoKit});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPainelPrincipal)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPainelPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtTrocarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTrocarSenhaActionPerformed
        // TODO add your handling code here:
        mostrarTelaTrocaSenha();
    }//GEN-LAST:event_jBtTrocarSenhaActionPerformed

    private void jBtLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLogoffActionPerformed
        // Sair e voltar para troca de usuário
        dispose();
        TelaLoginSenhaCPK tls = new TelaLoginSenhaCPK(this, true);
        tls.setVisible(true);
    }//GEN-LAST:event_jBtLogoffActionPerformed

    private void jBtSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSistemaActionPerformed
        // TODO add your handling code here:       
        System.exit(0);
    }//GEN-LAST:event_jBtSairSistemaActionPerformed

    private void jBtConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfereActionPerformed
        // TODO add your handling code here:
        String grupoAlm = "SEGURANCA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoAlm = "Sim";
        String moduloAlm = "SEGURANCA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            if (objConfere == null || objConfere.isClosed()) {
                objConfere = new TelaConfereInternos();
                jPainelPrincipal.add(objConfere);
                objConfere.setVisible(true);
            } else {
                if (objConfere.isVisible()) {
                    if (objConfere.isIcon()) { // Se esta minimizado
                        try {
                            objConfere.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objConfere.toFront(); // traz para frente
                        objConfere.pack();//volta frame 
                    }
                } else {
                    objConfere = new TelaConfereInternos();
                    jPainelPrincipal.add(objConfere);//adicona frame ao JDesktopPane  
                    objConfere.setVisible(true);
                }
            }
            try {
                objConfere.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                if (objConfere == null || objConfere.isClosed()) {
                    objConfere = new TelaConfereInternos();
                    jPainelPrincipal.add(objConfere);
                    objConfere.setVisible(true);
                } else {
                    if (objConfere.isVisible()) {
                        if (objConfere.isIcon()) { // Se esta minimizado
                            try {
                                objConfere.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objConfere.toFront(); // traz para frente
                            objConfere.pack();//volta frame 
                        }
                    } else {
                        objConfere = new TelaConfereInternos();
                        jPainelPrincipal.add(objConfere);//adicona frame ao JDesktopPane  
                        objConfere.setVisible(true);
                    }
                }
                try {
                    objConfere.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }

            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAlm + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloAlm + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoAlm)) {
                    if (objConfere == null || objConfere.isClosed()) {
                        objConfere = new TelaConfereInternos();
                        jPainelPrincipal.add(objConfere);
                        objConfere.setVisible(true);
                    } else {
                        if (objConfere.isVisible()) {
                            if (objConfere.isIcon()) { // Se esta minimizado
                                try {
                                    objConfere.setIcon(false); // maximiniza
                                } catch (PropertyVetoException ex) {
                                }
                            } else {
                                objConfere.toFront(); // traz para frente
                                objConfere.pack();//volta frame 
                            }
                        } else {
                            objConfere = new TelaConfereInternos();
                            jPainelPrincipal.add(objConfere);//adicona frame ao JDesktopPane  
                            objConfere.setVisible(true);
                        }
                    }
                    try {
                        objConfere.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtConfereActionPerformed

    private void jBtPagamentoKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPagamentoKitActionPerformed
        // TODO add your handling code here:
        String grupoSeg = "SEGURANCA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoSeg = "Sim";
        String moduloSeg = "SEGURANCA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            if (objPagto == null || objPagto.isClosed()) {
                objPagto = new TelaPagamentoKitInternoCPK();
                jPainelPrincipal.add(objPagto);
                objPagto.setVisible(true);
            } else {
                if (objPagto.isVisible()) {
                    if (objPagto.isIcon()) { // Se esta minimizado
                        try {
                            objPagto.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objPagto.toFront(); // traz para frente
                        objPagto.pack();//volta frame 
                    }
                } else {
                    objPagto = new TelaPagamentoKitInternoCPK();
                    jPainelPrincipal.add(objPagto);//adicona frame ao JDesktopPane  
                    objPagto.setVisible(true);
                }
            }
            try {
                objPagto.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                if (objPagto == null || objPagto.isClosed()) {
                    objPagto = new TelaPagamentoKitInternoCPK();
                    jPainelPrincipal.add(objPagto);
                    objPagto.setVisible(true);
                } else {
                    if (objPagto.isVisible()) {
                        if (objPagto.isIcon()) { // Se esta minimizado
                            try {
                                objPagto.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objPagto.toFront(); // traz para frente
                            objPagto.pack();//volta frame 
                        }
                    } else {
                        objPagto = new TelaPagamentoKitInternoCPK();
                        jPainelPrincipal.add(objPagto);//adicona frame ao JDesktopPane  
                        objPagto.setVisible(true);
                    }
                }
                try {
                    objPagto.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoSeg + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloSeg + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoSeg)) {
                    if (objPagto == null || objPagto.isClosed()) {
                        objPagto = new TelaPagamentoKitInternoCPK();
                        jPainelPrincipal.add(objPagto);
                        objPagto.setVisible(true);
                    } else {
                        if (objPagto.isVisible()) {
                            if (objPagto.isIcon()) { // Se esta minimizado
                                try {
                                    objPagto.setIcon(false); // maximiniza
                                } catch (PropertyVetoException ex) {
                                }
                            } else {
                                objPagto.toFront(); // traz para frente
                                objPagto.pack();//volta frame 
                            }
                        } else {
                            objPagto = new TelaPagamentoKitInternoCPK();
                            jPainelPrincipal.add(objPagto);//adicona frame ao JDesktopPane  
                            objPagto.setVisible(true);
                        }
                    }
                    try {
                        objPagto.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPagamentoKitActionPerformed

    private void jBtLocalizacaoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLocalizacaoInternoActionPerformed
        // TODO add your handling code here:
        String grupoSeg = "PAGAMENTO KIT TABLET";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoSeg = "Sim";
        String moduloSeg = "PAGAMENTO KIT TABLET";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            if (objLocal == null || objLocal.isClosed()) {
                objLocal = new TelaConsultaLocalInternoSegurancaCPK();
                jPainelPrincipal.add(objLocal);
                objLocal.setVisible(true);
            } else {
                if (objLocal.isVisible()) {
                    if (objLocal.isIcon()) { // Se esta minimizado
                        try {
                            objLocal.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        objLocal.toFront(); // traz para frente
                        objLocal.pack();//volta frame 
                    }
                } else {
                    objLocal = new TelaConsultaLocalInternoSegurancaCPK();
                    jPainelPrincipal.add(objLocal);//adicona frame ao JDesktopPane  
                    objLocal.setVisible(true);
                }
            }
            try {
                objLocal.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                if (objLocal == null || objLocal.isClosed()) {
                    objLocal = new TelaConsultaLocalInternoSegurancaCPK();
                    jPainelPrincipal.add(objLocal);
                    objLocal.setVisible(true);
                } else {
                    if (objLocal.isVisible()) {
                        if (objLocal.isIcon()) { // Se esta minimizado
                            try {
                                objLocal.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objLocal.toFront(); // traz para frente
                            objLocal.pack();//volta frame 
                        }
                    } else {
                        objLocal = new TelaConsultaLocalInternoSegurancaCPK();
                        jPainelPrincipal.add(objLocal);//adicona frame ao JDesktopPane  
                        objLocal.setVisible(true);
                    }
                }
                try {
                    objLocal.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoSeg + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloSeg + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoSeg)) {
                    if (objLocal == null || objLocal.isClosed()) {
                        objLocal = new TelaConsultaLocalInternoSegurancaCPK();
                        jPainelPrincipal.add(objLocal);
                        objLocal.setVisible(true);
                    } else {
                        if (objLocal.isVisible()) {
                            if (objLocal.isIcon()) { // Se esta minimizado
                                try {
                                    objLocal.setIcon(false); // maximiniza
                                } catch (PropertyVetoException ex) {
                                }
                            } else {
                                objLocal.toFront(); // traz para frente
                                objLocal.pack();//volta frame 
                            }
                        } else {
                            objLocal = new TelaConsultaLocalInternoSegurancaCPK();
                            jPainelPrincipal.add(objLocal);//adicona frame ao JDesktopPane  
                            objLocal.setVisible(true);
                        }
                    }
                    try {
                        objLocal.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtLocalizacaoInternoActionPerformed

    private void jBtCadastroBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastroBiometriaActionPerformed
        // TODO add your handling code here:
        String grupoSeg = "TRIAGEM";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoSeg = "Sim";
        String moduloSeg = "TRIAGEM";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            if (cadBio == null || cadBio.isClosed()) {
                cadBio = new TelaCadastroDatiloscopia();
                jPainelPrincipal.add(cadBio);
                cadBio.setVisible(true);
            } else {
                if (cadBio.isVisible()) {
                    if (cadBio.isIcon()) { // Se esta minimizado
                        try {
                            cadBio.setIcon(false); // maximiniza
                        } catch (PropertyVetoException ex) {
                        }
                    } else {
                        cadBio.toFront(); // traz para frente
                        cadBio.pack();//volta frame 
                    }
                } else {
                    cadBio = new TelaCadastroDatiloscopia();
                    jPainelPrincipal.add(cadBio);//adicona frame ao JDesktopPane  
                    cadBio.setVisible(true);
                }
            }
            try {
                cadBio.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                if (cadBio == null || cadBio.isClosed()) {
                    cadBio = new TelaCadastroDatiloscopia();
                    jPainelPrincipal.add(cadBio);
                    cadBio.setVisible(true);
                } else {
                    if (cadBio.isVisible()) {
                        if (cadBio.isIcon()) { // Se esta minimizado
                            try {
                                cadBio.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            cadBio.toFront(); // traz para frente
                            cadBio.pack();//volta frame 
                        }
                    } else {
                        cadBio = new TelaCadastroDatiloscopia();
                        jPainelPrincipal.add(cadBio);//adicona frame ao JDesktopPane  
                        cadBio.setVisible(true);
                    }
                }
                try {
                    cadBio.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoSeg + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloSeg + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoSeg)) {
                    if (cadBio == null || cadBio.isClosed()) {
                        cadBio = new TelaCadastroDatiloscopia();
                        jPainelPrincipal.add(cadBio);
                        cadBio.setVisible(true);
                    } else {
                        if (cadBio.isVisible()) {
                            if (cadBio.isIcon()) { // Se esta minimizado
                                try {
                                    cadBio.setIcon(false); // maximiniza
                                } catch (PropertyVetoException ex) {
                                }
                            } else {
                                cadBio.toFront(); // traz para frente
                                cadBio.pack();//volta frame 
                            }
                        } else {
                            cadBio = new TelaCadastroDatiloscopia();
                            jPainelPrincipal.add(cadBio);//adicona frame ao JDesktopPane  
                            cadBio.setVisible(true);
                        }
                    }
                    try {
                        cadBio.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
//        private TelaCadastroDatiloscopia cadBio = null;
    }//GEN-LAST:event_jBtCadastroBiometriaActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastroBiometria;
    private javax.swing.JButton jBtConfere;
    private javax.swing.JButton jBtLocalizacaoInterno;
    private javax.swing.JButton jBtLogoff;
    private javax.swing.JButton jBtPagamentoKit;
    private javax.swing.JButton jBtSairSistema;
    private javax.swing.JButton jBtTrocarSenha;
    public static javax.swing.JTextField jDataSistema;
    public static javax.swing.JTextField jHoraSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLoginConectado;
    private javax.swing.JLabel jNomeUnidade;
    public static javax.swing.JDesktopPane jPainelPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    // End of variables declaration//GEN-END:variables
 
    // PARAMETRO PARA IDENTIFICAR O OS DO SERVIDOR DE BANCO DE DADOS.
    public void verificarParametrosSRV() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            tipoServidor = conecta.rs.getString("TipoServidor");
            tipoBancoDados = conecta.rs.getString("TipoBancoDados");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
