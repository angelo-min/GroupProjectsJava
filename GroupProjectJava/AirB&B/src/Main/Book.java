package Main;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import User.User;


public class Book implements Comparable<Book> {

    private final UUID id;
    private ZonedDateTime checkIn;
    private ZonedDateTime checkOut;
    private House house;
    private User user;
    private Feedback feedback;

    public Book(User user, ZonedDateTime checkIn, ZonedDateTime checkOut, House house) {
        id = UUID.randomUUID();
        setUser(user);
        setCheckIn(checkIn);
        setCheckOut(checkOut);
        setHouse(house);
        feedback = null;
    }


    public void addFeedback(Feedback feedback) {
        this.feedback = feedback;
    }


    //Getter and Setter
    public UUID getUUID() { return id; }

    public ZonedDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(ZonedDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public ZonedDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(ZonedDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feedback getFeedback() {
        return feedback;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }


    @Override
    public String toString(){
       return "Prenotazione{" +
                "id=" + id +
                ", check in='" + checkIn + '\'' +
                ", check out='" + checkOut + '\'' +
                ", nome utente prenotazione ='" + user.getName() + '\'' +
               ", id utente prenotazione ='" + user.getUUID() + '\'' +
               ", titolo feedback ='" + (feedback == null ? "" : feedback.getTitle()) + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Book b) {
        return id.compareTo(b.getUUID());
    }

}
