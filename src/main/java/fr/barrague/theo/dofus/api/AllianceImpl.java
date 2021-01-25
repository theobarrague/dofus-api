package fr.barrague.theo.dofus.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.barrague.theo.dofus.api.Dofus.Server;

class AllianceImpl implements Alliance {

    private int rank;
    private String name;
    private Server server;
    private int numberOfGuilds;
    private int players;
    private int villages;
    private int territories;
    private int total;


    public AllianceImpl(int rank, String name, Server server, int numberOfGuilds, int players, int villages, int territories, int total) {
        this.setRank(rank);
        this.setName(name);
        this.setServer(server);
        this.setNumberOfGuilds(numberOfGuilds);
        this.setPlayers(players);
        this.setVillages(villages);
        this.setTerritories(territories);
        this.setTotal(total);
    }

    public int getRank() {
        return rank;
    }

    private void setRank(int rank) {
        if (rank <= 0) throw new IllegalArgumentException("Rank must be greater than 0 ( provided " + rank + " )");
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0)
            throw new IllegalArgumentException("Name must be a not empty string ( provided '" + name + "' )");
        this.name = name;
    }

    public Server getServer() {
        return server;
    }

    private void setServer(Server server) {
        if (server == null) throw new IllegalArgumentException("Server must be non null ( provided null )");
        this.server = server;
    }

    public int getNumberOfGuilds() {
        return numberOfGuilds;
    }

    private void setNumberOfGuilds(int guilds) {
        if (guilds < 0)
            throw new IllegalArgumentException("Guilds must be equal or greater than 0 ( provided " + guilds + " )");
        this.numberOfGuilds = guilds;
    }

    public int getPlayers() {
        return players;
    }

    private void setPlayers(int players) {
        if (players < 0)
            throw new IllegalArgumentException("Players must be equal or greater than 0 ( provided " + players + " )");
        this.players = players;
    }

    public int getVillages() {
        return villages;
    }

    private void setVillages(int villages) {
        if (villages < 0)
            throw new IllegalArgumentException("Villages must be equal or greater than 0 ( provided " + villages + " )");
        this.villages = villages;
    }

    public int getTerritories() {
        return territories;
    }

    private void setTerritories(int territories) {
        if (territories < 0)
            throw new IllegalArgumentException("Territories must be equal or greater than 0 ( provided " + territories + " )");
        this.territories = territories;
    }

    public int getTotal() {
        return total;
    }


    private void setTotal(int total) {
        if (total < 0)
            throw new IllegalArgumentException("Total must be equal or greater than 0 ( provided " + total + " )");
        this.total = total;
    }


    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this);
            return json;
        } catch (Exception e) {
            return "{}";
        }
    }

}
