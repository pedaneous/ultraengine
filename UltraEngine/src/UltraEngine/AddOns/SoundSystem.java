package UltraEngine.AddOns;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundSystem {

	public static void playSound(String file) {
		File sound = new File(file);
		try {
			AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
}
