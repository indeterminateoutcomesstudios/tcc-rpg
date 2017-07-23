package ConexaoBanco;

import Objetos.*;
import Telas.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class JogadorDAO {

    public static String nomePersonagem = "";
    public static Jogador player = null;
    public static Sala salaAtual = null;
    public static String nickName = "";
    public static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    public static ArrayList<Sala> salas = new ArrayList<Sala>();
    public static ArrayList<Jogador> jogadoresAtuais = new ArrayList<Jogador>();
    public static Connection c = ConexaoMySql.getConnection();

    public static String SaltedPassword(String unecryptedPassword) {

        String salt = "(NioU&y%%OguyF=d%6S)(L.~mnHXR6#@3jn0*FX7HD(iSHuvTdkfsC5$¨865709giVFTcf76)VB9";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update((unecryptedPassword + salt).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
        return encryptedPassword;
    }

    public static void mensagemSairDaSala() {
        final String sql = ("update sala SET chat_sala=concat(chat_sala,(?)) where nome_sala = (?)");
        String mensagem = "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + " Saiu da Sala]\n";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, mensagem);
            stmt.setString(2, TelaConfigurarSala.nomeSala);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mensagemEntrarNaSala() {
        final String sql = ("update sala SET chat_sala=concat(chat_sala,(?)) where nome_sala = (?)");
        String mensagem = "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + " Entrou na Sala]\n";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, mensagem);
            stmt.setString(2, TelaConfigurarSala.nomeSala);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean personagemExiste(String nomePersonagem) {
        String sql = "SELECT nomePersonagem_fic FROM personagem WHERE nomePersonagem_fic = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomePersonagem);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void criarPersonagem(int fk_sala, String nomePersonagem_fic, String nomeJogador_fic, String raca_fic, String classe_fic, int pontosVida_fic, int pontosMana_fic, int nivel_fic, int idade_fic, String divindade_fic, String lore_fic, String outrosAtributos_fic, int pontosForca_fic, int pontosInteligencia_fic, int pontosDefesa_fic, int pontosConstituicao_fic, int pontosSabedoria_fic, int pontosDestreza_fic, int pontosCarisma_fic) {
        final String sql = ("insert into personagem(fk_sala,outrosAtributos_fic,lore_fic,raca_fic,classe_fic,nomePersonagem_fic,nomeJogador_fic,divindade_fic,nivel_fic,idade_fic,pontosVida_fic,pontosMana_fic,pontosForca_fic,pontosConstituicao_fic,pontosDestreza_fic,pontosInteligencia_fic,pontosSabedoria_fic,pontosCarisma_fic,pontosDefesa_fic) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, fk_sala);
            stmt.setString(2, outrosAtributos_fic);
            stmt.setString(3, lore_fic);
            stmt.setString(4, raca_fic);
            stmt.setString(5, classe_fic);
            stmt.setString(6, nomePersonagem_fic);
            stmt.setString(7, nomeJogador_fic);
            stmt.setString(8, divindade_fic);
            stmt.setInt(9, nivel_fic);
            stmt.setInt(10, idade_fic);
            stmt.setInt(11, pontosVida_fic);
            stmt.setInt(12, pontosMana_fic);
            stmt.setInt(13, pontosForca_fic);
            stmt.setInt(14, pontosConstituicao_fic);
            stmt.setInt(15, pontosDestreza_fic);
            stmt.setInt(16, pontosInteligencia_fic);
            stmt.setInt(17, pontosSabedoria_fic);
            stmt.setInt(18, pontosCarisma_fic);
            stmt.setInt(19, pontosDefesa_fic);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void salvarEdicaoPersonagem(int fk_sala, String nomePersonagem_fic, String nomeJogador_fic, String raca_fic, String classe_fic, int pontosVida_fic, int pontosMana_fic, int nivel_fic, int idade_fic, String divindade_fic, String lore_fic, String outrosAtributos_fic, int pontosForca_fic, int pontosInteligencia_fic, int pontosDefesa_fic, int pontosConstituicao_fic, int pontosSabedoria_fic, int pontosDestreza_fic, int pontosCarisma_fic) {
        final String sql = ("UPDATE personagem SET fk_sala = ?,outrosAtributos_fic=?,lore_fic=?,raca_fic=?,classe_fic=?,nomePersonagem_fic=?,nomeJogador_fic=?,divindade_fic=?,nivel_fic=?,idade_fic=?,pontosVida_fic=?,pontosMana_fic=?,pontosForca_fic=?,pontosConstituicao_fic=?,pontosDestreza_fic=?,pontosInteligencia_fic=?,pontosSabedoria_fic=?,pontosCarisma_fic=?,pontosDefesa_fic=? WHERE nomePersonagem_fic = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, fk_sala);
            stmt.setString(2, outrosAtributos_fic);
            stmt.setString(3, lore_fic);
            stmt.setString(4, raca_fic);
            stmt.setString(5, classe_fic);
            stmt.setString(6, nomePersonagem_fic);
            stmt.setString(7, nomeJogador_fic);
            stmt.setString(8, divindade_fic);
            stmt.setInt(9, nivel_fic);
            stmt.setInt(10, idade_fic);
            stmt.setInt(11, pontosVida_fic);
            stmt.setInt(12, pontosMana_fic);
            stmt.setInt(13, pontosForca_fic);
            stmt.setInt(14, pontosConstituicao_fic);
            stmt.setInt(15, pontosDestreza_fic);
            stmt.setInt(16, pontosInteligencia_fic);
            stmt.setInt(17, pontosSabedoria_fic);
            stmt.setInt(18, pontosCarisma_fic);
            stmt.setInt(19, pontosDefesa_fic);
            stmt.setString(20, JogadorDAO.nomePersonagem);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pegarDadosPersonagem(String nomePersonagem) {
        JogadorDAO.nomePersonagem = nomePersonagem;
        final String sql = ("SELECT * FROM personagem WHERE nomePersonagem_fic = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomePersonagem);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TelaPersonagem telaPersonagem = new TelaPersonagem(null, true);
                telaPersonagem.campoOutrosAtributos.setText(rs.getString("outrosAtributos_fic"));
                telaPersonagem.campoLore.setText(rs.getString("lore_fic"));
                telaPersonagem.campoRaca.setText(rs.getString("raca_fic"));
                telaPersonagem.campoClasse.setText(rs.getString("classe_fic"));
                telaPersonagem.campoNomePersonagem.setText(rs.getString("nomePersonagem_fic"));
                telaPersonagem.campoNomeJogador.setText(rs.getString("nomeJogador_fic"));
                telaPersonagem.campoDivindade.setText(rs.getString("divindade_fic"));
                telaPersonagem.campoNivel.setText(rs.getInt("nivel_fic") + "");
                telaPersonagem.campoIdade.setText(rs.getInt("idade_fic") + "");
                telaPersonagem.campoVida.setText(rs.getInt("pontosVida_fic") + "");
                telaPersonagem.campoMana.setText(rs.getInt("pontosMana_fic") + "");
                telaPersonagem.campoForca.setText(rs.getInt("pontosForca_fic") + "");
                telaPersonagem.campoConstituicao.setText(rs.getInt("pontosConstituicao_fic") + "");
                telaPersonagem.campoDestreza.setText(rs.getInt("pontosDestreza_fic") + "");
                telaPersonagem.campoInteligencia.setText(rs.getInt("pontosInteligencia_fic") + "");
                telaPersonagem.campoSabedoria.setText(rs.getInt("pontosSabedoria_fic") + "");
                telaPersonagem.campoCarisma.setText(rs.getInt("pontosCarisma_fic") + "");
                telaPersonagem.campoDefesa.setText(rs.getInt("pontosDefesa_fic") + "");
                if (verificarDono()) {
                    telaPersonagem.botaoExcluirPersonagem.setEnabled(true);
                    telaPersonagem.botaoEquipamentos.setEnabled(true);
                    telaPersonagem.botaoMagias.setEnabled(true);
                    telaPersonagem.botaoSalvarPersonagem.setVisible(false);
                    telaPersonagem.salvarEdicao.setEnabled(true);
                    telaPersonagem.setVisible(true);

                } else {
                    telaPersonagem.botaoEquipamentos.setEnabled(true);
                    telaPersonagem.botaoMagias.setEnabled(true);
                    telaPersonagem.campoCarisma.setEditable(false);
                    telaPersonagem.campoClasse.setEditable(false);
                    telaPersonagem.campoConstituicao.setEditable(false);
                    telaPersonagem.campoDefesa.setEditable(false);
                    telaPersonagem.campoDestreza.setEditable(false);
                    telaPersonagem.campoDivindade.setEditable(false);
                    telaPersonagem.campoForca.setEditable(false);
                    telaPersonagem.campoIdade.setEditable(false);
                    telaPersonagem.campoInteligencia.setEditable(false);
                    telaPersonagem.campoLore.setEditable(false);
                    telaPersonagem.campoMana.setEditable(false);
                    telaPersonagem.campoNivel.setEditable(false);
                    telaPersonagem.campoNomeJogador.setEditable(false);
                    telaPersonagem.campoNomePersonagem.setEditable(false);
                    telaPersonagem.campoOutrosAtributos.setEditable(false);
                    telaPersonagem.campoRaca.setEditable(false);
                    telaPersonagem.campoSabedoria.setEditable(false);
                    telaPersonagem.campoVida.setEditable(false);
                    telaPersonagem.setVisible(true);
                }

            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirPersonagem() {
        final String sql = ("DELETE FROM personagem WHERE nomePersonagem_fic = ?;");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, JogadorDAO.nomePersonagem);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarPersonagens() {
        final String sql = ("select * from personagem per join sala sala on per.fk_sala = sala.pk_sala where sala.nome_sala = ?;");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, salaAtual.getNome_sala());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TelaJogo.caixaFichaPersonagem.addItem(rs.getString("nomePersonagem_fic"));
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarSalas() {
        final String sql = ("select * from sala");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TelaEntrarEmSala.caixaDeSalas.addItem(rs.getString("nome_sala"));
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void banir(int pk_jogador, String motivo_ban) {
        final String sql = ("INSERT INTO banlist(fk_jogador, fk_sala, dt_ban, motivo_ban) VALUES(?,?,?,?)");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, pk_jogador);
            stmt.setInt(2, salaAtual.getPk_sala());
            stmt.setString(4, motivo_ban);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void banir(int pk_jogador) {
        final String sql = ("INSERT INTO banlist(fk_jogador, fk_sala, dt_ban) VALUES(?,?,?)");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, pk_jogador);
            stmt.setInt(2, salaAtual.getPk_sala());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void criarJogador(Jogador jogador, TelaRegistrar tela) {
        final String sql = "insert into jogador(nome_jog, email_jog, senha_jog, dt_registro, dt_ultimoLogin) values(?,?,sha1(md5(sha1(md5(sha1(md5(?)))))),now(),now())";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, jogador.getNome_jog());
            stmt.setString(2, jogador.getEmail_jog());
            stmt.setString(3, SaltedPassword(jogador.getSenha_jog()));
            stmt.execute();
            tela.labelRegistrado.setVisible(true);
            tela.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void limparChat() {
        final String sql = ("UPDATE sala SET chat_sala = '' WHERE pk_sala = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, salaAtual.getPk_sala());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarJogadores(Jogador jogador) {
        final String sql = ("select * from jogador;");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("pk_jogador"));
                System.out.println("Nome: " + rs.getString("nome_jog"));
                System.out.println("Email: " + rs.getString("email_jog"));
                System.out.println("Senha: " + rs.getString("senha_jog"));
                stmt.execute();
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean salaExiste(String nomeSala) {
        String sql = "SELECT nome_sala FROM sala WHERE nome_sala = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomeSala);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificarDono() {
        String sql = ("SELECT * FROM sala WHERE fk_jogador =? AND nome_sala = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, player.getPk_jogador());
            stmt.setString(2, salaAtual.getNome_sala());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void alterarIP(String nome_sala) {
        String ip = TelaInicial.ipAddress;
        final String sql = ("UPDATE sala SET ip_dono = ? WHERE nome_sala = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, ip);
            stmt.setString(2, nome_sala);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String pegarIPDono(String nome_sala) {
        final String sql = ("SELECT ip_dono FROM sala WHERE nome_sala = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nome_sala);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isVOIPAtivado(String nomeSala) {
        final String sql = ("SELECT voip_sala FROM sala WHERE nome_sala = ?;");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomeSala);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int voip_sala = rs.getInt(1);
                if (voip_sala == 1) {
                    stmt.close();
                    rs.close();
                    return true;
                } else {
                    stmt.close();
                    rs.close();
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void alterarVOIP(int estado) {
        final String sql = ("UPDATE sala SET voip_sala = ? WHERE nome_sala = ?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, estado);
            stmt.setString(2, salaAtual.getNome_sala());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void criarSala(TelaConfigurarSala tela, String nomeSala, String senhaSala) {
        String sql = "insert into sala(fk_jogador, nome_sala, senha_sala, chat_sala, ip_dono, limpar_chat_daily, voip_sala) values(?,?,?,?,?,?,?)";
        for (Sala sala : salas) {
            if (sala.getNome_sala().equalsIgnoreCase(nomeSala)) {
                salaAtual = sala;
            }
        }
        int pk_dono = player.getPk_jogador();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, pk_dono);
            stmt.setString(2, nomeSala);
            stmt.setString(3, senhaSala);
            stmt.setString(4, "");
            stmt.setString(5, "0");//depois colocar o ip do cara
            stmt.setInt(6, 0);
            stmt.setBoolean(7, false);
            stmt.execute();
            tela.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String pegarTempoServer() {
        final String sql = ("SELECT CURTIME();");

        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String comando(String texto) {
        switch (texto) {
            case "/help": {
                String help = "\n     /ping: retorna o tempo de resposta do servidor \n     /time: retorna o tempo do servidor \n     /owner: retorna o nome do dono da sala \n     /clear: limpa a sua janela de chat \n";
                return "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + "]: " + help + "\n";
            }
            case "/ping": {
                return "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + "]: " + ping() + "\n";
            }
            case "/time": {
                return "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + "]: Server time:" + pegarTempoServer() + "\n \n";
            }
            case "/owner": {
                String aux = dono();
                if (aux.isEmpty()) {
                    break;
                } else {
                    return "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + "]: " + aux + "\n";
                }
            }
            default: {
                return "[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + "]:" + texto + "\n";
            }
        }
        return "";
    }

    public static String dono() {
        final String sql = ("SELECT * FROM jogador jog JOIN sala sala ON jog.pk_jogador = sala.fk_jogador WHERE nome_sala =?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, salaAtual.getNome_sala());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return "Owner: " + rs.getString("nome_jog") + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String ping() {
        final String sql = ("/* ping */ SELECT 1");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return "PING: " + rs.getString(1) + "ms \n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void enviarDadoBanco(int dado, int numeroModificado, int numero, int modificadorMais, int modificadorMenos, int tipo) {
        final String sql = ("update sala SET chat_sala=concat(chat_sala,(?)) where nome_sala = (?)");
        String mensagem = "";
        switch (tipo) {
            case 1: {
                mensagem = ("[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + " rolou um dado D" + dado + "] = " + numeroModificado + " {[" + numero + "+" + modificadorMais + "]}\n");
                break;
            }
            case 2: {
                mensagem = ("[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + " rolou um dado D" + dado + "] = " + numeroModificado + " {[" + numero + "-" + modificadorMenos + "]}\n");
                break;
            }
            case 3: {
                mensagem = ("[" + pegarTempoServer() + "] [" + JogadorDAO.nickName + " rolou um dado D" + dado + "] = " + numero + "\n");
                break;
            }
        }
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, mensagem);
            stmt.setString(2, TelaConfigurarSala.nomeSala);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enviarChatBanco(String texto) {
        final String sql = ("update sala SET chat_sala=concat(chat_sala,(?)) where nome_sala = (?)");
        String mensagem = comando(texto);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, mensagem);
            stmt.setString(2, TelaConfigurarSala.nomeSala);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fecharSala(Telas.TelaJogo telaJogo, String nomeSala) {
        String sql = ("delete from sala where nome_sala = ?;");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomeSala);
            stmt.execute();
            telaJogo.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void lerChat() {
        final String sql = ("select chat_sala from sala where nome_sala=?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, TelaConfigurarSala.nomeSala);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TelaJogo.areaDeChat.setText(rs.getString("chat_sala"));
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean entrarEmSala(String nomeSala, String senhaSala) {
        final String sql = ("select * from sala where nome_sala =? and senha_sala =?;");
        for (Sala sala : salas) {
            if (sala.getNome_sala().equalsIgnoreCase(nomeSala)) {
                salaAtual = sala;
            }
        }
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomeSala);
            stmt.setString(2, senhaSala);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TelaConfigurarSala.nomeSala = nomeSala;
                return true;
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void pegarSalasDoBanco() {
        final String sql = ("select * from sala");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setPk_sala(rs.getInt("pk_sala"));
                sala.setFk_jogador(rs.getInt("fk_jogador"));
                sala.setNome_sala(rs.getString("nome_sala"));
                sala.setSenha_sala(rs.getString("senha_sala"));
                salas.add(sala);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pegarJogadoresDoBanco() {
        final String sql = ("select * from jogador");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setPk_jogador(rs.getInt("pk_jogador"));
                jogador.setNome_jog(rs.getString("nome_jog"));
                jogador.setEmail_jog(rs.getString("email_jog"));
                jogador.setSenha_jog(rs.getString("senha_jog"));
                jogador.setDt_registro(rs.getDate("dt_registro"));
                jogador.setDt_ultimoLogin(rs.getDate("dt_ultimoLogin"));
                jogadores.add(jogador);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pegarJogadoresDaSala() {
        final String sql = ("SELECT * FROM jogador jog JOIN sala sala ON jog.pk_jogador = sala.fk_jogador WHERE sala.pk_sala =?");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, salaAtual.getPk_sala());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setPk_jogador(rs.getInt("pk_jogador"));
                jogador.setNome_jog(rs.getString("nome_jog"));
                jogador.setEmail_jog(rs.getString("email_jog"));
                jogador.setSenha_jog(rs.getString("senha_jog"));
                jogador.setDt_registro(rs.getDate("dt_registro"));
                jogador.setDt_ultimoLogin(rs.getDate("dt_ultimoLogin"));
                jogadoresAtuais.add(jogador);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logar(String email, String senha, TelaLogin tela) {
        final String sql = ("select * from jogador where email_jog =? and senha_jog = sha1(md5(sha1(md5(sha1(md5(?))))));");
        try {
            pegarJogadoresDoBanco();
            Thread pegarVariaveisLocais = new Thread() {
                public void run() {
                    pegarSalasDoBanco();
                }
            };
            pegarVariaveisLocais.start();
            for (Jogador jog : jogadores) {
                if (jog.getEmail_jog().equals(email)) {
                    player = jog;
                    break;
                }
            }
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, SaltedPassword(senha));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nickName = rs.getString("nome_jog");
                Telas.TelaInicial.Start();
                tela.setVisible(false);
            } else {
                System.out.println("Falha ao efetuar login: Credenciais incorretas");
                tela.erroLogin.setVisible(true);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean verificarEmail(String email) {
        final String sql = ("select * from jogador");
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String emailAux = rs.getString("email_jog");
                if (email.equals(emailAux)) {
                    return true;
                }
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificarNomeDeUsuario(String nick) {
        final String sql = "select * from jogador";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeBanco = rs.getString("nome_jog");
                if (nick.equals(nomeBanco)) {
                    stmt.close();
                    return true;
                }
            }
            stmt.close();

        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return false;
    }

    public static void modificarUltimoLogin(String login) {
        final String sql = "UPDATE jogador SET dt_ultimoLogin = now() WHERE email_jog = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void modificarChatDaily(String nomeSala, int estado) {
        final String sql = "UPDATE sala SET limpar_chat_daily = ? WHERE nome_sala = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, estado);
            stmt.setString(2, nomeSala);
            stmt.execute();
            stmt.close();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    public static boolean verificarChatDaily(String nomeSala) {
        final String sql = "SELECT limpar_chat_daily FROM sala WHERE nome_sala = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, nomeSala);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
