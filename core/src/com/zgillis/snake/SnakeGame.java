package com.zgillis.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zgillis.snake.state.GameStateManager;
import com.zgillis.snake.state.MenuState;

public class SnakeGame extends ApplicationAdapter
{
	public static String TITLE = "Snake - zgillis";
	public static int WIDTH = 800;
	public static int HEIGHT = 600;

	SpriteBatch sb;
	GameStateManager gsm;

	@Override
	public void create ()
	{
		sb = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
	
	@Override
	public void dispose ()
	{
		sb.dispose();
	}
}
