package UltraEngine.AddOns;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontLoader {

	public static Font getFont(String fileName, int size) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fileName)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
