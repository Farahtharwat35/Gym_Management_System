package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import Gym_Components.Member;
import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class addmembertoclassWindow extends JFrame {
    public JTextField txt_id;
    private JButton addButton;
    private JButton backToMenuButton;
    private JPanel addmembertoclassPanel;
    private JTextField txt_class;
    public JLabel lbl_add_member_to_class;

    addmembertoclassWindow() {
        setContentPane(addmembertoclassPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Add Member to Class");
        setVisible(true);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id,gymClassName;
                gymClassName = txt_class.getText().toUpperCase(Locale.ROOT);
                Gym_Class gym_class = Employee.findGymClass(gymClassName);
                national_id = txt_id.getText();
                Member addedMember = Employee.findMember(national_id);
                if(addedMember==null)
                {
                    lbl_add_member_to_class.setText("No Member exists with this ID");
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));

                }
                else if(gym_class==null){
                    lbl_add_member_to_class.setText("No Class exists with this name");
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));
                }
                else {
                    addedMember.getMemberAttendedClasses().add(gym_class);
                    gym_class.addMemberToClass(addedMember);
                    dispose();
                    employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
                    employeemanagmentwindow.lbl_employee_management_home.setText(addedMember.get_name() + " was added successfully to " + gym_class.getType());
                    employeemanagmentwindow.lbl_employee_management_home.setForeground(new Color(75, 181, 67));
                }

            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}
