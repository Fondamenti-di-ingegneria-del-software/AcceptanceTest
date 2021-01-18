package it.univr;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private WebTester tester;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080/");
    }

    @Test
    public void addPersonTest(){
        tester.beginAt("/");
        tester.clickLinkWithText("Add new person");

        tester.assertTextPresent("Create a new record");
        tester.setTextField("firstname", "Mariano");
        tester.setTextField("lastname", "Ceccato");
        tester.submit();

        tester.assertTextPresent("People list");
        tester.assertTablePresent("");
        tester.assertTextInTable("", new String[]{"Mariano","Ceccato"});
    }


}
