package lfslopes.dio.aparelhoeletronico.aparelho;

public abstract class AparelhoEletronico implements Aparelho, AparelhoBateria {
    private String modelo;
    private String descricao;
    private int bateria;
    private boolean ligado;
    private boolean telaLigada;
    private boolean desbloqueado;

    public AparelhoEletronico(String modelo, String descricao) {
        this.modelo = modelo;
        this.descricao = descricao;
        this.bateria = 100;
        this.ligado = true;
        this.telaLigada = false;
        this.desbloqueado = false;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getBateria() {
        return bateria;
    }
    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
    public boolean isLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    public boolean isTelaLigada() {
        return telaLigada;
    }
    public void setTelaLigada(boolean telaLigada) {
        this.telaLigada = telaLigada;
    }
    public boolean isDesbloqueado() {
        return desbloqueado;
    }
    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public abstract void aplicacoes();
}
