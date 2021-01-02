package fr.barrague.theo.dofus.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class AlliancesImpl implements Alliances, Iterable<Alliance> {

    private final List<Alliance> alliances = new ArrayList<>();

    public void addAlliance(AllianceImpl alliance) {
        if (alliance == null) throw new IllegalArgumentException("Alliance must be non null ( provided null )");
        this.alliances.add(alliance);
    }

    public List<Alliance> getAlliances() {
        return Collections.unmodifiableList(this.alliances);
    }

    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this.alliances);
            return json;
        } catch (Exception e) {
            return "[]";
        }
    }

    @Override
    public Iterator<Alliance> iterator() {
        return this.alliances.iterator();
    }
}
