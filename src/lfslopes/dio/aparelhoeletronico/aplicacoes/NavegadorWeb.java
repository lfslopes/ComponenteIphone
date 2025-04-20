package lfslopes.dio.aparelhoeletronico.aplicacoes;

import lfslopes.dio.aparelhoeletronico.exceptions.AplicacaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NavegadorWeb implements Aplicacao{
    private List<String> paginas = new ArrayList<>();
    private int abas = 0;
    private boolean aberto;

    @Override
    public void abrirAplicacao() {
        if (this.aberto)
            throw new AplicacaoException("Página já aberta");
        this.aberto = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Abrindo navegador");
        System.out.print("Qual página deseja acessar: ");
        String url = scanner.nextLine();
        this.exibirPagina(url);
    }

    @Override
    public void fecharAplicacao() {
        this.aberto = false;
    }

    public void exibirPagina(String url) {
        if (url == null)
            throw new AplicacaoException("Sem url para exibir");
        if (!this.paginas.contains(url))
        {
            this.adicionarNovaAba();
            String pagina = paginas.get(abas - 1);
            this.paginas.get(this.abas - 1).replace(pagina, url);
        } else
            atualizarPagina();
        System.out.println("Exibindo " + url);
    }
    public void adicionarNovaAba() {
        this.paginas.add("");
        this.abas++;
    }
    public void atualizarPagina() {
        System.out.println("Atualizando pagina");
    }
}
