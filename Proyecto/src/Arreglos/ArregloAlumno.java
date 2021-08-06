package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import Clases.Alumnos;

public class ArregloAlumno {
	
	// atributo
	private ArrayList<Alumnos> alumno;
	//construcctor
	
	   public ArregloAlumno() {
	    	alumno = new ArrayList <Alumnos> ();
	    	
	    	adicionar(new Alumnos(202010001 , "Juan ", "Prado Salazar", "07557853", 20,963542158, 0));
	    
	    }
	   
	   
	   public void adicionar( Alumnos a) {
		alumno.add(a);
	
	   }
	   
	   public int tamaño() {
		return alumno.size();
	}
	   
	   public Alumnos obtener( int a ) {
		return alumno.get( a );
	}
	   
		public Alumnos buscar( int codAlumno ) {
			Alumnos x;
			for ( int i=0; i<tamaño(); i++ ) {
				x = obtener(i);
				if ( x.getCodAlumno() == codAlumno )
					return x;
			}
				
			return null;
		}
		
		public Alumnos  buscarDni( String dni ) {
			Alumnos a;
			for ( int i=0; i<tamaño(); i++ ) {
				a = obtener( i );
				if ( a.getDni().equals( dni  ) )
					return a;
			} 
			return null;	
			
		}
		
		
		public void eliminar( Alumnos a ) {
			alumno.remove( a );
		
		}
		
			
		public int numeroCorrelativo() {
			if (tamaño() == 0)
				return 202010001;
			else
				return obtener(tamaño()-1).getCodAlumno() + 1;
		}
		
}


























