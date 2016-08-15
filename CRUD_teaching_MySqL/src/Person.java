
public class Person {
	public int id;
	public String name;
	public String surname;
	public int age;
	
	public Person(int id, String name, String surname, int age){
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
}
