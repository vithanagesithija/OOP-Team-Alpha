package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBLayer.DbConnection;
import DTO.CustomerJobDto;
import DTO.OrderDto;
import Model.CustomerJobModel;

public class CustomerJobs extends JFrame {

    public JPanel backPane;
    private JTable CustomerJobsTable;
    private JTextField EmpID;
    private JButton markFinshButton;
    private JTextField txtorderId;
    private JTextField txtCustomerId;
    private JTextField txtEmpId;
    private JTextField txtProblm;
    private JButton saveButton;
    private JButton clearButton;
    private JTextField textCname;
    private JTextField textPrice;
    private JScrollPane scrollTable;
    CustomerJobModel customerJobModel = new CustomerJobModel();
    private DefaultTableModel tableModel;

    public CustomerJobs() {

        cretaTableUI();
        refreshTable();

        markFinshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String orderId = EmpID.getText();
                   String price = textPrice.getText();
                   String cname = textCname.getText();
                   var OrderDto = new OrderDto(orderId,cname,price);

;                try {
                    boolean isDeleted = customerJobModel.deleteCustomerOrder(orderId);
                    customerJobModel.saveCustomerFishOrder(OrderDto);
                    if(isDeleted) {
                        JOptionPane.showMessageDialog(null, "Fishid the order place send Email to customer", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Suppliers ID not matched!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oid = txtorderId.getText();
                String CustomerId = txtCustomerId.getText();
                String problm = txtProblm.getText();
                String EmpId = txtEmpId.getText();

                var CustomerJobDyo = new CustomerJobDto(oid,CustomerId,problm,EmpId);
                try{
                    boolean isSave = customerJobModel.saveCustomerJob(CustomerJobDyo);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "Customer job member has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtorderId.setText("");
                txtCustomerId.setText("");
                txtProblm.setText("");
                txtEmpId.setText("");
            }
        });
    }

    public  void cretaTableUI(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Order ID", "Customer ID", "Problem", "Employee ID"});
        CustomerJobsTable.setModel(tableModel);
        scrollTable.setViewportView(CustomerJobsTable);
    }

    public void refreshTable() {
        System.out.println("********.refreshTable().*******");
        try{
            Connection connection = DbConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM `Order`";
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.executeQuery();

            tableModel.setRowCount(0);

            while (pstm.getResultSet().next()) {
                String order_id = pstm.getResultSet().getString("Id");
                String customer_id = pstm.getResultSet().getString("CustomerId");
                String employee_id = pstm.getResultSet().getString("EmployeeId");
                String problem = pstm.getResultSet().getString("Problem");
                tableModel.addRow(new String[]{order_id, customer_id, employee_id, problem});
            }


        } catch (SQLException ex) {
            // Handle the exception in a user-friendly way
            JOptionPane.showMessageDialog(this, "Error retrieving data from the database.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }


}
