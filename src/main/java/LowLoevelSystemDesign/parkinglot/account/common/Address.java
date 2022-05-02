package LowLoevelSystemDesign.parkinglot.account.common;

import lombok.Getter;

@Getter
public class Address {
  private Address() {
  }
  private String addressLine1;
  private String addressLine2;
  private String street;
  private String city;
  private String country;
  private String zipcode;
}
