package lfslopes.dio.aparelhoeletronico;

import lfslopes.dio.aparelhoeletronico.aparelho.AparelhoCelular;

public class Main {
    public static void main(String[] args) {
        AparelhoCelular iPhone = new AparelhoCelular("Iphone 1", "Primeiro iPhone da Apple");

        iPhone.ligar();
        iPhone.ligarTela();
        iPhone.desbloquearTela();

        iPhone.aplicacoes();
    }
}
