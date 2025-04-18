package lfslopes.dio.aparelhoeletronico;
import lfslopes.dio.aparelhoeletronico.exceptions.AparelhoException;

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
    protected void desbloquear () throws AparelhoException {
        if (!this.telaLigada)
            throw new AparelhoException("Tela desligada. Ligue-a para desbloquear");
        this.desbloqueado = true;
    }
}
