package VacMan.game;

import VacMan.game.*;

/**
 * VacMan ist unsere Main Klasse die das Spiel und somit die MVC Klassen initialisiert.
 * @author Marius
 *
 */
public class VacMan {
	public static void main(String[] args) {
		View view = new View(initFieldLevel1);
		Model model = new Model();
		Controller controller = new Controller(view, model);
	}

}
