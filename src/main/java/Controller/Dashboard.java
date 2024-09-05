package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JButton manageEmployeesButton;
    private JButton manageCustomersButton;
    public JPanel dashboardPane;
    private JButton manageSuppliersButton;
    private JButton inventoryButton;
    private JButton customerJobsButton;
    private JButton monthlyReportsButton;
    private JButton sendEmailButton;
    private JButton customersButton;


    public Dashboard() {
        manageCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCustomer();
            }
        });
        manageEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmployee();
            }
        });
        manageSuppliersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSupplires();
            }
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewInventory();
            }
        });
        customerJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCustomerJobs();
            }
        });
        monthlyReportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gview();
            }
        });
        sendEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmail();
            }
        });
    }

    public void viewCustomer(){
        CustomerUI customerUI = new CustomerUI();
        customerUI.setContentPane(customerUI.backPane);
        customerUI.setTitle("Login TechRepair");
        customerUI.setSize(400,400);
        customerUI.setVisible(true);
    }

    public void viewEmployee(){
        EmployeeUI employeeUI = new EmployeeUI();
        employeeUI.setContentPane(employeeUI.backPane);
        employeeUI.setTitle("Login TechRepair");
        employeeUI.setSize(400,400);
        employeeUI.setVisible(true);
    }
    public void viewSupplires(){
        SuppliresUI suppliresUI = new SuppliresUI();
        suppliresUI.setContentPane(suppliresUI.backPane);
        suppliresUI.setTitle("Login TechRepair");
        suppliresUI.setSize(400,400);
        suppliresUI.setVisible(true);
    }
     public void viewInventory(){
         InventoryView inventoryView = new InventoryView();
         inventoryView.setContentPane(inventoryView.backPane);
         inventoryView.setTitle("Login TechRepair");
         inventoryView.setSize(400,400);
         inventoryView.setVisible(true);
     }

     public void viewCustomerJobs(){
         CustomerJobs customerJobs = new CustomerJobs();
         customerJobs.setContentPane(customerJobs.backPane);
         customerJobs.setTitle("Login TechRepair");
         customerJobs.setSize(400,400);
         customerJobs.setVisible(true);
     }

     public void Gview(){
         RepoartGenarate repoartGenarate = new RepoartGenarate();
         repoartGenarate.setContentPane(repoartGenarate.BackPane);
         repoartGenarate.setTitle("Login TechRepair");
         repoartGenarate.setSize(400,400);
         repoartGenarate.setVisible(true);
     }

     public void viewEmail(){
         emailSend emailSend = new emailSend();
         emailSend.setContentPane(emailSend.backPane);
         emailSend.setTitle("Login TechRepair");
         emailSend.setSize(400,400);
         emailSend.setVisible(true);
     }
    public void initializeComponents() {
    }
}
