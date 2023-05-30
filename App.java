import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private ArrayList<Cliente> clientes;
    private ArrayList<Imposto> impostos;
    private int proximoIdCliente;
    private int proximoIdImposto;

// Códigos para mudar as cores do programa 
public static final String RESETA = "\u001B[0m"; // resetar para a cor padrão
public static final String PRETO = "\u001B[30m"; 
public static final String VERMELHO = "\u001B[31m";
public static final String VERDE = "\u001B[32m";
public static final String AMARELO = "\u001B[33m";
public static final String AZUL = "\u001B[34m";
public static final String MAGENTA = "\u001B[35m";
public static final String CIANO = "\u001B[36m";
public static final String BRANCO = "\u001B[37m";
public static final String ROXO_TITULO = "\u001B[35m";



 
    public App() {
        clientes = new ArrayList<>();
        impostos = new ArrayList<>(); 
        proximoIdCliente = 1;
        proximoIdImposto = 1;
    }

    public void registarImposto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println( AZUL + "\n---- Registar Imposto ----"+ RESETA);

        // Solicitar dados do cliente
        System.out.println("Dados do Cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Criar objeto Endereco e Contacto
        Endereco objEndereco = new Endereco(endereco);
        Contacto objContacto = new Contacto(telefone, email);

        // Criar objeto Cliente
        Cliente cliente = new Cliente(proximoIdCliente, nome, objEndereco, objContacto);
        clientes.add(cliente);

        // Solicitar tipo de imposto
        System.out.println(AZUL+"\nEscolha o tipo de imposto:"+ RESETA);
        System.out.println(CIANO + "1 - Imposto Arrendado" + RESETA);
        System.out.println(CIANO + "2 - Imposto Não Arrendado" + RESETA);
        int tipoImposto = scanner.nextInt();



        // Registrar imposto com base no tipo escolhido
        if (tipoImposto == 1) {
            System.out.print("Valor da Renda: ");
            double valorRenda = scanner.nextDouble();
            ImpostoArrendado impostoArrendado = new ImpostoArrendado(proximoIdImposto, 0.15, valorRenda);
            impostos.add(impostoArrendado);
        } else if (tipoImposto == 2) {
            System.out.print("Valor Patrimonial: ");
            double valorPatrimonial = scanner.nextDouble();
            ImpostoNaoArrendado impostoNaoArrendado = new ImpostoNaoArrendado(proximoIdImposto, 0.005, valorPatrimonial);
            impostos.add(impostoNaoArrendado);
        }


        // Incrementar o Id para o próximo cliente e próximo imposto
        proximoIdCliente++;
        proximoIdImposto++;

        System.out.println(VERDE + "\nImposto registrado com sucesso!\n" + RESETA);
    }

    public void consultarImposto(int idCliente) {
        System.out.println(AZUL + "\n---- Consultar Imposto ----" + RESETA);

        // Procurar cliente com base no ID fornecido
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            System.out.println("Dados do Cliente:");
            System.out.println(cliente.toString());

            System.out.println("\nImpostos relacionados: ");

            // Procurar impostos relacionados ao cliente
            for (Imposto imposto : impostos) {
                if (imposto.getId() == idCliente) {
                    System.out.println(VERDE + imposto.toString() + RESETA);
                }
            }
        } else {
            System.out.println( VERMELHO + "Cliente não encontrado." + RESETA);
        }
    }

    public void atualizarImposto(int idCliente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(AZUL + "\n---- Atualizar Imposto ----" + RESETA);


        // Procurar cliente com base no ID fornecido
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            System.out.println("Dados do Cliente:");
            System.out.println( VERDE+ cliente.toString() + RESETA);

            System.out.println("\nImpostos relacionados:");

            // Procurar e atualizar impostos relacionados ao cliente
            for (Imposto imposto : impostos) {
                if (imposto.getId() == idCliente) {
                    if (imposto instanceof ImpostoArrendado) {
                        System.out.print( VERDE+ "Novo valor da Renda: "+RESETA);
                        double valorRenda = scanner.nextDouble();
                        ((ImpostoArrendado) imposto).setValorRenda(valorRenda);
                    } else if (imposto instanceof ImpostoNaoArrendado) {
                        System.out.print("Novo valor Patrimonial: ");
                        double valorPatrimonial = scanner.nextDouble();
                        ((ImpostoNaoArrendado) imposto).setValorPatrimonial(valorPatrimonial);
                    }
                }
            }
        } else {
            System.out.println(VERMELHO + "Cliente não encontrado." + RESETA);
        }
    }

    public void verListaImposto() {
        System.out.println(CIANO + "\n---- Lista de Impostos ----" + RESETA);

        for (Imposto imposto : impostos) {
            System.out.println(VERDE + imposto.toString() + RESETA +"\n");
        }
    }

    public void removerImposto(int idCliente) {
        System.out.println(AZUL + "\n---- Remover Imposto ----"+ RESETA);

        // Procurar e remover impostos relacionados ao cliente
        for (Imposto imposto : impostos) {
            if (imposto.getId() == idCliente) {
                impostos.remove(imposto);
                break;
            }
        }

        System.out.println(VERDE + "Imposto removido com sucesso!\n" + RESETA);
    }

    public static void main(String[] args) {
        App programa = new App();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 6) {
            System.out.println(ROXO_TITULO + "\n\n---- IMPOSTO PREDIAL ----"+RESETA);
            System.out.println(AZUL+"1 - Registar Imposto");
            System.out.println("2 - Consultar Imposto");
            System.out.println("3 - Atualizar Imposto");
            System.out.println("4 - Ver Lista de Impostos");
            System.out.println("5 - Remover Imposto");
            System.out.println("6 - Sair" + RESETA);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    programa.registarImposto();
                    break;
                case 2:
                    System.out.print("Digite o ID do Cliente: ");
                    int idConsulta = scanner.nextInt();
                    programa.consultarImposto(idConsulta);
                    break;
                case 3:
                    System.out.print("Digite o ID do Cliente: ");
                    int idAtualizacao = scanner.nextInt();
                    programa.atualizarImposto(idAtualizacao);
                    break;
                case 4:
                    programa.verListaImposto();
                    break;
                case 5:
                    System.out.print("Digite o ID do Cliente: ");
                    int idRemocao = scanner.nextInt();
                    programa.removerImposto(idRemocao);
                    break;
                case 6:
                    System.out.println(MAGENTA + "Encerrando o programa..." + RESETA);
                    break;
                default:
                    System.out.println(VERMELHO + "Opção inválida. Tente novamente." + RESETA);
                    break;
            }
        }
    }
}
