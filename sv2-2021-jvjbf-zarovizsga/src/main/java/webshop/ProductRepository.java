package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        String sql = "INSERT INTO products(product_name, price, stock) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, productName);
                    ps.setLong(2, price);
                    ps.setLong(3, stock);
                    return ps;
                }, keyHolder
        );
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public Product findProductById(long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, getProductRowMapper(), id);
    }

    public void updateProductStock(long id, int amount) {
        String sql = "UPDATE products SET stock = stock - ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    private RowMapper<Product> getProductRowMapper() {
        return (rs, rowNum) -> new Product(
                rs.getLong("id"),
                rs.getString("product_name"),
                rs.getLong("price"),
                rs.getLong("stock"));
    }
}
