package Models;

public class Menu
{
  private int menuID;
  private String description;

  public Menu (int menuID, String description)
  {
    this.description= description;
    this.menuID = menuID;
  }

  public int getMenuID()
  {
    return menuID;
  }

  public String getDescription()
  {
    return description;
  }

  public void setMenuID(int menuID)
  {
    this.menuID = menuID;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String toString()
  {
    return "Menu{" + "menuID= "+menuID+", description= "+description+"}";
  }
}
