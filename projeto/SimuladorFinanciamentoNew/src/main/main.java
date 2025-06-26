package main;

import java.util.ArrayList;
import modelo.*; 
import util.InterfaceUsuario;

public class main {
    public static void main(String[] args) { 
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        System.out.println("Entrada de Dados para o 1° financiamento (CASA)");
        double valorImovelUsuario = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamentoUsuario = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnualUsuario = interfaceUsuario.pedirTaxaJurosAnual();

        Casa primeiraCasa =new Casa(valorImovelUsuario, prazoFinanciamentoUsuario, taxaJurosAnualUsuario);
        listaDeFinanciamentos.add(primeiraCasa);

        System.out.println("Adicionando dados fixos");

        Casa segundaCasa= new Casa(300000.0, 15,0.08);
        listaDeFinanciamentos.add(segundaCasa);

        Apartamento primeiroApartamento=new Apartamento(450000.0, 20, 0.095);
        listaDeFinanciamentos.add(primeiroApartamento);

        Apartamento segundoApartamento =new Apartamento(280000.0,10,0.07);
        listaDeFinanciamentos.add(segundoApartamento);

        Terreno terreno = new Terreno(120000.0,8,0.11);
        listaDeFinanciamentos.add(terreno);

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
