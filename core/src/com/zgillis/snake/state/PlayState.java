package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.zgillis.snake.SnakeGame;
import com.zgillis.snake.sprite.Food;
import com.zgillis.snake.sprite.Snake;

public class PlayState extends State
{
    // Game is 32x24 blocks (WIDTH x HEIGHT).
    public static final int BLOCK_SIZE = 25;
    public static final int BLOCK_WIDTH = SnakeGame.WIDTH / BLOCK_SIZE;
    public static final int BLOCK_HEIGHT = SnakeGame.HEIGHT / BLOCK_SIZE;
    public static final int SNAKE_START_X = 15;
    public static final int SNAKE_START_Y = 11;
    public static final float SPEEDUP_RATE = 0.95f;

    float moveRate = 0.25f;
    float timePassed = 0f;
    long score = 0;
    ShapeRenderer shapeRenderer;
    Snake snake;
    Food food;
    BitmapFont font;
    FreeTypeFontGenerator generator;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        snake = new Snake();
        food = new Food();


        generator = new FreeTypeFontGenerator(Gdx.files.internal("Minecraft.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        font = generator.generateFont(parameter); // font size 12 pixels
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
            if (snake.getHeadPos().epsilonEquals(food.getPosition())) {
                snake.setNextLinkPos(food.getPosition());
                score += 50f / moveRate;
                moveRate *= 0.9f;
                food = new Food();
            }
            snake.moveSnake();
            timePassed = 0;
        }
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        font.draw(sb, "SCORE: " + score, 2.5f, 595);
        sb.end();
        food.drawFood(shapeRenderer);
        snake.drawSnake(shapeRenderer);
    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }
}
