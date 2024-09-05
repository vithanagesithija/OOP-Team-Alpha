import Controller.LoginForm;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Initialize and show the Login form
        LoginForm loginForm = new LoginForm();
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);
    }
}
