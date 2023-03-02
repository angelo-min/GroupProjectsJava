package User;

import Main.Book;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import Exception.InvalidPeriodException;
import Main.House;
import Exception.DateNotAvailableException;

public class User implements Comparable<User> {
    private final UUID id;
    private final String name;

    private final String surname;
    private String email;
    private List<Book> books;


    public User(UUID id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        setEmail(email);
        books = new ArrayList<>();
    }

    //overriding costruttore senza mail (mail viene inizializzata a stringa nulla)
    public User(UUID id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
        setEmail("");
        books = new ArrayList<>();
    }

    public User(String name, String surname, String email){
        id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        setEmail(email);
        books = new ArrayList<>();
    }

    public User(String name, String surname){
        id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        setEmail("");
        books = new ArrayList<>();
    }

    public UUID getUUID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBookingList() {
        return books;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book book(House house, ZonedDateTime startDate, ZonedDateTime endDate) throws InvalidPeriodException {
        if(startDate.isAfter(endDate)) throw new InvalidPeriodException();
       else {
           Book actualBook = new Book(this, startDate, endDate, house);
           Period periodAvailability = Period.between(startDate.toLocalDate(), endDate.toLocalDate());
           try {
               house.addSlot(startDate, periodAvailability);
               books.add(actualBook);
           }catch(DateNotAvailableException e){
               return null;
           }

           return actualBook;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public int compareTo(User u) {
        int compare = surname.compareTo(u.surname);
        if(compare == 0){
            compare = name.compareTo(u.name);
        }
        return compare;
    }
}
