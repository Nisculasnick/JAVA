import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        interfaceUsuario interfaceUsuariovar = new interfaceUsuario();

        double valorImovel=interfaceUsuariovar.pedirValorImovel();
        int prazoFinanciamento=interfaceUsuariovar.pedirPrazoFinanciamento();
        double taxaJurosAnual=interfaceUsuariovar.pedirTaxaJurosAnual();

        Financiamento financiamentovar = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

        double pagamentoMensal=financiamentovar.calcularPagamentoMensal();
        double totalPagamento=financiamentovar.calcularTotalPagamento();

        System.out.println("\nRESUMO DO FINANCIAMENTO\n");
        System.out.printf("Valor do imóvel: R$ %.2f\n", valorImovel);
        System.out.printf("Prazo de %d anos\n", prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual %.2f\n" ,taxaJurosAnual*100);
        System.out.printf("Pagamento mensal: %.2f\n", pagamentoMensal);
        System.out.printf("Total a ser pago: %.2f\n", totalPagamento);
    }
  
}

class Financiamento{
    final double valorImovel;
    final int prazoFinanciamento;
    final double taxaJurosAnual;

    public Financiamento( double valorImovel,   int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel=valorImovel;
        this.prazoFinanciamento=prazoFinanciamento;
        this.taxaJurosAnual=taxaJurosAnual;
    }
    public double calcularPagamentoMensal(){
        return(valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }
}
class interfaceUsuario{
    final Scanner scanner;

    public interfaceUsuario(){
        scanner = new Scanner(System.in);
    }
    public double pedirValorImovel(){
        System.out.print("Digite valor do imóvel: ");
        return scanner.nextDouble();
    }
    public int pedirPrazoFinanciamento(){
        System.out.print("Digite prazo do finaciamento em anos: ");
        return scanner.nextInt();
    }
    public double pedirTaxaJurosAnual(){
        System.out.print("Digite taxa de juros anual (em decimal, ex.: 0.05 para 5%): ");
        return scanner.nextDouble();
    }
}
/*
FINANCIAMENTO, faz os cálculos
pega (atributos) as variaveis como private para trabalhar somente dentro da classe financiamento
o construtor solicita os parâmetros (as variáveis/atributos) depois tem que dizer ao construtor que o valor recebido no parãmetro é igual ao atributo criado na classe financiamento por isso o uso do this. e pega os valores das variáveis main que vem do scanner

MAIN, organiza o que o scanner coletou
Parte 1
criar variável chamando a classe interfaceUsuario interfaceUsuariovar = new InterfaceUsuario()
variavel double valorImóvel
variável int PrazoFinanciamento
variavel double taxaJurosAnual 
Parte 2
Pega os valores gerados pelo financiamento e espera 3 itens:
Financiamento financiamentovar= new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual)
Depois coleta dos métodos da class Financiamento o calcularxxx()
Mostra os resultados ao usuário:
valor do imóvel;
prazo em anos;
taxa de juros anual (taxaJurosAnual * 100)
Pagamento mensal;
total Pagamento.

INTERFACE, coleta com o scanner
pedir o valor do ímovel double
pedir prazo do financiamento int
pedir a taxa de juros double


*/
