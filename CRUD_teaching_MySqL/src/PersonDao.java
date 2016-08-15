import java.util.List;


public interface PersonDao {
	
	void create(Person p);
	
	List<Person>read();
	
	void update(int id, Person pnew);
	
	void delete(int id);

}
