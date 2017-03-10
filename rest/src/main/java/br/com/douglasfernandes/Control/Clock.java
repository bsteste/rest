package br.com.douglasfernandes.Control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.douglasfernandes.Model.Angle;

/**
 * Classe que serve de escopo para solicitação do REST
 * @author Compliance Software (by Douglas Fernandes)
 *
 */
@Path("/clock")
public class Clock {

	@GET
	@Produces("application/json")
	@Path("{horas}")
	public Angle getAngle(@PathParam("horas") String horas){
		Angle angle = Angle.getAngleFromString(horas);
		return angle;
	}
	
}
