package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameOverState extends State
{
    private long score;

    public GameOverState(GameStateManager gsm, long score)
    {
        super(gsm);
        this.score = score;

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
        sb.end();
    }

    @Override
    public void dispose()
    {

    }
}
