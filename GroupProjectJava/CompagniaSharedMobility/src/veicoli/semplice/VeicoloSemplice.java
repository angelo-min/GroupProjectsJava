package veicoli.semplice;
import veicoli.Veicolo;

public abstract class VeicoloSemplice extends Veicolo {
    public VeicoloSemplice(String posizione, boolean inAffitto) {
        super(posizione, inAffitto);
    }

    public VeicoloSemplice() {
        super();
    }
}