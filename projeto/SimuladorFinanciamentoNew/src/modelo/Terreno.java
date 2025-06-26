package modelo;

public class Terreno extends Financiamento {

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    //sobreescrevendo método de pagamento mensal
    @Override
    public double calcularPagamentoMensal(){
        double pagamentoBase = super.calcularPagamentoMensal();
        return (pagamentoBase+(pagamentoBase*0.02));
    }
}
