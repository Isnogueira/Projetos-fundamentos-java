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
        private static double trab1;
        private static double trab2;       

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
            prova1 = Double.valueOf(parametros[6]);
            prova2 = Double.valueOf(parametros[7]);
            trab1 = Double.valueOf(parametros[8]);
            trab2 = Double.valueOf(parametros[9]);
        }

        private static String getTipo(){
            return bolsista == true ? "bolsista" : "pagante";
        }

        private static float getMensalidade(){
            if(bolsista == true){
                return mensalidade /= 2;
            }
            else{
                return mensalidade;
            }
        }

        private static double validarProva1(){
            if (prova1 < 0){
              return 0;
            }
            else if(prova1 > 7 ){
                return 7;
            }
            else{
                return prova1;
            }
        }
        
        private static double validarProva2(){
             if (prova2 < 0){
                 return 0;
            }
             else if(prova2 > 7){
                 return 7;
             }
             else {
                return prova2;
             }
        }
                         
        private static double validarTrab1(){
             if (trab1 < 0){
                 return 0;
             }
             else if(trab1 > 3){
                 return 3;
             }
             else{
                 return trab1;
             }
        }
                
        private static double validarTrab2(){
             if (trab2 < 0){
                 return 0;
             }
             else if(trab1 > 3){
                 return 3;
             }
             else{
                 return trab2;
             }
        }
        
         private static double calcularMedia(){
            double prova1 = validarProva1();
            double prova2 = validarProva2();
            double trab1 = validarTrab1();
            double trab2 = validarTrab2();
            
            double nota1 = (prova1 + trab1) * 0.6;
            double nota2 = (prova2 + trab2) * 0.4;
            return nota1 + nota2;

        }

        private static String getSituacao(){
          double media = calcularMedia();
          return media >= 8 ? "aprovado" : "reprovado";

        }

        private static void exibir() {
            System.out.println( nomeAluno + " - aluno(a) " + getTipo() + " - paga R$" + getMensalidade() + " de mensalidade em " + nomeEscola + "(" + emailEscola + ")" + " - fundado(a) em " + anoCriacao + " - e foi " + getSituacao() + " com media "  + calcularMedia() + ".");

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
