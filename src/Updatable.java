package ic.doc;

/* Implemented by classes that are changing
 * according to changes to the backend. */
public interface Updatable {
  void update(BackEnd backEnd);
}
