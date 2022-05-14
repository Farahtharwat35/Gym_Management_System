package gym_system.gym_management_system;

import javax.swing.*;

public class membersmanagmentWindow extends JFrame{
    private JButton btn_view_members_in_specific_class;
    private JButton btn_view_members_in_specific_membership;
    private JButton btn_view_all_members_infos;
    private JButton btn_managemembers_signout;
    private JPanel membersmanagmentPanel;

    membersmanagmentWindow(){
        setContentPane(membersmanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Admin Test");
        setVisible(true);

    }
}
