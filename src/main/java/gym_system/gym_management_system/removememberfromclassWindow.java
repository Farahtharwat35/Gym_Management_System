package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import Gym_Components.Member;
import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class removememberfromclassWindow extends JFrame{
    private JPanel removememberfromclassPanel;
    public JLabel lbl_add_member_to_class;
    public JTextField txt_id;
    private JButton addButton;
    private JButton backToMenuButton;
    private JTextField txt_class;

    removememberfromclassWindow() {
        setContentPane(removememberfromclassPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Remove Member from Class");
        setVisible(true);
        setLocationRelativeTo(null);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id,gymClassName;
                gymClassName = txt_class.getText().toUpperCase(Locale.ROOT);
                Gym_Class gym_class = Employee.findGymClass(gymClassName);
                national_id = txt_id.getText();
                Member memberToBeRemoved = Employee.findMember(national_id);
                if(memberToBeRemoved==null)
                {
                    lbl_add_member_to_class.setText("No Member exists with this ID");
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));

                }
                else if(gym_class==null){
                    lbl_add_member_to_class.setText("No Class exists with this name");
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));
                }


                else{

                    boolean is_found=false;
                    for (Gym_Class C : memberToBeRemoved.getMemberAttendedClasses() ) {
                        if (C.getType().equals(gym_class.getType())) {
                            is_found=true ;
                            break;
                        }

                    }
                    if(is_found==false){
                        lbl_add_member_to_class.setText(memberToBeRemoved.get_name() + " is not assigned to " + gym_class.getType());
                        lbl_add_member_to_class.setForeground(new Color(255,0,0));

                    }
                    else {
                        gym_class.EmployeeRemoveClass_members(memberToBeRemoved);
                        memberToBeRemoved.getMemberAttendedClasses().remove(gym_class);
                        dispose();
                        employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
                        employeemanagmentwindow.lbl_employee_management_home.setText(memberToBeRemoved.get_name() + " was removed successfully from " + gym_class.getType());
                        employeemanagmentwindow.lbl_employee_management_home.setForeground(new Color(75, 181, 67));
                    }


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
