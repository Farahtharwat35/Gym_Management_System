package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminWindow extends JFrame{
    private JPanel adminPanel;
    private JButton btn_Trainers_Management;
    private JButton btn_Classes_Management;
    private JButton btn_Members_Management;
    private JButton btn_admin_signout;
    public JLabel lbl_admin_home;

    adminWindow(){
        setContentPane(adminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Admin");
        setVisible(true);
        setLocationRelativeTo(null);

        btn_Trainers_Management.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                trainermanagmentWindow trainermanagmentwindow = new trainermanagmentWindow();
            }
        });
        btn_Classes_Management.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                classesmanagmentWindow classesmanagmentwindow = new classesmanagmentWindow();
            }
        });
        btn_Members_Management.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                membersmanagmentWindow membersmanagmentwindow = new membersmanagmentWindow();
            }
        });
        btn_admin_signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GymSystem.signout();
                welcomePage welcomepage = new welcomePage();
                welcomepage.txtHome.setText("Signed out successfully");
            }
        });
    }


}

