package fr.barrague.theo.dofus.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.barrague.theo.dofus.api.Dofus.Server;

import java.math.BigInteger;

class PlayerImpl implements Player {

    private int rank;
    private String name;
    private String type;
    private int level;
    private Server server;
    private BigInteger xp24;
    private BigInteger xp;

    public PlayerImpl(int rank, String name, String type, int level, Server server, BigInteger xp24, BigInteger xp) {
        this.setRank(rank);
        this.setName(name);
        this.setType(type);
        this.setLevel(level);
        this.setServer(server);
        this.setXp24(xp24);
        this.setXp(xp);
    }

    public int getRank() {
        return rank;
    }

    private void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public Server getServer() {
        return server;
    }

    private void setServer(Server server) {
        this.server = server;
    }

    public BigInteger getXp24() {
        return xp24;
    }

    private void setXp24(BigInteger xp24) {
        this.xp24 = xp24;
    }

    public BigInteger getXp() {
        return xp;
    }

    private void setXp(BigInteger xp) {
        this.xp = xp;
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
