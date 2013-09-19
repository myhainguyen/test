package com.vaadin.scrumban;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.scrumban.model.Employee;
import com.vaadin.scrumban.service.EmployeeService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.TextField;

@Configurable(preConstruction =true)
public class EmployeeLayout {
	@Autowired
	private EmployeeService employeeService;
	
	private Table scrumTable = new Table();
	private CssLayout mainWindow ;
	private CssLayout cssContent = new CssLayout();
	private CssLayout cssAdd = new CssLayout();
	private final String ID = "id";
	private final String FIRSTNAME = "firstname";
	private final String LASTNAME = "lastname";
	private final String AGE = "age";
	private final String DELETE ="delete";
	public EmployeeLayout(CssLayout vrlayout){
		this.mainWindow = vrlayout;
		mainWindow.removeAllComponents();
		mainWindow.setSizeFull();
		mainWindow.setWidth("500px");
		
	}
	public void init(){
		CreateAddEmployee();
		createTable();
		mainWindow.addComponent(cssAdd);
		mainWindow.addComponent(cssContent);
	}
	
	private final String[] visibleColumn = new String[] {ID, FIRSTNAME, LASTNAME, AGE,DELETE };
	private final String[] columnHeaders = new String[] {"id","Fist name", "Last name", "age","" };

	private void createTable()
	{
		cssContent.removeAllComponents();
		cssContent.setSizeFull();
		cssContent.setWidth("500px");	
		cssContent.setStyleName("cssContent");
		scrumTable.removeAllItems();
		scrumTable.setSizeFull();
		scrumTable.setWidth( "500px" );
		scrumTable.setStyleName( "scrumtable" );
		scrumTable.setColumnCollapsingAllowed( true );
		scrumTable.setColumnReorderingAllowed( true );
		scrumTable.setContainerDataSource( getDataSource() );

		scrumTable.setVisibleColumns( visibleColumn );
		scrumTable.setColumnHeaders( columnHeaders );
		scrumTable.setImmediate(true);
		createGenColumn();
		cssContent.addComponent( scrumTable );
		mainWindow.addComponent(cssContent);
		
		
	}

	@SuppressWarnings("unchecked")
	private IndexedContainer getDataSource()
	{
		final IndexedContainer c = new IndexedContainer();
		c.addContainerProperty( ID, Integer.class, null );
		c.addContainerProperty( FIRSTNAME, String.class, null );
		c.addContainerProperty( LASTNAME, String.class, null );
		c.addContainerProperty( AGE, String.class, null );
		c.addContainerProperty( DELETE, Employee.class, null );

		final List<Employee> lstEmp = employeeService.getAllEmployees();
		if ( lstEmp == null )
		{
			return c;
		}
		int i = 0;
		for (Employee emp : lstEmp )
		{
			Item item;
			if ( c.getItem( i ) == null )
			{
				item = c.addItem( i );
			}
			else
			{
				item = c.addItem( i );
			}
			Employee e = emp;
			item.getItemProperty(ID).setValue(e.getId());
			item.getItemProperty( FIRSTNAME ).setValue( e.getFirstname() );
			item.getItemProperty( LASTNAME ).setValue( e.getLastname() );
			item.getItemProperty( AGE ).setValue( e.getAge() );
			item.getItemProperty( DELETE ).setValue( e );
			i++;
		}
		return c;
	}
	private void createGenColumn(){
		scrumTable.addGeneratedColumn(DELETE, new ColumnGenerator() {
			
			public Object generateCell(Table source, Object itemId, Object columnId) {
				if (DELETE.equals(columnId)) {
					final Item itemdown = scrumTable.getItem(itemId);
					final Employee data = (Employee) itemdown.getItemProperty(DELETE)
							.getValue();
					Button btnDelete = new Button("Delete");
					btnDelete.setImmediate(true);
					btnDelete.addClickListener(new ClickListener() {
						
						public void buttonClick(ClickEvent event) {
							employeeService.deleteEmployee(data.getId());
							scrumTable.setContainerDataSource( getDataSource() );
							
						}
					});
					return btnDelete;
				}
				return null;
			}
		});
	}
	private void CreateAddEmployee(){
		cssAdd.removeAllComponents();
		cssAdd.setSizeFull();
		cssAdd.setWidth("200px");
		cssAdd.setStyleName("cssAdd");
		final TextField txtFistName = new TextField();
		txtFistName.setImmediate(true);
		txtFistName.setInputPrompt("First name");
		
		final TextField txtLastName = new TextField();
		txtLastName.setImmediate(true);
		txtLastName.setInputPrompt("Last name");
		
		final TextField txtAge = new TextField();
		txtAge.setImmediate(true);
		txtAge.setInputPrompt("Age");
		
		Button btnSubmit = new Button("Add Employee");
		btnSubmit.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				Employee e = new Employee();
				e.setFirstname(txtFistName.getValue());
				e.setLastname(txtLastName.getValue());
				e.setAge(txtAge.getValue());
				
				employeeService.insertEmployee(e);
				scrumTable.setContainerDataSource( getDataSource() );
				
				
			}
		});
		cssAdd.addComponent(txtFistName);
		cssAdd.addComponent(txtLastName);
		cssAdd.addComponent(txtAge);
		cssAdd.addComponent(btnSubmit);
		
	}

	
}
