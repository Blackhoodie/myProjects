import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.IconView;

import java.awt.*;


public class MainPanel extends JPanel {
	
	JButton addButton;
	JButton readButton;
	JButton updateButton;
	JButton deleteButton;
	JTable personsTable;
	
	JLabel alert;
	
	TableModel model;
	JTable table;
	
	
	//String titles[] = {"id", "name", "surname", "age"};
	
	PersonDaoMySql sql = new PersonDaoMySql();
	
	
	
	
		/**
		 * 
		 */
		MainPanel()
	{
			
			 model = new MyTableModel();
			 table = new JTable(model);
			 add(new JScrollPane(table));

			setPreferredSize(new Dimension (260, 220));
		
		 addButton = new JButton("Добавить");
		 add(addButton);
		 addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id;
				String name;
				String surname;
				int age;
				
				String a1 = (String)JOptionPane.showInputDialog(personsTable, "Выберите id новой персоны", "Добавление персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				String a2 = (String)JOptionPane.showInputDialog(personsTable, "Выберите name новой персоны", "Добавление персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				String a3 = (String)JOptionPane.showInputDialog(personsTable, "Выберите surname новой персоны", "Добавление персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				String a4 = (String)JOptionPane.showInputDialog(personsTable, "Выберите age новой персоны", "Добавление персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				id = Integer.parseInt(a1);
				name = a2;
				surname = a3;
				age = Integer.parseInt(a4);
				Person p = new Person(id, name, surname, age);
				sql.create(p);
			}
		});
		 
		 readButton = new JButton("Считать");
		 add(readButton);
		 
		 readButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				model = new MyTableModel();
				table.setModel(model);
				repaint();
			}
		});
			
		
		 
		 updateButton = new JButton("Изменить");
		 add(updateButton);
		 
		 updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int oldId;
				int newId;
				String newName;
				String newSurname;
				int newAge;
				String upd1 = (String)JOptionPane.showInputDialog(personsTable, "Выберите id персоны для изменения", "Изменение персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");			
				String upd2 = (String)JOptionPane.showInputDialog(personsTable, "Выберите новый id персоны", "Изменение персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				String upd3 = (String)JOptionPane.showInputDialog(personsTable, "Выберите новый name для  персоны", "Изменение персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				String upd4 = (String)JOptionPane.showInputDialog(personsTable, "Выберите новый surname для  персоны", "Изменение персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				String upd5 = (String)JOptionPane.showInputDialog(personsTable, "Выберите age для  персоны", "Изменение персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				
				oldId = Integer.parseInt(upd1);
				newId = Integer.parseInt(upd2);
				newName = upd3;
				newSurname = upd4;
				newAge = Integer.parseInt(upd5);
				
				Person pnew = new Person(newId, newName, newSurname, newAge);
				
				sql.update(oldId, pnew);
			}
		});
		 
		 deleteButton = new JButton("Удалить");
		 add(deleteButton);
		 
		 deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id;
				String s = (String)JOptionPane.showInputDialog(personsTable, "Выберите id для удаление персоны", "Удаление персоны", JOptionPane.PLAIN_MESSAGE, null,null, "");
				id = Integer.parseInt(s);
				sql.delete(id);
				
			}
		});
		
		 
		 
		 
		
		 
		 
		 
					
					
					 
			
		 
	}
	
}
