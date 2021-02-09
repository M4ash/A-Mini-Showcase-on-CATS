//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*; 
public class result extends Application{
	
	Button ans1 = new Button("  To Menu  ");
	Button ans2 = new Button("Exit");
	Label lb1 = new Label("YOUR QUIZ RESULT");
	Button view = new Button("View Score");
	
	  
	public void start(Stage primaryStage) {
		
		Image image = new Image(new File("img\\res.gif").toURI().toString(),250,250, false, false);
		
		
		VBox vBox= new VBox();
		ans1.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		ans2.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		
		ans1.setPrefWidth(220); //button size
		ans2.setPrefWidth(220);

		lb1.setStyle("-fx-text-fill: black;-fx-font-size: 3.2em;-fx-font-weight: bold;");
		view.setStyle("-fx-text-fill: grey;-fx-font-size: 1.9em;-fx-font-weight: bold;");
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(lb1);
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new ImageView(image));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(view);
		
		
		
		vBox.setStyle("-fx-background-color: #EBF7FF");
		
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(vBox);
	    BorderPane.setAlignment(vBox, Pos.CENTER);
	    
	    
	    
	    
	    view.setOnAction(e ->{
	    	try {
	    		FileReader freader = new FileReader("result.txt");
	    		BufferedReader br = new BufferedReader(freader);
	    		String s;
	    		int i = 0;
	    		while((s = br.readLine()) != null) {
	    		i = Integer.parseInt(s);
	    		}
	    		
	    		br.close();
	    		freader.close();
	    		Label lb2 = new Label (""+Integer.toString(i)+"/5");
	    		FileWriter writer = new FileWriter("result.txt");
			      int n = 0;
			      for (int i2 = 0; i2 < 1; i2++) {
			         writer.write(n +"");
			      }
			    writer.close();
	    		vBox.getChildren().add(new Label(" "));
	    		lb2.setStyle("-fx-text-fill: black;-fx-font-size: 3.2em;-fx-font-weight: bold;");
	    		vBox.getChildren().add(lb2);
	    		
	    		vBox.getChildren().add(ans1);
	    		vBox.getChildren().add(new Label(" "));
	    		vBox.getChildren().add(ans2);
	    		
	    }
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });
	    ans1.setOnAction(e ->{try{ StartUp toStartUp=new StartUp();toStartUp.start(primaryStage); //back to start page
	    }
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });
	    ans2.setOnAction(e ->{
		    try{ 
		    		System.exit(0);
		    		
		    }
		    catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
		    });
	   
		Scene scene = new Scene(borderPane,700,636);
		primaryStage.setTitle("RESULT");
		primaryStage.setScene(scene);
		primaryStage.show();
	    
	}
	
	public static void main(String[] args) {
		
	    launch(args);
	  }

}