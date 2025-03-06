package dao;
import entidade.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MedicoDAO extends AbstratoDAO {
    
    public boolean inserirMedico(Medico medico) {
        try {
            String sql = "INSERT INTO medico (nome, matricula, especialidade, salario) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, medico.getNome());
            ps.setInt(2, medico.getMatricula());
            ps.setString(3, medico.getEspecialidade());
            ps.setFloat(4, medico.getSalario());
            if (ps.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    public Medico BuscarMedicoPorMatricula(int matricula) {
        Medico medico = null;
        try {
            String sql = "SELECT * FROM medico WHERE matricula = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");
                float salario = rs.getFloat("salario");
                medico = new Medico(id, nome, matricula, especialidade, salario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }  
}
