package com.zgillis.snake.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.zgillis.snake.SnakeGame;
import com.zgillis.snake.state.PlayState;

import java.util.Random;

import static com.zgillis.snake.state.PlayState.BLOCK_SIZE;
import static com.zgillis.snake.state.PlayState.SNAKE_START_X;
import static com.zgillis.snake.state.PlayState.SNAKE_START_Y;

public class Food
{
    private Vector2 position;

    public Food(int x, int y)
    {
        position = new Vector2(x, y);
    }

    public Food()
    {
        position = new Vector2();
        Random random = new Random();
        do {
            position.x = random.nextInt(PlayState.BLOCK_WIDTH);
            position.y = random.nextInt(PlayState.BLOCK_HEIGHT);
        } while (position.x == SNAKE_START_X && position.y == SNAKE_START_Y);

        position.x *= BLOCK_SIZE;
        position.y *= BLOCK_SIZE;
    }

    public void drawFood(ShapeRenderer sr)
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1f, 0f, 0f, 1f);
        sr.rect(position.x, position.y, BLOCK_SIZE, BLOCK_SIZE);
        sr.end();
    }

    public Vector2 getPosition() {
        return position;
    }
}
