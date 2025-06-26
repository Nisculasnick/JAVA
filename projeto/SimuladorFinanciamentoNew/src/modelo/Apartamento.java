package modelo;

public class Apartamento extends Financiamento {

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

    }
    @Override
    public double calcularPagamentoMensal(){
        double taxaMensal=  getTaxaJurosAnual()/12; //taxa mensal
        int totalMeses= getPrazoFinanciamento()*12; //valor em meses do financiamento

        //fórmula price
        double baseElevada=Math.pow((1+taxaMensal),totalMeses);
        double numerador=getValorImovel()* baseElevada;
        double denominador= baseElevada-1;
        if (denominador ==0){
            System.out.println("ERRO: Denominador é 0, verifique entrada!");
            return 0.0;
        }
        return numerador/denominador;
    }

}
