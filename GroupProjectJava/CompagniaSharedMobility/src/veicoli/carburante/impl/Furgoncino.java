package veicoli.carburante.impl;
import enumerations.Patente;
import veicoli.carburante.VeicoloCarburante;

public class Furgoncino extends VeicoloCarburante {
    public Furgoncino(String posizione, boolean inAffitto, float carburanteRimanente, String targa) {
        super(posizione, inAffitto, carburanteRimanente, targa);
        setPatenteRichiesta(Patente.B);
        setTariffaMinuto(1);
    }

    public Furgoncino() {
        super();
        setPatenteRichiesta(Patente.B);
    }

    @Override
    public String toString() {
        return "Furgoncino {" +
                "id=" + getId() +
                ", posizione='" + getPosizione() + '\'' +
                ", tariffaMinuto=" + getTariffaMinuto() +
                "}\n";
    }
}