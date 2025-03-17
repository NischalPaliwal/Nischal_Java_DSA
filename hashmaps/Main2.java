package hashmaps;
import java.util.*;

class HashMapFinal<K, V> {
  ArrayList<LinkedList<Entity>> list;

  private int size = 0;

  private float lf = 0.5f;

  public HashMapFinal() {
    list = new ArrayList<LinkedList<Entity>>();
    for (int index = 0; index < 10; index++) {
    list.add(new LinkedList<Entity>());
    }
  }

  public void put(K key, V value) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);
    for (Entity entity : entities) {
      if (entity.key.equals(key)) {
        entity.value = value;
        return;
      }
    }

    if ((float)(size) / list.size() > lf) {
      reHash();
    }

    entities.add(new Entity(key, value));
    size++;
  }

  private void reHash() {
    System.out.println("We are now rehashing!");
    ArrayList<LinkedList<Entity>> old = list;
    list = new ArrayList<LinkedList<Entity>>();

    size = 0;

    for (int i = 0; i < old.size() * 2; i++) {
      list.add(new LinkedList<Entity>());
    }    

    for (LinkedList<Entity> entities : old) {
      for (Entity entity : entities) {
        put(entity.key, entity.value);
      }
    }
  }

  public V get(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);
    for (Entity entity : entities) {
      if (entity.key.equals(key)) {
        return entity.value;
      }
    }
    return null;
  }

  public void remove(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);

    Entity target = null;
    
    for (Entity entity : entities) {
      if (entity.key.equals(key)) {
        target = entity;
        break;
      }
    }

    entities.remove(target);
    size--;
  }

  private class Entity {
    K key;
    V value;

    public Entity(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}

public class Main2 {
  public static void main(String[] args) {
    
  }
}