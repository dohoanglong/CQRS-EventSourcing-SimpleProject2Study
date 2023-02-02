package service;

import command.CreateUserCommand;
import command.UpdateUserCommand;
import command.UserAggregate;
import dto.Address;
import dto.Contact;
import dto.User;
import projector.UserProjector;
import query.AddressByRegionQuery;
import query.ContactByTypeQuery;
import query.UserProjection;
import repository.UserReadRepository;
import repository.UserWriteRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class UserService {
    private final UserWriteRepository writeRepository = new UserWriteRepository();
    private final UserReadRepository readRepository = new UserReadRepository();
    private final UserProjector projector = new UserProjector(readRepository);


    public void createUser(String userId, String firstName, String lastName) {
        CreateUserCommand createUserCommand = new CreateUserCommand(userId, firstName, lastName);

        UserAggregate aggregate = new UserAggregate(writeRepository);
        User user = aggregate.handleCreateUserCommand(createUserCommand);
        projector.project(user);
    }

    public void updateUser(String userId, Set<Address> addresses, Set<Contact> contacts) {
        UpdateUserCommand updateUserCommand = new UpdateUserCommand(userId, addresses, contacts);
        UserAggregate aggregate = new UserAggregate(writeRepository);
        User user = aggregate.handleUpdateUserCommand(updateUserCommand);
        projector.project(user);
    }

    public Set<Contact> getContactByType(String userId, String contactType) {
        ContactByTypeQuery contactByTypeQuery = new ContactByTypeQuery(userId, contactType);
        UserProjection userProjection = new UserProjection(readRepository);

        return userProjection.handle(contactByTypeQuery);
    }

    public Set<Address> getAddressByRegion(String userId, String state) {
        AddressByRegionQuery addressByRegionQuery = new AddressByRegionQuery(userId, state);
        UserProjection userProjection = new UserProjection(readRepository);

        return userProjection.handle(addressByRegionQuery);
    }
}
