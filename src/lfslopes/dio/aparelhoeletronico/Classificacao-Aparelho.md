# Classificação da abstração de um Aparelho

```mermaid
classDiagram
  class Aparelho{
    <<interface>>
    +ligarTela(): void
    +desligarTela(): void
    +desbloquearTela(): void
  }
  class AparelhoBateria{
    <<interface>>
    +ligar(): void
    +desligar(): void
    +verificarBateria(): void
    +recarregarBateria(): void
  }
  class AparelhoEletronico{
    <<abstract>>
    -modelo: String
    -descricao: String
    -bateria: int
    -ligado: boolean
    -telaLigada: boolean
    -desbloqueado: boolean
  }
  Aparelho ..> AparelhoEletronico
  AparelhoBateria ..> AparelhoEletronico
```

