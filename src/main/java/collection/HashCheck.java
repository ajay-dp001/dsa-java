package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCheck {

  private static class Key {

    int keyId;
    String keyName;

    public Key(int keyId, String keyName) {
      this.keyId = keyId;
    }

    /*@Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Key)) {
        return false;
      }
      Key keyObj = (Key) obj;
      return Objects.equals(keyId, keyObj.keyId) && Objects.equals(keyName, keyObj.keyName);
    }*/

    @Override
    public int hashCode(){
      return Objects.hash(keyId, keyName);
    }
  }

  public static void main(String[] args) {
    Map<Key, String> map = new HashMap<>();
    Key key = new Key(10, "Ajay");
    System.out.println(key.hashCode());
    Key key1 = new Key(10, "Ajay");
    System.out.println(key1.hashCode());
    System.out.println(key.equals(key1));
    System.out.println(key == key1);

    map.put(key, "Key_VAl");
    map.put(key1, "Key_VAl2");
    if (map.containsKey(key)) {
      System.out.println(map.get(key));
    } else {
      System.out.println("Key Not exist..");
    }
  }

}
