package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.zgillis.snake.fonts.FontManager;


public class GameOverState extends State
{
    private BitmapFont gameOverFont;
    private BitmapFont endScoreFont;
    private BitmapFont playAgainText;
    private FreeTypeFontGenerator generator;
    private long score;

    public GameOverState(GameStateManager gsm, long score)
    {
        super(gsm);
        this.score = score;
        gameOverFont = FontManager.createFont(FontManager.Font.MINECRAFT, 72,
                new Color(1, 0.5f, 0, 1));

        endScoreFont = FontManager.createFont(FontManager.Font.MINECRAFT, 38);
        playAgainText = FontManager.createFont(FontManager.Font.MINECRAFT, 26, new Color(0, 0.1f, 1, 1));
    }

    @Override
    protected void handleInput()
    {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            gsm.set(new LoadingState(gsm, new PlayState(gsm)));
        }
    }

    @Override
    public void update(float deltaTime)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        gameOverFont.draw(sb, "GAME OVER", 190f, 400f);
        endScoreFont.draw(sb, score + " POINTS", 300f, 325f);
        playAgainText.draw(sb, "Press any key to play again...", 225f, 27f);
        sb.end();
    }

    @Override
    public void dispose()
    {

    }
}
