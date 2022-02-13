package magiclamp;

import java.io.File;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
 
/**
 * Classe para tocar um fivheiro .wav usando o Clip da Java Sound API.
 * @author www.codejava.net
 *
 */
public class AudioPlayer implements LineListener {
     
    /**
     * indica se a playlist completou ou não
     */
    boolean playCompleted;
     
    /**
     * Toca um audio (.wav)
     * @param filename nome do ficheiro
     */
    public void play(String filename) {
    	
		String basePath = new File("").getAbsolutePath(); // Vai buscar o caminho relativo da pasta

        File audioFile = new File(basePath + "\\" + filename); // cria o ficheiro
 
        try 
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // cria o audio stream
 
            AudioFormat format = audioStream.getFormat(); // vai buscar o formato do audiostream
 
            DataLine.Info info = new DataLine.Info(Clip.class, format); // com o formato, cria um objeto DataLine
 
            Clip audioClip = (Clip) AudioSystem.getLine(info); // gera o audioclip, uando o dataline criado
 
            audioClip.addLineListener(this); // adiciona um listener
 
            audioClip.open(audioStream); // abre o audiofile
             
            audioClip.start(); // começa a tocar
             
            while (!playCompleted) // ciclo para esperar que termine de tocar o audio
            {
                
                try 
                {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                	MyErrorHandler.errorHandler(ex, null, null);
                }
            }
             
            audioClip.close(); //fecha o audio, se parou de tocar
             
        }
        catch (Exception ex)
        {
            MyErrorHandler.errorHandler(ex, null, null);
        }
         
    }
     
    /**
     * Escuta os eventos START e STOP da linha audio.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType(); // Vai buscar o tipo de evento
         
        if (type == LineEvent.Type.START) 
        {
            //System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) 
        {
            playCompleted = true; // se acabou, acerta o boleano
            //System.out.println("Playback completed.");
        }
 
    }
 
 
}