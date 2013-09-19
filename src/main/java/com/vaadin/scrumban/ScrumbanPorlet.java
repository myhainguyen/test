package com.vaadin.scrumban;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings( "serial" )
public class ScrumbanPorlet  extends UI 
{

	
	private VerticalLayout  mainWindow ;
	private CssLayout cssContent;
	private EmployeeLayout empLayout;
	private AccountLayout accLayout;
//	@WebServlet(value = "/*", asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = ScrumbanPorlet.class)
//	public static class Servlet extends VaadinServlet {
//	}

	
	@Override
	protected void init(VaadinRequest request) {
		mainWindow = new VerticalLayout();
		mainWindow.setMargin(true);		
		cssContent = new CssLayout();
		cssContent.setSizeFull();
		cssContent.setWidth("500px");
		setContent(mainWindow);

		Button button = new Button("Load Employee");
		button.setImmediate(true);
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				 empLayout = new EmployeeLayout(cssContent);
				 empLayout.init();
				
			}
		});
		
		Button buttonAccount = new Button("Load account");
		buttonAccount.setImmediate(true);
		buttonAccount.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				accLayout = new AccountLayout(cssContent);
				accLayout.init();
				
			}
		});
//		empLayout = new EmployeeLayout(cssContent);
//		empLayout.init();
//		mainWindow.addComponent(button);
		mainWindow.addComponent(buttonAccount);
		mainWindow.addComponent(cssContent);
		
		
	}
	

}
