package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona= tipoZona;
    }
    //sobreescrevendo método de pagamento mensal
    @Override
    public double calcularPagamentoMensal(){
        double pagamentoBase =  (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
        return (pagamentoBase+(pagamentoBase*0.02));
    }

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }
}
