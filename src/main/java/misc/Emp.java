package misc;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Emp implements Comparable {

  public String name;
  private double salary;

  public Emp(String name, double salary) {
    this.name = name;
    this.salary = salary;
  }

  @Override
  public int compareTo(Object obj) {
    Emp empObj = (Emp) obj;
    if (this.getSalary() > empObj.getSalary()) {
      return 1;
    } else if (this.getSalary() < empObj.getSalary()) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Emp empObj = (Emp) obj;
    return Double.compare(empObj.salary, salary) == 0 &&
        Objects.equals(name, empObj.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, salary);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", salary=" + salary +
        '}';
  }

}
