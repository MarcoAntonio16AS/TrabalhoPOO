package br.edu.agendacrudmysql.view;

import br.edu.agendacrudmysql.controller.ContatoController;
import br.edu.agendacrudmysql.model.Contato;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * VIEW (Console): interface com o usuário em modo texto. - Mostra menu - Lê
 * entradas - Chama o Controller
 */
public class ConsoleView {

    private final ContatoController controller = new ContatoController();
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        int op;
        do {
            mostrarMenu();
            op = lerInt("Escolha: ");
            try {
                switch (op) {
                    case 1 ->
                        criar();
                    case 2 ->
                        listar();
                    case 3 ->
                        buscarPorId();
                    case 4 ->
                        buscarPorNome();
                    case 5 ->
                        atualizar();
                    case 6 ->
                        remover();
                    case 0 ->
                        System.out.println("Encerrando...");
                    default ->
                        System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro de validação: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Erro de banco de dados: "
                        + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (op != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=== CRUD Contatos (MySQL) ===");
        System.out.println("1) Criar contato");
        System.out.println("2) Listar contatos");
        System.out.println("3) Buscar contato por ID");
        System.out.println("4) Buscar contato por nome (trecho)");
        System.out.println("5) Atualizar contato");
        System.out.println("6) Remover contato");
        System.out.println("0) Sair");
    }

    private void criar() throws SQLException {
        System.out.println("\n-- Criar contato --");
        String nome = lerLinha("Nome: ");
        String email = lerLinha("Email: ");
        String telefone = lerLinha("Telefone: ");
        int id = controller.criarContato(nome, email, telefone);
        System.out.println("Contato criado com ID: " + id);
    }

    private void listar() throws SQLException {
        System.out.println("\n-- Listar contatos --");
        List<Contato> lista = controller.listarContatos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }
        for (Contato c : lista) {
            System.out.println(c);
        }
    }

    private void buscarPorId() throws SQLException {
        System.out.println("\n-- Buscar por ID --");
        int id = lerInt("ID: ");
        Contato c = controller.buscarContato(id);
        System.out.println(c == null ? "Não encontrado." : c.toString());
    }

    private void buscarPorNome() throws SQLException {
        System.out.println("\n-- Buscar por nome --");
        String trecho = lerLinha("Trecho do nome: ");
        List<Contato> lista = controller.buscarPorNome(trecho);
        if (lista.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
            return;
        }
        for (Contato c : lista) {
            System.out.println(c);
        }
    }

    private void atualizar() throws SQLException {
        System.out.println("\n-- Atualizar contato --");
        int id = lerInt("ID: ");
        String nome = lerLinha("Novo nome: ");
        String email = lerLinha("Novo email: ");
        String telefone = lerLinha("Novo telefone: ");
        boolean ok = controller.atualizarContato(id, nome, email, telefone);
        System.out.println(ok ? "Atualizado com sucesso." : "ID não encontrado.");
}
private void remover() throws SQLException {
        System.out.println("\n-- Remover contato --");
        int id = lerInt("ID: ");
        boolean ok = controller.removerContato(id);
        System.out.println(ok ? "Removido com sucesso." : "ID não encontrado.");
}
// -------- utilitários de leitura (evitam bugs comuns de Scanner) --------
private int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private String lerLinha(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}
