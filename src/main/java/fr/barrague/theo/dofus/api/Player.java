package fr.barrague.theo.dofus.api;

import fr.barrague.theo.dofus.api.Dofus.Server;

import java.math.BigInteger;

public interface Player {

    int getRank();

    String getName();

    String getType();

    int getLevel();

    Server getServer();

    BigInteger getXp24();

    BigInteger getXp();

}
