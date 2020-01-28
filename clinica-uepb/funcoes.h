#ifndef FUNCOES_H_INCLUDED
#define FUNCOES_H_INCLUDED

/*Apenas declarações das funções*/

/*Menu*/
void cabecalho();
int opcaoMenu();
void opcoes(int op)
int gerandoCodigo()
/*Paciente*/
int menuPaciente();
void opcaoPaciente(int op);
void cadastroPaciente();
void listarPaciente();
void editarPaciente();
void removerPaciente();
/*Aluno*/
int menuAluno();
void opcaoAluno(int op);
void cadastroAluno();
void listarAluno();
void editarAluno();
void removerAluno();
/*Supervisor*/
int menuSupervisor();
void opcaoSupervisor(int op);
void cadastroSupervisor();
void listarSupervisor();
void editarSupervisor();
void removerSupervisor();
/*Agendamento*/
int menuAgendamento();
void opcaoAgendamento(int op);
void fazerAgendamento();
void cancelarAgendamento();
void listarAgendamento();
/*Atendimento*/
int menuAtendimento();
void opcaoAtendimento(int op);
void criarAtendimento();
void cancelarAtendimento();
int menuListarAtendimento();
void opcaoListarAtendimento(int op);
void listarTodosAtendimentos();
void listarAreaAtendimento();
void listarAlunoAtendimento();
void listarPacienteAtendimento();


#endif /* FUNCOES_H_INCLUDED */
