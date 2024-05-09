public class Conta {
    private int numeroConta;
    private double saldo;

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;  
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }


    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;  
            System.out.println("Depósito de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
        } else {
    
            System.out.println("Valor de depósito inválido. Por favor, insira um valor positivo.");
        }
    }

    @Override
    public String toString() {
        return "Número da Conta: " + numeroConta + ", Saldo: R$" + saldo;
    }
}