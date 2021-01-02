package fr.barrague.theo.dofus.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class PlayersImpl implements Players {

    private final List<Player> players = new ArrayList<>();

    public void addPlayer(PlayerImpl player) {
        if (player == null) throw new IllegalArgumentException("Player must be non null ( provided null )");
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this.players);
            return json;
        } catch (Exception e) {
            return "[]";
        }
    }

    @Override
    public Iterator<Player> iterator() {
        return this.players.iterator();
    }

}
