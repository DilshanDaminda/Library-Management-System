package lk.ijse.dep.library.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.library.business.BOFactory;
import lk.ijse.dep.library.business.costom.BookManageBO;
import lk.ijse.dep.library.dto.BookDTO;
import lk.ijse.dep.library.view.util.BookTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BookManageFormController {
    public ToggleGroup BookGroup;
    @FXML
    private ImageView btnhome;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtISBN;
    @FXML
    private JFXTextField TxtBookTitle;
    @FXML
    private JFXTextField TxtAuthor;
    @FXML
    private JFXTextField TxtPubName;
    @FXML
    private RadioButton RadioAvail;
    @FXML
    private RadioButton RadioBorrow;
    @FXML
    private TableView<BookTM> Tblbookmange;
    @FXML
    private JFXTextField TxtPubID;
    @FXML
    private Label BtnHome;
    @FXML
    private ImageView Btnhome;
    @FXML
    private JFXButton BtnSave;
    @FXML
    private JFXButton Btndelete;
    @FXML
    private ImageView btnadd;

    private BookManageBO bookManageBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.BOOK_MANAGE);

    public void initialize() throws Exception {

        RadioAvail.setUserData("Available");
        RadioBorrow.setUserData("Borrowed");

        Tblbookmange.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bookid"));
        Tblbookmange.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        Tblbookmange.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        Tblbookmange.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("pubid"));
        Tblbookmange.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("availability"));

        List<BookDTO> bookdb = bookManageBO.getBook();
        ObservableList <BookDTO> bookDTOS = FXCollections.observableArrayList(bookdb);
        ObservableList <BookTM> tblbookitems = FXCollections.observableArrayList();
        for (BookDTO bookDTO : bookDTOS) {
            tblbookitems.add(new BookTM(bookDTO.getBookid(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getPubid(),bookDTO.getAvailability()));
        }
        Tblbookmange.setItems(tblbookitems);
        Tblbookmange.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTM>() {
            @Override
            public void changed(ObservableValue<? extends BookTM> observable, BookTM oldValue, BookTM newValue) {
                if (newValue == null) {
                    return;
                }
                txtISBN.setText(newValue.getBookid());
                TxtBookTitle.setText(newValue.getTitle());
                TxtAuthor.setText(newValue.getAuthor());
                TxtPubID.setText(newValue.getPubid());
                txtISBN.setDisable(true);

                BtnSave.setDisable(false);

            }
        });
    }





    public void Save(ActionEvent actionEvent) throws Exception {
        if (txtISBN.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "ISBN is Empty", ButtonType.OK).showAndWait();
            txtISBN.requestFocus();
            return;
        } else if (TxtBookTitle.getText().trim().isEmpty()) {

            new Alert(Alert.AlertType.ERROR, "Book Title empty", ButtonType.OK).showAndWait();
            TxtBookTitle.requestFocus();
            return;
        } else if (TxtAuthor.getText().trim().isEmpty()) {

            new Alert(Alert.AlertType.ERROR, "Book Author empty", ButtonType.OK).showAndWait();
            TxtAuthor.requestFocus();
            return;
        }
        if (Tblbookmange.getSelectionModel().isEmpty()) {
            //new
            ObservableList<BookTM> bookitem = Tblbookmange.getItems();
            for (BookTM bookTM : bookitem) {
              //if ((txtISBN.getText()).equals(bookTM.getBookid())) {
                if((txtISBN.getText().equals(bookTM.getBookid()))){

                    new Alert(Alert.AlertType.ERROR, "Duplicate ISBN Not Allowed", ButtonType.OK).showAndWait();

                    txtISBN.requestFocus();
                    return;
                }
            }



            BookTM bookTM = new BookTM(txtISBN.getText(), TxtBookTitle.getText(), TxtAuthor.getText(), TxtPubID.getText(), BookGroup.getSelectedToggle().getUserData().toString());
            Tblbookmange.getItems().add(bookTM);
            BookDTO bookDTO = new BookDTO(txtISBN.getText(), TxtBookTitle.getText(), TxtAuthor.getText(), TxtPubID.getText(), BookGroup.getSelectedToggle().getUserData().toString());
            boolean reslt = bookManageBO.createBook(bookDTO);

            if (reslt) {


                new Alert(Alert.AlertType.INFORMATION, "Successfully Saved", ButtonType.OK).showAndWait();
                Tblbookmange.scrollTo(bookTM);
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save!", ButtonType.OK).showAndWait();
            }
        }
        else {
       //update
            BookTM sectedbook = Tblbookmange.getSelectionModel().getSelectedItem();
            sectedbook.setTitle(TxtBookTitle.getText());
            sectedbook.setAuthor(TxtAuthor.getText());
            sectedbook.setPubid(TxtPubID.getText());
              sectedbook.setAvailability(BookGroup.getSelectedToggle().getUserData().toString());

            String selctisbn = Tblbookmange.getSelectionModel().getSelectedItem().getBookid();
            boolean result = bookManageBO.updateupdate(new BookDTO(txtISBN.getText(), TxtBookTitle.getText(), TxtAuthor.getText(), TxtPubID.getText(), BookGroup.getSelectedToggle().getUserData().toString()));
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Book has been updated successfully", ButtonType.OK).showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Book", ButtonType.OK).showAndWait();
            }
        }

       }


    public void delete(ActionEvent actionEvent) throws Exception {
        Alert cofirmMsg = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete this Book?",ButtonType.OK,ButtonType.NO);
        Optional<ButtonType> buttonType = cofirmMsg.showAndWait();

        if(buttonType.get()== ButtonType.YES){

            String selectedbook = Tblbookmange.getSelectionModel().getSelectedItem().getBookid();

            Tblbookmange.getItems().remove(Tblbookmange.getSelectionModel().getSelectedItem());
            boolean rslt = bookManageBO.deleteBook(selectedbook );
            if(!rslt){
                new Alert(Alert.AlertType.ERROR,"Failed to Delete",ButtonType.OK).showAndWait();


            }else {
                reset();
            }
        }


    }

    public void NewAdd(MouseEvent mouseEvent) {
        reset();

    }

    private void reset(){
      txtISBN.clear();
      TxtPubID.clear();
      TxtAuthor.clear();
      TxtPubName.clear();
      TxtBookTitle.clear();
      BtnSave.setDisable(false);
      Btndelete.setDisable(true);
      Tblbookmange.getSelectionModel().clearSelection();



    }
    public void homego(MouseEvent mouseEvent) {
    }

    public void Home(MouseEvent mouseEvent) throws IOException {

    }

    public void dashboard(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/DashboardForm.fxml"));
        Scene scene = new Scene(load);
        Stage mainstage = (Stage) root.getScene().getWindow();
        mainstage.setScene(scene);

    }


}
