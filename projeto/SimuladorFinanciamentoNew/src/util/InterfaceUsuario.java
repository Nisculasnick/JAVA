package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    final Scanner scanner;

    public InterfaceUsuario(){
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel(){
        double valor = 0;
        while(valor <=0){
            try {
                System.out.println("Digite um valor (maior que 0): ");
                valor=scanner.nextDouble();
                if(valor<=0){
                    System.out.println("Valor inválido, tente novamente: ");
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada Inválida!");
                scanner.next();
                valor=0;
            }
        }
        return valor;
    }
    public int pedirPrazoFinanciamento(){
        int prazo=0;
        while(prazo<=0){
            try {
                System.out.println("Digite prazo do finaciamento em anos: ");
                prazo = scanner.nextInt();
                if (prazo <= 0) {
                    System.out.println("Valor inválido, tente novamente: ");
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada inválida !");
                scanner.next();
                prazo=0;
            }
        }
        return prazo;
    }

    public double pedirTaxaJurosAnual() {
        double taxa=0;
        while (taxa<=0){
            try {
                System.out.println("Digite taxa de juros anual (em decimal COM VÍRGULA, ex.: 00,5 para 5% ");
                taxa=scanner.nextDouble();
                if (taxa <= 0){
                    System.out.println("A TAXA DEVE SER POSITIVA !");
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada inválida! Por favor, digite um número para a taxa de juros.");
                scanner.next();
                taxa = 0;
            }
        }
        return taxa;
    }

    public double pedirAreaConstruida(){
        double area =0;
        while (area<=0){
            try {
                System.out.print("Digite área (m²): ");
                area = scanner.nextDouble();
                if (area <= 0) {
                    System.out.println("Valor inválido, tente novamente: ");}
            }catch (InputMismatchException e){
                System.out.println("Entrada Inválida !");
                scanner.next();
                area=0;
            }
        }
        return area;
    }
    public double pedirTamanhoTerreno() {
        double terreno = 0;
        while (terreno <= 0) {
            try {
                System.out.println("Digite tamanho do terreno (m²) ");
                terreno = scanner.nextDouble();
                if (terreno <= 0) {
                    System.out.println("Valor inválido! tente novamente: ");
                }
            }catch (InputMismatchException e){
                System.out.print("Entrada Inválida !");
                scanner.next();
                terreno=0;
            }
        }
        return terreno;
    }
}


