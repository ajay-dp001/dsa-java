package collection;

import java.util.HashSet;
import java.util.Set;

public class HashCodeEqualChecks {

  private static class Employee {

    int id;
    String name;
    String email;

    Employee(int id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Employee)) {
        return false;
      }
      Employee employee = (Employee) o;
      return id == employee.id;
    }

    @Override
    public int hashCode() {
      int result = (id ^ (id >>> 31));
      //result = 31 * result + name.hashCode();
      //result = 31 * result + email.hashCode();
      return result;
    }
  }

  public static void main(String[] args) {
    int x=-1;
    System.out.println(x>>>29);
    System.out.println(x>>>30);
    System.out.println(x>>>31);
    System.out.println(x>>>32);

    Employee emp1 = new Employee(10);
    Employee emp2 = new Employee(10);
    Object obj = new Object();

    System.out.println("toString: " + obj);
    System.out.println("hashCode: " + obj.hashCode());
    System.out.println("hashCode: " + System.identityHashCode(obj));

    System.out.println(emp1.equals(emp2));
    System.out.println("ToString : " + emp1);
    System.out.println("ToString : " + emp1.hashCode());
    System.out.println("ToString : " + Integer.toHexString(emp1.hashCode()));
    System.out.println("ToString : " + Integer.toHexString(System.identityHashCode(emp1)));

    Set<Employee> set = new HashSet<>();
    System.out.println(System.identityHashCode(emp1));
    System.out.println(System.identityHashCode(emp2));
    set.add(emp1);
    set.add(emp2);
    System.out.println(set.size());
  }
}
