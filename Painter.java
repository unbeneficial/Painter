import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.layout.BorderPane; 
import javafx.scene.canvas.Canvas; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.canvas.GraphicsContext; 
import javafx.scene.paint.Paint; 
import javafx.event.EventHandler; 
import javafx.scene.paint.Color; 
import javafx.scene.control.ColorPicker; 

/**
 * @author <em>Benjamin Wang</em>
 */

public class Painter extends Application {
  
  static private final int value = 10;
  
  public void start(Stage primaryStage) {
    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane);
    Canvas canvas = new Canvas(500.0, 500.0);
    ColorPicker picker = new ColorPicker(Color.BLACK); 
    
    pane.setCenter(canvas);
    pane.setTop(picker); 
    primaryStage.setScene(scene); 
    primaryStage.show();
    canvas.setOnMouseDragged(new EventHandler<MouseEvent>() { 
      public void handle(MouseEvent e) {
        canvas.getGraphicsContext2D().setFill(picker.getValue());
        canvas.getGraphicsContext2D().fillOval(e.getX(), e.getY(),value ,value);
      } 
    });
  }
  
 
  
  public static void main(String[] args) { 
    Application.launch(args); 
  }
  
}