package com.zgillis.snake.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class LoadingState extends State
{
    private PlayState playState;
    private boolean loading = false;

    public LoadingState(GameStateManager gsm, PlayState playState)
    {
        super(gsm);
        this.playState = playState;
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float deltaTime)
    {
        if (playState.isLoaded()) {
            gsm.set(playState);
            this.dispose();
        }

        else if (!loading) {
            playState.load();
        }
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
