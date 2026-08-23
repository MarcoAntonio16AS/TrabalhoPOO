package com.myproject.view;

//Imports de classes e pacotes criados ao decorrer do programa!
import com.myproject.controller.ClientesController;
import com.myproject.controller.EventosController;
import com.myproject.controller.RecursosController;
import com.myproject.controller.ReservasController;
import com.myproject.model.Cliente;
import com.myproject.model.EventosReserva;
import com.myproject.model.Recurso;
import com.myproject.model.ReservasModel;

//Imports de bibliotecas java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ReservasInterface {

    public void iniciarSistema() {
        try (Scanner sc = new Scanner(System.in)) {
            ClientesController clienteController = new ClientesController();
            ReservasController reservaController = new ReservasController();
            RecursosController recursoController = new RecursosController();
            EventosController eventoController = new EventosController();
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            int opcao;
            
            do {
                
                System.out.println("\n====================================================");
                System.out.println("      SISTEMA DE RESERVAS - HOTEL/COWORKING");
                System.out.println("====================================================");
                
                System.out.println("1 - Clientes");
                System.out.println("2 - Reservas");
                System.out.println("3 - Recursos");
                System.out.println("4 - Eventos/Histórico");
                System.out.println("0 - Encerrar Sistema");
                
                System.out.print("\nEscolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();
                
                switch(opcao) {
                    
                    case 1 -> {
                        int opCliente;
                        
                        do {
                            
                            System.out.println("\n============== CLIENTES ==============");
                            
                            System.out.println("1 - Cadastrar Cliente");
                            System.out.println("2 - Listar Clientes");
                            System.out.println("3 - Atualizar Cliente");
                            System.out.println("4 - Apagar Cliente");
                            System.out.println("0 - Voltar");
                            
                            System.out.print("\nEscolha: ");
                            opCliente = sc.nextInt();
                            sc.nextLine();
                            
                            switch(opCliente) {
                                
                                case 1 -> {
                                    System.out.print("Nome: ");
                                    String nome = sc.nextLine();
                                    
                                    System.out.print("Documento: ");
                                    String doc = sc.nextLine();
                                    
                                    System.out.print("Telefone: ");
                                    String tel = sc.nextLine();
                                    
                                    clienteController.criarCliente(
                                            nome,
                                            doc,
                                            tel
                                    );
                                }
                                
                                case 2 -> {
                                    List<Cliente> clientes =
                                            clienteController.listarClientes();
                                    
                                    System.out.println("\n=========== CLIENTES ===========");
                                    
                                    for(Cliente c : clientes) {
                                        
                                        System.out.println(
                                                "ID: " + c.getId_cliente()
                                                        + " | Nome: "
                                                        + c.getNome_cliente()
                                                        + " | Documento: "
                                                        + c.getDoc_cliente()
                                                        + " | Telefone: "
                                                        + c.getTel_cliente()
                                        );
                                    }
                                }
                                
                                case 3 -> {
                                    System.out.print("ID do cliente: ");
                                    int idAtualizar = sc.nextInt();
                                    sc.nextLine();
                                    
                                    System.out.print("Novo nome: ");
                                    String novoNome = sc.nextLine();
                                    
                                    System.out.print("Novo documento: ");
                                    String novoDoc = sc.nextLine();
                                    
                                    System.out.print("Novo telefone: ");
                                    String novoTel = sc.nextLine();
                                    
                                    clienteController.atualizarCliente(
                                            idAtualizar,
                                            novoNome,
                                            novoDoc,
                                            novoTel
                                    );
                                }
                                
                                case 4 -> {
                                    System.out.print("ID do cliente: ");
                                    int idDelete = sc.nextInt();
                                    
                                    clienteController.deletarCliente(idDelete);
                                }
                                
                                case 0 -> System.out.println("Voltando...");
                                
                                default -> System.out.println("Opção inválida!");
                            }
                            
                        } while(opCliente != 0);
                    }
                    
                    case 2 -> {
                        int opReserva;
                        
                        do {
                            
                            System.out.println("\n============== RESERVAS ==============");
                            
                            System.out.println("1 - Criar Reserva");
                            System.out.println("2 - Listar Reservas");
                            System.out.println("3 - Atualizar Reserva");
                            System.out.println("4 - Cancelar Reserva");
                            System.out.println("0 - Voltar");
                            
                            System.out.print("\nEscolha: ");
                            opReserva = sc.nextInt();
                            sc.nextLine();
                            
                            switch(opReserva) {
                                
                                case 1 -> {
                                    System.out.print("ID Cliente: ");
                                    int idCliente = sc.nextInt();
                                    
                                    System.out.print("ID Recurso: ");
                                    int idRecurso = sc.nextInt();
                                    sc.nextLine();
                                    
                                    System.out.print(
                                            "Início (dd/MM/yyyy HH:mm): "
                                    );
                                    
                                    String inicioStr = sc.nextLine();
                                    
                                    System.out.print(
                                            "Fim (dd/MM/yyyy HH:mm): "
                                    );
                                    
                                    String fimStr = sc.nextLine();
                                    
                                    System.out.print("Valor base: ");
                                    double valor = sc.nextFloat();
                                    sc.nextLine();
                                    
                                    LocalDateTime inicio =
                                            LocalDateTime.parse(
                                                    inicioStr,
                                                    formatter
                                            );
                                    
                                    LocalDateTime fim =
                                            LocalDateTime.parse(
                                                    fimStr,
                                                    formatter
                                            );

                                    String status = "ATIVA";

                                    boolean criada =
                                            reservaController.criarReserva(
                                                    idCliente,
                                                    idRecurso,
                                                    inicio,
                                                    fim,
                                                    valor,
                                                    status
                                            );

                                    if (criada) {

                                        System.out.println(
                                                "Reserva criada com sucesso!"
                                        );

                                    } else {

                                        System.out.println(
                                                "Não foi possível criar a reserva."
                                        );
                                    }
                                }
                                
                                case 2 -> {
                                    List<ReservasModel> reservas =
                                            reservaController.listarReservas();
                                    
                                    System.out.println("\n=========== RESERVAS ===========");
                                    
                                    for(ReservasModel r : reservas) {
                                        
                                        System.out.println(
                                                "ID: " + r.getId_reserva()
                                                        + " | Cliente: "
                                                        + r.getId_cliente()
                                                        + " | Recurso: "
                                                        + r.getId_recurso()
                                                        + " | Início: "
                                                        + r.getInicio_reserva()
                                                        + " | Fim: "
                                                        + r.getFim_reserva()
                                                        + " | Valor Total: "
                                                        + r.getTotal_reserva()
                                                        + " | Status: "
                                                        + r.getStatus_reserva()
                                        );
                                    }
                                }
                                
                                case 3 -> {
                                    System.out.print("ID da reserva: ");
                                    int idReservaAtualizar = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("ID do cliente: ");
                                    int idClienteAtualizar = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("ID do recurso: ");
                                    int idRecursoAtualizar = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Início (dd/MM/yyyy HH:mm): ");
                                    String novoInicio = sc.nextLine();

                                    LocalDateTime Inicio =
                                            LocalDateTime.parse(
                                                    novoInicio,
                                                    formatter
                                            );

                                    System.out.print("Fim (dd/MM/yyyy HH:mm): ");
                                    String novoFim = sc.nextLine();

                                    LocalDateTime Fim =
                                            LocalDateTime.parse(
                                                    novoFim,
                                                    formatter
                                            );

                                    System.out.print("Novo valor base: ");
                                    double valor = sc.nextFloat();
                                    sc.nextLine();

                                    System.out.print("Nova disponibilidade (ATIVA, FINALIZADA, CANCELADA): ");
                                    String status = sc.nextLine();

                                    reservaController.atualizarReserva(
                                            idReservaAtualizar,
                                            idClienteAtualizar,
                                            idRecursoAtualizar,
                                            Inicio,
                                            Fim,
                                            valor,
                                            status
                                    );

                                }

                                
                                case 4 -> {
                                    System.out.print("ID da reserva: ");
                                    int idReserva = sc.nextInt();
                                    
                                    reservaController.deletarReserva(idReserva);
                                }
                                
                                case 0 -> System.out.println("Voltando...");
                                
                                default -> System.out.println("Opção inválida!");
                            }
                            
                        } while(opReserva != 0);

                    }
                    
                    case 3 -> {

                        int opRecursos;

                        do {

                            System.out.println("\n============== RECURSOS ==============");

                            System.out.println("1 - Criar Recurso");
                            System.out.println("2 - Listar Recursos");
                            System.out.println("3 - Atualizar Recursos");
                            System.out.println("4 - Apagar Recursos");
                            System.out.println("0 - Voltar");

                            System.out.print("\nEscolha: ");
                            opRecursos = sc.nextInt();
                            sc.nextLine();

                            switch (opRecursos) {

                                case 1 -> {
                                    System.out.print("Nome do Recurso: ");
                                    String nomeRecurso = sc.nextLine();

                                    System.out.print("Tipo do Recurso: ");
                                    String tipoRecurso = sc.nextLine();

                                    System.out.print("Capacidade do Recurso: ");
                                    int capRecurso = sc.nextInt();

                                    System.out.print("Preço do Recurso: ");
                                    double precoRecurso = sc.nextDouble();

                                    System.out.print("Disponível: ");
                                    boolean disponivel = sc.nextBoolean();

                                    recursoController.criarRecurso(
                                            nomeRecurso,
                                            tipoRecurso,
                                            capRecurso,
                                            precoRecurso,
                                            disponivel
                                    );

                                }


                                case 2 -> {
                                    List<Recurso> recursos =
                                            recursoController.listarRecursos();

                                    System.out.println("\n=========== RECURSOS ===========");

                                    for (Recurso r : recursos) {

                                        System.out.println(
                                                "ID: " + r.getId_recurso()
                                                        + " | Nome: "
                                                        + r.getNome_recurso()
                                                        + " | Tipo: "
                                                        + r.getTipo_recurso()
                                                        + " | Capacidade: "
                                                        + r.getCap_recurso()
                                                        + " | Preço: R$"
                                                        + r.getPreco_recurso()
                                                        + " | Disponível: "
                                                        + r.isDisponivel()

                                        );

                                    }

                                }

                                case 3 -> {
                                    System.out.print("ID do Recurso: ");
                                    int idAtualizar = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Novo nome: ");
                                    String novoNome = sc.nextLine();

                                    System.out.print("Novo tipo: ");
                                    String novoTipo = sc.nextLine();

                                    System.out.print("Nova capacidade: ");
                                    int novaCap = sc.nextInt();

                                    System.out.println("Novo preço: ");
                                    double novoPreco = sc.nextDouble();

                                    System.out.println("Nova disponibilidade: ");
                                    boolean novaDisponibilidade = sc.nextBoolean();

                                    recursoController.atualizarRecurso(
                                            idAtualizar,
                                            novoNome,
                                            novoTipo,
                                            novaCap,
                                            novoPreco,
                                            novaDisponibilidade
                                    );

                                }

                                case 4 -> {
                                    System.out.print("ID do Recurso: ");
                                    int idAReserva = sc.nextInt();

                                    recursoController.deletarRecurso(idAReserva);
                                }

                            }

                        } while (opRecursos != 0) ;

                    }
                    
                    case 4 -> {
                        List<EventosReserva> eventos = eventoController.listarEventos();

                        System.out.println("\n=========== EVENTOS ===========");
                        
                        for(EventosReserva e : eventos) {
                            
                            System.out.println(
                                    "ID Evento: " + e.getId_evento()
                                            + " | Reserva: "
                                            + e.getId_reserva()
                                            + " | Tipo: "
                                            + e.getTipo_evento()
                                            + " | Data: "
                                            + e.getData_evento()
                                            + " | Descrição: "
                                            + e.getDescricao()
                            );
                        }
                    }
                    
                    case 0 -> System.out.println(
                            "\nSistema encerrado com sucesso!"
                    );
                    
                    default -> System.out.println("Opção inválida!");
                }
                //==============================================================
                // CLIENTES
                //==============================================================
                // RESERVAS
                //==============================================================
                // RECURSOS
                //==============================================================
                // EVENTOS
                //==============================================================
                // ENCERRAR
                
            } while(opcao != 0);
        }
    }
}
