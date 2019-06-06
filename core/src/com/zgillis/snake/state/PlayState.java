package com.zgillis.snake.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.zgillis.snake.sprite.Snake;

public class PlayState extends State
{
    ShapeRenderer shapeRenderer;
    Snake snake;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        snake = new Snake(100, 100);
    }

    @Override
    protected void handleInput()
    {

    }

    @Override
    public void update(float deltaTime)
    {
        handleInput();
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
