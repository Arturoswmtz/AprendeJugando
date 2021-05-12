/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectaColor;

import Formulario.SelecionMateria;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Cruz
 */
public class ConectaColor extends JFrame implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = -1473384533532581274L;
	private final int gameWidth = 800;
	private final int gameHeight = 600;
	private JPanel panel;

	int N = 4 * 2; // numero de colores en el tablero * 2
	final int M = 15; // cuadros del tablero para longitud y anchura(tablero cuadrado)
	int listaCoordenadas[][]; // lista de los cuadros de color iniciales en el tablero
	int lideres[][];// lista de las coordenadas de los cuadros de color que pueden ser arrastradas
					// para pintar otro cuadro
	
	Color colores[] = new Color[8];//colores a utilizar en el tablero
	String palabraColor[] = new String[7]; // palabras en ingles de los colores
	Rectangle boardRect; // rectangulo del tablero
	boolean dibujando; // indica si se seleccionó un cuadro de color y se puede mover y pintar dentro
						// del tablero
	int indiceColorActual;
	int coloresCompletos; // indica cuantos colores llegaron a su color en palabra
	boolean listaColoresCompletos[];// indica con la posicion del array que color ya está completo

	int puntaje;// puntaje actual del juego
	int temporizador;// temporizador para contar cada segundo del juego
	int tiempo; // tiempo jugando un nivel

	JLabel labelPuntaje;
	JLabel labelTiempoTranscurrido;
        
        int matriz[][] = new int[M][M];//tablero de juego
//	  La matriz tiene numeros del 0 al 14 que significan: 
//	  0 -> vacio
//	  1 -> color 1 
//	  2 -> color 2 
//	  ... 
//	  7 -> color 7 
//	  8 -> palabra de color 1 
//	  9 -> palabra de color 2
//	  ... 
//	  14 -> palabra de color 7

	public ConectaColor() {
		this.setSize(gameWidth, gameHeight);
		this.setTitle("Conecta color");
		this.setLocationRelativeTo(null);
		iniciarComponentes();
		colocarBotones();
		iniciarVariables();
	}

	public void iniciarComponentes() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(139, 89, 16));
		this.getContentPane().add(panel);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void colocarBotones() {
		JButton botonRegreso = new JButton();
		botonRegreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelecionMateria form = new SelecionMateria();
                                form.setVisible(true);
                                dispose();
			}
		});
		botonRegreso.setBounds(gameWidth / 16, gameHeight / 32, gameWidth / 8, 3 * gameHeight / 16);

		// agregando la imagen home
		ImageIcon imagen = new ImageIcon("src/imagenesConectaColor/home.png");
		botonRegreso.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(9 * botonRegreso.getWidth() / 10,
				botonRegreso.getHeight(), Image.SCALE_SMOOTH)));

		panel.add(botonRegreso);

		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
			}
		});
		botonReiniciar.setBounds(0, gameHeight / 4, gameWidth / 4, gameHeight / 4);
		// agregando la imagen reiniciar
		imagen = new ImageIcon("src/imagenesConectaColor/reiniciar.png");
		botonReiniciar.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(botonReiniciar.getWidth() / 2,
				botonReiniciar.getHeight() / 2, Image.SCALE_SMOOTH)));
		panel.add(botonReiniciar);

		JButton botonCambiar = new JButton("Cambiar");
		botonCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiar();
			}
		});
		botonCambiar.setBounds(botonReiniciar.getX(), gameHeight / 2, botonReiniciar.getWidth(),
				botonReiniciar.getHeight());
		// agregando la imagen reiniciar
		imagen = new ImageIcon("src/imagenesConectaColor/cambiar.png");
		botonCambiar.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(botonCambiar.getWidth() / 2,
				botonCambiar.getHeight() / 2, Image.SCALE_SMOOTH)));
		panel.add(botonCambiar);

		labelPuntaje = new JLabel("Puntaje: 0");
		labelPuntaje.setBounds(botonReiniciar.getX(), 3 * gameHeight / 4, botonReiniciar.getWidth(),
				botonReiniciar.getHeight() / 4);
		panel.add(labelPuntaje);

		JLabel labelTiempoMaximo = new JLabel("tiempo Maximo: 20");
		labelTiempoMaximo.setBounds(labelPuntaje.getX(), labelPuntaje.getY() + labelPuntaje.getHeight(),
				labelPuntaje.getWidth(), labelPuntaje.getHeight());
		panel.add(labelTiempoMaximo);

		labelTiempoTranscurrido = new JLabel("Tiempo transcurrido: " + tiempo);
		labelTiempoTranscurrido.setBounds(labelTiempoMaximo.getX(),
				labelTiempoMaximo.getY() + labelTiempoMaximo.getHeight(), labelTiempoMaximo.getWidth(),
				labelTiempoMaximo.getHeight());
		panel.add(labelTiempoTranscurrido);

		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}

	public void iniciarVariables() {

		listaCoordenadas = new int[N][2];
		lideres = new int[N / 2 + 1][2];
		Rectangle menuRect = new Rectangle(0, 0, gameWidth / 4, gameHeight);
		boardRect = new Rectangle(menuRect.width + gameWidth / 10, menuRect.y + gameHeight / 10,
				(3 * gameWidth / 4) - gameWidth / 5, gameHeight - gameHeight / 5);
		temporizador = 0;
		puntaje = 0;
		tiempo = 0;

		dibujando = false;
		coloresCompletos = 0;

		colores[0] = Color.BLACK;
		colores[1] = Color.RED;
		colores[2] = Color.CYAN;
		colores[3] = Color.GREEN;
		colores[4] = Color.MAGENTA;
		colores[5] = Color.ORANGE;
		colores[6] = Color.PINK;
		colores[7] = Color.YELLOW;

		palabraColor[0] = "RED";
		palabraColor[1] = "BLUE";
		palabraColor[2] = "GREEN";
		palabraColor[3] = "MAGENTA";
		palabraColor[4] = "ORANGE";
		palabraColor[5] = "PINK";
		palabraColor[6] = "YELLOW";

		listaColoresCompletos = new boolean[8]; // el primer color se deja en false por comodidad

		generarCoordenadas();
	}

	public void siguienteNivel() {
		coloresCompletos = 0;
		for (int i = 0; i < listaColoresCompletos.length; i++) {
			listaColoresCompletos[i] = false;
		}
		dibujando = false;
		if (N < 14)
			N += 2;
		listaCoordenadas = new int[N][2];
		lideres = new int[N / 2 + 1][2];
		puntaje = 0;
		temporizador = 0;
		tiempo = 0;
		labelPuntaje.setText("Puntaje: " + puntaje);
		labelTiempoTranscurrido.setText("Tiempo transcurrido: " + tiempo);
		generarCoordenadas();
		repaint();
	}

	public void reiniciar() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				matriz[i][j] = 0;
			}
		}
		// pasando las coordenadas anteriores al tablero de juego para bloques de
		// colores
		for (int i = 0; i < listaCoordenadas.length / 2; i++) {
			matriz[listaCoordenadas[i][0]][listaCoordenadas[i][1]] = i + 1;
		}
		// pasando las coordenadas anteriores al tablero de juego para nombres de
		// colores en ingles
		for (int i = 0; i < listaCoordenadas.length / 2; i++) {
			matriz[listaCoordenadas[listaCoordenadas.length / 2 + i][0]][listaCoordenadas[listaCoordenadas.length / 2
					+ i][1]] = i + 8;
		}
		coloresCompletos = 0;
		for (int i = 1; i < listaColoresCompletos.length; i++) {
			listaColoresCompletos[i] = false;
		}
		dibujando = false;
		puntaje = 0;
		temporizador = 0;
		tiempo = 0;
		labelPuntaje.setText("Puntaje: " + puntaje);
		labelTiempoTranscurrido.setText("Tiempo transcurrido: " + tiempo);
		// agregando los bloques de colores a la lista de lideres, se deja el primero
		// vacio por comodidad
		for (int i = 0; i < N / 2; i++) {
			lideres[i + 1][0] = listaCoordenadas[i][0];
			lideres[i + 1][1] = listaCoordenadas[i][1];
		}
		repaint();
	}

        //cambia las coordenadas de los colores del cuadro de juego
	public void cambiar() {
		generarCoordenadas();
		coloresCompletos = 0;
		for (int i = 1; i < listaColoresCompletos.length; i++) {
			listaColoresCompletos[i] = false;
		}
		puntaje = 0;
		temporizador = 0;
		tiempo = 0;
		labelPuntaje.setText("Puntaje: " + puntaje);
		labelTiempoTranscurrido.setText("Tiempo transcurrido: " + tiempo);
		dibujando = false;
		repaint();
	}

	public void generarCoordenadas() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				matriz[i][j] = 0;
			}
		}
		// genera las N coordenadas diferentes y con distancia mayor o igual a 1
		listaCoordenadas[0][0] = (int) (Math.random() * M);
		listaCoordenadas[0][1] = (int) (Math.random() * M);
		for (int i = 1; i < N; i++) {
			listaCoordenadas = generaAleatorioAlejado(listaCoordenadas, M, i);
		}
		// pasando las coordenadas anteriores al tablero de juego para bloques de
		// colores
		for (int i = 0; i < listaCoordenadas.length / 2; i++) {
			matriz[listaCoordenadas[i][0]][listaCoordenadas[i][1]] = i + 1;
		}
		// pasando las coordenadas anteriores al tablero de juego para nombres de
		// colores en ingles
		for (int i = 0; i < listaCoordenadas.length / 2; i++) {
			matriz[listaCoordenadas[listaCoordenadas.length / 2 + i][0]][listaCoordenadas[listaCoordenadas.length / 2
					+ i][1]] = i + 8;
		}

		// agregando los bloques de colores a la lista de lideres, se deja el primero
		// vacio por comodidad
		for (int i = 0; i < N / 2; i++) {
			lideres[i + 1][0] = listaCoordenadas[i][0];
			lideres[i + 1][1] = listaCoordenadas[i][1];
		}
	}

	/**
	 * Este metodo determina si una coordenada (x,y) tiene o no una distancia de al
	 * menos 1 con los elementos de una lista de coordenadas empezando en la
	 * posicion 0 hasta maxLista - 1
	 * 
	 * @param x          coordenada x
	 * @param y          coordenada y
	 * @param lista      lista de coordenadas totales
	 * @param tamTablero tamanio de un tablero cuadrado
	 * @param maxLista   limite de la revision de la lista
	 * @return true si la distancia es menor o igual a 1, false si es mayor a 1
	 */
	public boolean distanciaMenorA1(int x, int y, int lista[][], int tamTablero, int maxLista) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i != 0 || j != 0) {
					int coordenadaX = x - i;
					int coordenadaY = y - j;
					if (coordenadaX >= 0 && coordenadaX < tamTablero && coordenadaY >= 0 && coordenadaY < tamTablero) {
						for (int k = 0; k < maxLista; k++) {
							if (lista[k][0] == coordenadaX && lista[k][1] == coordenadaY) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Genera una coordenada sin repetirla en la lista y que tenga una distancia de
	 * almenos una unidad conr especto de las otras coordenadas
	 * 
	 * @param lista      de coordenadas a revisar y en ella se agreagara la nueva
	 *                   coordenada en la posicion maxLista
	 * @param tamTablero tamanio de un tablero cuadrado
	 * @param maxLista   limite de la revision de la lista
	 * @return la lista con una nueva coordenada en maxLista
	 */
	public int[][] generaAleatorioAlejado(int lista[][], int tamTablero, int maxLista) {
		int random1;
		int random2;
		// la nueva coordenada tenga mas de 1 de distancia
		do {
			boolean contenido;
			// la nueva coordenada no este ya en la lista
			do {
				random1 = (int) (Math.random() * tamTablero);
				random2 = (int) (Math.random() * tamTablero);
				contenido = false;
				for (int i = 0; i < maxLista; i++) {
					if (lista[i][0] == random1 && lista[i][1] == random2) {
						contenido = true;
						break;
					}
				}
			} while (contenido);
		} while (distanciaMenorA1(random1, random2, lista, tamTablero, maxLista));
		lista[maxLista][0] = random1;
		lista[maxLista][1] = random2;
		return lista;
	}

	public void iniciarSonido(String ruta) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");
		}
	}

	// draw rectangles and Strings in different colors
	public void paint(Graphics g) {
		// call superclass's paint method
		super.paint(g);
		drawBoard(g);
		drawLines(g);
	}

	public void drawBoard(Graphics g) {

		int rectWidth = boardRect.width / M;
		int rectHeight = boardRect.height / M;
		Toolkit t = Toolkit.getDefaultToolkit();

		java.awt.Image imagen;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int index = matriz[i][j];
				if (index < 8) {
					g.setColor(colores[index]);
					g.fillRect(j * rectWidth + boardRect.x, i * rectHeight + boardRect.y, rectWidth, rectHeight);
				} else {
					imagen = t.getImage("src/imagenesConectaColor/" + palabraColor[matriz[i][j] - 8] + ".jpg");
					g.drawImage(imagen, j * rectWidth + boardRect.x, i * rectHeight + boardRect.y, rectWidth,
							rectHeight, this);
				}
			}
		}
	}

	public void dibujarCuadrosCompletados(Graphics g, int rectWidth, int rectHeight) {
		for (int i = 0; i < listaColoresCompletos.length; i++) {
			if (listaColoresCompletos[i] == true) {
				int coordenadaX = listaCoordenadas[i + 7][0];
				int coordenadaY = listaCoordenadas[i + 7][1];
				g.setColor(colores[indiceColorActual]);
				g.fillRect(coordenadaY * rectHeight + boardRect.x, coordenadaX * rectWidth, rectWidth, rectHeight);
			}
		}
	}

	public void drawLines(Graphics g) {
		g.setColor(Color.WHITE);
		int rectHeight = boardRect.height / M;
		int rectWidth = boardRect.width / M;
		for (int i = 0; i <= M; i++) {
			g.drawLine(boardRect.x, i * rectHeight + boardRect.y, rectWidth * M + boardRect.x,
					i * rectHeight + boardRect.y);
			g.drawLine(i * rectWidth + boardRect.x, boardRect.y, i * rectWidth + boardRect.x,
					rectHeight * M + boardRect.y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Al apretar el click
		Point point = new Point(arg0.getX() + 7, arg0.getY() + 30);
		if (boardRect.contains(point)) {
			// dentro del cuadro de juego
			int rectHeight = (boardRect.height / M);
			int rectWidth = (boardRect.width / M);
			int coordenadaX = (point.y - boardRect.y) / rectHeight;
			int coordenadaY = (point.x - boardRect.x) / rectWidth;
			// se revisa si el click esta en un bloque de color y no se ha llevado a su
			// palabra
			if (matriz[coordenadaX][coordenadaY] > 0 && matriz[coordenadaX][coordenadaY] < 8
					&& !listaColoresCompletos[matriz[coordenadaX][coordenadaY]]) {
				if (lideres[matriz[coordenadaX][coordenadaY]][0] == coordenadaX
						&& lideres[matriz[coordenadaX][coordenadaY]][1] == coordenadaY) {
					dibujando = true;
					indiceColorActual = matriz[coordenadaX][coordenadaY];
				}

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dibujando = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (dibujando) {

			Point point = new Point(arg0.getX() + 7, arg0.getY() + 30);
			// dentro del cuadro de juego
			int rectHeight = (boardRect.height / M);
			int rectWidth = (boardRect.width / M);
			int coordenadaX = (point.y - boardRect.y) / rectHeight;
			int coordenadaY = (point.x - boardRect.x) / rectWidth;
			if (coordenadaX >= 0 && coordenadaX < M && coordenadaY >= 0 && coordenadaY < M) {
				// dentro del cuadro de juego
				if (matriz[coordenadaX][coordenadaY] != indiceColorActual) {
					if (matriz[coordenadaX][coordenadaY] == 0) {
						// cuadrado negro
						matriz[coordenadaX][coordenadaY] = indiceColorActual;
						iniciarSonido("src/imagenesConectaColor/otroCuadro.wav");
						// se cambia a este ultimo cuadro el lider de ese color
						lideres[matriz[coordenadaX][coordenadaY]][0] = coordenadaX;
						lideres[matriz[coordenadaX][coordenadaY]][1] = coordenadaY;
						repaint();
					} else if (matriz[coordenadaX][coordenadaY] == indiceColorActual + 7) {
						// palabra destino
						iniciarSonido("src/imagenesConectaColor/final.wav");
						dibujando = false;
						coloresCompletos++;
						// se agrega a la lista este color para ya no poder modificarlo
						listaColoresCompletos[matriz[coordenadaX][coordenadaY] - 7] = true;
						puntaje++;
						labelPuntaje.setText("Puntaje: " + puntaje);
						if (coloresCompletos >= N / 2) {
							// se gana
                                                        if(tiempo <= 20){
                                                            JOptionPane.showMessageDialog(null, "Pasaste de nivel, puntuación: " + (puntaje + 3));
                                                        }else{
                                                             JOptionPane.showMessageDialog(null, "Pasaste de nivel, puntuación: " + puntaje);
                                                        }
							siguienteNivel();
						}
					} else if (matriz[coordenadaX][coordenadaY] < 8) {
						// diferente bloque de color
						reiniciar();
					} else {
						// palabra no destino
						dibujando = false;
					}
				}
			} else {
				// fuera del cuadro de juego
				dibujando = false;
			}
		}
		try {
			Thread.sleep((long) 10);
			temporizador += 10;
			if (temporizador > 1000) {
				temporizador = 0;
				tiempo++;
				labelTiempoTranscurrido.setText("Tiempo transcurrido: " + tiempo);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep((long) 10);
			temporizador += 10;
			if (temporizador > 1000) {
				temporizador = 0;
				tiempo++;
				labelTiempoTranscurrido.setText("Tiempo transcurrido: " + tiempo);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
