package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.zgillis.snake.sprite.Snake;

public class PlayState extends State
{
    float moveRate = 0.25f;
    float timePassed = 0f;
    ShapeRenderer shapeRenderer;
    Snake snake;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        snake = new Snake(15 * Snake.BLOCK_SIZE, 11 * Snake.BLOCK_SIZE);
    }

    @Override
    protected void handleInput()
    {
        // Check arrow keys and set snake direction accordingly
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            snake.setDirection(Snake.Direction.UP);
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            snake.setDirection(Snake.Direction.DOWN);
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            snake.setDirection(Snake.Direction.LEFT);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            snake.setDirection(Snake.Direction.RIGHT);
    }

    @Override
    public void update(float deltaTime)
    {
        /* Add the time since last frame to 'timePassed', which
         * keeps a total of time passed since the last snake movement.
         * When this is greater than or equal to the moveRate, move snake.*/
        timePassed += deltaTime;
        handleInput();
        if (timePassed >= moveRate) {
            snake.moveSnake();
            timePassed = 0;
        }
    }

    @Override
    public void render(SpriteBatch sb)
    {
        snake.drawSnake(shapeRenderer);
    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
