package gym_system.gym_management_system;

import javax.swing.*;

public class employeemanagmentWindow extends JFrame{
    private JButton btn_employeemanagment_add_member;
    private JButton btn_employeemanagment_edit_member;
    private JButton btn_employeemanagment_delete_member;
    private JButton btn_employeemanagment__add_member_to_class;
    private JButton btn_employeemanagment_remove_member_from_class;
    private JButton btn_employeemanagment_view_members_in_class;
    private JButton btn_employeemanagment_view_members_info;
    private JButton btn_employeemanagment_signout;
    private JPanel employeemanagmentPanel;
    public JLabel lbl_employee_management_home;

    employeemanagmentWindow() {
        setContentPane(employeemanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Admin Test");
        setVisible(true);
    }
}
