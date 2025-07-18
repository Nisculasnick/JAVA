package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private int vagasGaragem;
    private int numeroAndar;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem= vagasGaragem;
        this.numeroAndar= numeroAndar;

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

    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }
    //Getters e Setters

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
    }
}
