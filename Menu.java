import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title;
    private List<String> options;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

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

    public void depositarEmConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da conta para depósito:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        System.out.println("Digite o valor a ser depositado:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left-over

        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                conta.depositar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void exibirSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da conta para verificar o saldo:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.println("Saldo atual: R$" + conta.getSaldo());
                return;
            }
        }
        System.out.println("Conta não encontrada.");
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

    private boolean verificarContaExistente(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return true;
            }
        }
        return false;
    }

    public void abrirConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da conta que deseja criar:");
        int numeroConta = scanner.nextInt();

        if (verificarContaExistente(numeroConta)) {
            System.out.println("Uma conta com esse número já existe.");
        } else {
            Conta novaConta = new Conta(numeroConta);
            contas.add(novaConta);
            System.out.println("Conta criada com sucesso! " + novaConta);
        }
    }

    public void removerConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da conta a ser removida:");
        int numeroConta = scanner.nextInt();
        Conta contaParaRemover = null;
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                if (conta.getSaldo() == 0) {
                    contaParaRemover = conta;
                    break;
                } else {
                    System.out.println("A conta ainda possui saldo. Não é possível remover.");
                    return;
                }
            }
        }
        if (contaParaRemover != null) {
            contas.remove(contaParaRemover);
            System.out.println("Conta removida com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

}