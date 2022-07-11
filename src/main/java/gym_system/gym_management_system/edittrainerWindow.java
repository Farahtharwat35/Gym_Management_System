package gym_system.gym_management_system;

import Gym_Components.Trainer;
import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class edittrainerWindow extends JFrame{
    private JPanel addtrainerPanel;
    private JTextField txt_national_id;
    private JTextField txt_name;
    private JTextField txt_phone;
    private JButton checkButton;
    private JLabel lbl_add_trainer;
    private JComboBox gender_combobox;
    private JButton btn_submit;
    private JButton backToMenuButton;


    edittrainerWindow(){
        setContentPane(addtrainerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Edit Trainer");
        setVisible(true);
        setLocationRelativeTo(null);


        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id = txt_national_id.getText();
                Trainer edited_trainer = Administrator.findTrainer(national_id);
                if(Administrator.checktrainer_id(national_id) == false)
                {
                    lbl_add_trainer.setText("Trainer was found");
                    lbl_add_trainer.setForeground(new Color(75, 181, 67));

                    txt_name.setEnabled(true);
                    txt_name.setText(edited_trainer.get_name());

                    gender_combobox.setEnabled(true);
                    gender_combobox.setSelectedItem(edited_trainer.get_gender());


                    txt_phone.setEnabled(true);
                    txt_phone.setText(edited_trainer.getPhone_number());


                    btn_submit.setEnabled(true);
                    txt_national_id.setEnabled(false);
                    checkButton.setVisible(false);
                }
                else
                {
                    lbl_add_trainer.setText("No trainer exists with this ID");
                    lbl_add_trainer.setForeground(new Color(255, 0, 0));
                    txt_name.setEnabled(false);
                    gender_combobox.setEnabled(false);
                    txt_phone.setEnabled(false);
                    btn_submit.setEnabled(false);
                    txt_national_id.setEnabled(true);
                }
            }
        });
        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id = txt_national_id.getText();
                Trainer edited_trainer = Administrator.findTrainer(national_id);
                String name = txt_name.getText();
                String gender = (String) gender_combobox.getItemAt(gender_combobox.getSelectedIndex());
                String phone_number = txt_phone.getText();
                edited_trainer.set_name(name);
                edited_trainer.set_gender(gender);
                edited_trainer.set_phone_number(phone_number);
                dispose();
                adminWindow adminwindow = new adminWindow();
                adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));
                adminwindow.lbl_admin_home.setText(name +"'s data was edited successfully");

            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                trainermanagmentWindow trainermanagmentwindow = new trainermanagmentWindow();
            }
        });
    }
}