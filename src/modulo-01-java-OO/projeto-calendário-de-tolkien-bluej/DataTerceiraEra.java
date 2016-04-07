/**
1.1 Crie um objeto DataTerceiraEra com 3 campos: dia, mês e ano. Todos campos são inteiros. Faça os métodos getters apenas.
1.2 Adicione um construtor à classe DataTerceiraEra com os 3 campos existentes no objeto.
1.3 Adicione um método ehBissexto() no objeto DataTerceiraEra que retorna true caso o ano da data seja bissexto, false caso contrário.
Obs: Necessita de uma conversão de números do sistema decimal (08, 09) para o 
sistema Octal (01, 02, 03, 04, 05, 06, 07) para que esses valores possam ser utilizados.
*/
public class DataTerceiraEra {
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }
    
    public int getAno() {
        return ano;
    }
    
    public boolean ehBissexto() {
        return ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0);
    }
}
