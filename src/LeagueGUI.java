import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;

public class LeagueGUI {

    private static LeagueManager premierLeagueManager = new PremierLeagueManager();

    public void tableView(List<FootballClub> footballLeague){

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-base: #f5e35b;");

        Text txtHead = new Text();
        txtHead.setText("Football Premier League 2020");
        txtHead.setLayoutY(25);
        txtHead.setLayoutX(200);
        txtHead.setFill(Color.valueOf("#2e2396"));
        txtHead.setFont(Font.font("Franklin Gothic Heavy", 20));
        txtHead.setStyle("-fx-font-weight: bold");

        Text txtPointTable = new Text();
        txtPointTable.setText("Point Table");
        txtPointTable.setLayoutY(50);
        txtPointTable.setLayoutX(300);
        txtPointTable.setFill(Color.valueOf("#0cb025"));
        txtPointTable.setFont(Font.font("Franklin Gothic Heavy", 20));
        txtPointTable.setStyle("-fx-font-weight: bold");

        TableView table = new TableView();
        table.setLayoutY(70);
        table.setLayoutX(30);

        TableColumn<FootballClub, String> colClub = new TableColumn<>("Club");
        colClub.setCellValueFactory(new PropertyValueFactory<>("name"));
        colClub.setMinWidth(100);

        TableColumn<FootballClub, String> colMatchesPlayed = new TableColumn<>("Matches Played");
        colMatchesPlayed.setCellValueFactory(new PropertyValueFactory<>("noOfMatchesPlayed"));
        colMatchesPlayed.setMinWidth(60);

        TableColumn<FootballClub, String> colWins = new TableColumn<>("Wins");
        colWins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        colWins.setMinWidth(60);

        TableColumn<FootballClub, String> colDraws = new TableColumn<>("Draws");
        colDraws.setCellValueFactory(new PropertyValueFactory<>("draws"));
        colDraws.setMinWidth(60);

        TableColumn<FootballClub, String> colDefeats = new TableColumn<>("Defeats");
        colDefeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));
        colDefeats.setMinWidth(60);

        TableColumn<FootballClub, String> colScoredGoals = new TableColumn<>("Goals Scored");
        colScoredGoals.setCellValueFactory(new PropertyValueFactory<>("noOfScoredGoals"));
        colScoredGoals.setMinWidth(60);

        TableColumn<FootballClub, String> colReceivedGoals = new TableColumn<>("Goals Received");
        colReceivedGoals.setCellValueFactory(new PropertyValueFactory<>("noOfReceivedGoals"));
        colReceivedGoals.setMinWidth(60);

        TableColumn<FootballClub, String> colPoints = new TableColumn<>("Points");
        colPoints.setCellValueFactory(new PropertyValueFactory<>("noOfPoints"));
        colPoints.setMinWidth(60);

        table.getColumns().addAll(colClub,colMatchesPlayed,colWins,colDraws,colDefeats,colScoredGoals,colReceivedGoals,colPoints);
        table.setMaxSize(635, 220);

        Collections.sort(footballLeague, new PointComparator());
        for (FootballClub club : footballLeague){
            table.getItems().add(club);
        }

        Button btnScoredGoalsSort = new Button();
        btnScoredGoalsSort.setText("Sort by Scored Goals");
        btnScoredGoalsSort.setLayoutX(45);
        btnScoredGoalsSort.setLayoutY(320);
        btnScoredGoalsSort.setMinSize(50,30);

        btnScoredGoalsSort.setOnAction(event -> {
            table.getItems().clear();
            Collections.sort(footballLeague, new ScoredGoalsComparator());
            for (FootballClub club : footballLeague){
                table.getItems().add(club);
            }
        });

        Button btnWinSort = new Button();
        btnWinSort.setText("Sort by Win Count");
        btnWinSort.setLayoutX(200);
        btnWinSort.setLayoutY(320);
        btnWinSort.setMinSize(50,30);

        btnWinSort.setOnAction(event -> {
            table.getItems().clear();
            Collections.sort(footballLeague, new WinCountComparator());
            for (FootballClub club : footballLeague){
                table.getItems().add(club);
            }
        });

        
        anchorPane.getChildren().addAll(txtHead,txtPointTable,table,btnScoredGoalsSort,btnWinSort);
        Stage stage = new Stage();

        //create a scene with anchorPane as the root
        Scene scene = new Scene(anchorPane, 700, 450);

        //configure the stage,set the scene and display
        stage.setTitle("Football League");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
