package modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;
    
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida= areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }
    //sobreescrevendo método de pagamento mensal
    @Override
    public double calcularPagamentoMensal(){
        double pagamentoBase = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
        return pagamentoBase+80;
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }
    //Getters e Setters

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public void setTamanhoTerreno(double tamanhoTerreno) {
        this.tamanhoTerreno = tamanhoTerreno;
    }
}