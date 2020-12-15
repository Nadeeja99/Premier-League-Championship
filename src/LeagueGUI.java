import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import java.util.Random;

public class LeagueGUI {

    public void tableView(List<FootballClub> footballLeague,List<Match> matchDetails){

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
        colMatchesPlayed.setMinWidth(50);

        TableColumn<FootballClub, String> colWins = new TableColumn<>("Wins");
        colWins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        colWins.setMinWidth(50);

        TableColumn<FootballClub, String> colDraws = new TableColumn<>("Draws");
        colDraws.setCellValueFactory(new PropertyValueFactory<>("draws"));
        colDraws.setMinWidth(50);

        TableColumn<FootballClub, String> colDefeats = new TableColumn<>("Defeats");
        colDefeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));
        colDefeats.setMinWidth(50);

        TableColumn<FootballClub, String> colScoredGoals = new TableColumn<>("Goals Scored");
        colScoredGoals.setCellValueFactory(new PropertyValueFactory<>("noOfScoredGoals"));
        colScoredGoals.setMinWidth(50);

        TableColumn<FootballClub, String> colReceivedGoals = new TableColumn<>("Goals Received");
        colReceivedGoals.setCellValueFactory(new PropertyValueFactory<>("noOfReceivedGoals"));
        colReceivedGoals.setMinWidth(50);

        TableColumn<FootballClub, String> colPoints = new TableColumn<>("Points");
        colPoints.setCellValueFactory(new PropertyValueFactory<>("noOfPoints"));
        colPoints.setMinWidth(50);

        table.getColumns().addAll(colClub,colMatchesPlayed,colWins,colDraws,colDefeats,colScoredGoals,colReceivedGoals,colPoints);
        table.setMaxSize(612, 220);

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

        Button btnMatchGen = new Button();
        btnMatchGen.setText("Match Generator");
        btnMatchGen.setLayoutX(350);
        btnMatchGen.setLayoutY(320);
        btnMatchGen.setMinSize(50,30);

        btnMatchGen.setOnAction(event -> {
            matchGenerate(footballLeague,matchDetails);
            table.getItems().clear();
            Collections.sort(footballLeague, new PointComparator());
            for (FootballClub club : footballLeague){
                table.getItems().add(club);
            }
        });

        
        anchorPane.getChildren().addAll(txtHead,txtPointTable,table,btnScoredGoalsSort,btnWinSort,btnMatchGen);
        Stage stage = new Stage();

        //create a scene with anchorPane as the root
        Scene scene = new Scene(anchorPane, 700, 450);

        //configure the stage,set the scene and display
        stage.setTitle("Football League");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void matchGenerate(List<FootballClub> footballLeague,List<Match> matchDetails){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-base: #f5e35b;");

        Random rand = new Random();

        int club1 = 0;
        int club2 = 0;

        while (club1 == club2){
            club1 = rand.nextInt(footballLeague.size());
            club2 = rand.nextInt(footballLeague.size());
        }

        int club1Score = rand.nextInt(7);
        int club2Score = rand.nextInt(7);
        int day = 1 + rand.nextInt(31);
        int month = 1 + rand.nextInt(13);
        int year = 2020;
        Date matchDate = new Date(day, month, year);

        Match match = new Match(footballLeague.get(club1), footballLeague.get(club2), club1Score, club2Score, matchDate);
        matchDetails.add(match);

        // add new stats to the previous stats
        footballLeague.get(club1).setNoOfScoredGoals(footballLeague.get(club1).getNoOfScoredGoals() + club1Score);
        footballLeague.get(club2).setNoOfScoredGoals(footballLeague.get(club2).getNoOfScoredGoals() + club2Score);
        footballLeague.get(club1).setNoOfReceivedGoals(footballLeague.get(club1).getNoOfReceivedGoals() + club2Score);
        footballLeague.get(club2).setNoOfReceivedGoals(footballLeague.get(club2).getNoOfReceivedGoals() + club1Score);
        footballLeague.get(club1).setNoOfMatchesPlayed(footballLeague.get(club1).getNoOfMatchesPlayed() + 1);
        footballLeague.get(club2).setNoOfMatchesPlayed(footballLeague.get(club2).getNoOfMatchesPlayed() + 1);

        if (club1Score > club2Score) {
            footballLeague.get(club1).setNoOfPoints(footballLeague.get(club1).getNoOfPoints() + 2);
            footballLeague.get(club1).setWins(footballLeague.get(club1).getWins() + 1);
            footballLeague.get(club2).setDefeats(footballLeague.get(club2).getDefeats() + 1);

        } else if (club1Score < club2Score) {
            footballLeague.get(club2).setNoOfPoints(footballLeague.get(club2).getNoOfPoints() + 2);
            footballLeague.get(club2).setWins(footballLeague.get(club2).getWins() + 1);
            footballLeague.get(club1).setDefeats(footballLeague.get(club1).getDefeats() + 1);

        } else {
            footballLeague.get(club1).setNoOfPoints(footballLeague.get(club1).getNoOfPoints() + 1);
            footballLeague.get(club2).setNoOfPoints(footballLeague.get(club2).getNoOfPoints() + 1);
            footballLeague.get(club1).setDraws(footballLeague.get(club1).getDraws() + 1);
            footballLeague.get(club2).setDraws(footballLeague.get(club2).getDraws() + 1);
        }

        Text txtHead = new Text();
        txtHead.setText("Football Premier League 2020");
        txtHead.setLayoutY(30);
        txtHead.setLayoutX(80);
        txtHead.setFill(Color.valueOf("#2e2396"));
        txtHead.setFont(Font.font("Franklin Gothic Heavy", 20));
        txtHead.setStyle("-fx-font-weight: bold");

        Text txtMatch = new Text();
        txtMatch.setText(footballLeague.get(club1).getName() + " vs " + footballLeague.get(club2).getName());
        txtMatch.setLayoutY(60);
        txtMatch.setLayoutX(110);
        txtMatch.setFill(Color.valueOf("#32ad36"));
        txtMatch.setFont(Font.font("Franklin Gothic Heavy", 18));
        txtMatch.setStyle("-fx-font-weight: bold");

        Text txtDate = new Text();
        txtDate.setText(String.valueOf(matchDate));
        txtDate.setLayoutY(90);
        txtDate.setLayoutX(30);
        txtDate.setFill(Color.valueOf("#212124"));
        txtDate.setFont(Font.font("Franklin Gothic Heavy", 12));
        txtDate.setStyle("-fx-font-weight: bold");

        Text txtClub1 = new Text();
        txtClub1.setText(footballLeague.get(club1).getName());
        txtClub1.setLayoutY(130);
        txtClub1.setLayoutX(70);
        txtClub1.setFill(Color.valueOf("#4951eb"));
        txtClub1.setFont(Font.font("Franklin Gothic Heavy", 18));
        txtClub1.setStyle("-fx-font-weight: bold");

        Text txtClub1Score = new Text();
        txtClub1Score.setText(String.valueOf(club1Score));
        txtClub1Score.setLayoutY(160);
        txtClub1Score.setLayoutX(100);
        txtClub1Score.setFill(Color.valueOf("#d6230f"));
        txtClub1Score.setFont(Font.font("Franklin Gothic Heavy", 18));
        txtClub1Score.setStyle("-fx-font-weight: bold");

        Text txtHyphen = new Text();
        txtHyphen.setText("-");
        txtHyphen.setLayoutY(160);
        txtHyphen.setLayoutX(190);
        txtHyphen.setFill(Color.valueOf("#d6230f"));
        txtHyphen.setFont(Font.font("Franklin Gothic Heavy", 18));
        txtHyphen.setStyle("-fx-font-weight: bold");

        Text txtClub2 = new Text();
        txtClub2.setText(footballLeague.get(club2).getName());
        txtClub2.setLayoutY(130);
        txtClub2.setLayoutX(240);
        txtClub2.setFill(Color.valueOf("#4951eb"));
        txtClub2.setFont(Font.font("Franklin Gothic Heavy", 18));
        txtClub2.setStyle("-fx-font-weight: bold");

        Text txtClub2Score = new Text();
        txtClub2Score.setText(String.valueOf(club2Score));
        txtClub2Score.setLayoutY(160);
        txtClub2Score.setLayoutX(270);
        txtClub2Score.setFill(Color.valueOf("#d6230f"));
        txtClub2Score.setFont(Font.font("Franklin Gothic Heavy", 18));
        txtClub2Score.setStyle("-fx-font-weight: bold");

        Button btnOk = new Button();
        btnOk.setText("Ok");
        btnOk.setLayoutY(180);
        btnOk.setLayoutX(360);
        btnOk.setMinSize(50,30);

        btnOk.setOnAction(event -> {
            Stage stageClose = (Stage) btnOk.getScene().getWindow();
            stageClose.close();
        });


        anchorPane.getChildren().addAll(txtHead,txtMatch,txtDate,txtClub1,txtClub1Score,txtHyphen,txtClub2Score,txtClub2,btnOk);
        Stage stage = new Stage();

        //create a scene with anchorPane as the root
        Scene scene = new Scene(anchorPane, 440, 230);

        //configure the stage,set the scene and display
        stage.setTitle("Match Details");
        stage.setScene(scene);
        stage.showAndWait();

    }
}
