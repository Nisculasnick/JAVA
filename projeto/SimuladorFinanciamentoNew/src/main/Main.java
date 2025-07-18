package main;

import java.io.*;
import java.util.ArrayList;
import modelo.*;
import util.AumentoMaiorDoQueJurosException;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) throws AumentoMaiorDoQueJurosException {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        System.out.println("Entrada de Dados para o 1° financiamento (CASA)");
        double valorImovelUsuario = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamentoUsuario = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnualUsuario = interfaceUsuario.pedirTaxaJurosAnual();
        double areaConstruidaUsuario = interfaceUsuario.pedirAreaConstruida();
        double tamanhoTerrenousuario = interfaceUsuario.pedirTamanhoTerreno();

        Casa primeiraCasa =new Casa(valorImovelUsuario, prazoFinanciamentoUsuario, taxaJurosAnualUsuario, areaConstruidaUsuario, tamanhoTerrenousuario);
        listaDeFinanciamentos.add(primeiraCasa);

        System.out.println("Adicionando dados fixos");

        Casa segundaCasa= new Casa(3000000.0, 10,0.08, 180.0, 400.0);
        listaDeFinanciamentos.add(segundaCasa);

        Apartamento primeiroApartamento=new Apartamento(2000000.0, 10, 0.08, 1, 303);
        listaDeFinanciamentos.add(primeiroApartamento);

        Apartamento segundoApartamento =new Apartamento(280000.0,10,0.07, 2, 201);
        listaDeFinanciamentos.add(segundoApartamento);

        Terreno terreno = new Terreno(120000.0,8,0.11, "Residencial");
        listaDeFinanciamentos.add(terreno);

        double totalTodosImoveis = 0;
        double totalTodosFinanciamentos = 0;

        // Escrver e ler dados num arquivo de texto
        String arquivoTexto = "Financiamento_detalhes.txt";
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoTexto))) {
            System.out.println("\nSalvando Dados do Financimento em: " + arquivoTexto+"\n");
            int contador = 1;
            for (Financiamento f: listaDeFinanciamentos){
                StringBuilder linha= new StringBuilder();
                linha.append("\nFinanciamento: ").append(contador++).append(" \n");
                linha.append("Valor imóvel: ").append(f.getValorImovel()).append(", ");
                linha.append("Prazo de Financiamento: ").append(f.getPrazoFinanciamento()).append(", ");
                linha.append("Taxa de juros: ").append(f.getTaxaJurosAnual()).append(", ");
                linha.append("Prazo: ").append(f.getPrazoFinanciamento()).append(" anos\n");
                if (f instanceof Casa casa){
                    linha.append("\nTipo = Casa\n");
                    linha.append("Tamanho do Terreno: ").append(casa.getTamanhoTerreno()).append(", ");
                    linha.append("Área construída: ").append(casa.getAreaConstruida()).append("\n");
                } else if (f instanceof Apartamento apt) {
                    linha.append("\nTipo = Apartamento\n");
                    linha.append("Número do andar: ").append(apt.getNumeroAndar()).append(", ");
                    linha.append("Vagas de garagem: ").append(apt.getVagasGaragem()).append("\n");
                } else if (f instanceof Terreno zona) {
                    linha.append("\nTipo = Terreno\n");
                    linha.append("Tipo de zona: ").append(zona.getTipoZona()).append("\n");
                }
                escritor.write(linha.toString());
                escritor.newLine();
            }
        }catch (IOException e){
            System.err.println("Erro ao salvar dados de financimento! " + e.getMessage());
        }
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoTexto))){
            String linhaLida;
            while ((linhaLida= leitor.readLine())!= null){
                System.out.println(linhaLida);
            }
            System.out.println("Leitura do arquivo concluída!");

        }catch (IOException e){
            System.err.println("Erro ao ler arquivo "+ e.getMessage());
        }

        // Serializando e Desserializar
        String arquivoSerialializado = "Financiamento.ser";
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(arquivoSerialializado))) {
            System.out.println("--- Serialiando aquivos em: "+ arquivoSerialializado+" ---");
            oos.writeObject(listaDeFinanciamentos);
            System.out.println("Lista de financiamentos serializada com sucesso.");
        }catch ( IOException e){
            System.out.println("Erro ao serialiar Lista de Financiamentos ! "+ e.getMessage());
        }

        ArrayList<Financiamento> listaDesserializada =null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoSerialializado))){
            System.out.println(("--- Desserializando aquivos de : "+ arquivoSerialializado+" ---"));
            listaDesserializada=(ArrayList<Financiamento>) ois.readObject();
            System.out.print("Lista de Financiamentos Dessializada com sucesso!");

            //comprovação
        System.out.println("---Comprovação da lista desserializada---");
        int contadorDesserializado=1;
        for (Financiamento f : listaDesserializada){
            System.out.printf("\nFinanciamento Desserializado %d:\n", contadorDesserializado++);
            System.out.printf("  Valor do Imóvel: R$ %.2f\n", f.getValorImovel());
            System.out.printf("  Prazo: %d anos\n", f.getPrazoFinanciamento());
            System.out.printf("  Taxa de Juros: %.2f%%\n", f.getTaxaJurosAnual() * 100);
            System.out.printf("  Pagamento Mensal: R$ %.2f\n", f.calcularPagamentoMensal());
            System.out.printf("  Valor Total do Financiamento: R$ %.2f\n", f.calcularTotalPagamento());

            switch (f){
                case Casa casa ->{
                    System.out.printf("Área construída: %2f\n", casa.getAreaConstruida());
                    System.out.printf("Tamanho do terreno: %2f\n",casa.getTamanhoTerreno());
                }
                case Apartamento apt ->{
                    System.out.printf("Número do Andar: %d\n", apt.getNumeroAndar());
                    System.out.printf("Vagas na garagem: %d\n", apt.getVagasGaragem());
                }
                case Terreno terr -> {
                    System.out.printf("Zona: %s\n", terr.getTipoZona());
                }default -> {}
            }
        }}catch (IOException | ClassNotFoundException e){
            System.out.println("Erro ao IO ao Desserializar arquivo ou classe não encontrada! \n");
        }
        System.out.print("----------------------------------------------------\n");


        System.out.println("\n--- Resumo Individual dos Financiamentos ---");
        int contador = 1;
        for (Financiamento f : listaDeFinanciamentos) {
            System.out.printf("\nFinanciamento %d:\n", contador++);
            System.out.printf("  Valor do Imóvel: R$ %.2f\n", f.getValorImovel());
            System.out.printf("  Prazo: %d anos\n", f.getPrazoFinanciamento());
            System.out.printf("  Taxa de Juros: %.2f%%\n", f.getTaxaJurosAnual() * 100);
            System.out.printf("  Pagamento Mensal: R$ %.2f\n", f.calcularPagamentoMensal());
            System.out.printf("  Valor Total do Financiamento: R$ %.2f\n", f.calcularTotalPagamento());


            switch (f) {
                case Casa casa -> {
                    System.out.printf("\nÁrea contruída: %.2f m²\n", casa.getAreaConstruida());
                    System.out.printf("\nTamando do Terreno: %.2f m²\n", casa.getTamanhoTerreno());
                }
                case Apartamento apartamento -> {
                    System.out.printf("\nNúmero de vagas na garagem: %d\n", apartamento.getVagasGaragem());
                    System.out.printf("\nNumero do andar: %d\n", apartamento.getNumeroAndar());
                }
                case Terreno zona -> System.out.printf("\nTipo de zona: %s\n", zona.getTipoZona());
                default -> {
                }
            }
            System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

            totalTodosImoveis += f.getValorImovel();
            totalTodosFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\n--- Totais Gerais ---");
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalTodosImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalTodosFinanciamentos);
    }
}
