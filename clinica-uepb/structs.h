#ifndef STRUCTS_H_INCLUDED
#define STRUCTS_H_INCLUDED

typedef struct{
	char login[15],senha[6];
}Login;

typedef struct{
    int unsigned codigoPaciente;
    char nomePaciente[30],enderecoPaciente[100],cpfPaciente[15],nascimentoPaciente[11];
}Paciente;

typedef struct{
    int unsigned codigoSupervisor;
    char nomeSupervisor[30],cursoSupervisor[20];
}Supervisor;

typedef struct{
    int unsigned codigoAgendamento,codigoPacienteAgen,op1,op2,op3,op4,op5,op6;
    char areaAgendamento[20],dataConsulta[11],nomePacienteAgendado[30];
}Agendamento;

typedef struct{
    int unsigned matriculaAluno;
    char nomeAluno[30],cpfAluno[15],cursoAluno[20];
}Aluno;

typedef struct{
    int unsigned codigoAtendimento,codigiAgen,codigoSuper,matriculaAl;
    char dataAgendado[12],nomeAlu[30],nomePaci[30],dataAtendi[11],areaAten[20],nomeSuper[30];
}Atendimento;

#endif // STRUCTS_H_INCLUDED
