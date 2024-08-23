package ContaPOO;

import Exceptions.SaldoInsuficienteException;

public abstract class Conta implements IConta {
    
    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    
    protected int agencia;
    protected int numero;
    protected Double saldo = 0.0;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }


    @Override
    public void sacar(double valor) {
        try {
            if (valor > saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
            }
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Saldo atual: " + this.saldo);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    protected void imprimirDados() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
