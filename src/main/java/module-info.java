module edu.miracosta.cs112.finalproject.finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.miracosta.cs112.finalproject.finalproject to javafx.fxml;
    exports edu.miracosta.cs112.finalproject.finalproject;
    exports edu.miracosta.cs112.finalproject.finalproject.controllers;
    opens edu.miracosta.cs112.finalproject.finalproject.controllers to javafx.fxml;
    exports edu.miracosta.cs112.finalproject.finalproject.models;
    opens edu.miracosta.cs112.finalproject.finalproject.models to javafx.fxml;
}