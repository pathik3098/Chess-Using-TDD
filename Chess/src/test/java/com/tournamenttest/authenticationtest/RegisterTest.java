package com.tournamenttest.authenticationtest;
import com.tournament.authentication.Register;
import com.tournament.model.Users;
import com.tournament.persistence.RegisterPersistence;
import com.tournament.persistence.interfaces.IRegisterPersistence;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.sql.SQLException;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterTest
{
    Register registerObject;
    Users userObject;
    public RegisterTest()
    {
        registerObject = new Register();
        userObject = new Users();
    }

    @Mock
    IRegisterPersistence registerPersistenceObject = new RegisterPersistence();

    @Test
    public void userRegistrationTest() throws SQLException
    {
        userObject.setEmail("aparna@gmail.com");
        userObject.setUsername("AparnaVivekanandan");
        userObject.setUserId("aparna99");
        userObject.setPassword("Daz@");
        registerObject.setRegisterPersistenceObj(registerPersistenceObject);
        when(registerPersistenceObject.saveUserDetails(userObject)).thenReturn("RegisterSuccess");
        Assertions.assertEquals("RegisterSuccess",registerObject.userRegistration(userObject));
    }

    @After
    public void destroy()
    {
        registerPersistenceObject = null;
        registerObject = null;
    }

}
