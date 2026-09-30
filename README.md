# Atividades: Strategy e Iterator

Refatorações das atividades de anti-pattern propostas na disciplina de Design
Patterns (SATC 2026.2), professor Ramon Venson. Enunciados originais e código
de partida em: https://gitlab.com/professor-rvenson/designpatterns-2026-2
(pastas `projetos/strategy-antipattern` e `projetos/iterator-antipattern`).

## strategy/

Refatoração de `projetos/strategy-antipattern`. O código original decidia
desconto, frete e etiqueta do relatório com o mesmo `switch (TipoCliente)`
repetido em três classes.

Solução aplicada:

- `RegraCliente` — interface de estratégia (`calcularDesconto`,
  `calcularFrete`, `getEtiqueta`).
- `RegraClienteComum`, `RegraClienteVip`, `RegraClienteCorporativo` —
  estratégias concretas, uma por tipo de cliente.
- `Pedido` — contexto: guarda a `RegraCliente` atual e delega a ela; permite
  trocar a regra em runtime via `setRegraCliente(...)`.
- `RelatorioPedido` — apenas formata o resultado, sem nenhum `switch`.

Adicionar um novo tipo de cliente agora exige criar **uma única classe**
nova (`implements RegraCliente`); nenhuma classe existente precisa ser
editada.

Rodar:

```bash
cd strategy
javac -d target/classes $(find src -name "*.java")
java -cp target/classes br.venson.net.designpatterns.strategy.Main
```

## iterator/

Refatoração de `projetos/iterator-antipattern`. O código original expunha a
lista interna da playlist via `getFaixas()`, permitindo que `tocarEmbaralhado`
alterasse a ordem da playlist original, e repetia a travessia por índice em
três clientes diferentes.

Solução aplicada:

- `IteradorFaixas` — interface de iterador (`temProxima`/`proxima`).
- `ListaFaixasIterator` — iterador concreto, percorre uma lista já preparada
  (original, embaralhada ou filtrada).
- `Playlist` — agregado: guarda as faixas e cria iteradores
  (`iterador()`, `iteradorEmbaralhado()`, `iteradorFavoritas()`) sem nunca
  devolver a lista interna.
- `Player`, `Recomendador`, `RelatorioPlaylist` — passam a percorrer a
  playlist via iterador, sem laço por índice e sem conhecer a estrutura
  interna.

O shuffle passa a operar sobre uma **cópia** criada dentro do iterador
embaralhado, então a playlist original não é mais alterada.

Rodar:

```bash
cd iterator
javac -d target/classes $(find src -name "*.java")
java -cp target/classes br.venson.net.designpatterns.iterator.Main
```
