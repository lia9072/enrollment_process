import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloAlumno;
import Clases.Alumnos;

public class Alumno extends JFrame {

	private JPanel contentPane;
	private JTable tblAlumno;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumno frame = new Alumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// DECLARACION DE VARIABLE 
	ArregloAlumno al = new ArregloAlumno( );
	
	int codAlumno, edad, celular, estado;
	 String nombres, apellidos, dni;
	
	
	public Alumno() {
		setTitle("Mantenimiento / Alumno ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
				
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codAlumno = al.numeroCorrelativo( );
				nombres   = " Alumno 1 ";
				apellidos = " i�m sorry no se tu apellido ";
				dni 	  = " 12345678 ";
				edad	  = 20;
				celular	  = 963258741;
				estado 	  = 0;
				
				String 	 C = " CODIGO: " + codAlumno + "\n " + " NOMBRE ";
				
				try {
					 
					nombres = adicionarModificar(C,nombres);
					C 		+= ( " : " + nombres + " \n " + " DNI ");
					dni 	 = adicionarModificar(C, dni);
					
					if( al.buscarDni( dni ) == null) {
						
						C  += ( " : " + dni + " \n " + " EDAD ");
						edad = Integer.parseInt( adicionarModificar(C, " " + edad));
						
						C  += ( " : " + dni + " \n " + " CELULAR ");
						celular = Integer.parseInt( adicionarModificar(C, " " + celular));
						
						C  += ( " : " + dni + " \n " + " ESTADO ");
						estado = Integer.parseInt( adicionarModificar(C, " [0] Registrado [1] Matriculado [2] Retirado "  + estado));
						
						C += ( enTextoEstado(estado));
						int oki = verificar( C );
						
						if( oki == 0 ) {
							Alumnos  nueva = new Alumnos(codAlumno, nombres, apellidos, dni, edad, celular, estado );
							al.adicionar( nueva );
							listar( );
							
							tblAlumno.getSelectionModel().setSelectionInterval(al.tama�o()-1, al.tama�o()-1);
							
						}
						
					}else {
						mensaje(" El dni que ingreso: " + dni + " ya existe ");
					}
					
				}catch (Exception x) {
			
				}
				
				
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int posFila = tblAlumno.getSelectedRow();
				Alumnos x = al.obtener(posFila);
				String C = " CODIGO : " + x.getCodAlumno() + " \n" + " NOMBRE ";
				
				try{
					nombres = adicionarModificar(C, x.getNombres());
					 C += ( " : " + nombres + "\n" + "DNI : " + x.getDni() + "\n" + " EDAD "  );
					 
					 apellidos = adicionarModificar(C, x.getApellidos());
					 C += ( " : " + apellidos + "\n" + " EDAD "  );
					 
					 edad = Integer.parseInt(adicionarModificar(C, "" + x.getEdad()));
					 C += ( " : " + edad + "\n" +  " CELULAR "  );
					 
					 celular = Integer.parseInt(adicionarModificar(C, "" + x.getCelular()));
					 C += ( " : " + celular + "\n" +  " ESTADO "  );
					 			
					 estado = Integer.parseInt( adicionarModificar(C, " [0] Registrado [1] Matriculado [2] Retirado "  + estado));						
					C += ( enTextoEstado(estado));
					
					int oki = verificar( C );
					
					if( oki == 0 ) {
						x.setNombres( nombres );
						x.setApellidos( apellidos );
						x.setEdad( edad );
						x.setCelular( celular );
						x.setEstado( estado );
						
						listar();
						tblAlumno.getSelectionModel().setSelectionInterval(posFila, posFila);
						
					}
					 
				}
				catch (Exception m) {
				
				}
				
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				
				Alumnos x = al.obtener(tblAlumno.getSelectedRow( ) );
				
				mensaje(" CODIGO: "  + x.getCodAlumno() + " \n " + 
						"NOMBRE : " + x.getNombres() + "\n" + 
						" APELLIDOS: " + x.getApellidos() + "\n" + 
						" DNI : " + x.getDni() + "\n" + 
						" EDAD : " + x.getEdad() + " \n" +
						" CELULAR : " + x.getCelular() + " \n" + 
						" ESTADO : " + x.getEstado() 
						
				);
				
				
				
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 754, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar)
						.addComponent(btnConsultar)
						.addComponent(btnModificar)
						.addComponent(btnEliminar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		DefaultTableModel modelo = new DefaultTableModel(); 
		JTable table = new JTable( modelo );
		tblAlumno = new JTable();
		tblAlumno.setModel(new DefaultTableModel(
			new Object[][] {
			
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRE", "APELLIDOS", "DNI", "EDAD ", "CELULAR ", "ESTADO"
			}
		));
		tblAlumno.getColumnModel().getColumn(5).setPreferredWidth(119);
		tblAlumno.getColumnModel().getColumn(6).setPreferredWidth(144);
		scrollPane.setViewportView(tblAlumno);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	
	
	
	// metodos sin retorno	
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblAlumno.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // dni
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // peso
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // estatura
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // estadoCivil
		tcm.getColumn(6).setPreferredWidth(anchoColumna(17));  // imc
		tcm.getColumn(7).setPreferredWidth(anchoColumna(10));  // grado
	}
	
	
	
	
	void listar() {
		Alumnos x;
		modelo.setRowCount( 0 );
		for (int i=0; i<al.tama�o(); i++ ) {
			x = al.obtener( i );
			Object[] fila = { x.getCodAlumno(),
					          x.getNombres(),
					          x.getApellidos(),
					          x.getDni(),
					          x.getEdad(),
					          x.getCelular(),                                  
					          enTextoEstado(x.getEstado()),
					          
					          };
			modelo.addRow(fila);
		}
	}
	
	//  M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Persona", 1);
	}	
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	
	String enTextoEstado(int i) {
		switch (i) {
			case 0:
				return "Registrado";
			case 1:
				return "Matriculado";			
			default:
				return "Retirado";
		}
	}
	double ajustar(double numero) {
		return (int)(numero * 10) / 10.0;
	}
	String adicionarModificar(String s, String texto) {
		return JOptionPane.showInputDialog(this, s, "Alumno", -1, null, null, texto).toString();
	}
	int verificar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alumno", 0, 3, null);
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alumno", 0, 0, null);
	}
	
	
}















