/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Controllers.RepublicController;
import Controllers.SignInController;
import Views.RepublicView;
import java.util.UUID;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.Migration;


/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Migration migration = new Migration();
        migration.run();
        
        SignInController republic = new SignInController();
        republic.view();
    }
}
