package magiclamp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * Classe para sequenciação de Midis
 * @author P. Perneta e J. Rocha
 *
 */
public class MidiSequencer {

	/** 
	 * Váriável que guarda o sequenciador 
	 */
	private Sequencer sequencer;

	/**
	 * Método construtor do sequenciador
	 * 
	 */

	public MidiSequencer ()
	{
		sequencer = null;
	}

	/**
	 * Toca uma música / liga o sequenciador para uma música
	 * 
	 * @param filename
	 * 				nome do ficheiro a tocar, em String
	 */
	public void playSound (String filename)
	{
		// Obtains the default Sequencer connected to a default device.
	    // Sequencer sequencer = null;
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			
			MyErrorHandler.errorHandler(e, null, null);
		}
		
		/* abre o sequenciador, indicando que deve adquiror agora
		 * quaiaquer recursos do sistema que necessite para se tornar operacional
		 */
	    try {
			sequencer.open(); //abre o sequenciador
		} catch (MidiUnavailableException e) {
			MyErrorHandler.errorHandler(e, null, null);
		}

	    // cria a stream a partir de um ficheiro
	    InputStream inputstream = null;
		try {
			String basePath = new File("").getAbsolutePath(); // Vai buscar o caminho relativo da pasta
		    
			inputstream = new BufferedInputStream(new FileInputStream(new File(basePath + "\\" + filename)));
		} catch (FileNotFoundException e) {
			MyErrorHandler.errorHandler(e, null, null);
		}
	    // Define a sequência correta sober a qual o sequenciador opera.
	    // A stream tem de apontar para o ficheiro MIDI.
	    try {
			sequencer.setSequence(inputstream);
		} catch (IOException e) {
			MyErrorHandler.errorHandler(e, null, null);
		} catch (InvalidMidiDataException e) {
			MyErrorHandler.errorHandler(e, null, null);
		}

	    // Começa a tocar a sequência de dados MIDI correntemente carregada.
	    sequencer.start();
		
	}
	
	/**
	 * Para o sequenciador
	 */
	public void stopSequencer ()
	{
		sequencer.stop();
	}
	
}

