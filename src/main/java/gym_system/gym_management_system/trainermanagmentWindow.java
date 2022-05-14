package gym_system.gym_management_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trainermanagmentWindow extends JFrame{
    private JButton btn_add_trainer;
    private JButton btn_edit_trainer;
    private JButton btn_remove_trainer;
    private JButton btn_assign_trainer_to_class;
    private JButton btn_assign_trainer_to_member;
    private JButton btn_trainermanagment_signout;
    private JPanel trainermanagmentPanel;
    GymSystem Gym_Management_System = new GymSystem();
    trainermanagmentWindow(){
        setContentPane(trainermanagmentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Admin Test");
        setVisible(true);

        btn_add_trainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addtrainerWindow addtrainerwindow = new addtrainerWindow();
            }
        });
        btn_edit_trainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                edittrainerWindow edittrainerwindow = new edittrainerWindow();
            }
        });
        btn_remove_trainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                removetrainerWindow removetrainerwindow = new removetrainerWindow();
            }
        });
        btn_assign_trainer_to_class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                assigntrainerWindow assigntrainerwindow = new assigntrainerWindow();
            }
        });
        btn_assign_trainer_to_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                assigntrainertomemberWindow assigntrainertomemberwindow = new assigntrainertomemberWindow();
            }
        });
        btn_trainermanagment_signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Gym_Management_System.signout();
                welcomePage welcomepage = new welcomePage();
                welcomepage.txtHome.setText("Signed out successfully");
            }
        });
    }


}
