package message;

public class Message {

    private Long id;
    private Long senderId;
    private Long receiverId;
    private String message;

    public Message(Long senderId, Long receiverId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
    }

    public Message(Long id, Long senderId, Long receiverId, String message) {
        this(senderId, receiverId, message);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public String getMessage() {
        return message;
    }
}
