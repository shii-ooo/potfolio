package portfolio;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository 
public class TopicRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public TopicRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findAll() {
        String sql = "SELECT title , content , created_at FROM topics ORDER BY created_at DESC LIMIT 3;";
        return jdbcTemplate.queryForList(sql);
    }
}
