package gym_system.gym_management_system;

import Gym_Components.Member;
import Gym_Components.Trainer;
import System_Users.Administrator;
import System_Users.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removememberWindow extends JFrame{
    private JPanel removememberPanel;
    private JTextField txt_nationalid;
    private JButton deleteButton1;
    private JLabel lbl_delete_assure;
    private JButton cancelButton;
    private JButton deleteButton;


    removememberWindow(){
        setContentPane(removememberPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Employee Register");
        setVisible(true);
        deleteButton.setVisible(false);
        cancelButton.setVisible(false);
        lbl_delete_assure.setVisible(false);


        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String delete_member_id = txt_nationalid.getText();
                deleteButton.setVisible(true);
                cancelButton.setVisible(true);
                lbl_delete_assure.setVisible(true);
                Member delete_member= Employee.findMember(delete_member_id);
                String message = "Are you sure you want to remove " + delete_member.get_name();
                lbl_delete_assure.setText(message);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String delete_member_id = txt_nationalid.getText();
                Member delete_member2= Employee.findMember(delete_member_id);
                GymSystem.getMembers().remove(delete_member2);
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
                String message = delete_member2.get_name() + " was removed successfully.";
                employeemanagmentwindow.lbl_employee_management_home.setText(message);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}

