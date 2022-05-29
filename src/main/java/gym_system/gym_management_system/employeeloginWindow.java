package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class employeeloginWindow extends JFrame{
    public JTextField txt_employee_user;
    public JTextField txt_employee_pass;
    private JButton btn_employee_login;
    private JLabel lbl_employee_username;
    private JLabel lbl_employee_password;
    public JLabel lbl_invalid_employee_login;
    private JPanel employeeloginPanel;
    private JButton registerButton;


    employeeloginWindow(){
        setContentPane(employeeloginPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Employee Login");
        setVisible(true);
        setLocationRelativeTo(null);

        btn_employee_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = txt_employee_user.getText().toUpperCase(Locale.ROOT);
                String Password = txt_employee_pass.getText();
                try {
                    if (((Username.isEmpty()) || (Password.isEmpty()))) {

                        throw new NullPointerException("Please Complete missing data");
                    } else {
                        if (GymSystem.employeeLogin(Username, Password) == null) {
                            lbl_invalid_employee_login.setForeground(new Color(255, 0, 0));
                            lbl_invalid_employee_login.setText("Invalid Username or Password!");
                        } else {
                            lbl_invalid_employee_login.setText("");
                            dispose();
                            GymSystem.loggedInEmployee = GymSystem.employeeLogin(Username, Password);
                            employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();


                        }
                    }
                } catch (Exception x) {
                    lbl_invalid_employee_login.setText(x.getMessage());
                    lbl_invalid_employee_login.setForeground(new Color(255, 0, 0));

                }
            }});
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeeregisterWindow employeeregisterwindow = new employeeregisterWindow();
            }
        });
    }
}
