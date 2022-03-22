package message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MessageRepository {

    private JdbcTemplate jdbcTemplate;

    public MessageRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertMessage(Long senderId, Long receiverId, String message) {
        jdbcTemplate.update("INSERT INTO messages (sender_id, receiver_id, message) VALUES (?,?,?)",
                senderId, receiverId, message);
    }

    public List<String> findMessagesBySenderId(Long senderId) {
        return jdbcTemplate.queryForList("SELECT message FROM messages WHERE sender_id = ?",
                String.class,
                senderId);
    }
}
