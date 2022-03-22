package message;

public class MessageService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public void registerUser(String username) {
        if (isUsernamePresent(username)) {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
        userRepository.insertUser(username);
    }

    private boolean isUsernamePresent(String username) {
        if (userRepository.findUserByName(username).isPresent()) {
            return true;
        }
        return false;
    }

    public void sendMessage(User sender, User receiver, String message) {
        setUserId(sender);
        setUserId(receiver);
        messageRepository.insertMessage(sender.getId(), receiver.getId(), message);
    }

    private void setUserId(User user) {
        if (user.getId() == null) {
            user.setId(userRepository.findUserByName(user.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("Username is unknown: " + user.getUsername()))
                    .getId());
        }
    }
}
