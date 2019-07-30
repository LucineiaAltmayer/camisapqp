/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Camisa;
/**
 *
 * @author Administrador
 */
public class CamisaDao {
    public static boolean inserir(Camisa objeto) {
        String sql = "INSERT INTO camisa (cor, tamanho, codigo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getcor());
            ps.setString(2, objeto.gettamanho());
            ps.setString(3, objeto.getcodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Camisa objeto = new Camisa();
        objeto.setcor("Branca");
        objeto.settamanho("m");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}