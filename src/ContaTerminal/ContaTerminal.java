package ContaTerminal;

import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int numero = 0;
        String agencia = "";
        String nomeCliente = "";
        double saldo = 0.0;

        System.out.println("Por favor, digite o número da Agência!");
        numero = scanner.nextInt();
        System.out.println("Por favor, digite o código da Agência!");
        scanner.nextLine();
        agencia = scanner.nextLine();
        System.out.println("Por favor, digite seu nome!");
        nomeCliente = scanner.nextLine();
        System.out.println("Por favor, digite o saldo da conta!");
        saldo = scanner.nextDouble();

        System.out.println();
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo " + String.format("%.2f", saldo) + " já está disponível para saque");

        // Fechando o scanner
        scanner.close();
    }
}