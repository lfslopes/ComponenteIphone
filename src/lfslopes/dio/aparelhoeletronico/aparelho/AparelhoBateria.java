package lfslopes.dio.aparelhoeletronico.aparelho;

public interface AparelhoBateria {
    void ligar();
    void desligar();
    void verificarBateria();
    void recarregarBateria() throws InterruptedException;
}
