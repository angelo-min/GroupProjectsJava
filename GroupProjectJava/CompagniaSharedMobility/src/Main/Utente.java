package Main;
import enumerations.Patente;
import java.util.Objects;

public class Utente  {
    private static int counterId = 0;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String codiceFiscale;
    private int id;
    private float credito;
    private boolean posiedeCasco;
    private Patente[] patenti;

    public Utente(String nome, String cognome, String codiceFiscale, String dataNascita, boolean possiedeCasco, Patente[] patenti){
        this.id = counterId++;
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
        this.credito = 0;
        this.posiedeCasco = possiedeCasco;
        this.patenti = patenti;
    }

    public boolean ricaricaCredito(float credito){
        if(credito < 0)
            return false;
        this.credito += credito;
        return true;
    }


    /****** GETTERS AND SETTERS ******/
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCognome() {
        return cognome;
    }


    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public String getDataNascita() {
        return dataNascita;
    }


    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }


    public String getCodiceFiscale() {
        return codiceFiscale;
    }


    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public float getCredito() {
        return credito;
    }


    public void setCredito(float credito) {
        this.credito = credito;
    }



    public boolean isPosiediCasco() {
        return posiedeCasco;
    }


    public void setPosiediCasco(boolean posiediCasco) {
        this.posiedeCasco = posiediCasco;
    }

    public Patente[] getPatenti() {
        return patenti;
    }

    public void setPatenti(Patente[] patenti) {
        this.patenti = patenti;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(codiceFiscale, utente.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceFiscale);
    }
}

