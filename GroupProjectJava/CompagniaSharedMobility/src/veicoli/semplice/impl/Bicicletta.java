package veicoli.semplice.impl;
import enumerations.Patente;
import veicoli.semplice.VeicoloSemplice;

public class Bicicletta extends VeicoloSemplice {
    public Bicicletta(String posizione, boolean inAffitto) {
        super(posizione, inAffitto);
        setPatenteRichiesta(Patente.NESSUNA);
    }

    public Bicicletta() {
        super();
        setPatenteRichiesta(Patente.NESSUNA);
    }

    @Override
    public String toString() {
        return "Bicicletta {" +
                "id=" + getId() +
                ", posizione='" + getPosizione() + '\'' +
                ", tariffaMinuto=" + getTariffaMinuto() +
                "}\n";
    }
}
