package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(getHeadLocation(), BODY_SIZE));
		// System.out.println(snake.size());
	}

	public Location getHeadLocation() {
		// 2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		// 1. use a switch statement to check on the currentDirection
		// of the snake and calculate its next x and y position.
		Location newLoc = null;
		switch (currentDirection) {
		case RIGHT:

			newLoc = new Location(head.getLocation().x + 1, head.getLocation().y);

			break;

		case LEFT:

			newLoc = new Location(head.getLocation().x - 1, head.getLocation().y);
			break;

		case UP:

			newLoc = new Location(head.getLocation().x, head.getLocation().y - 1);
			break;

		case DOWN:

			newLoc = new Location(head.getLocation().x, head.getLocation().y + 1);
			break;

		}

		for (int i = snake.size() - 1; i > 0; i--) {
			// newLoc = new Location(snake.get(i - 1).getLocation().x, snake.get(i -
			// 1).getLocation().y);
			snake.get(i).setLocation(snake.get(i - 1).getLocation());
		}
		head.setLocation(newLoc);
		// 2. Iterate through the SnakeSegments in reverse order
		// 2a. Update each snake segment to the location of the segment
		// in front of it.

		// 3. set the location of the head to the new location calculated in step 1

		// 4. set canMove to true
		canMove = true;
	}

	public void setDirection(Direction d) {
		// 1. set the current direction equal to the passed in Direction only if canMove
		// is true.
		// set canMove equal to false.
		// make sure the snake cannot completely reverse directions.
		// System.out.println(d);
		if (canMove == true) {
			switch (currentDirection) {
			case RIGHT:
				if (d == Direction.LEFT) {
					System.out.println("You may not turn in completely reverse directions.");
				} else {
					currentDirection = d;

				}
				break;
			case LEFT:
				if (d == Direction.RIGHT) {
					System.out.println("You may not turn in completely reverse directions.");
				} else {
					currentDirection = d;
				}
				break;
			case UP:
				if (d == Direction.DOWN) {
					System.out.println("You may not turn in completely reverse directions.");
				} else {
					currentDirection = d;
				}
				break;
			case DOWN:
				if (d == Direction.UP) {
					System.out.println("You may not turn in completely reverse directions.");
				} else {
					currentDirection = d;
				}
				break;
			}
			canMove = false;
		}

	}

	public void reset(Location loc) {
		// 1. clear the snake
		snake.clear();
		// 2. set the location of the head
		head.setLocation(loc);
		// 3. add the head to the snake
		snake.add(head);
		System.out.println(snake.size());

	}

	public boolean isOutOfBounds() {
		// 1. complete the method so it returns true if the head of the snake is outside
		// of the window
		// and false otherwise
		// System.out.println(getHeadLocation().x);
		if (getHeadLocation().x <= -1 || getHeadLocation().x >= _00_SnakeGame.WIDTH || getHeadLocation().y <= -1
				|| getHeadLocation().y >= _00_SnakeGame.HEIGHT) {
			return true;
		}

		return false;
	}

	public boolean isHeadCollidingWithBody() {
		// 1. complete the method so it returns true if the head is located
		// in the same location as any other body segment
		for (int i = 1; i < snake.size() - 1; i++) {
			if (getHeadLocation().equals(snake.get(i).getLocation())) {
				return true;
			}
		}

		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		// 1. complete the method so it returns true if the passed in
		// location is located on the snake
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getLocation() == loc) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}

	}
}
