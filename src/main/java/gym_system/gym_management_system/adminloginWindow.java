package gym_system.gym_management_system;

import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class adminloginWindow extends JFrame{
    private JTextField txt_user;
    private JPasswordField txt_pass;
    private JButton btn_admin_login;
    private JLabel lbl_adminlogin;
    private JPanel adminloginPanel;


    adminloginWindow()
    {
        setContentPane(adminloginPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setLocationRelativeTo(null);
        setTitle("Admin Login");
        setVisible(true);
        btn_admin_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = txt_user.getText().toUpperCase(Locale.ROOT);
                String Password = txt_pass.getText();
                if (Administrator.getUsername().equals(Username) && Administrator.getPassword().equals(Password)) {
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    adminwindow.lbl_admin_home.setText("Welcome " + Administrator.getUsername());
                    GymSystem.status = true;
                }
                else {
                    lbl_adminlogin.setText("Invalid Username or Password!");
                    lbl_adminlogin.setForeground(new Color(255, 0, 0));
                }
            }
        });
    }
}
