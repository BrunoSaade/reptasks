/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.UserDAO;
import Models.UserModel;
import Views.SignUpView;
import com.password4j.Hash;
import com.password4j.Password;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class SignUpController {
    private final SignInController signInController;
    private final SignUpView signUpView;
    private final UserDAO userDAO;
    public boolean caduser = false;
    
    public SignUpController(SignInController signInController) {
        this.signInController = signInController;
        this.userDAO = new UserDAO();
        this.signUpView = new SignUpView(this);
    }
    
    public void view() {
        this.signUpView.setVisible(true);
    }
    
    public void close() {
        this.signUpView.setVisible(false);
        this.signUpView.dispose();
    }
    
    public void toSignIn() {
        this.signUpView.emptyFields();
        this.close();
        this.signInController.view();
    }

    public void register(String name, String username, String password, String confirmPassword) {
        UserModel user = this.userDAO.findByUsername(username);
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
        
         if (user != null) {
            JOptionPane.showMessageDialog(null, "Usuário existente!", "Cadastro", JOptionPane.ERROR_MESSAGE);
            this.signUpView.handleEmptyFields("username");
            caduser = false;
            return;
        }
        
        if (!confirmPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Senha de confirmação não coincide com a senha", "Cadastro", JOptionPane.ERROR_MESSAGE);
            this.signUpView.handleEmptyFields("password");
            caduser = false;
            return;
        }
        
        if (!Pattern.matches(regex, password)) {
            JOptionPane.showMessageDialog(null, "Senha não atende os critérios!", "Cadastro", JOptionPane.ERROR_MESSAGE);
            this.signUpView.handleEmptyFields("password");
            caduser = false;
            return;
        }
       
        
        Hash passwordHash = Password.hash(password).addRandomSalt().withArgon2();
        user = new UserModel();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(passwordHash.getResult());
        
        if (this.userDAO.create(user)) {
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            caduser = true;
            this.toSignIn();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar a conta!", "Cadastro", JOptionPane.ERROR_MESSAGE);
            caduser = false;
        }   
        
        return;
    }   
}
