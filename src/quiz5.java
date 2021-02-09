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
public class quiz5 extends Application{
	
	Button ans1 = new Button("  NO  ");
	Button ans2 = new Button("YES");
	Button ans3 = new Button("Finish");
	Label lb1 = new Label("Fun Facts Mini Quiz");
	Label lb2 = new Label("Do cats dream while they sleep?");
	Label lb3 = new Label("Correct Answer");
	Label lb4 = new Label("Incorrect Answer");
	
	
	
	public void start(Stage primaryStage) {
		
		Image image = new Image(new File("img\\quiz5.gif").toURI().toString(),380,190, false, false);
		
		
		VBox vBox= new VBox();
		ans1.setStyle("-fx-background-color: black;-fx-text-fill: White;-fx-font-size: 1.2em;");
		ans2.setStyle("-fx-background-color: black;-fx-text-fill: White;-fx-font-size: 1.2em;");
		ans3.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		ans1.setPrefWidth(220); //button size
		ans2.setPrefWidth(220);
		ans3.setPrefWidth(100);
		lb1.setStyle("-fx-text-fill: black;-fx-font-size: 3.2em;-fx-font-weight: bold;");
		lb2.setStyle("-fx-text-fill: grey;-fx-font-size: 2.2em;-fx-font-weight: bold;");
		lb3.setStyle("-fx-text-fill: green;-fx-font-size: 2.2em;-fx-font-weight: bold;");
		lb4.setStyle("-fx-text-fill: red;-fx-font-size: 2.2em;-fx-font-weight: bold;");
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(lb1);
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new ImageView(image));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(lb2);
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(ans1);
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(ans2);
		vBox.getChildren().add(new Label(" "));
		vBox.setStyle("-fx-background-color: #EBF7FF");
		
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(vBox);
	    BorderPane.setAlignment(vBox, Pos.CENTER);
	    
	    
	    ans1.setOnAction(e ->{
		try{ 
			vBox.getChildren().add(new Label(" "));
			vBox.getChildren().add(lb4);
			vBox.getChildren().add(new Label(" "));
			vBox.getChildren().add(ans3); 
		}
		catch(Exception ex){Logger.getLogger(Introduction.class.getName()).log(null);}
		});
	    ans2.setOnAction(e ->{try{ 
	    	FileReader freader = new FileReader("result.txt");
    		BufferedReader br = new BufferedReader(freader);
    		String s;
    		int i = 0;
    		while((s = br.readLine()) != null) {
    		i = Integer.parseInt(s);
    		}
    		
    		br.close();
    		freader.close();
			FileWriter writer = new FileWriter("result.txt");
		      int n = i+1;
		      for (int i2 = 0; i2 < 1; i2++) {
		         writer.write(n +"");
		      }
		    writer.close();
	    vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(lb3); 
		vBox.getChildren().add(new Label(" "));
		vBox.getChildren().add(ans3); 
	    }
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });
	    
	    ans3.setOnAction(e ->{try{ 
	    	result res=new result();
	
	    	res.start(primaryStage);
		    }
		    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
		    });
	   
		Scene scene = new Scene(borderPane,700,636);
		primaryStage.setTitle("FUN FACTS MINI QUIZ");
		primaryStage.setScene(scene);
		primaryStage.show();
	    
	}
	
	public static void main(String[] args) {	
	    launch(args);
	  }

}