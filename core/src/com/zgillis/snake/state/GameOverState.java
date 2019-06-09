package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;


public class GameOverState extends State
{
    private BitmapFont gameOverFont;
    private BitmapFont endScoreFont;
    private FreeTypeFontGenerator generator;
    private long score;

    public GameOverState(GameStateManager gsm, long score)
    {
        super(gsm);
        this.score = score;
        generator = new FreeTypeFontGenerator(Gdx.files.internal("Minecraft.ttf"));

        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 72;
        parameter.color = new Color(1f, 0.5f, 0f, 1f);
        gameOverFont = generator.generateFont(parameter);

        FreeTypeFontParameter scoreParameter = new FreeTypeFontParameter();
        scoreParameter.size = 34;
        endScoreFont = generator.generateFont(scoreParameter);
    }

    @Override
    protected void handleInput()
    {

    }

    @Override
    public void update(float deltaTime)
    {

    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        gameOverFont.draw(sb, "GAME OVER", 190f, 400f);
        endScoreFont.draw(sb, score + " POINTS", 300f, 325f);
        sb.end();
    }

    @Override
    public void dispose()
    {

    }
}
