package Main;

import java.lang.reflect.InvocationTargetException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import Exception.InvalidHostException;
import Exception.InvalidUserException;
import Exception.ImpossibleException;
import Exception.BookNotFoundException;
import User.User;
import User.Host;
import Exception.InvalidPeriodException;
import Exception.NotExistingHouseException;

public class AirBnB {
    private final Set<User> allUsers;
    private final Set<Host> allHosts;
    private static AirBnB airBnb = null;

    private AirBnB(){
        allUsers = new HashSet<>();
        allHosts = new HashSet<>();
    }

    public static AirBnB getInstance() {
        if(airBnb==null){
            airBnb = new AirBnB();
        }
        return airBnb;
    }

    public Set<House> getHostHouses(UUID uuid) throws InvalidHostException {
        for(Host u: allHosts){
            if(u.getUUID().equals(uuid)){
                return new HashSet<>(u.getHouses());
            }
        }
        throw new InvalidHostException();
    }
    public Book getLastBook(UUID uuid) throws BookNotFoundException{
        for(User u: allUsers){
            if(u.getUUID().equals(uuid)){
                List<Book> lst = u.getBookingList();
                return lst.get(lst.size()-1);
            }
        }
        throw new BookNotFoundException();
    }
    public House getMostBookedThisMonth(){
        House out = null;
        int mostBooked = 0;
        for(Host h: allHosts){
            SortedMap<House, SortedSet<Book>> map = h.getBooks();
            for(House house: map.keySet()){
                List<Book> tmp = map.get(house).stream().toList();
                if(mostBooked<map.get(house).size() && tmp.get(tmp.size()-1).getCheckIn().isAfter(ZonedDateTime.now().minusMonths(1))){
                    out = house;
                    mostBooked = map.get(house).size();
                }
            }
        }
        return out;
    }
    public Host getHostOfTheMonth(){
        int bookedQuantity = 0;
        Host out = null;
        for(Host h: allHosts){
            int currBook = 0;
            for(Set<Book> books : h.getBooks().values()){
                for(Book b: books){
                    if(b.getCheckIn().isAfter(ZonedDateTime.now().minusMonths(1))){
                        ++currBook;
                    }
                }
            }
            if(currBook>bookedQuantity){
                bookedQuantity = currBook;
                out = h;
            }
        }
        return out;
    }
    public Set<Host> getSuperHost(){
        Set<Host> out = new HashSet<>();
        for(Host h: allHosts){
            if(h.isSuperhost()){
                out.add(h);
            }
        }
        return out;
    }
    public Set<User> getBestUsers(){
        SortedMap<Integer, List<User>> bestUsers = new TreeMap<>(Comparator.reverseOrder());
        for(User u: allUsers){
            int size = u.getBookingList().size();
            List<User> tmp = new ArrayList<>();
            if(bestUsers.containsKey(size)){
                tmp = bestUsers.get(size);
            }
            tmp.add(u);
            bestUsers.put(size, tmp);
        }
        Set<User> out = new HashSet<>();
        int userCount = 0;
        for(List<User> lst: bestUsers.values()){
            for(User u: lst){
                if(out.add(u)){
                    ++userCount;
                }
                if(userCount>=5){
                    return out;
                }
            }
        }
        return out;
    }
    public double getAverageBeds(){
        int bedQuantity = 0, houseQuantity = 0;
        for(Host h: allHosts){
            for(House house: h.getBooks().keySet()){
                bedQuantity += house.getNbeds();
                ++houseQuantity;
            }
        }
        return ((double)bedQuantity)/((double)houseQuantity);
    }
    public boolean addUser(User user) throws InvalidUserException{
        if(user == null){
            throw new InvalidUserException();
        }
        if(user instanceof Host) {
            allHosts.add((Host) user);
        }
        return allUsers.add(user);
    }

    public boolean deleteUser(User user) throws InvalidUserException {
        if(user == null){
            throw new InvalidUserException();
        }
        if(user instanceof Host){
            allHosts.remove(user);
        }
        return allUsers.remove(user);
    }

    public boolean addHouse(House house, Host host) throws InvalidHostException {
        if(!allHosts.contains(host)){
            throw new InvalidHostException();
        }
        for(Host h: allHosts){
            if(host.equals(h)){
                return h.addHouse(house);
            }
        }
        return false;
    }

    public boolean deleteHouse(House house, Host host) throws InvalidHostException {
        if(!allHosts.contains(host)){
            throw new InvalidHostException();
        }
        for(Host h: allHosts){
            if(host.equals(h)){
                return h.removeHouse(house);
            }
        }
        return false;
    }

    public User changeUAC(User user, Class<? extends User> Class) throws ImpossibleException{
        if(!user.getClass().equals(Class)){
            try {
                User newUser = Class.getConstructor(UUID.class, String.class, String.class, String.class)
                        .newInstance(user.getUUID(), user.getName(), user.getSurname(), user.getEmail());
                deleteUser(user);
                addUser(newUser);
            }catch(NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex){
                return user;
            }catch (InvalidUserException ex){
                //impossible
                throw new ImpossibleException();
            }
        }
        return user;
    }

    public void addFeedback(Book book, Feedback feedback){
        for(Host h: allHosts){
            for(SortedSet<Book> entry: h.getBooks().values()){
                for(Book b: entry){
                    if(book.equals(b)){
                        b.addFeedback(feedback);
                        return;
                    }
                }
            }
        }
    }

    public Book addBook(House house, User user, ZonedDateTime checkIn, ZonedDateTime checkOut) throws InvalidPeriodException, NotExistingHouseException {
        for (Host h : allHosts) {
            List<House> houses = h.getHouses();
            if(houses.contains(house)){
                for (House a : houses) {
                    if(house.equals(a)){
                        Book bookLocal = user.book(a, checkIn, checkOut);
                        h.addBook(a, bookLocal);
                        return bookLocal;
                    }
                }
            }
        }
        throw new NotExistingHouseException();
    }
}
