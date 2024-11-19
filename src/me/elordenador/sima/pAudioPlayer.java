package me.elordenador.sima;

import me.elordenador.audioplayer.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;


public class pAudioPlayer extends AudioPlayer {
    public pAudioPlayer() throws LineUnavailableException {

    }

    public void playFall() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        InputStream in = getClass().getResourceAsStream("/me/elordenador/sima/audio/fall.wav");
        assert in != null;
        InputStream bufferedIn = new BufferedInputStream(in);
        load(bufferedIn);
        play();
    }
    public void playAttack() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        InputStream in = getClass().getResourceAsStream("/me/elordenador/sima/audio/attack.wav");
        assert in != null;
        InputStream bufferedIn = new BufferedInputStream(in);
        load(bufferedIn);
        play();
    }
    public void playDefeat() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        InputStream in = getClass().getResourceAsStream(("/me/elordenador/sima/audio/defeat.wav"));
        assert in != null;
        InputStream bufferedIn = new BufferedInputStream(in);
        load(bufferedIn);
        play();
    }
    public void playDeath() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        InputStream in = getClass().getResourceAsStream("/me/elordenador/sima/audio/death.wav");
        assert in != null;
        InputStream bufferedIn = new BufferedInputStream(in);
        load(bufferedIn);
        play();
    }
}
