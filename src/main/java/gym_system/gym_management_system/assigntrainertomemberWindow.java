package gym_system.gym_management_system;

import Gym_Components.Member;
import Gym_Components.Trainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class assigntrainertomemberWindow extends JFrame {
    private JPanel assigntrainertomemberPanel;
    private JTextField txt_id;
    private JTextField txt_member;
    private JLabel lbl_class;
    private JLabel lbl_assign_trainer;
    private JButton submitButton;

    GymSystem Gym_Management_System = new GymSystem();

    assigntrainertomemberWindow() {
        setContentPane(assigntrainertomemberPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Employee Register");
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_national_id = txt_id.getText();
                String member_national_id = txt_member.getText();
                Trainer assigned_trainer=Gym_Management_System.admin1.findTrainer(trainer_national_id);
                Member assigned_member= Gym_Management_System.admin1.findMember(member_national_id);

                if (assigned_trainer==null || assigned_member==null) {
                    lbl_assign_trainer.setText("No such trainer or member found ! Please try again !");
                    lbl_assign_trainer.setForeground(new Color(255, 0, 0));
                }
                else if(Gym_Management_System.admin1.assign_trainer_to_member (assigned_trainer, assigned_member)==true)
                {
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    String message = assigned_trainer.get_name()+ " was assigned successfully to " + assigned_member.get_name();
                    adminwindow.lbl_admin_home.setText(message);
                    adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));
                }
                else{
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    String message = assigned_trainer.get_name()+ " is already assigned to " + assigned_member.get_name();
                    adminwindow.lbl_admin_home.setText(message);
                    adminwindow.lbl_admin_home.setForeground(new Color(255, 0, 0));
                }
            }
        });
    }
}