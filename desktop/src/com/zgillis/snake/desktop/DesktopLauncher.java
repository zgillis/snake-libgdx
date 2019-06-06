package com.zgillis.snake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zgillis.snake.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = SnakeGame.TITLE;
		config.width = SnakeGame.WIDTH;
		config.height = SnakeGame.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new SnakeGame(), config);
	}
}
