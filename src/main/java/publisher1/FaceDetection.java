package publisher1;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


/**
 * The main class for a JavaFX application. It creates and handle the main
 * window with its resources (style, graphics, etc.).
 * <p>
 * This application handles a video stream and try to find any possible human
 * face in a frame. It can use the Haar or the LBP classifier.
 */
public class FaceDetection extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // load the FXML resource
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("FXView.fxml"));
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/FXHelloCV.fxml"));
            // store the root element so that the controllers can use it
            BorderPane root = (BorderPane) loader.load();            // set a whitesmoke background
            root.setStyle("-fx-background-color: whitesmoke;");
            // create and style a scene
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
            // create the stage with the given title and the previously created
            // scene
            primaryStage.setTitle("Face Detection and Tracking");
            primaryStage.setScene(scene);
            // show the GUI
            primaryStage.show();

            // init the controller
            FXCameraController controller = loader.getController();
            controller.init();

            // set the proper behavior on closing the application
            primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    controller.setClosed();
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        // load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        launch(args);
    }
}
