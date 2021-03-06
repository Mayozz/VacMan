package VacMan.game;

import java.awt.Color;
import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Der View Part der MVC Pattern enthält die grafische Oberfläche, dass was man sieht.
 * @author Marius
 *
 */
public class View extends GraphicsProgram {

	public View(int field[][]) {
		this.field = field;
	}

	

	public void update() {

/////////////// nested for-loops to build the field////////////////////

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				// if value in array is 0, the tile has to be blue, otherwise it has to be black
				if (field[i][j] == 0) {
					GRect blue = new GRect(BEGINNING_FIELD + j * TILE_SIZE, BEGINNING_FIELD + i * TILE_SIZE, TILE_SIZE,
							TILE_SIZE);
					blue.setFilled(true);
					blue.setColor(Color.BLACK);
					blue.setFillColor(Color.BLUE);
					add(blue);
				} else {
					GRect black = new GRect(BEGINNING_FIELD + j * TILE_SIZE, BEGINNING_FIELD + i * TILE_SIZE, TILE_SIZE,
							TILE_SIZE);
					black.setFilled(true);
					black.setColor(Color.BLACK);
					black.setFillColor(Color.BLACK);
					add(black);
				}

			}
		}
		///////// Vacman at starting position/////////////
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 2) {
					GOval vacman = new GOval(BEGINNING_FIELD + j * TILE_SIZE, BEGINNING_FIELD + i * TILE_SIZE,
							TILE_SIZE, TILE_SIZE);
					vacman.setFilled(true);
					vacman.setFillColor(Color.GREEN);
					add(vacman);
				}
			}
		}
		//////// Viruses at starting position /////////////
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 3) {
					GOval virus = new GOval(BEGINNING_FIELD + j * TILE_SIZE, BEGINNING_FIELD + i * TILE_SIZE, TILE_SIZE,
							TILE_SIZE);
					virus.setFilled(true);
					virus.setFillColor(Color.RED);
					add(virus);
				}
			}

		}

		//////// Vaccines in the beginning///////////////
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 4) {
					GOval vaccine = new GOval(BEGINNING_FIELD + j * TILE_SIZE + TILE_SIZE / 2,
							BEGINNING_FIELD + i * TILE_SIZE + TILE_SIZE / 2, TILE_SIZE / 3, TILE_SIZE / 3);
					vaccine.setFilled(true);
					vaccine.setFillColor(Color.ORANGE);
					add(vaccine);
				}
			}
		}

	}

}
