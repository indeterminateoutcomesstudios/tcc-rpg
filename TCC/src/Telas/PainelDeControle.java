package Telas;

import ConexaoBanco.DAO;
import ServidorVoIP.ServerRunner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PainelDeControle extends javax.swing.JFrame {

    static DAO dao = new DAO();
    JFrame voipFrame = null;
    public boolean estadoVoip = false;
    public int port = 0;

    public PainelDeControle() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        senhaSala = new javax.swing.JLabel();
        botaoLimparChat = new javax.swing.JButton();
        caixaJogadores = new javax.swing.JComboBox<>();
        botaoBanir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        botaoDesbanir = new javax.swing.JButton();
        botaoCriarObjetos = new javax.swing.JButton();
        botaoMudarMapa = new javax.swing.JButton();
        botaoCriarNPC = new javax.swing.JButton();
        botaoCriarMonstro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Painel de Controle de Sala");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(440, 470));
        setMinimumSize(new java.awt.Dimension(440, 470));
        setPreferredSize(new java.awt.Dimension(440, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        senhaSala.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        senhaSala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        senhaSala.setText("JOGADORES:");
        getContentPane().add(senhaSala);
        senhaSala.setBounds(10, 10, 420, 32);

        botaoLimparChat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoLimparChat.setText("LIMPAR CHAT");
        botaoLimparChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparChatActionPerformed(evt);
            }
        });
        getContentPane().add(botaoLimparChat);
        botaoLimparChat.setBounds(10, 120, 210, 32);

        caixaJogadores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        caixaJogadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        caixaJogadores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                caixaJogadoresFocusGained(evt);
            }
        });
        getContentPane().add(caixaJogadores);
        caixaJogadores.setBounds(10, 40, 420, 32);

        botaoBanir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoBanir.setText("BANIR");
        botaoBanir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBanirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBanir);
        botaoBanir.setBounds(220, 80, 210, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("INICIAR VOIP (OFF)");
        jButton2.setToolTipText("AVISO: Esta funcão só está disponível para jogadores conectados em LAN.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 120, 210, 32);

        botaoDesbanir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoDesbanir.setText("DESBANIR");
        botaoDesbanir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDesbanirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoDesbanir);
        botaoDesbanir.setBounds(10, 80, 210, 30);

        botaoCriarObjetos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCriarObjetos.setText("CRIAR OBJETOS");
        botaoCriarObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarObjetosActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCriarObjetos);
        botaoCriarObjetos.setBounds(10, 160, 210, 30);

        botaoMudarMapa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoMudarMapa.setText("MUDAR MAPA");
        botaoMudarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMudarMapaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoMudarMapa);
        botaoMudarMapa.setBounds(220, 160, 210, 30);

        botaoCriarNPC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCriarNPC.setText("CRIAR NPC");
        botaoCriarNPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarNPCActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCriarNPC);
        botaoCriarNPC.setBounds(10, 200, 210, 30);

        botaoCriarMonstro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCriarMonstro.setText("CRIAR MONSTRO");
        botaoCriarMonstro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarMonstroActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCriarMonstro);
        botaoCriarMonstro.setBounds(220, 200, 210, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLimparChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparChatActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja limpar o chat?", "Limpar chat", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            dao.limparChat();
        }
    }//GEN-LAST:event_botaoLimparChatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!estadoVoip) {
            do {
                dao.alterarPorta(0, dao.salaAtual.getNome_sala());
                String configPort = JOptionPane.showInputDialog("Escolha em qual porta o servidor de voIP funcionará: ");
                if (configPort != null) {
                    port = Integer.parseInt(configPort);
                }
                if (port < 1024 || port > 65535) {
                    JOptionPane.showMessageDialog(null, "AVISO: Apenas valores maiores que 1024 e menores que 65535!");
                }
            } while (port < 1024 || port > 65535);
            new Thread() {
                @Override
                public void run() {
                    try {
                        TelaJogo.botaoConectarVOIP.setEnabled(false);
                        voipFrame = new ServerRunner(port);
                        voipFrame.setVisible(false);
                        JFrame telaSom = new TelaConfigurarSom();
                        telaSom.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }.start();
            estadoVoip = true;
            jButton2.setText("DESLIGAR VOIP (ON)");
            TelaJogo.botaoConectarVOIP.setEnabled(false);
            dao.alterarPorta(port, TelaConfigurarSala.nomeSala);
            dao.alterarVOIP(1);
        } else {
            System.out.println("Parando servidor de voIP...");
            estadoVoip = false;
            voipFrame.setVisible(false);
            voipFrame.dispose();
            jButton2.setText("LIGAR VOIP (OFF)");
            TelaJogo.botaoConectarVOIP.setEnabled(true);
            dao.alterarVOIP(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botaoCriarObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarObjetosActionPerformed
        TelaCriarObjetos telaCriarObjetos = new TelaCriarObjetos(this, false);
        telaCriarObjetos.setVisible(true);
        botaoCriarObjetos.setEnabled(false);
    }//GEN-LAST:event_botaoCriarObjetosActionPerformed

    private void botaoMudarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMudarMapaActionPerformed
        new Thread() {
            @Override
            public void run() {
                JFileChooser escolherArquivo = new JFileChooser();
                escolherArquivo.setMaximumSize(new java.awt.Dimension(800, 600));
                escolherArquivo.setMinimumSize(new java.awt.Dimension(800, 600));
                escolherArquivo.setPreferredSize(new java.awt.Dimension(800, 600));
                FileFilter filter = new FileNameExtensionFilter("Imagens em JPEG", "jpg", "jpeg");
                FileFilter filter2 = new FileNameExtensionFilter("Imagens em PNG", "png");
                FileFilter filter3 = new FileNameExtensionFilter("Imagens em GIF", "gif");
                escolherArquivo.addChoosableFileFilter(filter);
                escolherArquivo.addChoosableFileFilter(filter2);
                escolherArquivo.addChoosableFileFilter(filter3);
                escolherArquivo.setAcceptAllFileFilterUsed(false);
                escolherArquivo.setMultiSelectionEnabled(false);
                int resultado = escolherArquivo.showOpenDialog(null);
                if (resultado == escolherArquivo.CANCEL_OPTION) {
                    System.out.println("Escolha de arquivos cancelada");
                } else {
                    String path = escolherArquivo.getSelectedFile().getPath();
                    System.out.println("Arquivo: [" + path + "] selecionado");
                    dao.uploadMapa(path);
                }
            }
        }.start();
    }//GEN-LAST:event_botaoMudarMapaActionPerformed

    private void caixaJogadoresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caixaJogadoresFocusGained
        new Thread() {
            @Override
            public void run() {
                caixaJogadores.removeAllItems();
                dao.jogadoresAtuais.clear();
                dao.pegarJogadoresDaSala();
            }
        }.start();
    }//GEN-LAST:event_caixaJogadoresFocusGained

    private void botaoBanirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBanirActionPerformed
        dao.alterarEstadoBan(1, dao.pegarPk_jogador(caixaJogadores.getSelectedItem().toString()), DAO.salaAtual.getPk_sala());
    }//GEN-LAST:event_botaoBanirActionPerformed

    private void botaoDesbanirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDesbanirActionPerformed
        dao.alterarEstadoBan(0, dao.pegarPk_jogador(caixaJogadores.getSelectedItem().toString()), DAO.salaAtual.getPk_sala());
    }//GEN-LAST:event_botaoDesbanirActionPerformed

    private void botaoCriarNPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarNPCActionPerformed
        TelaNPC telaNPC = new TelaNPC(this, true);
        telaNPC.botaoSalvar.setEnabled(true);
        telaNPC.botaAdicionarImagem.setEnabled(false);
        telaNPC.setVisible(true);
    }//GEN-LAST:event_botaoCriarNPCActionPerformed

    private void botaoCriarMonstroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarMonstroActionPerformed
        TelaMonstro telaMonstro = new TelaMonstro(this, true);
        telaMonstro.botaoSalvar.setEnabled(true);
        telaMonstro.botaAdicionarImagem.setEnabled(false);
        telaMonstro.setVisible(true);
    }//GEN-LAST:event_botaoCriarMonstroActionPerformed

    public static void Start() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelDeControle().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBanir;
    private javax.swing.JButton botaoCriarMonstro;
    private javax.swing.JButton botaoCriarNPC;
    public static javax.swing.JButton botaoCriarObjetos;
    private javax.swing.JButton botaoDesbanir;
    private javax.swing.JButton botaoLimparChat;
    private javax.swing.JButton botaoMudarMapa;
    public static javax.swing.JComboBox<String> caixaJogadores;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel senhaSala;
    // End of variables declaration//GEN-END:variables
}
