package org.iit.mmp.tests;

import org.h2k.mmp2.pages.LoginPage;
import org.h2k.mmp2.pages.NavigatePage;
import org.h2k.mmp2.pages.TestBaseClass;
import org.h2k.mmp2.pages.WriteMessagePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PAT009_Tests extends TestBaseClass {
	@Test
	public void validate() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		
		LoginPage lobj = new LoginPage(driver);
		boolean result1 = lobj.login("ria1","Ria12345");
		sa.assertTrue(result1);
		
		NavigatePage nobj = new NavigatePage(driver);
		boolean result2 = nobj.navigateToModule("Messages");
		sa.assertTrue(result2);

		WriteMessagePage wobj= new WriteMessagePage(driver);
		try {
			wobj.writeMessage();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		sa.assertAll();
	}



}
