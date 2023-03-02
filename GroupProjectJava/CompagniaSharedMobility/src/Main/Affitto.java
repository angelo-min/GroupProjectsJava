package Main;

import veicoli.Veicolo;
import java.time.LocalDateTime;
import java.util.Objects;

public class Affitto {

    private static int counterId = 0;
    private int id;
    private Utente cliente;
    private Veicolo veicoloAffittato;
    private LocalDateTime dataAffitto;
    private int durata;

    public Affitto(Utente cliente,Veicolo veicoloAffittato,int durata) {
        setId(counterId++);
        setCliente(cliente);
        setDataAffitto();
        setVeicoloAffittato(veicoloAffittato);
    }

    /****** GETTERS AND SETTERS ******/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getCliente() {
        return cliente;
    }

    public void setCliente(Utente cliente) {
        this.cliente = cliente;
    }

    public Veicolo getVeicoloAffittato() {
        return veicoloAffittato;
    }

    public void setVeicoloAffittato(Veicolo veicoloAffittato) {
        this.veicoloAffittato = veicoloAffittato;
    }

    public LocalDateTime getDataAffitto() {
        return dataAffitto;
    }

    public void setDataAffitto() {
        this.dataAffitto = LocalDateTime.now();
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    /****** OVERRIDE EQUALS E HASHCODE ******/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affitto affitto = (Affitto) o;
        return durata == affitto.durata
                && Objects.equals(cliente, affitto.cliente)
                && Objects.equals(veicoloAffittato, affitto.veicoloAffittato)
                && Objects.equals(dataAffitto, affitto.dataAffitto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, veicoloAffittato, dataAffitto, durata);
    }

}