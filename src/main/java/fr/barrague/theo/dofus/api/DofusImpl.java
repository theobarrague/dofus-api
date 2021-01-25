package fr.barrague.theo.dofus.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigInteger;

public class DofusImpl implements Dofus {

    private static final String ALLIANCES_URL = "https://www.dofus.com/fr/mmorpg/communaute/ladder/alliances";
    private static final String PLAYERS_URL = "https://www.dofus.com/fr/mmorpg/communaute/ladder/general";

    public Alliances getLadderedAlliances(Server server) {
        try {
            String url;
            if (server == Server.All) url = ALLIANCES_URL;
            else url = ALLIANCES_URL + "?servers=" + server.getServerCode() + "&search=#jt_list";

            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select(".ak-name");
            AlliancesImpl alliances = new AlliancesImpl();
            for (Element element : elements) {
                Element parent = element.parent();

                int rank = this.getInt(parent.children().get(0));
                String name = this.getString(parent.children().get(1));
                Server serv = this.getServer(parent.children().get(2));
                int numberOfGuilds = this.getInt(parent.children().get(3));
                int players = this.getInt(parent.children().get(4));
                int villages = this.getInt(parent.children().get(5));
                int territories = this.getInt(parent.children().get(6));
                int total = this.getInt(parent.children().get(7));

                AllianceImpl alliance = new AllianceImpl(rank, name, serv, numberOfGuilds, players, villages, territories, total);
                alliances.addAlliance(alliance);

            }
            return alliances;
        } catch (Exception e) {
            System.err.println(e);
            return new AlliancesImpl();
        }
    }

    public Players getLadderedPlayers(Server server) {
        try {
            String url;
            if (server == Server.All) url = PLAYERS_URL;
            else url = PLAYERS_URL + "?servers=" + server.getServerCode();

            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select(".ak-name");
            PlayersImpl players = new PlayersImpl();
            for (Element element : elements) {
                Element parent = element.parent();

                int rank = this.getInt(parent.children().get(0));
                String name = this.getString(parent.children().get(1));
                String type = this.getString(parent.children().get(2));
                int level = this.getLevel(parent.children().get(3));
                Server serv = this.getServer(parent.children().get(4));
                BigInteger xp24 = this.getBigInteger(parent.children().get(5));
                BigInteger xp = this.getBigInteger(parent.children().get(6));

                PlayerImpl player = new PlayerImpl(rank, name, type, level, serv, xp24, xp);
                players.addPlayer(player);
            }
            return players;
        } catch (Exception e) {
            System.err.println(e);
            return new PlayersImpl();
        }
    }

    private int getInt(Element element) {
        return Integer.parseInt(element.text().replaceAll(" ", ""));
    }

    private String getString(Element element) {
        return element.text();
    }

    private int getLevel(Element element) {
        return Integer.parseInt(element.text().replaceAll("([ ]|Omega )", ""));
    }

    private BigInteger getBigInteger(Element element) {
        return new BigInteger(element.text().replaceAll(" ", ""));
    }

    private Server getServer(Element element) {
        return Server.valueOf(element.text().replaceAll("[ -]", "_"));
    }

}
