package gym_system.gym_management_system;

import javax.swing.*;

public class classesmanagmentWindow extends JFrame{
    private JButton btn_open_class;
    private JButton btn_edit_class;
    private JButton btn_remove_class;
    private JButton btn_view_members_in_class;
    private JButton btn_classesmanagment_signout;
    private JPanel classesmanagmentPanel;

    classesmanagmentWindow(){
        setContentPane(classesmanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Admin Test");
        setVisible(true);

    }
}
