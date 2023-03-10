package command;

import dto.User;
import repository.UserWriteRepository;

public class UserAggregate {
    private UserWriteRepository writeRepository;
    public UserAggregate(UserWriteRepository repository) {
        this.writeRepository = repository;
    }

    public User handleCreateUserCommand(CreateUserCommand command) {
        User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }

    public User handleUpdateUserCommand(UpdateUserCommand command) {
        User user = writeRepository.getUser(command.getUserId());
        user.getAddresses().addAll(command.getAddresses());
        user.getContacts().addAll(command.getContacts());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }
}
