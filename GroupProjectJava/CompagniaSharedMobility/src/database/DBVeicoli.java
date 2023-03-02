package database;

import veicoli.Veicolo;

public class DBVeicoli extends DBGenerico<Veicolo>{
    private static DBVeicoli db = null;
    public static DBVeicoli getInstance() {
        if(db==null){
            db = new DBVeicoli();
        }
        return db;
    }
}