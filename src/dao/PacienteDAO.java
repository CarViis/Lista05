package dao;
import entidade.Paciente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PacienteDAO extends AbstratoDAO {
    
    public boolean inserirPaciente(Paciente paciente) {
        try {
            String sql = "INSERT INTO paciente (nome, cpf, doenca) VALUES (?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setString(3, paciente.getDoenca());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        Paciente paciente = null;
        try {
            String sql = "SELECT * FROM paciente WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String doenca = rs.getString("doenca");
                paciente = new Paciente(id, nome, cpf, doenca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
}
