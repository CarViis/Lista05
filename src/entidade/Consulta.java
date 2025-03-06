package entidade;
import java.time.LocalDateTime;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime horario;
    private float valor;

    public Consulta(Medico medico, Paciente paciente, LocalDateTime horario, float valor) {
        this.medico = medico;
        this.paciente = paciente;
        this.horario = horario;
        this.valor = valor;
    }
    public Consulta() {
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
