package database;

import Main.Affitto;

public class DBAffitti extends DBGenerico<Affitto>{
    private static DBAffitti db = null;
    public static DBAffitti getInstance() {
        if(db==null){
            db = new DBAffitti();
        }
        return db;
    }
}
