import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;

public class ConfigViewerController {
    
   private Configuration currentConfig;
    
   @FXML
    private Button Save;

   @FXML
    private Button buttonLoad;

   @FXML
    private Button buttonRandomize;

   @FXML
    private TextArea textDisplay;

   @FXML
    void handleButtonLoad(ActionEvent event) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open a csv Config File");
      File file = fileChooser.showOpenDialog(null);
      if (file != null)
      {
         // remember to create another constructor for config that works off file path so files can be in different directories
         currentConfig = new Configuration(file.getName());
         textDisplay.setText(currentConfig.DisplayMethod());
      }
      else
      {
         //give scary error window
      }
   }

   @FXML
    void handleButtonSave(ActionEvent event) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Find a Home for a Config");
      File file = fileChooser.showSaveDialog(null);
      if (file != null)
      {
         currentConfig.SaveConfigMethod(file.getName());
         
      }
      else
      {
         //Scary error 2 the electric boogaloo
      }
   
   }

   @FXML
    void handleRandomize(ActionEvent event) {
      if(currentConfig != null)
      {
         currentConfig.randomWinner();
         textDisplay.setText(currentConfig.DisplayMethod());
      }
      else
      {
         //Scary error 3 the threequel
      }
   }

}
