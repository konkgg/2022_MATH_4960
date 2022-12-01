import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ConfigViewerMainFXMLController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button createConfigButton;

    @FXML
    private MenuItem githubButton;

    @FXML
    private Button loadConfigButton;

    @FXML
    private MenuItem loadMenuButton;

    @FXML
    private MenuItem saveMenuButton;

    @FXML
    void handleConfigButton(ActionEvent event) throws IOException{
        loadScene("ConfigViewerConfigLoadedFXML.fxml");
    }

    @FXML
    void handleCreateConfigButton(ActionEvent event) throws IOException{
    }

    @FXML
    void handleGithubButton(ActionEvent event) {
        Desktop computer = java.awt.Desktop.getDesktop();
        try
        {
            computer.browse(new URI("https://github.com/ksturdivantwilson/2022_MATH_4960"));
        }
        catch(URISyntaxException e)
        {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Failed to Find website");
            a.setContentText("Action Canceled. Please try again later or email me: ksturdivantwilson@daltonstate.edu");
            a.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void handleLoadMenuButton(ActionEvent event) {

    }

    @FXML
    void handleSaveMenuButton(ActionEvent event) {

    }

    void loadScene(String fxmlFile)
    {
        FXMLLoader loader = new FXMLLoader();
        try
        {
        loader.setLocation(getClass().getResource(fxmlFile));
        Parent pane = loader.load();
        borderPane.setCenter(pane);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}