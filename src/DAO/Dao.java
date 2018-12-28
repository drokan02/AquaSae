package DAO;

import java.util.ArrayList;

public interface Dao<T> {

  public String insert(T a);

  public String edit(T a);

  public String delete(T a);

  public ArrayList<T> list(String description);

  public T search(T a);
}
