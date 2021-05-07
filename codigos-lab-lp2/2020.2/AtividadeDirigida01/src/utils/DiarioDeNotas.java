package utils;

public class DiarioDeNotas {
	private byte nota;
    private boolean aprovado;
    private String professor;
    private String course;
    
    public DiarioDeNotas(byte nota){
        this.nota = nota;
    }

    public DiarioDeNotas(){
    }
    
    public DiarioDeNotas(String course, String professor) {
    	this.course = course;
    	this.professor = professor;
    }
    
    public void showMessage() {
    	System.out.println("Seja bem vindo ao curso de: " + this.course);
    	System.out.println("Este é um curso apresentado por: " + this.professor);
    }
    
    public void setNota(byte nota){
        this.nota = nota;
    }

    public byte getNota(){
        return this.nota;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    public void setProfessor(String professor) {
    	this.professor = professor;
    }
    
    public String getProfessor() {
    	return this.professor;
    }
    
    public void setCourse(String course) {
    	this.course = course;
    }
    
    public String getCourse() {
    	return this.course;
    }
}
