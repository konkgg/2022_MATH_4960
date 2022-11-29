import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
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
   private Label notableProperties;

   @FXML
   private CheckBox savedCheckBox;

   @FXML
   private CheckBox sortedCheckBox;

   @FXML
   private CheckBox sumsEqualCheckBox;

   @FXML
   private TextArea textDisplay;

   @FXML
   private VBox topVBox;


   @FXML
    void handleButtonLoad(ActionEvent event) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open a csv Config File");
      fileChooser.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("CSV", "*.csv")
      );
      File file = fileChooser.showOpenDialog(null);
      
      if (file != null)
      {
         // remember to create another constructor for config that works off file path so files can be in different directories
         currentConfig = new Configuration(file);
         textDisplay.setText(currentConfig.DisplayMethod());
      }
      else
      {
         //give scary error window
         noFile();
      }
      sortedCheckBox.setSelected(currentConfig.sorted());
      sumsEqualCheckBox.setSelected(currentConfig.rowSumIsEqual());
      savedCheckBox.setSelected(true);
   }

   @FXML
    void handleButtonSave(ActionEvent event) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Find a Home for a Config");
      fileChooser.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("CSV", "*.csv")
      );
      File file = fileChooser.showSaveDialog(null);
      if (file != null)
      {
         currentConfig.SaveConfigMethod(file.getName(),(file.getAbsolutePath()).substring(0,file.getAbsolutePath().length() - (file.getName()).length() - 1));
      }
      else
      {
         //Scary error 2 the electric boogaloo
         noFile();
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
         noFile();
      }
   }

   void noFile()
   {
      Alert a = new Alert(AlertType.WARNING);
      a.setHeaderText("Failed to Select File");
      a.setContentText("Action Canceled. Please Select a .csv File");
      a.show();
   }


}
