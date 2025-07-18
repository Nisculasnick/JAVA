## Simulador de Financiamento Imobiliário
[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)


Este projeto foi desenvolvido como ativiade acadêmica para a disciplina de POO Java da PUCPR

## Funcionalidades

- Cálculo de pagamentos mensais e totais de financiamentos
- Validação de entradas do usuário
- Simulação de múltiplos financiamentos simultaneamente
- Relatório completo com totais consolidados

## Estrutura do Projeto

    projeto
        |--SimuladorFinanciamentoNew
        |--.vscode
        |       |--setting.json
        |--src
        |    |--main
        |    |    |-- Main.java
        |    |--modelo
        |    |    |-- Apartamento.java
        |    |    |-- Casa.java
        |    |    |-- Financiamento.java
        |    |    |-- Terreno.java
        |    |--util
        |    |     |-- AumentoMaiorDoQueJurosException.java
        |    |     |-- InterfaceUsuario.java
        |--README.md
        |--index.html
    
    projeto_old
        |--SimuladorFinancimento.java
        |--test.java

main.java: Classe Principal

Financiamento.java: Lógica de Negócio

InterfaceUsuário.java: Interação com usuário

**Financiamento (modelo)**
* `calcularPagamentoMensal()`: retorna o valor da parcela mensal
* `calcularTotalPagamento()` : Calcula o total do financiamento
* `mostrarDadosBasicos()`: Exibe informações resumidas

**InterfaceUsuario (util)**
* `pediUserValorImovel()`: Solicita o valor de imóvel 4
* `pedirPrazoFinancimento()`: Obtém prazo em ano
* `pedirTaxaJurosAnual()`: Captura taxa de juros

## Contato
Nicolas Paz - nisculasnick@gmail.com

LinkedIn - [Clique Aqui](www.linkedin.com/in/nicolas-paz-a66584306)
