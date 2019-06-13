package Controllers;

import Models.ConnectionMethods;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

    private final String user = "phase";
    private final String pass = "11297ss99ro230";

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ImageView imageView;

    @FXML
    private void loginButtonPressed(ActionEvent event) {
        String user = userTextField.getText();
        String pass = passTextField.getText();

        if (user.equals(this.user) && pass.equals(this.pass)) {
            ConnectionMethods.user = "phase";
            ConnectionMethods.pass = "passcross";

            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Sesi�n iniciada");
            dialog.setContentText("Ha iniciado sesi�n correctamente.");
            dialog.setHeaderText(null);
            dialog.showAndWait();

            Stage stage = (Stage) (imageView.getScene().getWindow());
            stage.close();

        } else {

            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error de inicio de sesi�n");
            dialog.setHeaderText(null);
            dialog.setContentText("Los datos son incorrectos.");
            dialog.showAndWait();

        }
    }

    @FXML
    private void cancelButtonPressed(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void initialize() {
        loginButton.setDisable(true);

        imageView.setImage(new Image(getClass().getResource("/Resources/login.png").toString()));

        userTextField.textProperty().addListener((observable) -> {
            if (userTextField.getText().isEmpty()) {
                loginButton.setDisable(true);
            } else {
                loginButton.setDisable(false);
            }
        });
    }

}
