package com.zgillis.snake.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.zgillis.snake.fonts.FontManager;


public class LoadingState extends State
{
    private BitmapFont loadingFont;
    private PlayState playState;
    private boolean loading = false;

    public LoadingState(GameStateManager gsm, PlayState playState)
    {
        super(gsm);
        loadingFont = FontManager.createFont(FontManager.Font.MINECRAFT_BOLD, 28, new Color(0.2f, 0.5f, 1, 1));
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
        loadingFont.draw(sb, "LOADING . . .", 300, 300);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
