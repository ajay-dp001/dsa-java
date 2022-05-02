package LowLoevelSystemDesign.parkinglot.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import LowLoevelSystemDesign.parkinglot.account.common.Person;

@Getter
@NoArgsConstructor
public class Account {

  private String id;
  private String username;
  private String password;
  private Person person;
}
