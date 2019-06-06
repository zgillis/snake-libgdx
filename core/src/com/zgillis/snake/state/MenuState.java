package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State
{
    private final int BTN_RESIZE_FACTOR = 6;

    Texture snakeBackground;
    Texture playButton;

    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        snakeBackground = new Texture("snake_bg.png");
        playButton = new Texture("play_btn.png");
    }

    @Override
    protected void handleInput()
    {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            this.dispose();
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
        sb.draw(snakeBackground, 0, 0);
        sb.draw(playButton, 525, 180, playButton.getWidth()/BTN_RESIZE_FACTOR, playButton.getHeight()/BTN_RESIZE_FACTOR);
        sb.end();
    }

    @Override
    public void dispose()
    {
        snakeBackground.dispose();
    }
}
