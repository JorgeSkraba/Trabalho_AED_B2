public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(50);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(57);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(40);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(20);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(30);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(58);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(90);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(60);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(25);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(35);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(34);

        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");
        arvoreBinaria.remover(59);
        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");
        arvoreBinaria.remover(20);
        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");
        arvoreBinaria.remover(58);
        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");
        arvoreBinaria.remover(50);
        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");
        arvoreBinaria.remover(40);
        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");
        arvoreBinaria.visualizarEmOrdem();
        System.out.println("-------------");

    }
}