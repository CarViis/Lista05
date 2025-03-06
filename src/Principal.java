import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;

import entidade.*;
import dao.*;
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Sair do programa");
            System.out.println("2. Cadastrar novo médico");
            System.out.println("3. Cadastrar novo paciente");
            System.out.println("4. Buscar médico por matrícula");
            System.out.println("5. Buscar Paciente por CPF");
            System.out.println("6. Cadastrar uma nova consulta");
            System.out.println("7. Remover uma consulta cadastrada");
            System.out.println("8. Atualizar o horário de uma consulta cadastrada");
            System.out.println("9. Gerar relatório de consulta");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Saindo do programa...");
                    break;
                case 2:
                    System.out.println("Cadastrar novo médico");
                    Medico m = new Medico();
                    System.out.println("Digite o nome do médico: ");
                    m.setNome(scanner.nextLine());
                    System.out.println("Digite a matrícula do médico: ");
                    m.setMatricula(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Digite a especialidade do médico: ");
                    m.setEspecialidade(scanner.nextLine());
                    System.out.println("Digite o salário do médico: ");
                    m.setSalario(scanner.nextFloat());
                    scanner.nextLine();
                    MedicoDAO mDAO = new MedicoDAO();
                    if (mDAO.inserirMedico(m)) {
                        System.out.println("Médico cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar médico."); 
                    }
                    mDAO.close();
                    break;
                case 3:
                    System.out.println("Cadastrar novo paciente");
                    Paciente p = new Paciente();
                    System.out.println("Digite o nome do paciente: ");
                    p.setNome(scanner.nextLine());
                    System.out.println("Digite o CPF do paciente: ");
                    p.setCpf(scanner.nextLine());
                    System.out.println("Digite a doença do paciente: ");
                    p.setDoenca(scanner.nextLine());
                    PacienteDAO pDAO = new PacienteDAO();
                    if (pDAO.inserirPaciente(p)) {
                        System.out.println("Paciente cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar paciente.");
                    }
                    pDAO.close();
                    break;
                case 4:
                    System.out.println("Buscar médico por matrícula");
                    System.out.println("Digite a matrícula do médico: ");
                    MedicoDAO mDAO2 = new MedicoDAO();
                    Medico medico = mDAO2.BuscarMedicoPorMatricula(scanner.nextInt());
                    if (medico != null) {
                        System.out.println("Médico encontrado:");
                        // System.out.println("ID: " + medico.getId());
                        System.out.println("Nome: " + medico.getNome());
                        System.out.println("Matrícula: " + medico.getMatricula());
                        System.out.println("Especialidade: " + medico.getEspecialidade());
                        System.out.println("Salário: " + medico.getSalario());
                    } else {
                        System.out.println("Médico não encontrado.");    
                    }
                    mDAO2.close();
                    break;
                case 5:
                    System.out.println("Buscar Paciente por CPF");
                    System.out.println("Digite o CPF do paciente: ");
                    PacienteDAO pDAO2 = new PacienteDAO();
                    Paciente paciente = pDAO2.buscarPacientePorCpf(scanner.nextLine());
                    if (paciente != null) {
                        System.out.println("Paciente encontrado:");
                        // System.out.println("ID: " + paciente.getId());
                        System.out.println("Nome: " + paciente.getNome());
                        System.out.println("CPF: " + paciente.getCpf());
                        System.out.println("Doença: " + paciente.getDoenca());
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    pDAO2.close();
                    break;
                case 6:
                    System.out.println("Cadastrar uma nova consulta");
                    Consulta c = new Consulta();
                    System.out.println("Digite a matrícula do médico: ");
                    MedicoDAO mDAO3 = new MedicoDAO();
                    c.setMedico(mDAO3.BuscarMedicoPorMatricula(scanner.nextInt()));
                    scanner.nextLine();
                    mDAO3.close();
                    System.out.println("Digite o CPF do paciente: ");
                    PacienteDAO pDAO3 = new PacienteDAO();
                    c.setPaciente(pDAO3.buscarPacientePorCpf(scanner.nextLine()));
                    pDAO3.close();
                    System.out.println("Digite a data e horário da consulta: (Utilizando o Formato \"DD/MM/AAAA hh:mm\")");
                    c.setHorario(DateUtil.stringToDate(scanner.nextLine(), LocalDateTime.class));
                    System.out.println("Digite o valor da consulta: ");
                    c.setValor(scanner.nextFloat());
                    scanner.nextLine();
                    ConsultaDAO cDAO = new ConsultaDAO();
                    if (cDAO.inserirConsulta(c)) {
                        System.out.println("Consulta cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar consulta.");
                    }
                    cDAO.close();
                    break;
                case 7:
                    System.out.println("Remover uma consulta cadastrada");
                    Consulta c2 = new Consulta();
                    System.out.println("Digite a matrícula do médico: ");
                    MedicoDAO mDAO4 = new MedicoDAO();
                    c2.setMedico(mDAO4.BuscarMedicoPorMatricula(scanner.nextInt()));
                    scanner.nextLine();
                    mDAO4.close();
                    System.out.println("Digite o CPF do paciente: ");
                    PacienteDAO pDAO4 = new PacienteDAO();
                    c2.setPaciente(pDAO4.buscarPacientePorCpf(scanner.nextLine()));
                    pDAO4.close();
                    System.out.println("Digite a data e horário da consulta: (Utilizando o Formato \"DD/MM/AAAA hh:mm\")");
                    c2.setHorario(DateUtil.stringToDate(scanner.nextLine(), LocalDateTime.class));
                    ConsultaDAO cDAO2 = new ConsultaDAO();
                    if (cDAO2.deletarConsulta(c2)) {
                        System.out.println("Consulta removida com sucesso!");
                    } else {
                        System.out.println("Erro ao remover consulta.");
                    }
                    cDAO2.close();
                    break;
                case 8:
                    System.out.println("Atualizar o horário de uma consulta cadastrada");
                    Consulta c3 = new Consulta();
                    System.out.println("Digite a matrícula do médico: ");
                    MedicoDAO mDAO5 = new MedicoDAO();
                    c3.setMedico(mDAO5.BuscarMedicoPorMatricula(scanner.nextInt()));
                    scanner.nextLine();
                    mDAO5.close();
                    System.out.println("Digite o CPF do paciente: ");
                    PacienteDAO pDAO5 = new PacienteDAO();
                    c3.setPaciente(pDAO5.buscarPacientePorCpf(scanner.nextLine()));
                    pDAO5.close();
                    System.out.println("Digite a data e horário da consulta: (Utilizando o Formato \"DD/MM/AAAA hh:mm\")");
                    c3.setHorario(DateUtil.stringToDate(scanner.nextLine(), LocalDateTime.class));
                    System.out.println("Digite a nova data e horário da consulta: (Utilizando o Formato \"DD/MM/AAAA hh:mm\")");
                    LocalDateTime novoHorario = DateUtil.stringToDate(scanner.nextLine(), LocalDateTime.class);
                    ConsultaDAO cDAO3 = new ConsultaDAO();
                    if (cDAO3.atualizarHorarioConsulta(c3, novoHorario)) {
                        System.out.println("Horário da consulta atualizado com sucesso!");
                    } else {
                        System.out.println("Erro ao atualizar horário da consulta.");
                    }
                    cDAO3.close();
                    break;
                case 9:
                    System.out.println("Gerar relatório de consulta");
                    ConsultaDAO cDAO4 = new ConsultaDAO();
                    List<Consulta> consultas = cDAO4.gerarRelatorio();
                    cDAO4.close();
                    if (consultas.size() > 0) {
                        System.out.println("Relatório de consultas:");
                        for (int i = 0; i < consultas.size(); i++) {
                            System.out.println("Consulta " + (i + 1) + ":");
                            System.out.println("    Nome do Médico: " + consultas.get(i).getMedico().getNome() + " (" + consultas.get(i).getMedico().getMatricula() + ")");
                            System.out.println("    Nome do Paciente: " + consultas.get(i).getPaciente().getNome() + " (" + consultas.get(i).getPaciente().getCpf() + ")");
                            System.out.println("    Horário: " + DateUtil.dateToString(consultas.get(i).getHorario()));
                            System.out.println("    Valor: R$ " + consultas.get(i).getValor());
                        }
                    } else {
                        System.out.println("Nenhuma consulta cadastrada.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 1);

        scanner.close();
    }
}
