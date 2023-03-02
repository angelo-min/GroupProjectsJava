package veicoli.corrente.impl;
import enumerations.Patente;
import veicoli.corrente.VeicoloCorrente;

public class MonopattinoElettrico extends VeicoloCorrente {
    public MonopattinoElettrico(String posizione, boolean inAffitto, float tariffaMinuto, float correnteRimanente) {
        super(posizione, inAffitto, correnteRimanente);
        setPatenteRichiesta(Patente.NESSUNA);
    }

    public MonopattinoElettrico() {
        super();
        setPatenteRichiesta(Patente.NESSUNA);
    }

    @Override
    public String toString() {
        return "MonopattinoElettrico {" +
                "id=" + getId() +
                ", posizione='" + getPosizione() + '\'' +
                ", tariffaMinuto=" + getTariffaMinuto() +
                "}\n";
    }
}
