package Model;

import DBLayer.DbConnection;
import DTO.CustomerDto;
import DTO.CustomerJobDto;
import DTO.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerJobModel {
    public boolean saveCustomerJob(CustomerJobDto customerJobDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Orders VALUES (?,?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, customerJobDto.getId());
        ptsm.setString(2,customerJobDto.getCustomerId());
        ptsm.setString(3, customerJobDto.getEmployeeId());
        ptsm.setString(4, customerJobDto.getProblem());

        return ptsm.executeUpdate() > 0;
    }

    public boolean deleteCustomerOrder(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM Orders WHERE Id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public boolean saveCustomerFishOrder(OrderDto orderDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Report VALUES (?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, orderDto.getId());
        ptsm.setString(2, orderDto.getName());
        ptsm.setString(3, orderDto.getPrice());


        return ptsm.executeUpdate() > 0;
    }
}
