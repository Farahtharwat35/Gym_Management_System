package gym_system.gym_management_system;

import Gym_Components.Member;
import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removememberWindow extends JFrame{
    private JPanel removememberPanel;
    private JTextField txt_nationalid;
    private JButton deleteButton1;
    private JLabel lbl_delete_assure;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton backToMenuButton;


    removememberWindow(){
        setContentPane(removememberPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Delete Member");
        setVisible(true);
        setLocationRelativeTo(null);
        deleteButton.setVisible(false);
        cancelButton.setVisible(false);
        lbl_delete_assure.setVisible(false);


        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String delete_member_id = txt_nationalid.getText();
                Member delete_member= Employee.findMember(delete_member_id);

                if(delete_member != null){
                    deleteButton.setVisible(true);
                    cancelButton.setVisible(true);
                    lbl_delete_assure.setVisible(true);
                    txt_nationalid.setEnabled(false);
                    String message = "Are you sure you want to remove " + delete_member.get_name();
                    lbl_delete_assure.setText(message);
                    lbl_delete_assure.setForeground(new Color(0,0,0));
                }
                else{
                    deleteButton.setVisible(false);
                    cancelButton.setVisible(false);
                    lbl_delete_assure.setVisible(true);
                    lbl_delete_assure.setText("No Member was found was this ID");
                    lbl_delete_assure.setForeground(new Color(255,0,0));
                }
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
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}

