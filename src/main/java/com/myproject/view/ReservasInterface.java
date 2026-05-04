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
                            System.out.println("4 - Deletar Cliente");
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
                                    float valor = sc.nextFloat();
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
                                    
                                    reservaController.criarReserva(
                                            idCliente,
                                            idRecurso,
                                            inicio,
                                            fim,
                                            valor,
                                            "ATIVA"
                                    );
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
                                
                                case 3 -> System.out.println(
                                        "Atualização disponível futuramente."
                                );
                                
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
                        List<Recurso> recursos =
                                recursoController.listarRecursos();
                        
                        System.out.println("\n=========== RECURSOS ===========");
                        
                        for(Recurso r : recursos) {
                            
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
                    
                    case 4 -> {
                        List<EventosReserva> eventos =
                                eventoController.listarEventos();
                        
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
