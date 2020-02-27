package database;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class groupdata {
    
    private final StringProperty id_courses;
    private final StringProperty name_courses;
    private final StringProperty date_start;
    private final StringProperty date_end;
    private final StringProperty t_name;
    private final StringProperty t_surname;
    private final StringProperty imggrp;
  
   

    
    public groupdata(String id_courses,String name_courses,String date_start,String date_end,String t_name,String t_surname,String imggrp){
        this.id_courses = new SimpleStringProperty(id_courses);
        this.name_courses = new SimpleStringProperty(name_courses);
        this.date_start = new SimpleStringProperty(date_start);
        this.date_end = new SimpleStringProperty(date_end);
        this.t_name = new SimpleStringProperty(t_name);
        this.t_surname = new SimpleStringProperty(t_surname);
        this.imggrp = new SimpleStringProperty(imggrp);
        
    }

    public String getId_courses()
  {
    return (String)this.id_courses.get();
  }
  
  public String getName_courses()
  {
    return (String)this.name_courses.get();
  }
  
  public String getDate_start()
  {
    return (String)this.date_start.get();
  }
  
  public String getDate_end()
  {
    return (String)this.date_end.get();
  }
  
  public String getT_name()
  {
    return (String)this.t_name.get();
  }
 
  public String getT_surname()
  {
    return (String)this.t_surname.get();
  }
  
  public String getImggrp()
  {
      return (String)this.imggrp.get();
  }
  
  
  public void setId_courses(String value)
  {
    this.id_courses.set(value);
  }
  
  public void setName_courses(String value)
  {
    this.name_courses.set(value);
  }
  
  public void setDate_start(String value)
  {
    this.date_start.set(value);
  }
  
  public void setT_name(String value)
  {
    this.t_name.set(value);
  }
  
  public void setT_surname(String value)
  {
    this.t_surname.set(value);
  }
  
  public void setDate_end(String value)
  {
    this.date_end.set(value);
  }
  
  public void setImggrp(String value)
  {
    this.imggrp.set(value);
  }
  
  public StringProperty id_coursesProperty()
  {
    return this.id_courses;
  }
  
  public StringProperty name_coursesProperty()
  {
    return this.name_courses;
  }
  
  public StringProperty date_startProperty()
  {
    return this.date_start;
  }
  
  public StringProperty date_endProperty()
  {
    return this.date_end;
  }
  
  public StringProperty t_nameProperty()
  {
    return this.t_name;
  }
  
  public StringProperty t_surnameProperty()
  {
    return this.t_surname;
  }
  
  public StringProperty imggrpProperty()
  {
    return this.imggrp;
  }

//    public Button getUpdatebutton() {
//        return updatebutton;
//    }
//
//    public void setUpdatebutton(Button updatebutton) {
//        this.updatebutton = updatebutton;
//    }

 
    
    
    
   
}

