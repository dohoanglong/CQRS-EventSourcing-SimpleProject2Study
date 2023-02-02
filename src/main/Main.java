package main;

import command.CreateUserCommand;
import command.UpdateUserCommand;
import command.UserAggregate;
import dto.Address;
import dto.Contact;
import projector.UserProjector;
import query.ContactByTypeQuery;
import query.UserProjection;
import repository.UserReadRepository;
import repository.UserWriteRepository;
import service.UserService;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        UserService service = new UserService();
        service.createUser("1", "John", "Zoe");
        service.createUser("2", "Jane", "Moe");
        Address address = new Address();
        address.setCity("New York");
        address.setState("NY");
        Contact contact = new Contact();
        contact.setType("email");
        contact.setDetail("sample@gmail.com");

        Address address1 = new Address();
        address1.setCity("New Mexico");
        address1.setState("NM");
        Contact contact1 = new Contact();
        contact1.setType("phone");
        contact1.setDetail("1234567890");

        Address address2 = new Address();
        address2.setCity("New Jersey");
        address2.setState("NJ");
        Contact contact2 = new Contact();
        contact2.setType("email");
        contact2.setDetail("alo@gmail.com");

        service.updateUser("1", Set.of(address), Set.of(contact));
        service.updateUser("2", Set.of(address1), Set.of(contact1));
        service.updateUser("1", Set.of(address2), Set.of(contact2));

        Set<Contact> contacts = service.getContactByType("1", "email");
        for (Contact c : contacts) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(c.toString());
            }
        }
    }
}
