import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApprovalScreen extends Application {

    private Immigrant tempImmigrant; // Temporary Immigrant object for testing

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Temporary Immigrant object
        tempImmigrant = new Immigrant("John Doe", 123456789, "Jane Doe");
        tempImmigrant.setComplete(true);
        tempImmigrant.setValidAN(true);

        
        primaryStage.setTitle("Immigration Approval Screen");

        // GridPane for layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Labels for Immigrant data
        Label nameLabel = new Label("Name: " + tempImmigrant.getName());
        Label anLabel = new Label("Alien Number: " + tempImmigrant.getAN());
        Label relativeNameLabel = new Label("Relative's Name: " + tempImmigrant.getRelativeName());
        Label statusLabel = new Label("Status: " + (tempImmigrant.getComplete() ? "Complete" : "Incomplete"));
        Label validANLabel = new Label("Valid AN: " + (tempImmigrant.getValidAN() ? "Yes" : "No"));
        
        // Adding labels to grid
        grid.add(nameLabel, 0, 0);
        grid.add(anLabel, 0, 1);
        grid.add(relativeNameLabel, 0, 2);
        grid.add(statusLabel, 0, 3);
        grid.add(validANLabel, 0, 4);

        // Approval and send back buttons
        Button btnApprove = new Button("Approve");
        Button btnSendBack = new Button("Send Back");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnApprove);
        hbBtn.getChildren().add(btnSendBack);
        grid.add(hbBtn, 0, 5);

        // Button actions
        btnApprove.setOnAction(e -> handleApprove());
        btnSendBack.setOnAction(e -> handleSendBack());

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleApprove() {
        // Logic to approve the immigrant data
        // This would include validation and sending email
        System.out.println("Approved!");
    }

    private void handleSendBack() {
        // Logic to send back the immigrant form for review
        System.out.println("Sent Back!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}