package gym_system.gym_management_system;

import Gym_Components.Gym_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Locale;

public class editclassWindow extends JFrame{
    private JPanel editclassPanel;
    private JLabel lbl_edit_class;
    private JTextField txt_name;
    private JTextField txt_time1;
    private JSpinner spin_max;
    private JTextArea txt_description;
    private JButton submitButton;
    private JComboBox comboBox1;
    private JTextField txt_time2;
    private JButton searchButton;

    LocalTime start_time;
    LocalTime end_time;

    GymSystem Gym_Managment_System = new GymSystem();

    editclassWindow(){

        setContentPane(editclassPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Open Class");
        setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String class_name = txt_name.getText().toUpperCase(Locale.ROOT);
                Gym_Class edited_class = Gym_Managment_System.admin1.findClass(class_name);

                if (edited_class == null){
                   lbl_edit_class.setText("No Class was found");
                   lbl_edit_class.setForeground(new Color(255,0,0));
                }
                else {
                    lbl_edit_class.setText("Class " + edited_class.getType() + " was found successfully");
                    lbl_edit_class.setForeground(new Color(75, 181, 67));
                    txt_name.setEnabled(false);
                    searchButton.setEnabled(false);

                    comboBox1.setEnabled(true);
                    comboBox1.setSelectedItem(edited_class.getDay());

                    txt_time1.setEnabled(true);
                    txt_time1.setText(edited_class.getStart_time().toString());

                    txt_time2.setEnabled(true);
                    txt_time2.setText(edited_class.getEnd_time().toString());

                    txt_description.setEnabled(true);
                    txt_description.setText(edited_class.getDescription());

                    spin_max.setEnabled(true);
                    spin_max.setValue(edited_class.getMembers_limited_number());

                    submitButton.setEnabled(true);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String class_name = txt_name.getText().toUpperCase(Locale.ROOT);
                Gym_Class edited_class = Gym_Managment_System.admin1.findClass(class_name);
                    edited_class.setDay((String) comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                    edited_class.setStart_time(LocalTime.parse(txt_time1.getText() + ":00.00"));

                    edited_class.setEnd_time(LocalTime.parse(txt_time2.getText() + ":00.00"));

                    edited_class.setDescription(txt_description.getText());
                    edited_class.setMembers_limited_number((Integer) (spin_max.getValue()));
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    adminwindow.lbl_admin_home.setText("Class " + edited_class.getType() + " has been edited successfully!");
                    adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));

            }
        });
    }

}