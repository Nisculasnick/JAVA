package main;
import modelo.*;
import util.*;


public class main {
    public static void Main(String[] args) {
        InterfaceUsuario interfaceUsuariovar = new InterfaceUsuario();

        double valorImovel=interfaceUsuariovar.pedirValorImovel();
        int prazoFinanciamento=interfaceUsuariovar.pedirPrazoFinanciamento();
        double taxaJurosAnual=interfaceUsuariovar.pedirTaxaJurosAnual();

        Financiamento financiamentovar = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

        double pagamentoMensal=financiamentovar.calcularPagamentoMensal();
        double totalPagamento=financiamentovar.calcularTotalPagamento();

        System.out.println("\nRESUMO DO FINANCIAMENTO\n");
        financiamentovar.mostrarDadosBasicos();
        System.out.printf("Pagamento mensal: %.2f\n", pagamentoMensal);
        System.out.printf("Total a ser pago: %.2f\n", totalPagamento);
    }
  
}
