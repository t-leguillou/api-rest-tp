package au.com.octo.services;

import au.com.octo.exceptions.MyBusinessException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class MyServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @InjectMocks
    private MyService myService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestShouldBeReturningUppercaseValue() {
        String result = myService.processStuff("blabla");
        Assert.assertEquals("BLABLA", result);
    }

    @Test
    public void TestShouldThrowErrorWhenCoucou() {
        thrown.expect(MyBusinessException.class);
        thrown.expectMessage("Not working");

        String result = myService.processStuff("coucou");
    }

}