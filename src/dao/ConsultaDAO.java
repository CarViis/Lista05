package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import entidade.Consulta;
import entidade.Paciente;
import entidade.Medico;
public class ConsultaDAO extends AbstratoDAO {
    
    public boolean inserirConsulta(Consulta consulta) {
        try {
            String sql = "INSERT INTO consulta (id_medico, id_paciente, horario, valor) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, consulta.getMedico().getId());
            ps.setInt(2, consulta.getPaciente().getId());
            ps.setObject(3, consulta.getHorario());
            ps.setFloat(4, consulta.getValor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deletarConsulta(Consulta consulta) {
        try {
            String sql = "DELETE FROM consulta WHERE id_medico = ? AND id_paciente = ? AND horario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, consulta.getMedico().getId());
            ps.setInt(2, consulta.getPaciente().getId());
            ps.setObject(3, consulta.getHorario());
            if (ps.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean atualizarHorarioConsulta(Consulta consulta, LocalDateTime novoHorario) {
        try {
            String sql = "UPDATE consulta SET horario = ? WHERE id_medico = ? AND id_paciente = ? AND horario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setObject(1, novoHorario);
            ps.setInt(2, consulta.getMedico().getId());
            ps.setInt(3, consulta.getPaciente().getId());
            ps.setObject(4, consulta.getHorario());
            if (ps.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public List <Consulta> gerarRelatorio() {
        List<Consulta> consultas = new ArrayList<>();
            try {
                String sql = "SELECT * FROM consulta INNER JOIN paciente INNER JOIN medico ON consulta.id_paciente = paciente.id AND consulta.id_medico = medico.id";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setId(rs.getInt("paciente.id"));
                    paciente.setNome(rs.getString("paciente.nome"));
                    paciente.setCpf(rs.getString("paciente.cpf"));
                    paciente.setDoenca(rs.getString("paciente.doenca"));
                    Medico medico = new Medico();
                    medico.setId(rs.getInt("medico.id"));
                    medico.setNome(rs.getString("medico.nome"));
                    medico.setMatricula(rs.getInt("medico.matricula"));
                    medico.setEspecialidade(rs.getString("medico.especialidade"));
                    medico.setSalario(rs.getFloat("medico.salario"));
                    Consulta consulta = new Consulta();

                    consulta.setMedico(medico);
                    consulta.setPaciente(paciente);
                    consulta.setHorario(rs.getObject("horario", LocalDateTime.class));
                    consulta.setValor(rs.getFloat("valor"));
                    consultas.add(consulta);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return consultas;
    }
}
