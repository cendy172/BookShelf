package integration;

import com.liqing.dto.JDBCService;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectSQLTest {

    private JDBCService jdbcService;

    @Before
    public void setUp() {
        jdbcService = new JDBCService();
    }

    @Test
    public void shouldGetData() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ResultSet result = jdbcService.executeSelect("select * from book");

        result.next();
        assertThat(result.getString(1), is("1"));
    }

    @Test
    public void shouldInsert() throws SQLException {
        jdbcService.executeUpdate("insert into book values(2,'test', 12.00, 'tester')");
        ResultSet resultSet = jdbcService.executeSelect("select count(*) from book");

        resultSet.next();
        assertThat(resultSet.getInt(1), is(2));

        jdbcService.executeUpdate("delete from book where isbn = 2");

    }
}
