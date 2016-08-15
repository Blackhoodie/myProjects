import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class MyTableModel extends AbstractTableModel{

	public Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	PersonDao sql = new PersonDaoMySql();
	List<Person> person;
	
	public MyTableModel(){
		person = sql.read();
		fireTableDataChanged();
	}
	
	@Override
	public void addTableModelListener(TableModelListener listener) {
		
		listeners.add(listener);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex)
		{
		case 0:
			return "id";
		case 1:
			return "name";
		case 2:
			return "surname";
		case 3:
			return "age";
		} 
		return " ";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return person.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Person nPerson = person.get(rowIndex);
		switch (columnIndex){
		case 0:
			return nPerson.getId();
		case 1:
			return nPerson.getName();
		case 2:
			return nPerson.getSurname();
		case 3:
			return nPerson.getAge();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener listener) {
		// TODO Auto-generated method stub
		listeners.remove(listener);
		
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	
}
