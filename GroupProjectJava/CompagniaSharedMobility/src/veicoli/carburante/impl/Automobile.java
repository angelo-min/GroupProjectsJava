package veicoli.carburante.impl;
import enumerations.Patente;
import veicoli.carburante.VeicoloCarburante;

public class Automobile extends VeicoloCarburante {
    public Automobile(String posizione, boolean inAffitto, float carburanteRimanente, String targa) {
        super(posizione, inAffitto, carburanteRimanente, targa);
        setPatenteRichiesta(Patente.B);
    }

    public Automobile() {
        super();
        setPatenteRichiesta(Patente.B);
        setTariffaMinuto(1);
    }

    @Override
    public String toString() {
        return "Automobile {" +
                "id=" + getId() +
                ", posizione='" + getPosizione() + '\'' +
                ", tariffaMinuto=" + getTariffaMinuto() +
                "}\n";
    }
}