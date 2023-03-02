package veicoli.carburante.impl;
import enumerations.Patente;
import veicoli.carburante.VeicoloCarburante;

public class MotoScooter extends VeicoloCarburante {
    public MotoScooter(String posizione, boolean inAffitto, float carburanteRimanente, String targa) {
        super(posizione, inAffitto, carburanteRimanente, targa);
        setPatenteRichiesta(Patente.B);
        setTariffaMinuto(1);
    }

    public MotoScooter() {
        super();
        setPatenteRichiesta(Patente.B);
    }

    @Override
    public String toString() {
        return "MotoScooter {" +
                "id=" + getId() +
                ", posizione='" + getPosizione() + '\'' +
                ", tariffaMinuto=" + getTariffaMinuto() +
                "}\n";
    }
}
