package VacMan.game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import VacMan.game.*;

/**
 * Der Controller Part der MVC Pattern enthält die Steuer Elemente mit der man
 * Daten aus dem Model und die grafische Oberfläche aus der View steuert und
 * updated.
 * 
 * @author Marius
 *
 */
public class Controller implements KeyListener {

	/** The world that is updated upon every key press. */
	private Model model;
	private View view;

	/**
	 * Creates a new instance.
	 * 
	 * @param world the world to be updated whenever Nick should move.
	 */
	public Controller(View view, Model model) {
		view = view;
		model = model;
		view.loadField(model.currFieldSetUp());
		view.setVisible(true);
		view.setBoardListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			model.moveVacman(KeyEvent.VK_LEFT);
			view.updateViews();
		}
		if (key == KeyEvent.VK_RIGHT) {
			model.moveVacman(KeyEvent.VK_RIGHT);
			view.updateViews();
		}
		if (key == KeyEvent.VK_UP) {
			model.moveVacman(KeyEvent.VK_UP);
			view.reBoard();
		}
		if (key == KeyEvent.VK_DOWN) {
			model.moveVacman(KeyEvent.VK_DOWN);
			view.updateViews();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private Point position;

	public Controller(int x, int y) {
		position = new Point(x, y);
	}

	public int getX() {
		return position.x;
	}

	public int getY() {
		return position.y;
	}

	public void moveVacman(int x, int y) {
		position.setLocation(x, y);
	}

	/** Method to add the different characters to new places on the field. */
	public void addThing(int x, int y, int thing) {
		currField[x][y] = thing;
	}

	/** Checks if vacman can move to the given place. */
	public boolean isChangeValid(int thing1, int thing2) {
		if (thing1 == WALL || thing2 == WALL) {
			return false;
		}
		return true;
	}

	public void changePositions(int x1, int y1, int thing1, int x2, int y2, int thing2) {
		// implement conditions
	}

	/** Deletes the character from its old place and makes this place a path. */
	public void deleteThing(int x, int y) {
		currField[x][y] = PATH;
	}

	public int[][] getField() {
		return currField;
	}

	/** Adds the vaccines to randomized places on the game filed. */
	public void randVaccines() {
		int x, y;
		Random rand = new Random();

		do {
			x = rand.nextInt(21);
			y = rand.nextInt(14);
		}

		while (currField[x][y] != PATH);
		currField[x][y] = VACCINE;
	}

	public void VacmanLeft() {
		int vacX = vacman.getX();
		int vacY = vacman.getY();
		if (currField[vacX][vacY - 1] != WALL) {
			currField[vacX][vacY] = PATH;
			currField[vacX][vacY - 1] = VACMAN;
			vacman.moveVacman(vacX, vacY - 1);
			View view = new View(currField);
			view.update();
		}
	}

	public void VacmanRight() {
		int vacX = vacman.getX();
		int vacY = vacman.getY();
		if (currField[vacX][vacY + 1] != WALL) {
			currField[vacX][vacY] = PATH;
			currField[vacX][vacY + 1] = VACMAN;
			vacman.moveVacman(vacX, vacY + 1);
		}
	}

	public void VacmanUp() {
		int vacX = vacman.getX();
		int vacY = vacman.getY();
		if (currField[vacX - 1][vacY] != WALL) {
			currField[vacX][vacY] = PATH;
			currField[vacX - 1][vacY] = VACMAN;
			vacman.moveVacman(vacX - 1, vacY);
		}
	}

	public void VacmanDown() {
		int vacX = vacman.getX();
		int vacY = vacman.getY();
		if (currField[vacX + 1][vacY] != WALL) {
			currField[vacX][vacY] = PATH;
			currField[vacX + 1][vacY] = VACMAN;
			vacman.moveVacman(vacX + 1, vacY);
		}
	}
}
