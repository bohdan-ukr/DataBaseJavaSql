
package database;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class childrendata {
    
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty contact;
    private final StringProperty courses;
    private final StringProperty date;
    private final StringProperty images;
   // public Button updatebutton;
    
   

    
    public childrendata(String id,String name,String surname,String date,String contact,String courses,String images){
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.contact = new SimpleStringProperty(contact);
        this.courses = new SimpleStringProperty(courses);
        this.date = new SimpleStringProperty(date);
        this.id = new SimpleStringProperty(id);
        this.images = new SimpleStringProperty(images);
        
    }
    

    public String getId()
  {
    return (String)this.id.get();
  }
  
  public String getName()
  {
    return (String)this.name.get();
  }
  
  public String getSurname()
  {
    return (String)this.surname.get();
  }
  
  public String getContact()
  {
    return (String)this.contact.get();
  }
  
  public String getDate()
  {
    return (String)this.date.get();
  }
 
  public String getCourses()
  {
    return (String)this.courses.get();
  }
  
  
  public String getImages()
  {
    return (String)this.images.get();
  }
  
  public void setId(String value)
  {
    this.id.set(value);
  }
  
  public void setName(String value)
  {
    this.name.set(value);
  }
  
  public void setSurname(String value)
  {
    this.surname.set(value);
  }
  
  public void setContact(String value)
  {
    this.contact.set(value);
  }
  
  public void setDate(String value)
  {
    this.date.set(value);
  }
  
  public void setCourses(String value)
  {
    this.courses.set(value);
  }
  
  
  public void setImages(String value)
  {
    this.images.set(value);
  }
  
  public StringProperty idProperty()
  {
    return this.id;
  }
  
  public StringProperty nameProperty()
  {
    return this.name;
  }
  
  public StringProperty surnameProperty()
  {
    return this.surname;
  }
  
  public StringProperty contactProperty()
  {
    return this.contact;
  }
  
  public StringProperty dateProperty()
  {
    return this.date;
  }

  public StringProperty coursesProperty()
  {
    return this.courses;
  }

  public StringProperty imagesProperty()
  {
    return this.images;
  }

//   public Button getUpdatebutton() {
//        return updatebutton;
//    }
//
//    public void setUpdatebutton(Button updatebutton) {
//        this.updatebutton = updatebutton;
//    }

 
    
    
    
   
}
