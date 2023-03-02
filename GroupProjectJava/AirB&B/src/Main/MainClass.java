package Main;

import User.User;
import User.Host;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Locale;
import Exception.*;

import javax.sound.midi.Soundbank;

public class MainClass {
    public static void main(String[] args) {

        User user1 = new User("Giggino","Rossi","giggino_rossi@gmail.com");
        User user2 = new User("Giggino","Don Perignon","giggino_donperignon@gmail.com");
        User host1 = new Host("Primo","Levi","primolevi@gmail.com");
        User host2 = new Host("Italo","Calvino","italocalvino@gmail.com");

        AirBnB airBnB = AirBnB.getInstance();

        House house1 = new House("Dimora Partenope", 3, 6, 1);

        ZonedDateTime checkIn = ZonedDateTime.of(2021, 9, 20, 0, 0, 0, 0, ZoneId.systemDefault());

        try{
            airBnB.addUser(user1);
            airBnB.addUser(user2);
            airBnB.addUser(host1);
            airBnB.addUser(host2);
            airBnB.addHouse(house1, (Host) host1);
            Book book1 = airBnB.addBook(house1, user1, checkIn, checkIn.plusDays(7));
            System.out.println(book1 != null);
            System.out.println(book1);
            Feedback feedback1 = new Feedback("Buono", "ottimo", 5);
            airBnB.addFeedback(book1, feedback1);
            System.out.println(feedback1);
            System.out.println(book1);
        }catch (InvalidUserException | InvalidHostException | InvalidPeriodException | NotExistingHouseException | InvalidStarsRankingException e) {
            System.out.println(e);
        }



    }
}
