// Arquivo único: SimuladorFinanciamento.java

import java.util.Scanner;

public class SimuladorFinanciamento {
    public static void main(String[] args) {
        // Fluxo principal do programa
        InterfaceUsuario interfaceUsuariovar = new InterfaceUsuario();
        
        double valorImovel = interfaceUsuariovar.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuariovar.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuariovar.pedirTaxaJurosAnual();
        
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        
        double pagamentoMensal = financiamento.calcularPagamentoMensal();
        double totalPagamento = financiamento.calcularTotalPagamento();
        
        System.out.printf("\nResumo do Financiamento:\n");
        System.out.printf("Valor do imóvel: R$ %.2f\n", valorImovel);
        System.out.printf("Prazo: %d anos\n", prazoFinanciamento);
        System.out.printf("Taxa de juros anual: %.2f%%\n", taxaJurosAnual * 100);
        System.out.printf("Pagamento mensal: R$ %.2f\n", pagamentoMensal);
        System.out.printf("Total a ser pago: R$ %.2f\n", totalPagamento);
    }
}

class Financiamento {
    final double valorImovel;
    final int prazoFinanciamento;
    final double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double calcularPagamentoMensal() {
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
    }

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }
}

class InterfaceUsuario {
    final  Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        System.out.print("Digite o valor do imóvel: ");
        return scanner.nextDouble();
    }

    public int pedirPrazoFinanciamento() {
        System.out.print("Digite o prazo do financiamento em anos: ");
        return scanner.nextInt();
    }

    public double pedirTaxaJurosAnual() {
        System.out.print("Digite a taxa de juros anual (em decimal e com virgula ',', ex: 0,05 para 5%): ");
        return scanner.nextDouble();
    }
    
}


