module me.tjens23.searchandreplace {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.tjens23.searchandreplace to javafx.fxml;
    exports me.tjens23.searchandreplace;
}