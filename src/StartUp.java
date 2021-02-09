import java.io.File;
import java.util.logging.Logger;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartUp extends Application {
	Label wlcm = new Label("  C A T S"); 
	Label wlcm2 = new Label("   ANIMAL SHOWCASE"); 
	Label space = new Label(" ");
	Button bt1 = new Button("  ABOUT CATS ");
	Button bt2 = new Button("Fun Facts Mini Quiz");
	Button btgal = new Button("Photo Galley");
	Button btexit = new Button("EXIT");

	
	public void start(Stage primaryStage) {
		
		wlcm.setStyle("-fx-text-fill: grey;-fx-font-size: 3.2em;-fx-font-weight: bold;");
		wlcm2.setStyle("-fx-text-fill: grey;-fx-font-size: 2.2em;-fx-font-weight: regular;");
		GridPane pane = new GridPane();
		pane.add(bt1, 1, 0);
		pane.add(bt2,1 , 1);
		pane.add(btgal,1 , 3);
		pane.add(btexit,1 , 4);
		pane.add(wlcm,1 , 5);
		pane.setAlignment(Pos.BOTTOM_CENTER);
		pane.setStyle("-fx-background-color: #EBF7FF");
		bt1.setPrefWidth(180); //button size
		bt2.setPrefWidth(180);
		btgal.setPrefWidth(180); //button size
		btexit.setPrefWidth(180);
		
		
		bt1.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		bt2.setStyle("-fx-text-fill: White;-fx-background-color: #2A8CCD;-fx-font-size: 1.2em; ");
		btgal.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btexit.setStyle("-fx-text-fill: White;-fx-background-color: #2A8CCD;-fx-font-size: 1.2em; ");
	
		
		
	    pane.setVgap(15);
		
		GridPane pane1 = new GridPane();
		
		Image image = new Image(new File("img\\Animated-Kitty-Drawing.gif").toURI().toString(),280,280, false, false);
		
	    pane1.add(wlcm2, 0, 1);
	    pane1.add(space, 0, 2);
		pane1.getChildren().addAll(new ImageView(image));
	    pane1.setAlignment(Pos.CENTER);
	    
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(pane1);
	    borderPane.setBottom(pane);
	    BorderPane.setAlignment(pane1, Pos.CENTER);
	    
	    pane1.setStyle("-fx-background-color: #EBF7FF");
	    
	    
	    //Process events
	    btexit.setOnAction(e ->{
	    try{ 
	    		System.exit(0);
	    }
	    catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
	    });
	    bt1.setOnAction(e ->{try{ Introduction toIntro=new Introduction();toIntro.start(primaryStage); //back to start page
	    }
	    
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });	
	    bt2.setOnAction(e ->{try{ quiz1 toquiz1=new quiz1();toquiz1.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
	    });
	    
	    btgal.setOnAction(e ->{
		    try{ 
		    	gallery toGal=new gallery(); toGal.start(primaryStage);
		    }
		    catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
		    });
	    
	    Scene scene = new Scene(borderPane,700,659);
	    
		primaryStage.setTitle("WELCOME"); // Set the stage title
		primaryStage.setScene(scene);// Place the scene in the stage
		primaryStage.show();
	    
	}
	
	
	public static void main(String[] args) {
		
	    launch(args);
	  }
}