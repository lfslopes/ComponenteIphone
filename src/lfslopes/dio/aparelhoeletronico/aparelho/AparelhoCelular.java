package lfslopes.dio.aparelhoeletronico.aparelho;

import lfslopes.dio.aparelhoeletronico.exceptions.AparelhoException;

import java.util.Scanner;

public class AparelhoCelular extends AparelhoEletronico{
    private String senha;

    private final static String SENHA_PATTERN = "[a-zA-Z0-9.@#$*]{6,20}";
    public AparelhoCelular(String modelo, String descricao) {
        super(modelo, descricao);
        Scanner scanner = new Scanner(System.in);
        char opcao;
        System.out.println("Aparelho sem senha de bloqueio. Definir uma senha? [S/N]");
        opcao = scanner.next().toLowerCase().charAt(0);
        switch (opcao) {
            case 's':
                System.out.print("Digite sua nova senha: ");
                definirSenha(scanner.next());
                break;
            case 'n':
                System.out.println("Certo, prosseguindo");
                break;
            default:
                System.out.println("Opção inválida. Prosseguindo...");
        }
    }
    @Override
    public void aplicacoes() {
        if (!this.isLigado())
            throw new AparelhoException("Celular desligado. Por favor, ligue-o antes de qualquer coisa");
        if (!this.isTelaLigada())
            throw new AparelhoException("Tela desligada, ligue-a para desbloquear o aparelho");
        if (!this.isDesbloqueado())
            throw new AparelhoException("Tela bloqueada, desbloqueie para poder acessar as aplicações");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Você tem acesso a três aplicações no seu celular, selecione uma delas para começar:");
        System.out.println("1 - Reprodutor de Música");
        System.out.println("2 - Agenda Telefônica");
        System.out.println("3 - Navegador de Internet");
        opcao = scanner.nextInt();

    }

    @Override
    public void ligarTela() {
        this.setTelaLigada(true);
    }
    @Override
    public void desligarTela() {
        this.setTelaLigada(false);
    }

    @Override
    public void desbloquearTela() throws AparelhoException {
        if (!this.isLigado())
            throw new AparelhoException("Celular desligado. Por favor, ligue-o antes de desbloquear");
        if (!this.isTelaLigada())
            throw new AparelhoException("Tela desligada, ligue-a para desbloquear o aparelho");
        if (this.isDesbloqueado())
            System.out.println("Telefone já está desbloqueado");
        else {
            if (senha == null)
                this.setDesbloqueado(true);
            else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite sua senha: ");
                String senha = scanner.next();
                if (!this.senha.equals(senha))
                    throw new AparelhoException("Senha incorreta. Por favor, tente novamente");
                this.setDesbloqueado(true);
            }
        }
    }

    @Override
    public void ligar() {
        this.setLigado(true);
    }
    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void verificarBateria() {
        System.out.println("Bateria em " + this.getBateria() + "%.");
    }
    @Override
    public void recarregarBateria() throws InterruptedException {
        this.setBateria(this.getBateria() + 1);
        Thread.sleep(100);
    }

    public void definirSenha(String senha) {
        if (this.senha == null){
            if (senha.matches(SENHA_PATTERN))
                this.senha = senha;
            else
                throw new AparelhoException("Senha inválida. " +
                        "Utilize somente números, dígitos e os caracteres '.', '@', '#', '$', '*'");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite sua senha atual: ");
            String senhaAtual = scanner.next();
            if (this.senha.equals(senhaAtual) && senha.matches(SENHA_PATTERN))
                this.senha = senha;
            else if (!this.senha.equals(senhaAtual))
                throw new AparelhoException("Senha atual incorreta.");
            else
                throw new AparelhoException("Senha inválida. " +
                        "Utilize somente números, dígitos e os caracteres '.', '@', '#', '$', '*'");

        }
    }
}
