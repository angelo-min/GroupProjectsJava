package veicoli.corrente;
import veicoli.Veicolo;

public abstract class VeicoloCorrente extends Veicolo {
    private float correnteRimanente;

    public VeicoloCorrente(String posizione, boolean inAffitto, float correnteRimanente) {
        super(posizione, inAffitto);
        this.correnteRimanente = correnteRimanente;
    }

    public VeicoloCorrente() {
        super();
    }

    public float getCorrenteRimanente() {
        return correnteRimanente;
    }

    public void setCorrenteRimanente(float correnteRimanente) {
        this.correnteRimanente = correnteRimanente;
    }
}