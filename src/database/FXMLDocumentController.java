/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;


/**
 *
 * @author bodi4
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TextField searchChildren;
     @FXML
    private TextField searchGroup;
     @FXML
    private TextField searchGarden;   
     
    
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField contact;
    @FXML
    private DatePicker date;
    @FXML
    private TextField courses;
    @FXML
    private TextField images;
    @FXML
    private Button updatebutton;
    
    @FXML
    private TextField id_courses;
    @FXML
    private TextField name_courses;
    @FXML
    private DatePicker date_start;
    @FXML
    private DatePicker date_end;
    @FXML
    private TextField t_name;
    @FXML
    private TextField t_surname;
    @FXML
    private TextField imggrp;
   
    
    @FXML
    private TextField idteach;
    @FXML
    private TextField name_teach;
    @FXML
    private TextField surname_teach;
    @FXML
    private TextField course_teach;
    @FXML
    private TextField course_visit;
    @FXML
    private TextField imgkd;
    
    
    
    @FXML
     private TableView <childrendata> childrentable;
    @FXML
    private TableView <groupdata> grouptable;
    @FXML
    private TableView <gardendata> gardentable;
    
    @FXML
    private TableColumn <childrendata, String> idcolumn;
    @FXML
    private TableColumn <childrendata, String> namecolumn;
    @FXML
    private TableColumn <childrendata, String> surnamecolumn;
    @FXML
    private TableColumn <childrendata, String> contactcolumn;
    @FXML
    private TableColumn <childrendata, String> datecolumn;
    @FXML
    private TableColumn <childrendata, String> coursescolumn;
    @FXML
    private TableColumn <childrendata, String> imagescolumn;
    
    
    @FXML 
    private TableColumn <groupdata, String> id_coursescolumn;
    @FXML
    private TableColumn <groupdata, String> name_coursescolumn;
    @FXML
    private TableColumn <groupdata, String> date_startcolumn;
    @FXML
    private TableColumn <groupdata, String> date_endcolumn;
    @FXML
    private TableColumn <groupdata, String> t_namecolumn;
    @FXML
    private TableColumn <groupdata, String> t_surnamecolumn;
    @FXML
    private TableColumn <groupdata, String> imggrpcolumn; 
    
     
    @FXML 
    private TableColumn <gardendata, String> idteachcolumn;
    @FXML
    private TableColumn <gardendata, String> name_teachcolumn;
    @FXML
    private TableColumn <gardendata, String> surname_teachcolumn;
    @FXML
    private TableColumn <gardendata, String> course_teachcolumn;
    @FXML
    private TableColumn <gardendata, String> course_visitcolumn;
    @FXML
    private TableColumn <gardendata, String> imgkdcolumn;
    
    @FXML
    private ImageView containerimg;
    @FXML
    private ImageView containerimggrp;
    @FXML
    private ImageView containerimggarden;
     
    String c1;
    private sql_connection dc;
   
    private ObservableList<childrendata> newdata;
    private ObservableList<groupdata> newgroupdata;
    private ObservableList<gardendata> newgardendata;
    
     
     
    
    public void changeIdCellEvent(CellEditEvent edditedCell) {
        childrendata newid = childrentable.getSelectionModel().getSelectedItem();
        newid.setId(edditedCell.getNewValue().toString());
    }
    
    public void changeNameCellEvent(CellEditEvent edditedCell) {
        childrendata newname = childrentable.getSelectionModel().getSelectedItem();
        newname.setName(edditedCell.getNewValue().toString());
    }
    
     public void changeSurNameCellEvent(CellEditEvent edditedCell) {
        childrendata newsurname = childrentable.getSelectionModel().getSelectedItem();
        newsurname.setSurname(edditedCell.getNewValue().toString());
    }
    
      public void changeFatherNameCellEvent(CellEditEvent edditedCell) {
        childrendata newcontact = childrentable.getSelectionModel().getSelectedItem();
        newcontact.setContact(edditedCell.getNewValue().toString());
    }
      
       public void changeGroupCellEvent(CellEditEvent edditedCell) {
        childrendata newgroup = childrentable.getSelectionModel().getSelectedItem();
        newgroup.setCourses(edditedCell.getNewValue().toString());
    }
       
    
         public void changeDataCellEvent(CellEditEvent edditedCell) {
        childrendata newname = childrentable.getSelectionModel().getSelectedItem();
        newname.setDate(edditedCell.getNewValue().toString());
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.dc = new sql_connection();
         editable();
 
       
        
         
    }   
     
                       
    
    
   
    @FXML
    private void img(){
        FileChooser chooser = new FileChooser();
       
Window stage = null;
chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG(*.jpg)", "*.jpg","PNG(*.png)", "*.png"));
File selectedFile = chooser.showOpenDialog(stage);

 String somepath = selectedFile.getAbsolutePath();
 
 images.setText(somepath);
 
        System.out.println(somepath);
        
        
        
    }
    
    
    @FXML
    private void imgload(ActionEvent event) {
        try {
        Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
           
            ResultSet rs = conn.createStatement().executeQuery("SELECT images FROM student WHERE id='"+rowNew+"' ");
                  while(rs.next()){
                  String str = rs.getString("images");
                   System.out.println(str);
                    File file = new File(str);
        Image image = new Image(file.toURI().toString());
        containerimg.setImage(image);
                  }
                  
         
                  
        }
        catch(SQLException e){
            System.err.println("error " + e);
            
        }
               
    }
    
    @FXML
        private void imgloadgrp(ActionEvent event) {
        try {
        Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = grouptable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
           
            ResultSet rs = conn.createStatement().executeQuery("SELECT imggrp FROM courses WHERE id_courses='"+rowNew+"' ");
                  while(rs.next()){
                  String str = rs.getString("imggrp");
                   System.out.println(str);
                    File file = new File(str);
        Image image = new Image(file.toURI().toString());
        containerimggrp.setImage(image);
                  }
                  
         
                  
        }
        catch(SQLException e){
            System.err.println("error " + e);
            
        }
               
    }
        @FXML
            private void imgloadgarden(ActionEvent event) {
        try {
        Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = gardentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
           
            ResultSet rs = conn.createStatement().executeQuery("SELECT imgkd FROM teacher WHERE idteach='"+rowNew+"' ");
                  while(rs.next()){
                  String str = rs.getString("imgkd");
                   System.out.println(str);
                    File file = new File(str);
        Image image = new Image(file.toURI().toString());
        containerimggarden.setImage(image);
                  }
                  
         
                  
        }
        catch(SQLException e){
            System.err.println("error " + e);
            
        }
               
    }
     
     @FXML
    private void imggrp(){
        
        
        FileChooser chooser = new FileChooser();
       
Window stage = null;
chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG(*.jpg)", "*.jpg","PNG(*.png)", "*.png"));
File selectedFile = chooser.showOpenDialog(stage);

 String somepath = selectedFile.getAbsolutePath();
 
 imggrp.setText(somepath);
 
        System.out.println(somepath);
        
    }
    
     @FXML
    private void imgkd(){
        FileChooser chooser = new FileChooser();
       
Window stage = null;
chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG(*.jpg)", "*.jpg","PNG(*.png)", "*.png"));
File selectedFile = chooser.showOpenDialog(stage);

 String somepath = selectedFile.getAbsolutePath();
 
 imgkd.setText(somepath);
 
        System.out.println(somepath);
        
    }
    
    @FXML
    private void searchChildren(KeyEvent event) {
         FilteredList <childrendata> childrenfilter = new FilteredList<>(newdata,e->true);
         searchChildren.textProperty().addListener((observable,oldvalue,newvalue) -> {
            childrenfilter.setPredicate(pers -> {
                
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
              String typedText = newvalue.toLowerCase();
              if(pers.getId().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getName().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getSurname().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getCourses().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getDate().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getContact().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
            
                
                return false;
            });
            
            SortedList<childrendata> childrensorted = new SortedList<>(childrenfilter);
            childrensorted.comparatorProperty().bind(childrentable.comparatorProperty());
            childrentable.setItems(childrensorted);
         });
        
    }
    
    

            
    
    
    @FXML
    private void searchGroup(KeyEvent event) {
         FilteredList <groupdata> groupfilter = new FilteredList<>(newgroupdata,e->true);
         searchGroup.textProperty().addListener((observable,oldvalue,newvalue) -> {
            groupfilter.setPredicate(pers -> {
                
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
              String typedText = newvalue.toLowerCase();
              if(pers.getId_courses().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getName_courses().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getDate_start().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getDate_end().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getT_name().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getT_surname().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
             
                return false;
            });
            
            SortedList<groupdata> groupsorted = new SortedList<>(groupfilter);
            groupsorted.comparatorProperty().bind(grouptable.comparatorProperty());
            grouptable.setItems(groupsorted);
         });
        
    }
    

    
    @FXML
    private void searchGarden(KeyEvent event) {
         FilteredList <gardendata> gardenfilter = new FilteredList<>(newgardendata,e->true);
         searchGarden.textProperty().addListener((observable,oldvalue,newvalue) -> {
            gardenfilter.setPredicate(pers -> {
                
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
              String typedText = newvalue.toLowerCase();
              if(pers.getIdteach().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getName_teach().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getSurname_teach().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getCourse_teach().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getCourse_visit().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              
                
                return false;
            });
            
            SortedList<gardendata> gardensorted = new SortedList<>(gardenfilter);
            gardensorted.comparatorProperty().bind(gardentable.comparatorProperty());
            gardentable.setItems(gardensorted);
         });
        
    }
                

    
    @FXML
    private void loadchildrenData(ActionEvent event) throws SQLException{
        
        try{
                Connection conn = sql_connection.getConnection();
                this.newdata = FXCollections.observableArrayList();
                
                // ResultSet rs = conn.createStatement().executeQuery("SELECT student.[id],student.[name],student.[surname],student.[date],student.[contact],courses.[name_courses],student.[images] FROM student INNER JOIN courses ON courses.[name_courses]=student.[courses]");
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student");
                while(rs.next()){
                    this.newdata.add(new childrendata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
                }
        } 
        catch(SQLException e){
            System.err.println("error " + e);
    }
        
        this.idcolumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.contactcolumn.setCellValueFactory(new PropertyValueFactory("contact"));
        this.datecolumn.setCellValueFactory(new PropertyValueFactory("date"));
        this.coursescolumn.setCellValueFactory(new PropertyValueFactory("courses"));
        this.imagescolumn.setCellValueFactory(new PropertyValueFactory("images"));
       // this.update.setCellValueFactory(new PropertyValueFactory("updatebutton"));
        
        
        this.childrentable.setItems(null);
        this.childrentable.setItems(this.newdata);
        
        
        
        
        }
    
    @FXML
    private void loadgroupData(ActionEvent event) throws SQLException{
        
        try{
                Connection conn = sql_connection.getConnection();
                this.newgroupdata = FXCollections.observableArrayList();
                
                
               // ResultSet rs = conn.createStatement().executeQuery("SELECT courses.[id_courses],courses.[name_courses],student.[date_start],student.[date_end],teacher.[name_teacher],teacher[surname_teacher] FROM courses INNER JOIN teacher ON teacher.[name_teacher]=courses.[t_name] INNER JOIN teacher ON teacher.[surname_teacher]=courses.[t_surname]");
               ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM courses");
                while(rs.next()){
                    this.newgroupdata.add(new groupdata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
                }
        } 
        catch(SQLException e){
            System.err.println("error " + e);
    }
        
        this.id_coursescolumn.setCellValueFactory(new PropertyValueFactory("id_courses"));
        this.name_coursescolumn.setCellValueFactory(new PropertyValueFactory("name_courses"));
        this.date_startcolumn.setCellValueFactory(new PropertyValueFactory("date_start"));
        this.date_endcolumn.setCellValueFactory(new PropertyValueFactory("date_end"));
        this.t_namecolumn.setCellValueFactory(new PropertyValueFactory("t_name"));
        this.t_surnamecolumn.setCellValueFactory(new PropertyValueFactory("t_surname"));
        this.imggrpcolumn.setCellValueFactory(new PropertyValueFactory("imggrp"));
      
        
        this.grouptable.setItems(null);
        this.grouptable.setItems(this.newgroupdata);
        
        
        }
    
       @FXML
    private void loadgardenData(ActionEvent event) throws SQLException{
        
        try{
                Connection conn = sql_connection.getConnection();
                this.newgardendata = FXCollections.observableArrayList();
                
                // ResultSet rs = conn.createStatement().executeQuery("SELECT teacher.[idteach],teacher.[name_teach],teacher.[surname_teach],courses.[name_courses],courses.[name_courses] FROM teacher INNER JOIN courses ON courses.[name_courses]=teacher.[course_teach] LEFT JOIN courses ON courses.[name_courses]=teacher.[course_visit]");
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM teacher");
                while(rs.next()){
                    this.newgardendata.add(new gardendata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
        } 
        catch(SQLException e){
            System.err.println("error " + e);
    }
        
        this.idteachcolumn.setCellValueFactory(new PropertyValueFactory("idteach"));
        this.name_teachcolumn.setCellValueFactory(new PropertyValueFactory("name_teach"));
        this.surname_teachcolumn.setCellValueFactory(new PropertyValueFactory("surname_teach"));
        this.course_teachcolumn.setCellValueFactory(new PropertyValueFactory("course_teach"));
        this.course_visitcolumn.setCellValueFactory(new PropertyValueFactory("course_visit"));
        this.imgkdcolumn.setCellValueFactory(new PropertyValueFactory("imgkd"));
        //this.t_surnamecolumn.setCellValueFactory(new PropertyValueFactory("t_surname"));
      
        
        this.gardentable.setItems(null);
        this.gardentable.setItems(this.newgardendata);
        
        
        }
    
   private void editable() {
       
       
        
        idcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        namecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        contactcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        datecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        coursescolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imagescolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        id_coursescolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        name_coursescolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        date_startcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        date_endcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        t_namecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        t_surnamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imggrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        idteachcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        name_teachcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surname_teachcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        course_teachcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        course_visitcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imgkdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
       
        
        
        
         idcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });
         
          namecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });
          
            surnamecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setSurname(e.getNewValue());
        });
            
              contactcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setContact(e.getNewValue()); 
        });
        
                datecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate(e.getNewValue());
        });
              
                coursescolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setCourses(e.getNewValue());
        });
                
        
                  imagescolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setImages(e.getNewValue());
        });
                
                
                
                id_coursescolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setId_courses(e.getNewValue());
        });
         
          name_coursescolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setName_courses(e.getNewValue());
        });
          
            date_startcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate_start(e.getNewValue());
        });
            
              date_endcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate_end(e.getNewValue()); 
        });
        
                t_namecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setT_name(e.getNewValue());
        });
              
                t_surnamecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setT_surname(e.getNewValue());
        });
                imggrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setImggrp(e.getNewValue());
        });
              
                
                
                
                
                idteachcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdteach(e.getNewValue());
        });
         
          name_teachcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setName_teach(e.getNewValue());
        });
          
            surname_teachcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setSurname_teach(e.getNewValue());
        });
            
              course_teachcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setCourse_teach(e.getNewValue()); 
        });
        
                course_visitcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setCourse_visit(e.getNewValue());
        });
                imgkdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setImgkd(e.getNewValue());
        });
                  
     
        this.childrentable.setEditable(true);
        this.grouptable.setEditable(true);
        this.gardentable.setEditable(true);

    
   }
    

@FXML 
private void load(ActionEvent event) {
 
        TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();


childrendata item = childrentable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 
       
}



    public void updataData() {
     
        try {
            Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
            
            TableColumn col = pos.getTableColumn();
            int colIndex = childrentable.getColumns().indexOf(col);
            
            if(colIndex==0){
                rowText="id";
            }else if(colIndex==1){
                rowText="name";
            }else if(colIndex==2){
                rowText="surname";
            }else if(colIndex==3){
                rowText="date";
            }else if(colIndex==4){
                rowText="contact";
            }else if (colIndex==5){
                rowText="courses";
            }else if (colIndex==6){
                rowText="images";
            }
                
                
            System.out.println(rowText);
             String data1 = (String) col.getCellObservableValue(row).getValue();
             System.out.println(data1);
            
           
           con.execute("UPDATE student SET '"+rowText+"' = '"+data1+"' WHERE id = '"+rowNew+"' ");
                   
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    
    
    public void updataGRP() {
     
        try {
            Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = grouptable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
            
            TableColumn col = pos.getTableColumn();
            int colIndex = grouptable.getColumns().indexOf(col);
            
            if(colIndex==0){
                rowText="id_courses";
            }else if(colIndex==1){
                rowText="name_courses";
            }else if(colIndex==2){
                rowText="date_start";
            }else if(colIndex==3){
                rowText="date_end";
            }else if(colIndex==4){
                rowText="t_name";
            }else if (colIndex==5){
                rowText="t_surname";
            }else if (colIndex==6){
                rowText="imggrp";
            }
                
                
            System.out.println(rowText);
             String data1 = (String) col.getCellObservableValue(row).getValue();
             System.out.println(data1);
            
           
           con.execute("UPDATE courses SET '"+rowText+"' = '"+data1+"' WHERE id_courses = '"+rowNew+"' ");
                   
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    
    
    public void updataGarden() {
     
        try {
            Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = gardentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
            
            TableColumn col = pos.getTableColumn();
            int colIndex = gardentable.getColumns().indexOf(col);
            
            if(colIndex==0){
                rowText="idteach";
            }else if(colIndex==1){
                rowText="name_teach";
            }else if(colIndex==2){
                rowText="surname_teach";
            }else if(colIndex==3){
                rowText="course_teach";
            }else if(colIndex==4){
                rowText="course_visit";
            }else if(colIndex==5){
                rowText="imgkd";
            }
                
                
            System.out.println(rowText);
             String data1 = (String) col.getCellObservableValue(row).getValue();
             System.out.println(data1);
            
           
           con.execute("UPDATE teacher SET '"+rowText+"' = '"+data1+"' WHERE idteach = '"+rowNew+"' ");
                   
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    
    
    
    

    
      @FXML
    private void addStudent(ActionEvent event)
  {
    String sql = "INSERT INTO student(`id`, `name`, `surname`,  `date`, `contact`, `courses`, 'images') VALUES (? , ?, ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id.getText());
      stmt.setString(2, this.name.getText());
      stmt.setString(3, this.surname.getText());
      stmt.setString(4, this.date.getEditor().getText());
      stmt.setString(5, this.contact.getText());
      stmt.setString(6, this.courses.getText());
      stmt.setString(7, this.images.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
    
     @FXML
    private void addGroup(ActionEvent event)
  {
    String sql = "INSERT INTO courses(`id_courses`, `name_courses`, `date_start`, `date_end`, `t_name`, `t_surname`, 'imggrp') VALUES (? , ?, ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id_courses.getText());
      stmt.setString(2, this.name_courses.getText());
      stmt.setString(3, this.date_start.getEditor().getText());
      stmt.setString(4, this.date_end.getEditor().getText());
      stmt.setString(5, this.t_name.getText());
      stmt.setString(6, this.t_surname.getText());
      stmt.setString(7, this.imggrp.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
    
     @FXML
    private void addKG(ActionEvent event)
  {
    String sql = "INSERT INTO teacher(`idteach`, `name_teach`, `surname_teach`, `course_teach`, `course_visit`, 'imgkd') VALUES (? , ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.idteach.getText());
      stmt.setString(2, this.name_teach.getText());
      stmt.setString(3, this.surname_teach.getText());
      stmt.setString(4, this.course_teach.getText());
      stmt.setString(5, this.course_visit.getText());
      stmt.setString(6, this.imgkd.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
    
     @FXML
    private void deleteStudent(ActionEvent event)
  {
   
  TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();


childrendata item = childrentable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 String sql = "DELETE FROM student WHERE id=?";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, data);
      
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

childrentable.getItems().removeAll(childrentable.getSelectionModel().getSelectedItem());
      
   
  }
    
    @FXML
    private void deleteGroup(ActionEvent event)
  {
   
  TablePosition pos = grouptable.getSelectionModel().getSelectedCells().get(0);
  System.out.println(pos);
int row = pos.getRow();


groupdata item = grouptable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 String sql = "DELETE FROM courses WHERE id_courses=?";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, data);
      
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

grouptable.getItems().removeAll(grouptable.getSelectionModel().getSelectedItem());
      
   
  }
    
    @FXML
    private void deleteGarden(ActionEvent event)
  {
   
  TablePosition pos = gardentable.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();


gardendata item = gardentable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 String sql = "DELETE FROM teacher WHERE idteach=?";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, data);
      
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

gardentable.getItems().removeAll(gardentable.getSelectionModel().getSelectedItem());
      
   
  }
    
   @FXML 
    private void deleteFromForm(ActionEvent event)
  {
     
           String sql = "DELETE FROM student WHERE id=?";
           
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1,this.id.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
      }
    
    


    
    @FXML
     private void clearFields(ActionEvent event)
  {
    this.id.setText("");
    this.name.setText("");
    this.surname.setText("");
    this.contact.setText("");
    this.date.setValue(null);
    this.courses.setText("");
    this.images.setText("");
  }
     
     @FXML
     private void clearFieldsgroup(ActionEvent event)
  {
    this.id_courses.setText("");
    this.name_courses.setText("");
    this.date_start.setValue(null);
    this.date_end.setValue(null);
    this.t_surname.setText("");
    this.t_name.setText("");
    this.imggrp.setText("");
  }
     @FXML
       private void clearFieldsgarden(ActionEvent event)
  {
    this.idteach.setText("");
    this.name_teach.setText("");
    this.surname_teach.setText("");
    this.course_teach.setText("");
    this.course_visit.setText("");
    this.imgkd.setText("");
  }
}
