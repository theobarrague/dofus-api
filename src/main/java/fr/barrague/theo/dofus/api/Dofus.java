package fr.barrague.theo.dofus.api;

public interface Dofus {

    Alliances getLadderedAlliances(Server server);

    Players getLadderedPlayers(Server server);

    enum Server {
        All(0),
        Oto_Mustam(22),
        Agride(36),
        Ombre(50),
        Echo(201),
        Crocabulia(202),
        Rubilax(203),
        Atcham(204),
        Meriana(205),
        Pandore(206),
        Ush(207),
        Julith(208),
        Nidas(209),
        Merkator(210),
        Furye(211),
        Brumen(212),
        Ilyzaelle(222),
        Thanatena(239),
        Jahash(240),
        Temporis_I(251),
        Temporis_II(252);

        private final int server;

        Server(int server) {
            this.server = server;
        }

        public int getServerCode() {
            return this.server;
        }

    }

}
