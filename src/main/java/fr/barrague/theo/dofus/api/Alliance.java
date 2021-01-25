package fr.barrague.theo.dofus.api;

import fr.barrague.theo.dofus.api.Dofus.Server;

public interface Alliance {

    int getRank();

    String getName();

    Server getServer();

    int getNumberOfGuilds();

    int getPlayers();

    int getVillages();

    int getTerritories();

    int getTotal();
}
