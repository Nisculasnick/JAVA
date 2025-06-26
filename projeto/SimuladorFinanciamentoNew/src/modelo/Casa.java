package modelo;

public class Casa extends Financiamento {

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    //sobreescrevendo método de pagamento mensal
    @Override
    public double calcularPagamentoMensal(){
        double pagamentoBase = super.calcularPagamentoMensal();
        return pagamentoBase+80;
    }
}
