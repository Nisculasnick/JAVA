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
        public double getvalorImovel(){
            return valorImovel;
        }  
        public int getprazoFinanciamento(){
            return prazoFinanciamento;
        }  
        public double  taxaJurosAnual(){
            return taxaJurosAnual;
        }
        //mostrar dados 
        public  void mostrarDadosBasicos() {
        System.out.println("\nDADOS BÁSICO FINANCIAMENTO\n");
        System.out.printf("Valor do imóvel: R$ %.2f\n", valorImovel);
        System.out.printf("Prazo de %d anos\n", prazoFinanciamento);

        }
}
