# dofus-api
```java
  Alliances alliances = dofus.getLadderedAlliances(Server.Nidas);
  System.out.println("Liste du top 100 des alliances sur Nidas :");
  for ( Alliance alliance : alliances ) System.out.println(" " + alliance.getRank() + ". " + alliance.getName());

  Players players = dofus.getLadderedPlayers(Server.Nidas);
  System.out.println("Liste du top 100 des joueurs sur Nidas :");
  for ( Player player : players ) System.out.println(" " + player.getRank() + ". " + player.getName());
```
