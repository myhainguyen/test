package com.vaadin.scrumban.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


@ContextConfiguration( "classpath:/contextTest.xml" )
@Component
public class ScrumbanTest extends AbstractTestNGSpringContextTests
{
	/** Group name for all services integration tests */
	public static final String SERVICES_INTEGRATION_TEST_GROUP = "SERVICES_INTEGRATION_TEST_GROUP";
	@Override
	@BeforeSuite( alwaysRun = true )
	@BeforeClass( alwaysRun = true )
	public void springTestContextPrepareTestInstance() throws Exception
	{
		super.springTestContextPrepareTestInstance();
	}

}
