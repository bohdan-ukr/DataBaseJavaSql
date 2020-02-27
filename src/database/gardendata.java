package database;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class gardendata {
    
    private final StringProperty idteach;
    private final StringProperty name_teach;
    private final StringProperty surname_teach;
    private final StringProperty course_teach;
    private final StringProperty course_visit;
    private final StringProperty imgkd;
  
   

    
    public gardendata(String idteach,String name_teach,String surname_teach,String course_teach,String course_visit,String imgkd){
        this.name_teach = new SimpleStringProperty(name_teach);
        this.surname_teach = new SimpleStringProperty(surname_teach);
        this.course_teach = new SimpleStringProperty(course_teach);
        this.course_visit = new SimpleStringProperty(course_visit);
        this.idteach = new SimpleStringProperty(idteach);
        this.imgkd = new SimpleStringProperty(imgkd);
    }

    public String getIdteach()
  {
    return (String)this.idteach.get();
  }
  
  public String getName_teach()
  {
    return (String)this.name_teach.get();
  }
  
  public String getSurname_teach()
  {
    return (String)this.surname_teach.get();
  }
  
  public String getCourse_teach()
  {
    return (String)this.course_teach.get();
  }
  
  public String getCourse_visit()
  {
    return (String)this.course_visit.get();
  }
  
  public String getImgkd()
  {
    return (String)this.imgkd.get();
  }
  
  
  public void setIdteach(String value)
  {
    this.idteach.set(value);
  }
  
  public void setName_teach(String value)
  {
    this.name_teach.set(value);
  }
  
  public void setSurname_teach(String value)
  {
    this.surname_teach.set(value);
  }
  
  public void setCourse_teach(String value)
  {
    this.course_teach.set(value);
  }
  
  public void setCourse_visit(String value)
  {
    this.course_visit.set(value);
  }
  
  public void setImgkd(String value)
  {
    this.imgkd.set(value);
  }
  
  public StringProperty idteachProperty()
  {
    return this.idteach;
  }
  
  public StringProperty name_teachProperty()
  {
    return this.name_teach;
  }
  
  public StringProperty surname_teachProperty()
  {
    return this.surname_teach;
  }
  
  public StringProperty course_teachProperty()
  {
    return this.course_teach;
  }
  
  public StringProperty course_visitProperty()
  {
    return this.course_visit;
  }
  
  public StringProperty imgkdProperty()
  {
    return this.imgkd;
  }
  

//    public Button getUpdatebutton() {
//        return updatebutton;
//    }
//
//    public void setUpdatebutton(Button updatebutton) {
//        this.updatebutton = updatebutton;
//    }

 
    
    
    
   
}

