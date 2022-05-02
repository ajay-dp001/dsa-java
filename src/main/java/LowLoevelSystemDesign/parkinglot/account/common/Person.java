package LowLoevelSystemDesign.parkinglot.account.common;

import lombok.Getter;

@Getter
public class Person {
  private Person(){}
  private Address address;
  private Contact contact;
  private String firstName;
  private String lastName;
}
