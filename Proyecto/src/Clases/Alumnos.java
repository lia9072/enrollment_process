package Clases;

public class Alumnos {

	//atributos privados
	
	private int codAlumno, edad, celular, estado;
	private String nombres, apellidos, dni;
	
	

	//Constructor
	public Alumnos(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}
	
	//Métodos  set 
	
		public void setCodAlumno(int codAlumno) {
			this.codAlumno = codAlumno;
		}

		public void setNombres(String nombres) {
			this.nombres = nombres;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public void setCelular(int celular) {
			this.celular = celular;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}
	
		// metodos get 
		public int getCodAlumno() {
			return codAlumno;
		}

		public String getNombres() {
			return nombres;
		}

		public String getApellidos() {
			return apellidos;
		}

		public String getDni() {
			return dni;
		}
		
		public int getEdad() {
			return edad;
		}

		public int getCelular() {
			return celular;
		}

		public int getEstado() {
			return estado;
		}
	
	
	
}
