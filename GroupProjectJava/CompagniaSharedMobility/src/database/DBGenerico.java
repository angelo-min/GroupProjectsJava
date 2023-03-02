package database;

import java.util.ArrayList;
import java.util.List;

abstract class DBGenerico<K> implements Database<K>{
    private final List<K> lst;
    protected DBGenerico(){
        lst = new ArrayList<>();
    }
    @Override
    public boolean insert(K element) {
        if(element != null)
            return lst.add(element);
        return false;
    }

    @Override
    public boolean delete(K element) {
        if(element == null) {
            return false;
        }
        return lst.remove(element);
    }

    @Override
    public boolean delete(Integer index) {
        if(index>=0 && index<lst.size()) {
            return lst.remove(index.intValue())!=null;
        }
        return false;
    }

    @Override
    public K select(Integer index) {
        return lst.get(index);
    }

    @Override
    public K select(Object parameter) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public K search(K element) {
        for(K v: lst){
            if(element.equals(v)){
                return v;
            }
        }
        return null;
    }
}
