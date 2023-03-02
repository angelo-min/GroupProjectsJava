package User;

import Main.Book;
import Main.House;

import java.util.*;

public class Host extends User{
    private boolean isSuperhost;
    private SortedMap<House, SortedSet<Book>> books;

    //se non viene dato nessun altro parametro viene considerato NON superhost e viene creata la mappa delle prenotazioni
    public Host(UUID id, String name, String surname, String email) {
        super(id, name, surname, email);
        isSuperhost = false;
        books = new TreeMap<House, SortedSet<Book>>();
    }

    public Host(String name, String surname, String email){
        super(name, surname, email);
        isSuperhost = false;
        books = new TreeMap<>();
    }

    public Host(String name, String surname){
        super(name, surname);
        isSuperhost = false;
        books = new TreeMap<>();
    }

    public Host(UUID id, String name, String surname, SortedMap<House, SortedSet<Book>> books){
        super(id, name, surname);
        this.books = books;
        setSuperhost();

    }

    public Host(UUID id, String name, String surname, String email, SortedMap<House, SortedSet<Book>> books){
        super(id, name, surname, email);
        this.books = books;
        setSuperhost();


    }

    private void setSuperhost(){
        if (books.size() > 100) isSuperhost = true;
        else isSuperhost = false;
    }

    public boolean isSuperhost(){
        return isSuperhost;
    }

    public SortedMap<House, SortedSet<Book>> getBooks() {
        return books;
    }

    public void setBooks(SortedMap<House, SortedSet<Book>> books) {
        this.books = books;
    }

    public boolean addHouse(House house) {
        if(!books.containsKey(house)){
            TreeSet<Book> booksLocal = new TreeSet<>();
            books.put(house, booksLocal);
            return true;
        }else return false;

    }

    public boolean removeHouse(House house){
        if(books.containsKey(house)){
            books.remove(house);
            return true;
        }
        return false;

    }

    public void addBook(House house, Book book){
        SortedSet<Book> booksLocal = new TreeSet<>();
        if(books.containsKey(house)){
            booksLocal = books.get(house);
        }
        booksLocal.add(book);
        books.put(house, booksLocal);
        setSuperhost();
    }

    public List<House> getHouses(){
        List<House> houses = new ArrayList<>(books.keySet());
        return houses;
    }

    @Override
    public String toString() {
        return "Host{" +
                "isSuperhost=" + isSuperhost +
                ", houses=" + books.keySet().toString() +
                ", books=" + books.values().toString() +
                '}';
    }

}
