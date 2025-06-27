package main;

import java.util.ArrayList;
import modelo.*; 
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        System.out.println("Entrada de Dados para o 1° financiamento (CASA)");
        double valorImovelUsuario = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamentoUsuario = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnualUsuario = interfaceUsuario.pedirTaxaJurosAnual();
        double areaConstruidaUsuario = interfaceUsuario.pedirAreaConstruida();
        double tamanhoTerrenousuario = interfaceUsuario.pedirTamanhoTerreno();

        Casa primeiraCasa =new Casa(valorImovelUsuario, prazoFinanciamentoUsuario, taxaJurosAnualUsuario, areaConstruidaUsuario, tamanhoTerrenousuario);
        listaDeFinanciamentos.add(primeiraCasa);

        System.out.println("Adicionando dados fixos");

        Casa segundaCasa= new Casa(300000.0, 15,0.08, 180.0, 400.0);
        listaDeFinanciamentos.add(segundaCasa);

        Apartamento primeiroApartamento=new Apartamento(450000.0, 20, 0.095, 1, 303);
        listaDeFinanciamentos.add(primeiroApartamento);

        Apartamento segundoApartamento =new Apartamento(280000.0,10,0.07, 2, 201);
        listaDeFinanciamentos.add(segundoApartamento);

        Terreno terreno = new Terreno(120000.0,8,0.11, "Residencial");
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


            switch (f) {
                case Casa casa -> {
                    System.out.printf("\nÁrea contruída: %.2f m²\n", casa.getAreaConstruida());
                    System.out.printf("\nTamando do Terreno: %.2f m²\n", casa.getTamanhoTerreno());
                }
                case Apartamento apartamento -> {
                    System.out.printf("\nNúmero de vagas na garagem: %d\n", apartamento.getVagasGaragem());
                    System.out.printf("\nNumero do andar: %d\n", apartamento.getNumeroAndar());
                }
                case Terreno zona -> System.out.printf("\nTipo de zona: %s\n", zona.getTipoZona());
                default -> {
                }
            }
            System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

            totalTodosImoveis += f.getValorImovel();
            totalTodosFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\n--- Totais Gerais ---");
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalTodosImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalTodosFinanciamentos);
    }
}
