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
    protected boolean desbloquearCheck (){
        return this.telaLigada;
    }
}
