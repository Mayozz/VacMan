package VacMan.game;

import java.awt.event.KeyEvent;

import VacMan.game.*;

/**
 * Der Model Part des MVC Patterns enthält die Daten, bzw. die Datenzugriffe.
 * 
 * @author Marius
 *
 */
public class Model {
	////////////// variables and constants /////////////////////
	/** The view's width. */
	public static final int WIDTH = 21;
	/** The view's height. */
	public static final int HEIGHT = 14;
	/** Distance from edge to field. */
	public static final int BEGINNING_FIELD = 10;
	/** Size of each tile to built the board. */
	public static final int TILE_SIZE = 20;
	// declaration of the array for field
	int[][] field = new int[21][14];
	// score of the game
	public static int score;
	// instance of the original board
	static int[][] currField;
	//
	private Controller vacman;
	//
	public static final int WALL = 0, PATH = 1, VACMAN = 2, VIRUS = 3, VACCINE = 4;

	/*
	 * //Starts the game with field of level one and a score of 0. public Model() {
	 * field = new Model(); score = 0; }
	 */

	public Model(int level) {
		vacman = new Controller(10, 13);
		currField = new int[21][14];

		switch (level) {
		case 1:
			initFieldLevel1();
			break;
		default:
			System.out.println("Invalid level.");
		}
		initFieldLevel1();
	}

	//////////////////////// two-dimensional array for the
	//////////////////////// board///////////////////////////
	public static int[][] initFieldLevel1() {
		int[][] fieldLevel1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0 },
				{ 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 0, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 0, 4, 0, 1, 1, 4, 3, 4, 1, 1, 0, 4, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 4, 0, 1, 0, 0, 1, 0, 0, 1, 0, 4, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 4, 0, 1, 0, 1, 1, 1, 0, 1, 0, 4, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 4, 1, 1, 0, 1, 3, 1, 0, 1, 1, 4, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 4, 0, 1, 0, 0, 0, 0, 0, 1, 0, 4, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 4, 0, 1, 1, 1, 1, 1, 1, 1, 0, 4, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 4, 0, 1, 0, 0, 0, 0, 0, 1, 0, 4, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 4, 0, 1, 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 0, 0, 0 },
				{ 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0 },
				{ 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		currField = fieldLevel1; // start with the level 1 field, but field never changes whilst the game
		currField[10][13] = VACMAN; // starting position of vacman

		return fieldLevel1;
	}

	public void moveVacman(int e) {
		switch (e) {
		case KeyEvent.VK_LEFT:
			field.VacmanLeft();
			break;

		case KeyEvent.VK_RIGHT:
			field.VacmanRight();
			break;

		case KeyEvent.VK_UP:
			field.VacmanUp();
			break;

		case KeyEvent.VK_DOWN:
			field.VacmanDown();
			break;
		}
	}

	/** Method to get the current state of the game field. */
	public int[][] currFieldSetUp() {
		return fieldLevel1.getField();
	}

}
