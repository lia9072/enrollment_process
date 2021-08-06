package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Retiro;

public class ArregloRetiro {
	
	//Atributo
		private ArrayList <Retiro> retiro;

		//Constructor
		public ArregloRetiro() {
			retiro = new ArrayList<Retiro>();
			cargarRetiros();
		}
		
		

		public void adicionar(Retiro x) {
			retiro.add(x);
			grabarRetiros();
		}
		
		public int tama�o() {
			return retiro.size();
		}
		
		public Retiro obtener(int i) {
			return retiro.get(i);
		}
		
		public Retiro buscar(int numeroRetiro) {
			for (int i=0; i<tama�o(); i++)
				if (obtener(i).getNumRetiro() == numeroRetiro)
					return obtener(i);
			return null;
		}
		
		public void eliminar(Retiro x) {
			retiro.remove(x);
			grabarRetiros();
		}
		
		public void actualizarArchivo() {
			grabarRetiros();
		}
		

		private void grabarRetiros() {
			try {
				PrintWriter pw;
				String linea;
				Retiro x;
				pw = new PrintWriter(new FileWriter("retiros.txt"));
				for (int i=0; i<tama�o(); i++) {
					x = obtener(i);
					linea =	x.getNumRetiro() + ";" +
							x.getNumMatricula() + ";" +
							x.getFecha() + ";" +
							x.getHora();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}
		
		//M�todo para abrir o leer el txt
		public void cargarRetiros() {
			try {
				BufferedReader br;
				String linea, fecha, hora;
				String[] s;
				int numeroRetiro, numeroMatricula;
				br = new BufferedReader(new FileReader("retiros.txt"));
				while ((linea=br.readLine()) != null) {
					s = linea.split(";");
					numeroRetiro = Integer.parseInt(s[0].trim());
					numeroMatricula = Integer.parseInt(s[1].trim());
					fecha = s[2].trim();
					hora = s[3].trim();
					adicionar(new Retiro(numeroRetiro, numeroMatricula, fecha, hora));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
		
		//Operaciones p�blicas complementarias
		public int codigoCorrelativo() {
			if (tama�o() == 0)
				return 200001;
			else
				return obtener(tama�o()-1).getNumRetiro() + 1;
		}

}
