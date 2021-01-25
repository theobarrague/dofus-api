package fr.barrague.theo.dofus.demo;

import fr.barrague.theo.dofus.api.Alliance;
import fr.barrague.theo.dofus.api.Alliances;
import fr.barrague.theo.dofus.api.Dofus;
import fr.barrague.theo.dofus.api.Dofus.Server;
import fr.barrague.theo.dofus.api.DofusImpl;

import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Dofus dofus = new DofusImpl();

//        Alliances alliances = dofus.getLadderedAlliances(Server.Nidas);
//        System.out.println("Liste du top 100 des alliances sur Nidas :");
//        for ( Alliance alliance : alliances ) System.out.println(" " + alliance.getRank() + ". " + alliance.getName());
//
//        Players players = dofus.getLadderedPlayers(Server.Nidas);
//        System.out.println("Liste du top 100 des joueurs sur Nidas :");
//        for ( Player player : players ) System.out.println(" " + player.getRank() + ". " + player.getName());


        Alliances alliances = dofus.getLadderedAlliances(Server.Nidas);
        List<Alliance> allianceFiltered =  alliances.getAlliances().stream().filter(alliance -> alliance.getPlayers() >= 500).collect(Collectors.toList());
        for (Alliance alliance : allianceFiltered)
            System.out.println(alliance);
    }

}
