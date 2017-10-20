package Telas;

import ConexaoBanco.DAO;
import static Telas.TelaRegistrar.erros;
import com.sun.glass.events.KeyEvent;
import java.awt.Cursor;
import javax.swing.JDialog;

public class TelaLogin extends javax.swing.JFrame {

    static DAO dao = new DAO();

    public TelaLogin() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoLogin = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoEntrar = new javax.swing.JButton();
        botaoRegistrarSe = new javax.swing.JButton();
        erroLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Double Damage");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("Frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        campoLogin.setBackground(new java.awt.Color(240, 240, 240));
        campoLogin.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        campoLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoLoginKeyPressed(evt);
            }
        });
        getContentPane().add(campoLogin);
        campoLogin.setBounds(430, 380, 480, 50);
        campoLogin.getAccessibleContext().setAccessibleName("");

        campoSenha.setBackground(new java.awt.Color(240, 240, 240));
        campoSenha.setFont(new java.awt.Font("SansSerif", 0, 28)); // NOI18N
        campoSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(campoSenha);
        campoSenha.setBounds(430, 470, 480, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMAIL:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 340, 480, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SENHA:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(430, 430, 480, 40);

        botaoEntrar.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botaoEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/botaoEntrar.png"))); // NOI18N
        botaoEntrar.setText("ENTRAR");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        botaoEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarKeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrar);
        botaoEntrar.setBounds(430, 550, 210, 50);

        botaoRegistrarSe.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botaoRegistrarSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/botaoRegistrar.png"))); // NOI18N
        botaoRegistrarSe.setText("REGISTRAR");
        botaoRegistrarSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarSeActionPerformed(evt);
            }
        });
        botaoRegistrarSe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoRegistrarSeKeyPressed(evt);
            }
        });
        getContentPane().add(botaoRegistrarSe);
        botaoRegistrarSe.setBounds(700, 550, 210, 50);

        erroLogin.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        erroLogin.setForeground(new java.awt.Color(255, 0, 0));
        erroLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/erroSenhas.png"))); // NOI18N
        erroLogin.setText("Credenciais incorretas.");
        getContentPane().add(erroLogin);
        erroLogin.setBounds(430, 530, 450, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/planoDeFundo.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -90, 1280, 890);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRegistrarSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarSeActionPerformed
        campoLogin.setText("");
        campoSenha.setText("");
        JDialog tela = new TelaRegistrar(this, true);
        erros();
        tela.setVisible(true);
    }//GEN-LAST:event_botaoRegistrarSeActionPerformed
    public void entrarComEnter() {

        DAO jogador = new DAO();
        String login = campoLogin.getText();
        char[] senha = campoSenha.getPassword();
        String senhaAuxiliar = String.valueOf(senha);
        try {

            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            System.out.println("Efetuando login...");
            jogador.logar(login, senhaAuxiliar, this);
            dao.modificarUltimoLogin(login);

        } finally {

            setCursor(Cursor.getDefaultCursor());

        }

    }
    private void campoLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrarComEnter();
        }
    }//GEN-LAST:event_campoLoginKeyPressed

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrarComEnter();
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void botaoRegistrarSeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoRegistrarSeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JDialog tela = new TelaRegistrar(this, true);
            erros();
            tela.setVisible(true);
        }
    }//GEN-LAST:event_botaoRegistrarSeKeyPressed

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        entrarComEnter();
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrarComEnter();
        }
    }//GEN-LAST:event_botaoEntrarKeyPressed

    public static void abrirTela() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
                erroLogin.setVisible(false);
            }
        });
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                System.out.println("Iniciando Double Damage (2017)...");
                System.out.println("'Aplicação Online Para RPG De Mesa Com Uso De VoIP E Chat'");
                System.out.println("Trabalho de Conclusão do Curso de Informática Integrado ao Ensino Médio");
                System.out.println("Instituto Federal Catarinense - Campus Ibirama");
                System.out.println("Turma: Informática 2015");
                System.out.println("Autores: Eduardo Schork & Lucas Dolsan");
                System.out.println("Repositório: " + "https://github.com/lucas-dolsan/tcc-rpg");
                System.out.println("--------------------------------------------------------------------------------");
                new TelaLogin().setVisible(true);
                erroLogin.setVisible(false);
                new Thread() {
                    public void run() {
                        while (true) {
                            dao.ping();
                        }
                    }
                }.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoRegistrarSe;
    public static javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    public static javax.swing.JLabel erroLogin;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
