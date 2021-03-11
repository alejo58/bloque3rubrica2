package RepasoConLosCabros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Binarios {
	
	private static final int bytes_NOTA = (2 * Integer.SIZE + Double.SIZE) / 8;
	
	public static void main(String[] args) {
		String path = "Files/matriculas.dat";
		leerFichero(path);
		try {
			RandomAccessFile salida = new RandomAccessFile(new File("Files/pruebaCabros.bin"), "rw");
			escribir(465, 654, 9.5, salida);
			escribir(465, 4984, 9.5, salida);
			escribir(465, 654544, 9.5, salida);
			escribir(465, 654, 9.5, salida);
			escribir(465, 654, 9.5, salida);
			escribir(465, 654, 9.5, salida);
			escribir(465, 654, 9.5, salida);
			escribir(465, 654, 9.5, salida);
			salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}

		leerPosicion("Files/pruebaCabros.bin", 3);
	}
	
	public static void leerFichero(String path) {
		try {
			DataInputStream f = new DataInputStream(new FileInputStream(path));
			int codAlumno = 0;
			int codAsignatura = 0;
			try {
				while(true) {
					codAlumno = f.readInt();
					codAsignatura = f.readInt();
					System.out.println(codAlumno + " " + codAsignatura);
				}
			} catch (EOFException e) {}
			f.close();
		} catch (FileNotFoundException e) {
			
		} catch(IOException e) {
			
		}
	}
	
	public static void escribir(int codAlumno, int codExamen, double nota, RandomAccessFile salida) {
		try {
			salida.writeInt(codAlumno);
			salida.writeInt(codExamen);
			salida.writeDouble(nota);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leerPosicion(String path, int posicion) {
		try {
			RandomAccessFile f = new RandomAccessFile(new File(path), "r");
			f.seek(bytes_NOTA * (posicion - 1));
			int codAlumno = f.readInt();	
			int codExamen = f.readInt();
			double nota = f.readDouble();
			System.out.println(codAlumno + " " + codExamen + " " + nota);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
