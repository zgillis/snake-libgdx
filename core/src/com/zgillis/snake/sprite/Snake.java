package com.zgillis.snake.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.zgillis.snake.SnakeGame;
import com.zgillis.snake.state.PlayState;

import static com.zgillis.snake.state.PlayState.BLOCK_SIZE;

public class Snake
{

    private Direction direction;
    private Array<Vector2> positions;

    public Snake()
    {
        /* Create a new snake at the designated location, add the first
         * position (head of snake) to positions array, and set the
         * initial snake position. */
        positions = new Array<Vector2>();
        Vector2 startPosition = new Vector2(PlayState.SNAKE_START_X * BLOCK_SIZE, PlayState.SNAKE_START_Y * BLOCK_SIZE);
        positions.add(startPosition);
        direction = Direction.RIGHT; //TODO: Randomize start direction
    }

    public void drawSnake(ShapeRenderer sr)
    {
        // Use a ShapeRenderer to render each segment of the snake
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1f, 1f, 1f, 1f);

        for (Vector2 pos : positions) {
            sr.rect(pos.x, pos.y, BLOCK_SIZE, BLOCK_SIZE);
        }
        sr.end();
    }

    public void moveSnake()
    {
        // Gets the position of the head of the snake, then moves it.
        Vector2 lastPos = positions.get(0);
        positions.set(0, updateBlockPosition(lastPos));

        /* For each snake segmment, copy the current location, move the
        *  segment to the previous position of the previous segment, then
        *  set save the previous position in 'lastPos' for the next iteration. */
        for (int i = 1; i < positions.size; i++) {
            Vector2 currentPos = new Vector2(positions.get(i));
            positions.set(i, lastPos);
            lastPos = currentPos;
        }
    }

    public Vector2 updateBlockPosition(Vector2 position)
    {
        /* Checks the snake's movement direction and sets the next position
        *  of the snake. If the snake would move off-screen, returns the current
        *  snake position instead of moving it. */
        switch (direction) {
            case UP:
                if (position.y >= SnakeGame.HEIGHT - BLOCK_SIZE)
                    return position;
                position.add(0, BLOCK_SIZE);
                break;
            case DOWN:
                if (position.y < BLOCK_SIZE)
                    return position;
                position.sub(0, BLOCK_SIZE);
                break;
            case LEFT:
                if (position.x < BLOCK_SIZE)
                    return position;
                position.sub(BLOCK_SIZE, 0);
                break;
            case RIGHT:
                if (position.x >= SnakeGame.WIDTH - BLOCK_SIZE)
                    return position;
                position.add(BLOCK_SIZE, 0);
                break;
        }
        return position;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    // An enumeration to define the directions a snake can move.
    public enum Direction
    {
        UP, DOWN, LEFT, RIGHT
    }
}
