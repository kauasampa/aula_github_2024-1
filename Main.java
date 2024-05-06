import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Cadastrar Cliente", "Listar Clientes", "Sair"));
        boolean continuar = true;
        while (continuar) {
            int escolha = mainMenu.getSelection();
            switch (escolha) {
                case 1:
                    mainMenu.cadastrarCliente();
                    break;
                case 2:
                    mainMenu.listarClientes();
                    break;
                case 3:
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
