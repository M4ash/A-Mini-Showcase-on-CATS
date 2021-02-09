import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
//import javafx.scene.text.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Introduction extends Application {
	
	


	TextField tf1 = new TextField();
	Button btUp2 = new Button("  UPDATE  ");
	
	Button back = new Button("To Menu ");
	Button btex = new Button("EXIT");
	Button btUp = new Button("Modify");
	Label l1 = new Label("\t\t\t  INTRODUCTION ON CATS");

	
	private int selectedIndex = -1;
	String[] line = new String[50];
	int count = 0;
	
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		l1.setStyle("-fx-text-fill: grey;-fx-font-size: 2.2em;-fx-font-weight: bold;");
		List<String> lines = new ArrayList<String>();
        try (Scanner br = new Scanner(new File("catinfo.txt")))
        {
            while (br.hasNext()) {
            	line[count] = br.nextLine();
                lines.add(line[count]);
                count++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        ListView<String> listView = new ListView<String>();
        listView.setItems(FXCollections.observableList(lines));
        
		GridPane pane = new GridPane();
		back.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btex.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btUp.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		Image image = new Image(new File("img\\catgiff.gif").toURI().toString(),190,150, false, false);
	    pane.getChildren();
	    pane.setStyle("-fx-background-color: #EBF7FF");
	    
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    hBox.setPrefSize(1000, 0);
	    btex.setPrefWidth(100);
	    back.setPrefWidth(100);
	    btUp.setPrefWidth(100);//button size

	    hBox.getChildren().addAll(back,btUp,btex); 
	    
	   	
		pane.add(new ImageView(image),0,0);
		pane.add(l1,0,0);
		
		pane.add(listView, 0, 1);
		

		pane.add(hBox,0,6);
		
		
		pane.setVgap(12);
		pane.setAlignment(Pos.CENTER);
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setTop(pane);
	    BorderPane.setAlignment(pane, Pos.CENTER);
	    
	    btUp.setOnAction(event ->{
			//Appears new window
			Stage stage3=new Stage();
			GridPane label = new GridPane();
			Label l = new Label("\t\t\t\t\tModify");
			l.setStyle("-fx-text-fill: White;-fx-font-size: 1.7em;");
			label.add(l, 1, 0);
			label.setAlignment(Pos.TOP_CENTER);
			
			GridPane grid=new GridPane();
			grid.add(l, 1,0) ;
			grid.setAlignment(Pos.CENTER);
			grid.setVgap(10);
			grid.add(tf1,1,1);
			tf1.setPrefWidth(540);
			tf1.setPrefHeight(37);
			
			HBox hBox2 = new HBox();
		    hBox2.setSpacing(10);
		    hBox2.setAlignment(Pos.CENTER);
		    btUp2.setPrefWidth(100); //button size
		  
		    hBox2.getChildren().addAll(btUp2);
			
			VBox vBox2= new VBox();
		    vBox2.setSpacing(15);
		    vBox2.setAlignment(Pos.CENTER);
		    vBox2.setStyle("-fx-background-color: #2A8CCD");
		    vBox2.getChildren().addAll(grid,hBox2);

		    Scene scene2 = new Scene(vBox2,520,250);
		    stage3.setTitle("Change/Modify"); // Set the stage title
		    stage3.setScene(scene2);   // Set a scene with a button in the stage     
		    stage3.show();
		    
		    String selectItem = listView.getSelectionModel().getSelectedItem().toString();
			selectedIndex = listView.getSelectionModel().getSelectedIndex();
			tf1.setText(selectItem);
			
			btUp2.setOnAction(event2 -> {
				listView.getItems().remove(selectedIndex);
				listView.getItems().add(selectedIndex,tf1.getText());
				try (PrintWriter out = new PrintWriter("catinfo.txt")) {
					int i;
					for( i=0; i < count; i++) {
						
						if(i == selectedIndex) {
							
							out.println(tf1.getText());
							
						}
						
						if(i != selectedIndex) {
							
							if(i != count-1) {
								out.println(line[i]);
							}
							else if (i == count-1) {
								out.print(line[i]);
								
							}		
							
						}
						
					}
					
					count = count -1;
					stage3.close();
				
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		});
	    
	    back.setOnAction(e ->{try{ StartUp toStartUp=new StartUp();toStartUp.start(primaryStage); //back to start page
	    }
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });
	    
	    btex.setOnAction(e ->{
		    try{ 
		    		System.exit(0);
		    }
		    catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
		    });
	    
	  
		Scene scene = new Scene(borderPane,700,659);
		primaryStage.setTitle("INTRODUCTION ON CATS");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
		}
	}