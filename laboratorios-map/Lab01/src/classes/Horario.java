package classes;

public class Horario {
	
	private HoraAula horaAula;
	private DiaAula diaAula;
	
	
	public Horario(String horario, String dia) {
		super();
		setHorario(horario);
		setDia(dia);
	}

	

	public HoraAula getHoraAula() {
		return horaAula;
	}



	public void setHoraAula(HoraAula horaAula) {
		this.horaAula = horaAula;
	}



	public DiaAula getDiaAula() {
		return diaAula;
	}



	public void setDiaAula(DiaAula diaAula) {
		this.diaAula = diaAula;
	}



	private void setDia(String dia) {
		switch(dia) {
			case "segunda":{
				this.diaAula = DiaAula.SEGUNDA;
				break;
			}case "terca":{
				this.diaAula = DiaAula.TERCA;
				break;
			}case "quarta":{
				this.diaAula = DiaAula.QUARTA;
				break;
			}case "quinta":{
				this.diaAula = DiaAula.QUINTA;
				break;
			}default:{
				this.diaAula = DiaAula.SEXTA;
			}
		}
		
	}
	private void setHorario(String horario) {
		switch(horario) {
			case "primeiro":{
				this.horaAula = HoraAula.PRIMEIRO_HORARIO;
				break;
			}case "segundo":{
				this.horaAula = HoraAula.SEGUNDO_HORARIO;
				break;
			}default:{
				this.horaAula = HoraAula.TERCEIRO_HORARIO;
			}
		}
	}
	
	public String getHorario() {
		return "Dia: " + this.diaAula
				+ "\tHorario: " + this.horaAula;
	}
	
	public boolean equals(Horario h) {
		if(h.getDiaAula().equals(this.diaAula)
				&& h.getHoraAula().equals(this.horaAula))
			return true;
		return false;
	}
	
}
