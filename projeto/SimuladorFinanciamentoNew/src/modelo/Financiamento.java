package modelo;
public class Financiamento {
        private double valorImovel;
        private int prazoFinanciamento;
        private double taxaJurosAnual;
    
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
        //Getters
        public double getValorImovel(){
            return valorImovel;
        }  
        public int getPrazoFinanciamento(){
            return prazoFinanciamento;
        }  
        public double getTaxaJurosAnual(){
            return taxaJurosAnual;
        }
}

