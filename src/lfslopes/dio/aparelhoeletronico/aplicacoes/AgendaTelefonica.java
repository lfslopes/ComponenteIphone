package lfslopes.dio.aparelhoeletronico.aplicacoes;

import lfslopes.dio.aparelhoeletronico.exceptions.AplicacaoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AgendaTelefonica implements Aplicacao {
    private boolean aberto;
    private List<String> correiosVoz = new ArrayList<>();

    public void setCorreiosVoz(List<String> correiosVoz) {
        this.correiosVoz = correiosVoz;
    }
    public void setCorreiosVoz(String... correiosVoz) {
        this.correiosVoz.addAll(Arrays.asList(correiosVoz));
    }

    @Override
    public void abrirAplicacao() throws AplicacaoException {
        if (this.aberto)
            throw new AplicacaoException("Aplicação já aberta");
        this.aberto = true;

        System.out.println("Agenda Telefônica aberta. O que deseja fazer?");
        System.out.println("1 - Realizar uma ligação");
        System.out.println("2 - Atender à uma ligação");
        System.out.println("3 - Iniciar correio de voz");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Qual número deseja ligar?");
                this.ligar(scanner.nextLine());
                break;
            case 2:
                System.out.print("Você está recebendo uma ligação? (S/N)");
                String l = scanner.nextLine();
                if (l.equalsIgnoreCase("n"))
                    this.atender(null);
                else {
                    System.out.println("Quem está te ligando?");
                    this.atender(scanner.nextLine());
                }
                break;
            case 3:
                System.out.println("Iniciando correio de voz");
                this.iniciarCorreioVoz();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        this.fecharAplicacao();
    }
    @Override
    public void fecharAplicacao() {
        this.aberto = false;
    }

    public void ligar (String numero) {
        System.out.println("Realizando ligação para " + numero);
    }
    public void atender (String numero) {
        if (numero == null || numero.isEmpty())
            System.out.println("Sem chamadas no momento");
        else {
            System.out.println("Recebendo ligacao de " + numero);
        }
    }
    public void iniciarCorreioVoz () {
        if (this.correiosVoz.isEmpty()){
            System.out.println("Sem chamadas no momento");
            return;
        }
        this.correiosVoz.forEach(System.out::println);
    }

}
