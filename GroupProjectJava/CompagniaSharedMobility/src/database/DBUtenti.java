package database;

import Main.Utente;

public class DBUtenti extends DBGenerico<Utente> {
    private static DBUtenti db = null;
    public static DBUtenti getInstance() {
        if(db==null){
            db = new DBUtenti();
        }
        return db;
    }
}
