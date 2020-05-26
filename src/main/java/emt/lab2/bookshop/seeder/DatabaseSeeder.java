package emt.lab2.bookshop.seeder;

import emt.lab2.bookshop.model.StoreUser;
import emt.lab2.bookshop.repository.UserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder {

    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;

    public DatabaseSeeder(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    private void seedUsersTable() {
        String sql = "SELECT TOP 1 * FROM store_user U WHERE U.username = 'test-user'";
        List<StoreUser> userQuery = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if(userQuery.size() <= 0) {
            StoreUser user = new StoreUser();
            user.setUsername("test-user");
            user.setPassword("test123");
            userRepository.save(user);
        }
    }
}
