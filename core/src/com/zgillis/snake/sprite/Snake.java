package com.zgillis.snake.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Snake
{
    private static final int SIZE = 25;

    private Array<Vector2> positions;

    public Snake(int x, int y)
    {
        positions = new Array<Vector2>();
        Vector2 startPosition = new Vector2(x, y);
        positions.add(startPosition);
    }

    public void drawSnake(ShapeRenderer sr)
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1f, 1f, 1f, 1f);

        for (Vector2 pos : positions) {
            sr.rect(pos.x, pos.y, SIZE, SIZE);
        }
        sr.end();
    }

    public void addLink()
    {

    }
}
