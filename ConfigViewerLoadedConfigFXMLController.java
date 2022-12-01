import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;


public class ConfigViewerLoadedConfigFXMLController{

    private Configuration currentConfig;

    @FXML
    private Label notableProperties;

    @FXML
    private CheckBox sortedCheckBox;

    @FXML
    private CheckBox sumsEqualCheckBox;
    
    @FXML
    private TextArea textDisplay;
    

    @FXML
    void initialize()
    {
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

        
    }


    void noFile()
   {
      Alert a = new Alert(AlertType.WARNING);
      a.setHeaderText("Failed to Select File");
      a.setContentText("Action Canceled. Please Select a .csv File");
      a.show();
   }

}
