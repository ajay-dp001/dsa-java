package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HasCodeCheck {

  private static class Emp {

    String empId;
    String dob;

    public Emp(String empId, String dob) {
      this.empId = empId;
      this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Emp)) {
        return false;
      }
      Emp emp = (Emp) o;
      return Objects.equals(empId, emp.empId) && Objects.equals(dob, emp.dob);
    }

    @Override
    public int hashCode() {
      return Objects.hash(empId, dob);
    }
  }

  public static void main(String[] args) {
    Map<Emp, String> cache = loadEmpCache();
    Emp lookUpKey = new Emp("100", "10101987");
    String empName = cache.get(lookUpKey);
    System.out.println(empName);
  }

  private static Map<Emp, String> loadEmpCache() {
    Map<Emp, String> cache = new HashMap<>();
    Emp ep1 = new Emp("100", "10101987");
    Emp ep2 = new Emp("100.1", "10101988");
    Emp ep3 = new Emp("100.2", "10101989");
    Emp ep4 = new Emp("100.3", "10101986");
    cache.put(ep1, "A");
    cache.put(ep2, "B");
    cache.put(ep3, "C");
    cache.put(ep4, "D");
    return cache;
  }

 /** public V put(K key, V value){
    if(key == null){
      return putForNull(value);
    }
    int hash = hash(key.hashCode());
    int index= indexFor(hash, table.lenght);
    for(Entry<K, V> entry = table[index]; entry!=null; entry = entry.next()){
      Objects k;
      if(entry.hash == hash  && ((k = entry.key) == key || key.equals(k))){
        V oldValue = entry.value;
        entry.value = value;
        entry.recordAccess(this);
        return oldValue;
      }
    }
    modCount++;
    addEntry(hash, key, value, index);
    return null;
  }
  **/
}
