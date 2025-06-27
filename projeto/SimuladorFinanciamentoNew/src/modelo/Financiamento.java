package modelo;
public abstract class Financiamento {
        protected double valorImovel;
        protected int prazoFinanciamento;
        protected double taxaJurosAnual;
    
        public Financiamento( double valorImovel,   int prazoFinanciamento, double taxaJurosAnual){
            this.valorImovel=valorImovel;
            this.prazoFinanciamento=prazoFinanciamento;
            this.taxaJurosAnual=taxaJurosAnual;
        }
        public abstract double calcularPagamentoMensal(); /*{
            return(valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
        }*/
        public abstract double calcularTotalPagamento(); /*{
            return calcularPagamentoMensal() * prazoFinanciamento * 12;
        }*/
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

