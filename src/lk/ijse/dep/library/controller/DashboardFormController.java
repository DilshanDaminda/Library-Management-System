package lk.ijse.dep.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private ImageView root1;
    @FXML
    private ImageView root;
    @FXML
    private ImageView BookId;
    @FXML
    private ImageView ReturnId;
    @FXML
    private ImageView BorrowId;
    @FXML
    private ImageView MemberId;

    public void bookmanage(MouseEvent mouseEvent) throws IOException {

        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/BookManageForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root1.getScene().getWindow();
        mainstage.setScene(scene);
    }

    public void Return(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/ReturnManageForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root1.getScene().getWindow();
        mainstage.setScene(scene);
    }

    public void Borrow(MouseEvent mouseEvent) throws IOException
    { Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/BorrowManageForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root1.getScene().getWindow();
        mainstage.setScene(scene);
    }

    public void membermanage(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/MemberManageForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root1.getScene().getWindow();
        mainstage.setScene(scene);
    }
}
