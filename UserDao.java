package jdbcloginpage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class UserDao {
public void adduser(User user) throws SQLException
{
	String query="insert into users(name,email,username,password,last_login)values(?,?,?,?,?)";
	try(Connection con=DbConnection.getConnection();
		PreparedStatement pt=con.prepareStatement(query))
	{
		pt.setString(1,user.getname());
		pt.setString(2, user.getemail());
		pt.setString(3, user.getusername());
		pt.setString(4, user.getpassword());
		pt.setTimestamp(5,user.getlastlogin());
		pt.executeUpdate();
	}
}
public User getuser(int id) throws SQLException
{
	String query="SELECT*from users where id=?";
	try(Connection con=DbConnection.getConnection();
			PreparedStatement pt=con.prepareStatement(query))
	{
		pt.setInt(1, id);
		ResultSet rs=pt.executeQuery();
		if(rs.next())
		{
			return new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),
					rs.getString("username"),rs.getString("password"),rs.getTimestamp("last_login"));
			
		}
	}
	return null;
}
public List<User> getAllUsers() throws SQLException
{
	List<User> users=new ArrayList<>();
	String query="select *from users";
	try(Connection con=DbConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query))
	{
		while(rs.next())
		{
			users.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("username"),
					rs.getString("password"),rs.getTimestamp("last_login")));
			
		}
	}
	return users;
}
public void updateUser(User user)throws SQLException
{
	String query="update users set name=?,email=?,username=?,password=?,last_login=? where id=?";
	 try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getname());
            statement.setString(2, user.getemail());
            statement.setString(3, user.getusername());
            statement.setString(4, user.getpassword());
            statement.setTimestamp(5, user.getlastlogin());
            statement.setInt(6, user.getid());
            statement.executeUpdate();
        }
}
public void deleteuser(int id)throws SQLException
{
	String query="delete from users where id=?";
	try(Connection con=DbConnection.getConnection();
			PreparedStatement pt=con.prepareStatement(query))
	{
		pt.setInt(1, id);
		pt.executeUpdate();
	}
}
}

