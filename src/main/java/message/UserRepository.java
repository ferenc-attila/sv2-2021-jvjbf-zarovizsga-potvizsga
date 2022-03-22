package message;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long insertUser(String username) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, username);
            return statement;
        }, holder);
        return getKeyHolder(holder);
    }

    private Long getKeyHolder(KeyHolder holder) {
        try {
            return holder.getKey().longValue();
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot insert!");
        }
    }

    public Optional<User> findUserByName (String username) {
            Optional<User> optionalUser = Optional.empty();
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?",
                    (rs, rowNum) -> new User(
                            rs.getLong("id"),
                            rs.getString("username")
                    ), username));
        } catch (DataAccessException dae) {
            return optionalUser;
        }
    }
}
