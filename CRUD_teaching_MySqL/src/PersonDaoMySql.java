import java.util.ArrayList;
import java.sql.*;
import java.util.List;


public class PersonDaoMySql implements PersonDao {

	Connection dbConnection = null;
	Statement statement = null;
	
	public void sqlConnect(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Драйвер загружен!");
			
		} catch (ClassNotFoundException e) {
			
			System.out.print(e.getMessage());
		}
		
		
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
			System.out.println("Соеденение с БД установлено");
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		try {
			statement = dbConnection.createStatement();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void create(Person p) {

		sqlConnect();
		
		try {
			statement.execute("INSERT INTO persons(id, name, surname, age) VALUES ("+p.getId()+",\""+p.getName()+
				"\",\""+p.getSurname()+"\","+p.getAge()+")");
			System.out.println("Добавление прошло успешно!!!");
			
			
		} catch (SQLException e) {
			
			System.out.println("Добавление не удалось!");
		}
		
	}

	@Override
	public List<Person>read() {
		
		ArrayList<Person> res = new ArrayList<>();
		
		sqlConnect();
		try {
			ResultSet result1 = statement.executeQuery("SELECT * FROM persons");
			
			//System.out.println("Вывод statement:");
			while(result1.next())
			{
				Person personN = new Person(result1.getInt("id"),result1.getString("name"),result1.getString("surname"),result1.getInt("age"));
				res.add(personN);
				
				
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return res;
		
	}

	@Override
	public void update(int id, Person pnew) {

		sqlConnect();
		try {
			statement.execute("UPDATE persons SET id = "+pnew.getId()+", name = '"+pnew.getName()+"', surname = '"+pnew.getSurname()+"', age = "+pnew.getAge()+" WHERE id = '"+id+"'");
			System.out.println("Update записи прошел успешно!");
			
			
		} catch (SQLException e) {
			
			System.out.println("Изменение не удалось!");
		}
		
	}

	@Override
	public void delete(int id) {
		
			sqlConnect();
			try {
				statement.execute("DELETE FROM persons WHERE id = " + id);
				System.out.println("Удаление прошло успешно!");
				
				
			} catch (SQLException e) {
				
				e.getMessage();
			}
		
	}


		
}
