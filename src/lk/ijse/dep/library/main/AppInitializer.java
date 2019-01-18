package lk.ijse.dep.library.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/DashboardForm.fxml"));
          Scene scene = new Scene(load);
          primaryStage.setTitle("Library Management System");
          primaryStage.setScene(scene);
          primaryStage.show();
    }
}
