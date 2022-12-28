package models;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserAddress {

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String homePhone;
    private String mobilePhone;
    private String titleForReference;
    private Optional optional;

    private String country;
    private String state;


    @Data
    @Builder
    public static class Optional {
        private String company;
        private String secondAddress;
    }
}