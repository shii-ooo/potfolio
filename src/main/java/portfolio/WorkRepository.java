
package portfolio;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkRepository { // SQLを実行してDBから取り出す

    private final JdbcTemplate jdbcTemplate;

    public WorkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findAll() {
        String sql = "SELECT id, title, description, github_url FROM works LIMIT 3";

        return jdbcTemplate.queryForList(sql);

    }

    public int saveImage(String title, String imagePath) throws java.io.IOException {

        String sql = """
                INSERT INTO works (title, image_data, image_type)
                VALUES (?, ?, ?)
                """;

        byte[] imageBytes = java.nio.file.Files.readAllBytes(
                java.nio.file.Path.of(imagePath));

        return jdbcTemplate.update(
                sql,
                title,
                imageBytes,
                "image/png");
    }

    public Map<String, Object> findImageById(int id) {
        String sql = """
                SELECT image_data, image_type
                FROM works
                WHERE id = ?
                """;

        return jdbcTemplate.queryForMap(sql, id);
    }
}

// Spring Bootでは、URLとメソッドをアノテーションで登録しておけば、
// Spring Bootがリクエストを受け取ったときに適切なメソッドを呼び出してくれる

// @GetMapping で実行条件を登録しておき、
// Spring Bootがその条件に合うリクエストを受け取ったときに、メソッドを呼び出している。