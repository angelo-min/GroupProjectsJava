package veicoli.carburante;
import veicoli.Veicolo;

import java.util.Objects;

public abstract class VeicoloCarburante extends Veicolo {
    private float carburanteRimanente;
    private String targa;

    public VeicoloCarburante(String posizione, boolean inAffitto, float carburanteRimanente, String targa) {
        super(posizione, inAffitto);
        this.carburanteRimanente = carburanteRimanente;
        this.targa = targa;
    }

    public VeicoloCarburante() {
        super();
    }

    public float getCarburanteRimanente() {
        return carburanteRimanente;
    }

    public void setCarburanteRimanente(float carburanteRimanente) {
        this.carburanteRimanente = carburanteRimanente;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeicoloCarburante that = (VeicoloCarburante) o;
        return Objects.equals(targa, that.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targa);
    }
}