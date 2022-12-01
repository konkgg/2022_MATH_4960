import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class Main extends Application {
	public void start(Stage primaryStage) throws IOException{
         Pane root = (Pane)FXMLLoader.load(getClass().getResource("ConfigViewerMainFXML.fxml"));
			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ConfigViewer");
			primaryStage.show();
	}
    public static void main(String[] args) {
        launch(args);
    }
}

