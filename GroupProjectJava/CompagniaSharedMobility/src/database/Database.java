package database;

public interface Database<K> {
    boolean insert(K element);
    boolean delete(K element);
    boolean delete(Integer index);
    K select(Integer index);
    K select(Object parameter); //IDK mi sembra un po complesso, maybe lo tolgo
    K search(K element);
}
