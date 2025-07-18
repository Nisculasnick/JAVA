package modelo;

import util.AumentoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private double areaConstruida;
    private double tamanhoTerreno;
    
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida= areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;

        validarJuros(valorImovel, prazoFinanciamento, taxaJurosAnual);

    }

    private void validarJuros(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {

        double jurosMensal=(valorImovel/(prazoFinanciamento*12.0))*(taxaJurosAnual/12.0);

        if (80>(jurosMensal/2.0)){
            throw new AumentoMaiorDoQueJurosException("O acreścimo de R$ 80 execede metade dos juros mensais!");
        }
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