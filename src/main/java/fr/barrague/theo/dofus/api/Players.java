package fr.barrague.theo.dofus.api;

import java.util.List;

public interface Players extends Iterable<Player> {

    List<Player> getPlayers();

}
