/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Audio;

/**
 *
 * @author laiker
 */
import javax.sound.midi.*;
import java.io.*;

public class MusicaFondo {

	private Sequence secuencia;
	private Sequencer secuenciador;

	public MusicaFondo(String archivo){
		try{
			secuencia=MidiSystem.getSequence(new File(archivo));
			secuenciador=MidiSystem.getSequencer(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public void reproducir(){
		try{

			secuenciador.setSequence(secuencia);
			secuenciador.open();
			secuenciador.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			secuenciador.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public void detener(){
		secuenciador.stop();
		secuenciador.close();
	}
}
