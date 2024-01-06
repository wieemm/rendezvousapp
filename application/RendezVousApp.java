package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class RendezVousApp extends Application {

    private Agenda agenda;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        agenda = new Agenda();

        primaryStage.setTitle("Gestion de Rendez-vous");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label labelNom = new Label("Nom:");
        TextField textFieldNom = new TextField();

        Label labelPrenom = new Label("Prénom:");
        TextField textFieldPrenom = new TextField();

        Label labelCarteId = new Label("Numéro de carte d'identité:");
        TextField textFieldCarteId = new TextField();

        Label labelTypeDocteur = new Label("Type de docteur:");
        ChoiceBox<String> choiceBoxTypeDocteur = new ChoiceBox<>();
        choiceBoxTypeDocteur.getItems().addAll("Généraliste", "Spécialiste");

        Label labelJour = new Label("Jour de la semaine:");
        ChoiceBox<String> choiceBoxJour = new ChoiceBox<>();
        choiceBoxJour.getItems().addAll("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche");

        Label labelHoraire = new Label("Horaire:");
        ChoiceBox<String> choiceBoxHoraire = new ChoiceBox<>();
        choiceBoxHoraire.getItems().addAll("Matin (9h00 - 11h00)", "Après-midi (14h00 - 16h00)", "Soir (18h00 - 20h00)");

        Label labelLieu = new Label("Lieu:");
        TextField textFieldLieu = new TextField();
        
        Button buttonConfirmer = new Button("Confirmer");
        buttonConfirmer.setOnAction(e -> confirmerRendezVous(
                textFieldNom.getText(),
                textFieldPrenom.getText(),
                textFieldCarteId.getText(),
                choiceBoxTypeDocteur.getValue(),
                choiceBoxJour.getValue(),
                choiceBoxHoraire.getValue(), 
                textFieldLieu.getText()
        ));

        grid.add(labelNom, 0, 0);
        grid.add(textFieldNom, 1, 0);
        grid.add(labelPrenom, 0, 1);
        grid.add(textFieldPrenom, 1, 1);
        grid.add(labelCarteId, 0, 2);
        grid.add(textFieldCarteId, 1, 2);
        grid.add(labelTypeDocteur, 0, 3);
        grid.add(choiceBoxTypeDocteur, 1, 3);
        grid.add(labelJour, 0, 4);
        grid.add(choiceBoxJour, 1, 4);
        grid.add(labelHoraire, 0, 5);
        grid.add(choiceBoxHoraire, 1, 5);
        grid.add(labelLieu, 0, 6);
        grid.add(textFieldLieu, 1, 6);
        grid.add(buttonConfirmer, 0, 7, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void confirmerRendezVous(String nom, String prenom, String carteId, String typeDocteur, String jour, String horaire, String lieu) {
       
        Date date = new Date(); 
        RendezVous rendezVous = new RendezVous(date, lieu ); 

        agenda.ajouterRendezVous(rendezVous);

        System.out.println("Monsieur/Madame " + nom + " " + prenom + ", votre numéro de carte d'identité est "
                + carteId + ". Votre rendez-vous sera le " + jour + " à l'horaire " + horaire
                + " avec un " + typeDocteur + " au lieu : " + lieu);
    }
}
