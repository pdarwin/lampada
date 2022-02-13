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

public class MidiSequencer {

	//** O sequenciador */
	private Sequencer sequencer;

	public MidiSequencer ()
	{
		sequencer = null;
	}

	public void playSound (String filename)
	{
		// Obtains the default Sequencer connected to a default device.
	    // Sequencer sequencer = null;
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			
			MyErrorHandler.errorHandler(e, null, null);
		}
		 
	    // Opens the device, indicating that it should now acquire any
	    // system resources it requires and become operational.
	    try {
			sequencer.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			MyErrorHandler.errorHandler(e, null, null);
		}

	    // create a stream from a file
	    InputStream is = null;
		try {
			String basePath = new File("").getAbsolutePath(); // Vai buscar o caminho relativo da pasta
		    
			is = new BufferedInputStream(new FileInputStream(new File(basePath + "\\" + filename)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			MyErrorHandler.errorHandler(e, null, null);
		}
	    // Sets the current sequence on which the sequencer operates.
	    // The stream must point to MIDI file data.
	    try {
			sequencer.setSequence(is);
		} catch (IOException e) {
			MyErrorHandler.errorHandler(e, null, null);
		} catch (InvalidMidiDataException e) {
			MyErrorHandler.errorHandler(e, null, null);
		}

	    // Starts playback of the MIDI data in the currently loaded sequence.
	    sequencer.start();
		
	}
	
	public void stopSequencer ()
	{
		sequencer.stop();
	}
	
}

