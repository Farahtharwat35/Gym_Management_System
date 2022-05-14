package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeWindow extends JFrame{
    private JButton loginEmployee;
    private JButton registerEmployee;
    private JPanel employeePanel;
    public JLabel txtHome;
    GymSystem Gym_Management_System= new GymSystem();

    employeeWindow(){
        setContentPane(employeePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Employee");
        setVisible(true);

        loginEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeeloginWindow employeeloginwindow = new employeeloginWindow();
            }
        });
        registerEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeeregisterWindow employeeregisterwindow = new employeeregisterWindow();
            }
        });
    }
}
