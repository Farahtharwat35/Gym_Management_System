package gym_system.gym_management_system;

import Gym_Components.Member;
import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class addmemberWindow extends JFrame {


    private JPanel addmemberPanel;
    private JTextField txt_name;
    private JComboBox combo_gender;
    private JTextField txt_phone;
    private JComboBox combo_membership;
    private JTextField txt_id;
    private JButton searchButton;
    private JButton submitButton;
    private JLabel lbl_name;
    private JLabel lbl_addmember;
    private JButton resetButton;
    private JButton backToMenuButton;

    addmemberWindow() {
        setContentPane(addmemberPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Add Member");
        setVisible(true);
        txt_name.setEnabled(false);
        txt_phone.setEnabled(false);
        submitButton.setEnabled(false);
        combo_membership.setEnabled(false);
        combo_gender.setEnabled(false);
        resetButton.setVisible(false);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberNational_id = txt_id.getText();
                Member new_member = Employee.findMember(memberNational_id);
                if (new_member == null) {
                    lbl_addmember.setText("No Member was found with this ID");
                    lbl_addmember.setForeground(new Color(75, 181, 67));
                    txt_id.setEnabled(false);
                    searchButton.setVisible(false);
                    txt_name.setEnabled(true);
                    txt_phone.setEnabled(true);
                    submitButton.setEnabled(true);
                    combo_membership.setEnabled(true);
                    combo_gender.setEnabled(true);
                    resetButton.setVisible(true);


                }
                else{
                    lbl_addmember.setText("A member already exist with this ID ( " + Employee.findMember(memberNational_id).get_name() + " )");
                    lbl_addmember.setForeground(new Color(255, 0, 0));

                }
            }
        });


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberNational_id = txt_id.getText();
                String memberName = txt_name.getText();
                String memberGender = ((String) combo_gender.getItemAt(combo_gender.getSelectedIndex())).toUpperCase(Locale.ROOT);
                String memberPhoneNumber = txt_phone.getText();
                String enteredMembership= ((String) combo_membership.getItemAt(combo_membership.getSelectedIndex())).toUpperCase(Locale.ROOT);
                GymSystem.getMembers().add(new Member(memberName, memberNational_id, memberGender, memberPhoneNumber, enteredMembership));
                dispose();
                employeemanagmentWindow  employeemanagmentwindow = new employeemanagmentWindow();
                employeemanagmentwindow.lbl_employee_management_home.setText(memberName + " was added Successfully!");
                employeemanagmentwindow.lbl_employee_management_home.setForeground(new Color(75, 181, 67));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addmemberWindow addmemberwindow = new addmemberWindow();
            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow  employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}
