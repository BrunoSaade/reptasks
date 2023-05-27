/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controllers;

import java.util.UUID;
import org.junit.jupiter.api. Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brunosaade
 */
public class SignUpControllerTest {
    
    @Test
    public void testRegisterfalse() {
        SignInController incontroller = new SignInController();
        SignUpController upcontroller = new SignUpController(incontroller);
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();  
        String name = "teste2";
        String username = myRandom;
        String password = "123";
        String confirmPassword = "123";
        upcontroller.register(name, username, password, confirmPassword);
        boolean resultExp = false;
        boolean resultObtido = upcontroller.caduser;
        assertEquals(resultExp, resultObtido);
    }

    @Test
    public void testRegistertrue() {
        SignInController incontroller = new SignInController();
        SignUpController upcontroller = new SignUpController(incontroller);
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();        
        String name = "teste2";
        String username = myRandom;
        String password = "1234567Pa";
        String confirmPassword = "1234567Pa";
        upcontroller.register(name, username, password, confirmPassword);
        boolean resultExp = true;
        boolean resultObtido = upcontroller.caduser;
        assertEquals(resultExp, resultObtido);
    }
    
}
