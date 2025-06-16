package main;

import java.util.ArrayList;
import modelo.Financiamento; 
import util.InterfaceUsuario;

public class main {
    public static void main(String[] args) { 
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        System.out.println("Entrada de Dados para 4 Financiamentos");
        for (int i = 0; i < 4; i++) { 
            System.out.printf("\nInforme os dados para o Financiamento %d:\n", i + 1);
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

            listaDeFinanciamentos.add(financiamento);
        }

        double totalTodosImoveis = 0;
        double totalTodosFinanciamentos = 0;

        System.out.println("\n--- Resumo Individual dos Financiamentos ---");
        int contador = 1;
        for (Financiamento f : listaDeFinanciamentos) {
            System.out.printf("\nFinanciamento %d:\n", contador++);
            System.out.printf("  Valor do Imóvel: R$ %.2f\n", f.getValorImovel());
            System.out.printf("  Prazo: %d anos\n", f.getPrazoFinanciamento());
            System.out.printf("  Taxa de Juros: %.2f%%\n", f.getTaxaJurosAnual() * 100);
            System.out.printf("  Pagamento Mensal: R$ %.2f\n", f.calcularPagamentoMensal());
            System.out.printf("  Valor Total do Financiamento: R$ %.2f\n", f.calcularTotalPagamento());

            totalTodosImoveis += f.getValorImovel();
            totalTodosFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\n--- Totais Gerais ---");
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalTodosImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalTodosFinanciamentos);
    }
}
