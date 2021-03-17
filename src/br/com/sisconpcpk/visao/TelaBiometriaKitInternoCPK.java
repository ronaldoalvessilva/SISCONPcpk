/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.visao;

import br.com.sisconpcpk.dao.ConectaBanco;
import br.com.sisconpcpk.dao.ControleItensProdutosPagamentoKitInternoDao;
import br.com.sisconpcpk.dao.ControleLogSistemaDao;
import br.com.sisconpcpk.dao.ControlePesquisaKitInternoManual;
import br.com.sisconpcpk.dao.ControlePesquisaKitInternoManualBio_PER;
import br.com.sisconpcpk.dao.ControleProdutosKitLote;
import br.com.sisconpcpk.dao.PagamentoKitInternosDao;
import static br.com.sisconpcpk.dao.PagamentoKitInternosDao.qtdInternos;
import br.com.sisconpcpk.modelo.DigitalInternos;
import br.com.sisconpcpk.modelo.ItensPagamentoKitInterno;
import br.com.sisconpcpk.modelo.LogSistema;
import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import br.com.sisconpcpk.modelo.ProdutosPagtoKitInterno;
import static br.com.sisconpcpk.visao.FormPrincipal.jDataSistema;
import static br.com.sisconpcpk.visao.FormPrincipal.jHoraSistema;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.nameUser;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.codItem;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jComboBoxTipoKit;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_anual;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_decendial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_inicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_mensal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_quinzenal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_semestral;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdKit;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdLanc;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitAnual;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitDecendial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitInicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitMensal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitQuinzenal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitSemestral;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jTabelaInternos;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronaldo
 */
public class TelaBiometriaKitInternoCPK extends javax.swing.JDialog {

    ConectaBanco conecta = new ConectaBanco();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    PagamentoKitInternosDao CONTROLE_manutencao = new PagamentoKitInternosDao();
    ControleProdutosKitLote CONTROLE_PRODUTOS_kit = new ControleProdutosKitLote();
    //
    ProdutosPagtoKitInterno objItensPagtoProd = new ProdutosPagtoKitInterno();
    ControleItensProdutosPagamentoKitInternoDao CONTROLE_PRODUTOS_internos = new ControleItensProdutosPagamentoKitInternoDao();
    ControlePesquisaKitInternoManual CONTROLE_PESQUISA_manual = new ControlePesquisaKitInternoManual();
    ControlePesquisaKitInternoManualBio_PER CONTROLE_PESQUISA_personalizado = new ControlePesquisaKitInternoManualBio_PER();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    //
    ControleLogSistemaDao controlLog = new ControleLogSistemaDao();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Base Pavilhão:Pagamento de Kit de Internos:Manutenção";
    String statusMov;
    String horaMov;
    String dataModFinal;
    public static String caminhoFotoInterno;
    // VARIVAEL PARA ARMAZENAR AS DIGITAIS DO BANCO DE DADOS
    String caminhoBiometria = "";
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    // PARA GRAVAR NO BANCO DE DADOS
    public static byte[] pDigitalCapturada = null;
    int tipoEntrada = 1; // MANUAL É (0) - BIOMETRIA (1)
    public static String codigoInterno;
    public static String codigoKit;
    // VARIÁVEIS PARA OS KITS INICIAL E 15 DIAS
    int copo, prato, colher, vasilha, garfo, absorvente, bermuda, lencol, colchao, toalha, camisa, cueca, sandalia, desodorante = 0;
    int cobertor, bola, calcaoJogo, camisaJogo, parMeiao = 0;
    int cremeDental, sabonete, papelHigienico, barbeador, escovaDente, sabaopo = 0;
    int marcaTodos = 0;
    int kitAnual = 0;
    int kitDecimal = 0;
    int kitQuinzenal = 0;
    int kitMensal = 0;
    int kitSemetral = 0;
    int kitPersonalizado = 0;
    //
    public static float estoque = 0;
    public static String codigoInternoKit;
    String kitPago = "Sim";
    public static int pCodigoInterno = 0;
    public static int pCodigoProd = 0;
    public static int pQuantidade = 0;
    public static int pSaldo = 0;
    public static int pID_kit = 0;
    public static String statusFinal = "FINALIZADO";
    public static String pKitPago = "Não"; // PARA PESQUISAR SOMENTE OS INTERNOS QUE AINDA NÃO FORAM PAGO OS KITS.
    public static int pRegistroComp = 0;
    //
    int pZERO = 0;
    String utilizado = "Sim";
    int pTOTAL_ITENS_gravado = 0;
    public static int pTOTAL_ITENS_pesquisado = 0;

    /**
     * Creates new form TelaBiometriaKitInterno
     */
    public static TelaPagamentoKitInternoCPK pagamentoKit;

    public TelaBiometriaKitInternoCPK(TelaPagamentoKitInternoCPK parent, boolean modal) {
        this.pagamentoKit = parent;
        this.setModal(modal);
        setLocationRelativeTo(pagamentoKit);
        initComponents();
        corCampos();
        if (jComboBoxTipoKit.getSelectedItem().equals("Kit Inicial")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_inicial();
        } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Decendial")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_decendial();
        } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Quinzenal")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_quinzenal();
        } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Mensal")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_mensal();
        } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Semestral")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_semestral();
        } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Anual")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_anual();
        } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_inicial();
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_decendial();
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_quinzenal();
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_mensal();
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_semestral();
            pPESQUISA_PAGAMENTO_KIT_INTERNOS_anual();
        }
    }

    // CÓDIGO DA BIOMETRIA CIS FS-80H
    public interface CIS_SDK extends StdCallLibrary {

        CIS_SDK INSTANCE = (CIS_SDK) Native.loadLibrary("CIS_SDK", CIS_SDK.class);

        public int CIS_SDK_Biometrico_Iniciar();

        public int CIS_SDK_Biometrico_Finalizar();

        public int CIS_SDK_Biometrico_LerDigital(PointerByReference pTemplate);

        public Pointer CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(IntByReference iRetorno);

        public int CIS_SDK_Biometrico_CancelarLeitura();

        public int CIS_SDK_Biometrico_CompararDigital(PointerByReference pAmostra1, PointerByReference pAmostra2);

        public Pointer CIS_SDK_Biometrico_LerWSQ(IntByReference iRetorno, IntByReference iSize);

        public int CIS_SDK_Biometrico_LerDigitalComImagem(Pointer pTemplate, IntByReference iTemplate, Pointer pImagem, IntByReference iImagem, int iFundoBranco, int iTipoImagem);

        public Pointer CIS_SDK_Versao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaProdutosKit = new javax.swing.JTable();
        jBtVerificarKit = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jIdInternoKitBio = new javax.swing.JTextField();
        jNomeInternoKitBio = new javax.swing.JTextField();
        jPavilhaoKitBio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMatriculaPenalKitBio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRegimeKitBio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCelaKitBio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jHorarioPagto = new javax.swing.JFormattedTextField();
        jDataEntrega = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jFotoInternoKitBio = new javax.swing.JLabel();
        jBtIniciarLeitor = new javax.swing.JButton();
        jBtCancelarLeitura = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jIdInternoKitBio1 = new javax.swing.JTextField();
        jNomeInternoKitBio1 = new javax.swing.JTextField();
        jPavilhaoKitBio1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jMatriculaPenalKitBio1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jRegimeKitBio1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jCelaKitBio1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jHorarioPagto1 = new javax.swing.JFormattedTextField();
        jDataEntrega1 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jFotoInternoKitBio1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxPesquisarInterno = new javax.swing.JComboBox<>();
        jBtConfirmar = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxOperacao = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jTotalItens = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTOTAL_REG_GRAVADO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Registro de Kit de Internos {Biometria} :::...");

        jProgressBar1.setStringPainted(true);

        jTabelaProdutosKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaProdutosKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Un.", "Quant."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTabelaProdutosKit);
        if (jTabelaProdutosKit.getColumnModel().getColumnCount() > 0) {
            jTabelaProdutosKit.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(1).setMinWidth(390);
            jTabelaProdutosKit.getColumnModel().getColumn(1).setMaxWidth(390);
            jTabelaProdutosKit.getColumnModel().getColumn(2).setMinWidth(60);
            jTabelaProdutosKit.getColumnModel().getColumn(2).setMaxWidth(60);
            jTabelaProdutosKit.getColumnModel().getColumn(3).setMinWidth(70);
            jTabelaProdutosKit.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jBtVerificarKit.setForeground(new java.awt.Color(0, 102, 0));
        jBtVerificarKit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtVerificarKit.setText("Verificar Kit");
        jBtVerificarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVerificarKitActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Completo do Interno");
        jLabel2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Pavilhão");
        jLabel3.setEnabled(false);

        jIdInternoKitBio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoKitBio.setEnabled(false);

        jNomeInternoKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoKitBio.setEnabled(false);

        jPavilhaoKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoKitBio.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Matricula Penal");

        jMatriculaPenalKitBio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenalKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalKitBio.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Regime");

        jRegimeKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeKitBio.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cela");
        jLabel6.setEnabled(false);

        jCelaKitBio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaKitBio.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Entrega");
        jLabel7.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Horário");
        jLabel8.setEnabled(false);

        jHorarioPagto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto.setEnabled(false);

        jDataEntrega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCelaKitBio)
                    .addComponent(jNomeInternoKitBio)
                    .addComponent(jPavilhaoKitBio)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jHorarioPagto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jIdInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMatriculaPenalKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jRegimeKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegimeKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenalKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPavilhaoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCelaKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoInternoKitBio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jFotoInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jFotoInternoKitBio, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jBtIniciarLeitor.setForeground(new java.awt.Color(0, 0, 255));
        jBtIniciarLeitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Biometria16.png"))); // NOI18N
        jBtIniciarLeitor.setText("Iniciar Leitura");
        jBtIniciarLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIniciarLeitorActionPerformed(evt);
            }
        });

        jBtCancelarLeitura.setForeground(new java.awt.Color(204, 0, 0));
        jBtCancelarLeitura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Biometria16Vermelho.png"))); // NOI18N
        jBtCancelarLeitura.setText("Cancelar Leitura");
        jBtCancelarLeitura.setEnabled(false);
        jBtCancelarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarLeituraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtIniciarLeitor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtCancelarLeitura)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtIniciarLeitor)
                    .addComponent(jBtCancelarLeitura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Biometria", new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/Biometria16.png")), jPanel3); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome Completo do Interno");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Pavilhão");

        jIdInternoKitBio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInternoKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInternoKitBio1.setEnabled(false);

        jNomeInternoKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoKitBio1.setEnabled(false);

        jPavilhaoKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhaoKitBio1.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Matricula Penal");

        jMatriculaPenalKitBio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenalKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenalKitBio1.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Regime");

        jRegimeKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegimeKitBio1.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Cela");

        jCelaKitBio1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelaKitBio1.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Data Entrega");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Horário");

        jHorarioPagto1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jHorarioPagto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jHorarioPagto1.setEnabled(false);

        jDataEntrega1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrega1.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCelaKitBio1)
                    .addComponent(jNomeInternoKitBio1)
                    .addComponent(jPavilhaoKitBio1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jDataEntrega1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jHorarioPagto1)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jIdInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMatriculaPenalKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jRegimeKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegimeKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMatriculaPenalKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPavilhaoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCelaKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDataEntrega1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorarioPagto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoInternoKitBio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jFotoInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jFotoInternoKitBio1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Pesquisar Interno:");

        jComboBoxPesquisarInterno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPesquisarInterno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxPesquisarInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/tick.png"))); // NOI18N
        jBtConfirmar.setContentAreaFilled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPesquisarInterno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jBtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manual", new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/191216082320_16.png")), jPanel5); // NOI18N

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/filesave.png"))); // NOI18N
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisconpcpk/imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Operação de Pesquisa:");

        jComboBoxOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Pesquisa por Biometria", "Pesquisa Manual" }));
        jComboBoxOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperacaoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("Total de Itens:");

        jTotalItens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTotalItens.setForeground(new java.awt.Color(204, 0, 0));
        jTotalItens.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTotalItens.setText("0");
        jTotalItens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTotalItens.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTotalItens.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText("Total Gravado:");

        jTOTAL_REG_GRAVADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_GRAVADO.setForeground(new java.awt.Color(0, 102, 0));
        jTOTAL_REG_GRAVADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_GRAVADO.setText("0");
        jTOTAL_REG_GRAVADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtVerificarKit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jBtVerificarKit)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtSair, jBtSalvar});

        setSize(new java.awt.Dimension(610, 612));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        jBtSair.setEnabled(!true);
        VERIFICAR_LIBERACAO_BIOMETRIA_internos();
        VERIFICAR_LIBERACAO_MANUAL_internos();
        Integer rows = jTabelaProdutosKit.getRowCount();
        if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria") && jIdInternoKitBio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do interno.");
        } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual") && jIdInternoKitBio1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do interno.");
        } else if (jDataEntrega.getDate() == null && jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
            JOptionPane.showMessageDialog(null, "Informe a data de entrega do kit.");
        } else if (jHorarioPagto.getText().equals("")
                && jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")
                || jHorarioPagto.getText().equals("00:00")
                && jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
            JOptionPane.showMessageDialog(null, "Informe o horário de entrega do kit.");
        } else if (jDataEntrega1.getDate() == null && jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            JOptionPane.showMessageDialog(null, "Informe a data de entrega do kit.");
        } else if (jHorarioPagto1.getText().equals("")
                && jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")
                || jHorarioPagto1.getText().equals("00:00")
                && jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            JOptionPane.showMessageDialog(null, "Informe o horário de entrega do kit.");
        } else if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "É necessário verificar os itens do kit para o interno.");
        } else {
            objItensPagto.setTipoEntrada(tipoEntrada);
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            // ASSINATURA POR BIOMETRIA
            if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
                objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                objItensPagto.setNomeInternoCrcKit(jNomeInternoKitBio.getText());
                //ASSINATURA MANUAL
            } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
                objItensPagto.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                objItensPagto.setNomeInternoCrcKit(jNomeInternoKitBio1.getText());
            }
            objItensPagto.setIdPagto(Integer.valueOf(jIdLanc.getText()));
            objItensPagto.setDataEntrega(jDataEntrega.getDate());
            objItensPagto.setHoraEntrega(jHorarioPagto.getText());
            objItensPagto.setAssinaturaDigital(pDigitalCapturada);
            //
            objItensPagto.setUsuarioInsert(nameUser);
            objItensPagto.setDataInsert(dataModFinal);
            objItensPagto.setHorarioInsert(horaMov);
            if (jIdInternoKitBio.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
            } else if (jIdInternoKitBio1.getText().equals(codigoInterno) && jIdLanc.getText().equals(codigoKit)) {
                JOptionPane.showMessageDialog(rootPane, "Esse interno já recebeu o kit nesse registro.");
            } else {
                CONTROLE_manutencao.incluirPagamentoKitInterno(objItensPagto);
                //          
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                //
                pBUSCAR_CODIGO_item();
                limparTabelaInternos();
                PREENCHER_TABELA_internos();
                Salvar();
                bloquearCampos();
                gravarDadosBanco();
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtIniciarLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIniciarLeitorActionPerformed
        // TODO add your handling code here:
        Novo();
        abrirCampos();
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        //
        int iRetorno = dll.CIS_SDK_Biometrico_Iniciar();
        if (iRetorno != 1 && iRetorno == 0) {
            JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -1) {
            JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
            return;
        } else if (iRetorno != 1 && iRetorno == -10) {
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -11) {
            JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
            return;
        } else if (iRetorno != 1 && iRetorno == -12) {
            JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -13) {
            JOptionPane.showMessageDialog(null, "SDK EM USO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -14) {
            JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -15) {
            JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -16) {
            JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -17) {
            JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -18) {
            JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -21) {
            JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -22) {
            JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -23) {
            JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -24) {
            JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
            return;
        } else if (iRetorno != 1 && iRetorno == -25) {
            JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
            return;
        } else if (iRetorno != 1 && iRetorno == -26) {
            JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
            return;
        } else if (iRetorno != 1 && iRetorno == -27) {
            JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -28) {
            JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
            return;
        } else if (iRetorno != 1 && iRetorno == -29) {
            JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
            return;
        }
        jBtCancelarLeitura.setEnabled(true);
        new Thread(LerDigital1).start();
    }//GEN-LAST:event_jBtIniciarLeitorActionPerformed

    private void jBtCancelarLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarLeituraActionPerformed
        // TODO add your handling code here:
        // Instanciar a DLL
        CIS_SDK dll = CIS_SDK.INSTANCE;
        // Cancelar a leitura 
        dll.CIS_SDK_Biometrico_CancelarLeitura();
        // HABILITAR O BOTÃO PARA CANCELAR A LEITURA
        jBtCancelarLeitura.setEnabled(false);
    }//GEN-LAST:event_jBtCancelarLeituraActionPerformed

    private void jBtVerificarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVerificarKitActionPerformed
        // TODO add your handling code here:        
        if (jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
            if (jComboBoxOperacao.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de pesquisa dos produtos.");
            } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
                limparTabelaProdutosKit();
                pPESQUISAR_TODOS_PRODUTOS_KIT_INTERNOS_Biometria();
            } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
                limparTabelaProdutosKit();
                pPESQUISAR_TODOS_PRODUTOS_KIT_InternoManual();
            }
        } else {
            if (jComboBoxOperacao.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o tipo de pesquisa dos produtos.");
            } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
                limparTabelaProdutosKit();
                pPESQUISAR_PRODUTOS_KIT_INTERNOS_biometria();
            } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
                limparTabelaProdutosKit();
                pPESQUISAR_PRODUTOS_KIT_INTERNOS_manual();
            }
        }
    }//GEN-LAST:event_jBtVerificarKitActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxPesquisarInterno.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o interno para pesquisar os produtos.");
        } else {
            Novo();
            abrirCampos();
            pPESQUISAR_INTERNO_kit();
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jComboBoxOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperacaoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            jTabbedPane1.setSelectedIndex(1);
        } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jComboBoxOperacaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBiometriaKitInternoCPK dialog = new TelaBiometriaKitInternoCPK(pagamentoKit, true);
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
    private javax.swing.JButton jBtCancelarLeitura;
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtIniciarLeitor;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVerificarKit;
    public static javax.swing.JTextField jCelaKitBio;
    public static javax.swing.JTextField jCelaKitBio1;
    private javax.swing.JComboBox<String> jComboBoxOperacao;
    public static javax.swing.JComboBox<String> jComboBoxPesquisarInterno;
    private com.toedter.calendar.JDateChooser jDataEntrega;
    private com.toedter.calendar.JDateChooser jDataEntrega1;
    public static javax.swing.JLabel jFotoInternoKitBio;
    public static javax.swing.JLabel jFotoInternoKitBio1;
    private javax.swing.JFormattedTextField jHorarioPagto;
    private javax.swing.JFormattedTextField jHorarioPagto1;
    public static javax.swing.JTextField jIdInternoKitBio;
    public static javax.swing.JTextField jIdInternoKitBio1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jMatriculaPenalKitBio;
    public static javax.swing.JTextField jMatriculaPenalKitBio1;
    public static javax.swing.JTextField jNomeInternoKitBio;
    public static javax.swing.JTextField jNomeInternoKitBio1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JTextField jPavilhaoKitBio;
    public static javax.swing.JTextField jPavilhaoKitBio1;
    private javax.swing.JProgressBar jProgressBar1;
    public static javax.swing.JTextField jRegimeKitBio;
    public static javax.swing.JTextField jRegimeKitBio1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTOTAL_REG_GRAVADO;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaProdutosKit;
    private javax.swing.JTextField jTotalItens;
    // End of variables declaration//GEN-END:variables

    private static Runnable LerDigital1 = new Runnable() {
        @Override
        public void run() {
            try {
                // Instanciar a DLL
                CIS_SDK dll = CIS_SDK.INSTANCE;
                // Capturar a digital no leitor   
                Pointer pDigital;
                IntByReference iRet = new IntByReference();
                pDigital = dll.CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(iRet);
                int iRetorno2 = iRet.getValue();
                if (iRetorno2 != 1 && iRetorno2 == 0) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -1) {
                    JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -10) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -11) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -12) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -13) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "SDK EM USO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -14) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -15) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -16) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -17) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -18) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -21) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -22) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -23) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -24) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -25) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -26) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -27) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -28) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
                    return;
                } else if (iRetorno2 != 1 && iRetorno2 == -29) {
                    dll.CIS_SDK_Biometrico_Finalizar();
                    JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
                    return;
                }
                //
                byte[] pDigitalCap = pDigital.getByteArray(0, 669);
                pDigitalCapturada = pDigitalCap; // SALVAR DIGITAL NO BANCO DE DADOS
                //
                PagamentoKitInternosDao digiControl = new PagamentoKitInternosDao();
                DigitalInternos d = new DigitalInternos();
                int pVar = 0;
                for (DigitalInternos dd : digiControl.read()) {
                    // LER DIGITAL PARA COMPRAR
                    final Pointer p1 = new Memory(669);
                    p1.write(0, pDigitalCap, 0, pDigitalCap.length);
                    final PointerByReference pr1 = new PointerByReference();
                    pr1.setPointer(p1);
                    // DIGITAL DO BANCO DE DADOS - DEDO UM                   
                    Pointer p2 = new Memory(669);
                    p2.write(0, dd.getBiometriaDedo1(), 0, dd.getBiometriaDedo1().length);
                    PointerByReference pr2 = new PointerByReference();
                    pr2.setPointer(p2);
                    // DIGITAL DO BANCO DE DADOS - DEDO DOIS  
                    Pointer p3 = new Memory(669);
                    p3.write(0, dd.getBiometriaDedo2(), 0, dd.getBiometriaDedo2().length);
                    PointerByReference pr3 = new PointerByReference();
                    pr3.setPointer(p3);
                    // DIGITAL DO BANCO DE DADOS - DEDO TRÊS  
                    Pointer p4 = new Memory(669);
                    p4.write(0, dd.getBiometriaDedo3(), 0, dd.getBiometriaDedo3().length);
                    PointerByReference pr4 = new PointerByReference();
                    pr4.setPointer(p4);
                    // DIGITAL DO BANCO DE DADOS - DEDO QUATRO  
                    Pointer p5 = new Memory(669);
                    p5.write(0, dd.getBiometriaDedo4(), 0, dd.getBiometriaDedo4().length);
                    PointerByReference pr5 = new PointerByReference();
                    pr5.setPointer(p5);
                    // COMPARA TODAS AS DIGITAIS                 
                    int iRetorno = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr2);
                    int iRetornod1 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr3);
                    int iRetornod2 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr4);
                    int iRetornod3 = dll.CIS_SDK_Biometrico_CompararDigital(pr1, pr5);
                    // VERIFICAR SE A DIGITAL EXISTE OU NÃO
                    if (iRetorno == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        if (caminhoFotoInterno != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                            jFotoInternoKitBio.setIcon(a);
                            jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        byte[] imgBytes = dd.getImagemFrente();
                        if (imgBytes != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imgBytes);
                            Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoInternoKitBio.setIcon(icon);
                        }
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    } else if (iRetornod1 == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        if (caminhoFotoInterno != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                            jFotoInternoKitBio.setIcon(a);
                            jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        byte[] imgBytes = dd.getImagemFrente();
                        if (imgBytes != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imgBytes);
                            Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoInternoKitBio.setIcon(icon);
                        }
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    } else if (iRetornod2 == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        if (caminhoFotoInterno != null) {
                            javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                            jFotoInternoKitBio.setIcon(a);
                            jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        }
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        byte[] imgBytes = dd.getImagemFrente();
                        if (imgBytes != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imgBytes);
                            Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoInternoKitBio.setIcon(icon);
                        }
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    } else if (iRetornod3 == 1) {
                        jIdInternoKitBio.setText(String.valueOf(dd.getIdInternoCrc()));
                        jNomeInternoKitBio.setText(dd.getNomeInternoCrc());
                        jMatriculaPenalKitBio.setText(dd.getMatriculaPenal());
                        jRegimeKitBio.setText(dd.getRegime());
                        jPavilhaoKitBio.setText(dd.getPavilhao());
                        jCelaKitBio.setText(dd.getCela());
                        caminhoFotoInterno = dd.getCaminhoFotoInterno();
                        javax.swing.ImageIcon a = new javax.swing.ImageIcon(caminhoFotoInterno);
                        jFotoInternoKitBio.setIcon(a);
                        jFotoInternoKitBio.setIcon(new ImageIcon(a.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_DEFAULT)));
                        // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                        byte[] imgBytes = dd.getImagemFrente();
                        if (imgBytes != null) {
                            ImageIcon pic = null;
                            pic = new ImageIcon(imgBytes);
                            Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitBio.getWidth(), jFotoInternoKitBio.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(scaled);
                            jFotoInternoKitBio.setIcon(icon);
                        }
                        JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !!!");
                        int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                        return;
                    }
                    // SE iRetorno FOR IGUAL A -2 E pVar FOR IGUAL A count DIGITAL NÃO CADASTRADA                        
                    if (iRetorno == -2 && iRetornod1 == -2 && iRetornod2 == -2 && iRetornod3 == -2 && qtdInternos == pVar) {
                        break;
                    }
                    pVar = pVar + 1;
                }
                JOptionPane.showMessageDialog(null, "Digital não cadastrada, procure o CRC !!!");
                // Finalizar o SDK 
                int idRetorno = dll.CIS_SDK_Biometrico_Finalizar();
                if (idRetorno != 1 && idRetorno == 0) {
                    JOptionPane.showMessageDialog(null, "COMANDO NÃO EXECUTADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -1) {
                    JOptionPane.showMessageDialog(null, "LEITOR INCOMPATIVEL COM SDK...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -10) {
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -11) {
                    JOptionPane.showMessageDialog(null, "FALTA DE MEMÓRIA...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -12) {
                    JOptionPane.showMessageDialog(null, "ARGUMENTO INVALIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -13) {
                    JOptionPane.showMessageDialog(null, "SDK EM USO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -14) {
                    JOptionPane.showMessageDialog(null, "TEMPLATE INVALIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -15) {
                    JOptionPane.showMessageDialog(null, "ERRO INTERNO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -16) {
                    JOptionPane.showMessageDialog(null, "NÃO HABILITADO PARA CAPTURAR DIGITAL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -17) {
                    JOptionPane.showMessageDialog(null, "CANCELADO PELO USUARIO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -18) {
                    JOptionPane.showMessageDialog(null, "LEITURA NÃO É POSSIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -21) {
                    JOptionPane.showMessageDialog(null, "ERRO DESCONHECIDO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -22) {
                    JOptionPane.showMessageDialog(null, "SDK NÃO FOI INICIADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -23) {
                    JOptionPane.showMessageDialog(null, "LEITOR NÃO CONECTADO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -24) {
                    JOptionPane.showMessageDialog(null, "ERRO NO LEITOR...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -25) {
                    JOptionPane.showMessageDialog(null, "FRAME DE DADOS VAZIO...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -26) {
                    JOptionPane.showMessageDialog(null, "ORIGEM FALSA (FAKE)...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -27) {
                    JOptionPane.showMessageDialog(null, "HARDWARE INCOMPATIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -28) {
                    JOptionPane.showMessageDialog(null, "FIRMWARE INCOMPATIVEL...");
                    return;
                } else if (idRetorno != 1 && idRetorno == -29) {
                    JOptionPane.showMessageDialog(null, "FRAME ALTERADO...");
                    return;
                }
                d.setBiometriaDedo1(pDigitalCap);
                d.setBiometriaDedo2(pDigitalCap);
                d.setBiometriaDedo3(pDigitalCap);
                d.setBiometriaDedo4(pDigitalCap);
            } catch (Exception e) {
            }
        }
    ;

    };            
 
 //---------------------------------------------------------------------
     public void corCampos() {
        jIdInternoKitBio.setBackground(Color.white);
        jMatriculaPenalKitBio.setBackground(Color.white);
        jNomeInternoKitBio.setBackground(Color.white);
        jRegimeKitBio.setBackground(Color.white);
        jPavilhaoKitBio.setBackground(Color.white);
        jCelaKitBio.setBackground(Color.white);
        //
        jDataEntrega.setBackground(Color.white);
        jHorarioPagto.setBackground(Color.white);
        //
        jIdInternoKitBio1.setBackground(Color.white);
        jMatriculaPenalKitBio1.setBackground(Color.white);
        jNomeInternoKitBio1.setBackground(Color.white);
        jRegimeKitBio1.setBackground(Color.white);
        jPavilhaoKitBio1.setBackground(Color.white);
        jCelaKitBio1.setBackground(Color.white);
        //
        jTotalItens.setBackground(Color.white);
        jDataEntrega1.setBackground(Color.white);
        jHorarioPagto1.setBackground(Color.white);
    }

    public void Novo() {
        jDataEntrega.setCalendar(Calendar.getInstance());
        jHorarioPagto.setText(jHoraSistema.getText());
        if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
            jIdInternoKitBio.setText("");
            jNomeInternoKitBio.setText("");
            jRegimeKitBio.setText("");
            jPavilhaoKitBio.setText("");
            jCelaKitBio.setText("");
            //
            jIdInternoKitBio1.setText("");
            jNomeInternoKitBio1.setText("");
            jRegimeKitBio1.setText("");
            jPavilhaoKitBio1.setText("");
            jCelaKitBio1.setText("");
            //
            jDataEntrega.setEnabled(true);
            jHorarioPagto.setEnabled(true);
        } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            jIdInternoKitBio1.setText("");
            jNomeInternoKitBio1.setText("");
            jRegimeKitBio1.setText("");
            jPavilhaoKitBio1.setText("");
            jCelaKitBio1.setText("");
            //
            jIdInternoKitBio.setText("");
            jNomeInternoKitBio.setText("");
            jRegimeKitBio.setText("");
            jPavilhaoKitBio.setText("");
            jCelaKitBio.setText("");
            //
            jDataEntrega1.setCalendar(Calendar.getInstance());
            jHorarioPagto1.setText(jHoraSistema.getText());
            //
            jDataEntrega1.setEnabled(true);
            jHorarioPagto1.setEnabled(true);
        }
        //APAGAR REGISTRO DA TABELA
        Integer rows = jTabelaProdutosKit.getRowCount();
        if (rows != 0) {
            // APAGAR DADOS DA TABELA
            while (jTabelaProdutosKit.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaProdutosKit.getModel()).removeRow(0);
            }
        }
    }

    public void Salvar() {
        if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
            jDataEntrega.setEnabled(!true);
            jHorarioPagto.setEnabled(!true);
            //
            jBtSalvar.setEnabled(!true);
            jBtIniciarLeitor.setEnabled(true);
        } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
            jDataEntrega1.setEnabled(!true);
            jHorarioPagto1.setEnabled(!true);
            //
            jBtSalvar.setEnabled(!true);
            jBtIniciarLeitor.setEnabled(true);
        }
    }

    public void abrirCampos() {
        jBtSalvar.setEnabled(true);
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
    }

    public void bloquearCampos() {
        //
        jDataEntrega.setEnabled(!true);
        jHorarioPagto.setEnabled(!true);
        //
        jDataEntrega1.setEnabled(!true);
        jHorarioPagto1.setEnabled(!true);
    }

    public void pPESQUISAR_INTERNO_kit() {
        try {
            for (ProdutosPagtoKitInterno pp : CONTROLE_PESQUISA_manual.pBUSCAR_DADOS_interno()) {
                jIdInternoKitBio1.setText(String.valueOf(pp.getIdInternoCrc()));
                jNomeInternoKitBio1.setText(pp.getNomeInternoCrc());
                jRegimeKitBio1.setText(pp.getRegime());
                jPavilhaoKitBio1.setText(pp.getDescricaoPavilhao());
                jCelaKitBio1.setText(pp.getEnderecoCela());
                caminhoFotoInterno = pp.getCaminhoFoto();
                if (caminhoFotoInterno != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoFotoInterno);
                    jFotoInternoKitBio1.setIcon(i);
                    jFotoInternoKitBio1.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoKitBio1.getWidth(), jFotoInternoKitBio1.getHeight(), Image.SCALE_SMOOTH)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) pp.getImagemFrente());
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInternoKitBio1.getWidth(), jFotoInternoKitBio1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInternoKitBio1.setIcon(icon);
                }
                jDataEntrega1.setCalendar(Calendar.getInstance());
                jHorarioPagto1.setText(jHoraSistema.getText());
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pPESQUISAR_PRODUTOS_KIT_INTERNOS_biometria() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_LIBERACAO_BIOMETRIA_internos(objProdKit);
        if (jIdInternoKitBio.getText().equals(codigoInternoKit)) {
            DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
            ProdutoInternosKitLote p = new ProdutoInternosKitLote();
            try {
                for (ProdutoInternosKitLote pp : CONTROLE_PRODUTOS_kit.read()) {
                    produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                    jTotalItens.setText(String.valueOf(pTOTAL_ITENS_pesquisado));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe kit para esse interno.");
        }
    }

    public void pPESQUISAR_PRODUTOS_KIT_INTERNOS_manual() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_LIBERACAO_MANUAL_internos(objProdKit);
        if (jIdInternoKitBio1.getText().equals(codigoInternoKit)) {
            DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
            ProdutoInternosKitLote p = new ProdutoInternosKitLote();
            try {
                for (ProdutoInternosKitLote pp : CONTROLE_PESQUISA_manual.read()) {
                    produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                    jTotalItens.setText(String.valueOf(pTOTAL_ITENS_pesquisado));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe kit para esse interno.");
        }
    }

    public void VERIFICAR_LIBERACAO_BIOMETRIA_internos() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_LIBERACAO_BIOMETRIA_internos(objProdKit);
    }

    public void VERIFICAR_LIBERACAO_MANUAL_internos() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_VERIFICAR_LIBERACAO_MANUAL_internos(objProdKit);
    }

    public void pBUSCAR_CODIGO_item() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_CODIGO_kitPago(objProdKit);
    }

    //------------------------------ PESQUISAR TODOS OS KITS POR INTERNO -------------------------------------
    //PESQUISAR TODOS OS PRODUTOS DO INTERNO INDEPENDENTE DO KIT
    //PARA TANTO BASTA TER SALDO NO KIT A SER PAGO
    public void pPESQUISAR_TODOS_PRODUTOS_KIT_INTERNOS_Biometria() {
        //PESQUISA CÓDIGO DO INTERNO PARA EXIBIÇÃO DOS PRODUTOS RELACIONADOS A ELE
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_LIBERACAO_BIOMETRIA_internos(objProdKit);
        if (jIdInternoKitBio.getText().equals(codigoInternoKit)) {
            DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
            ProdutoInternosKitLote p = new ProdutoInternosKitLote();
            try {
                for (ProdutoInternosKitLote pp : CONTROLE_PESQUISA_personalizado.PRODUTOS_BIO_read()) {
                    produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                    jTotalItens.setText(String.valueOf(pTOTAL_ITENS_pesquisado));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe kit para esse interno.");
        }
    }

    //PESQUISA MANUAL PARA TODOS OS KITS DE INTERNOS INDEPENDENTE DO TIPO DE KIT
    //PARA TANTO BASTA TER SALDO NO KIT A SER PAGO
    public void pPESQUISAR_TODOS_PRODUTOS_KIT_InternoManual() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_LIBERACAO_MANUAL_internos(objProdKit);
        if (jIdInternoKitBio1.getText().equals(codigoInternoKit)) {
            DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
            ProdutoInternosKitLote p = new ProdutoInternosKitLote();
            try {
                for (ProdutoInternosKitLote pp : CONTROLE_PESQUISA_personalizado.PRODUTOS_MANUAL_read()) {
                    produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                    jTotalItens.setText(String.valueOf(pTOTAL_ITENS_pesquisado));
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                    jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe kit para esse interno.");
        }
    }

    //------------------------------------------------------------------------------------------------------
    //KIT INICIAL
    public void pPESQUISA_PAGAMENTO_KIT_INTERNOS_inicial() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_KIT_inicial(objProdKit);
    }

    //KIT DECENDIAL
    public void pPESQUISA_PAGAMENTO_KIT_INTERNOS_decendial() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_KIT_decendial(objProdKit);
    }

    // KIT QUINZENAL
    public void pPESQUISA_PAGAMENTO_KIT_INTERNOS_quinzenal() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_KIT_quinzenal(objProdKit);
    }

    // KIT MENSAL
    public void pPESQUISA_PAGAMENTO_KIT_INTERNOS_mensal() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_KIT_mensal(objProdKit);
    }

    // KIT SEMESTRAL
    public void pPESQUISA_PAGAMENTO_KIT_INTERNOS_semestral() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_KIT_semestral(objProdKit);
    }

    // KIT ANUAL
    public void pPESQUISA_PAGAMENTO_KIT_INTERNOS_anual() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTOS_KIT_anual(objProdKit);
    }

    public void gravarDadosBanco() {
        pTOTAL_ITENS_gravado = 0;
        // THREAD DOS DADOS
        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    // GRAVAR NA TABELA ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO                         
                    for (int i = 0; i < jTabelaProdutosKit.getRowCount(); i++) {//                          
                        objItensPagtoProd.setUsuarioInsert(nameUser);
                        objItensPagtoProd.setDataInsert(dataModFinal);
                        objItensPagtoProd.setHorarioInsert(horaMov);
                        //CONFIRMAR O RECEBIMENTO DO KIT
                        if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa por Biometria")) {
                            //KIT PERSONALIZADO, OU SEJA COM VÁRIOS PRODUTOS DE VÁRIOS KITS (01/12/2020)
                            if (jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                                objItensPagtoProd.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                                objItensPagtoProd.setIdItem(codItem);
                                objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                objItensPagtoProd.setDataEntrega(jDataEntrega.getDate());
                                objItensPagtoProd.setHorario(jHorarioPagto.getText());
                                objItensPagtoProd.setAssinaturaDigitalInterno(pDigitalCapturada);
                                CONTROLE_PRODUTOS_internos.incluirPagamentoProdutoKitInterno(objItensPagtoProd);
                                //
                                objProdKit.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                objProdKit.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                objProdKit.setDataPagto(jDataEntrega.getDate());
                                objProdKit.setPago(kitPago);
                                // SE O PRODUTO EXISTIR EM QUALQUER KIT O SISTEMA VAI COLOCAR COMO PAGO
                                CONTROLE_PESQUISA_manual.alterarKitInicial(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitDecendial(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitQuinzenal(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitMensal(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitSemestral(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitAnual(objProdKit);
                                //PESQUISAR O PRODUTO DO INTERNO PARA DA BAIXA.
                                if (jRBtKitInicial.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_inicial();
                                    if (jRBtKitInicial.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitDecendial.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_decendial();
                                    if (jRBtKitDecendial.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitQuinzenal.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_quinzenal();
                                    if (jRBtKitQuinzenal.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                        objItensPagtoProd.setQuantItem((int) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitMensal.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_mensal();
                                    if (jRBtKitMensal.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitSemestral.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_semestral();
                                    if (jRBtKitSemestral.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitAnual.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_anual();
                                    if (jRBtKitAnual.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                            } else {
                                //NÃO PERSONALIZADO POR BIOMETRIA
                                objItensPagtoProd.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                                objItensPagtoProd.setIdItem(codItem);
                                objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                objItensPagtoProd.setDataEntrega(jDataEntrega.getDate());
                                objItensPagtoProd.setHorario(jHorarioPagto.getText());
                                objItensPagtoProd.setAssinaturaDigitalInterno(pDigitalCapturada);
                                CONTROLE_PRODUTOS_internos.incluirPagamentoProdutoKitInterno(objItensPagtoProd);
                                //
                                objProdKit.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                objProdKit.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                objProdKit.setDataPagto(jDataEntrega.getDate());
                                objProdKit.setPago(kitPago);
                                // INFORMAR PAGAMENTO DOS KITS
                                if (jComboBoxTipoKit.getSelectedItem().equals("Kit Inicial")) {
                                    CONTROLE_PESQUISA_manual.alterarKitInicial(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Decendial")) {
                                    CONTROLE_PESQUISA_manual.alterarKitDecendial(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Quinzenal")) {
                                    CONTROLE_PESQUISA_manual.alterarKitQuinzenal(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Mensal")) {
                                    CONTROLE_PESQUISA_manual.alterarKitMensal(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Semestral")) {
                                    CONTROLE_PESQUISA_manual.alterarKitSemestral(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Anual")) {
                                    CONTROLE_PESQUISA_manual.alterarKitAnual(objProdKit);
                                }
                                //PESQUISAR O PRODUTO DO INTERNO PARA DA BAIXA.
                                pPESQUISAR_INTERNO_biometria();
                                if (jIdKit.getText().equals(pID_kit) && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                    objItensPagtoProd.setIdPagto(pRegistroComp);
                                    objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                    objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                    objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio.getText()));
                                    objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio.getText());
                                    objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                    pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                    objItensPagtoProd.setQuatProd(pSaldo);
                                    CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                }
                            }
                            // PAGAMENTO QUANDO A BIOMETRIA NÃO FUNCIONAR POR ALGUM MOTIVO
                        } else if (jComboBoxOperacao.getSelectedItem().equals("Pesquisa Manual")) {
                            //KIT PERSONALIZADO, OU SEJA COM VÁRIOS PRODUTOS DE VÁRIOS KITS (01/12/2020)
                            if (jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                                objItensPagtoProd.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                                objItensPagtoProd.setIdItem(codItem);
                                objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                objItensPagtoProd.setDataEntrega(jDataEntrega.getDate());
                                objItensPagtoProd.setHorario(jHorarioPagto.getText());
                                objItensPagtoProd.setAssinaturaDigitalInterno(pDigitalCapturada);
                                CONTROLE_PRODUTOS_internos.incluirPagamentoProdutoKitInterno(objItensPagtoProd);
                                //
                                objProdKit.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                objProdKit.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                objProdKit.setDataPagto(jDataEntrega1.getDate());
                                objProdKit.setPago(kitPago);
                                // SE O PRODUTO EXISTIR EM QUALQUER KIT O SISTEMA VAI COLOCAR COMO PAGO (QUANDO O KIT É PERSONALIZADO)
                                CONTROLE_PESQUISA_manual.alterarKitInicial(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitDecendial(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitQuinzenal(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitMensal(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitSemestral(objProdKit);
                                CONTROLE_PESQUISA_manual.alterarKitAnual(objProdKit);
                                //PESQUISAR O PRODUTO DO INTERNO PARA DA BAIXA.
                                if (jRBtKitInicial.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_inicial();
                                    if (jRBtKitInicial.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitDecendial.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_decendial();
                                    if (jRBtKitDecendial.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitQuinzenal.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_quinzenal();
                                    if (jRBtKitQuinzenal.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitMensal.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_mensal();
                                    if (jRBtKitMensal.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitSemestral.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_semestral();
                                    if (jRBtKitSemestral.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                                if (jRBtKitAnual.isSelected()) {
                                    pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_anual();
                                    if (jRBtKitAnual.isSelected() && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                        objItensPagtoProd.setIdPagto(pRegistroComp);
                                        objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                        objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                        objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                        objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                        objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                        pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                        objItensPagtoProd.setQuatProd(pSaldo);
                                        CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                    }
                                }
                            } else {
                                //NÃO PERSONALIZADO - MANUAL
                                objItensPagtoProd.setIdPagto(Integer.valueOf(jIdLanc.getText()));
                                objItensPagtoProd.setIdItem(codItem);
                                objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                objItensPagtoProd.setQuatProd((float) jTabelaProdutosKit.getValueAt(i, 3));
                                objItensPagtoProd.setDataEntrega(jDataEntrega.getDate());
                                objItensPagtoProd.setHorario(jHorarioPagto.getText());
                                objItensPagtoProd.setAssinaturaDigitalInterno(pDigitalCapturada);
                                CONTROLE_PRODUTOS_internos.incluirPagamentoProdutoKitInterno(objItensPagtoProd);
                                //
                                objProdKit.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                objProdKit.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                objProdKit.setDataPagto(jDataEntrega1.getDate());
                                objProdKit.setPago(kitPago);
                                // INFORMAR PAGAMENTO DOS KITS
                                if (jComboBoxTipoKit.getSelectedItem().equals("Kit Inicial")) {
                                    CONTROLE_PESQUISA_manual.alterarKitInicial(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Decendial")) {
                                    CONTROLE_PESQUISA_manual.alterarKitDecendial(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Quinzenal")) {
                                    CONTROLE_PESQUISA_manual.alterarKitQuinzenal(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Mensal")) {
                                    CONTROLE_PESQUISA_manual.alterarKitMensal(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Semestral")) {
                                    CONTROLE_PESQUISA_manual.alterarKitSemestral(objProdKit);
                                } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Anual")) {
                                    CONTROLE_PESQUISA_manual.alterarKitAnual(objProdKit);
                                }
                                //PESQUISAR O PRODUTO DO INTERNO PARA DA BAIXA.
                                pPESQUISAR_INTERNO_KIT_especifico();
                                if (jIdKit.getText().equals(pID_kit) && objItensPagtoProd.getIdProd() == pCodigoProd) {
                                    objItensPagtoProd.setIdPagto(pRegistroComp);
                                    objItensPagtoProd.setIdProd((int) jTabelaProdutosKit.getValueAt(i, 0));
                                    objItensPagtoProd.setDescricaoProduto((String) jTabelaProdutosKit.getValueAt(i, 1));
                                    objItensPagtoProd.setIdInternoCrc(Integer.valueOf(jIdInternoKitBio1.getText()));
                                    objItensPagtoProd.setNomeInternoCrc(jNomeInternoKitBio1.getText());
                                    objItensPagtoProd.setQuantItem((float) jTabelaProdutosKit.getValueAt(i, 3));
                                    pSaldo = (int) (pQuantidade - objItensPagtoProd.getQuantItem());
                                    objItensPagtoProd.setQuatProd(pSaldo);
                                    CONTROLE_PRODUTOS_internos.alterarPagamentoProdutoKitInterno(objItensPagtoProd);
                                }
                            }
                        }// FIM DA PERSISTÊNCIA
                        pTOTAL_ITENS_gravado = i + 1;
                        jTOTAL_REG_GRAVADO.setText(String.valueOf(pTOTAL_ITENS_gravado));
                        jProgressBar1.setValue(i);
                    }
                    if (pTOTAL_ITENS_gravado == pTOTAL_ITENS_pesquisado) {
                        JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                        jBtSair.setEnabled(true);
                    }
                    //
                    limparCamposBiometria();
                    while (jTabelaProdutosKit.getModel().getRowCount() > 0) {
                        ((DefaultTableModel) jTabelaProdutosKit.getModel()).removeRow(0);
                    }
                    jComboBoxPesquisarInterno.removeAllItems();
                    jComboBoxPesquisarInterno.addItem("Selecione...");
                    if (jComboBoxTipoKit.getSelectedItem().equals("Kit Inicial")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_inicial();
                    } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Decendial")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_decendial();
                    } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Quinzenal")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_quinzenal();
                    } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Mensal")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_mensal();
                    } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Semestral")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_semestral();
                    } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Anual")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_anual();
                    } else if (jComboBoxTipoKit.getSelectedItem().equals("Kit Personalizado")) {
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_inicial();
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_decendial();
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_quinzenal();
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_mensal();
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_semestral();
                        pPESQUISA_PAGAMENTO_KIT_INTERNOS_anual();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            };
            t0.start();
        } catch (Exception e) {
        }
        // THREAD DA BARRA DE EXECUÇÃO
        try {
            Thread t1 = new Thread() {
                public void run() {
                    jProgressBar1.setMaximum(jTabelaProdutosKit.getRowCount());
                    Rectangle rect;
                    for (int b = 0; b < jTabelaProdutosKit.getRowCount(); b++) {
                        rect = jTabelaProdutosKit.getCellRect(b, 0, true);
                        try {
                            jTabelaProdutosKit.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
                        if (b == 0) {
                            jTabelaProdutosKit.setRowSelectionInterval(b, 0);
                            jProgressBar1.setValue((b + 1));
                        } else if (b > 0) {
                            jTabelaProdutosKit.setRowSelectionInterval(b, 1);
                            jProgressBar1.setValue((b + 1));
                        }
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                        }
                    }
                    jProgressBar1.setValue(0);
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t1.start();
        } catch (Exception e) {
        }
    } //FIM DO MÉTODO

    public void limparCamposBiometria() {
        jIdInternoKitBio1.setText("");
        jNomeInternoKitBio1.setText("");
        jRegimeKitBio1.setText("");
        jPavilhaoKitBio1.setText("");
        jCelaKitBio1.setText("");
        jFotoInternoKitBio1.setIcon(null);
        jFotoInternoKitBio.setIcon(null);
        //
        jIdInternoKitBio.setText("");
        jNomeInternoKitBio.setText("");
        jRegimeKitBio.setText("");
        jPavilhaoKitBio.setText("");
        jCelaKitBio.setText("");
        jDataEntrega1.setDate(null);
        jHorarioPagto1.setText("");
        //ZERAR AS VARIÁVEIS DE CALCULO DO SALDO
        pQuantidade = 0;
        pSaldo = 0;
        //
        jTotalItens.setText("0");
        jTOTAL_REG_GRAVADO.setText("0");
    }

    public void PREENCHER_TABELA_internos() {
        DefaultTableModel objInternos = (DefaultTableModel) jTabelaInternos.getModel();
        try {
            for (ProdutosPagtoKitInterno b : CONTROLE_PESQUISA_manual.pPESQUISAR_PRODUTO_interno()) {
                objInternos.addRow(new Object[]{b.getIdItem(), b.getIdInternoCrc(), b.getNomeInternoCrc()});
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

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdLanc.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void listarTodosProdutosKitCompleto() {
        DefaultTableModel produtosSelecionados = (DefaultTableModel) jTabelaProdutosKit.getModel();
        ProdutoInternosKitLote p = new ProdutoInternosKitLote();
        try {
            for (ProdutoInternosKitLote pp : CONTROLE_PRODUTOS_kit.read()) {
                produtosSelecionados.addRow(new Object[]{pp.getIdProd(), pp.getDescricaoProduto(), pp.getUnidadeProd(), pp.getQuantidadeProd()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaProdutosKit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaProdutosKit.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaProdutosKit.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaProdutosKit.getColumnModel().getColumn(3).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaBiometriaKitInternoCPK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparTabelaProdutosKit() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaProdutosKit.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaProdutosKit.getModel()).removeRow(0);
        }
    }

    public void limparTabelaInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaInternos.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaInternos.getModel()).removeRow(0);
        }
    }

    public void pPESQUISAR_INTERNO_biometria() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_biometria(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_biometria() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Binicial(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_KIT_especifico() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_manual(objItensPagtoProd);
    }

// ------------------------------------------- KIT MANUAL PERSONALIZADO
    public void pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_inicial() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Minicial(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_decendial() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Mdecendial(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_quinzenal() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Mquinzenal(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_mensal() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Mmensal(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_semestral() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Msemestral(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_MANUAL_anual() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Manual(objItensPagtoProd);
    }

    //KIT POR BIOMETRIA PERSONALIZADO
    public void pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_inicial() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Binicial(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_decendial() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bdecendial(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_quinzenal() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bquinzenal(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_mensal() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bmensal(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_semestral() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bsemestral(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_PERSONALIZADO_BIOMETRIA_anual() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Banual(objItensPagtoProd);
    }

    public void pPESQUISAR_INTERNO_manual() {
        CONTROLE_PESQUISA_manual.pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_manual(objItensPagtoProd);
    }
}
