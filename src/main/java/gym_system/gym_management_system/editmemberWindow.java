package gym_system.gym_management_system;

import Gym_Components.Member;
import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class editmemberWindow extends JFrame{


    private JPanel editmemberPanel2;
    private JPanel editmemberPanel;
    private JLabel lbl_addmember;
    private JLabel lbl_name;
    private JTextField txt_name;
    private JComboBox combo_gender;
    private JTextField txt_phone;
    private JComboBox combo_membership;
    private JTextField txt_id;
    private JButton searchButton;
    private JButton submitButton;
    private JButton resetButton;
    private JButton backToMenuButton;
    private JButton addToClassButton;
    private JButton removeFromClassButton;

    editmemberWindow() {
        setContentPane(editmemberPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Edit Member");
        setVisible(true);
        setLocationRelativeTo(null);
        txt_name.setEnabled(false);
        txt_phone.setEnabled(false);
        submitButton.setEnabled(false);
        combo_membership.setEnabled(false);
        combo_gender.setEnabled(false);
        resetButton.setVisible(false);
        addToClassButton.setEnabled(false);
        removeFromClassButton.setEnabled(false);



        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberNational_id = txt_id.getText();
                Member edited_member = Employee.findMember(memberNational_id);
                if (edited_member != null) {
                    lbl_addmember.setText("A Member was found with this ID");
                    lbl_addmember.setForeground(new Color(75, 181, 67));
                    txt_id.setEnabled(false);
                    searchButton.setVisible(false);
                    resetButton.setVisible(true);
                    addToClassButton.setEnabled(true);
                    removeFromClassButton.setEnabled(true);

                    txt_name.setEnabled(true);
                    txt_name.setText(edited_member.get_name());

                    txt_phone.setEnabled(true);
                    txt_phone.setText(edited_member.getPhone_number());

                    combo_membership.setEnabled(true);
                    combo_membership.setSelectedItem(edited_member.getMembership_type());

                    combo_gender.setEnabled(true);
                    combo_gender.setSelectedItem(edited_member.get_gender());

                    submitButton.setEnabled(true);

                }
                else{
                    lbl_addmember.setText("No Member exists with this ID");
                    lbl_addmember.setForeground(new Color(255, 0, 0));

                }
            }
        });


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberNational_id = txt_id.getText();
                Member edited_member = Employee.findMember(memberNational_id);
                edited_member.set_name(txt_name.getText());
                edited_member.set_gender(((String) combo_gender.getItemAt(combo_gender.getSelectedIndex())).toUpperCase(Locale.ROOT));
                edited_member.set_phone_number(txt_phone.getText());
                edited_member.setMembership_type(((String) combo_membership.getItemAt(combo_membership.getSelectedIndex())).toUpperCase(Locale.ROOT));

                dispose();
                employeemanagmentWindow  employeemanagmentwindow = new employeemanagmentWindow();
                employeemanagmentwindow.lbl_employee_management_home.setText(edited_member.get_name() + "'s data was edited Successfully!");
                employeemanagmentwindow.lbl_employee_management_home.setForeground(new Color(75, 181, 67));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                editmemberWindow editmemberwindow = new editmemberWindow();
            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow  employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
        addToClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberNational_id = txt_id.getText();
                Member edited_member = Employee.findMember(memberNational_id);
                dispose();
                addmembertoclassWindow addmembertoclasswindow = new addmembertoclassWindow();
                addmembertoclasswindow.txt_id.setText(txt_id.getText());
                addmembertoclasswindow.txt_id.setEnabled(false);
                addmembertoclasswindow.lbl_add_member_to_class.setText("Add " + edited_member.get_name() + " to a Class");
            }
        });
        removeFromClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberNational_id = txt_id.getText();
                Member edited_member = Employee.findMember(memberNational_id);
                dispose();
                removememberfromclassWindow removememberfromclasswindow = new removememberfromclassWindow();
                removememberfromclasswindow.txt_id.setText(txt_id.getText());
                removememberfromclasswindow.txt_id.setEnabled(false);
                removememberfromclasswindow.lbl_add_member_to_class.setText("Remove " + edited_member.get_name() + " from a Class");
            }
        });
    }
}