package br.com.douglasfernandes.Model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe responsável por servir de parâmetro para conversão de dados em json
 * @author Compliance Software (by Douglas Fernandes)
 *
 */
@XmlRootElement
public class Angle {
	private int angle;

	/**
	 * Construtor padrão para serialização.
	 */
	public Angle(){
		this.angle = 0;
	}
	
	/**
	 * Construtor de uso prático (como em atribuições estáticas).
	 * @param angle
	 */
	public Angle (int angle){
		this.angle = angle;
	}
	
	/**
	 * Pega o valor de angulo em inteiro que pode variar de 0 a 180.
	 * @return
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Define um novo valor de angulo entre 0 e 180
	 * @param angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	private static String ultima_solicitacao = "";
	private static Angle ultima_resposta = new Angle(0);
	
	/**
	 * Pega o menor angulo de diferença entre os ponteiros de minutos e horas de um relógio segundo o horário passado como String no formato HH:mm por parametro.
	 * @param hour
	 * @return
	 */
	public static Angle getAngleFromString(String hour){
		try{
			if(hour.equals(ultima_solicitacao))
				return ultima_resposta;
			else{
				if((hour != null) && !hour.equals(null) && !hour.equals("")){
					int horas = 0;
					int minutos = 0;
					
					if(hour.contains(":")){
						String[] horario = hour.split(":");
						
						horas = Integer.parseInt(horario[0]);
						minutos = Integer.parseInt(horario[1]);
						
						if((horas < 0 || horas > 12) && (minutos < 0 || minutos > 59)){
							horas = 0;
							minutos = 0;
						}
					}
					else{
						horas = Integer.parseInt(hour);
						if(!(horas >= 0 && horas <= 12)){
							horas = 0;
							minutos = 0;
						}
					}
					
					int hg = horas * 30;//horas em graus
					int mg = minutos * 6;//minutos em graus
					int diferenca = 0;
					
					if(hg > mg)
						diferenca = hg - mg;
					else
						diferenca = mg - hg;
					
					if(diferenca > 180)
						diferenca = 360 - diferenca;
					
					Angle angle = new Angle(diferenca);
					
					ultima_solicitacao = hour;
					ultima_resposta = angle;
					
					return angle;
				}
				else
					return new Angle(0);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return new Angle(0);
		}
	}
	
}
