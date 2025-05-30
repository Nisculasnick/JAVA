package util;

import java.util.Scanner;

public class InterfaceUsuario {
    final Scanner scanner;

    public InterfaceUsuario(){
        scanner = new Scanner(System.in);
    }
    public double pedirValorImovel(){
        double valor = -1;
        while(valor <=0){
            System.out.println("Digite um valor (maior que 0): ");
            valor=scanner.nextDouble();
            if(valor<=0){
                System.out.println("Valor inválido, tente novamente: ");
            }
        }
        return valor;
    }
    public int pedirPrazoFinanciamento(){
        int prazo=-1;
        while(prazo<=0){
            System.out.print("Digite prazo do finaciamento em anos: ");
            prazo=scanner.nextInt();
        if (prazo<=0){
            System.out.println("Valor inválido, tente novamente: ");
        }
        }
        return prazo;
    }
    public double pedirTaxaJurosAnual(){
        double taxa=-1;
        while(taxa<=0){
        System.out.print("Digite taxa de juros anual (em decimal, ex.: 0.05 para 5%): ");
        taxa=scanner.nextDouble();
        if (taxa<=0){
            System.out.println("Valor inválido, tente novamente: ");
        }    
        }
        return taxa;
    }
}

