/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.visao;

import br.com.sisconpcpk.dao.ConectaBanco;
import br.com.sisconpcpk.dao.ControleLogSistemaDao;
import br.com.sisconpcpk.dao.ControlePagamentoKit;
import br.com.sisconpcpk.dao.ControlePesquisaKitInternoManual;
import br.com.sisconpcpk.dao.PagamentoKitDao;
import br.com.sisconpcpk.dao.PagamentoKitInternosDao;
import br.com.sisconpcpk.modelo.ComposicaoKit;
import br.com.sisconpcpk.modelo.ItensPagamentoKitInterno;
import br.com.sisconpcpk.modelo.LogSistema;
import br.com.sisconpcpk.modelo.PagamentoKitInterno;
import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import br.com.sisconpcpk.modelo.ProdutosPagtoKitInterno;
import static br.com.sisconpcpk.visao.FormPrincipal.codigoUserGroupB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codigoGrupoB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codAbrirTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.codAbrirB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codConsultarB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codAlterarB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codAlterarB2;
import static br.com.sisconpcpk.visao.FormPrincipal.codAlterarTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.codExcluirB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codExcluirB2;
import static br.com.sisconpcpk.visao.FormPrincipal.codExcluirTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.codGravarB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codGravarB2;
import static br.com.sisconpcpk.visao.FormPrincipal.codGravarTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.codIncluirB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codIncluirB2;
import static br.com.sisconpcpk.visao.FormPrincipal.codIncluirTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.codUserAcessoB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codUserAcessoB2;
import static br.com.sisconpcpk.visao.FormPrincipal.codUserAcessoTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.codigoUserB1;
import static br.com.sisconpcpk.visao.FormPrincipal.codigoUserB2;
import static br.com.sisconpcpk.visao.FormPrincipal.codigoUserTRI;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.nameUser;
import static br.com.sisconpcpk.visao.FormPrincipal.jDataSistema;
import static br.com.sisconpcpk.visao.FormPrincipal.jHoraSistema;
import static br.com.sisconpcpk.visao.FormPrincipal.nomeGrupoB1;
import static br.com.sisconpcpk.visao.FormPrincipal.nomeGrupoB2;
import static br.com.sisconpcpk.visao.FormPrincipal.nomeGrupoTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.nomeTelaB1;
import static br.com.sisconpcpk.visao.FormPrincipal.nomeTelaB2;
import static br.com.sisconpcpk.visao.FormPrincipal.nomeTelaTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.telaEntregaMaterialUsoB1;
import static br.com.sisconpcpk.visao.FormPrincipal.telaEntregaMaterialUsoB2;
import static br.com.sisconpcpk.visao.FormPrincipal.telaEntregaMaterialUsoInternosBioB1;
import static br.com.sisconpcpk.visao.FormPrincipal.telaEntregaMaterialUsoInternosBioB2;
import static br.com.sisconpcpk.visao.FormPrincipal.telaEntregaMaterialUsoInternosBioTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.telaEntregaMaterialUsoTRI;
import static br.com.sisconpcpk.visao.FormPrincipal.tipoServidor;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.descricaoUnidade;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronaldo
 */
public class TelaPagamentoKitInternoCPK extends javax.swing.JInternalFrame {

    ConectaBanco conecta = new ConectaBanco();
    PagamentoKitInterno objPag = new PagamentoKitInterno();
    PagamentoKitDao CONTROLE_KIT_manutencao = new PagamentoKitDao();
    //   
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    PagamentoKitInternosDao controle = new PagamentoKitInternosDao();
    //
    ControlePagamentoKit controlPagoKit = new ControlePagamentoKit();
    ComposicaoKit objComp = new ComposicaoKit();
    //
    ControlePesquisaKitInternoManual CONTROLE_PESQUISA_manual = new ControlePesquisaKitInternoManual();
    //
    ControleLogSistemaDao controlLog = new ControleLogSistemaDao();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Base Pavilhão:Pagamento de Kit de Internos:Manutenção";
    String nomeModuloTela2 = "Base:Pagamento de Kit de Internos:Pertences";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int acao;
    int flag;
    int count;
    String dataEntrada;
    String dataSaida;
    public static String dataInicial;
    public static String dataFinal;
    String situacaoKit = "ABERTO";
    public static String codLanc;
    // VARIÁVEIS PARA OS KITS INICIAL E 15 DIAS
    int copo, prato, colher, vasilha, garfo, absorvente, bermuda, lencol, colchao, toalha, camisa, cueca, sandalia, desodorante = 0;
    int cobertor, bola, calcaoJogo, camisaJogo, parMeiao = 0;
    int cremeDental, sabonete, papelHigienico, barbeador, escovaDente, sabaopo = 0;
    public static int idItem;
    String caminho;
    int marcaTodos = 0;
    int kitAnual = 0;
    int kitDecimal = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitSemetral = 0;
    int tipoEntrada = 0; // MANUAL É (0) - BIOMETRIA (1)
    public static String codigoInterno;
    public static String codigoKit;
    public static int codItem;
    public static String idItemPagto;
    String pRespostaKit = "Sim";
    java.sql.Date data;
    //
    int pKIT_inicial = 0;
    int pKIT_decendial = 0;
    int pKIT_quinzenal = 0;
    int pKIT_mensal = 0;
    int pKIT_semestral = 0;
    int pKIT_anual = 0;
    //
    public static int pTOTAL_registros = 0;
    public static String pCONFIRMARCAO_resposta = "";
    /**
     * Creates new form TelaPagamentoKitInterno
     */
    public static TelaBiometriaKitInternoCPK telaBiometriaKit;
    public static TelaAjudaAcesso telaHelp;
    public static TelaPesquisaInternoKitPago pPESQUISA_INTERNO;

    public TelaPagamentoKitInternoCPK() {
        initComponents();
        formatarCampos();
        corCampos();
    }

    public void mostrarTelaBiometria() {
        telaBiometriaKit = new TelaBiometriaKitInternoCPK(this, true);
        telaBiometriaKit.setVisible(true);
    }

    public void mostrarAjuda() {
        telaHelp = new TelaAjudaAcesso(this, true);
        telaHelp.setVisible(true);
    }

    public void mostrarInternoPesquisado() {
        pPESQUISA_INTERNO = new TelaPesquisaInternoKitPago(this, true);
        pPESQUISA_INTERNO.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jBtPesqData = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jPesqNomeInternoVisitado = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxPesquisarTipoKit = new javax.swing.JComboBox<>();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaPagamentoKit = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdLanc = new javax.swing.JTextField();
        jStatusLanc = new javax.swing.JTextField();
        jDataLanc = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jResponsavel = new javax.swing.JTextField();
        jHorarioInicial = new javax.swing.JFormattedTextField();
        jHorarioTermino = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxPavilhao = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxTipoKit = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jIdKit = new javax.swing.JTextField();
        jBtPesquisarKit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jIdRegistroComp = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxKitPersonalizado = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jID_Kit_inicial = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jID_REG_inicial = new javax.swing.JTextField();
        jRBtKitInicial = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jRBtKitDecendial = new javax.swing.JRadioButton();
        jID_REG_decendial = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jID_Kit_decendial = new javax.swing.JTextField();
        jRBtKitQuinzenal = new javax.swing.JRadioButton();
        jID_REG_quinzenal = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jID_Kit_quinzenal = new javax.swing.JTextField();
        jRBtKitMensal = new javax.swing.JRadioButton();
        jID_REG_mensal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jID_Kit_mensal = new javax.swing.JTextField();
        jRBtKitSemestral = new javax.swing.JRadioButton();
        jID_REG_semestral = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jID_Kit_semestral = new javax.swing.JTextField();
        jID_REG_anual = new javax.swing.JTextField();
        jRBtKitAnual = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        jID_Kit_anual = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jBtNovoInterno = new javax.swing.JButton();
        jBtAlterarInterno = new javax.swing.JButton();
        jBtExcluirInterno = new javax.swing.JButton();
        jBtSalvarInterno = new javax.swing.JButton();
        jBtCancelarInterno = new javax.swing.JButton();
        jBtSairInterno = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaProdutosKitInterno = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jFotoInternoKit = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jBtBiometria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBtFinalizar = new javax.swing.JButton();
        jBtImpressao = new javax.swing.JButton();
        jDataEntrega = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jHorarioPagto = new javax.swing.JFormattedTextField();
        jBtPesquisarInterno = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jBtAuditoria = new javax.swing.JButton();
        jBtAuditoriaItens = new javax.swing.JButton();
        jBtAjudaAcesso = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Relação de Materiais de Uso Pessoal de Internos (Kit) {FO.SGP.07} :::...");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Shopping_cart_Icon_32.png"))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Final:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jCheckBox19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox19.setText("Todos");
        jCheckBox19.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox19ItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nome Interno:");

        jPesqNomeInternoVisitado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Tipo de Kit:");

        jComboBoxPesquisarTipoKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPesquisarTipoKit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Kit Inicial", "Kit Decendial", "Kit Quinzenal", "Kit Mensal", "Kit Semestral", "Kit Anual" }));
        jComboBoxPesquisarTipoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(159, 159, 159)
                            .addComponent(jCheckBox19))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16)
                            .addGap(3, 3, 3)
                            .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxPesquisarTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqID)
                    .addComponent(jCheckBox19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBoxPesquisarTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jTabelaPagamentoKit.setAutoCreateRowSorter(true);
        jTabelaPagamentoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPagamentoKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Status", "Tipo de Kit", "Pavilhão", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPagamentoKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPagamentoKitMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaPagamentoKit);
        if (jTabelaPagamentoKit.getColumnModel().getColumnCount() > 0) {
            jTabelaPagamentoKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaPagamentoKit.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaPagamentoKit.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaPagamentoKit.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaPagamentoKit.getColumnModel().getColumn(4).setMinWidth(200);
            jTabelaPagamentoKit.getColumnModel().getColumn(4).setMaxWidth(200);
            jTabelaPagamentoKit.getColumnModel().getColumn(5).setMinWidth(350);
            jTabelaPagamentoKit.getColumnModel().getColumn(5).setMaxWidth(350);
        }

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jIdLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdLanc.setEnabled(false);

        jStatusLanc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusLanc.setForeground(new java.awt.Color(204, 0, 0));
        jStatusLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusLanc.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jStatusLanc.setEnabled(false);

        jDataLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataLanc.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Responsável");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Hora Inicio");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Hora Termino");

        jResponsavel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jResponsavel.setEnabled(false);

        jHorarioInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioInicial.setEnabled(false);

        jHorarioTermino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioTermino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioTermino.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Pavilhão");

        jComboBoxPavilhao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPavilhao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPavilhao.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tipo de Kit");

        jComboBoxTipoKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoKit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Kit Inicial", "Kit Decendial", "Kit Quinzenal", "Kit Mensal", "Kit Semestral", "Kit Anual", "Kit Personalizado" }));
        jComboBoxTipoKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoKit.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("ID Kit");

        jIdKit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdKit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdKit.setText("0");
        jIdKit.setToolTipText("");
        jIdKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdKit.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jIdKit.setEnabled(false);

        jBtPesquisarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarKit.setToolTipText("Pesquisar Kit de Higiêne");
        jBtPesquisarKit.setContentAreaFilled(false);
        jBtPesquisarKit.setEnabled(false);
        jBtPesquisarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarKitActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setText("ID Registro");

        jIdRegistroComp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdRegistroComp.setForeground(new java.awt.Color(0, 0, 204));
        jIdRegistroComp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdRegistroComp.setText("0");
        jIdRegistroComp.setToolTipText("");
        jIdRegistroComp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdRegistroComp.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        jIdRegistroComp.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Kit Personalizado");

        jComboBoxKitPersonalizado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxKitPersonalizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Sim", "Não" }));
        jComboBoxKitPersonalizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxKitPersonalizado.setEnabled(false);
        jComboBoxKitPersonalizado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxKitPersonalizadoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jResponsavel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusLanc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(183, 183, 183)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBoxTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jHorarioInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jIdKit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxKitPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jHorarioInicial, jHorarioTermino});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jHorarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdRegistroComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxKitPersonalizado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisarKit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setEnabled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtSair)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovo)
                .addComponent(jBtAlterar)
                .addComponent(jBtExcluir)
                .addComponent(jBtSalvar)
                .addComponent(jBtCancelar))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Observação");

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane1.setViewportView(jObservacao);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Kits Personalizados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jID_Kit_inicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_Kit_inicial.setText("0");
        jID_Kit_inicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_Kit_inicial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_Kit_inicial.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("ID Kit");

        jID_REG_inicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REG_inicial.setText("0");
        jID_REG_inicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_REG_inicial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_REG_inicial.setEnabled(false);

        jRBtKitInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitInicial.setEnabled(false);
        jRBtKitInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Inicial");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Decendial");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Quinzenal");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Mensal");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Semestral");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Anual");

        jRBtKitDecendial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitDecendial.setEnabled(false);
        jRBtKitDecendial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jID_REG_decendial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REG_decendial.setText("0");
        jID_REG_decendial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_REG_decendial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_REG_decendial.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("ID Kit");

        jID_Kit_decendial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_Kit_decendial.setText("0");
        jID_Kit_decendial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_Kit_decendial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_Kit_decendial.setEnabled(false);

        jRBtKitQuinzenal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitQuinzenal.setEnabled(false);
        jRBtKitQuinzenal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jID_REG_quinzenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REG_quinzenal.setText("0");
        jID_REG_quinzenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_REG_quinzenal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_REG_quinzenal.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("ID Kit");

        jID_Kit_quinzenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_Kit_quinzenal.setText("0");
        jID_Kit_quinzenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_Kit_quinzenal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_Kit_quinzenal.setEnabled(false);

        jRBtKitMensal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitMensal.setEnabled(false);
        jRBtKitMensal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jID_REG_mensal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REG_mensal.setText("0");
        jID_REG_mensal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_REG_mensal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_REG_mensal.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("ID Kit");

        jID_Kit_mensal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_Kit_mensal.setText("0");
        jID_Kit_mensal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_Kit_mensal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_Kit_mensal.setEnabled(false);

        jRBtKitSemestral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitSemestral.setEnabled(false);
        jRBtKitSemestral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jID_REG_semestral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REG_semestral.setText("0");
        jID_REG_semestral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_REG_semestral.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_REG_semestral.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("ID Kit");

        jID_Kit_semestral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_Kit_semestral.setText("0");
        jID_Kit_semestral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_Kit_semestral.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_Kit_semestral.setEnabled(false);

        jID_REG_anual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_REG_anual.setText("0");
        jID_REG_anual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_REG_anual.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_REG_anual.setEnabled(false);

        jRBtKitAnual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBtKitAnual.setEnabled(false);
        jRBtKitAnual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("ID Kit");

        jID_Kit_anual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jID_Kit_anual.setText("0");
        jID_Kit_anual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jID_Kit_anual.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jID_Kit_anual.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jID_REG_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addComponent(jID_Kit_inicial)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRBtKitInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jID_REG_decendial, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel29)
                    .addComponent(jRBtKitDecendial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jID_Kit_decendial))
                .addGap(4, 4, 4)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jID_REG_quinzenal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel30)
                            .addComponent(jID_Kit_quinzenal))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jID_REG_mensal, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(jLabel31)
                            .addComponent(jID_Kit_mensal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jRBtKitQuinzenal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRBtKitMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jID_REG_semestral, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32))
                    .addComponent(jRBtKitSemestral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jID_Kit_semestral))
                .addGap(4, 4, 4)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jID_REG_anual, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel33)
                    .addComponent(jID_Kit_anual, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBtKitAnual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jID_REG_inicial, jID_REG_mensal});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jID_REG_decendial, jID_REG_semestral});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jID_REG_anual, jID_REG_quinzenal});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(3, 3, 3)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBtKitInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBtKitDecendial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBtKitQuinzenal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBtKitMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBtKitSemestral, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBtKitAnual, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jID_REG_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_REG_decendial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_REG_quinzenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_REG_mensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_REG_semestral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_REG_anual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(2, 2, 2)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jID_Kit_anual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_Kit_semestral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_Kit_mensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_Kit_quinzenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_Kit_decendial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jID_Kit_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jID_Kit_mensal, jID_REG_decendial, jID_REG_inicial, jID_REG_mensal, jID_REG_semestral});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jID_REG_anual, jID_REG_quinzenal});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel15, jPanel3});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nome Completo do Interno");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jNomeInterno))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaInternos.setAutoCreateRowSorter(true);
        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtNovoInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/page_add.png"))); // NOI18N
        jBtNovoInterno.setText("Novo");
        jBtNovoInterno.setContentAreaFilled(false);
        jBtNovoInterno.setEnabled(false);
        jBtNovoInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoInternoActionPerformed(evt);
            }
        });

        jBtAlterarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarInterno.setText("Alterar");
        jBtAlterarInterno.setContentAreaFilled(false);
        jBtAlterarInterno.setEnabled(false);
        jBtAlterarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarInternoActionPerformed(evt);
            }
        });

        jBtExcluirInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirInterno.setText("Excluir");
        jBtExcluirInterno.setContentAreaFilled(false);
        jBtExcluirInterno.setEnabled(false);
        jBtExcluirInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirInternoActionPerformed(evt);
            }
        });

        jBtSalvarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarInterno.setText("Gravar");
        jBtSalvarInterno.setContentAreaFilled(false);
        jBtSalvarInterno.setEnabled(false);
        jBtSalvarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarInternoActionPerformed(evt);
            }
        });

        jBtCancelarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarInterno.setText("Cancelar");
        jBtCancelarInterno.setContentAreaFilled(false);
        jBtCancelarInterno.setEnabled(false);
        jBtCancelarInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarInternoActionPerformed(evt);
            }
        });

        jBtSairInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairInterno.setText("Sair");
        jBtSairInterno.setContentAreaFilled(false);
        jBtSairInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairInterno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairInterno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jBtNovoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirInterno)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarInterno)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtSairInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtSairInterno)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtNovoInterno)
                .addComponent(jBtAlterarInterno)
                .addComponent(jBtExcluirInterno)
                .addComponent(jBtSalvarInterno)
                .addComponent(jBtCancelarInterno))
        );

        jTabelaProdutosKitInterno.setAutoCreateRowSorter(true);
        jTabelaProdutosKitInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKitInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Un.", "Quant."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTabelaProdutosKitInterno);
        if (jTabelaProdutosKitInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setMinWidth(340);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(1).setMaxWidth(340);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setMinWidth(60);
            jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Internos/Materiais", jPanel9);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInternoKit, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtBiometria.setForeground(new java.awt.Color(204, 0, 0));
        jBtBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtBiometria.setText("Pagamento");
        jBtBiometria.setToolTipText("Pesquisar Interno para Pagamento de Kit");
        jBtBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jBtBiometria)
                .addGap(3, 3, 3))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jBtImpressao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressao.setText("Impressão");
        jBtImpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoActionPerformed(evt);
            }
        });

        jDataEntrega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data Entrega");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Horário");

        jHorarioPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto.setEnabled(false);

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Lupas_1338_05_1.gif"))); // NOI18N
        jBtPesquisarInterno.setText("Pesquisar");
        jBtPesquisarInterno.setToolTipText("Pesquisar Registro do Interno");
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtFinalizar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jHorarioPagto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDataEntrega, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao, jBtPesquisarInterno});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jBtPesquisarInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtFinalizar)
                .addGap(3, 3, 3)
                .addComponent(jBtImpressao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtFinalizar, jBtImpressao});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/book_open.png"))); // NOI18N
        jBtAuditoria.setToolTipText("Auditoria");
        jBtAuditoria.setContentAreaFilled(false);
        jBtAuditoria.setEnabled(false);
        jBtAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaActionPerformed(evt);
            }
        });

        jBtAuditoriaItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/book_open.png"))); // NOI18N
        jBtAuditoriaItens.setToolTipText("Auditoria");
        jBtAuditoriaItens.setContentAreaFilled(false);
        jBtAuditoriaItens.setEnabled(false);
        jBtAuditoriaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaItensActionPerformed(evt);
            }
        });

        jBtAjudaAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Ajuda.png"))); // NOI18N
        jBtAjudaAcesso.setToolTipText("Ajuda");
        jBtAjudaAcesso.setContentAreaFilled(false);
        jBtAjudaAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAjudaAcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAuditoriaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAjudaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAuditoria, jBtAuditoriaItens});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAuditoriaItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtAjudaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAuditoria, jBtAuditoriaItens});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );

        setBounds(250, 30, 615, 506);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        if (jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...")) {
                            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                            }
                            PREENCHER_TABELA_GERAL_PAGO_kit();
                            if (pTOTAL_registros == 0) {
                                jtotalRegistros.setText("");
                                limparTabela();
                                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                            }
                        } else if (!jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...")) {
                            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                            }
                            PREENCHER_TABELA_GERAL_PAGO_kit0();
                            if (pTOTAL_registros == 0) {
                                jtotalRegistros.setText("");
                                limparTabela();
                                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                            }
                        }
                    }
                }
            }
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            if (jDataPesqInicial.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
                jDataPesqInicial.requestFocus();
            } else {
                if (jDataPesqFinal.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                    jDataPesqFinal.requestFocus();
                } else {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        if (jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...")) {
                            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                            }
                            PREENCHER_TABELA_GERAL_PAGO_kit();
                            if (pTOTAL_registros == 0) {
                                jtotalRegistros.setText("");
                                limparTabela();
                                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                            }
                        } else if (!jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...")) {
                            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                            }
                            PREENCHER_TABELA_GERAL_PAGO_kit0();
                            if (pTOTAL_registros == 0) {
                                jtotalRegistros.setText("");
                                limparTabela();
                                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
//            if (jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...")) {
//                if (!jIDPesqLanc.getText().equals("")) {
            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
            }
            PREENCHER_TABELA_GERAL_CODIGO_nomeInterno();
            if (pTOTAL_registros == 0) {
                jtotalRegistros.setText("");
                limparTabela();
                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
            }
//                } else {
//                    while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
//                        ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
//                    }
//                    PREENCHER_TABELA_GERAL_PAGO_kitOBS();
//                    if (pTOTAL_registros == 0) {
//                        jtotalRegistros.setText("");
//                        limparTabela();
//                        JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
//                    }
//                }
//            } else if (!jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...")) {
//                if (jIDPesqLanc.getText().equals("")) {
//                    while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
//                        ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
//                    }
//                    PREENCHER_TABELA_GERAL_PAGO_kitOBS();
//                    if (pTOTAL_registros == 0) {
//                        jtotalRegistros.setText("");
//                        limparTabela();
//                        JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
//                    }
//                } else {
//                    while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
//                        ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
//                    }
//                    PREENCHER_TABELA_GERAL_CODIGO_nomeInterno();
//                    if (pTOTAL_registros == 0) {
//                        jtotalRegistros.setText("");
//                        limparTabela();
//                        JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
//                    }
//                }
//            }
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jCheckBox19ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox19ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            // APAGAR DADOS DA TABELA PRODUTOS
            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
            }
            pTOTAL_registros = 0;
            jtotalRegistros.setText("");
            DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
            try {
                for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_TODOS_registros()) {
                    dataEntrada = String.valueOf(b.getDataLanc());
                    String diae = dataEntrada.substring(8, 10);
                    String mese = dataEntrada.substring(5, 7);
                    String anoe = dataEntrada.substring(0, 4);
                    dataEntrada = diae + "/" + mese + "/" + anoe;
                    objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // APAGAR DADOS DA TABELA PRODUTOS
            while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
            }
            pTOTAL_registros = 0;
            jtotalRegistros.setText("");
//            if (pTOTAL_registros == 0) {
//                jtotalRegistros.setText("");
//                limparTabela();
//                JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
//            }
        }
    }//GEN-LAST:event_jCheckBox19ItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInternoVisitado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisa.");
        } else {
            if (jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...") && jDataPesqInicial.getDate() == null && jDataPesqFinal.getDate() == null) {
                // APAGAR DADOS DA TABELA PRODUTOS
                while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                }
                PREENCHER_TABELA_PAGTO_KIT_nomeInterno();
                if (pTOTAL_registros == 0) {
                    jtotalRegistros.setText("");
                    limparTabela();
                    JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                }
            } else if (!jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...") && jDataPesqInicial.getDate() == null && jDataPesqFinal.getDate() == null) {
                // APAGAR DADOS DA TABELA PRODUTOS
                while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                }
                PREENCHER_TABELA_PAGTO_KIT_NOME_tipokit();
                if (pTOTAL_registros == 0) {
                    jtotalRegistros.setText("");
                    limparTabela();
                    JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                }
            } else if (!jComboBoxPesquisarTipoKit.getSelectedItem().equals("Selecione...") && jDataPesqInicial.getDate() != null && jDataPesqFinal.getDate() != null) {
                if (tipoServidor == null || tipoServidor.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
                } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        // APAGAR DADOS DA TABELA PRODUTOS
                        while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                        }
                        PREENCHER_TABELA_PAGTO_KIT_NOME_TIPO_data();
                        if (pTOTAL_registros == 0) {
                            jtotalRegistros.setText("");
                            limparTabela();
                            JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                        }
                    }
                } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                    if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                        JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                    } else {
                        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                        dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                        dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                        // APAGAR DADOS DA TABELA PRODUTOS
                        while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
                            ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
                        }
                        PREENCHER_TABELA_PAGTO_KIT_NOME_TIPO_data();
                        if (pTOTAL_registros == 0) {
                            jtotalRegistros.setText("");
                            limparTabela();
                            JOptionPane.showMessageDialog(rootPane, "Não existem registros a serem exibidos.");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jTabelaPagamentoKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPagamentoKitMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String IdLanc = "" + jTabelaPagamentoKit.getValueAt(jTabelaPagamentoKit.getSelectedRow(), 0);
            jIDPesqLanc.setText(IdLanc);
            jDataLanc.setDate(jDataLanc.getDate());
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtBiometria.setEnabled(true);
            //
            limparCamposManutencao();
            limparTabelaInternos();
            limparTabelaProdutosInternos();
            //
            bloquearCampos(!true);
            jComboBoxPavilhao.removeAllItems();
            jComboBoxTipoKit.removeAll();
            jComboBoxKitPersonalizado.removeAllItems();
            try {
                for (PagamentoKitInterno cc : CONTROLE_KIT_manutencao.pBUSCAR_REGISTRO_MOUSE_clicked()) {
                    jIdLanc.setText(String.valueOf(cc.getIdPagto()));
                    jStatusLanc.setText(cc.getStatusLanc());
                    jDataLanc.setDate(cc.getDataLanc());
                    jResponsavel.setText(cc.getResponsavel());
                    jHorarioInicial.setText(cc.getHoraInicio());
                    jHorarioTermino.setText(cc.getHoraTermino());
                    jIdKit.setText(String.valueOf(cc.getIdKit()));
                    jIdRegistroComp.setText(String.valueOf(cc.getIdRegistroComp()));
                    jComboBoxTipoKit.addItem(cc.getTipoKit());
                    jComboBoxPavilhao.addItem(cc.getDescricaoPavilhao());
                    jComboBoxKitPersonalizado.addItem(cc.getKitPersonalizado());
                    if (jComboBoxKitPersonalizado.getSelectedItem() != null && jComboBoxKitPersonalizado.getSelectedItem().equals("Sim")) {
                        pKIT_inicial = cc.getiD_BT_Kit_inicial();
                        if (pKIT_inicial == 0) {
                            jRBtKitInicial.setSelected(!true);
                        } else if (pKIT_inicial == 1) {
                            jRBtKitInicial.setSelected(true);
                        }
                        pKIT_decendial = cc.getiD_BT_Kit_decendial();
                        if (pKIT_decendial == 0) {
                            jRBtKitDecendial.setSelected(!true);
                        } else if (pKIT_decendial == 1) {
                            jRBtKitDecendial.setSelected(true);
                        }
                        pKIT_quinzenal = cc.getiD_BT_Kit_quinzenal();
                        if (pKIT_quinzenal == 0) {
                            jRBtKitQuinzenal.setSelected(!true);
                        } else if (pKIT_quinzenal == 1) {
                            jRBtKitQuinzenal.setSelected(true);
                        }
                        pKIT_mensal = cc.getiD_BT_Kit_mensal();
                        if (pKIT_mensal == 0) {
                            jRBtKitMensal.setSelected(!true);
                        } else if (pKIT_mensal == 1) {
                            jRBtKitMensal.setSelected(true);
                        }
                        pKIT_semestral = cc.getiD_BT_Kit_semestral();
                        if (pKIT_semestral == 0) {
                            jRBtKitSemestral.setSelected(!true);
                        } else if (pKIT_semestral == 1) {
                            jRBtKitSemestral.setSelected(true);
                        }
                        pKIT_anual = cc.getiD_BT_Kit_anual();
                        if (pKIT_anual == 0) {
                            jRBtKitAnual.setSelected(!true);
                        } else if (pKIT_anual == 1) {
                            jRBtKitAnual.setSelected(true);
                        }
                        jID_REG_inicial.setText(String.valueOf(cc.getiD_REG_inicial()));
                        jID_REG_decendial.setText(String.valueOf(cc.getiD_REG_decendial()));
                        jID_REG_quinzenal.setText(String.valueOf(cc.getiD_REG_quinzenal()));
                        jID_REG_mensal.setText(String.valueOf(cc.getiD_REG_mensal()));
                        jID_REG_semestral.setText(String.valueOf(cc.getiD_REG_semestral()));
                        jID_REG_anual.setText(String.valueOf(cc.getiD_REG_anual()));
                        //
                        jID_Kit_inicial.setText(String.valueOf(cc.getiD_KIT_inicial()));
                        jID_Kit_decendial.setText(String.valueOf(cc.getiD_KIT_decendial()));
                        jID_Kit_quinzenal.setText(String.valueOf(cc.getiD_KIT_quinzenal()));
                        jID_Kit_mensal.setText(String.valueOf(cc.getiD_KIT_mensal()));
                        jID_Kit_semestral.setText(String.valueOf(cc.getiD_KIT_semestral()));
                        jID_Kit_anual.setText(String.valueOf(cc.getiD_KIT_anual()));
                    } else if (jComboBoxKitPersonalizado.getSelectedItem() != null && jComboBoxKitPersonalizado.getSelectedItem().equals("Não")) {
                        jIdKit.setText(String.valueOf(cc.getIdKit()));
                        jIdRegistroComp.setText(String.valueOf(cc.getIdRegistroComp()));
                        jComboBoxTipoKit.setSelectedItem(cc.getTipoKit());
                    }
                    jObservacao.setText(cc.getObservacao());
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
            pPREENCHER_TABELA_ITENS_internos();
        }
    }//GEN-LAST:event_jTabelaPagamentoKitMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codIncluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos(!true);
            bloquearBotoes(!true);
            limparTabelaInternos();
            acao = 1;
            Novo();
            corCampos();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos(!true);
            bloquearBotoes(!true);
            limparTabelaInternos();
            acao = 1;
            Novo();
            corCampos();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            limparCamposManutencao();
            bloquearCampos(!true);
            bloquearBotoes(!true);
            limparTabelaInternos();
            acao = 1;
            Novo();
            corCampos();
            preencherComboBoxPavilhao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codAlterarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaInternos.getModel().getRowCount();
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (rows != 0) {
                    jComboBoxPavilhao.setEnabled(!true);
//                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    Alterar();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    AlterarTabelaInternosZero();
                    jComboBoxPavilhao.setEnabled(true);
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codAlterarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaInternos.getModel().getRowCount();
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (rows != 0) {
                    jComboBoxPavilhao.setEnabled(!true);
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    Alterar();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    AlterarTabelaInternosZero();
                    jComboBoxPavilhao.setEnabled(true);
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codAlterarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            Integer rows = jTabelaInternos.getModel().getRowCount();
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                if (rows != 0) {
                    jComboBoxPavilhao.setEnabled(!true);
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    Alterar();
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                } else {
                    preencherComboBoxPavilhao();
                    acao = 2;
                    bloquearCampos(!true);
                    bloquearBotoes(!true);
                    AlterarTabelaInternosZero();
                    jComboBoxPavilhao.setEnabled(true);
                    corCampos();
                    statusMov = "Alterou";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codExcluirTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                bloquearCampos(!true);
                bloquearBotoes(!true);
                VERIFICAR_itens();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codExcluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                bloquearCampos(!true);
                bloquearBotoes(!true);
                VERIFICAR_itens();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codExcluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            objPag.setStatusLanc(jStatusLanc.getText());
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Esse  Lançamento não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                bloquearCampos(!true);
                bloquearBotoes(!true);
                VERIFICAR_itens();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoB2);
        if (codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoTRI) && codGravarTRI == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else if (jIdKit.getText().equals("") && !jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código da composição do kit de higiêne do interno.");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar se o kit é ou não personalizado.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                objPag.setIdKit(Integer.valueOf(jIdKit.getText()));
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setKitPersonalizado((String) jComboBoxKitPersonalizado.getSelectedItem());
                objPag.setiD_REG_inicial(Integer.valueOf(jID_REG_inicial.getText()));
                objPag.setiD_REG_decendial(Integer.valueOf(jID_REG_decendial.getText()));
                objPag.setiD_REG_quinzenal(Integer.valueOf(jID_REG_quinzenal.getText()));
                objPag.setiD_REG_mensal(Integer.valueOf(jID_REG_mensal.getText()));
                objPag.setiD_REG_semestral(Integer.valueOf(jID_REG_semestral.getText()));
                objPag.setiD_REG_anual(Integer.valueOf(jID_REG_anual.getText()));
                objPag.setiD_KIT_inicial(Integer.valueOf(jID_Kit_inicial.getText()));
                objPag.setiD_KIT_decendial(Integer.valueOf(jID_Kit_decendial.getText()));
                objPag.setiD_KIT_quinzenal(Integer.valueOf(jID_Kit_quinzenal.getText()));
                objPag.setiD_KIT_mensal(Integer.valueOf(jID_Kit_mensal.getText()));
                objPag.setiD_KIT_semestral(Integer.valueOf(jID_Kit_semestral.getText()));
                objPag.setiD_KIT_anual(Integer.valueOf(jID_Kit_anual.getText()));
                if (jRBtKitInicial.isSelected()) {
                    pKIT_inicial = 1;
                } else {
                    pKIT_inicial = 0;
                }
                objPag.setiD_BT_Kit_inicial(pKIT_inicial);
                if (jRBtKitDecendial.isSelected()) {
                    pKIT_decendial = 1;
                } else {
                    pKIT_decendial = 0;
                }
                objPag.setiD_BT_Kit_decendial(pKIT_decendial);
                if (jRBtKitQuinzenal.isSelected()) {
                    pKIT_quinzenal = 1;
                } else {
                    pKIT_quinzenal = 0;
                }
                objPag.setiD_BT_Kit_quinzenal(pKIT_quinzenal);
                if (jRBtKitMensal.isSelected()) {
                    pKIT_mensal = 1;
                } else {
                    pKIT_mensal = 0;
                }
                objPag.setiD_BT_Kit_mensal(pKIT_mensal);
                if (jRBtKitSemestral.isSelected()) {
                    pKIT_semestral = 1;
                } else {
                    pKIT_semestral = 0;
                }
                objPag.setiD_BT_Kit_semestral(pKIT_semestral);
                if (jRBtKitAnual.isSelected()) {
                    pKIT_anual = 1;
                } else {
                    pKIT_anual = 0;
                }
                objPag.setiD_BT_Kit_anual(pKIT_anual);
                objPag.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objPag.setUsuarioInsert(nameUser);
                    objPag.setDataInsert(dataModFinal);
                    objPag.setHorarioInsert(horaMov);
                    //
                    CONTROLE_KIT_manutencao.incluirPagamentoKit(objPag);
                    pBUSCAR_codigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    Salvar();
                    if (pCONFIRMARCAO_resposta.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objPag.setUsuarioUp(nameUser);
                    objPag.setDataUp(dataModFinal);
                    objPag.setHorarioUp(horaMov);
                    //
                    objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                    CONTROLE_KIT_manutencao.alterarPagamentoKit(objPag);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    Salvar();
                    if (pCONFIRMARCAO_resposta.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoB1) && codGravarB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else if (jIdKit.getText().equals("") && !jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código da composição do kit de higiêne do interno.");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar se o kit é ou não personalizado.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                objPag.setIdKit(Integer.valueOf(jIdKit.getText()));
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setKitPersonalizado((String) jComboBoxKitPersonalizado.getSelectedItem());
                objPag.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objPag.setUsuarioInsert(nameUser);
                    objPag.setDataInsert(dataModFinal);
                    objPag.setHorarioInsert(horaMov);
                    //
                    CONTROLE_KIT_manutencao.incluirPagamentoKit(objPag);
                    pBUSCAR_codigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    Salvar();
                    if (pCONFIRMARCAO_resposta.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objPag.setUsuarioUp(nameUser);
                    objPag.setDataUp(dataModFinal);
                    objPag.setHorarioUp(horaMov);
                    //
                    objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                    CONTROLE_KIT_manutencao.alterarPagamentoKit(objPag);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    Salvar();
                    if (pCONFIRMARCAO_resposta.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoB2) && codGravarB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES")) {
            if (jDataLanc.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar a data do lançamento.");
            } else if (jResponsavel.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o responsável pelo registro.");
            } else if (jComboBoxTipoKit.getSelectedItem().equals("Selecione...") || jComboBoxTipoKit.getSelectedItem().equals("") || jComboBoxTipoKit.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "É necessário o tipo de kit.");
            } else if (jComboBoxPavilhao.getSelectedItem().equals("Selecione...") || jComboBoxPavilhao.getSelectedItem().equals("") || jComboBoxPavilhao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe qual é o pavilhão.");
            } else if (jIdKit.getText().equals("") && !jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar o código da composição do kit de higiêne do interno.");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário informar se o kit é ou não personalizado.");
            } else {
                objPag.setStatusLanc(jStatusLanc.getText());
                objPag.setDataLanc(jDataLanc.getDate());
                objPag.setResponsavel(jResponsavel.getText());
                objPag.setHoraInicio(jHorarioInicial.getText());
                objPag.setHoraTermino(jHorarioTermino.getText());
                objPag.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                objPag.setIdKit(Integer.valueOf(jIdKit.getText()));
                objPag.setTipoKit((String) jComboBoxTipoKit.getSelectedItem());
                objPag.setDescricaoPavilhao((String) jComboBoxPavilhao.getSelectedItem());
                objPag.setKitPersonalizado((String) jComboBoxKitPersonalizado.getSelectedItem());
                objPag.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objPag.setUsuarioInsert(nameUser);
                    objPag.setDataInsert(dataModFinal);
                    objPag.setHorarioInsert(horaMov);
                    //
                    CONTROLE_KIT_manutencao.incluirPagamentoKit(objPag);
                    pBUSCAR_codigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação             
                    Salvar();
                    if (pCONFIRMARCAO_resposta.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
                if (acao == 2) {
                    objPag.setUsuarioUp(nameUser);
                    objPag.setDataUp(dataModFinal);
                    objPag.setHorarioUp(horaMov);
                    //
                    objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                    CONTROLE_KIT_manutencao.alterarPagamentoKit(objPag);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação     
                    Salvar();
                    if (pCONFIRMARCAO_resposta.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível finalizar esse registro, pois não existe(m) produto(s) lançado(s).");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                        + "WHERE IdPagto='" + jIdLanc.getText() + "'");
                conecta.rs.first();
                jStatusLanc.setText(conecta.rs.getString("StatusLanc"));
                if (jStatusLanc.getText().equals("FINALIZADO")) {
                    JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
                } else {
                    FINALIZAR_kits();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar se lançamento foi finalizado\nERRO: " + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPagamentoKitCPK objAudiKit = new TelaAuditoriaPagamentoKitCPK();
        FormPrincipal.jPainelPrincipal.add(objAudiKit);
        objAudiKit.show();
    }//GEN-LAST:event_jBtAuditoriaActionPerformed

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idItemPagto = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //         
            jBtNovoInterno.setEnabled(!true);
            jBtAlterarInterno.setEnabled(!true);
            jBtExcluirInterno.setEnabled(!true);
            jBtSalvarInterno.setEnabled(!true);
            jBtCancelarInterno.setEnabled(!true);
            jBtAuditoriaItens.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                for (ItensPagamentoKitInterno qq : CONTROLE_KIT_manutencao.pPESQUISAR_PRODUTOS_KITS_internoCliced()) {
                    idItem = qq.getIdItem();
                    codItem = qq.getIdItem();
                    jIdInterno.setText(String.valueOf(qq.getIdInternoCrc()));
                    jNomeInterno.setText(qq.getNomeInternoCrcKit());
                    // Capturando foto
                    caminho = qq.getCaminhoFoto();
                    if (caminho != null) {
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                        jFotoInternoKit.setIcon(i);
                        jFotoInternoKit.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_SMOOTH)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] imgBytes = ((byte[]) qq.getImagemFoto());
                    if (imgBytes != null) {
                        ImageIcon pic = null;
                        pic = new ImageIcon(imgBytes);
                        Image scaled = pic.getImage().getScaledInstance(jFotoInternoKit.getWidth(), jFotoInternoKit.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(scaled);
                        jFotoInternoKit.setIcon(icon);
                    }
                    jDataEntrega.setDate(qq.getDataEntrega());
                    jHorarioPagto.setText(qq.getHoraEntrega());
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
            limparTabelaProdutosInternos();
            PREENCHER_TABELA_PRODUTOS_KIT_interno();
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked

    private void jBtNovoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoInternoActionPerformed
        // TODO add your handling code here:
        objPag.setStatusLanc(jStatusLanc.getText());
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 3;
            limparCampos();
            bloquearBotoes(!true);
            NovoInterno();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtNovoInternoActionPerformed

    private void jBtAlterarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarInternoActionPerformed
        // TODO add your handling code here:
        objPag.setStatusLanc(jStatusLanc.getText());
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser alterado, o mesmo encontra-se FINALIZADO");
        } else {
            acao = 4;
            AlterarInterno();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtAlterarInternoActionPerformed

    private void jBtExcluirInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirInternoActionPerformed
        // TODO add your handling code here:
        objPag.setStatusLanc(jStatusLanc.getText());
        if (jStatusLanc.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, o mesmo encontra-se FINALIZADO");
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objItensPagto.setIdItem(idItem);
            controle.excluirPagamentoKitInterno(objItensPagto);
            objLog2();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
            ExcluirInterno();
            pPREENCHER_TABELA_ITENS_internos();
            JOptionPane.showMessageDialog(rootPane, "Registro EXCLUÍDO com sucesso.");
        }
    }//GEN-LAST:event_jBtExcluirInternoActionPerformed

    private void jBtSalvarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarInternoActionPerformed
        // TODO add your handling code here:
        VERIFICAR_internos();
        tipoEntrada = 0;
        if (marcaTodos == 0 && kitAnual == 0 && kitQuinzenal == 0 && kitDecimal == 0 && kitSemetral == 0 && kitMensal == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe um tipo de kit para ser entregue ao interno.");
        } else if (jIdInterno.getText().equals("") || jNomeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe para qual interno será o kit.");
        } else {
            objItensPagto.setTipoEntrada(tipoEntrada);
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            //
            objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
            objItensPagto.setNomeInternoCrcKit(jNomeInterno.getText());
            objItensPagto.setIdPagto(Integer.valueOf(jIdLanc.getText()));
            if (acao == 3) {
                if (jIdInterno.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
                } else {
                    objItensPagto.setUsuarioInsert(nameUser);
                    objItensPagto.setDataInsert(dataModFinal);
                    objItensPagto.setHorarioInsert(horaMov);
                    //
                    pBUSCAR_CODIGO_item();
                    //
                    controle.incluirPagamentoKitInterno(objItensPagto);
                    objLog2();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    SalvarInterno();
                    pPREENCHER_TABELA_ITENS_internos();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
            if (acao == 4) {
                objItensPagto.setUsuarioUp(nameUser);
                objItensPagto.setDataUp(dataModFinal);
                objItensPagto.setHorarioUp(horaMov);
                //
                objItensPagto.setIdItem(idItem);
                controle.alterarPagamentoKitInterno(objItensPagto);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarInterno();
                pPREENCHER_TABELA_ITENS_internos();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarInternoActionPerformed

    private void jBtCancelarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarInternoActionPerformed
        // TODO add your handling code here:
        limparCampos();
        bloquearCampos(!true);
        CancelarInterno();
    }//GEN-LAST:event_jBtCancelarInternoActionPerformed

    private void jBtSairInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairInternoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairInternoActionPerformed

    private void jBtAuditoriaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaItensActionPerformed
        // TODO add your handling code here:
        TelaAudItensPagamentoKitCPK objAudiIten = new TelaAudItensPagamentoKitCPK();
        FormPrincipal.jPainelPrincipal.add(objAudiIten);
        objAudiIten.show();
    }//GEN-LAST:event_jBtAuditoriaItensActionPerformed

    private void jBtBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBiometriaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosBioTRI);
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosBioB1);
        buscarAcessoUsuario(telaEntregaMaterialUsoInternosBioB2);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoTRI.equals("ADMINISTRADORES") || codigoUserTRI == codUserAcessoTRI && nomeTelaTRI.equals(telaEntregaMaterialUsoInternosBioTRI) && codAbrirTRI == 1) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else if (!jIdLanc.getText().equals("")) {
                mostrarTelaBiometria();
            }
        } else if (codigoUserB1 == codUserAcessoB1 && nomeTelaB1.equals(telaEntregaMaterialUsoInternosBioB1) && codIncluirB1 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else if (!jIdLanc.getText().equals("")) {
                mostrarTelaBiometria();
            }
        } else if (codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaEntregaMaterialUsoInternosBioB2) && codIncluirB2 == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB1.equals("ADMINISTRADORES")) {
            if (jStatusLanc.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível utilizar essa função, registro finalizado.");
            } else if (!jIdLanc.getText().equals("")) {
                mostrarTelaBiometria();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtBiometriaActionPerformed

    private void jBtImpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoActionPerformed
        // TODO add your handling code here:
        // VERIFICAR SE A TABELA TEM PRODUTOS, SE ESTIVER VAZIA NÃO IMPRIMI
        Integer rows = jTabelaInternos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir esse registro, pois não existe(m) produto(s) lançado(s).");
        } else if (jIdInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para imprimir o relatório.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioPagamentoKitInterno.jasper";
                conecta.executaSQL("SELECT * FROM PAGAMENTO_KIT_INTERNOS "
                        + "INNER JOIN PAVILHAO "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                        + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                        + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE PAGAMENTO_KIT_INTERNOS.IdPagto='" + jIdLanc.getText() + "' "
                        + "AND ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc='" + jIdInterno.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("pUnidade", descricaoUnidade);
                parametros.put("pCodigo", jIdLanc.getText());
                parametros.put("pCodigoInternoCrc", jIdInterno.getText());
                parametros.put("pUsuario", nameUser);
                // Sub Relatório
                try {
                    parametros.put("REPORT_CONNECTION", conecta.stmt.getConnection());
                } catch (SQLException ex) {
                }
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Pagamento de Kit de Interno.");
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoActionPerformed

    private void jBtPesquisarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarKitActionPerformed
        // TODO add your handling code here:
        TelaPesquisaKitCpk objPesqKit = new TelaPesquisaKitCpk();
        FormPrincipal.jPainelPrincipal.add(objPesqKit);
        objPesqKit.show();
    }//GEN-LAST:event_jBtPesquisarKitActionPerformed

    private void jBtAjudaAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAjudaAcessoActionPerformed
        // TODO add your handling code here:
        mostrarAjuda();
    }//GEN-LAST:event_jBtAjudaAcessoActionPerformed

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        mostrarInternoPesquisado();
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jComboBoxKitPersonalizadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxKitPersonalizadoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            if (jComboBoxKitPersonalizado.getSelectedItem().equals("Selecione...")) {
                jComboBoxTipoKit.setSelectedItem("Selecione...");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Sim")) {
                jComboBoxTipoKit.removeAllItems();
                jComboBoxTipoKit.addItem("Kit Personalizado");
                jIdKit.setText("0");
                jIdRegistroComp.setText("0");
            } else if (jComboBoxKitPersonalizado.getSelectedItem().equals("Não")) {
                jComboBoxTipoKit.removeAllItems();
                jComboBoxTipoKit.addItem("Selecione...");
                jIdKit.setText("0");
                jIdRegistroComp.setText("0");
            }
        }
    }//GEN-LAST:event_jComboBoxKitPersonalizadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAjudaAcesso;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarInterno;
    private javax.swing.JButton jBtAuditoria;
    private javax.swing.JButton jBtAuditoriaItens;
    private javax.swing.JButton jBtBiometria;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarInterno;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirInterno;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImpressao;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoInterno;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtPesquisarKit;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairInterno;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarInterno;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JComboBox<String> jComboBoxKitPersonalizado;
    public static javax.swing.JComboBox jComboBoxPavilhao;
    public static javax.swing.JComboBox<String> jComboBoxPesquisarTipoKit;
    public static javax.swing.JComboBox jComboBoxTipoKit;
    public static com.toedter.calendar.JDateChooser jDataEntrega;
    private com.toedter.calendar.JDateChooser jDataLanc;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    public static javax.swing.JLabel jFotoInternoKit;
    private javax.swing.JFormattedTextField jHorarioInicial;
    public static javax.swing.JFormattedTextField jHorarioPagto;
    private javax.swing.JFormattedTextField jHorarioTermino;
    public static javax.swing.JTextField jIDPesqLanc;
    public static javax.swing.JTextField jID_Kit_anual;
    public static javax.swing.JTextField jID_Kit_decendial;
    public static javax.swing.JTextField jID_Kit_inicial;
    public static javax.swing.JTextField jID_Kit_mensal;
    public static javax.swing.JTextField jID_Kit_quinzenal;
    public static javax.swing.JTextField jID_Kit_semestral;
    public static javax.swing.JTextField jID_REG_anual;
    public static javax.swing.JTextField jID_REG_decendial;
    public static javax.swing.JTextField jID_REG_inicial;
    public static javax.swing.JTextField jID_REG_mensal;
    public static javax.swing.JTextField jID_REG_quinzenal;
    public static javax.swing.JTextField jID_REG_semestral;
    public static javax.swing.JTextField jIdInterno;
    public static javax.swing.JTextField jIdKit;
    public static javax.swing.JTextField jIdLanc;
    public static javax.swing.JTextField jIdRegistroComp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jPesqNomeInternoVisitado;
    public static javax.swing.JRadioButton jRBtKitAnual;
    public static javax.swing.JRadioButton jRBtKitDecendial;
    public static javax.swing.JRadioButton jRBtKitInicial;
    public static javax.swing.JRadioButton jRBtKitMensal;
    public static javax.swing.JRadioButton jRBtKitQuinzenal;
    public static javax.swing.JRadioButton jRBtKitSemestral;
    private javax.swing.JTextField jResponsavel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jStatusLanc;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaPagamentoKit;
    public static javax.swing.JTable jTabelaProdutosKitInterno;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
    }

    public void corCampos() {
        jIdLanc.setBackground(Color.white);
        jStatusLanc.setBackground(Color.white);
        jDataLanc.setBackground(Color.white);
        jResponsavel.setBackground(Color.white);
        jHorarioInicial.setBackground(Color.white);
        jHorarioTermino.setBackground(Color.white);
        jIdKit.setBackground(Color.white);
        jIdRegistroComp.setBackground(Color.white);
        jComboBoxTipoKit.setBackground(Color.white);
        jComboBoxPavilhao.setBackground(Color.white);
        jComboBoxKitPersonalizado.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jID_REG_inicial.setBackground(Color.white);
        jID_REG_decendial.setBackground(Color.white);
        jID_REG_quinzenal.setBackground(Color.white);
        jID_REG_mensal.setBackground(Color.white);
        jID_REG_semestral.setBackground(Color.white);
        jID_REG_anual.setBackground(Color.white);
        //
        jID_Kit_inicial.setBackground(Color.white);
        jID_Kit_decendial.setBackground(Color.white);
        jID_Kit_quinzenal.setBackground(Color.white);
        jID_Kit_mensal.setBackground(Color.white);
        jID_Kit_semestral.setBackground(Color.white);
        jID_Kit_anual.setBackground(Color.white);
        //
        jIdInterno.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jDataEntrega.setBackground(Color.white);
        jHorarioPagto.setBackground(Color.white);
    }

    public void pesquisarTelaAcesso() {
        jComboBoxTipoKit.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT NomeTela "
                    + "FROM KITS_HIGIENE_INTERNO");
            conecta.rs.first();
            do {
                jComboBoxTipoKit.addItem(conecta.rs.getString("NomeTela"));
            } while (conecta.rs.next());
            jComboBoxTipoKit.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void limparCampos() {
        jIdInterno.setText("");
        jNomeInterno.setText("");
        //     
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("");
    }

    public void limparCamposManutencao() {
        jIdLanc.setText("");
        jStatusLanc.setText("");
        jDataLanc.setDate(null);
        jResponsavel.setText("");
        jHorarioInicial.setText("");
        jHorarioTermino.setText("");
        jIdKit.setText("0");
        jIdRegistroComp.setText("0");
        jComboBoxTipoKit.setSelectedItem("Selecione...");
        jComboBoxPavilhao.setSelectedItem("Selecione...");
        jComboBoxKitPersonalizado.setSelectedItem("Selecione...");
        jComboBoxTipoKit.setSelectedItem("Selecione...");
        jObservacao.setText("");
        //
        jID_REG_inicial.setText("0");
        jID_REG_decendial.setText("0");
        jID_REG_quinzenal.setText("0");
        jID_REG_mensal.setText("0");
        jID_REG_semestral.setText("0");
        jID_REG_anual.setText("0");
        //
        jID_Kit_inicial.setText("0");
        jID_Kit_decendial.setText("0");
        jID_Kit_quinzenal.setText("0");
        jID_Kit_mensal.setText("0");
        jID_Kit_semestral.setText("0");
        jID_Kit_anual.setText("0");
        //
        jRBtKitInicial.setSelected(!true);
        jRBtKitDecendial.setSelected(!true);
        jRBtKitQuinzenal.setSelected(!true);
        jRBtKitMensal.setSelected(!true);
        jRBtKitSemestral.setSelected(!true);
        jRBtKitAnual.setSelected(!true);
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        //       
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("");
    }

    public void bloquearCampos(boolean opcao) {
        jDataLanc.setEnabled(opcao);
        jResponsavel.setEnabled(opcao);
        jHorarioInicial.setEnabled(opcao);
        jHorarioTermino.setEnabled(opcao);
        jComboBoxTipoKit.setEnabled(opcao);
        jComboBoxPavilhao.setEnabled(opcao);
        jComboBoxKitPersonalizado.setEnabled(opcao);
        jObservacao.setEnabled(opcao);
        //
        jID_REG_inicial.setEnabled(opcao);
        jID_REG_decendial.setEnabled(opcao);
        jID_REG_quinzenal.setEnabled(opcao);
        jID_REG_mensal.setEnabled(opcao);
        jID_REG_semestral.setEnabled(opcao);
        jID_REG_anual.setEnabled(opcao);
        //
        jID_Kit_inicial.setEnabled(opcao);
        jID_Kit_decendial.setEnabled(opcao);
        jID_Kit_quinzenal.setEnabled(opcao);
        jID_Kit_mensal.setEnabled(opcao);
        jID_Kit_semestral.setEnabled(opcao);
        jID_Kit_anual.setEnabled(opcao);
        //
        jDataEntrega.setEnabled(opcao);
        jHorarioPagto.setEnabled(opcao);
    }

    public void bloquearBotoes(boolean opcao) {
        jBtNovo.setEnabled(opcao);
        jBtAlterar.setEnabled(opcao);
        jBtExcluir.setEnabled(opcao);
        jBtSalvar.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtFinalizar.setEnabled(opcao);
        jBtAuditoria.setEnabled(opcao);
        jBtPesquisarKit.setEnabled(opcao);
        //               
        jBtNovoInterno.setEnabled(opcao);
        jBtAlterarInterno.setEnabled(opcao);
        jBtExcluirInterno.setEnabled(opcao);
        jBtSalvarInterno.setEnabled(opcao);
        jBtCancelarInterno.setEnabled(opcao);
        jBtBiometria.setEnabled(opcao);
        jBtAuditoriaItens.setEnabled(opcao);
    }

    public void Novo() {
        jStatusLanc.setText("ABERTO");
        jDataLanc.setCalendar(Calendar.getInstance());
        jResponsavel.setText(nameUser);
        jHorarioInicial.setText(jHoraSistema.getText());
        jHorarioTermino.setText("00:00");
        //
        jDataLanc.setEnabled(true);
        jHorarioInicial.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        // jComboBoxTipoKit.setEnabled(true);
        jComboBoxPavilhao.setEnabled(true);
        jComboBoxKitPersonalizado.setEnabled(true);
        jObservacao.setEnabled(true);
        //
        jBtPesquisarKit.setEnabled(true);
        //        
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Alterar() {
        jResponsavel.setEnabled(true);
        jHorarioInicial.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        jObservacao.setEnabled(true);
        //        
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void AlterarTabelaInternosZero() {
        jDataLanc.setEnabled(true);
        jResponsavel.setEnabled(true);
        jHorarioInicial.setEnabled(true);
        jHorarioTermino.setEnabled(true);
        jComboBoxKitPersonalizado.setEnabled(true);
        //  jComboBoxTipoKit.setEnabled(true);
        jObservacao.setEnabled(true);
        //        
        jBtPesquisarKit.setEnabled(true);
        //
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
    }

    public void Excluir() {
        bloquearCampos(!true);
        bloquearBotoes(!true);
        limparCampos();
        limparCamposManutencao();
        jBtNovo.setEnabled(true);
    }

    public void Salvar() {
        bloquearCampos(!true);
        bloquearBotoes(!true);
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
        //       
        jBtNovoInterno.setEnabled(true);
        jBtBiometria.setEnabled(true);
    }

    public void Cancelar() {
        if (jIdLanc.getText().equals("")) {
            limparCamposManutencao();
            bloquearBotoes(!true);
            bloquearCampos(!true);
            jBtNovo.setEnabled(true);
        } else {
            bloquearBotoes(!true);
            bloquearCampos(!true);
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            jBtAuditoria.setEnabled(true);
            //       
            jBtNovoInterno.setEnabled(true);
            jBtBiometria.setEnabled(true);
        }
    }

    public void FINALIZAR_kits() {
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        String statusLanc = "FINALIZADO";
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPag.setStatusLanc(statusLanc);
            objPag.setIdPagto(Integer.parseInt(jIdLanc.getText()));
            CONTROLE_KIT_manutencao.finalizarPagamentoKit(objPag);
            jStatusLanc.setText("FINALIZADO");
            if (tipoServidor == null || tipoServidor.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
            } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
                String dataConvert = formatoAmerica.format(jDataLanc.getDate().getTime());
                try {
                    java.sql.Date data = new java.sql.Date(formatoAmerica.parse(dataConvert).getTime());
                    objComp.setDataPagamentoKit(data);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (jComboBoxKitPersonalizado.getSelectedItem().equals("Sim") && jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                    //FAZER UM FOR
                    if (jRBtKitInicial.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_inicial.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_inicial.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitDecendial.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_decendial.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_decendial.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitQuinzenal.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_quinzenal.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_quinzenal.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitMensal.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_mensal.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_mensal.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitSemestral.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_semestral.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_semestral.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitAnual.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_anual.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_anual.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                } else {
                    //INFORMAR QUE O KIT FOI PAGO.
                    objComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                    objComp.setKitPago(pRespostaKit);
                    controlPagoKit.confirmarPagamentoKit(objComp);
                    //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                    objComp.setIdKit(Integer.valueOf(jIdKit.getText()));
                    objComp.setKitPago("Sim");
                    controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                    //
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    //
                    jBtNovo.setEnabled(true);
                    jBtAlterar.setEnabled(!true);
                    jBtExcluir.setEnabled(!true);
                    jBtSalvar.setEnabled(!true);
                    jBtCancelar.setEnabled(!true);
                    jBtFinalizar.setEnabled(!true);
                    //
                    jBtNovoInterno.setEnabled(!true);
                    jBtAlterarInterno.setEnabled(!true);
                    jBtExcluirInterno.setEnabled(!true);
                    jBtSalvarInterno.setEnabled(!true);
                    jBtCancelarInterno.setEnabled(!true);
                }
            } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
                //INFORMAR QUE O KIT FOI PAGO.
                objComp.setIdRegistroComp(Integer.valueOf(jIdRegistroComp.getText()));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    java.sql.Date data = new java.sql.Date(format.parse(jDataSistema.getText()).getTime());
                    objComp.setDataPagamentoKit(data);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (jComboBoxKitPersonalizado.getSelectedItem().equals("Sim") && jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                    //FAZER UM FOR
                    if (jRBtKitInicial.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_inicial.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_inicial.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitDecendial.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_decendial.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_decendial.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitQuinzenal.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_quinzenal.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_quinzenal.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitMensal.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_mensal.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_mensal.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitSemestral.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_semestral.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_semestral.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                    if (jRBtKitAnual.isSelected()) {
                        //INFORMAR QUE O KIT FOI PAGO.
                        objComp.setIdRegistroComp(Integer.valueOf(jID_REG_anual.getText()));
                        objComp.setKitPago(pRespostaKit);
                        controlPagoKit.confirmarPagamentoKit(objComp);
                        //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                        objComp.setIdKit(Integer.valueOf(jID_Kit_anual.getText()));
                        objComp.setKitPago("Sim");
                        controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                        //
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                        //
                        bloquearBotoes(!true);
                        bloquearCampos(!true);
                        //
                        jBtNovo.setEnabled(true);
                        jBtAlterar.setEnabled(!true);
                        jBtExcluir.setEnabled(!true);
                        jBtSalvar.setEnabled(!true);
                        jBtCancelar.setEnabled(!true);
                        jBtFinalizar.setEnabled(!true);
                        //
                        jBtNovoInterno.setEnabled(!true);
                        jBtAlterarInterno.setEnabled(!true);
                        jBtExcluirInterno.setEnabled(!true);
                        jBtSalvarInterno.setEnabled(!true);
                        jBtCancelarInterno.setEnabled(!true);
                    }
                } else {
                    objComp.setKitPago(pRespostaKit);
                    controlPagoKit.confirmarPagamentoKit(objComp);
                    //CONFIRMAR O PAGAMENTO DO KIT TAMBÉM NA TABELA "PROGRAMACAO_PAGAMENTO_KITS_INTERNOS" DA PROGRAMAÇÃO INDEPENDENTE.
                    objComp.setIdKit(Integer.valueOf(jIdKit.getText()));
                    objComp.setKitPago("Sim");
                    controlPagoKit.confirmarPagamentoKitProgramacao(objComp);
                    //
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
                    //
                    bloquearBotoes(!true);
                    bloquearCampos(!true);
                    //
                    jBtNovo.setEnabled(true);
                    jBtAlterar.setEnabled(!true);
                    jBtExcluir.setEnabled(!true);
                    jBtSalvar.setEnabled(!true);
                    jBtCancelar.setEnabled(!true);
                    jBtFinalizar.setEnabled(!true);
                    //
                    jBtNovoInterno.setEnabled(!true);
                    jBtAlterarInterno.setEnabled(!true);
                    jBtExcluirInterno.setEnabled(!true);
                    jBtSalvarInterno.setEnabled(!true);
                    jBtCancelarInterno.setEnabled(!true);
                }
            }
        }
    }

    public void NovoInterno() {
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jDataEntrega.setCalendar(Calendar.getInstance());
        jHorarioPagto.setText(jHoraSistema.getText());
        //
        jDataEntrega.setEnabled(true);
        jHorarioPagto.setEnabled(true);
        //        
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void AlterarInterno() {
        //       
        jBtSalvarInterno.setEnabled(true);
        jBtCancelarInterno.setEnabled(true);
    }

    public void ExcluirInterno() {
        limparCampos();
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //    
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(true);
        jBtAuditoriaItens.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void SalvarInterno() {
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("00:00");
        //       
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //       
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
        jBtBiometria.setEnabled(true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoria.setEnabled(true);
        jBtFinalizar.setEnabled(true);
    }

    public void CancelarInterno() {
        //
        jIdInterno.setText("");
        jNomeInterno.setText("");
        jFotoInternoKit.setIcon(null);
        jDataEntrega.setDate(null);
        jHorarioPagto.setText("00:00");
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        // ABA INTERNOS
        jBtNovoInterno.setEnabled(true);
        jBtAlterarInterno.setEnabled(!true);
        jBtExcluirInterno.setEnabled(!true);
        jBtSalvarInterno.setEnabled(!true);
        jBtCancelarInterno.setEnabled(!true);
        jBtAuditoriaItens.setEnabled(!true);
        jBtBiometria.setEnabled(true);
        // ABA MANUTENÇÃO
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtFinalizar.setEnabled(true);
        jBtAuditoria.setEnabled(true);
    }

    public void VERIFICAR_internos() {
        CONTROLE_KIT_manutencao.pVERIFICAR_interno(objPag);
    }

    public void pBUSCAR_codigo() {
        CONTROLE_KIT_manutencao.pBUSCAR_CODIGO_manutencao(objPag);
    }

    public void pBUSCAR_CODIGO_item() {
        CONTROLE_KIT_manutencao.pBUSCAR_CODIGO_item(objPag);
    }

    public void VERIFICAR_itens() {
        CONTROLE_KIT_manutencao.pVERIFICAR_item(objPag);
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        if (jIdLanc.getText().equals(codLanc)) {
            JOptionPane.showMessageDialog(rootPane, "Antes de excluir esse Lançamento, será necessário\nexcluir primeiro os internos relacionados a esse registro.");
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o interno selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objPag.setIdPagto(Integer.valueOf(jIdLanc.getText()));
            CONTROLE_KIT_manutencao.excluirPagamentoKit(objPag);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
            Excluir();
            if (pCONFIRMARCAO_resposta.equals("Sim")) {
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            } else if (pCONFIRMARCAO_resposta.equals("Não")) {
                JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
            }
        }
    }

    public void preencherComboBoxPavilhao() {
        jComboBoxPavilhao.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * "
                    + "FROM PAVILHAO "
                    + "ORDER BY DescricaoPav");
            conecta.rs.first();
            do {
                jComboBoxPavilhao.addItem(conecta.rs.getString("DescricaoPav"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void PREENCHER_TABELA_GERAL_PAGO_kit() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_TODOS_data()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_GERAL_PAGO_kit0() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_TODOS_data0()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_GERAL_PAGO_kitCodigo() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_TODOS_codigo()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_GERAL_CODIGO_nomeInterno() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_REGISTRO_NOME_INTERNO_CODIGO_nome()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_GERAL_PAGO_kitOBS() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_TODOS_codigoOBS()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabela() {
        while (jTabelaPagamentoKit.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaPagamentoKit.getModel()).removeRow(0);
        }
    }

    public void PREENCHER_TABELA_PAGTO_KIT_nomeInterno() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_REGISTRO_NOME_interno()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_PAGTO_KIT_NOME_tipokit() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_REGISTRO_NOME_INTERNO_tipoKit()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_PAGTO_KIT_NOME_TIPO_data() {
        DefaultTableModel objTodosRegistrosKit = (DefaultTableModel) jTabelaPagamentoKit.getModel();
        try {
            for (PagamentoKitInterno b : CONTROLE_KIT_manutencao.pBUSCAR_REGISTRO_NOME_INTERNO_tipoKitData()) {
                dataEntrada = String.valueOf(b.getDataLanc());
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(String.valueOf(pTOTAL_registros));
                objTodosRegistrosKit.addRow(new Object[]{b.getIdPagto(), dataEntrada, b.getStatusLanc(), b.getTipoKit(), b.getDescricaoPavilhao(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaPagamentoKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaPagamentoKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaPagamentoKit.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PREENCHER_TABELA_PRODUTOS_KIT_interno() {

        DefaultTableModel objProdutosKit = (DefaultTableModel) jTabelaProdutosKitInterno.getModel();
        try {
            for (ProdutoInternosKitLote pp : CONTROLE_KIT_manutencao.pPESQUISAR_PRODUTOS_KITS_PAGO_interno()) {
                objProdutosKit.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKitInterno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKitInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKitInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaProdutosKitInterno.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPagamentoKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabelaProdutosInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaProdutosKitInterno.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutosKitInterno.getModel()).removeRow(0);
        }
    }

    public void pPREENCHER_TABELA_ITENS_internos() {
        DefaultTableModel objTabelaInternos = (DefaultTableModel) jTabelaInternos.getModel();
        try {
            for (ProdutosPagtoKitInterno b : CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTO_interno()) {
                objTabelaInternos.addRow(new Object[]{b.getIdItem(), b.getIdInternoCrc(), b.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabelaInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaInternos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserB1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserB1 + "'");
            conecta.rs.first();
            codigoUserGroupB1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoB1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoB1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserB1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoB1 = conecta.rs.getInt("IdUsuario");
            codAbrirB1 = conecta.rs.getInt("Abrir");
            codIncluirB1 = conecta.rs.getInt("Incluir");
            codAlterarB1 = conecta.rs.getInt("Alterar");
            codExcluirB1 = conecta.rs.getInt("Excluir");
            codGravarB1 = conecta.rs.getInt("Gravar");
            codConsultarB1 = conecta.rs.getInt("Consultar");
            nomeTelaB1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
