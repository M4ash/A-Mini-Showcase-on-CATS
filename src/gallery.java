import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import java.io.File;
import java.util.logging.Logger;
import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class gallery extends Application {

	Button btback = new Button("To Menu ");
	Button btex = new Button("EXIT");
	Label l1 = new Label("\t\t\t  INTRODUCTION ON CATS");

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		btback.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btex.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		ScrollBar sy = new ScrollBar();
		sy.setMin(0);
		sy.setMax(500);
		sy.setValue(100);
		sy.setOrientation(Orientation.VERTICAL);
		sy.setTranslateY(2);
		sy.setPrefHeight(659);
	    sy.setPrefWidth(20);
	    
	    ScrollBar sx = new ScrollBar();
		sx.setMin(0);
		sx.setMax(500);
		sx.setValue(100);
		sx.setOrientation(Orientation.HORIZONTAL);
		sx.setTranslateX(2);
		sx.setPrefHeight(20);
	    sx.setPrefWidth(800);
		
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	  
	    btex.setPrefWidth(100);
	    btback.setPrefWidth(100);
	    hBox.getChildren().addAll(btback,btex);
	    
	    GridPane gp = new GridPane();
	   
		
		GridPane pane2 = new GridPane();
		pane2.setStyle("-fx-background-color: #EBF7FF");
		pane2.setVgap(10);
		pane2.setHgap(10);
		pane2.add(new ImageView(new Image(new File("img\\c1.png").toURI().toString(),280,280, false, false)),0,0);
		
		pane2.add(new ImageView(new Image(new File("img\\c2.png").toURI().toString(),280,280, false, false)),1,0);
		
		pane2.add(new ImageView(new Image(new File("img\\c3.png").toURI().toString(),280,280, false, false)),2,0);
		
	
		pane2.add(new ImageView(new Image(new File("img\\c4.png").toURI().toString(),280,280, false, false)),0,1);
		
		
		pane2.add(new ImageView(new Image(new File("img\\c5.png").toURI().toString(),280,280, false, false)),1,1);
		
	
		pane2.add(new ImageView(new Image(new File("img\\c6.png").toURI().toString(),280,280, false, false)),2,1);
		
		
		pane2.add(new ImageView(new Image(new File("img\\c7.png").toURI().toString(),280,280, false, false)),0,2);
		
	
		pane2.add(new ImageView(new Image(new File("img\\c8.png").toURI().toString(),280,280, false, false)),1,2);
		
		
		sy.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
	         gp.setLayoutY(-new_val.doubleValue());
	      });
		sx.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
	         gp.setLayoutX(-new_val.doubleValue());
	      });
		
		btex.setOnAction(e ->{
		    try{ 
		    		System.exit(0);
		    }
		    catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
		    });
		
		btback.setOnAction(e ->{try{ StartUp toStartUp=new StartUp();toStartUp.start(primaryStage); //back to start page
	    }
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });
		
		Group root = new Group();
	    root.getChildren().addAll(pane2, sy, sx);
	    
	    gp.add(root, 0, 1);
	    gp.add(hBox, 0, 0);
	    Scene scene = new Scene(gp, 725, 659);
		
		primaryStage.setTitle("Photo Gallery");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
