import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title;
    private List<String> options;
    private List<Cliente> clientes = new ArrayList<>();

    public Menu(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public int getSelection() {
        Scanner scanner = new Scanner(System.in);
        int op = 0, i = 1;
        while (op == 0) {
            System.out.println(title + "\n");
            for (String option : options) {
                System.out.println(i++ + " - " + option);
            }
            System.out.println("Informe a opcao desejada.");
            try {
                op = Integer.parseInt(scanner.nextLine());
                if (op < 1 || op >= i) {
                    System.out.println("Opcao errada!");
                    op = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
        return op;
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();
        Cliente novoCliente = new Cliente(nome, email, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}