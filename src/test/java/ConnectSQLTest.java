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
        ResultSet result = jdbcService.execute("select * from book");

        result.next();
        assertThat(result.getString(1), is("1"));
    }
}
