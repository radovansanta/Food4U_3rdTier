package DatabaseAccess;

import Models.User;

public interface ManageUsers {
  User getUser(String username);
  void addUser(User user);
}