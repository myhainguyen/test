package com.vaadin.scrumban;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.scrumban.model.Account;
import com.vaadin.scrumban.service.AccountService;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;

@Configurable(preConstruction =true)
public class AccountLayout {
	@Autowired
	private AccountService accountService;
	
	private Table scrumTable = new Table();	
	private CssLayout cssContent = new CssLayout();
	private final String ID = "id";
	private final String USERNAME ="user name";
	private final String MAIL = "mail";
	private final String PHONE= "phone";
	private final String STREET ="street";
	private final String POSTALCODE ="postal code";
	private final String CITY ="city";
	private final String COUNTRY="country";

	public AccountLayout(CssLayout css){
		cssContent = css;		
	}
	public void init(){
		createTable();
//		mainWindow.addComponent(cssContent);
	}
	private final String[] visibleColumn = new String[] {ID, USERNAME, MAIL, PHONE,STREET,POSTALCODE,CITY,COUNTRY };
	private final String[] columnHeaders = new String[] {"id","user name", "mail", "phone","street","postal code","city","country" };

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
		cssContent.addComponent( scrumTable );
		
	}

	@SuppressWarnings("unchecked")
	private IndexedContainer getDataSource()
	{
		final IndexedContainer c = new IndexedContainer();
		c.addContainerProperty( ID, Integer.class, null );
		c.addContainerProperty( USERNAME, String.class, null );
		c.addContainerProperty( MAIL, String.class, null );
		c.addContainerProperty( PHONE, String.class, null );
		c.addContainerProperty( STREET, String.class, null );
		c.addContainerProperty( POSTALCODE, String.class, null );
		c.addContainerProperty( CITY, String.class, null );
		c.addContainerProperty( COUNTRY, String.class, null );



		final List<Account> lst = accountService.getAllAccouts();
		if ( lst == null )
		{
			return c;
		}
		int i = 0;
		for (Account acc : lst )
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
			Account a = acc;
			item.getItemProperty(ID).setValue(a.getId());
			item.getItemProperty( USERNAME ).setValue( a.getUserName() );
			item.getItemProperty( MAIL ).setValue( a.getMail() );
			item.getItemProperty( PHONE ).setValue( a.getPhone() );
			item.getItemProperty( STREET ).setValue( a.getStreet() );
			item.getItemProperty( POSTALCODE ).setValue( a.getPostalCode() );
			item.getItemProperty( CITY ).setValue( a.getCity() );
			item.getItemProperty( COUNTRY ).setValue( a.getCountry() );
			i++;
		}
		return c;
	}
}
