package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String Id;
    private String Name;
    private String Problem;
    private String Orders;
    private String Contact;
    private String Email;
    private String EmpId;

    public CustomerDto(String id, String name, String problem, String orders, int contact, String email, String empId) {
        this.Id = id;
        this.Name = name;
        this.Problem = problem;
        this.Orders = orders;
        this.Contact = String.valueOf(contact);
        this.Email = email;
        this.EmpId = empId;
    }
}


