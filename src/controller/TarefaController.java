package controller;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TarefaController {

    private static List<Tarefa> listaDeTarefas = new ArrayList<>();

    public static Tarefa criarTarefa() {

        try (Scanner scanner = new Scanner(System.in)) {
            // Coleta e validação dos dados da tarefa
            System.out.print("Digite o ID da tarefa: ");
            Long id = null;
            while (id == null) {
                try {
                    id = Long.parseLong(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("ID inválido! Digite novamente: ");
                }
            }

            System.out.print("Digite o nome da tarefa: ");
            String nome = scanner.nextLine();
            while (nome == null || nome.trim().isEmpty()) {
                System.out.print("Nome inválido! Digite novamente: ");
                nome = scanner.nextLine();
            }

            System.out.print("Digite a descrição da tarefa: ");
            String descricao = scanner.nextLine();
            while (descricao == null || descricao.trim().isEmpty()) {
                System.out.print("Descrição inválida! Digite novamente: ");
                descricao = scanner.nextLine();
            }

            System.out.print("Escolha a prioridade da tarefa entre [1] e [5]: ");
            int prioridade = 0;
            while (prioridade < 1 || prioridade > 5) {
                try {
                    prioridade = Integer.parseInt(scanner.nextLine());
                    if (prioridade < 1 || prioridade > 5) {
                        System.out.print("Prioridade inválida! Digite novamente entre [1] e [5]: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Prioridade inválida! Digite novamente entre [1] e [5]: ");
                }
            }

            System.out.print("Escolha a categoria da tarefa: ");
            String categoria = scanner.nextLine();
            while (categoria == null || categoria.trim().isEmpty()) {
                System.out.print("Categoria inválida! Digite novamente: ");
                categoria = scanner.nextLine();
            }

            return new Tarefa(id, nome, descricao, prioridade, categoria);
        }
    }

    // Método Adicionar Tarefa
    public static Tarefa adicionaTarefa() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Código de leitura dos dados da tarefa
            Tarefa tarefa = criarTarefa(); // Método que cria a tarefa
            listaDeTarefas.add(tarefa);
            System.out.println("Tarefa adicionada com sucesso.");
            return tarefa; // Retorna apenas a tarefa criada recentemente
        } catch (Exception e) {
            System.out.println("Entrada inválida!");
            return null;
        }
    }

//    public static Tarefa mostrarTarefas() {
//
//    }

}
