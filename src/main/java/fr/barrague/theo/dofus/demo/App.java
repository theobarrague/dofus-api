package fr.barrague.theo.dofus.demo;

import fr.barrague.theo.dofus.api.*;
import fr.barrague.theo.dofus.api.Dofus.Server;

public class App {

    public static void main(String[] args) {
        Dofus dofus = new DofusImpl();

        Alliances alliances = dofus.getLadderedAlliances(Server.Nidas);
        System.out.println("Liste du top 100 des alliances sur Nidas :");
        for ( Alliance alliance : alliances ) System.out.println(" " + alliance.getRank() + ". " + alliance.getName());

        Players players = dofus.getLadderedPlayers(Server.Nidas);
        System.out.println("Liste du top 100 des joueurs sur Nidas :");
        for ( Player player : players ) System.out.println(" " + player.getRank() + ". " + player.getName());

        alliances = dofus.getLadderedAlliances(Server.All);
        System.out.println("Liste du top 100 des alliances :");
        for ( Alliance alliance : alliances ) System.out.println(" " + alliance.getRank() + ". " + alliance.getName());
    }

}
