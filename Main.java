import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Abrir Conta", "Cadastrar Cliente", "Listar Clientes",
                "Depositar em Conta", "Exibir saldo", "Remover conta", "Depósito em moeda estrangeira", "Sacar de Conta","Remover Cliente", "Sair"));
        boolean continuar = true;
        while (continuar) {
            int escolha = mainMenu.getSelection();
            switch (escolha) {
                case 1:

                    mainMenu.abrirConta();
                    break;
                case 2:

                    mainMenu.cadastrarCliente();
                    break;
                case 3:

                    mainMenu.listarClientes();
                    break;
                case 4:

                    mainMenu.depositarEmConta();
                    break;

                case 5:

                    mainMenu.exibirSaldo();
                    break;

                case 6:

                    mainMenu.removerConta();
                    break;

                case 7:
                    mainMenu.depositarEmMoedaEstrangeira();
                    break;

                case 8:
                    mainMenu.sacarDeConta();

                case 9:
                    mainMenu.removerCliente();
                    break;
                   
                case 10: 
                 System.out.println("Fim");
                 continuar = false;
                 break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}