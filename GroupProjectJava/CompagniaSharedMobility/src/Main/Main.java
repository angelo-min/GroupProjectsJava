package Main;

import enumerations.Patente;
import veicoli.Veicolo;
import veicoli.carburante.impl.Automobile;
import veicoli.carburante.impl.Furgoncino;
import veicoli.carburante.impl.MotoScooter;
import veicoli.corrente.impl.MonopattinoElettrico;
import veicoli.semplice.impl.Bicicletta;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompagniaSharedMobility csm = new CompagniaSharedMobility("Viale Regina Margherita");

        // Aggiungo 7 veicoli alla compagnia
        csm.getVeicoliCompagnia().add(new Automobile("0,0", false,1,"F0920K"));
        csm.getVeicoliCompagnia().add(new Automobile("0,0", true,1,"F092A20K")); // Automobile con id = 1 in affitto
        csm.getVeicoliCompagnia().add(new Bicicletta("0,0", false));
        csm.getVeicoliCompagnia().add(new Furgoncino("0,0", false,1,"Q0A2120K"));
        csm.getVeicoliCompagnia().add(new MotoScooter("0,0", false,10,"Q0A2120K"));
        csm.getVeicoliCompagnia().add(new MonopattinoElettrico("0,0", false,1,10));
        csm.getVeicoliCompagnia().add(new Bicicletta("0,0", false));

        System.out.println(csm.getVeicoliDisponibili().get(0).getPatenteRichiesta());

        System.out.println("\nTEST DISPONIBILITA' VEICOLI");
        List<Veicolo> veicoli = csm.getVeicoliDisponibili();
        System.out.println(veicoli.size() == 6); // Devono esserci 6 veicoli liberi su 7 totali
        System.out.println(csm.getVeicoliDisponibili().toString());

        System.out.println("\nTEST REGISTRAZIONE UTENTE");
        Utente pippoBaudo = new Utente("Pippo", "Baudo","PPBD23DWKODWH23FDW","01/01/2000", true, new Patente[]{Patente.B});
        csm.registrazioneNuovoUtente(pippoBaudo);
        System.out.println(csm.getUtentiRegistrati().size() == 1); // Deve esserce un utente registrato
        //System.out.println(csm.getUtentiRegistrati().toString()); //TODO implementare ToString Utente

        System.out.println("\nTEST REGISTRAZIONE UTENTE GIA' REGISTRATO");
        csm.registrazioneNuovoUtente(pippoBaudo);
        System.out.println(csm.getUtentiRegistrati().size() == 1);

        System.out.println("\nTEST CREDITO NON SUFFICIENTE");
        csm.affittaVeicolo(new Automobile(), pippoBaudo, 10); // Test credito non sufficiente
        System.out.println(csm.getAffittiInCorso().size() == 0); // Test non inserimento affitto

        System.out.println("\nTEST AFFITTO VEICOLO");
        pippoBaudo.ricaricaCredito(1000);
        int idAffitto = csm.affittaVeicolo(new Automobile(), pippoBaudo, 10); // Test credito sufficiente
        System.out.println(csm.getAffittiInCorso().size() == 1);
        //System.out.println(csm.getAffitti().toString());
        System.out.println(pippoBaudo.getCredito()==990);

        System.out.println("\nTEST RESTITUISCI VEICOLO SUCCESSO");
        csm.restituisciVeicolo(idAffitto);
        System.out.println(csm.getAffittiInCorso().size() == 0);

        System.out.println("\nTEST RESTITUISCI VEICOLO FALLIMENTO");
        csm.restituisciVeicolo(100);
    }
}
