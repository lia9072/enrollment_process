package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Matricula;

public class ArregloMatricula {
	//Atributo
		private ArrayList < Matricula > matricula;
		
		//Constructor
		public ArregloMatricula( ) {
			matricula = new ArrayList <Matricula> ();
			cargarMatriculas();
		}		
	
		
		
		public void adicionar( Matricula m ) {
			matricula.add( m );
			grabarMatriculas( );
		}
		
		public int tamaño( ) {
			return matricula.size( );
		}
		
		public Matricula obtener( int m ) {
			return matricula.get( m );
		}
		
		public Matricula buscar( int numeroMatricula ) {
			for ( int i=0; i<tamaño( ); i++ )
				if ( obtener( i ).getNumMatricula( ) == numeroMatricula )
					return obtener( i );
			return null;
		}
		
		public Matricula buscarCurso( int codigoCurso ){
			for( int i=0; i<tamaño(); i++ )
				if( obtener( i ).getCodCurso( ) == codigoCurso )
					return obtener(i);
			return null;
		}
		
		public Matricula buscarAlumno(int codigoAlumno){
			for(int i=0; i<tamaño(); i++)
				if(obtener(i).getCodAlumno() == codigoAlumno)
					return obtener(i);
			return null;
		}
		
		public void eliminar( Matricula m ) {
			matricula.remove( m );
			grabarMatriculas( );
		}
		
		public void actualizarArchivo( ) {
			grabarMatriculas( );
		}
		
		
		private void grabarMatriculas( ) {
			try {
				PrintWriter pw;
				String linea;
				Matricula x;
				pw = new PrintWriter(new FileWriter("matriculas.txt"));
				for (int i=0; i<tamaño(); i++) {
					x = obtener(i);
					linea =	x.getNumMatricula() + ";" +
							x.getCodAlumno() + ";" +
							x.getCodCurso() + ";" +
							x.getFecha() + ";" +
							x.getHora() + ";" ;
						
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}
		
		//Método para abrir o leer el txt
		public void cargarMatriculas( ) {
			try {
				BufferedReader br;
				String linea;
				String[] s;
				int numeroMatricula, codigoAlumno, codigoCurso, estado;
				String fecha, hora;
				br = new BufferedReader(new FileReader( "matriculas.txt" ) );
				while ( ( linea=br.readLine( ) ) != null ) {
					s = linea.split(";");
					numeroMatricula = Integer.parseInt(s[0].trim( ) );
					codigoAlumno = Integer.parseInt(s[1].trim( ) );
					codigoCurso = Integer.parseInt(s[2].trim( ) );
					fecha = s[3].trim( );
					hora = s[4].trim( );
					estado = Integer.parseInt(s[5].trim());
					adicionar ( new Matricula( numeroMatricula, codigoAlumno, codigoCurso, fecha, hora ) );
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
		
		/*******************************************************************/
		
		//Operaciones públicas complementarias
		public int codigoCorrelativo( ) {
			if ( tamaño( ) == 0 )
				return 100001;
			else
				return obtener( tamaño( )-1 ).getNumMatricula( ) + 1;
		}
		

}
