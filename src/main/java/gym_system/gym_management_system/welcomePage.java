package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomePage extends JFrame{
    private JButton logAdmin;
    private JPanel firstPanel;
    private JButton logEmployee;
    public JLabel txtHome;

    welcomePage(){
        setContentPane(firstPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Gym_6");
        setVisible(true);
        setLocationRelativeTo(null);

        logAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    adminloginWindow adminloginwindow = new adminloginWindow();

            }
        });
        logEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeeloginWindow employeeloginwindow = new employeeloginWindow();
            }
        });
    }
}
