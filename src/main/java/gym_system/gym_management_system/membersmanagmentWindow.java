package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class membersmanagmentWindow extends JFrame{
    private JButton btn_view_members_in_specific_class;
    private JButton btn_view_members_in_specific_membership;
    private JButton btn_view_all_members_infos;
    private JButton btn_managemembers_signout;
    private JPanel membersmanagmentPanel;
    private JButton backToMenuButton;


    membersmanagmentWindow(){
        setContentPane(membersmanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Member Management");
        setVisible(true);
        setLocationRelativeTo(null);

        btn_view_members_in_specific_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewmembersinclassWindow viewmembersinclasswindow = new viewmembersinclassWindow();
            }
        });
        btn_view_members_in_specific_membership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewmembersinmembershipWindow viewmembersinmembershipwindow = new viewmembersinmembershipWindow();
            }
        });
        btn_view_all_members_infos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewallmembersWindow viewallmemberswindow = new viewallmembersWindow();
            }
        });
        btn_managemembers_signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GymSystem.signout();
                welcomePage welcomepage = new welcomePage();
                welcomepage.txtHome.setText("Signed out successfully");
            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                adminWindow adminwindow = new adminWindow();
            }
        });
    }
}
