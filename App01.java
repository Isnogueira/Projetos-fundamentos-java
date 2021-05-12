public class App01 {
    
        private static String[] parametros; 

        private static String nomeAluno;
        private static float mensalidade;
        private static boolean bolsista;
        private static String nomeEscola;        
        private static String emailEscola;
        private static int anoCriacao;
        private static double prova1;
        private static double prova2;       
        private static double trabalho1;
        private static double trabalho2;       

        public static boolean validar(int qtd){
            return qtd == 10;
        }

        private static void construtor() {
            nomeAluno = parametros[0];
            mensalidade = Float.valueOf(parametros[1]);
            bolsista = "S".equalsIgnoreCase(parametros[2]) ? true : false;
            nomeEscola = parametros[3];
            emailEscola = parametros[4];
            anoCriacao = Integer.valueOf(parametros[5]);
            prova1 = validarProva(Double.valueOf(parametros[6]));
            prova2 = validarProva(Double.valueOf(parametros[7]));
            trabalho1 = validarTrabalho(Double.valueOf(parametros[8]));
            trabalho2 = validarTrabalho(Double.valueOf(parametros[9]));
        }

        private static String getTipo(){
            return bolsista ? "bolsista" : "pagante";
        }

        private static float getMensalidade(){
            return bolsista ? mensalidade/2 : mensalidade; 
        }

        private static double validarProva(double prv){
            if (prv < 0){
              return 0;
            }
            else if(prv > 7 ){
                return 7;
            }
            else{
                return prv;
            }
        }
          
        private static double validarTrabalho(double trab){
             if (trab < 0){
                 return 0;
             }
             else if(trab > 3){
                 return 3;
             }
             else{
                 return trab;
             }
        }

         private static double calcularMedia(){
            return ((prova1 + trabalho1) * 0.6) + ((prova2 + trabalho2) * 0.4);

        }

        private static String getSituacao(double media){
          return media >= 8 ? "aprovado" : "reprovado";

        }

        private static void exibir() {
            double media = calcularMedia();
            System.out.printf(nomeAluno + " - aluno(a) " + getTipo() + " - paga R$" + getMensalidade() + " de mensalidade em " + nomeEscola + "(" + emailEscola + ")" + " - fundado(a) em " + anoCriacao + " - e foi " + getSituacao(media) + " com media " +  media + ".");

        }

         public static void main(String []args) {

            if (validar(args.length)){

                parametros = args;

                construtor();

                exibir();
            }
            else{
                System.out.println("Problemas na quantidade de parametros.");
            }

         }
}
