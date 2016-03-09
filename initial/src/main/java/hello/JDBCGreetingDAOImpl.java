package hello;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCGreetingDAOImpl implements JDBCGreetingDAO{
	 private JdbcTemplate jdbcTemplate;
	 
	    @Autowired
	    public JDBCGreetingDAOImpl(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	public List<Greeting> findMessagesGivenPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<Greeting> findAllMessagesWithMaxPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Greeting greeting) {
		// TODO Auto-generated method stub
		
	}

	public List<Greeting> getAllGreeting() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Greeting> findGreetingById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Greeting> getAllGreetingwithTypeOKOK() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAddress() {
		// TODO Auto-generated method stub
		
	}
}


