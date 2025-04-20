package lfslopes.dio.aparelhoeletronico.aplicacoes;

import lfslopes.dio.aparelhoeletronico.exceptions.AplicacaoException;

import java.util.Scanner;

public class ReprodutorMusical implements Aplicacao {
    private boolean aberto;
    private boolean tocando;
    private String musica;

    @Override
    public void abrirAplicacao() throws AplicacaoException {
        if (aberto)
            throw new AplicacaoException("Aplicação já está aberta");
        aberto = true;

        System.out.println("Aplicativo de reprodução de músicas está aberto. Deseja selecionar uma música para tocar");
        Scanner scanner = new Scanner(System.in);
        selecionarMusica(scanner.nextLine());

        System.out.println("Deseja continuar ouvindo música? (S/N)");
        String continuar = scanner.nextLine();
        while (continuar.equalsIgnoreCase("s")) {
            System.out.print("Qual será a próxima faixa: ");
            selecionarMusica(scanner.nextLine());
            System.out.println("Deseja continuar? (S/N)");
            continuar = scanner.nextLine();
        }
        this.pausar();
        this.fecharAplicacao();
    }

    @Override
    public void fecharAplicacao() {
        if (this.aberto)
            this.aberto = false;
    }

    public void tocar(){
        this.tocando = true;
    }
    public void pausar(){
        this.tocando = false;
    }
    public void selecionarMusica (String musica) {
        this.musica = musica;
        this.tocar();
        System.out.println("Reproduzindo a faixa " + this.musica);
    }
}
