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

}
