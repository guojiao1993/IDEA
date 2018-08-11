package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    // jdbcTemplate对象 提供了操作数据库的方法
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findOneUser(int id) {
        return jdbcTemplate.queryForObject("select * from user_inf where id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setCreateDate(resultSet.getDate("createdate"));
                user.setLoginname(resultSet.getString("loginname"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getInt("status"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }
        },
        id);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
