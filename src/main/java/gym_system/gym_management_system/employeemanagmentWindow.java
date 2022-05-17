package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeemanagmentWindow extends JFrame{
    private JButton btn_employeemanagment_add_member;
    private JButton btn_employeemanagment_edit_member;
    private JButton btn_employeemanagment__add_member_to_class;
    private JButton btn_employeemanagment_remove_member_from_class;
    private JButton btn_employeemanagment_view_members_in_class;
    private JButton btn_employeemanagment_view_members_info;
    private JButton btn_employeemanagment_signout;
    private JPanel employeemanagmentPanel;
    public JLabel lbl_employee_management_home;
    private JButton btn_employeemanagment_delete_member;
    GymSystem Gym_Management_System = new GymSystem();

    employeemanagmentWindow() {
        setContentPane(employeemanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Admin Test");
        setVisible(true);
        btn_employeemanagment_add_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addmemberWindow addmemberwindow = new addmemberWindow();
            }
        });
        btn_employeemanagment_edit_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                editmemberWindow editmemberWindow = new editmemberWindow();
            }
        });
        btn_employeemanagment_delete_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                removememberWindow removememberwindow = new removememberWindow();
            }
        });
        btn_employeemanagment__add_member_to_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addmembertoclassWindow addmembertoclasswindow = new addmembertoclassWindow();
            }
        });
        btn_employeemanagment_signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Gym_Management_System.signout();
                welcomePage welcomepage = new welcomePage();
                welcomepage.txtHome.setText("Signed out successfully");
            }
        });
        btn_employeemanagment_remove_member_from_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                removememberfromclassWindow removememberfromclasswindow = new removememberfromclassWindow();
            }
        });
        btn_employeemanagment_view_members_in_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewmembersinclass2Window viewmembersinclass2window = new viewmembersinclass2Window();
            }
        });
        btn_employeemanagment_view_members_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewallmembers2Window viewallmembers2window = new viewallmembers2Window();
            }
        });
    }
}
