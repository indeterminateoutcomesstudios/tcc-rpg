package Telas;

import ServidorVoIP.Log;
import java.awt.event.KeyEvent;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class TelaInicial extends javax.swing.JFrame {

    public static String ipAddress = null;

    private static String getFirstNonLoopbackAddress(boolean preferIpv4, boolean preferIPv6) throws SocketException {
        Enumeration en = NetworkInterface.getNetworkInterfaces();
        while (en.hasMoreElements()) {
            NetworkInterface i = (NetworkInterface) en.nextElement();
            for (Enumeration en2 = i.getInetAddresses(); en2.hasMoreElements();) {
                InetAddress addr = (InetAddress) en2.nextElement();
                if (!addr.isLoopbackAddress()) {
                    if (addr instanceof Inet4Address) {
                        if (preferIPv6) {
                            continue;
                        }
                        return addr.getHostAddress();
                    }
                    if (addr instanceof Inet6Address) {
                        if (preferIpv4) {
                            continue;
                        }
                        return addr.getHostAddress();
                    }
                }
            }
        }
        return null;
    }

    public TelaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoConfigurarConta = new javax.swing.JButton();
        botaoCriarSala = new javax.swing.JButton();
        botaoEntrarEmSala = new javax.swing.JButton();
        botaoDeslogar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        planoFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Double Damage");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        botaoConfigurarConta.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botaoConfigurarConta.setText("CONFIGURAR CONTA");
        botaoConfigurarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfigurarContaActionPerformed(evt);
            }
        });
        botaoConfigurarConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoConfigurarContaKeyPressed(evt);
            }
        });
        getContentPane().add(botaoConfigurarConta);
        botaoConfigurarConta.setBounds(460, 510, 450, 60);

        botaoCriarSala.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botaoCriarSala.setText("CRIAR NOVA SALA");
        botaoCriarSala.setName(""); // NOI18N
        botaoCriarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarSalaActionPerformed(evt);
            }
        });
        botaoCriarSala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoCriarSalaKeyPressed(evt);
            }
        });
        getContentPane().add(botaoCriarSala);
        botaoCriarSala.setBounds(460, 350, 450, 60);

        botaoEntrarEmSala.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botaoEntrarEmSala.setText("ENTRAR EM UMA SALA");
        botaoEntrarEmSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarEmSalaActionPerformed(evt);
            }
        });
        botaoEntrarEmSala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarEmSalaKeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrarEmSala);
        botaoEntrarEmSala.setBounds(460, 430, 450, 60);

        botaoDeslogar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoDeslogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/botaoLogout.png"))); // NOI18N
        botaoDeslogar.setText("SAIR!");
        botaoDeslogar.setToolTipText("Desconectar.");
        botaoDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeslogarActionPerformed(evt);
            }
        });
        botaoDeslogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoDeslogarKeyPressed(evt);
            }
        });
        getContentPane().add(botaoDeslogar);
        botaoDeslogar.setBounds(1100, 640, 110, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/information-outline (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1220, 640, 40, 40);

        planoFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        planoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/planoDeFundo.png"))); // NOI18N
        getContentPane().add(planoFundo);
        planoFundo.setBounds(0, 0, 1280, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void deslogar() {
        int sair = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Desconectar.", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }
    private void botaoDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeslogarActionPerformed
        deslogar();
    }//GEN-LAST:event_botaoDeslogarActionPerformed

    private void botaoCriarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarSalaActionPerformed
        JDialog tela = new TelaConfigurarSala(this, true, this);
        tela.setVisible(true);
    }//GEN-LAST:event_botaoCriarSalaActionPerformed

    private void botaoCriarSalaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoCriarSalaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JDialog tela = new TelaConfigurarSala(this, true, this);
            tela.setVisible(true);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            deslogar();
        }
    }//GEN-LAST:event_botaoCriarSalaKeyPressed
    private void botaoEntrarEmSalaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarEmSalaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            deslogar();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JDialog tela = new TelaEntrarEmSala(this, true, this);
            tela.setVisible(true);
        }
    }//GEN-LAST:event_botaoEntrarEmSalaKeyPressed

    private void botaoDeslogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoDeslogarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            deslogar();
        }
    }//GEN-LAST:event_botaoDeslogarKeyPressed

    private void botaoEntrarEmSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarEmSalaActionPerformed
        JDialog tela = new TelaEntrarEmSala(this, true, this);
        tela.setVisible(true);
    }//GEN-LAST:event_botaoEntrarEmSalaActionPerformed

    private void botaoConfigurarContaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoConfigurarContaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            deslogar();
        }
    }//GEN-LAST:event_botaoConfigurarContaKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            deslogar();
        }
    }//GEN-LAST:event_formKeyPressed

    private void botaoConfigurarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfigurarContaActionPerformed
        TelaConfigurarConta telaConfigurarConta = new TelaConfigurarConta(this, true);
        telaConfigurarConta.setVisible(true);
    }//GEN-LAST:event_botaoConfigurarContaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaInformacoes telaInformacoes =  new TelaInformacoes(this, true);
        telaInformacoes.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void Start() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (ipAddress == null) {
                    System.out.println("Login realizado. @" + TelaLogin.campoLogin.getText());
                    try {
                        ipAddress = getFirstNonLoopbackAddress(true, false);
                        System.out.println(ipAddress);
                    } catch (SocketException ex) {
                        Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("--------------------------------------------------------------------------------");
                }
                new TelaInicial().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfigurarConta;
    private javax.swing.JButton botaoCriarSala;
    private javax.swing.JButton botaoDeslogar;
    private javax.swing.JButton botaoEntrarEmSala;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel planoFundo;
    // End of variables declaration//GEN-END:variables
}
