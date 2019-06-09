package com.zgillis.snake.fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class FontManager
{
    public FontManager()
    {

    }

    public static BitmapFont createFont(Font font, int size, Color color)
    {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(getFontFileName(font)));
        FreeTypeFontParameter settings = new FreeTypeFontParameter();
        settings.size = size;
        settings.color = color;
        return generator.generateFont(settings);
    }

    public static BitmapFont createFont(Font font, int size)
    {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(getFontFileName(font)));
        FreeTypeFontParameter settings = new FreeTypeFontParameter();
        settings.size = size;
        return generator.generateFont(settings);
    }

    public enum Font
    {
        MINECRAFT, MINECRAFT_BOLD, TEST
    }

    private static String getFontFileName(Font font)
    {
        switch (font) {
            case MINECRAFT:
                return "Minecraft.ttf";
            case MINECRAFT_BOLD:
                return "3 Minecraft-Bold.otf";
            default:
                return null;
        }
    }
}
