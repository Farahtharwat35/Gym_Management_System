package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class classesmanagmentWindow extends JFrame{
    private JButton btn_open_class;
    private JButton btn_edit_class;
    private JButton btn_remove_class;
    private JButton btn_view_members_in_class;
    private JButton btn_classesmanagment_signout;
    private JPanel classesmanagmentPanel;
    private JButton backToMenuButton;


    classesmanagmentWindow(){
        setContentPane(classesmanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Classes Management");
        setLocationRelativeTo(null);
        setVisible(true);

        btn_open_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                openclassWindow openclasswindow = new openclassWindow();
            }
        });
        btn_edit_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                editclassWindow editclasswindow = new editclassWindow();
            }
        });
        btn_remove_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                removeclassWindow removeclasswindow = new removeclassWindow();
            }
        });

        btn_classesmanagment_signout.addActionListener(new ActionListener() {
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
                adminWindow adminwindow= new adminWindow();
            }
        });
    }
}
