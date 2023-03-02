package Main;

import java.util.Objects;
import java.util.UUID;
import Exception.InvalidStarsRankingException;


public class Feedback implements Comparable<Feedback>{

    private final UUID id;
    private final String title;
    private final String text;
    private  int stars;

    public Feedback(String title, String text, int stars) throws InvalidStarsRankingException {
        id = UUID.randomUUID();
        this.title = title;
        this.text = text;
        setStars(stars);
    }

    public Feedback(UUID id,String title, String text, int stars) throws InvalidStarsRankingException {
       this.id = id;
       this.title = title;
       this.text = text;
       setStars(stars);
    }



    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getText() {
        return text;
    }


    public int getStars() {
        return stars;
    }

    private void setStars(int stars) throws InvalidStarsRankingException{
        if (stars <0 || stars>5){
            throw new InvalidStarsRankingException();
        }
        this.stars = stars;
    }

    @Override
    public int compareTo(Feedback f) {
        return id.compareTo(f.getId());
    }


    @Override
    public String toString(){
        return "Feedback{" +
                "id=" + id +
                ", titolo='" + title + '\'' +
                ", testo='" + text + '\'' +
                ", stelle ='" + stars + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}